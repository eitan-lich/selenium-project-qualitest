package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage extends BasePage {

    private By accountDeletedMessage = By.xpath("//b[text()='Account Deleted!']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifySuccessMessage() {
        return validateElementExist(accountDeletedMessage);
    }

    public void clickContinueButton() {
        click(continueButton);
    }

}
