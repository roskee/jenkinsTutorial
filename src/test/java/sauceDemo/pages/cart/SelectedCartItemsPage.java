package sauceDemo.pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectedCartItemsPage {
    public static final String CART_ITEMS_URL= "https://www.saucedemo.com/cart.html";
    final WebDriver driver;
    @FindBy(className = "cart_item")
    List<WebElement> cartItems;
    @FindBy(id = "continue-shopping") WebElement backToHomeBtn;
    @FindBy(id = "checkout")
    WebElement checkoutBtn;
    public SelectedCartItemsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public int cartItemsSize(){
        return cartItems.size();
    }
    public void clickBackToHomeBtn(){
        backToHomeBtn.click();
    }
    public void clickCheckoutBtn(){
        checkoutBtn.click();;
    }
}
