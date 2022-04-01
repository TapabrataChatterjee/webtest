package com;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import org.testng.log4testng.Logger;

import Utilities.Reports;

import org.testng.annotations.BeforeMethod;
//mport org.testng.annotations.DataProvider;
import dataSource.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
//import java.util.logging.LogManager;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.properties.*;
import org.apache.logging.log4j.core.LoggerContext;



public class MainTests extends BaseTest
{
    String url;
    SoftAssert softAssert;
    public ExtentTest extentTest;
    Reports reports;
    Date date;
    public static final Logger log = LogManager.getLogger("MainTests");
    @BeforeMethod
	public void testPrep(Method m) throws IOException
    {
        url="https://qaclickacademy.com/";

    //    public static Logger log = Logger.getLogger(Maintests.class.getName());
     //   PropertyConfigurator.configure("./src/main/java/log4j.properties");
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        File file = new File("./src/main/java/log4j.properties");
        context.setConfigLocation(file.toURI());

        reports = new Reports();
        reports.setReport();
        super.invokeDriver();

        driver.get(url);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.setPagetoTest();

        System.out.println("Method to be exeucted"+m.getName());
        log.info("Test to be started");
        

        
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
        log.info("Assert completed");
        landingPage.pageLogin();
        log.info("Test Completed");
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
            log.error("Test FAILED");
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