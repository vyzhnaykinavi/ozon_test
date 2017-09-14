package steps;


import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Step;
import static steps.BaseSteps.getDriver;

public class SearchPageSteps {

    @Step("прокрутка до конца страницы")
    public void scrollToEndPage(){
        new SearchPage(getDriver()).scrollToEndPage();
    }

    @Step("выделение четных элементов")
    public void selectOddSearchItems(){
        new SearchPage(getDriver()).selectOddSearchItems();
    }

}
