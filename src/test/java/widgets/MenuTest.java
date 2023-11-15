package widgets;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuTest extends TestBase {

    @RepeatedTest(3)
    @Tag("widgets")
    void pickOptionFromMenu() {
        openWebsite("http://www.seleniumui.moderntester.pl/menu-item.php");

        driver.findElement(By.cssSelector("#ui-id-9")).click();

        WebElement jazzMenu = driver.findElement(By.cssSelector("#ui-id-13"));
        waitAndClickElement(jazzMenu);

        WebElement modernMenu = driver.findElement(By.cssSelector("#ui-id-16"));
        waitAndClickElement(modernMenu);

    }

    private void waitAndClickElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}