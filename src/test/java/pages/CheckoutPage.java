package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends  BasePage{

    private By commentBox = By.cssSelector("#ordermsg textarea");
    private By placeOrderButton = By.cssSelector("a[href='/payment']");
    private By orderDetails = By.cssSelector("div[data-qa='checkout-info']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void addComment(String comment) {
        scrollDown(500);
        typeText(commentBox, comment);
    }

    public void clickPlaceOrderButton() {
        click(placeOrderButton);
    }

    public String getOrderDetails() {
        return elementText(orderDetails);
    }


}
