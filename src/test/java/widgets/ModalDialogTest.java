package widgets;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModalDialogTest extends TestBase {

    @ParameterizedTest
    @Tag("widgets")
    @CsvSource({"John Smith, john@smith.com, password",
    "John Adams, john@adams.com, password"})
    void createNewUser(String name, String email, String password) {
        openWebsite("http://www.seleniumui.moderntester.pl/modal-dialog.php");

        ModalDialogMethods modalDialogMethods = new ModalDialogMethods();

        List<WebElement> initialUsers = modalDialogMethods.findUsersList(driver);
        int initialNumberOfUsers = initialUsers.size();

        modalDialogMethods.clickCreateUserButton(driver);
        modalDialogMethods.clearAndSendKeysToNameInput(driver, name);
        modalDialogMethods.clearAndSendKeysToEmailInput(driver, email);
        modalDialogMethods.clearAndSendKeysToPasswordInput(driver, password);
        modalDialogMethods.clickCreateAccountButton(driver);

        List<WebElement> currentUsers = modalDialogMethods.findUsersList(driver);
        int newNumberOfUsers = currentUsers.size();
        modalDialogMethods.assertThatNewElementIsAddedToList(newNumberOfUsers, initialNumberOfUsers);
        modalDialogMethods.assertThatAddedDataIsCorrect(currentUsers, name, email, password);

    }

}
