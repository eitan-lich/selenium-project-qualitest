package actions;


import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.*;

public class Action {

    private static final Logger logger = LogManager.getLogger(Action.class);
    CartPage cartPage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    SignupLoginPage signupLoginPage;
    PaymentPage paymentPage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    SignupFormPage signupFormPage;
    TestCasesPage testCasesPage;
    AccountCreatedPage accountCreatedPage;
    AccountDeletedPage accountDeletedPage;

    public Action(WebDriver driver) {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        paymentPage = new PaymentPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        signupFormPage = new SignupFormPage(driver);
        testCasesPage = new TestCasesPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
    }

    public boolean login() {
        return true;
    }

    public boolean registerNewUser() {
        logger.info("Verifying homepage loaded successfully");
        homePage.verifyPageLoaded();
        logger.info("Page loaded successfully");
        logger.info("Clicking Signup / Login button");
        homePage.clickSignupLoginButton();
        signupLoginPage.verifyPageLoaded();
        logger.info("Verifying Signup page loaded successfully");
        signupLoginPage.filloutRegister();
        logger.info("Filling out initial signup form");
        signupFormPage.verifyPageLoaded();
        logger.info("Verifying Signup detailed page loaded successfully");
        signupFormPage.filloutForm();
        logger.info("Filling out detailed register form");
        accountCreatedPage.validateSuccessMessage();
        accountCreatedPage.clickContinueButton();
        homePage.validateLoggedInUserExists();
        logger.info("Verifying new registered user appears as logged in");
        homePage.clickDeleteAccount();
        accountDeletedPage.verifySuccessMessage();
        logger.info("Verifying account was deleted successfully");
        accountDeletedPage.clickContinueButton();
        return true;
    }

    public boolean addItemToCart() {
        return true;
    }

    public boolean purchaseItem() {
        return true;
    }

    public boolean addReviewToProduct() {
        return true;
    }
}
