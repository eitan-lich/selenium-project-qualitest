package tests;

import actions.Action;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExcelUtils;
import utils.GenerateDriver;
import utils.JsonUtils;
import utils.ScreenshotUtils;

import java.io.File;
import java.io.IOException;

public class AddReviewTest {

    WebDriver driver;
    Action actions;


    @DataProvider(name = "excelData")
    public Object[][] getData() throws IOException {
        String filePath = JsonUtils.readJsonFromFile("excelFilePath");
        String sheetName = JsonUtils.readJsonFromFile("excelSheet");
        return ExcelUtils.getExcelData(filePath, sheetName);
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        String browserType = JsonUtils.readJsonFromFile("browserType");
        String url = JsonUtils.readJsonFromFile("url");
        driver = GenerateDriver.initDriver(browserType, url);
        actions = new Action(driver);
    }

    @BeforeMethod
    public void navigateToDefaultPage() {
        GenerateDriver.navigateToDefaultPage(driver);
    }

    @Description("Verify the Products page load successfully")
    @Test(groups = {"Regression, ProductTests"}, priority = 1)
    public void testProductsPage() {
        Assert.assertTrue(actions.goToProductsPage(), "All products page did not load successfully");
    }

    @Description("Add a review to a product")
    @Test(groups = {"Regression", "ProductTests"}, dataProvider = "excelData", priority = 2)
    public void testAddingReviewToProduct(String name, String email, String review) {
        Assert.assertTrue(actions.addReviewToProduct(name, email, review), "Error to add review");
    }

    @AfterMethod()
    public void captureScreenshot() throws IOException {
        String testName = this.getClass().getName();
        File screenshot = ScreenshotUtils.captureScreenshot(driver, testName);
        Allure.addAttachment("Test screenshot", FileUtils.openInputStream(screenshot));
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

