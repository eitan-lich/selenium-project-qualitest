package actions;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.*;

public class Action {

    private static final Logger logger = LogManager.getLogger(Action.class);
    HomePage homePage;
    LoginPage loginPage;
    SignupFormPage signupFormPage;
    AccountCreatedPage accountCreatedPage;
    AccountDeletedPage accountDeletedPage;
    CartPage cartPage;
    ProductDetailsPage productDetailsPage;
    ProductsPage productsPage;
    TestCasesPage testCasesPage;

    public Action(WebDriver driver) {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signupFormPage = new SignupFormPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
        cartPage = new CartPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productsPage = new ProductsPage(driver);
        testCasesPage = new TestCasesPage(driver);
    }

    public boolean register() {
        logger.info("Clicking Signup / Login button");
        homePage.clickSignupLoginButton();
        logger.info("Verifying login page loaded");
        loginPage.verifyPageLoaded();
        logger.info("Filling out initial signup form");
        loginPage.typeNewUsername();
        loginPage.typeNewUserEmailAddress();
        loginPage.clickNewUserSignUpButton();
        logger.info("Verifying registration form page loaded");
        signupFormPage.verifyPageLoaded();
        logger.info("Filling out registration form");
        signupFormPage.clickTitleButton();
        signupFormPage.typePassword("Test");
        signupFormPage.selectBirthDay("19");
        signupFormPage.selectBirthMonth("May");
        signupFormPage.selectBirthYear("2000");
        signupFormPage.clickSignupNewsletterCheckbox();
        signupFormPage.clickSpecialOffersCheckbox();
        signupFormPage.typeFirstName("Test");
        signupFormPage.typeLastNameField("Test");
        signupFormPage.typeAddress1("Tel-Aviv");
        signupFormPage.typeAddress2("Haifa");
        signupFormPage.selectCountry("Israel");
        signupFormPage.typeState("Israel");
        signupFormPage.typeCity("Tel-Aviv");
        signupFormPage.typeZipCode("000000");
        signupFormPage.typeMobileNumber("000000");
        signupFormPage.clickCreateAccountButton();
        boolean successfulRegister = accountCreatedPage.validateSuccessMessage();
        accountCreatedPage.clickContinueButton();
        return successfulRegister;
    }

    public boolean deleteAccount() {
        boolean successMessage = false;

        logger.info("Deleting account");
        homePage.clickDeleteAccount();
        logger.info("Verifying account was deleted successfully");
        successMessage = accountDeletedPage.verifySuccessMessage();
        accountDeletedPage.clickContinueButton();
        return successMessage;
    }

    public String getLoggedInUser() {
        logger.info("Verifying new registered user appears as logged in");
        return homePage.getLoggedInUser();
    }

    public boolean verifyHomePageLoaded() {
        logger.info("Verifying homepage loaded successfully");
        return homePage.verifyPageLoaded();
    }

    public boolean loginWithWrongCredentials() {
        logger.info("Clicking Signup / Login button");
        homePage.clickSignupLoginButton();
        logger.info("Verifying login page loaded");
        boolean pageLoaded = loginPage.verifyPageLoaded();
        if (!pageLoaded) {
            return false;
        }
        logger.info("Filling out login info");
        loginPage.typeExistingUserEmail("incorrectemail@incorrect.com");
        loginPage.typeExistingUserPassword("incorrectPassword");
        return loginPage.verifyLoginErrorMessage();
    }

    public boolean goToTestCasesPage() {
        logger.info("Clicking Test Cases button");
        homePage.clickTestCasesButton();
        logger.info("Verifying test cases page loaded");
        return testCasesPage.verifyPageLoaded();
    }

    public void addItemAndCheckout() {
        logger.info("Add product to cart");
        homePage.clickAddCartButton();
        if (!homePage.verifyCheckoutMessageLoaded()) {
            return;
        }
        homePage.clickViewCartButton();
        if (!cartPage.verifyCheckoutPageLoaded()) {
            return;
        }
        cartPage.clickProceedToCheckoutButton();
    }

    public boolean registerFromCartPage() {
        cartPage.clickRegisterLoginButton();
        return register();
    }

    public boolean addReviewToProduct(String name, String email, String review) {
        logger.info("Clicking product details");
        productsPage.clickViewProductButton();
        logger.info("Adding review to product");
        productDetailsPage.addReview(name, email, review);
        return productDetailsPage.verifyReviewAdded();
    }

    public boolean goToProductsPage() {
        logger.info("clicking on Products button");
        homePage.clickProductsButton();
        return productsPage.verifyPageLoaded();
    }
}