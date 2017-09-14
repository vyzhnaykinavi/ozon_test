import org.testng.annotations.Test;
import steps.BaseSteps;
import steps.BasketPageSteps;
import steps.SearchPageSteps;
import steps.MainPageSteps;


import java.util.HashMap;


public class MyRefactoringTest extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    SearchPageSteps searchPageSteps = new SearchPageSteps();
    BasketPageSteps basketPageSteps = new BasketPageSteps();
    HashMap<String, String> authData = new HashMap<>();


    @Test(description = "Проверка корзины OZON")
    public void Test() {
        mainPageSteps.selectMenuItem("Мой OZON");
        mainPageSteps.selectMenuMyOzon("Вход");

        authData.put("Логин", properties.getProperty("login"));
        authData.put("Пароль", properties.getProperty("password"));
        mainPageSteps.fillFields(authData);
        mainPageSteps.checkFillFields(authData);
        mainPageSteps.submitAuthForm();

        mainPageSteps.runSearch("iPhone");

        searchPageSteps.scrollToEndPage();
        searchPageSteps.selectOddSearchItems();
        mainPageSteps.selectMenuItem("Корзина");
        basketPageSteps.checkCountBasketItems();
        basketPageSteps.deleteBasketItems();

        mainPageSteps.selectMenuItem(properties.getProperty("name"));
        mainPageSteps.selectMenuMyOzon("Выйти");
        authData.put("Логин", properties.getProperty("login"));
        authData.put("Пароль", properties.getProperty("password"));
        mainPageSteps.fillFields(authData);
        mainPageSteps.checkFillFields(authData);
        mainPageSteps.submitAuthForm();

        basketPageSteps.checkEmptyBasketItems();
    }
}
