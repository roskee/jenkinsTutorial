package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SauceDemoHomePage {
    public static final String HOME_PAGE_URL="https://www.saucedemo.com/inventory.html";
    final WebDriver driver;
    @FindBy(id = "react-burger-menu-btn") WebElement menuBtn;
    By logoutBtn = By.id("logout_sidebar_link");
    @FindBy(xpath = "//button[starts-with(@id,'add-to-cart')]")
            // mobile apium
    List<WebElement> addToCartBtns;
    @FindBy(xpath = "//a[@class='shopping_cart_link']") WebElement addToCartCounter;
    By removeBtns = By.xpath("//button[starts-with(@id,'remove')]");
    public SauceDemoHomePage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    public void clickAddToCartBtn(int index){
        if(index<addToCartBtns.size() && index>-1) addToCartBtns.get(index).click();
    }
    public void clickAddToCartBtns(){
        for(WebElement btn : addToCartBtns) btn.click();
    }
    public int addToCartBtnsSize(){
        return addToCartBtns.size();
    }
    public String addToCartCounterText(){
        return addToCartCounter.getText();
    }
    public void clickAddToCartCounter(){
        addToCartCounter.click();
    }
    public void clickRemoveBtn(int index){
        List<WebElement> btns = driver.findElements(removeBtns);
        if(index<btns.size() && index>-1) btns.get(index).click();
    }
    public void openMenu(){
        menuBtn.click();
    }
    public void clickLogoutBtn(){
        WebElement logout = driver.findElement(logoutBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();

    }
    public int removeBtnsSize(){
        return driver.findElements(removeBtns).size();
    }
}
