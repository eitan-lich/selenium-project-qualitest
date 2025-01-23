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

    @BeforeMethod
    public void navigateToDefaultPage() {
        GenerateDriver.navigateToDefaultPage(driver);
    }

    @Description("Tests login with valid credentials")
    @Test(groups = {"Regression", "RegisterUser"})
    public void testRegisterFromCheckoutPage() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        actions.addItemAndCheckout();
        Assert.assertTrue(actions.registerFromCartPage(), "Did not manage to register successfully");
        Assert.assertNotNull(actions.getLoggedInUser(), "User doesn't not display as logged in");
        actions.deleteAccount();
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
