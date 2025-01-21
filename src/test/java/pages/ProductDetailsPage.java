package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver, 5);
    }

    private By YourNameField = By.id("name");
    private By EmailAdressField = By.id("email");
    private By AddReviewField = By.id("review");
    private By SubmitButton = By.id("button-review");

    public void VerifyAddReview() {
        typeText(YourNameField, "Testuser943");
        typeText(EmailAdressField, "Testuser943@Testuser9431.com");
        typeText(AddReviewField, "Automation it's amazing");
        click(SubmitButton);
    }
}
