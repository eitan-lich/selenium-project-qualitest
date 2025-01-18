package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By automationExerciseLogo = By.cssSelector("img[alt='Website for automation practice']");
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By loggedInAs = By.cssSelector("i.fa-user ~ b");
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");

    public HomePage(WebDriver driver) {
        super(driver, 5000);
    }


    public boolean verifyPageLoaded() {
        return validateElementExist(automationExerciseLogo);
    }

    public void clickSignupLoginButton() {
        click(signupLoginButton);
    }

    public String getLoggedInUser() {
        return elementText(loggedInAs);
    }

    public boolean validateLoggedInUserExists() {
        return validateElementExist(loggedInAs);
    }

    public void clickDeleteAccount() {
        click(deleteAccountButton);
    }

}