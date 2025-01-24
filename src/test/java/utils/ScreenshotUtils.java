package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static File captureScreenshot(WebDriver driver, String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenShotPath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_screenshot.png";
            FileUtils.copyFile(screenshot, new File(screenShotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshot;
    }
}