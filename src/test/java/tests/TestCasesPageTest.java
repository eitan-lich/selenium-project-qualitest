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

public class TestCasesPageTest {

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
     * Verifies that the home page of the application loads successfully by checking
     * if the required elements are present and visible on the page.
     */
    @Description("Verify the home page loaded successfully")
    @Test(groups = {"Regression", "PagesValidation"}, priority = 1)
    public void verifyHomePageLoaded() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");

    }

    /**
     * Navigates to the test cases page and verifies that it loads successfully.
     * Confirms that the necessary elements of the page are displayed as expected.
     */
    @Description("Verify the test cases page loaded successfully")
    @Test(groups = {"Regression", "PagesValidation"}, priority = 2)
    public void verifyTestCasesPage() {
        Assert.assertTrue(actions.goToTestCasesPage(), "Test cases page did not load successfully");
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