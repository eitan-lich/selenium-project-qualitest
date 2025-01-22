package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By RegisterLogin = By.xpath("//u[text()='Register / Login']");
    private By ProceedToCheckout = By.xpath("//a[text()='Proceed To Checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyCheckoutPageLoaded() {
        return validateElementExist(ProceedToCheckout);
    }

    public void clickProceedToCheckoutButton() {
        click(ProceedToCheckout);
    }

    public void clickRegisterLoginButton() {
        click(RegisterLogin);
    }
}