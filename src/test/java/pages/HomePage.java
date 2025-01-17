package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By automationExerciseLogo = By.cssSelector("img[alt='Website for automation practice']");
    private By signupLoginButton = By.cssSelector("a[href='/login']");

    public HomePage(WebDriver driver) {
        super(driver, 5000);
    }


    public boolean verifyPageLoaded() {
        return validateElementExist(automationExerciseLogo);
    }

    public void clickSignupLoginButton() {
        click(signupLoginButton);
    }

}