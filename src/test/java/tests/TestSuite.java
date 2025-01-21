package tests;

import actions.Action;
import org.openqa.selenium.WebDriver;
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
    public void testLoginWithIncorrectEmailAndPassword() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        Assert.assertTrue(actions.loginWithWrongCredentials(), "Incorrect login did not fail as expected");
    }

    @Test
    public void verifyTestCasesPage() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        Assert.assertTrue(actions.goToTestCasesPage(), "Test cases page did not load successfully");
    }

    @Test
    public void testRegisterFromCheckoutPage() {
        Assert.assertTrue(actions.verifyHomePageLoaded(), "Home page did not load successfully");
        actions.addItemAndCheckout();
        Assert.assertTrue(actions.registerFromCartPage(), "Did not manage to register successfully");
        Assert.assertNotNull(actions.getLoggedInUser(), "User doesn't not display as logged in");
    }

    @Test
    public void testAddingReviewToProduct() {
        Assert.assertTrue(actions.goToProductsPage(), "All products page did not load successfully");
        Assert.assertTrue(actions.addReviewToProduct(), "Error to add review");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
