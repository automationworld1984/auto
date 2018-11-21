package dataImport;


import java.awt.TextField;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase extends Methods {
	private WebDriver driver;

	private StringBuffer verificationErrors = new StringBuffer();
	public String browser="Chrome";
	// Before Class and Method
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		ExtentReporterNG.onTestSuiteStart();


	}
	@BeforeMethod()
	public void configuration() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Anisha Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		ExtentReporterNG.logTestStepExtentReport("PASS","Enter URL", "URL entered",true,driver);// Report Steps PASS

	}
	//////////////Test Cases
	@Test(priority=1)//Test Cases
	public void testUntitledTestCase() throws Exception {
		String TestCasename="First Test case";
		ExtentReporterNG.onTestStart("Test Case Name : "+TestCasename+" and Broswer : "+browser);
//		
//		TextField(driver, "//input[@name='username']", "Test", "User Name");
//		dropdown(driver, "//select[@id='country']", "india", "Country dropdown");
//		CheckBox(driver, "//input[@id='Male']", "Male");	
		Button(driver, "//input[@name='upfile']", "Upoad Button");
		Login()
		UploadFile();
		ExtentReporterNG.logTestStepExtentReport("PASS","Click on Upload button", "Button clicked",true,driver);// Report Steps PASS
		
	}
	
	@Test(priority=2)// Test Cases
	public void SecondTestcase() throws Exception {
		String TestCasename="Second Test case";
		ExtentReporterNG.onTestStart("Test Case Name : "+TestCasename+" and Broswer : "+browser);
		Button(driver, "//input[@name='upfile']", "Data Input");

	}



	///////////////////////////////////////After Mehods and Class
	@AfterMethod()
	public void cofigclose() throws Exception{
		ExtentReporterNG.logTestStepExtentReport("PASS","Close Browser", "Browser closed",true,driver);// Report Steps PASS
		driver.close();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		//driver.quit();

		ExtentReporterNG.onTestSuiteFinish();
		ExtentReporterNG.onFinish();


		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}





}
