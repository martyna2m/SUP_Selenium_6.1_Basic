package basic;

import base.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableTest extends TestBase {

    @Test
    void printOutPeaksFromTable() {
        String countryCondition = "Switzerland";
        int heightCondition = 4000;

        openWebsite("http://www.seleniumui.moderntester.pl/table.php");
        System.out.println(iterateOnRows(driver, countryCondition, heightCondition));

    }


    List<String> iterateOnRows(WebDriver driver, String countryCondition, int heightCondition) {

        List<String> peaksMeetingConditions = new ArrayList<>();

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        for (WebElement row : rows) {
            String rank = row.findElement(By.cssSelector("th")).getText();
            String peak = row.findElements(By.cssSelector("td")).get(0).getText();
            String range = row.findElements(By.cssSelector("td")).get(1).getText();
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            int height = Integer.parseInt(row.findElements(By.cssSelector("td")).get(3).getText());

            if (state.contains(countryCondition) && height > heightCondition) {
                peaksMeetingConditions.add("Peak: " + peak + ", Rank: " + rank + ", Mountain Range: " + range + "\n");
            }
        }
        return peaksMeetingConditions;
    }
}
