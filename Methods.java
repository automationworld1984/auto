package dataImport;
//https://drive.google.com/file/d/0ByJmgAhaLx0GVzktVFNNUEZPeWc/view
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Methods {
	WebDriver driver;
	// Start Loginmethod
	public void Login() throws Exception{// Login Method

		TextField(driver, "//input[@name='username']", "Test", "User Name");
		TextField(driver, "//input[@name='password']", "Test@123", "Password");
		Button(driver, "//input[@name='Login']", "Login");
	
		
		//dropdown(driver, "//select[@id='country']", "india", "Country dropdown");
		//CheckBox(driver, "//input[@id='Male']", "Male");	

	}
	
	//End Login Method
	public void UploadFile() throws Exception{
		String filepath="C:\\Users\\Vikas\\Desktop\\Test\\Test.txt";
		StringSelection stringSelection = new StringSelection(filepath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		//Robot
		Thread.sleep(2000);	
		Robot robot=new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);	
		ExtentReporterNG.logTestStepExtentReport("PASS","File upload", "File uploaded succesfully",true,driver);// Report Steps PASS

	}
	
	
	public void Logout() throws Exception{
		
		ExtentReporterNG.logTestStepExtentReport("PASS","Verify the Logout functionality", "Logout Done",true,driver);// Report Steps PASS

	}

	//++++++++++++++++++++++++++++++++++++++++++++++++++       Web Element Methods     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static boolean isPageReady(WebDriver m_driver) throws Exception {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) m_driver;
		boolean docReadyState;


		// Document ready State
		docReadyState = (Boolean) javascriptExecutor.executeScript("return document.readyState == 'complete'");

		if (docReadyState)
		{
			//Log.info("Page "+m_driver.getTitle()+" Loaded Successfully");
			return docReadyState;
		}else{
			try{
				//Log.info("Page "+m_driver.getTitle()+" Loading Failed");
			}catch(Exception e){
				//Log.info("Failure in getting Page Title - "+e.getLocalizedMessage());
			}
			return (docReadyState);
		}
	}
	///// 1. Button
	public static void Click_On_Button(WebDriver driver, String xpath, String value) throws Exception{
		isPageReady(driver);
		String flag;
		int foundElement = 1;
		for (foundElement = 1; foundElement < 10000; foundElement++){
			if (driver.findElement(By.xpath(xpath)).isDisplayed()){
				if (driver.findElement(By.xpath(xpath)).isEnabled()){
					ExtentReporterNG.logTestStepExtentReport("PASS","Verification the Present of  : "+value,"Successfully Clicked  : "+value,true,driver);
					flag= "True";
					driver.findElement(By.xpath(xpath)).click();
					isPageReady(driver);
					////WriteHTMLLog.//WriteHTMLLogs(//WriteHTMLLog.getFormatedHTMLPASSTestStep(value+" : button Clicked"));

					break;
				}else{
					flag = "False";
				}					
			}

		}
		if (foundElement == 10000){
			////WriteHTMLLog.//WriteHTMLLogs(//WriteHTMLLog.getFormatedHTMLFailTestStep("Button Object not Found and not Clicked"));
			flag = "False";
			ExtentReporterNG.logTestStepExtentReport("FAIL","Verification the Present of  : "+value,value+" is Not Present",true,driver);


		}
		isPageReady(driver);
	}


	//////////////////////////2. DropDown
	public static void dropdown(WebDriver driver, String xpath, String fieldValue, String dropdowName) throws Exception{
		String flag = null;
		for (int foundElement = 1; foundElement < 5000; foundElement++){

			try{
				flag = "False";
				if (driver.findElement(By.xpath(xpath)).isDisplayed()){
					if (driver.findElement(By.xpath(xpath)).isEnabled()){
						try{
							Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
							dropdown.selectByVisibleText(fieldValue);
							////WriteHTMLLog.//WriteHTMLLogs(//WriteHTMLLog.getFormatedHTMLPASSTestStep(fieldValue+" Selected on from "+dropdowName+" dropdown"));

							ExtentReporterNG.logTestStepExtentReport("PASS",fieldValue+" Selected on  "+dropdowName+" dropdown", 
									fieldValue+" Sucessfully Selected on from "+dropdowName+" dropdown",false,driver);

							flag = "True";
							break;
						} catch (Exception e) {
							System.out.println("Still Searching :" + fieldValue);
							flag = "False";
						}

					}
				}
			} catch (Exception e) {
				System.out.println("Exception thrown in findElementdropdown Method--------->"+e);
			}
		}
		if (flag.equalsIgnoreCase("False")){
			//WriteHTMLLog.//WriteHTMLLogs(//WriteHTMLLog.getFormatedHTMLFailTestStep(fieldValue+" Not Present on "+dropdowName));

			ExtentReporterNG.logTestStepExtentReport("FAIL",fieldValue+" is NOT Present on  "+dropdowName+" dropdown", 
					fieldValue+" NOT Selected on from "+dropdowName+" dropdown",true,driver);
		}

	}


	public void dropdownByValue(WebDriver driver, String xpath, String fieldValue){// Dropdown by Value
		for (int foundElement = 1; foundElement < 5000; foundElement++){
			if (driver.findElement(By.xpath(xpath)).isDisplayed()){
				if (driver.findElement(By.xpath(xpath)).isEnabled()){
					Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
					//dropdown.selectByVisibleText(fieldValue);
					dropdown.selectByValue(fieldValue);
					break;
				}
			}
		}

	}
	//////////////////////////////////////////////////3. ClickOnButton
	public static void Button(WebDriver driver, String xpath, String value) throws Exception{
		isPageReady(driver);
		String flag;
		int foundElement = 1;
		for (foundElement = 1; foundElement < 10000; foundElement++){
			if (driver.findElement(By.xpath(xpath)).isDisplayed()){
				if (driver.findElement(By.xpath(xpath)).isEnabled()){
					ExtentReporterNG.logTestStepExtentReport("PASS","Verification the Present of  : "+value,"Successfully Clicked  : "+value,true,driver);
					flag = "True";
					driver.findElement(By.xpath(xpath)).click();
					isPageReady(driver);
					////WriteHTMLLog.//WriteHTMLLogs(//WriteHTMLLog.getFormatedHTMLPASSTestStep(value+" : button Clicked"));

					break;
				}else{
					flag = "False";
				}					
			}

		}
		if (foundElement == 10000){
			////WriteHTMLLog.//WriteHTMLLogs(//WriteHTMLLog.getFormatedHTMLFailTestStep("Button Object not Found and not Clicked"));
			flag = "False";
			ExtentReporterNG.logTestStepExtentReport("FAIL","Verification the Present of  : "+value,value+" is Not Present",true,driver);


		}
		isPageReady(driver);
	}
	///////////////////////////////////4. CheckBox
	public void CheckBox(WebDriver driver, String xpath, String value) throws Exception{
		for (int foundElement = 1; foundElement < 5000; foundElement++){
			if (driver.findElement(By.xpath(xpath)).isEnabled()){
				if (!driver.findElement(By.xpath(xpath)).isSelected()){
					driver.findElement(By.xpath(xpath)).click();
					////WriteHTMLLog.//WriteHTMLLogs(//WriteHTMLLog.getFormatedHTMLPASSTestStep("Check the checkbox : "+value));

					ExtentReporterNG.logTestStepExtentReport("PASS","Verify "+value+" is CheckBox on the webpage", 
							value+" is Checked displayed on Application",false,driver);
					break;
				}else{	

					break;
				}
			}
		}



	}
	/////////////////////////////////////5. TextField

	public void TextField(WebDriver driver, String xpath, String fieldValue, String fieldname) throws Exception{
		String fieldName = null;
		String flag = null;
		for (int foundElement = 1; foundElement < 5000; foundElement++){
			try{
				if (driver.findElement(By.xpath(xpath)).isDisplayed()){
					if (driver.findElement(By.xpath(xpath)).isEnabled()){
						try{
							driver.findElement(By.xpath(xpath)).click();
							driver.findElement(By.xpath(xpath)).clear();
							driver.findElement(By.xpath(xpath)).click();
							driver.findElement(By.xpath(xpath)).sendKeys(fieldValue);
							flag = "True";
							ExtentReporterNG.logTestStepExtentReport("PASS",fieldValue+" Entered on "+fieldName+" text Field", 
									fieldValue+" Sucessfully Enteron "+fieldName+" text Field",false,driver);
							break;
						}catch(Exception e){
							flag = "False";
						}
					}
				}
			}catch (Exception e) {

				System.out.println("Exception thrown in findElementTextBox Method--------->"+e);
				//notEnter="false";
				flag = "False";

			}

		}
		if (flag.equalsIgnoreCase("False")){
			////WriteHTMLLog.//WriteHTMLLogs(//WriteHTMLLog.getFormatedHTMLFailTestStep(fieldValue+" NOT Entered on Application"));
			ExtentReporterNG.logTestStepExtentReport("FAIL",fieldName+" Text Field"+  " : Object is Not Present",fieldValue+" NOT Entered on : " +fieldName,true,driver);

		}
	}


	///////////////////////////Radio
	public void Radio(WebDriver driver, String xpath, String nameOFRadiobutton) throws Exception{
		for (int foundElement = 1; foundElement < 5000; foundElement++){
			if (driver.findElement(By.xpath(xpath)).isEnabled()){
				if (!driver.findElement(By.xpath(xpath)).isSelected()){
					driver.findElement(By.xpath(xpath)).click();
					////WriteHTMLLog.//WriteHTMLLogs(//WriteHTMLLog.getFormatedHTMLPASSTestStep("Click on the Radio button : "+nameOFRadiobutton));

					ExtentReporterNG.logTestStepExtentReport("PASS","Verify "+nameOFRadiobutton+" is Radio on the webpage", 
							nameOFRadiobutton+" is displayed on Application",false,driver);
					break;
				}else{					
					break;
				}
			}
		}

	}
}




