package sauceDemo.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutStep2Page {
    public static final String CHECKOUT_STEP_2_URL="https://www.saucedemo.com/checkout-step-two.html";
    final WebDriver driver;
    @FindBy(className = "cart_item")
    List<WebElement> cartItems;
    @FindBy(id = "finish") WebElement finishBtn;
    public CheckoutStep2Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public int getCartItemsSize(){
        return cartItems.size();
    }
    public void clickFinishBtn(){
        finishBtn.click();
    }
}
