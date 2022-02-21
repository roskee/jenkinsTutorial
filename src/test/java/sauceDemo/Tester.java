package sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sauceDemo.cart.CheckoutCompletePage;
import sauceDemo.cart.CheckoutStep1Page;
import sauceDemo.cart.CheckoutStep2Page;
import sauceDemo.cart.SelectedCartItemsPage;

public class Tester {

    public WebDriver driver;

    @BeforeClass
    public void f() {
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test(priority = 0)
    public void launchBrowser() {
        driver.get(SauceDemoLoginPage.LOGIN_PAGE_URL);
    }

    @Test(priority = 1)
    public void Login() {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.enterUsername(SauceDemoLoginPage.USER_NAME);
        loginPage.enterPassword(SauceDemoLoginPage.PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), SauceDemoHomePage.HOME_PAGE_URL);
    }

    @Test(priority = 2)
    public void addItemsToCart() {
        SauceDemoHomePage homePage = new SauceDemoHomePage(driver);
        Assert.assertEquals(homePage.addToCartCounterText(), "");
        int addToCartBtnsSize = homePage.addToCartBtnsSize();
        homePage.clickAddToCartBtns();
        Assert.assertEquals(Integer.parseInt(homePage.addToCartCounterText()), addToCartBtnsSize);
        homePage.clickAddToCartCounter();
        Assert.assertEquals(driver.getCurrentUrl(), SelectedCartItemsPage.CART_ITEMS_URL);
        SelectedCartItemsPage cartItemsPage = new SelectedCartItemsPage(driver);

        Assert.assertEquals(cartItemsPage.cartItemsSize(), addToCartBtnsSize);
        cartItemsPage.clickBackToHomeBtn();
        Assert.assertEquals(driver.getCurrentUrl(), SauceDemoHomePage.HOME_PAGE_URL);

    }

    @Test(dependsOnMethods = {"addItemsToCart"})
    public void removeItemFromCart() {
        SauceDemoHomePage homePage = new SauceDemoHomePage(driver);
        int removeBtnsSize = homePage.removeBtnsSize();
        homePage.clickRemoveBtn(0);
        Assert.assertEquals(Integer.parseInt(homePage.addToCartCounterText()) + 1, removeBtnsSize);
    }

    @Test(dependsOnMethods = "removeItemFromCart")
    public void checkoutItems() {
        SauceDemoHomePage homePage = new SauceDemoHomePage(driver);
        int cartSize = Integer.parseInt(homePage.addToCartCounterText());
        homePage.clickAddToCartCounter();
        Assert.assertEquals(driver.getCurrentUrl(), SelectedCartItemsPage.CART_ITEMS_URL);
        SelectedCartItemsPage cartItemsPage = new SelectedCartItemsPage(driver);
        cartItemsPage.clickCheckoutBtn();
        Assert.assertEquals(driver.getCurrentUrl(), CheckoutStep1Page.CHECKOUT_STEP_1_URL);
        CheckoutStep1Page step1Page = new CheckoutStep1Page(driver);
        step1Page.enterFirstName("firstname");
        step1Page.enterLastName("lastname");
        step1Page.enterPostalCode("postalcode");
        step1Page.clickContinueBtn();
        Assert.assertEquals(driver.getCurrentUrl(), CheckoutStep2Page.CHECKOUT_STEP_2_URL);
        CheckoutStep2Page step2Page = new CheckoutStep2Page(driver);

        Assert.assertEquals(step2Page.getCartItemsSize(), cartSize);
        step2Page.clickFinishBtn();
        Assert.assertEquals(driver.getCurrentUrl(), CheckoutCompletePage.CHECKOUT_COMPLETE_URL);

    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}