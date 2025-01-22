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
        super(driver);
    }

    public void addReview(String name, String email, String review) {
        typeText(YourNameField, name);
        typeText(EmailAdressField, email);
        typeText(AddReviewField, review);
        scrollDown(200);
        click(SubmitButton);
    }

    public boolean verifyReviewAdded() {
        return validateElementExist(successMessage);
    }
}
