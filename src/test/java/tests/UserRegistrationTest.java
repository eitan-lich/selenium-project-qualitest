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

public class UserRegistrationTest {
    WebDriver driver;
    Action actions;

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

    @Description("Verify home page loaded successfully")
    @Test(groups = {"Regression", "RegisterUser"})
    public void verifyHomePageLoaded() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");

    }

    @Description("Register a new user")
    @Test(groups = {"Regression", "RegisterUser"})
    public void testUserRegistration() {
        Assert.assertTrue(actions.register(), "Did not manage to register successfully");
    }

    @Description("Verifies the user appears as logged after registering")
    @Test(groups = {"Regression", "RegisterUser"})
    public void testUserAppearsLoggedIn() {
        Assert.assertNotNull(actions.getLoggedInUser(), "User doesn't not display as logged in");
    }

    @Description("Deletes the users account")
    @Test(groups = {"Regression", "RegisterUser"})
    public void testAccountDeletion() {
        Assert.assertTrue(actions.deleteAccount(), "Did not manage to delete account");
    }

    @AfterMethod()
    public void captureScreenshot() throws IOException {
        String testName = this.getClass().getName();
        File screenshot = ScreenshotUtils.captureScreenshot(driver, testName);
        Allure.addAttachment("Screenshot of test: " + testName, FileUtils.openInputStream(screenshot));
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}