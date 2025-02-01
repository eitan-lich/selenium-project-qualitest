package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By homeButton = By.cssSelector("a[href='/'][style='color: orange;']");
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By testCasesButton = By.cssSelector("a[href='/test_cases']");
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    private By loggedInAs = By.cssSelector("i.fa-user ~ b");
    private By AddToCartButton = By.xpath("(//a[text()='Add to cart'])[1]");
    private By CheckoutMessage = By.xpath("//p[text()='Your product has been added to cart.']");
    private By viewCartPopup = By.xpath("//u[text()='View Cart']");
    private By productsButton = By.cssSelector("a[href='/products']");
    private By cartButton = By.cssSelector("a[href='/view_cart']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(homeButton);
    }

    public void clickSignupLoginButton() {
        click(signupLoginButton);
    }

    public void clickTestCasesButton() {
        click(testCasesButton);
    }

    public String getLoggedInUser() {
        return elementText(loggedInAs);
    }

    public void clickDeleteAccount() {
        click(deleteAccountButton);
    }

    public void addFirstItemToCart() {
        scrollDown(400);
        click(AddToCartButton);
    }

    public boolean verifyProductAddedSuccessfully() {
        return validateElementExist(CheckoutMessage);
    }

    public void clickViewCartPopup() {
        click(viewCartPopup);
    }

    public void clickCartButton() {
        click(cartButton);
    }

    public void clickProductsButton() {
        click(productsButton);
    }

}