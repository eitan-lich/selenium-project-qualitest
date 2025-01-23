package tests;

import actions.Action;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.GenerateDriver;
import utils.JsonUtils;

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

    @BeforeMethod
    public void navigateToDefaultPage() {
        GenerateDriver.navigateToDefaultPage(driver);
    }

    @Description("Verify home page loaded successfully")
    @Test(groups = {"Regression", "PagesValidation"})
    public void verifyHomePageLoaded() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");

    }

    @Description("Verify test cases page loads successfully")
    @Test(groups = {"Regression", "PagesValidation"})
    public void verifyTestCasesPage() {
        Assert.assertTrue(actions.goToTestCasesPage(), "Test cases page did not load successfully");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
