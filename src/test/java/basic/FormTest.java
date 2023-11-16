package basic;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class FormTest extends TestBase {


    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/formData.csv", numLinesToSkip = 1)
    @Tag("basic")
    void fillTheFormTest(String firstName, String lastName, String email, String age) {
        openWebsite("http://www.seleniumui.moderntester.pl/form.php");
        FormMethods formMethods = new FormMethods(driver);
        formMethods.fillTheForm(firstName, lastName, email, age);
    }


}
