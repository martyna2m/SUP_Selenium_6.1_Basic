package other;

import base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class HighSiteMethods extends TestBase {


    void scrollUntilButtonVisibleActions(WebDriver driver) {
        Actions actions = new Actions(driver);

        while (isSubmitButtonDisplayed(driver)) {
            actions.scrollByAmount(0, 100).build().perform();
        }
    }

    void scrollUntilButtonVisibleJS(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        while (isSubmitButtonDisplayed(driver)) {
            jsExecutor.executeScript("window.scrollBy(0,100);");
        }

    }

    boolean isSubmitButtonDisplayed(WebDriver driver) {
        try {
            WebElement submitButton = driver.findElement(By.cssSelector("#scroll-button"));
            return !submitButton.isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    void takeScreenShot(WebDriver driver) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path fileLocalization = Path.of("src/test/resources/screenshot.png");
            Files.copy(screenshotFile.toPath(), fileLocalization, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
