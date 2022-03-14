package com;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilities.Reports;

import org.testng.annotations.BeforeMethod;
//mport org.testng.annotations.DataProvider;
import dataSource.*;

import java.io.IOException;
import java.util.Date;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class MainTests extends BaseTest
{
    String url;
    SoftAssert softAssert;
    public ExtentTest extentTest;
    Reports reports;
    Date date;
    
    @BeforeMethod
	public void testPrep() throws IOException
    {
        url="https://qaclickacademy.com/";

        reports = new Reports();
        reports.setReport();
        super.invokeDriver();

        driver.get(url);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.setPagetoTest();
    } 

    @Test(dataProviderClass=DataParameters.class,dataProvider="getData")
    public void test1(String name, String ind) throws IOException
    {
        
        extentTest=reports.extentReports.createTest("Automation Test to click Login");
        date = new Date();
        LandingPage landingPage = new LandingPage(driver);
        System.out.println("Name is"+name+"Indicator is"+ind);
        String title=landingPage.getTitle();
        
        softAssert= new SoftAssert();
      //  softAssert.assertEquals(title, "google.com");
        extentTest.log(Status.INFO, "Attempting to verify Title");
        Assert.assertEquals(title, "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");

        landingPage.pageLogin();
        extentTest.log(Status.INFO, date.toString());
        extentTest.log(Status.INFO,"Test Completed");
     //   softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            extentTest.log(Status.FAIL,"Test Failed");
            Markup markup = MarkupHelper.createLabel("Test Failed", ExtentColor.RED);
            extentTest.fail(markup);

        }
        else if(result.getStatus()==ITestResult.SUCCESS)
        {
            Markup markup = MarkupHelper.createLabel("Test Succeeded", ExtentColor.GREEN);
            extentTest.pass(markup);
        }
    }
    @AfterTest
	public void testClose()
    {
        driver.close();
        reports.closeReport();
    }
    
    
    
    



}