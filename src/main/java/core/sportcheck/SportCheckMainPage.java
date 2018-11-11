package core.sportcheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class SportCheckMainPage {

        @FindBy(xpath = "//span[@class='menu-toggle__text']")
        private WebElement burgerButton;

        @FindBys({@FindBy(xpath = "//ul[@class='page-nav__list page-nav__list_short main-menu']//li[@class='page-nav__item']")})

        private List<WebElement> filterItems;

        @FindBy(xpath = "//div[@class='container']//div[@class='header-account__trigger']")
        private WebElement signInForm;

        @FindBy(xpath = "//div[@class='header-account__sign-in__register']//a[@class='header-account__sign-in__register__link']")
        private WebElement registerButton;

        @FindBy(xpath = "(//li[@class='rfk_product'])[1]//a")
        private WebElement firstPickedJustForYouItem;

        private WebDriver webDriver;

        public SportCheckMainPage(final WebDriver driver){
            this.webDriver = driver;
            PageFactory.initElements(webDriver, this);
        }

        public void expandFilterBox() {
            burgerButton.click();
        }

        public List<String> getFilterItemsTextList() {
            final List<String> filterItemsTextList = new ArrayList<String>();
            for (final WebElement element: filterItems){
                final String text = element.getText();
                filterItemsTextList.add(text);
            }
            return filterItemsTextList;
        }


        public ProductDetailsPage selectFirstElementFromThePickedJustForYouSection(){
            firstPickedJustForYouItem.click();
            return new ProductDetailsPage(webDriver);
    }

        public RegisterFormPage ExpandSignInAndClickRegistrationButton(){
            signInForm.click();
            registerButton.click();
            return new RegisterFormPage(webDriver);
    }


    }

