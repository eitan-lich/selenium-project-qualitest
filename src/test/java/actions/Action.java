package actions;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;

public class Action {

    private static final Logger log = LoggerFactory.getLogger(Action.class);
    CartPage cartPage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    LoginPage loginPage;
    PaymentPage paymentPage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    SignupFormPage signupFormPage;
    TestCasesPage testCasesPage;

    public Action(WebDriver driver) {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
        paymentPage = new PaymentPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        signupFormPage = new SignupFormPage(driver);
        testCasesPage = new TestCasesPage(driver);
    }

    public boolean login() {
        return true;
    }

    public boolean registerNewUser() {
        homePage.verifyPageLoaded();
        homePage.clickSignupLoginButton();
        loginPage.register();
        signupFormPage.filloutForm();
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
