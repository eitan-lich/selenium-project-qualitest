package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private By accountCreatedMessage = By.xpath("//b[text()='Account Created!']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver, 5);
    }

    public boolean validateSuccessMessage() {
        return validateElementExist(accountCreatedMessage);
    }

    public void clickContinueButton() {
        click(continueButton);
    }

}
