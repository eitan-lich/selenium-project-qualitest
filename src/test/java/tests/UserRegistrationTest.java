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

    /**
     * Verifies if the home page is loaded successfully.
     */
    @Description("Verify home page loaded successfully")
    @Test(groups = {"Regression", "Register"}, priority = 1)
    public void verifyHomePageLoaded() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");

    }

    /**
     * Registers a new user and ensures the registration is successful.
     */
    @Description("Register a new user")
    @Test(groups = {"Regression", "Register"}, priority = 2)
    public void testUserRegistration() {
        Assert.assertTrue(actions.register(), "Did not manage to register successfully");
    }

    /**
     * Verifies that the user appears as logged in after successful registration.
     */
    @Description("Verify the user appears as logged after registering")
    @Test(groups = {"Regression", "Register"}, priority = 3)
    public void testUserAppearsLoggedIn() {
        Assert.assertNotNull(actions.getLoggedInUser(), "User doesn't not display as logged in");
    }

    /**
     * Deletes the user's account and verifies successful deletion.
     */
    @Description("Deletes the users account")
    @Test(groups = {"Regression", "Register"}, priority = 4)
    public void testAccountDeletion() {
        Assert.assertTrue(actions.deleteAccount(), "Did not manage to delete account");
    }

    @AfterMethod(alwaysRun = true)
    public void captureScreenshot() throws IOException {
        String testName = this.getClass().getName();
        File screenshot = ScreenshotUtils.captureScreenshot(driver, testName);
        Allure.addAttachment("Screenshot of test: " + testName, FileUtils.openInputStream(screenshot));
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}