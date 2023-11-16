package widgets;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DatapickerMethods {

    WebDriver driver;

    public DatapickerMethods(WebDriver driver) {
        this.driver = driver;
    }

    void selectPickedDateInCalendar(String dateToPick) {
        openCalendar();
        navigateToYear(dateToPick);
        navigateToMonth(dateToPick);
        chooseDayInCalendar(dateToPick);
    }


    private void openCalendar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#datepicker"))));
        dateInput.click();
    }

    private void navigateToYear(String dateToPick) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        int yearToPick = extractYearToPick(dateToPick);
        int currentYear = Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ui-datepicker-year")))).getText());


        while (currentYear > yearToPick) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".ui-datepicker-prev")))).click();
            currentYear = Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ui-datepicker-year")))).getText());
        }

        while (currentYear < yearToPick) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".ui-datepicker-next")))).click();
            currentYear = Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ui-datepicker-year")))).getText());
        }

    }


    private void navigateToMonth(String dateToPick) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        int monthToPick = extractMonthToPick(dateToPick);
        int currentMonth = getIndexOfMonth(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ui-datepicker-month")))).getText());

        while (currentMonth > monthToPick) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".ui-datepicker-prev")))).click();
            currentMonth = getIndexOfMonth(driver.findElement(By.cssSelector(".ui-datepicker-month")).getText());
        }

        while (currentMonth < monthToPick) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".ui-datepicker-next")))).click();
            currentMonth = getIndexOfMonth(driver.findElement(By.cssSelector(".ui-datepicker-month")).getText());
        }


    }

    private int extractMonthToPick(String dateToPick) {
        String[] dateElements = dateToPick.split("/");
        return Integer.parseInt(dateElements[0]);
    }

    private int extractDayToPick(String dateToPick) {
        String[] dateElements = dateToPick.split("/");
        return Integer.parseInt(dateElements[1]);
    }

    private int extractYearToPick(String dateToPick) {
        String[] dateElements = dateToPick.split("/");
        return Integer.parseInt(dateElements[2]);
    }


    private void chooseDayInCalendar(String dateToPick) {

        int monthToPick = extractMonthToPick(dateToPick);
        String dayToPick = String.valueOf(extractDayToPick(dateToPick));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> daysOfMonth = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(".ui-state-default"))));
        for (WebElement day : daysOfMonth) {
            if ((day.getText()).equals(dayToPick)) {
                if (day.findElement(By.xpath("parent::*")).getAttribute("data-month").equals(String.valueOf(monthToPick - 1))) {
                    day.click();
                    break;
                }
            }
        }

    }

    void assertPickedDate(String pickedDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#datepicker"))));

        Assertions.assertThat(dateInput.getAttribute("value")).contains(pickedDate);

    }

    private int getIndexOfMonth(String month) {
        switch (month.toLowerCase()) {
            case "january" -> {
                return 1;
            }
            case "february" -> {
                return 2;
            }

            case "march" -> {
                return 3;
            }

            case "april" -> {
                return 4;
            }

            case "may" -> {
                return 5;
            }

            case "june" -> {
                return 6;
            }

            case "july" -> {
                return 7;
            }

            case "august" -> {
                return 8;
            }

            case "september" -> {
                return 9;
            }

            case "october" -> {
                return 10;
            }

            case "november" -> {
                return 11;
            }

            case "december" -> {
                return 12;
            }
            default -> {
                return 0;
            }

        }
    }
}


