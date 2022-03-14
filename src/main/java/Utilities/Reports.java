package Utilities;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;




public class Reports {

    public ExtentSparkReporter extentReporter;
    
    public ExtentReports extentReports;

    public void setReport()
    {
        extentReporter = new ExtentSparkReporter("./reports/extentreport.html");

        extentReporter.config().setEncoding("utf-8");
        extentReporter.config().setDocumentTitle("WebTest");
        extentReporter.config().setReportName("Automation Results");
        extentReporter.config().setTheme(Theme.DARK);

        extentReports=new ExtentReports();
        extentReports.attachReporter(extentReporter);

        extentReports.setSystemInfo("Automation Architect", "Tapabrata Chatterjee");



        



    }

    public void closeReport()
    {
        extentReports.flush();
    }

    
}
