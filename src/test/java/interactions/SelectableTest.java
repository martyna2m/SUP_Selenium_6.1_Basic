package interactions;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SelectableTest extends TestBase {
    @RepeatedTest(3)
    @Tag("interactions")
    void selectItems() {
        openWebsite("http://www.seleniumui.moderntester.pl/selectable.php");
        String option1 = "1";
        String option2 = "3";
        String option3 = "4";
        String expectedPhrase = "You've selected: #1 #3 #4.";

        holdCtrlBtn();
        findAndChooseOptions(option1, option2, option3);
        assertChosenOptions(expectedPhrase);
    }


    private void holdCtrlBtn() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL).build().perform();
    }

    private void findAndChooseOptions(String option1, String option2, String option3) {
        List<WebElement> items = driver.findElements(By.cssSelector(".ui-widget-content"));
        for (WebElement item : items) {
            if (item.getText().contains(option1) || item.getText().contains(option2) || item.getText().contains(option3)) {
                item.click();
            }
        }
    }

    private void assertChosenOptions(String expectedPhrase) {
        WebElement resultInfo = driver.findElement(By.cssSelector("#feedback"));
        Assertions.assertThat(resultInfo.getText()).isEqualTo(expectedPhrase);
    }

}