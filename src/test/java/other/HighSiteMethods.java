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

    WebDriver driver;

    public HighSiteMethods(WebDriver driver) {
        this.driver = driver;
    }

    void scrollUntilButtonVisibleActions() {
        Actions actions = new Actions(driver);

        while (isSubmitButtonDisplayed()) {
            actions.scrollByAmount(0, 100).build().perform();
        }
    }

    void scrollUntilButtonVisibleJS() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        while (isSubmitButtonDisplayed()) {
            jsExecutor.executeScript("window.scrollBy(0,100);");
        }

    }

    boolean isSubmitButtonDisplayed() {
        try {
            WebElement submitButton = driver.findElement(By.cssSelector("#scroll-button"));
            return !submitButton.isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    void takeScreenShot() {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path fileLocalization = Path.of("src/test/resources/screenshot.png");
            Files.copy(screenshotFile.toPath(), fileLocalization, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
