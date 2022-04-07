package cucumber.Cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties prop;

    public static WebDriver getDriver() throws IOException
    {
        prop=new Properties();
        FileInputStream fis=new FileInputStream("/Users/alexandru.badescu/IdeaProjects/Interview Project/src/test/resources/env/env-local.properties");
        prop.load(fis);

        System.setProperty("webdriver.chrome.driver", "/Users/alexandru.badescu/Downloads/Automation/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("baseurl"));
        return driver;
    }
}
