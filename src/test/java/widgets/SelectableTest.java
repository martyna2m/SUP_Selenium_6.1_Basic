package widgets;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SelectableTest extends TestBase {

    @RepeatedTest(3)
    @Tag("widgets")
    void select() {
        openWebsite("http://www.seleniumui.moderntester.pl/selectmenu.php");

        int preferredNumberOptionIndex = 7;
        String preferredFileOption = "Some unknown file";
        int randomNumber =  new Random().nextInt(5);

        driver.findElement(By.cssSelector("#speed-button")).click();
        List<WebElement> speedOptions = driver.findElements(By.cssSelector("#speed-menu>.ui-menu-item"));
        speedOptions.get(randomNumber).click();


        driver.findElement(By.cssSelector("#files-button")).click();
        List<WebElement> filesOptions = driver.findElements(By.cssSelector("#files-menu>.ui-menu-item"));
        for (WebElement fileOption : filesOptions) {
            if (fileOption.getText().equals(preferredFileOption)) {
                fileOption.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("#number-button")).click();
        List<WebElement> numberOptions = driver.findElements(By.cssSelector("#number-menu>.ui-menu-item"));
        numberOptions.get(preferredNumberOptionIndex).click();


        driver.findElement(By.cssSelector("#salutation-button")).click();
        List<WebElement> salutationOptions = driver.findElements(By.cssSelector("#salutation-menu>.ui-menu-item"));
        salutationOptions.get(randomNumber).click();


    }


}


