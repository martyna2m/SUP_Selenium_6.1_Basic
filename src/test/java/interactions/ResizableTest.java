package interactions;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizableTest extends TestBase {

    @RepeatedTest(3)
    @Tag("interactions")
    void resizeObject() {
        openWebsite("http://www.seleniumui.moderntester.pl/resizable.php");

        WebElement resizableElement = driver.findElement(By.cssSelector(".ui-resizable-handle:last-of-type"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(resizableElement).moveByOffset(10, 0).release().build().perform();
        actions.clickAndHold(resizableElement).moveByOffset(0, 10).release().build().perform();
        actions.clickAndHold(resizableElement).moveByOffset(10, 10).release().build().perform();

    }
}
