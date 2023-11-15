package widgets;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class TooltipTest extends TestBase {


    @RepeatedTest(3)
    @Tag("widgets")
    void printMessageFromTooltip() {
        openWebsite("http://www.seleniumui.moderntester.pl/tooltip.php");
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.cssSelector("#age"))).build().perform();
        String message = driver.findElement(By.cssSelector(".ui-tooltip-content")).getText();
        System.out.println(message);
    }

}
