package google;

import common.BaseTest;
import core.google.GoogleMainPage;
import core.google.SearchResultPage;
import org.junit.Assert;
import org.junit.Test;


public class GoogleTestSuite extends BaseTest {

    @Test
    public void checkGoogleMainPageIsOpened() {
        final String expectedTitle = "Google";
        getDriver().get("https://www.google.com/");
        final String actualTitle = getDriver().getTitle();
        Assert.assertEquals("There is incorrect page title!", expectedTitle, actualTitle);

    }

    @Test
    public void checkGoogleSearchFunctionality() {
        final String expectedFirstLinkText = "Компьютерная школа Hillel: курсы IT технологий";

        //1. Открываем главную страницу браузера
        getDriver().get("https://google.com");

        //2. Создаем объект главной страницы гугл
        final GoogleMainPage page = new GoogleMainPage(getDriver());

        //3. Вводим искомое слово в поисковик и жмем Enter button
        final SearchResultPage searchResultPage = page.typeSearchText("Hillel");

        /*4. Возвращаем новую страницу с результатами поиска
        final SearchResultPage searchResultPage = page.clickSearchButton();*/

        //4. Получаем текст первой ссылки со списка результата
        final String actualFirstLinkText = searchResultPage.getFirstSearchResultLinkText();

        //5. Сравниваем полученный с ожидаемым результатом
        Assert.assertEquals("There is incorrect first link text displayed",
                expectedFirstLinkText, actualFirstLinkText);


    }




}
