package widgets;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SliderTest extends TestBase {

    @RepeatedTest(3)
    @Tag("widgets")
    void moveSliderTest() {
        openWebsite("http://www.seleniumui.moderntester.pl/slider.php");
        moveSlider(20);
        moveSlider(58);
        moveSlider(58);
        moveSlider(10);
        moveSlider(100);
    }


    private void moveSlider(int expectedValue) {

        WebElement slider = driver.findElement(By.cssSelector("#custom-handle"));

        slider.click();

        int currentValue = Integer.parseInt(slider.getText());

        int numberOfClicks = expectedValue - currentValue;

        if (numberOfClicks < 0) {
            int positiveNumberOfClicks = Math.abs(numberOfClicks);
            for (int i = 0; i < positiveNumberOfClicks; i++) {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        } else {
            for (int i = 0; i < numberOfClicks; i++)
                slider.sendKeys(Keys.ARROW_RIGHT);
        }

        Assertions.assertThat(Integer.parseInt(slider.getText())).isEqualTo(expectedValue);


    }


}

