package hotline;

import common.BaseTest;
import core.hotline.HotlineMainPage;
import org.junit.Assert;
import org.junit.Test;


import java.util.List;

public class HotlineTestSuite extends BaseTest {

    @Test

    public void checkFilterItems() {
        final String[] expectedFilterItems = {
                "Автозапчасти",
                "Шины и диски",
                "Автозвук, видео, навигация",
                "Автоэлектрика и электроника",
                "Автохимия, масла",
                "Автооборудование",
                "Тюнинг",
                "Автомобили",
                "Мото, скутеры"
        };
        getDriver().get("https://hotline.ua/");
        HotlineMainPage hotlineMainPage = new HotlineMainPage(getDriver());
        hotlineMainPage.openAutoAndMotoPage();
        final List<String> actualFilterItems = hotlineMainPage.getFilterItemsTextList();
        Assert.assertArrayEquals("There are incorrect items displayed!",
                expectedFilterItems, actualFilterItems.toArray());

    }
}
