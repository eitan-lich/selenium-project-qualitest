package tests;

import actions.Action;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExcelUtils;
import utils.GenerateDriver;
import utils.JsonUtils;

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

    @Description("Tests login with valid credentials")
    @Test(groups = {"Regression", "ProductTests"}, dataProvider = "excelData")
    public void testAddingReviewToProduct(String name, String email, String review) {
        Assert.assertTrue(actions.goToProductsPage(), "All products page did not load successfully");
        Assert.assertTrue(actions.addReviewToProduct(name, email, review), "Error to add review");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
