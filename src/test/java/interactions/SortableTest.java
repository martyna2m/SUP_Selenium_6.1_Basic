package interactions;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortableTest extends TestBase {
    @RepeatedTest(3)
    @Tag("interactions")
    void selectItems() {
        openWebsite("http://www.seleniumui.moderntester.pl/sortable.php");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Collections.shuffle(numbers);

        sortElementsAccordingToNumberOrder(numbers);
    }


    private void sortElementsAccordingToNumberOrder(List<Integer> numbersOrder) {
        Actions actions = new Actions(driver);

        for (int number : numbersOrder) {

            String index = String.valueOf((numbersOrder.indexOf(number)) + 1);

            WebElement option = driver.findElement(By.xpath("//li[contains(text(),'" + number + "')]"));
            WebElement position = driver.findElement(By.xpath("//*[@id='sortable']/li[" + index + "]"));
            actions.dragAndDrop(option, position).build().perform();
        }
    }
}
