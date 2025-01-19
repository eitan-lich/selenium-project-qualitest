package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By automationExerciseLogo = By.cssSelector("img[alt='Website for automation practice']");
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By testCasesButton = By.cssSelector("a[href='/test_cases']");
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    private By loggedInAs = By.cssSelector("i.fa-user ~ b");

    public HomePage(WebDriver driver) {
        super(driver, 5);
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(automationExerciseLogo);
    }

    public void clickSignupLoginButton() {
        click(signupLoginButton);
    }

    public void clickTestCasesButton() {
        click(testCasesButton);
    }

    public String getLoggedInUser() {
        return elementText(loggedInAs);
    }

    public void clickDeleteAccount() {
        click(deleteAccountButton);
    }

}