package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By newUserSignupHeader = By.xpath("//h2[text()='New User Signup!']");
    private By newUserNameField = By.cssSelector("input[data-qa='signup-name']");
    private By newUserEmailAddressField = By.cssSelector("input[data-qa='signup-email']");
    private By newUserSignupButton = By.cssSelector("button[data-qa='signup-button']");

    public LoginPage(WebDriver driver) {
        super(driver, 5000);
    }

    public void register() {
        typeText(newUserNameField, "testuser123123123");
        typeText(newUserEmailAddressField, "test123123123123@test123123.com");
        click(newUserSignupButton);
    }
}