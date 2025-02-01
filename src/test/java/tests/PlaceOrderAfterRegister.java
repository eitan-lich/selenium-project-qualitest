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

public class PlaceOrderAfterRegister {
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
     * Test to verify that the home page loads successfully.
     * Uses the Action class to validate whether the page is correctly displayed.
     */
    @Description("Verify the home page loaded successfully")
    @Test(groups = {"Regression", "Register"}, priority = 1)
    public void verifyHomePageLoaded() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
    }


    /**
     * Test to validate the user registration process from the cart page during checkout.
     * Adds an item to the cart, proceeds to checkout, and attempts to register a new account.
     */
    @Description("Register from the cart page")
    @Test(groups = {"Regression", "Register"}, priority = 2)
    public void testRegisterFromCartPage() {
        Assert.assertTrue(actions.addItemAndCheckout(), "Failed to add item to cart or visit cart page");
        Assert.assertTrue(actions.registerFromCartPage(), "Did not manage to register successfully");
    }

    /**
     * Test to verify that the user appears as logged in after successful registration.
     * Checks the Action class for the presence of a logged-in user.
     */
    @Description("Verify the user appears as logged in")
    @Test(groups = {"Regression", "Register"}, priority = 3)
    public void testUserAppearsLoggedIn() {
        Assert.assertNotNull(actions.getLoggedInUser(), "User doesn't not display as logged in");
    }

    /**
     * Verifies the ability to place an order.
     * Ensures that the checkout and order placement processes are functioning correctly.
     */
    @Description("Places an order")
    @Test(groups = {"Regression", "Register"}, priority = 4)
    public void testPlaceOrder() {
        Assert.assertTrue(actions.placeOrder(), "Failed to place order");
    }

    /**
     * Deletes the user's account and verifies successful deletion.
     */
    @Description("Deletes the users account")
    @Test(groups = {"Regression", "Register"}, priority = 5)
    public void testAccountDeletion() {
        Assert.assertTrue(actions.deleteAccount(), "Did not manage to delete account");
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
