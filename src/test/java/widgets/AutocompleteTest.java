package widgets;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutocompleteTest extends TestBase {
    @RepeatedTest(3)
    @Tag("widgets")
    void chooseFromPromptOptions() {
        openWebsite("http://www.seleniumui.moderntester.pl/autocomplete.php");

        String searchedPhrase = "a";
        int optionIndex = 2;


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement searchBox = driver.findElement(By.cssSelector("#search"));
        searchBox.sendKeys(searchedPhrase);

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(".ui-menu-item"))));
        printAvailableOptions(options);

        WebElement pickedOption = options.get(optionIndex);
        wait.until(ExpectedConditions.elementToBeClickable(pickedOption));

        String expectedText = pickedOption.getText();
        pickedOption.click();

        Assertions.assertThat(searchBox.getAttribute("value")).isEqualTo(expectedText);
    }



    private void printAvailableOptions(List<WebElement> listOfOptions) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfAllElements(listOfOptions));
        for (WebElement option : listOfOptions) {
            System.out.println(option.getText());
        }

    }

}

