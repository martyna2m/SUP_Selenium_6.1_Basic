package basic;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTest extends TestBase {

    @BeforeEach
    void goToAlertPage() {
        openWebsite("http://www.seleniumui.moderntester.pl/alerts.php");
    }


    @RepeatedTest(1)
    @Tag("basic")
    void clickAndAcceptSimpleAlert() {
        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept();
        assertThatIsDisplayed("#simple-alert-label");

    }

    @RepeatedTest(1)
    @Tag("basic")
    void clickAndAcceptPromptAlert() {
        driver.findElement(By.cssSelector("#prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();
        assertThatPhrasesAreEqual("#prompt-label", "Hello Lord Vader! How are you today?");

    }


    @RepeatedTest(1)
    @Tag("basic")
    void clickAndAcceptThenDismissAlertBox() {
        WebElement confirmAlertBox = driver.findElement(By.cssSelector("#confirm-alert"));
        confirmAlertBox.click();

        driver.switchTo().alert().accept();
        assertThatPhrasesAreEqual("#confirm-label", "You pressed OK!");

        confirmAlertBox.click();
        driver.switchTo().alert().dismiss();
        assertThatPhrasesAreEqual("#confirm-label", "You pressed Cancel!");

    }

    @RepeatedTest(1)
    @Tag("basic")
    void clickAndAcceptDelayedAlert() {
        driver.findElement(By.cssSelector("#delayed-alert")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        assertThatIsDisplayed("#delayed-alert-label");

    }


    private void assertThatIsDisplayed(String cssSelector) {
        Assertions.assertThat(driver.findElement(By.cssSelector(cssSelector)).isDisplayed()).isTrue();
    }

    private void assertThatPhrasesAreEqual(String cssSelectorOfActualPhrase, String expectedPhrase) {
        assertThat(driver.findElement(By.cssSelector(cssSelectorOfActualPhrase)).getText()).isEqualTo(expectedPhrase);
    }

}
