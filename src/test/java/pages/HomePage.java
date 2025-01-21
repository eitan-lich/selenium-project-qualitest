package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By automationExerciseLogo = By.cssSelector("img[alt='Website for automation practice']");
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By testCasesButton = By.cssSelector("a[href='/test_cases']");
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    private By loggedInAs = By.cssSelector("i.fa-user ~ b");
    private By AddToCartButton = By.xpath("(//a[text()='Add to cart'])[1]");
    private By CheckoutMessage = By.xpath("//p[text()='Your product has been added to cart.']");
    private By ViewCart = By.xpath("//u[text()='View Cart']");
    private By ViewProduct = By.cssSelector("a[href='/product_details/1']");





    public HomePage(WebDriver driver) {
        super(driver, 5);
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(automationExerciseLogo);
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

    public void clickAddCartButton() {click(AddToCartButton);}

    public boolean verifyCheckoutMessageLoaded() {return validateElementExist(CheckoutMessage); }

    public void clickViewCartButton() {click (ViewCart); }

    public boolean verifyCheckoutPageLoaded() {return validateElementExist(ViewCart); }

    public void clickViewProductButton() {click(ViewProduct); }




}