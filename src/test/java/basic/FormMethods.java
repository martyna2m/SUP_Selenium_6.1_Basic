package basic;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormMethods {

    WebDriver driver;

    public FormMethods(WebDriver driver) {
        this.driver = driver;
    }

    File sampleFile = new File("src/test/resources/sampleFile.docx");

    void fillTheForm(String firstName, String lastName, String email, String age) {
        putFirstName(firstName);
        putLastName(lastName);
        putEmail(email);
        chooseGenderOption(0);
        putAge(age);
        chooseExperienceOption(0);
        chooseProfessionOption(0);
        selectContinent("europe");
        selectCommandOption(1);
        sendFile();
        clickSignInButton();

        WebElement successAlert = driver.findElement(By.cssSelector("#validator-message"));
        Assertions.assertThat(successAlert.isDisplayed()).isTrue();

    }

    private void putFirstName(String firstName) {
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys(firstName);
    }

    private void putLastName(String lastName) {
        driver.findElement(By.cssSelector("#inputLastName3")).sendKeys(lastName);
    }

    private void putEmail(String email) {
        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys(email);
    }

    private void putAge(String age) {
        driver.findElement(By.cssSelector("#inputAge3")).clear();
        driver.findElement(By.cssSelector("#inputAge3")).sendKeys(age);
    }

    private void chooseGenderOption(int optionIndex) {
        List<WebElement> sexCheckBoxes = driver.findElements(By.cssSelector("[name='gridRadiosSex']"));
        sexCheckBoxes.get(optionIndex).click();
    }

    private void chooseExperienceOption(int optionIndex) {
        List<WebElement> experienceCheckBoxes = driver.findElements(By.cssSelector("[name='gridRadiosExperience']"));
        experienceCheckBoxes.get(optionIndex).click();
    }

    private void chooseProfessionOption(int optionIndex) {
        List<WebElement> professionCheckBoxes = driver.findElements(By.cssSelector("[name='gridCheckboxProfession']"));
        professionCheckBoxes.get(optionIndex).click();
    }

    private void clickSignInButton() {
        driver.findElement(By.xpath("//*[text()='Sign in']")).click();
    }

    private void sendFile() {
        driver.findElement(By.cssSelector("#chooseFile")).sendKeys(sampleFile.getAbsolutePath());
    }

    private void selectContinent(String continentValue) {
        Select continents = new Select(driver.findElement(By.cssSelector("#selectContinents")));
        continents.selectByValue(continentValue);
    }

    private void selectCommandOption(int optionIndex) {
        Select commands = new Select(driver.findElement(By.cssSelector("#selectSeleniumCommands")));
        commands.selectByIndex(optionIndex);
    }
}
