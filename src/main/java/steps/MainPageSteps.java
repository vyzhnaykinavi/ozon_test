package steps;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;


import static junit.framework.TestCase.assertTrue;
import static steps.BaseSteps.getDriver;

public class MainPageSteps {

    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String menuItem) {
        new MainPage(getDriver()).selectMenuItem(menuItem);
    }

    @Step("выбран пункт {0}")
    public void selectMenuMyOzon(String menuItem) {
        new MainPage(getDriver()).selectMenuMyOzonItem(menuItem);
    }

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value) {
        new MainPage(getDriver()).fillField(field, value);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields) {
        fields.forEach((k, v) -> fillField(k, v));
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value) {
        String actual = new MainPage(getDriver()).getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach((k, v) -> checkFillField(k, v));
    }

    @Step("отправлена форма авторизации")
    public void submitAuthForm() {
        new MainPage(getDriver()).submitFormAuth();
    }

    @Step("отправлен текст для поиска")
    public void runSearch(String searchText) {
        fillField("Поиск", searchText + "\n");
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.textToBePresentInElementValue(
                new MainPage(getDriver()).inputSearchText,
                searchText
        ));
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.elementToBeClickable(
                new MainPage(getDriver()).buttonSearch
        ));
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new MainPage(getDriver()).waitForJqueryComplete();
//        new MainPage(getDriver()).buttonSearch.click();
    }
}
