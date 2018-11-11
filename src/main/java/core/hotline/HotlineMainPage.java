package core.hotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class HotlineMainPage {

    @FindBy(xpath = "//li[@class='level-1 auto']")
    private WebElement openAutoAndMotoCategory;


    @FindBys({

            @FindBy(xpath = "//ul[@class='cell-navigation cell-navigation-tree']//li[@class='item']")})
    private List<WebElement> filterItems;


    private WebDriver webDriver;


    public HotlineMainPage(final WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAutoAndMotoPage(){
        openAutoAndMotoCategory.click();
    }


    public List<String> getFilterItemsTextList() {
        final List<String> filterItemsTextList = new ArrayList<String>();
        for (final WebElement element: filterItems){
            final String text = element.getText();
            filterItemsTextList.add(text);
        }
        return filterItemsTextList;
    }
}
