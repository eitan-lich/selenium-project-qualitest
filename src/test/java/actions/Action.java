package actions;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.*;

public class Action {

    private static final Logger logger = LogManager.getLogger(Action.class);
    HomePage homePage;
    SignupLoginPage signupLoginPage;
    SignupFormPage signupFormPage;
    AccountCreatedPage accountCreatedPage;
    AccountDeletedPage accountDeletedPage;
    CheckoutPage checkoutPage;
    ProductDetailsPage productDetailsPage;
    TestCasesPage testCasesPage;

    public Action(WebDriver driver) {
        homePage = new HomePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        signupFormPage = new SignupFormPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        testCasesPage = new TestCasesPage(driver);
    }

    public boolean register() {
        logger.info("Clicking Signup / Login button");
        homePage.clickSignupLoginButton();
        signupLoginPage.verifyPageLoaded();
        logger.info("Verifying Signup page loaded successfully");
        logger.info("Filling out initial signup form");
        signupLoginPage.filloutRegister();
        logger.info("Verifying Signup detailed page loaded successfully");
        signupFormPage.verifyPageLoaded();
        logger.info("Filling out detailed register form");
        signupFormPage.filloutForm();
        accountCreatedPage.validateSuccessMessage();
        accountCreatedPage.clickContinueButton();
        return true;
    }

    public boolean deleteAccount() {
        boolean successMessage = false;

        logger.info("Deleting account");
        homePage.clickDeleteAccount();
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

    public void login(String email, String password) {
        homePage.clickSignupLoginButton();
        signupLoginPage.filloutLogin(email, password);
    }

    public boolean verifyLoginErrorMessage() {
        return signupLoginPage.verifyLoginErrorMessage();
    }

    public boolean verifyTestCasesPageLoaded() {
        homePage.clickTestCasesButton();
        return testCasesPage.verifyTestCasesMessage();
    }

    public void addItemAndCheckout() {
        homePage.clickAddCartButton();
        if (!homePage.verifyCheckoutMessageLoaded()) {
            return;
        }
        homePage.clickViewCartButton();
    }

    public boolean verifyCheckoutPageLoaded() {
        return checkoutPage.verifyCheckoutPageLoaded();
    }

    public void clickProccedToCheckoutButton() throws InterruptedException {
        checkoutPage.clickProccedToCheckoutButton();
        Thread.sleep(3000);
    }

    public void clickRegisterLoginButton() {
        checkoutPage.clickRegisterLoginButton();
    }

    public void addReviewToProduct() {
        homePage.clickViewProductButton();
    }

    public boolean verifyReview() {
        productDetailsPage.VerifyAddReview();
        return true;
    }
}
