package basic;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class WindowsAndTabsTest extends TestBase {
    @RepeatedTest(3)
    @Tag("basic")
    void switchBetweenWindows() {
        openWebsite("http://www.seleniumui.moderntester.pl/windows-tabs.php");


        WindowsAndTabsMethods windowsAndTabsMethods = new WindowsAndTabsMethods(driver);
        String mainWindowHandle = driver.getWindowHandle();

        driver.findElement(By.cssSelector("#newBrowserWindow")).click();
        windowsAndTabsMethods.switchToNewWindow();
        windowsAndTabsMethods.executeStepsFromTablesExercise();
        windowsAndTabsMethods.closeNewWindowAndSwitchBackToMain(mainWindowHandle);

        driver.findElement(By.cssSelector("#newMessageWindow")).click();
        windowsAndTabsMethods.switchToNewWindow();
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        windowsAndTabsMethods.closeNewWindowAndSwitchBackToMain(mainWindowHandle);

        driver.findElement(By.cssSelector("#newBrowserTab")).click();
        windowsAndTabsMethods.switchToNewWindow();
        windowsAndTabsMethods.executeStepsFromTablesExercise();
        windowsAndTabsMethods.closeNewWindowAndSwitchBackToMain(mainWindowHandle);

    }
}
