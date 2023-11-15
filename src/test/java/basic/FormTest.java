package basic;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class FormTest extends TestBase {
    FormMethods formMethods = new FormMethods();

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/formData.csv", numLinesToSkip = 1)
    @Tag("basic")
    void fillTheFormTest(String firstName, String lastName, String email, String age) {
        openWebsite("http://www.seleniumui.moderntester.pl/form.php");
        formMethods.fillTheForm(driver, firstName, lastName, email, age);

    }


}
