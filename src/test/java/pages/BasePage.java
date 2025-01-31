package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void typeText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public boolean validateElementExist(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    public WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String elementText(By locator) {
        return find(locator).getText();
    }

    public void scrollDown(int scrollAmount) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,arguments[0]);", scrollAmount);
    }

    public void preventPageRedirect() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.onbeforeunload = function(event) { " + "event.preventDefault(); " + "event.returnValue = ''; " + "setTimeout(function() { window.onbeforeunload = null; }, 5000); " + "return 'Are you sure you want to leave?'; " + "};");
    }
}