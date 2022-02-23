package sauceDemo.testers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ExitTester {
    WebDriver driver;
    @Test()
    public void closeBrowser() {
        driver = TestArguments.getInstance().driver;
        driver.quit();
    }
}

