package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage {

    private By newUserSignupMessage = By.xpath("//h2[text()='New User Signup!']");
    private By loginErrorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");
    private By newUserNameField = By.cssSelector("input[data-qa='signup-name']");
    private By newUserEmailAddressField = By.cssSelector("input[data-qa='signup-email']");
    private By newUserSignupButton = By.cssSelector("button[data-qa='signup-button']");
    private By existingUserEmailField = By.cssSelector("input[data-qa='login-email']");
    private By existingUserPasswordField = By.cssSelector("input[data-qa='login-password']");
    private By existingUserLoginButton = By.cssSelector("button[data-qa='login-button']");

    public SignupLoginPage(WebDriver driver) {
        super(driver, 5000);
    }

    public void filloutRegister() {
        typeText(newUserNameField, "Testuser943");
        typeText(newUserEmailAddressField, "Testuser943@Testuser9431.com");
        click(newUserSignupButton);
    }

    public void filloutLogin(String email, String password) {
        typeText(existingUserEmailField, email);
        typeText(existingUserPasswordField, password);
        click(existingUserLoginButton);
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(newUserSignupMessage);
    }

    public boolean verifyLoginErrorMessage() {
        return validateElementExist(loginErrorMessage);
    }
}