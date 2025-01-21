package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartPage extends BasePage {

    private By RegisterLogin = By.xpath("//u[text()='Register / Login']");
    private By ProceedToCheckout = By.xpath("//a[text()='Proceed To Checkout']");

    public cartPage(WebDriver driver) {
        super(driver, 5);
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