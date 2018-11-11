package core.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage {


    @FindBy(xpath = "//input[@id='lst-ib']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private static final Long ELEMENT_WAIT_TIME_OUT = 30L;

    public GoogleMainPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, ELEMENT_WAIT_TIME_OUT);
        PageFactory.initElements(webDriver, this);
    }

    public SearchResultPage typeSearchText(final String text){
        searchInput.sendKeys(text, Keys.ENTER);
        return new SearchResultPage(webDriver);
    }

    public String getExpectedOkButtonText(){
        return searchButton.getText();
    }


   /* public SearchResultPage clickSearchButton(){
        searchButton.click();
        return new SearchResultPage(webDriver);
    }*/


}
