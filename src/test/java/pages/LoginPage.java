package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.RandomUtils;

public class LoginPage extends BasePage {

    private By newUserSignupMessage = By.xpath("//h2[text()='New User Signup!']");
    private By loginErrorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");
    private By newUserNameField = By.cssSelector("input[data-qa='signup-name']");
    private By newUserEmailAddressField = By.cssSelector("input[data-qa='signup-email']");
    private By newUserSignupButton = By.cssSelector("button[data-qa='signup-button']");
    private By existingUserEmailField = By.cssSelector("input[data-qa='login-email']");
    private By existingUserPasswordField = By.cssSelector("input[data-qa='login-password']");
    private By existingUserLoginButton = By.cssSelector("button[data-qa='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(newUserSignupMessage);
    }

    public void typeNewUsername(String username) {
        typeText(newUserNameField, username);
    }

    public void typeNewUserEmailAddress(String email) {
        typeText(newUserEmailAddressField, email);
    }

    public void typeNewUsername() {
        String randomNumberSequence = RandomUtils.generateRandomNumberSequence();
        typeText(newUserNameField, "Testuser" + randomNumberSequence);
    }

    public void typeNewUserEmailAddress() {
        String randomNumberSequence = RandomUtils.generateRandomNumberSequence();
        typeText(newUserEmailAddressField, "Testuser" + randomNumberSequence + "@Testuser" + randomNumberSequence + ".com");
    }

    public void clickNewUserSignUpButton() {
        click(newUserSignupButton);
    }

    public void typeExistingUserEmail(String email) {
        typeText(existingUserEmailField, email);
    }

    public void typeExistingUserPassword(String Password) {
        typeText(existingUserPasswordField, Password);
    }

    public void clickExistingUserLoginButton() {
        click(existingUserLoginButton);
    }

    public boolean verifyLoginErrorMessage() {
        return validateElementExist(loginErrorMessage);
    }
}