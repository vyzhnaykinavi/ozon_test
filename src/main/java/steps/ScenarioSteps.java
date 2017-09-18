package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();

    BasketPageSteps basketPageSteps = new BasketPageSteps();

    SearchPageSteps searchPageSteps = new SearchPageSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuItem) {
        mainPageSteps.selectMenuItem(menuItem);
    }

    @When("^выбран подпункт \"(.+)\"$")
    public void selectMenuInsurance(String menuItem) {
        mainPageSteps.selectMenuMyOzon(menuItem);
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> mainPageSteps.fillField(field, value));

    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> mainPageSteps.checkFillField(field, value));
    }

    @When("^отправлена форма авторизации$")
    public void submitAuthForm() {
        mainPageSteps.submitAuthForm();
    }
    




    @When("^введен поиск \"(.+)\"$")
    public void runSearch(String searchStr) {
        mainPageSteps.runSearch(searchStr);
    }
    @When("^страница проматывается до самого конца$")
    public void scrollToEndPage() {
        searchPageSteps.scrollToEndPage();
    }
    @When("^выбраны все четные товары$")
    public void selectOddSearchItems() {
        searchPageSteps.selectOddSearchItems();
    }
    @Then("^корзина соответствует выделенным товарам$")
    public void checkCountBasketItems() {
        basketPageSteps.checkCountBasketItems();
    }
    @When("^очищается корзина$")
    public void deleteBasketItems() {
        basketPageSteps.deleteBasketItems();

    }

          @Then("^корзина пуста$")
    public void checkEmptyBasketItems() {
        basketPageSteps.checkEmptyBasketItems();
    }














}




