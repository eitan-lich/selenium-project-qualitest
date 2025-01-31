package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {


    private By nameOnCard = By.cssSelector("input[data-qa='name-on-card']");
    private By cardNumber = By.cssSelector("input[data-qa='card-number']");
    private By cvc = By.cssSelector("input[data-qa='cvc']");
    private By expiryMonth = By.cssSelector("input[data-qa='expiry-month']");
    private By expiryYear = By.cssSelector("input[data-qa='expiry-year']");
    private By payAndConfirmButton = By.cssSelector("button[data-qa='pay-button']");
    private By orderPlacedSuccesfully = By.id("success_message");


    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fillNameOnCard(String text) {
        typeText(nameOnCard, text);
    }

    public void fillCardNumber(String text) {
        typeText(cardNumber, text);
    }

    public void fillCvc(String text) {
        typeText(cvc, text);
    }
    public void fillExpiryMonth(String text) {
        typeText(expiryMonth, text);
    }

    public void fillExpiryYear(String text) {
        typeText(expiryYear, text);
    }

    public void clickPayAndConfirmButton() {
        preventPageRedirect();
        click(payAndConfirmButton);
    }

    public boolean verifyOrderSuccess() {
        return validateElementExist(orderPlacedSuccesfully);
    }
}

