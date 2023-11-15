package basic;

import base.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class WindowsAndTabsTest extends TestBase {
    @Test
    @Tag("basic")
    void switchBetweenWindows() {
        openWebsite("http://www.seleniumui.moderntester.pl/windows-tabs.php");

        WindowsAndTabsMethods windowsAndTabsMethods = new WindowsAndTabsMethods();
        String mainWindowHandle = driver.getWindowHandle();

        driver.findElement(By.cssSelector("#newBrowserWindow")).click();
        windowsAndTabsMethods.switchToNewWindow(driver);
        windowsAndTabsMethods.executeStepsFromTablesExercise(driver);
        windowsAndTabsMethods.closeNewWindowAndSwitchBackToMain(driver, mainWindowHandle);

        driver.findElement(By.cssSelector("#newMessageWindow")).click();
        windowsAndTabsMethods.switchToNewWindow(driver);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        windowsAndTabsMethods.closeNewWindowAndSwitchBackToMain(driver, mainWindowHandle);

        driver.findElement(By.cssSelector("#newBrowserTab")).click();
        windowsAndTabsMethods.switchToNewWindow(driver);
        windowsAndTabsMethods.executeStepsFromTablesExercise(driver);
        windowsAndTabsMethods.closeNewWindowAndSwitchBackToMain(driver, mainWindowHandle);

    }
}
