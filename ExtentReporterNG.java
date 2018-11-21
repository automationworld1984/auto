package dataImport;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;








import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG {

	public static ExtentReports report;
	public static ExtentTest logger;
	public static String reportFolderName;
	public static String createReportFolder(String reportLocation)
	{
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String time = dateFormat.format(now);
		File dir = new File(reportLocation+"report_"+time);
		dir.mkdir();
		return reportLocation+"report_"+time+"//";
	}
	public static String createScreenshot(WebDriver driver,String reportFolderName) {

		UUID uuid = UUID.randomUUID();
		// generate screenshot as a file object
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// copy file object to designated location
			FileUtils.copyFile(scrFile, new File(reportFolderName+".//Images//" + uuid + ".png"));
		} catch (IOException e) {
			System.out.println("Error while generating screenshot:\n" + e.toString());
		}
		return  reportFolderName+".//Images//" + uuid + ".png";
	}
	public static void onTestSuiteStart() {
		reportFolderName=createReportFolder( System.getProperty("user.dir")+"\\Report\\");
		report=new ExtentReports(reportFolderName+ "PDM Report.html", true);	
		
 
		report.loadConfig(ExtentReporterNG.class,"config.xml");
		//ExtentReports.config().reportHeadline("");
		//report.config().reportHeadline("");
	}

	
	public static void onFinish() {
		report.flush();
		//	report.close();
	}
	
	public static void logTestStepExtentReport(String result,String stepDetails,String actualResult,boolean screenshot,
			WebDriver driver)
			throws Exception
	{
		String imagepath;
		if(result.equalsIgnoreCase("PASS"))
			if(screenshot)
			{
				imagepath=createScreenshot(driver,reportFolderName);
				logger.log(LogStatus.PASS, stepDetails, actualResult);
				logger.log(LogStatus.INFO, "Snapshot below: " + logger.addScreenCapture(imagepath));
			}
			else
				logger.log(LogStatus.PASS, stepDetails, actualResult);
		if(result.equalsIgnoreCase("FAIL"))
			if(screenshot)
			{
				imagepath=createScreenshot(driver,reportFolderName);
				logger.log(LogStatus.FAIL, stepDetails, actualResult);
				logger.log(LogStatus.INFO, "Snapshot below: " + logger.addScreenCapture(imagepath));
			}
			else
				logger.log(LogStatus.FAIL, stepDetails, actualResult);
		if(result.equalsIgnoreCase("INFO"))
			if(screenshot)
			{
				imagepath=createScreenshot(driver,reportFolderName);
				logger.log(LogStatus.INFO, stepDetails, actualResult );
				logger.log(LogStatus.INFO, "Snapshot below: " + logger.addScreenCapture(imagepath));
			}
			else
				logger.log(LogStatus.INFO, stepDetails, actualResult);
	}

	
	public static void onTestStart(String TestCasename) {
		logger=report.startTest(TestCasename);
	}
	
	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public static void onTestSuiteFinish() {
		report.endTest(logger);
		
	}
	}