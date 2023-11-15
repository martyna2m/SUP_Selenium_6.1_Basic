package other;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoQaTest extends TestBase {


    @RepeatedTest(3)
    @Tag("other")
    void chooseSubmitOptions() {
        openWebsite("https://demoqa.com/automation-practice-form");

        String searchedPhrase1 = "m";
        String preferredOption1 = "Maths";
        String searchedPhrase2 = "a";
        String preferredOption2 = "Arts";

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 200).build().perform();

        WebElement subjectInput = driver.findElement(By.cssSelector("#subjectsInput"));
        subjectInput.click();

        subjectInput.sendKeys(searchedPhrase1);
        clickPreferredOption(".subjects-auto-complete__option", preferredOption1);

        subjectInput.sendKeys(searchedPhrase2);
        clickPreferredOption(".subjects-auto-complete__option", preferredOption2);


        Assertions.assertThat(driver.findElement(By.cssSelector(".subjects-auto-complete__value-container")).getText()).contains("Maths")
                .contains("Arts");

    }


    private void clickPreferredOption(String cssSelectorForListOfOptions, String preferredOptionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelectorForListOfOptions)));
        options.stream().filter(option -> option.getText().equals(preferredOptionText))
                .findFirst().ifPresent(WebElement::click);
    }
}
