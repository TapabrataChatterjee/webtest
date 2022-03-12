package listeners;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result)
    {
        Reporter.log("Test Failed");
        System.out.println("Take Screenshot");
    }
	
	

}
