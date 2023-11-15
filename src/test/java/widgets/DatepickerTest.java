package widgets;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

public class DatepickerTest extends TestBase {
    @RepeatedTest(3)
    @Tag("widgets")
    void pickDateTest() {

        DatapickerMethods datapickerMethods = new DatapickerMethods();

        openWebsite("http://www.seleniumui.moderntester.pl/datepicker.php");


        datapickerMethods.selectPickedDateInCalendar(driver, "10/18/2020");
        datapickerMethods.assertPickedDate(driver, "10/18/2020");

        datapickerMethods.selectPickedDateInCalendar(driver, "1/17/2022");
        datapickerMethods.assertPickedDate(driver, "1/17/2022");

        datapickerMethods.selectPickedDateInCalendar(driver, "5/30/2024");
        datapickerMethods.assertPickedDate(driver, "5/30/2024");

    }

}

