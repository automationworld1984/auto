package mv.test.uft.Iteration1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import mv.components.mvauthorMethods;
import mv.pageobjects.mvauthorPageFactory;
import mv.utils.CommonMethods;
import mv.utils.Constants;
import mv.utils.ExcelUtility;
import mv.utils.Log;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MN_Author_AddNetwork_UI {
	mvauthorPageFactory mvauthorPageFactory ;
    String startTime;
    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browser) throws Exception{
         ExcelUtility.openExcelFile(Constants.DriverSheetFile_Path + Constants.DriverSheetFile_Name_Iteration1, "MV");
          mvauthorPageFactory     = new mvauthorPageFactory(null,browser);
          Log.debug("Starting test case for "+browser);
          startTime=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());  

    }

    @Parameters("executionSheet")
    @Test
   
    public void TC_MN_Author_AddNetwork_UI(@Optional("MN_Author_AddNetwork_UI") String executionSheet) throws Exception
    {

          
          Actions actions=new Actions(mvauthorPageFactory.driver);
          int Row=1;
          int Col=3;
          boolean executionFlag = false;
          
          executionFlag=ExcelUtility.executeTestCase("MV",this.getClass().getSimpleName());
        
          
          
          if(executionFlag)
          {
                ExcelUtility.setExecutionStatus("MV",this.getClass().getSimpleName(),"Executed");
                String startTime=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());  

                //Step 1: Login to the MV author
                mvauthorPageFactory.mvauthorLogin(Constants.mvauthorUserID, Constants.mvauthorPassword);
                
                CommonMethods.globalWait(5000);
            
                try{
    				Assert.assertEquals (mvauthorPageFactory.driver.getTitle(), "Dashboard | NBCUniversal Media Village");
    				CommonMethods.onSuccess(Row, Col, mvauthorPageFactory.driver,executionSheet,"Dashboard | NBCUniversal Media Village");
    			}catch (NoSuchElementException e){
    				CommonMethods.onFailure(Row, Col, mvauthorPageFactory.driver,executionSheet,"Actual Result is different than expected");
    				assert(true);
    			}
    			  //Step 2: navigate to Manage Networks page
            
                
    			 actions.moveToElement(mvauthorPageFactory.menuManageHierachy).click()
                 .moveToElement(mvauthorPageFactory.tabSubMenuCreateNetwork).click().build().perform();
        
                CommonMethods.globalWait(5000);
            
      
          Row=Row+1;
          try{
				Assert.assertEquals (mvauthorPageFactory.driver.getTitle(), "Manage Networks | NBCUniversal Media Village");
				CommonMethods.onSuccess(Row, Col, mvauthorPageFactory.driver,executionSheet,"Manage Networks | NBCUniversal Media Village");
			}catch (NoSuchElementException e){
				CommonMethods.onFailure(Row, Col, mvauthorPageFactory.driver,executionSheet,"Actual Result is different than expected");
				assert(true);
			}
			
			mvauthorPageFactory.btnCreateNework.click();
			CommonMethods.globalWait(5000);
			
			 Row=Row+1;
	          try{
					Assert.assertEquals (mvauthorPageFactory.driver.getTitle(), "Create Networks | NBCUniversal Media Village");
					CommonMethods.onSuccess(Row, Col, mvauthorPageFactory.driver,executionSheet,"Create Networks | NBCUniversal Media Village");
				}catch (NoSuchElementException e){
					CommonMethods.onFailure(Row, Col, mvauthorPageFactory.driver,executionSheet,"Actual Result is different than expected");
					assert(true);
				}
			 
      	Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.dropdownSelectDiv, Row, Col, executionSheet, mvauthorPageFactory.driver,"Division dropdown");
		Row=Row+1;
		
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.eventLanguage, Row, Col, executionSheet, mvauthorPageFactory.driver,"Language dropdown");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.textTitle, Row, Col, executionSheet, mvauthorPageFactory.driver,"Title text field");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.inputCode, Row, Col, executionSheet, mvauthorPageFactory.driver,"Code text field");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.inputTwitterScreenName, Row, Col, executionSheet, mvauthorPageFactory.driver,"Twitter screen name text field");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.inputInstagramName, Row, Col, executionSheet, mvauthorPageFactory.driver,"Instagram name");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.description, Row, Col, executionSheet, mvauthorPageFactory.driver,"Description section");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.inputSortOrder, Row, Col, executionSheet, mvauthorPageFactory.driver,"Sort order text field");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.fileUploadLogo1, Row, Col, executionSheet, mvauthorPageFactory.driver,"Upload Logo 1");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.btnUploadLogo1, Row, Col, executionSheet, mvauthorPageFactory.driver,"Upload button 1");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.fileUploadLogo2, Row, Col, executionSheet, mvauthorPageFactory.driver,"Upload Logo 2");

		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.btnUploadLogo2, Row, Col, executionSheet, mvauthorPageFactory.driver,"Upload button 2");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.inputPRLogo, Row, Col, executionSheet, mvauthorPageFactory.driver,"Press release logo  text field");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.chkboxImportSchedule, Row, Col, executionSheet, mvauthorPageFactory.driver,"Import Schedule");
	
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.factSheet, Row, Col, executionSheet, mvauthorPageFactory.driver,"Fact Sheet section");
		//
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.addNewNavNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"ADD NEW SECONDARY NAVIGATION PANEL link");
		mvauthorPageFactory.addNewNavNetwork.click();
		CommonMethods.globalWait(5000);
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.secondaryTypeFirstNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"Secondary Nav Type & Title dropdown");
		new Select(mvauthorPageFactory.secondaryTypeFirstNetwork).selectByVisibleText("Info");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.aboutNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"About Check box");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.talentBiosNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"Talent Bios checkbox");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.contactsNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"Contacts checkbox");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.screenersNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"Screeners checkbox");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.tweetsNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"tweets checkbox");

		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.execbiosNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"Executive bios checkbox");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.photosNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"Photos checkbox");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.epksNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"EPKs checkbox");
	
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.newsNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"News checkbox");

		mvauthorPageFactory.addNewNavNetwork.click();
   	   CommonMethods.globalWait(2000);
   	   //Row=Row+1;
   	  // CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.secondaryTypeFirstNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"Secondary Nav Type & Title dropdown");
   	   new Select(mvauthorPageFactory.secondaryTypeSecondNetwork).selectByVisibleText("Shows");
   	   mvauthorPageFactory.addNewNavNetwork.click();
   	   CommonMethods.globalWait(2000);
   	  // Row=Row+1;
  	 //  CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.secondaryTypeFirstNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"Secondary Nav Type & Title dropdown");
  	   
   	   
	   CommonMethods.globalWait(2000);
	   new Select(mvauthorPageFactory.secondaryTypeThirdNetwork).selectByVisibleText("External Links");
	   Row=Row+1;
	   CommonMethods.globalWait(2000);
  	   CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.externalLinkNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"External Link Network");
  	
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.inputLiveStartDate, Row, Col, executionSheet, mvauthorPageFactory.driver,"Live Start Date");
		
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.inputLiveEndDate, Row, Col, executionSheet, mvauthorPageFactory.driver,"Live End Date");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.manageDivisionRevisionComments, Row, Col, executionSheet, mvauthorPageFactory.driver,"Revision Comments");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.btnSaveandPublishNetwork, Row, Col, executionSheet, mvauthorPageFactory.driver,"Save And Publish button");

		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.btnSave, Row, Col, executionSheet, mvauthorPageFactory.driver,"Save button");
		
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.btnSaveAndPreview, Row, Col, executionSheet, mvauthorPageFactory.driver,"Save And Preview buttons");
		Row=Row+1;
		CommonMethods.logUIValidationResultWithoutFailure(mvauthorPageFactory.btnCancel, Row, Col, executionSheet, mvauthorPageFactory.driver,"Cancel button");
		
		
	    mvauthorPageFactory.mvauthor_Logout.click();
		
      						
          }
                
                else
                ExcelUtility.setExecutionStatus("MV",this.getClass().getSimpleName(),"Not Executed");
    }

	@Parameters("browser")
	@AfterMethod
	public void afterMethod(@Optional("chrome") String browser) throws Exception
	{
		String endTime=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		Date startDate;
		Date EndDate;
		try {
			startDate=new SimpleDateFormat("HH:mm:ss").parse(startTime.split(" ")[1]);
			EndDate=new SimpleDateFormat("HH:mm:ss").parse(endTime.split(" ")[1]);
			ExcelUtility.setExecutionTimeInHours("MV", this.getClass().getSimpleName(),
					(EndDate.getTime()-startDate.getTime())/ (60 * 60 * 1000) % 24);
			ExcelUtility.setExecutionTimeInMinutes("MV", this.getClass().getSimpleName(),
					(EndDate.getTime()-startDate.getTime())/ (60 * 1000) % 60);
			ExcelUtility.setExecutionTimeInSeconds("MV",this.getClass().getSimpleName(),
					(EndDate.getTime()-startDate.getTime())/1000 % 60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Log.onTestCaseEnd();
		mvauthorPageFactory.closeDriver(mvauthorPageFactory.driver);
		Log.debug("Ending test suit for "+browser);
		ExcelUtility.saveAndcloseExcel(Constants.DriverSheetFile_Path, "TestResults_"+browser+".xlsx");
	}
}
