package sauceDemo.testers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;
public class TestArguments {
    private static TestArguments arguments;
    public static final String CHROME_DRIVER="chromedriver";
    public static final String FIREFOX_DRIVER="geckodriver";
    WebDriver driver;
    private TestArguments(){
        String browser = System.getProperty("browser");
        if(browser==null || (!browser.equalsIgnoreCase("chrome") && !browser.equalsIgnoreCase("firefox"))) browser = "chrome";
        browser = browser.toLowerCase(Locale.ROOT);
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER);
                driver = new FirefoxDriver();
        }
    }
    public static TestArguments getInstance(){
        if(arguments == null) arguments = new TestArguments();
        return  arguments;
    }

}
