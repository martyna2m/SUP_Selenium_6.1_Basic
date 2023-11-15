package widgets;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressbarTest extends TestBase {
    @RepeatedTest(3)
    @Tag("widgets")
    void waitForProgressComplete1() {
        openWebsite("http://www.seleniumui.moderntester.pl/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".progress-label"), "Complete"));

    }

    @RepeatedTest(3)
    void waitForProgressComplete2() {
        openWebsite("http://www.seleniumui.moderntester.pl/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement progressDiv = driver.findElement(By.cssSelector(".progress-label~div"));
        wait.until(ExpectedConditions.attributeContains(progressDiv, "class", "ui-progressbar-complete"));
    }
}
