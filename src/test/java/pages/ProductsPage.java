package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By allProductsHeader = By.xpath("//h2[text()='All Products']");
    private By ViewProduct = By.cssSelector("a[href='/product_details/1']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(allProductsHeader);
    }

    public void clickViewProductButton() {
        scrollDown(200);
        click(ViewProduct);
    }
}
