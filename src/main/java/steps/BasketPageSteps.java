package steps;

import pages.BasketPage;
import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.AssertJUnit.assertEquals;
import static steps.BaseSteps.getDriver;

public class BasketPageSteps {

    @Step("проверка товаров в корзине")
    public void checkCountBasketItems() {
        assertEquals(
                new BasketPage(getDriver()).getCountBasketItems(),
                SearchPage.basketCount
        );
    }

    @Step("удаление всех товаров в корзине")
    public void deleteBasketItems() {
        new BasketPage(getDriver()).deleteBasketItems();
    }

    @Step("проверка на отсутствие товаров в корзине")
    public void checkEmptyBasketItems() {
        assertEquals(
                new BasketPage(getDriver()).getCountBasketItems(),
                0
        );
    }

}
