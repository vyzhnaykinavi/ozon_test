package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(className = "eFooter_Table")
    public WebElement footer;

    public static int basketCount = 0;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void scrollToEndPage() {

        try {
            for (int i = 0; i <= 50; i++) {
                WebElement footerElement = driver.findElement(By.className("eFooter_Table"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", footerElement);

                waitForJqueryComplete();

                //WebElement loadingIndicator = driver.findElement(By.className("mLoading"));
            }
        } catch (NoSuchElementException e) {
        }
    }

    public void selectOddSearchItems() {
        List<WebElement> items = driver.findElements(By.className("mAddToCart"));
        int i = 0;
        for (WebElement item : items) {
            if (item.isDisplayed()) {
                i++;
                if (i % 2 == 0) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", item);
                    item.click();
                    basketCount++;
                    if (basketCount==10){
                        break;
                    }
                }
            }
        }
    }


}
