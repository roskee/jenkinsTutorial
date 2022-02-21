package sauceDemo.pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    public static final String CHECKOUT_COMPLETE_URL="https://www.saucedemo.com/checkout-complete.html";
    @FindBy(id = "back-to-products")
    WebElement backToProductsBtn;
    WebDriver driver;
    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickBackToProductsBtn(){
        backToProductsBtn.click();
    }
}
