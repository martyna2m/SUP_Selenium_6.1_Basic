package widgets;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModalDialogMethods {

    WebDriver driver;

    public ModalDialogMethods(WebDriver driver) {
        this.driver = driver;
    }

    List<WebElement> findUsersList() {
        return driver.findElements(By.cssSelector("tbody tr"));
    }

    void clickCreateUserButton() {
        driver.findElement(By.cssSelector("#create-user")).click();
    }

    void clickCreateAccountButton() {
        driver.findElement(By.xpath("//button[text()='Create an account']")).click();
    }

    void clearAndSendKeysToNameInput(String value) {
        WebElement nameInput = driver.findElement(By.cssSelector("#name"));
        nameInput.clear();
        nameInput.sendKeys(value);
    }

    void clearAndSendKeysToEmailInput(String value) {
        WebElement nameInput = driver.findElement(By.cssSelector("#email"));
        nameInput.clear();
        nameInput.sendKeys(value);
    }

    void clearAndSendKeysToPasswordInput(String value) {
        WebElement nameInput = driver.findElement(By.cssSelector("#password"));
        nameInput.clear();
        nameInput.sendKeys(value);
    }


    void assertThatAddedDataIsCorrect(List<WebElement> listOfUsers, String name, String email, String password) {
        WebElement addedUser = listOfUsers.get(listOfUsers.size() - 1);

        List<WebElement> addedUsersDetails = addedUser.findElements(By.cssSelector("td"));
        String addedName = addedUsersDetails.get(0).getText();
        String addedEmail = addedUsersDetails.get(1).getText();
        String addedPassword = addedUsersDetails.get(2).getText();

        Assertions.assertThat(addedName).isEqualTo(name);
        Assertions.assertThat(addedEmail).isEqualTo(email);
        Assertions.assertThat(addedPassword).isEqualTo(password);
    }

    void assertThatNewElementIsAddedToList(int newNumberOfUsers, int initialNumberOfUsers) {
        Assertions.assertThat(newNumberOfUsers == initialNumberOfUsers + 1).isTrue();
    }
}
