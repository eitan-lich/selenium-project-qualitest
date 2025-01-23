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

    @BeforeMethod
    public void navigateToDefaultPage() {
        GenerateDriver.navigateToDefaultPage(driver);
    }

    @Description("Tests login with valid credentials")
    @Test(groups = {"Regression", "LoginUser"})
    public void testLoginWithIncorrectEmailAndPassword() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        Assert.assertTrue(actions.loginWithWrongCredentials(), "Incorrect login did not fail as expected");
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
