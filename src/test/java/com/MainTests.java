package com;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
//mport org.testng.annotations.DataProvider;
import dataSource.*;

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

    @Test(dataProviderClass=DataParameters.class,dataProvider="getData")
    public void test1(String name, String ind) throws IOException
    {
    
       
        LandingPage landingPage = new LandingPage(driver);
        System.out.println("Name is"+name+"Indicator is"+ind);
        String title=landingPage.getTitle();
        
        softAssert= new SoftAssert();
        softAssert.assertEquals(title, "google.com");
        
        Assert.assertEquals(title, "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");

        landingPage.pageLogin();
     //   softAssert.assertAll();

    }
    @AfterMethod
	public void testClose()
    {
        driver.quit();
    }
    
    
    
    



}