package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;

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
                driver = new ChromeDriver();
                System.out.println("Chrome driver selected" + driver);
                break;
            }
            case "firefox": {
                System.setProperty("webdriver.gecko.driver", "/Users/Anindita/geckodriver 2");
                driver = new FirefoxDriver();
                driver.get("https://google.com");
                break;
            }
            default: {
                System.out.println("No Specific driver");
            }
        }


    }
    
}
