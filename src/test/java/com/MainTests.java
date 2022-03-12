package com;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

public class MainTests extends BaseTest
{
    String url;
    SoftAssert softAssert;
    @BeforeMethod
	public void testPrep() throws IOException
    {
        url="https://qaclickacademy.com/";
        super.invokeDriver();

        driver.get(url);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.setPagetoTest();
    }
    @Test
    public void test1() throws IOException
    {
        
        LandingPage landingPage = new LandingPage(driver);
        String title=landingPage.getTitle();
        softAssert= new SoftAssert();
        Assert.assertEquals(title, "google.com");
        Assert.assertEquals(title, "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");

        landingPage.pageLogin();
        softAssert.assertAll();

    }
    @AfterMethod
	public void testClose()
    {
        driver.quit();
    }



}