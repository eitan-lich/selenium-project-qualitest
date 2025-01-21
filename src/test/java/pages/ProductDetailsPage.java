package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private By YourNameField = By.id("name");
    private By EmailAdressField = By.id("email");
    private By AddReviewField = By.id("review");
    private By SubmitButton = By.id("button-review");
    private By successMessage = By.xpath("//span[text()='Thank you for your review.']");

    public ProductDetailsPage(WebDriver driver) {
        super(driver, 5);
    }

    public void addReview() {
        typeText(YourNameField, "Testuser943");
        typeText(EmailAdressField, "Testuser943@Testuser9431.com");
        typeText(AddReviewField, "Automation it's amazing");
        click(SubmitButton);
    }

    public boolean verifyReviewAdded() {
        return validateElementExist(successMessage);
    }
}
