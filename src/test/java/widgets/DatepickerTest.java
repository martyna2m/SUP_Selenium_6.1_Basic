package widgets;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

public class DatepickerTest extends TestBase {
    @RepeatedTest(3)
    @Tag("widgets")
    void pickDateTest() {

        DatapickerMethods datapickerMethods = new DatapickerMethods(driver);

        openWebsite("http://www.seleniumui.moderntester.pl/datepicker.php");


        datapickerMethods.selectPickedDateInCalendar("10/18/2020");
        datapickerMethods.assertPickedDate("10/18/2020");

        datapickerMethods.selectPickedDateInCalendar("1/17/2022");
        datapickerMethods.assertPickedDate("1/17/2022");

        datapickerMethods.selectPickedDateInCalendar("5/30/2024");
        datapickerMethods.assertPickedDate("5/30/2024");

    }

}

