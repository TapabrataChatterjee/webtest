package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {

    WebDriver driver;


    public void invokeDriver() throws IOException
    {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/data.properties");

        properties.load(fileInputStream);

        String browserName = properties.getProperty("browser");
        // System.out.println("Reading:"+browserName);
        switch (browserName) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", "/Users/Anindita/chromedriver_mac");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);
                System.out.println("Chrome driver selected" + driver);
                break;
            }
            case "firefox": {
                System.setProperty("webdriver.gecko.driver", "/Users/Anindita/geckodriver 2");
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("headless");
                driver=new RemoteWebDriver(new URL("http://13.137.172.118:4444"),options);
             //   driver = new FirefoxDriver();
                driver.get("https://google.com");
                break;
            }
            default: {
                System.out.println("No Specific driver");
            }
        }


    }
    
}
