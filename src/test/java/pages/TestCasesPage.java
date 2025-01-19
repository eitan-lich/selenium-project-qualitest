package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    private By testCasesMessage = By.xpath("//span[text()='Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:']");

    public TestCasesPage(WebDriver driver) {
        super(driver, 10000);
    }

    public boolean verifyTestCasesMessage() {
        return validateElementExist(testCasesMessage);
    }
}