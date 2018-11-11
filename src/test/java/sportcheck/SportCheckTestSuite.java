package sportcheck;

import common.BaseTest;
import core.sportcheck.ProductDetailsPage;
import core.sportcheck.RegisterFormPage;
import core.sportcheck.SportCheckMainPage;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class SportCheckTestSuite extends BaseTest{
    @Test
    public void checkFilterItems(){
        final String[] expectedFilterItems = {
                "Deals & Features",
                "Men",
                "Women",
                "Kids",
                "Shoes & Footwear",
                "Gear",
                "Electronics",
                "Jerseys & Fan Wear",
                "Sneaker Launches",
                "Shop by Brand",
                "Chek advice"
        };
        getDriver().get("https://www.sportchek.ca/");
        final SportCheckMainPage sportCheckMainPage = new SportCheckMainPage(getDriver());
        sportCheckMainPage.expandFilterBox();
        final List<String> actualFilterItems = sportCheckMainPage.getFilterItemsTextList();
        Assert.assertArrayEquals("There are incorrect items displayed!",
                expectedFilterItems, actualFilterItems.toArray());
    }

    @Test
    public void checkMiniCartProductInfo(){
        getDriver().get("https://www.sportchek.ca/");
        final SportCheckMainPage sportCheckMainPage = new SportCheckMainPage(getDriver());
        final ProductDetailsPage productDetailsPage = sportCheckMainPage.selectFirstElementFromThePickedJustForYouSection();
        productDetailsPage.selectProductSize(1);
        productDetailsPage.selectProductQty(1);
        productDetailsPage.clickAddToCartButton();
        final String productTitleBeforeAddToCart = productDetailsPage.getProductTitle();
        final String productTitleAfterAddToCart = productDetailsPage.getMiniCartPopupTitle();
        final Integer actualProductQty = productDetailsPage.getMiniCartPopupQty();
        Assert.assertEquals("There is incorrect product title displayed!", productTitleBeforeAddToCart, productTitleAfterAddToCart);

    }

    @Test
    public void checkErrorMessageForInvalidEmail(){
        final String expectedErrorMessageText = "Please enter your email address in this format: name@example.com";
        getDriver().get("https://www.sportchek.ca/");
        final SportCheckMainPage sportCheckMainPage = new SportCheckMainPage(getDriver());
        final RegisterFormPage registerFormPage = sportCheckMainPage.ExpandSignInAndClickRegistrationButton();
        registerFormPage.typeInvalidEmailAddress("t");

        final String actualErrorMessageText = registerFormPage.getEmailErrorMessage();

        Assert.assertEquals("There is incorrect first text displayed!", expectedErrorMessageText, actualErrorMessageText);

    }

    @Test
    public void checkErrorMessageForInvalidEmailConfirmation(){
        final String expectedErrorMessageText = "Please enter your email address in this format: name@example.com";
        getDriver().get("https://www.sportchek.ca/");
        final SportCheckMainPage sportCheckMainPage = new SportCheckMainPage(getDriver());
        final RegisterFormPage registerFormPage = sportCheckMainPage.ExpandSignInAndClickRegistrationButton();
        registerFormPage.typeInvalidEmailConfirmation("ttt@gmailcom");

        final String actualErrorMessageText = registerFormPage.getEmailErrorMessage();

        Assert.assertEquals("There is incorrect first text displayed!", expectedErrorMessageText, actualErrorMessageText);

    }


    @Test
    public void checkErrorMessageForInvalidPassword(){
        final String expectedErrorMessageText = "Your password must be 6-40 characters long.";
        getDriver().get("https://www.sportchek.ca/");
        final SportCheckMainPage sportCheckMainPage = new SportCheckMainPage(getDriver());
        final RegisterFormPage registerFormPage = sportCheckMainPage.ExpandSignInAndClickRegistrationButton();
        registerFormPage.typeInvalidPassword("12345");

        final String actualErrorMessageText = registerFormPage.getPasswordErrorMessage();

        Assert.assertEquals("There is incorrect first text displayed!", expectedErrorMessageText, actualErrorMessageText);

    }

    @Test
    public void checkErrorMessageForInvalidPasswordConfirmation() {
        final String expectedErrorMessageText = "Your password must be 6-40 characters long.";
        getDriver().get("https://www.sportchek.ca/");
        final SportCheckMainPage sportCheckMainPage = new SportCheckMainPage(getDriver());
        final RegisterFormPage registerFormPage = sportCheckMainPage.ExpandSignInAndClickRegistrationButton();
        registerFormPage.typeInvalidPasswordConfirmation("hgjDhfkk555884493kkkkfsshhahkdlf!gf800865");

        final String actualErrorMessageText = registerFormPage.getPasswordErrorMessage();

        Assert.assertEquals("There is incorrect first text displayed!", expectedErrorMessageText, actualErrorMessageText);
    }

}
