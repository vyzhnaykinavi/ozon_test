package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'Удалить всё')]")
    WebElement deleteItems;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int getCountBasketItems() {
        List<WebElement> items = driver.findElements(By.className("bCartItem"));
        int i = 0;
        for (WebElement item : items) {
            if (item.isDisplayed()) {
                i++;
            }
        }
        return i;
    }

    public void deleteBasketItems() {
        deleteItems.click();
    }

}
