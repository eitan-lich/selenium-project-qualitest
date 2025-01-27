package tests;

import actions.Action;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.GenerateDriver;
import utils.JsonUtils;
import utils.ScreenshotUtils;

import java.io.File;
import java.io.IOException;

public class UserRegistrationFromCheckoutTest {
    WebDriver driver;
    Action actions;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        String browserType = JsonUtils.readJsonFromFile("browserType");
        String url = JsonUtils.readJsonFromFile("url");
        driver = GenerateDriver.initDriver(browserType, url);
        actions = new Action(driver);
    }

    @Description("Verify the home page loaded successfully")
    @Test(groups = {"Regression", "RegisterUser"}, priority = 1)
    public void verifyHomePageLoaded() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
    }

    @Description("Register from the cart page")
    @Test(groups = {"Regression", "RegisterUser"}, priority = 2)
    public void testRegisterFromCartPage() {
        actions.addItemAndCheckout();
        Assert.assertTrue(actions.registerFromCartPage(), "Did not manage to register successfully");
    }

    @Description("Verify the user appears as logged in")
    @Test(groups = {"Regression", "RegisterUser"}, priority = 3)
    public void testRegisterFromCheckoutPage() {
        Assert.assertNotNull(actions.getLoggedInUser(), "User doesn't not display as logged in");
        actions.deleteAccount();
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
