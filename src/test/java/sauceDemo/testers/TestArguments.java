package sauceDemo.testers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestArguments {
    private static TestArguments arguments;
    WebDriver driver;
    private TestArguments(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }
    public static TestArguments getInstance(){
        if(arguments == null) arguments = new TestArguments();
        return  arguments;
    }

}
