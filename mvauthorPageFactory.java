package mv.pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import mv.utils.*;

public class mvauthorPageFactory {

	public WebDriver driver;
	
	//	------------------------------- MV EPK TV Screener----------------------------
	@FindBy(id="Master_Content_UsernameTextBox")
	public WebElement userNameEPKTV;
	
	@FindBy(id="Master_Content_PasswordTextBox")
	public WebElement passwordEPKTV;
	
	@FindBy(id="Master_Content_LoginButton")
	public WebElement loginEPKTV;
	
	@FindBy(xpath=".//*[@title='Manage screeners']")
	public WebElement manageScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_Content_AddNewScreenerTopButton']")
	public WebElement addNewScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_Content_ScreenerTitleTextBox']")
	public WebElement titleScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_Content_ScreenerUrlNameTextBox']")
	public WebElement urlNameScreenerEPKTV;
	
	
	@FindBy(xpath=".//*[@id='Master_Content_ScreenerDescriptionTextBox']")
	public WebElement descriptionScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_Content_ScreenerDurationTextBox']")
	public WebElement durationScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_Content_StationsDropDownList']")
	public WebElement networkScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_Content_ScreenerDateStartCalendarImage']")
	public WebElement fromDateScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_Content_NBCUMVCompassIDTextBox']")
	public WebElement compassIDScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_Content_ScreenerDateEndCalendarImage']")
	public WebElement toDateScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_Content_ScreenerEnableCheckBox']")
	public WebElement enabledScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='calendarDiv']/div[7]/table/tbody/tr[3]/td[5]")
	public WebElement datePreviousmonthScreenerEPKTV;
	
	
	@FindBy(xpath=".//*[@id='calendarDiv']/div[7]/table/tbody/tr[3]/td[5]")
	public WebElement dateScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_Content_ScreenerSaveButton']")
	public WebElement saveScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='topBar']/img")
	public WebElement closeCalenderScreenerEPKTV;
	
	@FindBy(xpath=".//*[@id='Master_HeaderControl_LogoutButton']")
	public WebElement logoutEPKTV;
	
	@FindBy(xpath=".//*[@id='calendarDiv']")
	public WebElement calanderEPKTV;
	
	@FindBy(xpath=".//*[@id='calendar_year_txt']")
	public WebElement calanderYearEPKTV;
	
	@FindBy(xpath=".//*[@href='/admin/nbcumv-epk-tv-listener']")
	public WebElement subMenuEPKInterface;
	
	@FindBy(xpath=".//*[@id='edit-import-videos']")
	public WebElement importEPK;
	
	@FindBy(xpath=".//*[@id='edit-import-images']")
	public WebElement importImage;
	
	@FindBy(xpath=".//*[@id='edit-send-email']")
	public WebElement sendEmailEPK;
	
	@FindBy(xpath=".//*[@id='edit-submit']")
	public WebElement importEPKRun;
	
	
	//	------------------------------- MV Author Objects ----------------------------

	@FindBy(id="edit-name")
	public WebElement userName;

	@FindBy(id="edit-pass")
	public WebElement password;

	@FindBy(id="edit-submit")
	public WebElement Login;

	@FindBy(xpath=".//*[@id='block-menu-menu-author-menu']/div/ul/li[3]/a")
	public WebElement menuManageAssets;
	
	@FindBy(xpath=".//*[@id='block-menu-menu-author-menu']/div/ul/li[2]/a")
	public WebElement menuManageHierachy;
	
	@FindBy(xpath=".//*[@id='block-menu-menu-author-menu']/div/ul/li[5]/a")
	public WebElement menuJobsInterfaces;
	
	@FindBy(xpath=".//*[@id='edit-search-type-1']")
	public WebElement menuManageAssest;

	@FindBy(xpath="//a[text()='Manage Bios']")	
	public WebElement submenuManageBios;
	
	@FindBy(xpath=".//*[@id='block-menu-menu-author-menu']/div/ul/li[2]/ul/li[4]/a")	
	public WebElement submenuCorporate;

	@FindBy(xpath=".//*[@id='block-system-main']/div/div[1]/p/a")
	public WebElement createTalentBio;

	@FindBy(id="edit-field-account-last-name-en-0-value")
	public WebElement createTalentBio_LastName;

	@FindBy(id="edit-field-bios-shows-collection-und-0-field-secondary-bio-title-und-0-value")
	public WebElement createTalentBio_CharName;

	@FindBy(id="edit-field-bios-shows-collection-und-0-field-shows-reference-und")
	public WebElement createTalentBio_Program;

	@FindBy(id="edit-field-live-start-date")
	public WebElement createTalentBio_LiveStartDate;

	@FindBy(xpath=".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[3]/a")
	public WebElement createTalentBio_LiveStartDateCalendar;

	@FindBy(xpath=".//*[@id='ui-datepicker-div']/div[3]/button[2]")
	public WebElement createTalentBio_LiveStartDateCalendarDoneButton;

	@FindBy(id="edit-field-live-end-date")
	public WebElement createTalentBio_LiveEndDate;

	@FindBy(linkText="14")
	public WebElement createTalentBio_PickStartDateCalendar;

	@FindBy(linkText="26")
	public WebElement createTalentBio_PickEndDateCalendar;

	@FindBy(xpath="(//button[@type='button'])[2]")
	public WebElement createTalentBio_CalendarDoneButton;

	@FindBy(xpath=".//*[@id='cke_elementspath_172_1']")
	public WebElement createTalentBio_BioBody;

	@FindBy(xpath=".//*[@id='edit-field-publish-on-future-date-und']")
	public WebElement createTalentBio_PublishInFuture;

	@FindBy(css="span.logout-icon")
	public WebElement mvauthor_Logout;

	/***Added for MV995(Sprint 35)*******/
	//Language
	@FindBy(id="edit-language")
	public WebElement createBioLangDropdown;
	//FirstName
	@FindBy(id="edit-field-account-first-name-en-0-value")
	public WebElement createBioFirstNameTextField;
	//TwitterScreenName
	@FindBy(id="edit-field-twitter-screen-name-und-0-value")
	public WebElement createBioTwitterNameTextField;
	@FindBy(id="edit-field-instagram-name-und-0-value")
	public WebElement createBioInstagramNameTextField;
	@FindBy(id="edit-field-network-collection-und-0-field-network-reference-und")
	public WebElement createBioNetworkNameDropdown;
	@FindBy(xpath="//a[@id='add_network']")
	public WebElement createBioAddNetworkLink;
	@FindBy(id="edit-field-program-event-collection-und-0-field-event-reference-und")
	public WebElement createBioProgEventDropdown;
	@FindBy(xpath="//a[@id='add_program_event']")
	public WebElement createBioAddProgEventLink;
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-bios-shows-collection-und-0-field-talent-bio-type-und-talent']")
	public WebElement createBioCharTypeTalentRadioBtn;
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-bios-shows-collection-und-0-field-talent-bio-type-und-production']")
	public WebElement createBioCharTypeProdRadioBtn;
	@FindBy(xpath="//input[@type='text'][@id='edit-field-bios-shows-collection-und-0-field-secondary-bio-title-en-0-value']")
	public WebElement createBioCharNameTextField;
	@FindBy(xpath="//input[@type='text'][@id='edit-field-bios-shows-collection-und-0-field-secondary-bio-title-es-0-value']")
	public WebElement createBioTranslatedNameTextField;
	@FindBy(id="edit-field-bios-shows-collection-und-0-field-shows-reference-und")
	public WebElement createBioProgramDropdown;
	@FindBy(xpath="//input[@type='text'][@id='edit-field-bios-shows-collection-und-0-field-associate-nup-id-und-0-value']")
	public WebElement createBioCharNUPIDTextField;
	@FindBy(xpath="//input[@type='file'][@id='edit-field-bios-shows-collection-und-0-field-division-bio-image-und-0-upload']")
	public WebElement createBioCharImageUploadFile;
	@FindBy(xpath="//input[@type='submit'][@id='edit-field-bios-shows-collection-und-0-field-division-bio-image-und-0-upload-button']")
	public WebElement createBioCharImageUploadBtn;
	@FindBy(xpath="//div[@class='form-item form-type-textarea form-item-body-en-0-value']/descendant::iframe[@class='cke_wysiwyg_frame cke_reset']")
	public WebElement createBioBodyFrame;
	@FindBy(xpath="//input[@type='text'][@id='edit-field-associate-nup-id-und-0-value']")
	public WebElement createBioBodyNUPIDText;
	@FindBy(xpath="//input[@type='file'][@id='edit-field-image-und-0-upload']")
	public WebElement createBioPhotoUploadFile;
	@FindBy(xpath="//input[@type='submit'][@id='edit-field-image-und-0-upload-button']")
	public WebElement createBioPhotoUploadBtn;
	@FindBy(xpath="//a[text()='TRANSLATED CONTENT'][@class='activate-text add-translated-content']/span[contains(text(),'SHOW')]")
	public WebElement createBioShowTranslatedContentLink;
	@FindBy(xpath="//a[text()='TRANSLATED CONTENT'][@class='activate-text add-translated-content']/span[contains(text(),'HIDE')]")
	public WebElement createBioHideTranslatedContentLink;
	@FindBy( xpath="//input[@id='edit-field-account-first-name-es-0-value']")
	public WebElement createBioTranslatedFNText;
	@FindBy( xpath="//input[@id='edit-field-account-last-name-es-0-value']")
	public WebElement createBioTranslatedLNText;
	@FindBy(xpath="//div[@class='form-item form-type-textarea form-item-body-es-0-value']/descendant::iframe[@class='cke_wysiwyg_frame cke_reset']")
	public WebElement createBioBodyTranslatedFrame;
	@FindBy(xpath="//a[text()='PUBLISHING DATA'][@class='activate-text add-publishing-wrap']/span[contains(text(),'HIDE')]")
	public WebElement createBioHidePublishingDataLink;
	@FindBy(xpath="//a[text()='PUBLISHING DATA'][@class='activate-text add-publishing-wrap']/span[contains(text(),'SHOW')]")
	public WebElement createBioShowPublishingDataLink;
	@FindBy(xpath="//textarea[@id='edit-log']")
	public WebElement createBioRevisionComments;
	//general:

	@FindBy(id="content-submit-publish-btn")
	public WebElement btnSaveAndPublish;
	@FindBy(id="edit-submit")
	public WebElement btnSave;
	@FindBy(id="edit-preview")
	public WebElement btnSaveAndPreview;
	@FindBy(id="edit-cancel")
	public WebElement btnCancel;

	/*----Manage Screener sub menu---------*/
	@FindBy(xpath="//*[@id='block-menu-menu-author-menu']/descendant::a[text()='Manage Screeners']")
	public WebElement manageScreeners;

	/*----ManageDNR sub menu---------*/
	@FindBy(xpath=".//*[@id='block-menu-menu-author-menu']/descendant::a[text()='Manage DNR']")
	public WebElement submenuManageDNR;

	/*----ManageUsers Menu---------*/
	@FindBy(xpath=".//*[@id='block-menu-menu-author-menu']/descendant::a[text()='manage users']")
	public WebElement menuManageUsers;

	/*----Manage User Requests and access sub menu---------*/
	@FindBy(xpath=".//*[@id='block-menu-menu-author-menu']/descendant::a[text()='Manage User Requests & Access']")
	public WebElement submenuManageUsersAndAccess;

	/*---Manage Photos sub menu-----------*/
	@FindBy(xpath=".//*[@id='block-menu-menu-author-menu']/descendant::a[text()='Manage Photos']")
	public WebElement submenuManagePhotos;

	/********Create Screener Page****************/

	@FindBy (xpath="//a[text()=' Create Screeners']")
	public WebElement createScreener;

	@FindBy (id="edit-title")
	public WebElement inputTitle;

	@FindBy (id="edit-field-compass-network-id-und-0-value")
	public WebElement inputCompassNetworkId;

	@FindBy (id="edit-field-shows-collection-und-0-field-shows-reference-und")
	public WebElement dropdownSelectShow;

	@FindBy (id="edit-field-epk-network-name-und-0-value")
	public WebElement inputEPKNetworkName;

	@FindBy (id="edit-field-network-reference-und")
	public WebElement dropdownNetwork;	

	@FindBy (xpath="//iframe[@title='Rich Text Editor, edit-body-und-0-value']")
	public WebElement iframeDescription;	

	@FindBy (xpath="//div[@class='messages status']/em")
	public WebElement msgStatus;

	@FindBy (xpath="//input[@type='checkbox'][@id='edit-field-publish-on-future-date-und']")
	public WebElement checkBoxPublishInFuture;
	
	@FindBy(id="edit-field-thumbnail-nup-und-0-target-id")
	public WebElement thumbnailNUP;
	
	@FindBy(id="edit-field-select-thumbnail-photo-und-0-value")
	public WebElement thumbnailPhoto;

	/*Common locators on admin page*/

	@FindBy (id="edit-keywords")
	public WebElement titleSearch;

	@FindBy (id="edit-status")
	public WebElement statusSearch;

	@FindBy (id="edit-date-from")
	public WebElement dateFromSearch;

	@FindBy (id="edit-date-to")
	public WebElement dateToSearch;

	@FindBy (id="edit-date-type")
	public WebElement dateTypeSearch;

	@FindBy (id="edit-title-search")
	public WebElement onlyTitleSearchCheckbox;

	@FindBy (id="edit-submit-admin-global-search")
	public WebElement buttonSearch;

	@FindBys(@FindBy (xpath="//table/tbody/tr/td/a[text()='Delete']"))
	public List<WebElement> deleteButtonList;

	@FindBys(@FindBy (xpath="//table/tbody/tr/td/a[text()='Edit']"))
	public List<WebElement> editButtonList;
	
	@FindBys(@FindBy (xpath="//table/tbody/tr/td[1]"))
	public List<WebElement> userNameListInResultTable;

	/*to delete user*/
	@FindBy (xpath="//input[@id='edit-submit'][@value='Delete Account']")
	public WebElement buttonDeleteAccount;
	/*Following locators are to select Dates from Datepicker*/

	@FindBy( xpath="//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")
	public WebElement selectMonth;

	@FindBy( xpath="//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")
	public WebElement selectYear;

	@FindBy(xpath="//button[text()='Done']")
	public WebElement btnDone;

	@FindBy(xpath="//button[text()='Clear']")
	public WebElement btnClear;

	@FindBy ( xpath="//div[@class='form-item form-type-textfield form-item-field-live-end-date']/img[@title='Pick a Date']")
	public WebElement liveEndDate;

	@FindBy ( xpath="//div[@class='form-item form-type-textfield form-item-field-live-start-date']/img[@title='Pick a Date']")
	public WebElement liveStartDate;

	@FindBy( xpath="//dd[@class='ui_tpicker_minute']/div/a[starts-with(@class,'ui-slider-handle ui-state-default ui-corner-all')]")
	public WebElement minuteSlider;

	@FindBy( xpath="//dd[@class='ui_tpicker_hour']/div/a[starts-with(@class,'ui-slider-handle ui-state-default ui-corner-all')]")
	public WebElement hourSlider;

	/***************bulk-edit-search Page**************************/

	@FindBy(xpath="//a[text()='Bulk Edit Photos']")
	public WebElement linkBulkEditPhotos;

	@FindBy(xpath="//h1[text()='Bulk Edit Search Photos']")
	public WebElement labelBulkEditSearchPhotos;

	@FindBy(id="edit-field-advanced-status-1")
	public WebElement checkboxUnpublished;

	@FindBy(id="edit-field-advanced-status-2")
	public WebElement checkboxPending;

	@FindBy(id="edit-field-advanced-status-3")
	public WebElement checkboxPublished;

	@FindBy(id="edit-field-nup-id-value")
	public WebElement inputNUP;

	@FindBy(id="edit-submit-bulk-edit-search")
	public WebElement buttonBulkEditSearch;

	@FindBy(id="bulk-edit-result-tbl")
	public WebElement tblBulkEditSearch;

	@FindBys(@FindBy(xpath="//*[@class='vbo-select form-checkbox']"))
	public List<WebElement> checkboxListBulkEditSearch;

	@FindBy(id="edit-actionnbcumv-lightbox-bulk-edit-action")
	public WebElement btnBulkEdit;

	@FindBys(@FindBy(xpath="//table[@id='bulk-edit-result-tbl']/tbody/tr/td[3]"))
	public List<WebElement> listFileNameForBulkEditSearch;


	/****************** Bulk Edit Photo Page ************************/

	@FindBy(xpath="//h1[text()='Bulk Edit Photo']")
	public WebElement labelBulkEditPhotos;

	@FindBy(className="views-table cols-6")
	public WebElement tblBulkEditPhoto;

	@FindBy(xpath="//table[@class='views-table cols-6']/tbody/tr/td[2]")
	public WebElement listFileNameForBulkEdit;

	@FindBy(id="edit-field-photo-type")
	public WebElement dropDownPhotoType;

	@FindBy(id="edit-field-division-collection-add-item")
	public WebElement btnAddAnotherDivison;

	@FindBys(@FindBy(xpath="//*[@class='division-list-item form-select']"))
	public List<WebElement> dropdownListAddDivison;

	@FindBy(id="edit-field-network-collection-add-item")
	public WebElement btnAddAnotherNetwork;

	@FindBys(@FindBy(xpath="//*[@class='network-list-item form-select']"))
	public List<WebElement> dropdownListAddNetwork;

	@FindBy(id="edit-field-shows-collection-add-episode")
	public WebElement btnAddAnotherShow;

	@FindBys(@FindBy(xpath="//*[@class='col1-wrap field-show form-select ajax-processed']"))
	public List<WebElement> dropdownListAddShow;

	@FindBy(id="edit-actions-submit")
	public WebElement btnSaveChanges;

	@FindBy(xpath="//div[contains(text(),'Please select a photo type before you save changes.')]")
	public WebElement errorMessage;


	/*********Manage DNR page ***************/
	@FindBy(xpath="//h1[text()='Manage DNR']")
	public WebElement labelManageDNR;

	public String LINK_CREATE_DNR="//a[text()=' Create dnr']";
	@FindBy(xpath="//a[text()=' Create dnr']")
	public WebElement createDNR;

	/***********Create DNR Page****************/
	@FindBy(xpath="//h1[text()='Create DNR']")
	public WebElement labelCreateDNR;

	@FindBy(id="from-date")
	public WebElement fromDate;
	
	@FindBy(xpath=".//*[@title='Create dnr']")
	public WebElement btnCreateDNR;

	@FindBy(id="to-date")
	public WebElement toDate;

	@FindBy(id="include_sent")
	public WebElement checkboxSent;

	@FindBy(id="include_unsent")
	public WebElement checkboxUnsent;

	@FindBy(id="dnr-search")
	public WebElement btnDNRSearch;

	public String tblResultsDNRXpath="//table[@id='searched-press-releases']";
	@FindBy(xpath="//table[@id='searched-press-releases']")
	public WebElement tblResultsDNR;

	@FindBys(@FindBy(xpath="//table[@id='searched-press-releases']/tbody/tr/td[1]"))
	public List<WebElement> listCheckboxTblResultsDNR;
	
	@FindBys(@FindBy(xpath="//table[@id='searched-press-releases']/tbody/tr[1]/td[1]"))
	public WebElement listCheckboxFirstDNR;

	@FindBys(@FindBy(xpath="//table[@id='searched-press-releases']/tbody/tr/td[2]"))
	public List<WebElement> listTitleTblResultsDNR;

	@FindBy(id="dnr-add-press-release")
	public WebElement btnAddToDNR;

	@FindBy(xpath="//table[@id='add-press-releases']")
	public WebElement tblAddedReleases;

	@FindBys(@FindBy(xpath="//table[@id='add-press-releases']/tbody/tr/td[3]"))
	public List<WebElement> listTitleTblAddedDNR;	

	@FindBys(@FindBy(xpath="//table[@id='add-press-releases']/tbody/tr/td[4]/select"))
	public List<WebElement> listDivisonTblAddedDNR;

	@FindBys(@FindBy(xpath="//table[@id='add-press-releases']/tbody/tr/td[5]/select"))
	public List<WebElement> listNetworkTblAddedDNR;	

	@FindBys(@FindBy(xpath="//table[@id='add-press-releases']/tbody/tr/td[2]/input"))
	public List<WebElement> listCheckboxTblAddedDNR;	

	@FindBy(id="dnr-preview")
	public WebElement btnSavePreview;

	@FindBy(id="edit-field-dnr-send-immediately-und")
	public WebElement checkboxSendImmediately;

	@FindBy(id="edit-field-dnr-schedule-time-date")
	public WebElement btnScheduleDate;

	@FindBy(xpath="//h1[text()='Preview']")
	public WebElement labelPreview;

	@FindBy(xpath="//a[@title='Close preview']")
	public WebElement closePreview;

	@FindBy(xpath="//*[text()='Please select send immediately / schedule date & time for the DNR.']")
	public WebElement errorMessageSelectSchedule;
	
	@FindBy(xpath=".//*[@id='edit-field-dnr-comments-und-0-value']")
	public WebElement commentsDNR;
	
	@FindBy(xpath=".//*[@id='test-email']")
	public WebElement emailChechBoxDNR;
	
	@FindBy(xpath=".//*[@id='test-email-ids']")
	public WebElement emailTextFieldDNR;
	
	@FindBy(xpath=".//*[@id='send-test-email']")
	public WebElement emailButtonDNR;

	@FindBy(xpath=".//*[@id='dnr-publish']")
	public WebElement saveAndPublishDNR;
	
	@FindBy(xpath="(.//*[@class='dnr-select-box'])[@name='press-release-division'][1]")
	public WebElement divisionDNR;
	
	@FindBy(xpath="(.//*[@class='dnr-select-box'])[@name='press-release-network'][1]")
	public WebElement networkDNR;
	
	
	/**********Preview frame***********/

	@FindBys(@FindBy(xpath="//div[@class='dnr-preview']/div[@style='padding-left: 80px']/p/a"))
	public List<WebElement> titlesOnPreviewFrame;

	/*************************Manage Users Requests & Access Page********************/
	public String labelManageUsersAccessXpath="//*[text()='Manage Users Requests & Access']";
	@FindBy(xpath="//*[text()='Manage Users Requests & Access']")
	public WebElement labelManageUsersAccess;

	@FindBy(id="edit-field-last-profile-updated-value-min-date")
	public WebElement lastUpdatedDate;

	@FindBy(id="edit-submit-users-management")
	public WebElement btnSearch;

	@FindBy(xpath="//p[@class='no-result-msg-centre'][text()='No users can be found for the given criteria. Please change the search criteria and try again.']")
	public WebElement noSearchResultMsg;
	
	public String resultTableXpath="//table[@id='add-network']";
	@FindBy(xpath="//table[@id='add-network']")
	public WebElement resultTable;
	
	@FindBys(@FindBy(xpath="//table[@id='add-network']/thead/tr/th"))
	public List<WebElement> resultTableHeaders;
	
	@FindBy(xpath="//div[@class='message-storage']")
	public WebElement storageMsg;

	@FindBy(xpath="//div[@class='messages error']")
	public WebElement errorMsg;
	
	@FindBy(id="edit-field-screeners-value")
	public WebElement dropdownScreenerAccessUserSearch;
	
	@FindBy(id="edit-field-user-status-value")
	public WebElement dropdownStatusValueUserSearch;
	

	//Feb 17th

	@FindBy(xpath="//a[@title='Create New User']")
	public WebElement linkCreateUser;

	/******************Create User web page**************/

	@FindBy(xpath="//*[@id='edit-field-account-first-name-und-0-value']")
	public WebElement inputFirstNameUser;

	@FindBy(xpath="//*[@id='edit-field-account-last-name-und-0-value']")
	public WebElement inputLastNameUser;

	@FindBy(xpath="//*[@id='edit-mail']")
	public WebElement inputEmailUser;

	@FindBy(xpath="//*[@id='edit-field-media-type-television-und']")
	public WebElement checkboxTelevisionMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-media-type-radio-station-und']")
	public WebElement checkboxRadioMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-media-type-cable-network-und']")
	public WebElement checkboxCableNetworkMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-media-type-magazine-und']")
	public WebElement checkboxMagazineMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-magazine-circulation-und-0-value']")
	public WebElement inputMagazineMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-media-type-newspaper-und']")
	public WebElement checkboxNewsPaperMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-newspaper-circulation-und-0-value']")
	public WebElement inputNewsPaperMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-media-type-internet-und']")
	public WebElement checkboxInternetMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-internet-circulation-und-0-value']")
	public WebElement inputInternetMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-media-type-other-und']")
	public WebElement checkboxOtherMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-other-circulation-und-0-value']")
	public WebElement inputOtherMediaTypeUser;

	@FindBy(xpath="//*[@id='edit-field-personal-title-und-0-value']")
	public WebElement inputTitleUser;

	@FindBy(xpath="//*[@id='edit-field-address-und-0-value']")
	public WebElement inputAddressUser;

	@FindBy(xpath="//*[@id='edit-field-city-und-0-value']")
	public WebElement inputCityUser;

	@FindBy(xpath="//select[@id='edit-field-state-und']")
	public WebElement dropdownStateUser;

	@FindBy(xpath="//*[@id='edit-field-country-und-0-value']")
	public WebElement inputCountryUser;

	@FindBy(xpath="//*[@id='edit-field-zip-code-no-und-0-value']")
	public WebElement inputZipUser;

	@FindBy(xpath="//*[@id='edit-field-personal-phone-no-und-0-value']")
	public WebElement inputPhoneUser;

	@FindBy(xpath="//*[@id='edit-field-fax-no-und-0-value']")
	public WebElement inputFaxUser;

	@FindBy(xpath="//*[@id='edit-field-company-url-und-0-value']")
	public WebElement inputCompanyWebsiteUser;

	@FindBy(xpath="//*[@id='edit-field-company-und-0-value']")
	public WebElement inputCompanyUser;

	@FindBy(xpath="//*[@id='edit-field-contact-person-und-0-value']")
	public WebElement inputNBCUContactUser;

	@FindBy(xpath="//*[@id='edit-field-tca-member-confirmation-und']")
	public WebElement checkboxTCAMemberUser;

	@FindBy(xpath="//*[@id='edit-field-subscribe-daily-news-und']")
	public WebElement checkboxSubscribeToDailyNewsUser;

	@FindBy(xpath="//*[@id='edit-field-subscribe-to-photo-alerts-und']")
	public WebElement checkboxSubsribeToPhotoAlertUser;

	@FindBy(xpath="//*[@id='edit-field-subscribe-photo-alerts-und']")
	public WebElement checkboxSubsribeToPhotoAlertMVUser;

	@FindBy(xpath="//*[@id='edit-field-subscribe-screener-alerts-und']")
	public WebElement checkboxSubsribeToScreenerAlertUser;

	@FindBy(xpath="//*[@id='edit-field-subscribe-epk-alerts-und']")
	public WebElement checkboxSubsribeToEPKAlertUser;

	//REQUESTED ACCESS SETTINGS
	@FindBy(xpath="//*[@id='edit-field-photo-download-for-web-und']")
	public WebElement checkboxWebRequestAccessUser;
	@FindBy(xpath="//*[@id='edit-field-photo-download-for-print-und']")
	public WebElement checkboxPrintRequestAccessUser;
	@FindBy(xpath="//*[@id='edit-field-epk-download-und']")
	public WebElement checkboxEPKRequestAccessUser;
	@FindBy(xpath="//*[@id='edit-field-photo-purpose-usage-und-0-value']")
	public WebElement textAreaPhotoPurposeUser;
	@FindBy(xpath="//*[@id='edit-field-epk-purpose-usage-und-0-value']")
	public WebElement textAreaEPKPurposeUser;
	@FindBy(xpath="//div[@class='fleft screener-access-wrap']/descendant::div[@class='form-label']/label")
	public WebElement screenerLabelReqAccess;
	@FindBy(xpath="//div[@class='fleft screener-access-wrap']/descendant::div[@class='form-input']/descendant::label")
	public WebElement streamingLabelReqAccess;
	@FindBy(xpath="//*[@id='edit-field-screener-streaming-und']")
	public WebElement checkboxScreenerStreaming;
	@FindBy(xpath="//div[@class='fleft screener-access-wrap']/descendant::div[@class='clearfix purpose']/descendant::label")
	public WebElement usageScreenerLabelReqAccess;
	@FindBy(xpath="//*[@id='edit-field-screener-purpose-usage-und-0-value']")
	public WebElement textAreaScreenerPurposeUser;
	

	//ACCESS SETTINGS:
	//photos
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-photos-und-0']")
	public WebElement radioBtnNoAccessPhotosUser;
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-photos-und-1']")
	public WebElement radioBtnLowResolutionPhotosUser;
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-photos-und-2']")
	public WebElement radioBtnHighResolutionPhotosUser;
	@FindBy(xpath="//input[@type='text'][@id='edit-field-limit-per-pay-und-0-value']")
	public WebElement inputLimitPerDayPhotosUser;
	@FindBy(xpath="//input[@type='text'][@id='edit-field-temp-limit-und-0-value']")
	public WebElement inputTempLimitPhotosUser;
	@FindBy(xpath="//input[@type='text'][@id='edit-field-exp-date-und-0-value']")
	public WebElement inputExpiryDatePhotosUser;

	//EPKs
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-epks-und-1']")
	public WebElement radioBtnNoAccessEPKUser;
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-epks-und-2']")
	public WebElement radioBtnStreamingAccessEPKUser;
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-epks-und-3']")
	public WebElement radioBtnDownloadAccessEPKUser;

	//Screener
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-screeners-und-1']")
	public WebElement radioBtnNoAccessScreenerUser;
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-screeners-und-2']")
	public WebElement radioBtnScreenerAccessUser;
	//Screener Access By Network - dynamic xpath required
	@FindBy(id="edit-field-programming-screener-und")
	public WebElement programmingScreenerAccess;
	@FindBy(id="edit-field-studios-and-distribution-s-und")
	public WebElement sdScreenerAccess;
	@FindBy(id="edit-field-digital-media-screener-und")
	public WebElement dmScreenerAccess;
	@FindBy(id="edit-field-parks-screener-und")
	public WebElement parksScreenerAccess;
	@FindBy(id="edit-field-corporate-screener-und")
	public WebElement corpScreenerAccess;
	//USER ACCESS MANAGEMENT:
	//Message type
	@FindBy(xpath="//select[@id='edit-field-message-type-und']")
	public WebElement dropdownMsgTypeUser;
	//Access
	@FindBy(xpath="//input[@id='edit-status-1'][@type='radio']")
	public WebElement radioBtnAccessApproveUser;
	@FindBy(xpath="//input[@id='edit-status-0'][@type='radio']")
	public WebElement radioBtnAccessDenyUser;
	@FindBy(xpath="//select[@id='edit-field-international-und']")
	public WebElement dropdownAccessDenyReasonUser;
	@FindBy(xpath="//select[@id='edit-type-of-expiration']")
	public WebElement dropdownAccessApproveExpDateUser;
	@FindBy(xpath="//select[@id='edit-field-approval-reason-und']")
	public WebElement dropdownAccessApproveReasonUser;
	@FindBy(xpath="//textarea[@id='edit-field-note-und-0-value']")
	public WebElement textAreaAuthorCommentUser;
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-email-to-be-sent-und-0']")
	public WebElement radioBtnEmailToBeSentNoUser;
	@FindBy(xpath="//input[@type='radio'][@id='edit-field-email-to-be-sent-und-1']")
	public WebElement radioBtnEmailToBeSentYesUser;
	//Create New account button
	@FindBy(xpath="//input[@type='submit'][@id='edit-submit']")
	public WebElement btnCreateNewUserAccount;
	@FindBy(xpath="//input[@type='button'][@id='cancel-back']")
	public WebElement btnCancelUserAccount;
	@FindBy(xpath="//input[@type='button'][@id='user-account-author-update']")
	public WebElement btnSaveUpdateUserAccount;


	//error message for invalid phone number
	@FindBy(xpath="//*[text()='Please enter the phone number in a valid format.']")
	public WebElement msgPhoneNumInvalid;
	@FindBy(xpath="//*[text()='Please enter the fax number in a valid format.']")
	public WebElement msgFaxNumInvalid;

	//success message
	@FindBys(@FindBy(xpath="//div[@class='messages status']/ul/child::*"))
	public List<WebElement> successfullySavedMsg;

	//search
	@FindBy(xpath="//input[@id='edit-submit-users-management'][@value='Search']")
	public WebElement searchUserMgmt;

	//delete Message
	@FindBy(xpath="//div[@class='cancel_message']")
	public WebElement msgDeleteUserAccount;

	//xls
	@FindBy(xpath="//a/img[@title='XLS']")
	public WebElement XLSButton;

	@FindBy(xpath="//*[text()='Data export successful']")
	public WebElement dataExportSuccessfulMsg;

	//media type drop down for search
	@FindBy(xpath="//select[@id='media-type-dropdown']")
	public WebElement mediaTypeDropdownSearchUser;
	
	@FindBy(id="edit-field-account-first-name-value")
	public WebElement fnameUserSearch;
	@FindBy(id="edit-field-account-first-name-value")
	public WebElement lnameUserSearch;
	@FindBy(id="edit-field-personal-title-value")
	public WebElement titleUserSearch;
	@FindBy(id="edit-field-company-value")
	public WebElement compUserSearch;
	@FindBy(id="edit-field-address-value")
	public WebElement addUserSearch;
	@FindBy(id="edit-field-city-value")
	public WebElement cityUserSearch;
	@FindBy(id="edit-field-state-value")
	public WebElement stateUserSearch;
	@FindBy(id="edit-field-zip-code-no-value")
	public WebElement zipUserSearch;
	@FindBy(id="edit-field-country-value")
	public WebElement countryUserSearch;
	@FindBy(id="edit-field-personal-phone-no-value")
	public WebElement phoneUserSearch;
	@FindBy(id="edit-field-fax-no-value")
	public WebElement faxUserSearch;
	@FindBy(id="edit-field-company-url-value")
	public WebElement websiteUserSearch;	
	@FindBy(id="edit-field-contact-person-value")
	public WebElement nbcContactUserSearch;

	@FindBy(id="edit-reset")
	public WebElement clearUserSearchBtn;
	
	/************Manage Photo Page***************/

	public String labelManagePhotosXpath="//h1[text()='Manage Photos']";
	@FindBy(xpath="//h1[text()='Manage Photos']")
	public WebElement labelManagePhotos;

	@FindBy(xpath="//a[text()=' Create Photos']")
	public WebElement linkCreatePhotos;

	/************Create Photo Page***************/

	public String labelCreatePhotosXpath="//h1[text()='Create Photos']";
	@FindBy(xpath="//h1[text()='Create Photos']")
	public WebElement labelCreatePhotos;

	@FindBy(id="edit-title")
	public WebElement photoFileName;

	@FindBy(id="edit-field-photo-type-und")
	public WebElement dropdownPhotoType;

	@FindBy(id="edit-field-photo-creation-date-show")
	public WebElement inputPhotoCreationDate;

	@FindBy(id="edit-field-copyright-en-0-value")
	public WebElement inputCopyright;

	@FindBy(id="edit-field-nup-id-und-0-value")
	public WebElement inputNupID;

	@FindBy(id="edit-field-dpl-file-number-und-0-value")
	public WebElement inputDPLFileNum;

	@FindBy(id="edit-field-dpl-program-title-und-0-value")
	public WebElement inputDPLProgTitle;

	@FindBy(id="edit-field-division-collection-und-0-field-division-und")
	public WebElement dropdownDivisonCreatePhoto;

	@FindBy(id="edit-field-network-collection-und-0-field-network-reference-und")
	public WebElement dropdownNetworkCreatePhoto;

	@FindBy(id="edit-field-shows-collection-und-0-field-shows-reference-und")
	public WebElement dropdownShowCreatePhoto;

	@FindBy(id="edit-field-program-event-collection-und-0-field-event-reference-und")
	public WebElement dropdownEventCreatePhoto;
	
	@FindBy(xpath=".//*[@id='edit_field_shows_collection_und_0_field_episode_reference_und_chosen']/a")
	public WebElement dropdownEpisodeCreatePhoto;
	
	@FindBy(xpath=".//*[@id='edit-field-thumbnail-only-und']")
	public WebElement checkBoxShowThumbnailOnly;

	@FindBy(id="edit-field-photo-air-date-show")
	public WebElement inputPhotoAirDate;

	@FindBy(id="edit-field-photo-air-date-text-en-0-value")
	public WebElement inputPhotoAirDateText;

	@FindBy(id="edit-field-lbx-lowres-image-path-und-0-value")
	public WebElement inputImagePath;
	
	@FindBy(xpath=".//*[@id='edit-field-photo-dimensions-und-0-value']")
	public WebElement inputImagePhotoDimension;

	@FindBy(id="edit-field-live-start-date")
	public WebElement inputLiveStartDate;

	@FindBy(id="edit-field-live-end-date")
	public WebElement inputLiveEndDate;
	
	@FindBy(xpath=".//*[@id='edit-field-show-season-und-0-value']")
	public WebElement inputShowSeason;


	//WebElements to set the data in CKEditor
	@FindBys(@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']"))
	public List<WebElement> ckEditorFrames;

	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	public WebElement ckEditorFramesbody;

	//WebElements to set Lowres Image Path
	@FindBy(xpath="//a[text()='link']")
	public WebElement imceLink;

	@FindBy(xpath="//table[@id='file-list']/tbody/tr[2]/td[1]")
	public WebElement tblImageFile;

	@FindBy(xpath="//div[@id='file-preview']/a[@title='Insert file']")
	public WebElement linkFileInsert;
	
	//GLOBAL SEARCH
	
	@FindBy(id="edit-search-type-0")
	public WebElement radioButtonAll;
	@FindBy(id="edit-search-type-1")
	public WebElement radioButtonAssets;
	@FindBy(id="edit-search-type-2")
	public WebElement radioButtonHierarchy;
	@FindBy(id="edit-assets")
	public WebElement dropdownAssetType;
	@FindBy(id="edit-hierarchy")
	public WebElement dropdownHierarchyType;
	
	
	

	/***********Common Links***************/

	/************Create News***************/

	@FindBy(xpath="//a[text()='Manage News']")
	public WebElement subMenuManageNews;

	@FindBy(xpath="//a[contains(text(),'Create News')]")
	public WebElement linkCreateNews;

	@FindBy(id="edit-field-press-release-type-und")
	public WebElement dropdownPressRelType;

	@FindBy(id="edit-title-field-en-0-value")
	public WebElement textTitle;

	@FindBy(id="edit-field-press-release-date-show")
	public WebElement newsDate;

	/**************Manage Exec Bio *************/

	@FindBy(xpath="//a[text()='Manage Executive Bios']")
	public WebElement subMenuManageExecutiveBios;

	@FindBy(xpath="//a[contains(text(),'Create Executive Biographies')]")
	public WebElement linkCreateExecBio;

	@FindBy(id="edit-field-division-collection-bios-und-0-field-division-und")
	public WebElement dropdowndivisionExecBio;

	@FindBy(id="edit-field-network-collection-bios-und-0-field-network-reference-und")
	public WebElement dropdownnetworkExecBio;

	@FindBy(id="edit-field-event-collection-bios-und-0-field-event-reference-und")
	public WebElement dropdowneventExecBio;


	//	---------------------- MV Application Objects -----------------------

	@FindBy(id="input_username")
	public WebElement mvUserName;

	@FindBy(id="input_password")
	public WebElement mvPassword;

	@FindBy(id="button_submit")
	public WebElement mvSignIn;

	@FindBy(xpath="//li[@id='field_current_password']/descendant::input[@name='user_data.current_password']")
	public WebElement currentPassword;

	@FindBy(xpath="//li[@id='field_password']/descendant::input[@name='user_data.password']")
	public WebElement newPassword;


	@FindBy(css="span.icon-search")
	public WebElement mvGlobalSearch;

	@FindBy(id="search-input")
	public WebElement mvSearchTextBox;

	@FindBy(xpath=".//*[@id='peopleColumn1']/div[1]/a")
	public WebElement mvPeopleSearchGlobal;

	@FindBy(xpath=".//*[@id='search-panel']/a[2]")
	public WebElement mvGlobalSearchClear;


	@FindBy(xpath=".//div/ul/li[4]/a")
	public WebElement mvManageUser;

	@FindBy(xpath=".//a[contains(text(),'Manage User Requests & Access')]")
	public WebElement mvSubOption;

	@FindBy(xpath=".//a[contains(text(),'Edit')])[2]")
	public WebElement mvEditUser;

	//added as part of the sprint 34

	@FindBy(xpath=".(//a[contains(@href, '#')])[4]")
	public WebElement mvRegisterlINK;

	@FindBy(xpath=".//div[@id='content']/p[2]/a")
	public WebElement mvTermsOfUse ;

	//Screener Ordering

	@FindBy(xpath="//a[@title='Login']")
	public WebElement linkLogin;

	@FindBy(xpath="//a[text()='Channels']")
	public WebElement linkChannels;

	@FindBy(xpath="//a[text()='Groups']")
	public WebElement linkGroups;

	@FindBy(xpath="//a[text()='Properties']")
	public WebElement linkProperties;

	@FindBy(xpath="//section[@class='subnav-details channel-logos-wrap'][@style='display: block;']/ul[@class='channel-logos clearfix']")
	public WebElement sectionChannelDisplayed;
	
	@FindBy(xpath="//section[@class='subnav-details shows-wrap'][@style='display: block;']")
	public WebElement sectionShowDisplayed;
	
	@FindBy(xpath="//a[@title='view all screeners'][text()='View All']")
	public WebElement linkViewScreener;

	@FindBy(xpath="(//div[@class='align-right epk-content-container'])[1]/h3")
	public WebElement recentShowScreener;

	@FindBy (xpath="//a[@title='Logout']")
	public WebElement mvLogout;

	@FindBy(xpath="//a[text()='screeners']")
	public WebElement screenerNetwork;

	@FindBy(xpath="//a[text()='talent bios']")
	public WebElement talentBioLinkNetwork;

	//Global Search for mv application
	@FindBy(xpath="//a[@title='search']")
	public WebElement linkGlobalSearch;

	@FindBy(xpath="//input[@id='search-input']")
	public WebElement inputGlobalSearchText;

	public String labelSearchResultsXpath="//*[text()='search results']";
	@FindBy(xpath="//*[text()='search results']")
	public WebElement labelSearchResults;

	@FindBy(xpath="//a[@title='view all photos']")
	public WebElement linkViewAllPhotos;

	@FindBys(@FindBy(xpath="//div[@class='photo-name grid-subtext']/a"))
	public List<WebElement> listLinksPublishedPhotos;

	@FindBy(xpath="//a[@title='view all bios']")
	public WebElement linkViewAllBios;

	@FindBys(@FindBy(xpath="//div[@class='block-title']/a"))
	public List<WebElement> listLinksPublishedBios;

	@FindBy(xpath="//a[text()='Haga clic para Español']")
	public WebElement clickForSpanishLink;

	@FindBy(xpath="//a[text()='Click for English']")
	public WebElement clickForEnglishLink;

	@FindBy(xpath="//a[text()='filtrar']")
	public WebElement filterSpanishLink;

	@FindBy(id="lastnamefilter")
	public WebElement lastNameInputFilter;

	@FindBy(id="filter_exec_bio_grid_submit")
	public WebElement searchFilterButtonExecBio;

	@FindBy(id="filter_corporate_exec_bio_grid_submit")
	public WebElement searchFilterButtonExecBioCorp;

	@FindBy(id="filter_bio_grid_submit")
	public WebElement searchFilterButton;

	@FindBy(xpath="//a[text()='Read More ']")
	public WebElement readMoreLink;

	@FindBy(xpath="//ul/li/a[text()='epks']")
	public WebElement epksLinkNetworkPage;

	@FindBy(xpath="//ul/li/a[text()='photos']")
	public WebElement photosLinkNetworkPage;

	@FindBy(xpath="//div[@class='alert-subscription-message'][contains(text(),'Email alerts announcing new photos and epks are available')]")
	public WebElement subscriptionAlertMessageEPKsPhotos;

	@FindBy(xpath="//div[@class='alert-subscription-message'][contains(text(),'Email alerts announcing new screeners are available')]")
	public WebElement subscriptionAlertMessageScreener;

	@FindBy(xpath="//a[contains(text(),'See all shows')]")
	public WebElement seeAllShowsLinkNetworkPage;

	@FindBy(xpath="//a[contains(text(),'See all titles ')]")
	public WebElement seeAllTitlesLinkNetworkPage;

	@FindBy(xpath="//a[contains(text(),'See all stations')]")
	public WebElement seeAllStationsLinkNetworkPage;


	//3/28/2015
	@FindBy(xpath="//a[contains(text(),'See all talent bios')]")
	public WebElement seeAllTalentBios;

	@FindBy(xpath="//a[text()='filter']")
	public WebElement filterLink;

	@FindBy(id="keyword")
	public WebElement keywordFilter;
	
	@FindBy(id="photo_filter_submit")
	public WebElement searchBtnPhoto;
	
	@FindBy(id="talane_bio_details_filter_submit")
	public WebElement searchBioSummPageBtn;
	
	@FindBy(xpath="//*[text()='No photos available.']")
	public WebElement noPhotoAvailMsg;
	
	@FindBy(xpath="//label[@for='bio-news_filter_chk']")
	public WebElement newsFilterCheckbox;
	@FindBy(xpath="//label[@for='bio-photos_filter_chk']")
	public WebElement photosFilterCheckbox;
	@FindBy(xpath="//label[@for='bio-shows_filter_chk']")
	public WebElement showsFilterCheckbox;
	@FindBy(xpath="//label[@for='bio-epks_filter_chk']")
	public WebElement epksFilterCheckbox;
	@FindBy(xpath="//label[@for='bio-events_filter_chk']")
	public WebElement eventsFilterCheckbox;

	@FindBy(xpath="//a[text()='more']")
	public WebElement moreLink;

	@FindBys(@FindBy(xpath="//div[@class='block-info clearfix']/span"))	
	public List<WebElement> mediaType;

	@FindBy(xpath="//a[text()='Programming']")
	public WebElement programmingDivLink;
	@FindBy(xpath="//a[text()='Studios & Distribution']")
	public WebElement studiosDistributionDivLink;
	@FindBy(xpath="//a[text()='Owned Stations']")
	public WebElement ownedStationsDivLink;
	@FindBy(xpath="//a[text()='Digital Media']")
	public WebElement digitalMediaDivLink;
	@FindBy(xpath="//a[text()='Parks']")
	public WebElement parksDivLink;
	@FindBy(xpath="//a[text()='Corporate']")
	public WebElement corporateLink;

	@FindBy(xpath="//a[contains(text(),'Shows')]")
	public WebElement linkShows;
	@FindBy(xpath="//a[contains(text(),'People')][@id='subnav-action-people']")
	public WebElement linkPeople;
	@FindBy(xpath="//a[contains(text(),'Titles')][@id='subnav-action-shows']")
	public WebElement linkTitles;
	@FindBy(xpath="//a[contains(text(),'Stations')][@id='subnav-action-shows']")
	public WebElement linkStations;
	@FindBy(xpath="//a[contains(text(),'Events & shows')]")
	public WebElement linkEventsShows;
	@FindBy(xpath="//a[contains(text(),'Attractions & shows')]")
	public WebElement linkAttrationShows;
	@FindBy(xpath="//a[text()='Back to Bio Summary']")
	public WebElement linkBackToBioSummary;
	@FindBy(xpath="//a[text()='executive bios']")
	public WebElement linkExecutiveBios;
	@FindBy(xpath="//span[contains(text(),'Back')]")
	public WebElement backButton;
	@FindBy(xpath="//*[text()='There are no results to display for the selected criteria.']")
	public WebElement noResultforFilterMessage; 
	
	@FindBy(xpath="//*[text()='bios']")
	public WebElement labelBios;
	@FindBy(xpath="//*[text()='No Executive Bios found.']")
	public WebElement noExecBioFoundMsg;

	@FindBy(xpath="//section[@id='inner-container']/div[2]/descendant::a[text()='filter']")
	public WebElement photoFilterlink; 
	
	@FindBys(@FindBy(xpath="//span[@title='photo']"))
	public List<WebElement> photosOnBioSummPage;

	//screener summary page
	@FindBy(xpath="//h3[@class='medium-txt darkish-gray-color episode-name']")
	public WebElement screenerTitleCoverPage;
	@FindBy(xpath="//p[@class='darkish-gray-color medium-txt episode-expires-date']")
	public WebElement expDateScreenerCoverPage;
	@FindBy(xpath="//div[@class='dark-gray-color medium-txt']")
	public WebElement coverDescScreenerCoverPage;
	@FindBy(xpath="//figure/a/img")
	public WebElement imgScreenerCoverPage;
	@FindBy(xpath="//a[text()='CONTINUE TO SCREENER']")
	public WebElement continueToScreenerLink;
	@FindBy(xpath="//a[text()='BACK TO LIST']")
	public WebElement backToListLink;
	@FindBy(xpath="//li[@class='last-item']/a/img")
	public WebElement secNavNWScreenerCoverPage;
	@FindBy(xpath="//span[text()='Back']")
	public WebElement expandBtnSecNavNWScreenerCoverPage;
	

	/***********Register User*************/
	public String registerLinkXpath="//a[text()='Register']";
	@FindBy(xpath="//a[text()='Register']")
	public WebElement registerLink;
	@FindBy(xpath="//input[@name='user_data.email']")
	public WebElement emailAddressUserReg;
	@FindBy(xpath="//input[@name='user_data.firstname']")
	public WebElement firstNameUserReg;
	@FindBy(xpath="//input[@name='user_data.lastname']")
	public WebElement lastNameUserReg;
	@FindBy(xpath="//input[@name='user_data.name']")
	public WebElement companyNameUserReg;
	@FindBy(xpath="//input[@name='user_data.personal_title']")
	public WebElement titleUserReg;
	@FindBy(xpath="//input[@name='user_data.url']")
	public WebElement companyURLUserReg;
	@FindBy(xpath="//input[@name='user_data.contact_person']")
	public WebElement nbcuContactUserReg;
	@FindBy(xpath="//input[@name='user_data.department']")
	public WebElement companyDeptUserReg;
	@FindBy(xpath="//select[@name='user_data.nbcu_employee']")
	public WebElement dropdownNbcuEmployee;
	@FindBy(xpath="//input[@name='user_data.phone']")
	public WebElement phoneUserReg;
	@FindBy(xpath="//input[@name='user_data.fax_no']")
	public WebElement faxUserReg;
	@FindBy(xpath="//input[@name='user_data.address1']")
	public WebElement address1UserReg;
	@FindBy(xpath="//input[@name='user_data.address2']")
	public WebElement address2UserReg;
	@FindBy(xpath="//input[@name='user_data.city']")
	public WebElement cityUserReg;
	@FindBy(xpath="//select[@name='user_data.state']")
	public WebElement dropdownStateUserReg;
	@FindBy(xpath="//select[@name='user_data.country']")
	public WebElement dropdownCountryUserReg;
	@FindBy(xpath="//input[@name='user_data.postalcode']")
	public WebElement zipCodeUserReg;
	@FindBy(xpath="//select[@name='user_data.television']")
	public WebElement dropdownTVUserReg;
	@FindBy(xpath="//select[@name='user_data.cable_network']")
	public WebElement dropdownCableNetworkUserReg;
	@FindBy(xpath="//select[@name='user_data.radio_station']")
	public WebElement dropdownRadioUserReg;
	@FindBy(xpath="//select[@name='user_data.newspaper']")
	public WebElement dropdownNewspprUserReg;
	@FindBy(xpath="//input[@name='user_data.newspaper_circulation']")
	public WebElement newsPprCirculationUserReg;
	@FindBy(xpath="//select[@name='user_data.magazine']")
	public WebElement dropdownMagazineUserReg;
	@FindBy(xpath="//input[@name='user_data.magazine_circulation']")
	public WebElement magazineCirculationUserReg;
	@FindBy(xpath="//select[@name='user_data.internet']")
	public WebElement dropdownInternetUserReg;
	@FindBy(xpath="//input[@name='user_data.internet_circulation']")
	public WebElement internetCirculationUserReg;
	@FindBy(xpath="//select[@name='user_data.photo_print']")
	public WebElement dropdownPhotoAccessPrintUserReg;
	@FindBy(xpath="//select[@name='user_data.photo_web']")
	public WebElement dropdownPhotoAccessWebUserReg;
	@FindBy(xpath="//input[@name='user_data.photos_purpose']")
	public WebElement photoUsageIntentUserReg;
	@FindBy(xpath="//select[@name='user_data.epk_download']")
	public WebElement dropdownEPKAccessDownloadUserReg;
	@FindBy(xpath="//select[@name='user_data.epk_streaming']")
	public WebElement dropdownEPKAccessStreamingUserReg;
	@FindBy(xpath="//input[@name='user_data.epks_purpose']")
	public WebElement epkUsageIntentUserReg;
	@FindBy(xpath="//select[@name='user_data.screeners_streaming']")
	public WebElement dropdownScreenerAccessStreamingUserReg;
	@FindBy(xpath="//input[@name='user_data.screeners_purpose']")
	public WebElement screenerUsageIntentUserReg;
	@FindBy(xpath="//select[@name='user_data.tca_member']")
	public WebElement dropdownTCAMemeberUserReg;
	@FindBy(xpath="//select[@name='user_data.photo_alerts_subscriber']")
	public WebElement dropdownSubscribePhotoEblastUserReg;
	@FindBy(xpath="//select[@name='user_data.photo_eblast_subscriber']")
	public WebElement dropdownSubscribePhotoAlertUserReg;
	@FindBy(xpath="//select[@name='user_data.epks_alerts_subscriber']")
	public WebElement dropdownSubscribeEPKAlertUserReg;
	@FindBy(xpath="//select[@name='user_data.daily_news_subscriber']")
	public WebElement dropdownSubscribeDailyNewsUserReg;
	@FindBy(xpath="//select[@name='user_data.screeners_alerts_subscriber']")
	public WebElement dropdownSubscribeMVScreenerAlertUserReg;
	@FindBy(xpath="//input[@name='user_data.feedback_comments']")
	public WebElement commentsUserReg;
	@FindBy(id="button_submit")
	public WebElement btnSubmitRegReq;
	@FindBy(xpath="//h1[text()='Request for A New Account']")
	public WebElement labelReqForNewAccount;
	@FindBy(xpath="//p[@class='reg-success-msg']")
	public WebElement successRegistrationMessage;
	@FindBys(@FindBy(xpath="//div[@class='notice']/p[@class='error']"))
	public List<WebElement> errorRegistrationMessageList;
	@FindBys(@FindBy(xpath="//div[@id='general_error_container'][text()='Please correct the errors found in the highlighted fields.']"))
	public WebElement errorRegistrationMessage;

	/******************YOP MAIL ********************************/
	@FindBy(xpath="//input[@id='login']")
	public WebElement emailYopMail;
	@FindBy(xpath="//input[@title='Check inbox @yopmail.com']")
	public WebElement checkInboxYopMail;
   /************************************************************/
	@FindBy(xpath="//a[text()='My Account']")
	public WebElement myAccount;

	@FindBy(xpath="//div[@class='button_close']")
	public WebElement closeFrame;

	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='value_tca_member']")
	public WebElement tcaMemberMyAccount;

	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='value_photo_eblast_subscriber']")
	public WebElement subscribeToPhotoEblastMyAccount;

	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='value_photo_alerts_subscriber']")
	public WebElement subscribeToNewPhotoMyAccount;

	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='value_daily_news_subscriber']")
	public WebElement subscribeToDailyNewsMyAccount;

	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='value_epks_alerts_subscriber']")
	public WebElement subscribeToEPKAlertsMyAccount;

	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='value_screeners_alerts_subscriber']")
	public WebElement subscribeToScreenersAlertsMyAccount;
	
	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='label_screeners_alerts_subscriber']")
	public WebElement subscribeToScreenersAlertsMyAccountLabel;
	
	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='value_screeners_streaming']")
	public WebElement screenerStreamingMyAccount;
	
	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='label_screeners_streaming']")
	public WebElement screenerStreamingMyAccountLabel;
	
	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='value_screeners_purpose']")
	public WebElement screenerPurposeMyAccount;
	
	@FindBy(xpath="//dl[@id='field_list']/descendant::dd[@id='label_screeners_purpose']")
	public WebElement screenerPurposeMyAccountLabel;
	
	@FindBy(id="button_edit_menu")
	public WebElement btnEditMenuMyAccount;
	
	@FindBy(id="button_edit_profile")
	public WebElement btnEditProfileMyAccount;	
	
	@FindBy(xpath="//*[text()='You can change your personal information at any time.']")
	public WebElement editMyAccountLabel;
	
	@FindBy(xpath="//select[@id='edit-type']")
	public WebElement allAssetTypeDropdown;
	
	@FindBy(id="value_firstname")
	public WebElement fnameValMyAccount;
	
	@FindBy(id="value_lastname")
	public WebElement lnameValMyAccount;
	
	@FindBy(id="value_contact_person")
	public WebElement nbcucontactValMyAccount;
	
	@FindBy(id="value_television")
	public WebElement tvValMyAccount;
	
	@FindBy(id="value_epk_streaming")
	public WebElement epkStreamingValMyAccount;
	
	//My account Profile:
	@FindBy(id="label_photos_purpose")
	public WebElement labelPhotoPurpose;

	@FindBy(id="label_epks_purpose")
	public WebElement labelepkspurpose;
	
	@FindBy(xpath="//*[text()='Your change has been saved.']")
	public WebElement successMsgSaveAccountInfo;
	
	
	
	//Cart related objects
	
	@FindBys(@FindBy(xpath="//a[@title='add to cart']"))
	public List<WebElement> addToCartLinksList;
	
	@FindBy(xpath="//a[@title='Go to cart']")
	public WebElement goToCartLink;
	
	@FindBy(xpath="//a[@title='Go to cart']/descendant::span[@id='lbx-cart-item-no']")
	public WebElement cartCount;
	
	@FindBy(xpath="//tr[@class='tfooter']/td[@class='select-all']/span")
	public WebElement selectAllCheckboxCart;
	
	@FindBy(id="download-selected-btn")
	public WebElement downloadSelectedButtonCart;
	
	@FindBy(xpath="(//tr[@class='theader']/th[@class='select-all']/span)[2]")
	public WebElement highResolutionCheckboxCart;
	
	@FindBys(@FindBy(xpath="//tbody[@id='lbxcart-body']/tr/td[@class='select-col'][2]/span"))
	public List<WebElement> checkboxListCartTableHighResolution;
	
	@FindBy(id="remove-item-cart-selected")
	public WebElement removeSelectedButtonCart;
	
	@FindBy(xpath="//*[contains(text(),'Please request an administrator for access.')]")
	public WebElement noAccessScreenerMsg;
	
	//Udham

	@FindBy(xpath="//html/body/div[1]/section/div[3]/aside/div[1]/div/div[1]/a")
	public 
	WebElement mvViewAll ;

	@FindBy(xpath=".//*[@id='load-more-link-wrapper']/a")
	public WebElement mvMore;

	@FindBy(xpath=".//*[@id='inner-content']/div[1]/p/a")
	public WebElement LnkViewAllSearch;


	@FindBy(xpath=".//*[@id='global-search-filter']/li[2]/a")
	public WebElement mvExpandFilter;

	@FindBy(xpath="//a[contains(text(),'Select all')]")
	public WebElement linkSearchAll;

    @FindBy(xpath="//a[@title='view all epks']")
    public WebElement ViewAllEpk;
    
    @FindBy(xpath="//a[text()='Shades of Blue: Fall of Man']")
    public WebElement EpkView;
    @FindBy(xpath="//input[@id='edit-search-type-1']")
    public WebElement radioAssets;
    @FindBy(xpath="//select[@id='edit-assets']")
    public WebElement ListStatus;
    @FindBy(xpath="//input[@id='edit-submit-admin-global-search']")
    public WebElement BtnSearch;
    @FindBy(xpath="//table[@id='add-shows']/tbody/tr[1]/td[2]")
    public WebElement WeBelementEpk;
    @FindBy(xpath="//a[text()='Edit']")
    public WebElement LinkEdit;
    @FindBy(xpath="//html/body/div[1]/div/h1")
    public WebElement WebElementEditEPK;
    @FindBy(xpath="//a[text()='link']")
    public WebElement LnkImage;
    @FindBy(xpath="//input[@id='content-submit-publish-btn']")
    public  WebElement BtnSavePublish;
    @FindBy(xpath="//div[@class='messages status']")
    public  WebElement MsgSuccessEpk;
     @FindBy(xpath="//tr[@id='10825.jpg']")
     public WebElement ImgSelect;
     
     //----------------------Vikas-------------------------------------
     
     @FindBy (xpath="edit-title-search")
 	public WebElement CorporateLink;
     
     @FindBy (xpath=".//*[@id='edit-field-corporate-info-und-about']")
  	public WebElement AboutCheckbox;
     
     @FindBy (xpath=".//*[@id='edit-field-corporate-info-und-contacts']")
   	public WebElement ContactsCheckbox;
     
     @FindBy (xpath=".//*[@id='edit-field-corporate-info-und-executive-bios']")
   	public WebElement ExecutiveBiosCheckbox;
     
     @FindBy (xpath=".//*[@id='edit-field-corporate-info-und-fact-sheet']")
   	public WebElement FactSheetCheckbox;
     
     @FindBy (xpath=".//*[@id='edit-field-corporate-info-und-history']")
   	public WebElement HistoryCheckbox;
     
     @FindBy (xpath=".//*[@id='edit-field-corporate-info-und-news']")
   	public WebElement NewsCheckbox;
     
     @FindBy (xpath=".//*[@id='edit-field-corporate-info-und-photos']")
   	public WebElement PhotosCheckbox;
     
     @FindBy (xpath=".//*[@id='edit-field-corporate-info-und-epks']")
   	public WebElement EPKSCheckbox;
     
     @FindBy (xpath=".//*[@id='content-submit-publish-btn']")
    	public WebElement SaveandPublishbutton;
     
     @FindBy (xpath=".//*[@id='header']/section/div[2]/div/h5")
 	public WebElement EventsSection;
     
     @FindBy (xpath=".//*[@id='header']/section/div[2]/div/ul/li[1]/a")
  	public WebElement WomenatNBCULink;
     
     @FindBy (xpath=".//*[@id='header']/section/div[2]/div/ul/li[2]/a")
   	public WebElement GreeisUniversalLink;
     
     @FindBy (xpath=".//*[@id='header']/section/div[2]/div/a")
    	public WebElement SeeAllEventslLink;
     
     @FindBy (xpath=".//*[@id='header']/section/div[3]/div/h5")
 	public WebElement InfoSection;
     
     @FindBy (xpath=".//*[@id='header']/section/div[3]/div/ul/li[1]/a")
  	public WebElement about;
     
     @FindBy (xpath=".//*[@id='header']/section/div[3]/div/ul/li[2]/a")
   	public WebElement contacts;
	
     @FindBy (xpath=".//*[@id='header']/section/div[3]/div/ul/li[3]/a")
    	public WebElement ExecutiveBios;
     
     @FindBy (xpath=".//*[@id='header']/section/div[3]/div/ul/li[4]/a")
 	public WebElement FactSheet;
     
     @FindBy (xpath=".//*[@id='header']/section/div[3]/div/ul/li[5]/a")
  	public WebElement History;
     
     @FindBy (xpath=".//*[@id='header']/section/div[3]/div/ul/li[6]/a")
   	public WebElement News;
     
     @FindBy (xpath=".//*[@id='header']/section/div[3]/div/ul/li[7]/a")
    	public WebElement Photos;
     
     @FindBy (xpath=".//*[@id='header']/section/div[3]/div/ul/li[8]/a")
 	public WebElement Epks;
     
     @FindBy (xpath=".//*[@id='header']/section/div[4]/div/h5")
  	public WebElement externallinks;
     
     @FindBy (xpath=".//*[@id='news-block-col-corporate']/div")
   	public WebElement NewsFilter;
     
     @FindBy (xpath=".//*[@id='photos-block-col-corporate']/div[1]")
    	public WebElement PhotosFilter;
     
     @FindBy (xpath=".//*[@id='inner-container']/aside/div[1]")
 	public WebElement TweetsViewAll;

     @FindBy (xpath=".//*[@id='inner-container']/aside/div[3]/div[1]")
  	public WebElement InstagramViewAll;
     
     @FindBy (xpath=".//*[@id='inner-container']/aside/div[4]/h1")
   	public WebElement EpksSection;
     
     @FindBy (xpath=".//*[@id='inner-content']/div[3]/div/article[9]")
    	public WebElement TotalEvents;
     
     @FindBy (xpath=".//*[@id='edit-field-event-collection-und-0-field-event-reference-und']")
 	public WebElement EventName1;
     
     @FindBy (xpath=".//*[@id='edit-field-event-collection-und-1-field-event-reference-und']")
  	public WebElement EventName2;
     
     @FindBy (xpath=".//*[@id='edit-field-event-collection-und-2-field-event-reference-und']")
   	public WebElement EventName3;
     
     @FindBy (xpath=".//*[@id='edit-field-external-link-collection-und-0-field-external-link-title-und-0-value']")
   	public WebElement ExternalLink1;
     
     @FindBy (xpath=".//*[@id='edit-field-external-link-collection-und-1-field-external-link-title-und-0-value']")
   	public WebElement ExternalLink2;
     
     @FindBy (xpath=".//*[@id='edit-field-external-link-collection-und-2-field-external-link-title-und-0-value']")
    	public WebElement ExternalLink3;
     
     @FindBy (xpath=".//*[@id='header']/section/div[4]/div/ul/li[1]/a")
    	public WebElement ExternalLinktooltip1;
     
     @FindBy (xpath=".//*[@id='header']/section/div[4]/div/ul/li[2]/a")
    	public WebElement ExternalLinktooltip2;
     
     @FindBy (xpath=".//*[@id='header']/section/div[2]/div/ul/li[2]/a")
 	public WebElement EventFirst;
  
  @FindBy (xpath=".//*[@id='header']/section/div[2]/div/ul/li[1]/a")
 	public WebElement EventSecond;
     
  @FindBy (xpath=".//*[@id='header']/section/div[2]/div/ul/li[9]/a")
	public WebElement TotalExternalLink;
  
  @FindBy (xpath=".//*[@id='header']/div[4]/div[1]/section/div[2]/div/h5")
	public WebElement EventInfoSection;
  
  @FindBy (xpath=".//*[@id='header']/div[4]/div[1]/section/div[4]/div/h5[2]")
	public WebElement EventExternal;
  
  @FindBy (xpath=".//*[@id='news-block-col']/div")
	public WebElement EventNews;
  
  @FindBy (xpath=".//*[@id='inner-container']/div[2]/div[1]")
	public WebElement EventPhotosSection;
  
  @FindBy (xpath=".//*[@id='inner-container']/aside/div[1]")
	public WebElement EventTweets;
  
  @FindBy (xpath=".//*[@id='header']/div[4]/div[1]/section/div[1]/div/figure/img")
	public WebElement EventPhoto;
  
  @FindBy (xpath=".//*[@id='view-more-btn']")
	public WebElement EventMoreLink;
  
  @FindBy (xpath=".//*[@id='block-system-main']/div/div/table/thead/tr/th[1]")
	public WebElement CorporateTitleGrid;
  
  @FindBy (xpath=".//*[@id='block-system-main']/div/div/table/thead/tr/th[3]")
	public WebElement CorporateCreatedDateGrid;
  
  @FindBy (xpath=".//*[@id='block-system-main']/div/div/table/thead/tr/th[2]")
	public WebElement CorporateCreatedByGrid;
  
  @FindBy (xpath=".//*[@id='block-system-main']/div/div/table/thead/tr/th[4]")
	public WebElement CorporateModifiedByGrid;
  
  @FindBy (xpath=".//*[@id='block-system-main']/div/div/table/thead/tr/th[5]")
	public WebElement CorporateModifiedDateGrid;
  
  @FindBy (xpath=".//*[@id='block-system-main']/div/div/table/thead/tr/th[6]")
	public WebElement CorporateStatusGrid;
  
  @FindBy (xpath=".//*[@id='block-system-main']/div/div/table/thead/tr/th[7]")
	public WebElement CorporateOperationsGrid;
  
  @FindBy (xpath=".//*[@id='block-system-main']/div/div/table/tbody/tr/td[7]/a[1]")
	public WebElement corporatePreviewIconGrid;
  
  @FindBy (xpath=".//*[@id='block-system-main']/div/div/table/tbody/tr/td[7]/a[2]")
	public WebElement corporateEditIconGrid;
  
  @FindBy (xpath=".//*[@id='block-system-main']/div/div/table/tbody/tr/td[7]/a[3]")
	public WebElement corporateHistoryIconGrid;
  
  @FindBy (xpath=".//*[@id='edit-name']")
	public WebElement corporateName;
  
  @FindBy (xpath=".//*[@id='edit-field-division-code-und-0-value']")
	public WebElement corporateCode;
  
  @FindBy (xpath=".//*[@id='edit-weight']")
	public WebElement corporateOrder;
  
  @FindBy (xpath=".//*[@id='cke_edit-description-value']")
	public WebElement corporateOverview;
  
  @FindBy (xpath=".//*[@id='cke_edit-field-fact-sheet-und-0-value']")
	public WebElement corporateFactSheet;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-sec-nav-image-und-0-ajax-wrapper']/div/label")
	public WebElement corporateSecNavImage;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-sec-image-link-und-0-value']")
	public WebElement corporateSecNavImageLink;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-info-und']/div[1]/label")
	public WebElement corporateAbout;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-info-und']/div[2]/label")
	public WebElement corporateContacts;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-info-und']/div[3]/label")
	public WebElement corporateExecutiveBios;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-info-und']/div[4]/label")
	public WebElement corporateSecFactSheet;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-info-und']/div[5]/label")
	public WebElement corporateHistory;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-info-und']/div[6]/label")
	public WebElement corporateNews;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-info-und']/div[7]/label")
	public WebElement corporatePhotos;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-info-und']/div[8]/label")
	public WebElement corporateEPKs;
  
  @FindBy (xpath=".//*[@id='edit-field-event-collection-und-0-field-event-reference']/div/label")
	public WebElement corporateEventName;

  @FindBy (xpath=".//*[@id='edit-field-external-link-collection-und-0-field-external-link-title-und-0-value']")
	public WebElement corporateLinkTitle;
  
  @FindBy (xpath=".//*[@id='edit-field-external-link-collection-und-1-field-external-link-url-und-0-value']")
	public WebElement corporateLinkTitle2;
  
  @FindBy (xpath=".//*[@id='edit-field-external-link-collection-und-2-field-external-link-url-und-0-value']")
	public WebElement corporateLinkTitle3;

  
  @FindBy (xpath=".//*[@id='edit-field-external-link-collection-und-0-field-external-link-url-und-0-value']")
	public WebElement corporateExtLink;

  @FindBy (xpath=".//*[@id='edit-field-external-link-collection-und-0-field-link-logo-reference-und']")
	public WebElement corporateLogo;
  
  @FindBy (xpath=".//*[@id='edit-field-external-link-collection-und-1-field-link-logo-reference-und']")
	public WebElement corporateLogo2;
  
  @FindBy (xpath=".//*[@id='edit-field-external-link-collection-und-2-field-link-logo-reference-und']")
	public WebElement corporateLogo3;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-live-start-date']")
	public WebElement corporateStartDate;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-live-end-date']")
	public WebElement corporateEndDate;
  
  @FindBy (xpath=".//*[@id='edit-cancel']")
	public WebElement corporateCancelbtn;
  
  @FindBy (xpath=".//*[@id='edit-submit']")
	public WebElement corporateSavebtn;
  
  @FindBy (xpath=".//*[@id='content-submit-publish-btn']")
	public WebElement corporateSaveAndPublishbtn;
  
  @FindBy (xpath=".//*[@id='edit-preview']")
	public WebElement corporateSaveandPreviewbtn;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-sec-nav-image-und-0-remove-button']")
	public WebElement corporateRemovewbtn;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-sec-nav-image-und-0-upload']")
	public WebElement corporateBrowsewbtn;
  
  @FindBy (xpath=".//*[@id='edit-field-corporate-sec-nav-image-und-0-upload-button']")
	public WebElement corporateUploadbtn;
  
  
  @FindBy (xpath="html/body/div[1]/div/div[1]")
	public WebElement corporateEditSuccessMessage;
  
  @FindBy (xpath=".//*[@id='header']/div[4]/div[1]/section/div[2]/div/ul/li[1]/a")
	public WebElement eventAbout;
  
  @FindBy (xpath=".//*[@id='header']/div[4]/div[1]/section/div[3]/div/a")
	public WebElement eventBios;
  
  @FindBy (xpath=".//*[@id='header']/div[4]/div[1]/section/div[4]/div/a")
	public WebElement eventContacts;
  
  @FindBy (xpath=".//*[@href='/admin/manage-content/shows']")
	public WebElement eventSubmenutab;

  @FindBy (xpath=".//*[@title='Create Show, Title, and Event']")
	public WebElement createEvent;
  
  @FindBy (xpath=".//*[@id='edit-field-show-type-und-69']")
	public WebElement eventRadiobutton;
  
  @FindBy (xpath=".//*[@id='edit-field-show-type-und-68']")
	public WebElement showRadiobutton;
  
  @FindBy (xpath=".//*[@id='cke_edit-field-shows-tag-line-en-0-value']/div")
	public WebElement eventAirDate;
  
  @FindBy (xpath=".//*[@id='edit-title-field-en-0-value']")
	public WebElement eventTitle;
  
  @FindBy (xpath=".//*[@id='edit-field-twitter-screen-name-und-0-value']")
	public WebElement eventTwitterScreeName;
  
  @FindBy (xpath=".//*[@id='edit-field-instagram-name-und-0-value']")
	public WebElement eventInstagramName;  
  

  @FindBy (xpath=".//*[@id='edit-field-shows-description-photo-und-0-value']")
	public WebElement eventProgramDescriptionPhoto;  
  
  @FindBy (xpath=".//*[@id='network_reference_0']")
	public WebElement eventNetworkName;  
  
  @FindBy (xpath=".//*[@id='program_title_0_0']")
	public WebElement eventProgramTitle; 
  
  @FindBy (xpath=".//*[@id='compass_episodde_id_0_0']")
	public WebElement eventEpisodeid; 
  
  @FindBy (xpath=".//*[@id='edit-language']")
	public WebElement eventLanguage; 
  
  @FindBy (xpath=".//*[@id='edit-field-live-start-date']")
	public WebElement eventStartDate; 
  
  @FindBy (xpath=".//*[@id='edit-field-live-end-date']")
	public WebElement eventEnddate; 
  
  @FindBy (xpath=".//*[@id='edit-keywords']")
	public WebElement eventSearchfield; 
  
  @FindBy (xpath=".//*[@id='edit-submit-admin-global-search']")
	public WebElement eventSearchbutton; 
  
  @FindBy (xpath="//a[@title='Delete']")
	public WebElement eventDeletebutton; 
  @FindBy (xpath="//a[@title='Edit']")
	public WebElement eventEditbutton; 
  
  
  @FindBy (xpath="//a[@href='/admin/manage-content/photos']")
	public WebElement createManagePhoto; 
  @FindBy (xpath="//a[@title='Create Photos']")
	public WebElement createPhotolnk; 

  @FindBy (linkText="Programming")
	public WebElement programmingLink;
  
  @FindBy (xpath=".//*[@id='header']/nav/ul/li[1]/a/span")
	public WebElement channelsplus; 
  @FindBy (xpath="//a[@title='NBC Entertainment']")
	public WebElement nbcEntertainmentLink; 
  
  @FindBy (xpath=".//*[@id='inner-container']/div[2]/div[1]/a")
	public WebElement photoFilterLink; 
  
  @FindBy (xpath=".//*[@id='keyword']")
	public WebElement filterSearch; 
  
  @FindBy (xpath=".//*[@id='photo_filter_submit']")
	public WebElement searchButton; 
  
  @FindBy (className=".//*[@id='photo_filter_submit']")
	public WebElement photoName; 

  @FindBy (xpath="//a[text()='See all shows ']")
	public WebElement seeAllShowsLink; 
  
 // @FindBy (xpath="//a[@class='network-search']")
  @FindBy (xpath=".//*[@id='inner-content']/div[1]/div/a/span")
	public WebElement allShowsLink; 
	
  @FindBy (xpath=".//*[@id='filter_show_all_grid_submit']")
	public WebElement searchAllShowButton; 
  
  @FindBy (xpath="(//a[text()='Grimm'])[2]")
	public WebElement grimmButton; 
  
  @FindBy (xpath=".//*[@id='edit-type']")
	public WebElement allAssestTypeDropdown; 
  
  @FindBy (xpath=".//*[@id='edit-field-division-und']")
	public WebElement dropdownSelectDiv; 
  
  @FindBy (xpath=".//*[@id='edit-field-code-und-0-value']")
	public WebElement inputCode; 
  
  @FindBy (xpath=".//*[@id='edit-field-twitter-screen-name-und-0-value']")
	public WebElement inputTwitterScreenName; 
  
  @FindBy (xpath=".//*[@id='edit-field-instagram-name-und-0-value']")
	public WebElement inputInstagramName; 
  
  @FindBy (xpath=".//*[@id='cke_edit-body-en-0-value']")
	public WebElement description; 
  
  @FindBy (xpath=".//*[@id='cke_edit-field-network-fact-sheet-en-0-value']")
	public WebElement factSheet; 
  
  @FindBy (xpath=".//*[@id='edit-field-sort-order-und-0-value']")
	public WebElement inputSortOrder; 
  
  @FindBy (xpath=".//*[@id='edit-field-press-release-logo-und-0-value']")
	public WebElement inputPRLogo;
  
  @FindBy (xpath=".//*[@id='edit-field-import-schedule-und']")
	public WebElement chkboxImportSchedule;
  
  @FindBy (xpath=".//*[@id='edit-field-image-und-0-upload']")
	public WebElement fileUploadLogo1;
  
  @FindBy (xpath=".//*[@id='edit-field-image-und-0-upload-button']")
	public WebElement btnUploadLogo1;
  
  @FindBy (xpath=".//*[@id='edit-field-second-image-und-0-upload']")
	public WebElement fileUploadLogo2;
  
  @FindBy (xpath=".//*[@id='edit-field-second-image-und-0-upload-button']")
	public WebElement btnUploadLogo2;
  
  @FindBy (xpath="//a[@title='Add, Edit or Delete Networks from Author Section']")
	public WebElement tabSubMenuCreateNetwork;
  
  @FindBy (xpath=".//*[@title='Create Networks']")
	public WebElement btnCreateNework;
  
  @FindBy (xpath=".//*[@id='edit-save-publish']")
	public WebElement btnSaveandPublishNetwork;
  
  @FindBy (xpath=".//*[@id='ajax-link--21']")
	public WebElement linkT;
  
  @FindBy (xpath=".//*[@id='ajax-link--47']")
	public WebElement linkTEpisode;

  @FindBy (xpath=".//*[@id='subnav-action-shows']")
	public WebElement sectionShow;
  
  @FindBy (xpath="(.//*[@id='slider']/ul[1]/li[1]/div[1]/p[1]/strong)[1]")
	public WebElement captionPhoto;
  @FindBy (xpath=".//*[@id='slider']/ul[1]/li/div[1]/p[2]")
	public WebElement titlePhoto;
  
  @FindBy (xpath=".//*[@id='slider']/ul[1]/li[1]/div[1]/div/time")
	public WebElement timePhoto;
  
  @FindBy (xpath=".//*[@id='slider']/ul[1]/li[1]/div[2]/div[2]/div/a/span")
	public WebElement downloadPhoto;
  
  @FindBy (xpath=".//*[@id='slider']/ul[1]/li[1]/div[2]/div[2]/a/span")
	public WebElement cartPhoto;
  
  @FindBy (xpath=".//*[@class='flex-prev']")
	public WebElement backPhoto;
  
  @FindBy (xpath=".//*[@class='flex-next']")
	public WebElement nextPhoto;
  
  @FindBy (xpath=".//*[@title='Create Episode']")
	public WebElement createEpisodeBtn;
  
  @FindBy (xpath=".//*[@href='/admin/manage-content/episode']")
	public WebElement episodSubMenuTab;
  
  @FindBy (xpath=".//*[@id='edit-title-field-en-0-value']")
	public WebElement titleEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-episode-season-und-0-value']")
	public WebElement seasonEpisode;
  
  
  @FindBy (xpath=".//*[@id='edit-field-episode-type-und-0-value']")
	public WebElement titleTypeEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-episode-air-time-date']")
	public WebElement airDateTimeEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-episode-duration-und-0-value']")
	public WebElement durationEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-episode-daypart-und-0-value']")
	public WebElement dayPartEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-episode-rating-und-0-value']")
	public WebElement nabRatingEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-network-reference-und']")
	public WebElement networkAssociationEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-shows-reference-und--2']")
	public WebElement showAssociationEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-shows-reference-und']")
	public WebElement showAssociationEpisodeEdit;
  
  @FindBy (xpath=".//*[@id='edit-field-schedule-item-id-und-0-value']")
	public WebElement scheduleItemEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-compass-network-id-und-0-value']")
	public WebElement compassNeworkIDEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-compass-episode-id-und-0-value']")
	public WebElement compassEpisodeIDEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-compass-series-id-und-0-value']")
	public WebElement compassSerialTitleNumberEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-talents-collection-und-0-field-account-first-name-und-0-value']")
	public WebElement talentFirstnameEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-talents-collection-und-0-field-account-last-name-und-0-value']")
	public WebElement talentLastnameEpisode;
  
  @FindBy (xpath=".//*[@id='edit-field-talents-collection-und-0-field-talents-role-und-0-value']")
	public WebElement talentRoleEpisode;
  
  @FindBy (xpath=".//*[@class='view-more transition']")
	public WebElement filterPhotoEpisode;
  
  @FindBy (xpath=".//*[@id='keyword']")
	public WebElement filterPhotoKeywordEpisode;
  
  @FindBy (xpath=".//*[@id='from-date']")
	public WebElement filterPhotoFromDateEpisode;
  
  @FindBy (xpath=".//*[@id='to-date']")
	public WebElement filterPhotoToDateEpisode;
  
  @FindBy (xpath=".//*[@class='ui-checkbox check-all-filters ui-checkbox-state-checked']")
	public WebElement allCheckboxEpisode;
  
  @FindBy (xpath=".//*[@class='no-result']")
	public WebElement noResultEpisode;
  
  @FindBy (xpath=".//*[@class='no-result']")
	public WebElement FromDateEpisode;
  
  @FindBy (xpath=".//*[@class='no-result']")
	public WebElement ToDateEpisode;
  
  @FindBy (xpath=".//*[@id='add_new_secondary_nav']")
	public WebElement addNewNavNetwork;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-0-enabled']")
	public WebElement secondaryTypeFirstNetwork;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-1-enabled']")
	public WebElement secondaryTypeSecondNetwork;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-2-enabled']")
	public WebElement secondaryTypeThirdNetwork;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-3-enabled']")
	public WebElement secondaryTypeFourNetwork;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-2-data-link']/a")
	public WebElement externalLinkNetwork;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-2-data-link-0-title']")
	public WebElement externalLinkTitle1Network;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-2-data-link-1-title']")
	public WebElement externalLinkTitle2Network;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-2-data-link-0-url']")
	public WebElement externalLink1Network;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-2-data-link-1-url']")
	public WebElement externalLink2Network;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-2-data-link-0-logo']")
	public WebElement externalLinkLogo1Network;
  
  @FindBy (xpath=".//*[@id='edit-field-nw-secondary-navigation-und-2-data-link-1-logo']")
	public WebElement externalLinkLogo2Network;
  
  @FindBy (xpath=".//*[@value='about']")
	public WebElement aboutNetwork;
  
  @FindBy (xpath=".//*[@value='talent-bios']")
	public WebElement talentBiosNetwork;
  
  @FindBy (xpath=".//*[@value='contacts']")
	public WebElement contactsNetwork;

@FindBy (xpath=".//*[@value='screeners']")
	public WebElement screenersNetwork;

@FindBy (xpath=".//*[@value='tweets']")
public WebElement tweetsNetwork;

@FindBy (xpath=".//*[@value='exec-bios']")
public WebElement execbiosNetwork;

@FindBy (xpath=".//*[@value='photos']")
public WebElement photosNetwork;

@FindBy (xpath=".//*[@value='epks']")
public WebElement epksNetwork;

@FindBy (xpath=".//*[@value='news']")
public WebElement newsNetwork;

@FindBy (xpath="(//*[@class='page-links-header'])[1]")
public WebElement infoShow;

@FindBy (xpath="(//*[@class='page-links-header'])[2]")
public WebElement showShow;

@FindBy (xpath="(//*[@class='page-links-header'])[3]")
public WebElement externalLinkShow;

@FindBy (xpath="(//*[@class='page-links-header'])[4]")
public WebElement schduleShow;
  
@FindBy (linkText="about")
public WebElement aboutInfoShow;

@FindBy (linkText="executive bios")
public WebElement executivebiosInfoShow;

@FindBy (linkText="talent bios")
public WebElement talentbiosInfoShow;

@FindBy (linkText="photos")
public WebElement photosInfoShow;

@FindBy (linkText="contacts")
public WebElement contactsInfoShow;

@FindBy (linkText="news")
public WebElement newsInfoShow;

@FindBy (linkText="screeners")
public WebElement screenersInfoShow;

@FindBy (linkText="epks")
public WebElement epksInfoShow;

@FindBy (linkText="tweets")
public WebElement tweetsInfoShow;

@FindBy (xpath=".//*[@class='photo-name grid-subtext']")
public WebElement photnameInfoShow;

@FindBy (xpath=".//*[@title='episodes']")
public WebElement showEpisodes;

@FindBy (xpath=".//*[@class='episode-block']")
public WebElement showEpisodesName;

@FindBy (xpath=".//*[@class='no-result']")
public WebElement noEpisodesName;

@FindBy (xpath=".//*[@title='Programming']")
public WebElement tabProgramming;

@FindBy (xpath=".//*[@class='darkish-gray-color']")
public WebElement dateEpisode;

@FindBy (xpath=".//*[@href='/admin/manage-content/talent_bio']")
public WebElement subMenuTabTalentBio;

@FindBy (xpath=".//*[@title='Create Talent Bio']")
public WebElement CreateTalentBio;

@FindBy (xpath=".//*[@class='filter-btn']")
public WebElement expandFilterTalentBio;

@FindBy (xpath=".//*[@id='firstnamefilter']")
public WebElement expandFilterFirstNameTalentBio;

@FindBy (xpath=".//*[@id='lastnamefilter']")
public WebElement expandFilterLastNameTalentBio;

@FindBy (xpath=".//*[@id='shownamefilter']")
public WebElement expandFilterShowTalentBio;

@FindBy (xpath=".//*[@id='filter_bio_grid_submit']")
public WebElement searchFilterShowTalentBio;

@FindBy (xpath=".//*[@id='filter_bio_grid_clear']")
public WebElement clearFilterShowTalentBio;

@FindBy (xpath=".//*[@id='edit-field-account-first-name-en-0-value']")
public WebElement firstNameTalentBio;

@FindBy (xpath=".//*[@id='add-shows']/tbody/tr/td[1]")
public WebElement serachTitle;



@FindBy (xpath=".//*[@id='add-shows']/tbody/tr/td[4]")
public WebElement serachCreatedDate;

@FindBy (xpath=".//*[@id='edit-field-department-en-0-value']")
public WebElement execitiveBioDepartment;

@FindBy (xpath=".//*[@id='edit-field-personal-title-en-0-value']")
public WebElement execitiveBioTitle;

@FindBy (xpath=".//*[@id='edit-field-division-collection-bios-und-0-field-associate-nup-id-und-0-value']")
public WebElement execitiveBioDivisionAssNUPID;

@FindBy (xpath=".//*[@id='edit-field-network-collection-bios-und-0-field-associate-nup-id-und-0-value']")
public WebElement execitiveBioNetworkAssNUPID;

@FindBy (xpath=".//*[@id='edit-field-event-collection-bios-und-0-field-associate-nup-id-und-0-value']")
public WebElement execitiveBioEventAssNUPID;

@FindBy (xpath=".//*[@id='edit-field-associate-nup-id-und-0-value']")
public WebElement execitiveBioAssNUPID;

@FindBy (xpath=".//*[@id='edit-field-division-collection-bios-und-0-field-division-bio-image-und-0-upload']")
public WebElement execitiveBioDivisionPhoto;

@FindBy (xpath=".//*[@id='edit-field-network-collection-bios-und-0-field-division-bio-image-und-0-upload']")
public WebElement execitiveBioNetworkPhoto;

@FindBy (xpath=".//*[@id='edit-field-event-collection-bios-und-0-field-division-bio-image-und-0-upload']")
public WebElement execitiveBioEventPhoto;

@FindBy (xpath=".//*[@id='edit-field-image-und-0-upload']")
public WebElement execitiveBioPhoto;

@FindBy (xpath=".//*[@id='edit-field-division-collection-bios-und-0-field-division-bio-image-und-0-upload-button']")
public WebElement execitiveBioDivisionPhotoUpload;

@FindBy (xpath=".//*[@id='edit-field-network-collection-bios-und-0-field-division-bio-image-und-0-upload-button']")
public WebElement execitiveBioNetworkPhotoUpload;

@FindBy (xpath=".//*[@id='edit-field-event-collection-bios-und-0-field-division-bio-image-und-0-upload-button']")
public WebElement execitiveBioEventPhotoUpload;

@FindBy (xpath=".//*[@id='edit-field-image-und-0-upload-button']")
public WebElement execitiveBioPhotoUpload;

@FindBy (xpath=".//*[@id='edit-field-division-collection-bios-und-0-field-executive-title-und']")
public WebElement execitiveBioDivisionHead;

@FindBy (xpath=".//*[@id='edit-field-network-collection-bios-und-0-field-executive-title-und']")
public WebElement execitiveBioNetworkHead;

@FindBy (xpath=".//*[@id='edit-field-event-collection-bios-und-0-field-executive-title-und']")
public WebElement execitiveBioEventHead;

@FindBy (xpath=".//*[@id='cke_edit-body-en-0-value']")
public WebElement execitiveBioBioBody;

@FindBy (xpath=".//*[@id='filter_exec_bio_grid_submit']")
public WebElement searchFilterShowExeBio;

@FindBy (xpath=".//*[@id='filter_bio_grid_clear']")
public WebElement clearFilterShowExeBio;

@FindBy (xpath="//a[text()='Manage EPKs']")
public WebElement subMenuTabEPKS;

@FindBy (xpath=".//*[@title='Create EPKs']")
public WebElement createEPKS;

@FindBy (xpath=".//*[@id='edit-field-epk-id-und-0-value']")
public WebElement idEPKS;

@FindBy (xpath=".//*[@id='edit-title']")
public WebElement titleEPKS;

@FindBy (xpath=".//*[@id='edit-field-airdate-epk']")
public WebElement dateTimeEPKS;
//
@FindBy (xpath=".//*[@id='edit-field-show-id-from-epk-und-0-value']")
public WebElement showIDEPKS;

@FindBy (xpath=".//*[@id='edit-field-custom-poster-und-0-value']")
public WebElement customPosterEPKS;

@FindBy (xpath=".//*[@id='edit-field-show-title-from-epk-und-0-value']")
public WebElement showTitleEPKS;

@FindBy (xpath=".//*[@id='edit-field-episode-compass-id-from-ep-und-0-value']")
public WebElement episodeIDEPKS;

@FindBy (xpath=".//*[@id='edit-field-shows-collection-und-0-field-shows-reference-und']")
public WebElement showsEPKS;

@FindBy (xpath=".//*[@id='back-epk']")
public WebElement backEPKS;

@FindBy (xpath=".//*[@class='icon-down']")
public WebElement downloadEPKS;

@FindBy (xpath=".//*[@href='/corporate/list-all-events']")
public WebElement seeAllEventEPKS;

@FindBy (xpath=".//*[@id='edit-field-image-und-0-upload']")
public WebElement photoNews;

@FindBy (xpath=".//*[@id='edit-field-image-und-0-upload-button']")
public WebElement uploadPhotoNews;

@FindBy (xpath=".//*[@id='edit-field-additional-photo-und-0-upload']")
public WebElement additionPhotoNews;

@FindBy (xpath=".//*[@id='edit-field-additional-photo-und-0-upload-button']")
public WebElement uploadAdditionPhotoNews;

@FindBy (xpath=".//*[@id='edit-field-sent-in-und']")
public WebElement sentInNews;

@FindBy (xpath=".//*[@id='edit-field-sent-date-show']")
public WebElement sentDateNews;

@FindBy (xpath=".//*[@id='edit-field-press-release-contacts-und-0-value']")
public WebElement contactsNews;

@FindBy (xpath=".//*[@id='edit-field-network-collection-und-0-field-network-reference-und']")
public WebElement networkNews;

@FindBy (xpath=".//*[@id='edit-field-shows-collection-und-0-field-shows-reference-und']")
public WebElement showsNews;

@FindBy (xpath=".//*[@id='edit-field-associate-nup-ids-multiple-und-0-value']")
public WebElement referenceNUPIDNews;

@FindBy (xpath=".//*[@href='/admin/manage-content/press_releases']")
public WebElement subMenuNews;

@FindBy (xpath=".//*[@title='Create News']")
public WebElement createNews;

@FindBy (xpath=".//*[@alt='Bravo']")
public WebElement networkBravo;

@FindBy (xpath=".//*[@id='news_filter_submit']")
public WebElement filterSearchButton;

@FindBy (xpath=".//*[@id='news_filter_clear']")
public WebElement filterClearButton;

@FindBy (xpath=".//*[@id='photo_filter_clear']")
public WebElement photoFilterClearButton;

@FindBy (xpath=".//*[@id='inner-content']/div[2]/div/div[1]/div[1]/a")
public WebElement firstNews;

@FindBy (xpath=".//*[@id='print-imagepath']")
public WebElement newsPrintButton;

@FindBy (xpath="//a[text()='Share']")
public WebElement newsShareButton;

@FindBy (xpath="//a[text()='rss']")
public WebElement newsRSSButton;

@FindBy (xpath=".//*[@class='icon-cart']")
public WebElement cartIcon;

@FindBy (xpath=".//*[@class='global-search-wrap']")
public WebElement globalSearchSection;

@FindBy (xpath=".//*[@title='sort by Title']")
public WebElement titleMVadmin;

@FindBy (xpath=".//*[@title='sort by Created By']")
public WebElement createdbyMVadmin;

@FindBy (xpath="(.//*[@class='views-field views-field-created'])[1]")
public WebElement createdDateMVadmin;

@FindBy (xpath=".//*[@class='views-field views-field-field-account-last-name-1 modified-by-col']")
public WebElement modifiedbysMVadmin;

@FindBy (xpath="(.//*[@class='views-field views-field-changed active'])[1]")
public WebElement modifiedDateMVadmin;

@FindBy (xpath="(.//*[@class='views-field views-field-status'])[1]")
public WebElement statusMVadmin;

@FindBy (xpath=".//*[@class='views-field views-field-operations-links operation-col']")
public WebElement operationMVadmin;

@FindBy (xpath=".//*[@title='Go to next page']")
public WebElement nextPaginationMVadmin;

@FindBy (xpath=".//*[@title='Go to previous page']")
public WebElement previousPaginationMVadmin;

@FindBy (xpath="(.//*[@title='Preview'])[1]")
public WebElement previewOperationMVadmin;

@FindBy (xpath="(.//*[@title='History'])[1]")
public WebElement HistoryOperationMVadmin;

@FindBy (xpath="(.//*[@title='Corporate'])[1]")
public WebElement corporateTab;

@FindBy (xpath="(.//*[@href='/corporate/epks?corporate=1'])[1]")
public WebElement epklinkCorporaeTab;

@FindBy (xpath=".//*[@title='My Account']")
public WebElement myAccountLink;

@FindBy (xpath=".//*[@title='Logout']")
public WebElement logoutLink;

@FindBy (xpath="(.//*[@class='icon-cart'])[1]")
public WebElement lightBoxLink;

@FindBy (xpath=".//*[@id='site-logo']/img")
public WebElement logoMVApp;

@FindBy (xpath=".//*[@class='subnav-item subnav-item-1']")
public WebElement secondNavigationChannels;

@FindBy (xpath=".//*[@class='subnav-item subnav-item-2']")
public WebElement secondNavigationShows;

@FindBy (xpath=".//*[@class='subnav-item subnav-item-3']")
public WebElement secondNavigationPeople;

@FindBy (xpath=".//*[@class='align-left']")
public WebElement latestSection;

@FindBy (xpath=".//*[@class='cart-count']")
public WebElement lightBoxCount;

@FindBy (xpath=".//*[@class='active-trail active']")
public WebElement highlightedTab;

@FindBy (xpath=".//*[@id='search-input']")
public WebElement searchField;

@FindBy (xpath=".//*[@class='button_close']")
public WebElement closeButtonMyAccount;

@FindBy (xpath=".//*[@class='action-btn back-btn']")
public WebElement channelsBackButton;

@FindBy (xpath=".//*[@id='subnav-top-shows-block-wrapper']/div/h5")
public WebElement showsMostViewed;

@FindBy (xpath=".//*[@id='subnav-top-people-block-wrapper']/h5")
public WebElement peopleMostViewed;

@FindBy (xpath=".//*[@id='subnav-shows-block-wrapper']/div/div/nav/ul")
public WebElement showsTSection;

@FindBy (xpath=".//*[@id='ajax-link']")
public WebElement showshashtag;

@FindBy (xpath=".//*[@id='subnav-shows-block-wrapper']/div/div/nav[1]/ul/li[1]/a")
public WebElement firstShow;

@FindBy (xpath=".//*[@id='subnav-people-block-wrapper']/div/div/nav[1]/ul/li[1]/a")
public WebElement firstEpisode;

@FindBy (xpath=".//*[@id='forgot_password']")
public WebElement forgotPassword;

@FindBy (xpath=".//*[@id='new_here']")
public WebElement submitRegistrationRequest;

@FindBy (xpath=".//*[@class='error_container error_notice clear']")
public WebElement loginErrormMessage;

@FindBy (xpath=".//*[@href='/admin/manage-divisions']")
public WebElement manageDivisionTab;

@FindBy (xpath=".//*[@title='sort by Created Date']")
public WebElement manageDivisionCreatedDate;

@FindBy (xpath=".//*[@title='sort by Modified By']")
public WebElement manageDivisionModifiedBy;

@FindBy (xpath=".//*[@title='sort by Modified Date']")
public WebElement manageDivisionModifiedDate;

@FindBy (xpath=".//*[@title='sort by Status']")
public WebElement manageDivisionStatus;

@FindBy (xpath=".//*[@id='add-network']/thead/tr/th[7]")
public WebElement manageDivisionOperation;

@FindBy (xpath=".//*[@title='History']")
public WebElement manageDivisionOperationHistory;

@FindBy (xpath=".//*[@id='edit-field-publish-radio-und-none']")
public WebElement manageDivisionPublishingNotApplicable;

@FindBy (xpath=".//*[@id='edit-field-publish-radio-und-1']")
public WebElement manageDivisionPublish;

@FindBy (xpath=".//*[@id='edit-field-publish-radio-und-0']")
public WebElement manageDivisionUnPublish;

@FindBy (xpath=".//*[@id='edit-log']")
public WebElement manageDivisionRevisionComments;

@FindBy (xpath=".//*[@id='division-save-only-button']")
public WebElement manageDivisionSaveButton;

@FindBy (xpath=".//*[@class='message-storage']")
public WebElement manageDivisionErrorMessage;

@FindBy (xpath=".//*[@class='home-icon']")
public WebElement mvAdminHOMETab;

@FindBy (xpath=".//*[@title='Delete']")
public WebElement deleteLinkNetwork;

@FindBy (xpath=".//*[@title='Edit']")
public WebElement editLinkNetwork;

@FindBy (xpath=".//*[@id='add-shows']/tbody/tr/td[2]")
public WebElement noRecordMessage;

@FindBy (xpath=".//*[@id='cke_edit-field-shows-program-credits-und-0-value']")
public WebElement showProgramCredit;

@FindBy (xpath=".//*[@id='contact_0']")
public WebElement showProgramContact;

@FindBy (xpath=".//*[@id='edit-network-record-0-compass-record-0-import-schedule-from-s']")
public WebElement showShowID;

@FindBy (xpath=".//*[@id='is_other_schedule_0_0']")
public WebElement showOtherSchdule;

@FindBy (xpath=".//*[@id='edit-network-record-0-add-compass-button']")
public WebElement showAddCompassShowInfoLink;

@FindBy (xpath=".//*[@id='edit-add-network-button']")
public WebElement showAddNewNetworkLink;

@FindBy (xpath=".//*[@title='Close preview']")
public WebElement closePreviewPage;

@FindBy (xpath="(.//*[@class='message-storage'])[2]")
public WebElement networkTitlefiledValidationMessage;

@FindBy (xpath="(.//*[@class='message-storage'])[1]")
public WebElement networkLogofiledValidationMessage;

@FindBy (xpath=".//*[@id='edit-field-image-und-0-remove-button']")
public WebElement networkRemoveLogo;


@FindBy (xpath=".//*[@id='edit-cancel--3']")
public WebElement networkCancelButton;

@FindBy (xpath=".//*[@id='edit-save-publish--2']")
public WebElement networkSaveButton;

@FindBy (xpath=".//*[@class='messages error']")
public WebElement messageerror;

@FindBy (xpath=".//*[@id='photo-download-btn']")
public WebElement downLoadButton;


@FindBy (xpath="(.//*[@class='icon-cart'])[2]")
public WebElement addCart;

@FindBy (xpath=".//*[@class='ui-checkbox']")
public WebElement cartSelectAll;

@FindBy (xpath=".//*[@id='download-selected-btn']")
public WebElement cartDownloadSelected;

@FindBy (xpath=".//*[@id='remove-item-cart-selected']")
public WebElement cartRemoveSelected;

@FindBy (xpath=".//*[@title='Read More']")
public WebElement linkReadMore;

@FindBy (xpath="//a[text()='print']")
public WebElement linkprint;

@FindBy (xpath="//a[text()='Share']")
public WebElement linkShare;

@FindBy (xpath=".//*[@id='pdf-download']")
public WebElement linkDownload;

@FindBy (xpath=".//*[@href='/owned-stations']")
public WebElement tabOwnedStation;

@FindBy (xpath="(.//*[@alt='NBC Owned Television Stations'])[1]")
public WebElement groupNBCOwnedTelevisionStations;

@FindBy (xpath=".//*[@class='live-show-info']")
public WebElement showAirDate;

@FindBy (xpath=".//*[@alt='Telemundo']")
public WebElement networkTelemundo;


@FindBy (xpath="//a[text()='about']")
public WebElement infoAbout;

@FindBy (xpath=".//*[@class='language-link spanish-link transition active']")
public WebElement linkHagaclicparaEspañol;

@FindBy (xpath=".//*[@class='lightbox-empty-msg medium-txt position-center']")
public WebElement cartIsEmpty;

@FindBy (xpath="(.//*[@class='ui-checkbox'])[2]")
public WebElement cartSelectionSecond;

@FindBy (xpath=".//*[@class='dark-grey-button medium-txt remove-item-cart']")
public WebElement removeItemCart;

@FindBy (xpath="(.//*[@class='subnav-grid-inner-wrap'])[1]")
public WebElement chanelInfoSection;

@FindBy (xpath="(.//*[@class='subnav-grid-inner-wrap'])[2]")
public WebElement chanelShowsSection;

@FindBy (xpath="(.//*[@class='subnav-grid-inner-wrap'])[3]")
public WebElement chanelSchduleSection;

@FindBy (xpath="(.//*[@class='subnav-grid-inner-wrap'])[4]")
public WebElement chanelExternalLinkSection;


@FindBy (xpath="//a[text()='about']")
public WebElement chanelInfoSectionAbout;

@FindBy (xpath="//a[text()='executive bios']")
public WebElement chanelInfoSectionExecutiveBios;

@FindBy (xpath="//a[text()='talent bios']")
public WebElement chanelInfoSectionTalentBios;

@FindBy (xpath="//a[text()='photos']")
public WebElement chanelInfoSectionPhotos;

@FindBy (xpath="//a[text()='contacts']")
public WebElement chanelInfoSectionContacts;

@FindBy (xpath="//a[text()='news']")
public WebElement chanelInfoSectionNews;

@FindBy (xpath="//a[text()='screeners']")
public WebElement chanelInfoSectionScreeners;

@FindBy (xpath="//a[text()='epks']")
public WebElement chanelInfoSectionEpks;

@FindBy (xpath="//a[text()='tweets']")
public WebElement chanelInfoSectionTweets;

@FindBy (xpath=".//*[@alt='Follow NBC on Twitter']")
public WebElement chanelExternalLinkTweets;

@FindBy (xpath=".//*[@alt='Like NBC on Facebook']")
public WebElement chanelExternalLinkFacebbok;

@FindBy (xpath=".//*[@alt='Follow NBC on Google+']")
public WebElement chanelExternalLinkGoogle;

@FindBy (xpath="(//*[@id='single-day-container']/div[3]/a)[1]")
public WebElement schduleFullListingFirst;

@FindBy (xpath="//a[text()='See full listings']")
public WebElement SeeFullListing;

@FindBy (xpath="(.//*[@class='align-left block-title full-width'])[1]")
public WebElement FirstShow;

@FindBy (xpath=".//*[@class='date-display-single']")
public WebElement photoDate;

@FindBy (xpath="(.//*[@class='icon-cart'])[2]")
public WebElement cartIconPhoto;

@FindBy (xpath=".//*[@href='/admin/manage-content/dnr']")
public WebElement tabDNR;

@FindBy (xpath="(.//*[@class='views-field views-field-title'])[1]")
public WebElement dnrTitle;


@FindBy (xpath="(.//*[@class='views-field views-field-field-account-last-name modified-by-col'])[1]")
public WebElement dnrCreatedBy;


@FindBy (xpath="(.//*[@class='views-field views-field-field-account-last-name-1'])[1]")
public WebElement dnrModifiedBy;

@FindBy (xpath=".//*[@id='news-block-col-corporate']/div/a")
public WebElement newsFilter;

@FindBy (xpath="((.//*[@class='ui-state-default'])[@href='#'])[1]")
public WebElement newsFilterFirstDate;

@FindBy (xpath="((.//*[@class='ui-state-default'])[@href='#'])[31]")
public WebElement photoFilterFirstDate;

@FindBy (xpath="((.//*[@class='ui-state-default'])[@href='#'])[15]")
public WebElement newsFilterMiddleDate;

@FindBy (xpath="((.//*[@class='ui-state-default'])[@href='#'])[46]")
public WebElement photoFilterMiddleDate;

@FindBy (xpath="((.//*[@class='ui-state-default'])[@href='#'])[28]")
public WebElement newsFilterLastDate;

@FindBy (xpath="((.//*[@class='ui-state-default'])[@href='#'])[59]")
public WebElement photoFilterLastDate;

@FindBy (xpath=".//*[@title='Prev']")
public WebElement newsFilterPreviousMonth;

@FindBy (xpath="(.//*[@title='Prev'])[2]")
public WebElement photoFilterPreviousMonth;

@FindBy (xpath="(.//*[@class='block block-text'])[1]")
public WebElement newsFilterSectionTitle;

@FindBy (xpath="(.//*[@class='photo-name grid-subtext'])[1]")
public WebElement photoFilterSectionTitle;


@FindBy (xpath="(.//*[@class='block-info clearfix'])[1]")
public WebElement newsFilterSectionNewsLink;

@FindBy (xpath="(.//*[@class='clearfix home-grid-icon-container'])[1]")
public WebElement newsFilterSectionNewsDate;

@FindBy (xpath="(.//*[@class='date-display-single'])[1]")
public WebElement photoFilterDate;

@FindBy (xpath=".//*[@class='error-msg']")
public WebElement newsFilterErrorMessage;

@FindBy (xpath="(.//*[@class='view-more transition'])[2]")
public WebElement photoFilter;

@FindBy (xpath="(.//*[@class='photo-grid-figure-link transition'])[1]")
public WebElement scrennerViewLink;

@FindBy (xpath=".//*[@class='medium-large-txt black-color screener-name']")
public WebElement scrennerName;

@FindBy (xpath=".//*[@class='medium-txt darkish-gray-color episode-name']")
public WebElement scrennerDesc;

@FindBy (xpath=".//*[@class='darkish-gray-color medium-txt episode-expires-date']")
public WebElement scrennerDate;

@FindBy (xpath=".//*[@class='back-epk']")
public WebElement scrennerBackToList;

@FindBy (xpath=".//*[@class='continue-epk']")
public WebElement scrennerContinueToScreener;

@FindBy(css=".block-type-icon.block-type-icon-epk.align-left")
public WebElement epkVideo;

@FindBy(css=".photo-grid-figure-link.transition")
public WebElement epkName;

@FindBy(css=".block-time>time")
public WebElement epkDate;

@FindBy(css=".photo-grid-figure-link>img")
public WebElement epkImage;

@FindBy(xpath="(.//*[@class='first'])[2]")
public WebElement peopleFirstElement;

@FindBy(xpath=".//*[@class='subnav-grid-unit subnav-grid-col-2 grid-people-bio']")
public WebElement peopleDesc;

@FindBy(css=".bio-back.transition.align-right.darkish-gray-color")
public WebElement talentBioBackToBioSummary;


@FindBy(xpath=".//*[@id='talane_bio_details_filter_clear']")
public WebElement talentBioClearButton;

@FindBy(xpath=".//*[@id='talane_bio_details_filter_submit']")
public WebElement talentBioSearchButton;

@FindBy(xpath="//*[@class='ui-checkbox'][@for='bio-photos_filter_chk']")
public WebElement talentBioPhotoCheckBox;

@FindBy(css=".field-item.even>a>img")
public WebElement talentBioImage;

@FindBy(xpath="//*[@class='ui-checkbox'][@for='bio-epks_filter_chk']")
public WebElement talentBioEPKCheckBox;

@FindBy(xpath="//*[@class='ui-checkbox'][@for='bio-news_filter_chk']")
public WebElement talentBioNewsCheckBox;

@FindBy(xpath=".//*[@class='transition read-more']")
public WebElement talentBioNewsReadMoreLink;

@FindBy(xpath=".//*[@class='align-left new-head']")
public WebElement talentBioPage;

// Bulk Photo

@FindBy(xpath=".//*[@href='/admin/bulk-edit-search']")
public WebElement tabBulkEditPhoto;

@FindBy(xpath=".//*[@id='edit-field-search-date-1']")
public WebElement radioBulkEditPhotoCreateDate;

@FindBy(xpath=".//*[@id='edit-field-search-date-2']")
public WebElement radioBulkEditPhotoUpdateDate;

@FindBy(xpath=".//*[@id='edit-field-search-date-3']")
public WebElement radioBulkEditPhotoLiveStartDate;

@FindBy(xpath=".//*[@id='edit-field-search-date-4']")
public WebElement radioBulkEditPhotoLiveEndDate;

@FindBy(xpath=".//*[@id='edit-field-start-date']")
public WebElement fieldBulkEditPhotoStartDate;

@FindBy(xpath=".//*[@id='edit-field-end-date']")
public WebElement fieldBulkEditPhotoEndDate;

@FindBy(xpath=".//*[@id='edit-caption']")
public WebElement fieldBulkEditPhotoCaption;

@FindBy(xpath=".//*[@id='edit-air-date-text']")
public WebElement fieldBulkEditPhotoAirDateText;

@FindBy(xpath=".//*[@id='edit-dpl-season']")
public WebElement fieldBulkEditPhotoDPLSeasone;

@FindBy(xpath=".//*[@id='edit-dpl-prog-title']")
public WebElement fieldBulkEditPhotoDPLProgramTitle;

@FindBy(xpath=".//*[@id='edit-field-nup-id-value']")
public WebElement fieldBulkEditPhotoNUP;

@FindBy(xpath=".//*[@id='edit-field-photo-type-tid']")
public WebElement dropdownBulkEditPhotoPhotoType;

@FindBy(xpath=".//*[@id='edit-dropdown-divisions']")
public WebElement dropdownBulkEditPhotoDivison;

@FindBy(xpath=".//*[@id='edit-dropdown-networks']")
public WebElement dropdownBulkEditPhotoNetworks;

@FindBy(xpath=".//*[@id='edit-dropdown-shows']")
public WebElement dropdownBulkEditPhotoShows;

@FindBy(xpath=".//*[@id='edit_dropdown_episodes_chosen']/a")
public WebElement dropdownBulkEditPhotoEpisode;

@FindBy(xpath=".//*[@id='edit-dropdown-events']")
public WebElement dropdownBulkEditPhotoEvent;

@FindBy(xpath=".//*[@id='edit-field-advanced-status-1']")
public WebElement checkBoxBulkEditPhotoUnPublished;

@FindBy(xpath=".//*[@id='edit-field-advanced-status-2']")
public WebElement checkBoxBulkEditPhotoPending;

@FindBy(xpath=".//*[@id='edit-field-advanced-status-3']")
public WebElement checkBoxBulkEditPhotoPublished;

@FindBy(xpath=".//*[@id='edit-submit-bulk-edit-search']")
public WebElement buttonBulkEditPhotoSearch;

@FindBy(xpath=".//*[@href='/admin/manage-lightbox'][@class='blue-btn']")
public WebElement buttonBulkEditPhotoLightBoxInterface;

@FindBy(xpath=".//*[@id='edit-views-bulk-operations-1-0']")
public WebElement checkBoxBulkEditPhotoListed;

@FindBy(xpath=".//*[@class='bulk-edit-table-field_image']")
public WebElement gridBulkEditPhotoPreview;

@FindBy(xpath=".//*[@class='bulk-edit-table-title']")
public WebElement gridBulkEditPhotoFileName;

@FindBy(xpath=".//*[@class='bulk-edit-table-field_photo_air_date']")
public WebElement gridBulkEditPhotoAirDate;

@FindBy(xpath=".//*[@class='bulk-edit-table-body']")
public WebElement gridBulkEditPhotoPhotoCaption;

@FindBy(xpath=".//*[@class='bulk-edit-table-advanced_status']")
public WebElement gridBulkEditPhotoStatus;

@FindBy(xpath=".//*[@class='bulk-edit-table-field_nup_id']")
public WebElement gridBulkEditPhotoNUPID;

@FindBy(xpath=".//*[@id='edit-actionnbcumv-lightbox-bulk-edit-action']")
public WebElement buttonBulkEditPhotoBulkEdit;

@FindBy(xpath=".//*[@id='edit-actionnbcumv-lightbox-delete-selected-action']")
public WebElement buttonBulkEditPhotoDeleteSelected;

@FindBy(xpath=".//*[@id='edit-actionnbcumv-pdp-add-photos-action']")
public WebElement buttonBulkEditPhotoBulkAddToPhotoDownloadPage;

@FindBy(css=".photo-grid-figure-link>img")
public WebElement newsPhotoApplication;

@FindBy(css=".date-display-single")
public WebElement newsDateApplication;

@FindBy(xpath=".//*[@class='press-release-body 1']")
public WebElement newsDescriptionApplication;

@FindBy(css="#add-shows>tbody>tr>td")
public WebElement elementDeleted;

// Contacts
@FindBy(xpath=".//*[@href='/admin/manage-content/contacts']")
public WebElement contacttab;

@FindBy(xpath=".//*[@title='Create Contacts']")
public WebElement contactcreate;

@FindBy(xpath=".//*[@id='edit-field-account-first-name-und-0-value']")
public WebElement contatcsFirstName;

@FindBy(xpath=".//*[@id='edit-field-account-last-name-und-0-value']")
public WebElement contatcsLastName;

@FindBy(xpath=".//*[@id='edit-field-personal-title-und-0-value']")
public WebElement contatcsTitle;

@FindBy(xpath=".//*[@id='edit-field-department-und-0-value']")
public WebElement contatcsDepartment;

@FindBy(xpath=".//*[@id='edit-field-account-email-address-und-0-value']")
public WebElement contatcsEmailAddress;

@FindBy(xpath=".//*[@id='edit-field-personal-phone-und-0-value']")
public WebElement contatcsMainPhone;

@FindBy(xpath=".//*[@id='edit-field-alternate-phone-und-0-value']")
public WebElement contatcsAlternatePhone;

@FindBy(xpath=".//*[@id='edit-field-fax-und-0-value']")
public WebElement contatcsFax;

@FindBy(xpath=".//*[@id='edit-field-contact-type-und-1']")
public WebElement contatcsTypePublicity;

@FindBy(xpath="(.//*[@class='contact-container']/h2)[1]")
public WebElement contatcsName;

@FindBy(xpath="(.//*[@class='vcard'])[1]")
public WebElement contatcsVCard;

@FindBy(xpath=".//*[@class='subnav-more-link']")
public WebElement contactsSeeAllContacts;

//              SpotLight
@FindBy(xpath=".//*[@href='/admin/manage-content/spotlight']")
public WebElement spotLightsubMenuTab;

@FindBy(xpath=".//*[@title='Create Spotlight']")
public WebElement spotLightCreateSpotlight;

@FindBy(xpath=".//*[@id='edit-field-division-collection-und-0-field-division-und']")
public WebElement spotLightDivision;

@FindBy(xpath=".//*[@id='edit-field-network-collection-und-0-field-network-reference-und']")
public WebElement spotLightNetwork;

@FindBy(xpath=".//*[@id='edit-title']")
public WebElement spotLightTitle;

@FindBy(xpath=".//*[@id='edit-field-sort-order-und-0-value']")
public WebElement spotLightSortOrder;

@FindBy(xpath=".//*[@id='edit-field-spotlight-image-collection-und-0-field-lbx-lowres-image-path-und-0-value']")
public WebElement spotLightLowerImagePath;

@FindBy(xpath=".//*[@id='edit-field-spotlight-image-collection-und-0-field-spotlight-url-und-0-value']")
public WebElement spotLightURL;

@FindBy(xpath=".//*[@id='edit-field-spotlight-image-collection-und-0-field-link-target-und']")
public WebElement spotLightTarget;

@FindBy(xpath=".//*[@id='edit-field-spotlight-image-collection-und-1-field-lbx-lowres-image-path-und-0-value']")
public WebElement spotLightLowerImagePath2;

@FindBy(xpath=".//*[@id='edit-field-spotlight-image-collection-und-1-field-spotlight-url-und-0-value']")
public WebElement spotLightURL2;

@FindBy(xpath=".//*[@id='edit-field-spotlight-image-collection-und-1-field-link-target-und']")
public WebElement spotLightTarget2;

@FindBy(xpath="(.//*[@class='flex-active'])[@href='#']")
public WebElement spotLightCount;

@FindBy(xpath=".//*[@class='flex-next']")
public WebElement spotLightNext;

@FindBy(xpath=".//*[@href='/admin/manage-content/videos']")
public WebElement epkTab;

@FindBy(xpath=".//*[@href='/admin/manage-content/screeners']")
public WebElement screenerSubMenuTab;

@FindBy(xpath=".//*[@id='block-system-main']/div/div[2]/table/tbody/tr[1]/td[1]")
public WebElement searchTitleScreener;

	//	---------------------- Methods -------------------------------

	/*	public mvauthorPageFactory(WebDriver driver) {
		///this.driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumBrowserDrivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		PageFactory.initElements(this.driver, this);
	}*/
	public mvauthorPageFactory(WebDriver driver,String browser) {
		if(browser.trim().equalsIgnoreCase("chrome"))
		{
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver", "C:/SeleniumBrowserDrivers/chromedriver.exe");
			this.driver = new ChromeDriver(cap);
		}
		else if(browser.trim().equalsIgnoreCase("internetexplorer"))
		{
			DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
			cap.setCapability(
					InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.ie.driver", "C:/SeleniumBrowserDrivers/IEDriverServer.exe");

			this.driver = new InternetExplorerDriver(cap);
		}
		else 
		{
			FirefoxProfile myProfile = new FirefoxProfile();
			myProfile.setAcceptUntrustedCertificates(true);
			myProfile.setAssumeUntrustedCertificateIssuer(false);
			this.driver = new FirefoxDriver();
		}
		PageFactory.initElements(this.driver, this);
	}

	public void mvauthorLogin(String UserID, String Password) throws InterruptedException{
		driver.get(Constants.mvauthorURL);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		userName.sendKeys(UserID);
		password.sendKeys(Password);
		Thread.sleep(1000);	        
		Login.click();
		Thread.sleep(2000);
	}
	
	public void mvauthorEPKTV(String UserID, String Password) throws InterruptedException{
		driver.get(Constants.epkTVURL);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		userNameEPKTV.sendKeys(UserID);
		passwordEPKTV.sendKeys(Password);
		Thread.sleep(1000);	        
		loginEPKTV.click();
		//driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}

	public void mvappLogin(String UserID, String Password) throws Exception{
		driver.get(Constants.mvURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		linkLogin.click();
		driver.switchTo().frame(0);
		driver.switchTo().frame("display-frame");
		mvUserName.sendKeys(UserID);
		mvPassword.sendKeys(Password);
		mvSignIn.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}

	public void closeDriver(WebDriver driver) {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browsername = cap.getBrowserName();
		if(browsername.equalsIgnoreCase("internet explorer"))
		{
			try {
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
			driver.quit();
	}


}