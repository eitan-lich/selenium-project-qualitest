package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By allProductsHeader = By.xpath("//h2[text()='All Products']");

    public ProductsPage(WebDriver driver) {
        super(driver, 5);
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(allProductsHeader);
    }
}
