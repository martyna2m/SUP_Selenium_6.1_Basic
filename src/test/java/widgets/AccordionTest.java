package widgets;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AccordionTest extends TestBase {
    @RepeatedTest(3)
    @Tag("widgets")
    void printTextFromSections() {
        openWebsite("http://www.seleniumui.moderntester.pl/accordion.php");

        Assertions.assertThat(driver.findElement(By.cssSelector("#ui-id-2")).isDisplayed()).isTrue();
        findElementAndPrintText("#ui-id-2>p");

        driver.findElement(By.cssSelector("#ui-id-3")).click();
        findElementAndPrintText("#ui-id-4>p");

        driver.findElement(By.cssSelector("#ui-id-5")).click();
        findElementAndPrintText("#ui-id-6>p");

        driver.findElement(By.cssSelector("#ui-id-7")).click();
        findElementAndPrintText("#ui-id-8>p");
    }



    private void findElementAndPrintText(String cssSelector) {
        System.out.println(driver.findElement(By.cssSelector(cssSelector)).getText());
        System.out.println();
    }
}
