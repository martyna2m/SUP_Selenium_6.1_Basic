package basic;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class IframesTest extends TestBase {

    @RepeatedTest(3)
    @Tag("basic")
    void testIframes() {
        openWebsite("http://automation-practice.emilos.pl/iframes.php");

        String firstName = "John";
        String lastName = "Smith";
        String login = "johnsmith";
        String password = "p@ssw0rd";
        String continent = "europe";
        int experienceOptionIndex = 0;

        fillInAndSubmitFormInIframe1(firstName, lastName);

        driver.switchTo().defaultContent();

        fillInAndSubmitFormInIframe2(login, password, continent,experienceOptionIndex);

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("li[class=\"nav-ite dropdown\"]")).click();

    }



    private void fillInAndSubmitFormInIframe1(String firstName, String lastName) {
        driver.switchTo().frame("iframe1");
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#inputSurname3")).sendKeys(lastName);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }


    private void fillInAndSubmitFormInIframe2(String login, String password, String continentValue, int experienceOptionIndex){
        driver.switchTo().frame("iframe2");
        driver.findElement(By.cssSelector("#inputLogin")).sendKeys(login);
        driver.findElement(By.cssSelector("#inputPassword")).sendKeys(password);

        Select continents = new Select(driver.findElement(By.cssSelector("#inlineFormCustomSelectPref")));
        continents.selectByValue(continentValue);

        List<WebElement> experienceCheckboxes = driver.findElements(By.cssSelector("[name='gridRadios']"));
        experienceCheckboxes.get(experienceOptionIndex).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

}
