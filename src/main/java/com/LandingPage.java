package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LandingPage {
    WebDriver webDriver;

    By link_Login = By.xpath("//*[@id='homepage']/header/div[1]/div/nav/ul/li[4]/a");
    By cancel_Popup = By.xpath("//*[@id='homepage']/div[4]/div[2]/div/div/div/span/div/div[6]");

    public LandingPage(WebDriver driver)
    {
        this.webDriver = driver;
    }

    public void setPagetoTest()
    {
        webDriver.findElement(cancel_Popup).click();

    }

    public String getTitle()
    {
        return webDriver.getTitle();
    }

    public void pageLogin()
    {
        webDriver.findElement(link_Login).click();
    }
}

