package widgets;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModalDialogTest extends TestBase {

    @ParameterizedTest
    @Tag("widgets")
    @CsvSource({"John Smith, john@smith.com, password",
            "John Adams, john@adams.com, password"})
    void createNewUser(String name, String email, String password) {
        openWebsite("http://www.seleniumui.moderntester.pl/modal-dialog.php");

        ModalDialogMethods modalDialogMethods = new ModalDialogMethods(driver);

        List<WebElement> initialUsers = modalDialogMethods.findUsersList();
        int initialNumberOfUsers = initialUsers.size();

        modalDialogMethods.clickCreateUserButton();
        modalDialogMethods.clearAndSendKeysToNameInput(name);
        modalDialogMethods.clearAndSendKeysToEmailInput(email);
        modalDialogMethods.clearAndSendKeysToPasswordInput(password);
        modalDialogMethods.clickCreateAccountButton();

        List<WebElement> currentUsers = modalDialogMethods.findUsersList();
        int newNumberOfUsers = currentUsers.size();
        modalDialogMethods.assertThatNewElementIsAddedToList(newNumberOfUsers, initialNumberOfUsers);
        modalDialogMethods.assertThatAddedDataIsCorrect(currentUsers, name, email, password);

    }

}
