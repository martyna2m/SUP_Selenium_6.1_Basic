package other;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

public class HighSiteTest extends TestBase {


    @RepeatedTest(3)
    @Tag("other")
    void takeScreenShotWhenSubmitButtonIsVisibleUsingScroll() {
        HighSiteMethods highSiteMethods = new HighSiteMethods(driver);
        openWebsite("http://www.seleniumui.moderntester.pl/high-site.php");
        highSiteMethods.scrollUntilButtonVisibleActions();
        highSiteMethods.takeScreenShot();

    }

    @RepeatedTest(3)
    @Tag("other")
    void takeScreenShotWhenSubmitButtonIsVisibleUsingJS() {
        HighSiteMethods highSiteMethods = new HighSiteMethods(driver);
        openWebsite("http://www.seleniumui.moderntester.pl/high-site.php");
        highSiteMethods.scrollUntilButtonVisibleJS();
        highSiteMethods.takeScreenShot();
    }


}

