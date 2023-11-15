package interactions;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraggableTest extends TestBase {

    @RepeatedTest(3)
    @Tag("interactions")
    void dragTheObject() {
        openWebsite("http://www.seleniumui.moderntester.pl/draggable.php");

        WebElement draggableElement = driver.findElement(By.cssSelector("#draggable"));

        int windowWidth = driver.manage().window().getSize().getWidth();
        int windowHeight = driver.manage().window().getSize().getHeight();
        int elementWidth = draggableElement.getSize().getWidth();
        int elementHeight = draggableElement.getSize().getHeight();
        int elementXOffset = draggableElement.getLocation().getX();


        dragElementTo(draggableElement, windowWidth - elementWidth - elementXOffset, 0);

        int elementYOffset = draggableElement.getLocation().getY();

        dragElementTo(draggableElement, 0, (windowHeight - elementYOffset) / 2);
        elementXOffset = draggableElement.getLocation().getX();
        elementYOffset = draggableElement.getLocation().getY();


        dragElementTo(draggableElement, ((windowWidth / 2) - elementXOffset - elementWidth), (windowHeight / 2) - elementYOffset - elementHeight);
        elementXOffset = draggableElement.getLocation().getX();
        elementYOffset = draggableElement.getLocation().getY();

        dragElementTo(draggableElement, (-(windowWidth - elementXOffset - elementWidth) / 2), (windowHeight - elementYOffset) / 2);


    }

    private void dragElementTo(WebElement element, int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, xOffset, yOffset).build().perform();
    }


}
