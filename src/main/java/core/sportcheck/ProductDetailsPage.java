package core.sportcheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {

    @FindBy(xpath = "//h1[@class='global-page-header__title']")
    private WebElement productTitle;

    @FindBy(xpath = "//select[@data-control-type='size']")
    private WebElement selectSizeDropdown;

    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement selectQty;

    @FindBy(xpath = "//button[contains(@class,'add-cart product-detail__button')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(@class,'header-cart__trigger')]")
    private WebElement miniCartItemsCount;

    @FindBy(xpath = "//section[@class='cart-item]/a[@data-action='goToProductDetailsPage']")
    private WebElement miniCartPopupTitle;

    @FindBy(xpath = "//dd[@class='cart-item__detail__description']")
    private WebElement miniCartPopupQty;

    private WebDriver webdriver;

    private Actions actions;

    public ProductDetailsPage(final WebDriver driver){
        this.webdriver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectProductSize(final Integer productSizeIndex){
        final Select sizeSelect = new Select(selectSizeDropdown);
        sizeSelect.selectByIndex(productSizeIndex);
    }

    public void selectProductQty(final Integer productQtyIndex){
        final Select productQtySelect = new Select(selectQty);
        productQtySelect.selectByIndex(productQtyIndex);
    }
    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public String getMiniCartPopupTitle(){
        actions.moveToElement(miniCartItemsCount).perform();
        return miniCartPopupTitle.getText();
    }

    public Integer getMiniCartPopupQty(){
        actions.moveToElement(miniCartItemsCount).perform();
        final String productQty = miniCartPopupQty.getText();
        return Integer.parseInt(productQty);
    }

    public String getProductTitle(){
        return productTitle.getText();
    }
}
