package core.sportcheck;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterFormPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//input[@placeholder='Email (e.g. name@example.com)']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@name='loginConfirmation']")
    WebElement inputEmailConfirmation;

    @FindBy(xpath = "//input[@placeholder='Password (six characters minimum)']")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    WebElement inputPasswordConfirm;

    @FindBy(xpath = "//span[contains(.,'Please enter your email address in this format: name@example.com')]")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//span[contains(.,'Your password must be 6-40 characters long.')]")
    WebElement passwordErrorMessage;



    public RegisterFormPage(final WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }


    public void typeInvalidEmailAddress(final String text){
        inputEmail.sendKeys(text, Keys.TAB);

    }

    public void typeInvalidEmailConfirmation(final String text){
        inputEmailConfirmation.sendKeys(text, Keys.TAB);

    }

    public void typeInvalidPassword(final String text){
        inputPassword.sendKeys(text, Keys.TAB);
    }

    public void typeInvalidPasswordConfirmation(final String text){
        inputPasswordConfirm.sendKeys(text, Keys.TAB);

    }

    public String getEmailErrorMessage(){
       return emailErrorMessage.getText();
    }

    public String getPasswordErrorMessage(){
        return passwordErrorMessage.getText();
    }

}
