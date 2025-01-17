package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenerateDriver {

    public static WebDriver initDriver(String browserType, String url) {
        WebDriver driver;

        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser: " + browserType + " is not supported");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);

        return driver;
    }
}