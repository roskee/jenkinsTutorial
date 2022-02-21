package sauceDemo.testers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sauceDemo.pages.SauceDemoLoginPage;

public class LaunchTester {
    WebDriver driver;
    @BeforeClass
    public void f() {
        driver = TestArguments.getInstance().driver;
    }

    @Test(priority = 0)
    public void launchBrowser() {
        driver.get(SauceDemoLoginPage.LOGIN_PAGE_URL);
    }

}
