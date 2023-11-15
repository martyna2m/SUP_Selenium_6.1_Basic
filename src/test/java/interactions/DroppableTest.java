package interactions;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DroppableTest extends TestBase {

    @RepeatedTest(3)
    @Tag("interactions")
    void moveAndDrop() {
        openWebsite("http://www.seleniumui.moderntester.pl/droppable.php");
        Actions actions = new Actions(driver);

        WebElement object = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));

        actions.dragAndDrop(object, target).build().perform();
        Assertions.assertThat(driver.findElement(By.cssSelector("#droppable>p")).getText()).isEqualTo("Dropped!");

    }

}
