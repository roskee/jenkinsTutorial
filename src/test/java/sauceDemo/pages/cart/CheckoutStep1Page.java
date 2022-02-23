package sauceDemo.pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStep1Page {
    public static final String CHECKOUT_STEP_1_URL="https://www.saucedemo.com/checkout-step-one.html";
    final WebDriver driver;
    @FindBy(id = "first-name") WebElement firstNameFld;
    @FindBy(id = "last-name") WebElement lastNameFld;
    @FindBy(id = "postal-code") WebElement postalCodeFld;
    @FindBy(id = "continue") WebElement continueBtn;

    public CheckoutStep1Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void enterFirstName(String firstName){
        firstNameFld.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        lastNameFld.sendKeys(lastName);
    }
    public void enterPostalCode(String postalCode){
        postalCodeFld.sendKeys(postalCode);
    }
    public void clickContinueBtn(){
        continueBtn.click();
    }
}
