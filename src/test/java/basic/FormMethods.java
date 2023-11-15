package basic;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormMethods {

    File sampleFile = new File("src/test/resources/sampleFile.docx");

    void fillTheForm(WebDriver driver, String firstName, String lastName, String email, String age) {
        putFirstName(driver, firstName);
        putLastName(driver, lastName);
        putEmail(driver, email);
        chooseGenderOption(driver, 0);
        putAge(driver, age);
        chooseExperienceOption(driver, 0);
        chooseProfessionOption(driver, 0);
        selectContinent(driver, "europe");
        selectCommandOption(driver,1);
        sendFile(driver);
        clickSignInButton(driver);

        WebElement successAlert = driver.findElement(By.cssSelector("#validator-message"));
        Assertions.assertThat(successAlert.isDisplayed()).isTrue();

    }

    private void putFirstName(WebDriver driver, String firstName) {
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys(firstName);
    }

    private void putLastName(WebDriver driver, String lastName) {
        driver.findElement(By.cssSelector("#inputLastName3")).sendKeys(lastName);
    }

    private void putEmail(WebDriver driver, String email) {
        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys(email);
    }

    private void putAge(WebDriver driver, String age) {
        driver.findElement(By.cssSelector("#inputAge3")).clear();
        driver.findElement(By.cssSelector("#inputAge3")).sendKeys(age);
    }

    private void chooseGenderOption(WebDriver driver, int optionIndex) {
        List<WebElement> sexCheckBoxes = driver.findElements(By.cssSelector("[name='gridRadiosSex']"));
        sexCheckBoxes.get(optionIndex).click();
    }

    private void chooseExperienceOption(WebDriver driver, int optionIndex) {
        List<WebElement> experienceCheckBoxes = driver.findElements(By.cssSelector("[name='gridRadiosExperience']"));
        experienceCheckBoxes.get(optionIndex).click();
    }

    private void chooseProfessionOption(WebDriver driver, int optionIndex) {
        List<WebElement> professionCheckBoxes = driver.findElements(By.cssSelector("[name='gridCheckboxProfession']"));
        professionCheckBoxes.get(optionIndex).click();
    }

    private void clickSignInButton(WebDriver driver) {
        driver.findElement(By.xpath("//*[text()='Sign in']")).click();
    }

    private void sendFile(WebDriver driver) {
        driver.findElement(By.cssSelector("#chooseFile")).sendKeys(sampleFile.getAbsolutePath());
    }

    private void selectContinent(WebDriver driver, String continentValue) {
        Select continents = new Select(driver.findElement(By.cssSelector("#selectContinents")));
        continents.selectByValue(continentValue);
    }

    private void selectCommandOption(WebDriver driver, int optionIndex) {
        Select commands = new Select(driver.findElement(By.cssSelector("#selectSeleniumCommands")));
        commands.selectByIndex(optionIndex);
    }
}
