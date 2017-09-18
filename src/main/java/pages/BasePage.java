package pages;

import org.openqa.selenium.*;

import static junit.framework.TestCase.assertEquals;


public class BasePage {
    WebDriver driver;

    public void waitForJqueryComplete() {
        try {
            JavascriptExecutor executer = (JavascriptExecutor) driver;
            Boolean jqueryDone = false;
            do {
                Thread.sleep(500);
                jqueryDone = (Boolean) executer.executeScript("return jQuery.active == 0");
            } while (!jqueryDone);
        } catch (InterruptedException e) {
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void notClearFillField(WebElement element, String value) {
        element.sendKeys(value);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkFillField(String value, WebElement element) {
        assertEquals(value, element.getAttribute("value"));
    }
}
