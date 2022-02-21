package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SauceDemoHomePage {
    public static final String HOME_PAGE_URL="https://www.saucedemo.com/inventory.html";
    final WebDriver driver;
    @FindBy(xpath = "//button[starts-with(@id,'add-to-cart')]")
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
    public int removeBtnsSize(){
        return driver.findElements(removeBtns).size();
    }
}
