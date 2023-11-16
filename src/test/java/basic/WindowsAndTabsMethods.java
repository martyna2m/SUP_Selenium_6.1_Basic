package basic;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowsAndTabsMethods {

    String mainWindowHandle;
    WebDriver driver;

    public WindowsAndTabsMethods(WebDriver driver) {
        this.driver = driver;
    }

    void switchToNewWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
    }


    void switchToMainWindow(String mainWindowHandle) {
        driver.switchTo().window(mainWindowHandle);
    }

    void closeNewWindowAndSwitchBackToMain(String mainWindowHandle) {
        driver.close();
        switchToMainWindow(mainWindowHandle);
    }

    void executeStepsFromTablesExercise() {
        TableTest tableTest = new TableTest();
        System.out.println(tableTest.iterateOnRows(driver, "Switzerland", 4000));
    }


}
