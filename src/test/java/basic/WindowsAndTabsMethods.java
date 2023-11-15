package basic;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowsAndTabsMethods {

    String mainWindowHandle;

    void switchToNewWindow(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
    }


    void switchToMainWindow(WebDriver driver, String mainWindowHandle) {
        driver.switchTo().window(mainWindowHandle);
    }

    void closeNewWindowAndSwitchBackToMain(WebDriver driver, String mainWindowHandle) {
        driver.close();
        switchToMainWindow(driver, mainWindowHandle);
    }

    void executeStepsFromTablesExercise(WebDriver driver) {
        TableTest tableTest = new TableTest();
        System.out.println(tableTest.iterateOnRows(driver, "Switzerland", 4000));
    }


}
