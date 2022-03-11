package com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

public class MainTests extends BaseTest
{
    String url;
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
        landingPage.pageLogin();

    }
    @AfterMethod
	public void testClose()
    {
        driver.quit();
    }



}