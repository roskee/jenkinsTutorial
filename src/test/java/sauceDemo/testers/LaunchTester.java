package sauceDemo.testers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sauceDemo.pages.SauceDemoLoginPage;

import java.util.Properties;

public class LaunchTester {
    WebDriver driver;

    @Test(priority = 0)
    public void launchBrowser() {
        driver = TestArguments.getInstance().driver;
        String env = System.getProperty("env");
        if(env == null) env = SauceDemoLoginPage.ENVIRONMENT;
        driver.get(
                SauceDemoLoginPage.URL_LEADING
                        + SauceDemoLoginPage.URL_MAIN
                        +env
                        + SauceDemoLoginPage.URL_ENDING);
    }

}
