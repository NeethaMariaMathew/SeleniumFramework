package general;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{
    @Override
    public void onTestFailure(ITestResult result) {
        //Screenshot.takeScreenshot(driver);
        System.out.println("Failed test case is " + result.getName());
    }
}
