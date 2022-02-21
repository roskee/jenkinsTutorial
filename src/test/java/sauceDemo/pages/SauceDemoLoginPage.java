package sauceDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPage {
    final WebDriver driver;
    public static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    public static final String USER_NAME = "standard_user";
    public static final String PASSWORD="secret_sauce";
    @FindBy(id = "user-name")
    WebElement usernameField;
    @FindBy(id="password") WebElement passwordField;
    @FindBy(name = "login-button") WebElement loginButton;
    public SauceDemoLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
}
