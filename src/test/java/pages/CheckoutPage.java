package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {


    public CheckoutPage(WebDriver driver) {
        super(driver, 5);
    }

    public boolean verifyCheckoutPageLoaded() {
        return validateElementExist(ProccedToCheckout);
    }

    private By ProccedToCheckout = By.xpath("//a[text()='Proceed To Checkout']");

    public void clickProccedToCheckoutButton() {
        click(ProccedToCheckout);
    }
    private By RegisterLogin = By.xpath("//u[text()='Register / Login']");

    public void clickRegisterLoginButton() {
        click(RegisterLogin);
    }
}