package tests;

import actions.Action;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExcelUtils;
import utils.GenerateDriver;
import utils.JsonUtils;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import java.io.IOException;

public class TestSuite {

    WebDriver driver;
    Action actions;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.out.println("HIIII");
        String browserType = JsonUtils.readJsonFromFile("browserType");
        String url = JsonUtils.readJsonFromFile("url");
        driver = GenerateDriver.initDriver(browserType, url);
        actions = new Action(driver);
    }

    @BeforeMethod
    public void navigateToDefaultPage() {
        GenerateDriver.navigateToDefaultPage(driver);
    }

    @DataProvider(name = "excelData")
    public Object[][] getData() throws IOException {
        String filePath = JsonUtils.readJsonFromFile("excelFilePath");
        String sheetName = JsonUtils.readJsonFromFile("excelSheet");
        return ExcelUtils.getExcelData(filePath, sheetName);
    }

    @Test (groups = {"Regression", "RegisterUser"})
    public void testUserCanRegister() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        Assert.assertTrue(actions.register(), "Did not manage to register successfully");
        Assert.assertNotNull(actions.getLoggedInUser(), "User doesn't not display as logged in");
        Assert.assertTrue(actions.deleteAccount(), "Did not manage to delete account");
    }

    @Test (groups = {"Regression", "LoginUser"})
    public void testLoginWithIncorrectEmailAndPassword() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        Assert.assertTrue(actions.loginWithWrongCredentials(), "Incorrect login did not fail as expected");
    }

    @Test (groups = {"Regression", "PagesValidation"})
    public void verifyTestCasesPage() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        Assert.assertTrue(actions.goToTestCasesPage(), "Test cases page did not load successfully");
    }

    @Test (groups = {"Regression", "RegisterUser"})
    public void testRegisterFromCheckoutPage() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        actions.addItemAndCheckout();
        Assert.assertTrue(actions.registerFromCartPage(), "Did not manage to register successfully");
        Assert.assertNotNull(actions.getLoggedInUser(), "User doesn't not display as logged in");
        actions.deleteAccount();
    }

    @Test (groups = {"Regression", "CoreFunctionality"}, dataProvider = "excelData")
    public void testAddingReviewToProduct(String name, String email, String review) {
        Assert.assertTrue(actions.goToProductsPage(), "All products page did not load successfully");
        Assert.assertTrue(actions.addReviewToProduct(name, email, review), "Error to add review");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
