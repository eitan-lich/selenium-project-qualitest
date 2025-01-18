package tests;

import actions.Action;
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
        driver = GenerateDriver.initDriver(browserType,url);
        actions = new Action(driver);
    }

    @Test
    public void validateLoginWithIncorrectEmailAndPassword() {

    }

    @Test
    public void validateTestCasesPage() {

    }

    @Test
    public void validateRegisterFromCheckoutPage() {

    }

    @Test
    public void validateAddingReviewToProduct() {

    }

    @Test
    public void validateRegisterNewUser() {
       Assert.assertTrue(actions.registerNewUser(), "Registration test failed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
