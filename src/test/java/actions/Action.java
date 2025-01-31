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
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;

    /**
     * Constructor for the Action class.
     *
     * @param driver the WebDriver instance used to initialize page objects for web interactions.
     */
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
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    /**
     * Registers a new user by filling out the signup form and verifying the account creation.
     *
     * @return true if the account has been created successfully, false otherwise.
     */
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
        logger.info("Clicking create account button");
        signupFormPage.clickCreateAccountButton();
        logger.info("Verifying success message was displayed");
        boolean successfulRegister = accountCreatedPage.validateSuccessMessage();
        accountCreatedPage.clickContinueButton();
        return successfulRegister;
    }

    /**
     * Deletes the user account and verifies that it was successfully deleted.
     *
     * @return true if the account deletion was successful, false otherwise.
     */
    public boolean deleteAccount() {
        boolean successMessage = false;

        logger.info("Deleting account");
        homePage.clickDeleteAccount();
        logger.info("Verifying account was deleted successfully");
        successMessage = accountDeletedPage.verifySuccessMessage();
        accountDeletedPage.clickContinueButton();
        return successMessage;
    }

    /**
     * Retrieves the username of the currently logged-in user as displayed on the homepage.
     *
     * @return a String representing the currently logged-in user, or null if no user is logged in.
     */
    public String getLoggedInUser() {
        logger.info("Verifying new registered user appears as logged in");
        return homePage.getLoggedInUser();
    }

    /**
     * Verifies that the homepage is loaded correctly by interacting with meaningful page elements.
     *
     * @return true if the homepage is loaded successfully, false otherwise.
     */
    public boolean verifyHomePageLoaded() {
        logger.info("Verifying homepage loaded successfully");
        return homePage.verifyPageLoaded();
    }

    /**
     * Attempts to log in with incorrect credentials and verifies whether the login error message is displayed.
     *
     * @return true if the error message is displayed after a failed login attempt, false otherwise.
     */
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
        logger.info("Clicking login button");
        loginPage.clickExistingUserLoginButton();
        return loginPage.verifyLoginErrorMessage();
    }

    /**
     * Navigates to the Test Cases page by interacting with the necessary homepage elements.
     *
     * @return true if the Test Cases page is loaded successfully, false otherwise.
     */
    public boolean goToTestCasesPage() {
        logger.info("Clicking Test Cases button");
        homePage.clickTestCasesButton();
        logger.info("Verifying test cases page loaded");
        return testCasesPage.verifyPageLoaded();
    }

    /**
     * Adds an item to the cart, verifies it, and proceeds to the checkout page.
     * Does nothing if any step in the process, such as verification, fails.
     */
    public boolean addItemAndCheckout() {
        logger.info("Adding product to cart");
        homePage.addFirstItemToCart();
        if (!homePage.verifyProductAddedSuccessfully()) {
            return false;
        }
        homePage.clickViewCartPopup();
        if (!cartPage.verifyPageLoaded()) {
            return false;
        }
        logger.info("Clicking proceed to checkout button");
        cartPage.clickProceedToCheckoutButton();
        return true;
    }

    /**
     * Registers a new user from the cart page during the checkout process.
     *
     * @return true if the registration from the cart page was successful, false otherwise.
     */
    public boolean registerFromCartPage() {
        logger.info("Clicking Register/Login button from cart page");
        cartPage.clickRegisterLoginButton();
        return register();
    }

    public boolean placeOrder() {
        logger.info("Clicking cart button");
        homePage.clickCartButton();
        logger.info("Clicking proceed to checkout button");
        cartPage.clickProceedToCheckoutButton();
        logger.info("Verifying order details are correct");
        if (checkoutPage.getOrderDetails().isEmpty()) {
            return false;
        }
        logger.info("Adding comment to order");
        checkoutPage.addComment("Please make sure the package is well packed");
        logger.info("Clicking place order button");
        checkoutPage.clickPlaceOrderButton();
        logger.info("Filling out payment details");
        paymentPage.fillNameOnCard("Test");
        paymentPage.fillCardNumber("0000000000");
        paymentPage.fillCvc("333");
        paymentPage.fillExpiryMonth("12");
        paymentPage.fillExpiryYear("29");
        logger.info("Clicking pay and confirm button");
        paymentPage.clickPayAndConfirmButton();
        logger.info("Verifying order was successful");
        return paymentPage.verifyOrderSuccess();
    }

    /**
     * Adds a review to a specific product by supplying the name, email, and review content.
     *
     * @param name   the name of the person submitting the review.
     * @param email  the email address of the reviewer.
     * @param review the content of the review to be added.
     * @return true if the review was added successfully, false otherwise.
     */
    public boolean addReviewToProduct(String name, String email, String review) {
        logger.info("Clicking product details");
        productsPage.clickViewProductButton();
        logger.info("Adding review to product");
        productDetailsPage.addReview(name, email, review);
        logger.info("Verifying review was added successfully");
        return productDetailsPage.verifyReviewAdded();
    }

    /**
     * Navigates to the Products page by interacting with the necessary homepage elements.
     *
     * @return true if the Products page is loaded successfully, false otherwise.
     */
    public boolean goToProductsPage() {
        logger.info("clicking on Products button");
        homePage.clickProductsButton();
        logger.info("Verifying Products page loaded successfully");
        return productsPage.verifyPageLoaded();
    }
}