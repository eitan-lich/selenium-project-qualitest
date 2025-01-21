package tests;

import actions.Action;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.GenerateDriver;
import utils.JsonUtils;

public class TestSuite {

    WebDriver driver;
    Action actions;

    @BeforeClass
    public void setUp() {
        String browserType = JsonUtils.readJsonFromFile("browserType");
        String url = JsonUtils.readJsonFromFile("url");
        driver = GenerateDriver.initDriver(browserType, url);
        actions = new Action(driver);
    }

    @Test
    public void testUserCanRegister() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        Assert.assertTrue(actions.register(), "Did not manage to register successfully");
        Assert.assertNotNull(actions.getLoggedInUser(), "User doesn't not display as logged in");
        Assert.assertTrue(actions.deleteAccount(), "Did not manage to delete account");
    }

    @Test
    public void validateLoginWithIncorrectEmailAndPassword() {
        actions.login("incorrectemail@incorrect.com", "incorrectPassword");
        Assert.assertTrue(actions.verifyLoginErrorMessage(), "Error message did not appear");
    }

    @Test
    public void validateTestCasesPage() {
        Assert.assertTrue(actions.verifyTestCasesPageLoaded(), "Test cases page did not load successfully");
    }

    @Test
    public void validateRegisterFromCheckoutPage() throws InterruptedException {
        actions.addItemAndCheckout();
        Assert.assertTrue(actions.verifyCheckoutPageLoaded(), "Check page did not load successfully");
        actions.clickProccedToCheckoutButton();
        actions.clickRegisterLoginButton();
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        Assert.assertTrue(actions.register(), "Did not manage to register successfully");
        Assert.assertNotNull(actions.getLoggedInUser(), "User doesn't not display as logged in");
    }

    @Test
    public void validateAddingReviewToProduct() {
        actions.addReviewToProduct();
        Assert.assertTrue(actions.verifyReview(), "Error to add review");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
