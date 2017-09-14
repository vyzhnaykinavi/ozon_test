package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestProperties;

public class MainPage extends BasePage {

    @FindBy(className = "bPanelLinks")
    WebElement menuItems;

    @FindBy(css = "bPanelLinks > bPopupHint")
    WebElement menuMyOzonItems;

    @FindBy(name = "login")
    WebElement inputLogin;

    @FindBy(name = "Password")
    WebElement inputPassword;

    @FindBy(className = "jsLoginWindowButton")
    WebElement buttonAuthSubmit;

    @FindBy(className = "mSearchButton")
    public WebElement buttonSearch;

    @FindBy(name = "SearchText")
    public WebElement inputSearchText;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMenuItem(String itemName) {
        Actions actions = new Actions(driver);
        WebElement element = menuItems.findElement(By.xpath(".//*[contains(text(),'" + itemName + "')]"));
        if (itemName.equals("Мой OZON")
            || itemName.equals(TestProperties.getInstance().getProperties().getProperty("name"))
        ) {
            actions.moveToElement(element).build().perform();
        } else {
            element.click();
        }
    }

    public void selectMenuMyOzonItem(String itemName) {
        menuItems.findElement(By.xpath(".//*[contains(text(),'" + itemName + "')]")).click();
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Логин":
                fillField(inputLogin, value);
                break;
            case "Пароль":
                fillField(inputPassword, value);
                break;
            case "Поиск":
                notClearFillField(inputSearchText, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Логин":
                return inputLogin.getAttribute("value");
            case "Пароль":
                return inputPassword.getAttribute("value");
            case "Поиск":
                return inputSearchText.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void submitFormAuth() {
        buttonAuthSubmit.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
