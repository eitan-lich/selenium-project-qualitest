package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage {

    private By newUserSignupMessage = By.xpath("//h2[text()='New User Signup!']");
    private By newUserNameField = By.cssSelector("input[data-qa='signup-name']");
    private By newUserEmailAddressField = By.cssSelector("input[data-qa='signup-email']");
    private By newUserSignupButton = By.cssSelector("button[data-qa='signup-button']");

    public SignupLoginPage(WebDriver driver) {
        super(driver, 5000);
    }

    public void filloutRegister() {
        typeText(newUserNameField, "Testuser943");
        typeText(newUserEmailAddressField, "Testuser943@Testuser9431.com");
        click(newUserSignupButton);
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(newUserSignupMessage);
    }
}