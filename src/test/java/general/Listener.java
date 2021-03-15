package general;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Listener implements ITestListener{

    Driver driver = new Driver();
    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Failed test case is " + result.getName());
    }

}
