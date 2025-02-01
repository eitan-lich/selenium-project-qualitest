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

public class LoginWithInvalidCredentialsTest {
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
     * Tests whether the home page loads successfully.
     * Validates the expected condition using assertions.
     */
    @Description("Verify the home page loaded successfully")
    @Test(groups = {"Regression", "Login"}, priority = 1)
    public void verifyHomePageLoaded() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
    }

    /**
     * Attempts to log in with invalid credentials and verifies
     * that the login fails as expected. Ensures the application
     * handles incorrect login attempts properly.
     */
    @Description("Test logging in with invalid credentials")
    @Test(groups = {"Regression", "Login"}, priority = 2)
    public void testLoginWithIncorrectEmailAndPassword() {
        Assert.assertTrue(actions.loginWithWrongCredentials(), "Incorrect login did not fail as expected");
    }

    @AfterMethod(alwaysRun = true)
    public void captureScreenshot() throws IOException {
        String testName = this.getClass().getName();
        File screenshot = ScreenshotUtils.captureScreenshot(driver, testName);
        Allure.addAttachment("Test screenshot", FileUtils.openInputStream(screenshot));
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
