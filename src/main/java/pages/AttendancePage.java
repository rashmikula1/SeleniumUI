package pages;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;





public class AttendancePage {
	public WebDriver driver;
	ArrayList <String> strings = new ArrayList<String>();
	ArrayList<String> array2=new ArrayList<String>();
	ArrayList<String> popupactual=new ArrayList<String>();
	ArrayList<String> popupexpected=new ArrayList<String>();
	int numofrows;
	String todayStr;
	Calendar calendar=Calendar.getInstance();
	int targetDay=calendar.get(Calendar.DAY_OF_MONTH);
	int targetMonth=calendar.get(Calendar.MONTH);
	int targetYear=calendar.get(Calendar.YEAR);
	String alert;
	WebElement anycheckBox;
	
	public AttendancePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//1.Manage attendance page verification
	@FindBy(xpath="//h1[text()='Manage Program']") WebElement dashboardPageHeader;
	@FindBy(linkText="Attendance") WebElement attendanceModuleLink;
	@FindBy(xpath="//h1[text()='Manage Attendance']") WebElement attendancePageHeader;
	@FindBy(xpath="//a[text()='404 brokenlink']") WebElement invalidHttpRequest;
	@FindBy(xpath="//a[text()='LMS - Learning Management System']") WebElement title;
	@FindBy (name="search") WebElement search;
	@FindBy (xpath ="//button[text()='+ A New Attendance']")WebElement newAttendanceButton;
	@FindBy (id="table") WebElement dataTable;
	@FindBy (xpath="//input[@type='checkbox']") WebElement checkbox;
	@FindBy (xpath="//tr//th[text()='Class ID']") WebElement classID;
	@FindBy (xpath="//tr//th[text()='Student ID']") WebElement studentID;
	@FindBy (xpath="//tr//th[text()='Present']") WebElement present;
	@FindBy (xpath="//tr//th[text()='Edit/Delete']") WebElement EditDelete;
	@FindBy (xpath="//*[@id='attendance']/tbody/tr ") WebElement tableRows;
	@FindBy (xpath="/*[@id='attendance']/tbody/tr[2]/td") WebElement tableColumns;
	@FindBy (xpath="/parent::td//preceding-sibling::td(1)//input[@type=‘editbutton’]") WebElement editIcon;
	@FindBy (id="sort1") WebElement sortClassId;
	@FindBy (id="sort2") WebElement sortStudentId;
	@FindBy (id="sort3") WebElement sortPresent;
	@FindBy (xpath="//*[starts-with(@id,'Showing')]") WebElement paginationText;
	@FindBy (xpath="//*[starts-with(@id,'In total there')]") WebElement footerText;
	@FindBy(linkText="<") WebElement prevArrow;
	@FindBy(linkText=">") WebElement nextArrow;
	@FindBy(linkText="<<") WebElement firstArrow;
	@FindBy(linkText=">>") WebElement lastArrow;
	
	//2.Attendance Details Popup
	@FindBy (xpath="//a[text()='Program Name']") WebElement programNameLabel;
	@FindBy (xpath="//a[text()='Class Name']") WebElement classNameLabel;
	@FindBy (xpath="//a[text()='Student']") WebElement studentNameLabel;
	@FindBy (xpath="//a[text()='Attendance']") WebElement attendanceLabel;
	@FindBy (xpath="//a[text()='Attendance Date']") WebElement attendanceDateLabel;
	@FindBy (xpath="//button[contains(@data-testid='CloseIcon')]") WebElement closeIcon;
	@FindBy (xpath="//div[@class='nav-item dropdown show']//a[1]") WebElement programNameDropdown;
	@FindBy (xpath="//div[@class='nav-item dropdown show']//a[1]") WebElement classNameDropdown;
	@FindBy (xpath="//div[@class='nav-item dropdown show']//a[1]") WebElement studentNameDropdown;
	@FindBy (xpath="//div[@class='nav-item dropdown show']//a[1]") WebElement attendanceDropdown;
	@FindBy (className="nav-link dropdown-toggle") WebElement dropDown;
	@FindBy (xpath="//button[text()='Cancel']") WebElement cancelButton;
	@FindBy (xpath="//button[text()='Save']") WebElement saveButton;
	
	//3.Attendance Details Popup window
	
	@FindBy (xpath="//a[text()='Attendance Details']") WebElement attendanceDetailsPopup;
	@FindBy (id="dateSelector") WebElement datePicker;
	@FindBy (className="ui-datepicker-calendar") WebElement calendarDisplay;
	@FindBy(xpath="//td[@data-handler='selectMonth']/a]") WebElement month;
	@FindBy (xpath="//td[@data-handler='selectDay']/a[1]") WebElement date;
	@FindBy(className="//td[@data-handler='selectDay']/a[text()='2023']") WebElement year;
	@FindBy (tagName="td") WebElement columns;
	@FindBy (xpath="//input[@type='Attendance Date]") WebElement attendanceDateTextbox;
	@FindBy (css="div[role='navigator'] i.chevron-left") WebElement rightArrow;
	@FindBy (css="div[role='navigator'] i.chevron-left") WebElement leftArrow;
	@FindBy (xpath="//div[@class='ui-datepicker-title") WebElement currentDisplayDate;
	
	//4. Add Edit Attendance
	@FindBy (xpath="//div[@class='alert alert-primary']" ) WebElement errorMsg;
	@FindBy (xpath="//div[@class='alert alert-primary']" ) WebElement successMsg;
	@FindBy(id="nextPage") WebElement nextPage;
	
	//5. Delete Attendance Validation
	@FindBy (xpath=".//button[text()='Delete']") WebElement deleteIcon;
	@FindBy(id="attendance1") WebElement deletedAttendanceRow;
	
	//6. Delete Multiple Attendance Validation
	@FindBy(xpath="//table//tbody//tr[1]") WebElement webtableFirstRow;
	@FindBy(xpath="//table//tbody//tr[1]//td[1]") WebElement webtableFirstCheckbox;
	@FindBy(xpath="id = “>delete<") WebElement headerdeletebtnmulti;
	
	
	//7. Pagination in Manage Attendance
	@FindBy(xpath="//[@class='right-arrow']") WebElement pagrightArrow;
	@FindBy(xpath="//[@class='2right-arrow']") WebElement secondPagerightArrow;
	@FindBy(xpath="//[@class='left-arrow']") WebElement pagleftArrow;
	@FindBy(xpath="//[@id='next-page-button']") WebElement nextPageButton;
	//@FindBy(xpath="//[@id='data-table-id']") WebElement dataTable1;
	
	
	//8. Navigation Function Validation
	 @FindBy(xpath="[//a[text()='Program']") public WebElement program;
	 @FindBy(xpath="[//a[text()='Student']") public WebElement student;
	 @FindBy(xpath="[//a[text()='Attendance']") public WebElement attendance;
	 @FindBy(xpath="[//a[text()='Batch']") public WebElement batch;
	 @FindBy(xpath="[//a[text()='Class']") public WebElement class1;
	 @FindBy(xpath="[//a[text()='User']") public WebElement user;
	 @FindBy(xpath="[//a[text()='assignment']") WebElement assignment;
	 @FindBy(xpath="//[@id='aasignment-row']") WebElement assignmentRow;
	 WebElement pageCountElement = dataTable.findElement(By.id("page-count"));
	 
	 List<WebElement> assignmentElements = driver.findElements((By) assignmentRow);
	int assignmentCount = assignmentElements.size();
	
	//1.Manage attendance page verification
	
	public boolean verifyDashboard() {
		return dashboardPageHeader.isDisplayed();
	}
	
	public void clickAttendance() {
		attendanceModuleLink.click();
	}
	public boolean verifyManageAttendance() {
		return attendancePageHeader.isDisplayed();
	}
	
	public boolean navigationTime() {
        long start = System.currentTimeMillis();
        attendanceModuleLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(attendancePageHeader));
        long timeToLoad= (System.currentTimeMillis()-start);
        if (timeToLoad<30) 
        	return true;      
        else 
        	return false;
	}
	
	public boolean verifyBrokenLink() throws IOException {
		WebElement element=driver.findElement(By.linkText("a"));
		// using href attribute we can get url of required link
		String url=element.getAttribute("href");
		URL link=new URL(url);
		HttpURLConnection httpConn=(HttpURLConnection) link.openConnection();
		httpConn.connect();
		int rescode=httpConn.getResponseCode();
		if(rescode>400) {
			System.out.println(url+" is a broken link");
			return true;
		}
		else return false;
			
	}
	
	public String pageTitle() {
		return title.getText();
	}

	public boolean isleftAligned() {
		String textAlignment = attendancePageHeader.getCssValue("text-align");
		if (textAlignment.equals("left")) {
			System.out.println("Manage Attendance text is left-justified"); }
		return true;
				
	}
	
	public ArrayList<String> getStrings() {
		
		strings.add(classID.getText());
		strings.add(studentID.getText());
		strings.add(present.getText());
		strings.add(EditDelete.getText());
		return strings;
			
	}
	public boolean spellingCheck() {
		array2.add("Class ID");
		array2.add("Student ID");
		array2.add("Present");
		array2.add("Edit/Delete");
		if (strings.equals(array2) == true) {
			System.out.println("Spellings are correct");
		}
		return true;
	}
	
	public boolean isDeleteIconDisabled() {
		if(deleteIcon.isEnabled()==false) {
			System.out.println("Delete icon disabled");
		}
		return true;
	}
	
	public boolean isSearchPresent() {
		return search.isDisplayed();
	}
	
	public boolean isAddNewAttendancePresent() {
		return newAttendanceButton.isDisplayed();
	}
	
	public boolean isDatatableDisplayed() {
		checkbox.isDisplayed();
		classID.isDisplayed();
		studentID.isDisplayed();
		present.isDisplayed();
		return dataTable.isDisplayed();
		 
	}
	
	public boolean isEditIconPresent() {
		if(tableRows.isDisplayed()) 
			 editIcon.isDisplayed();
		
		return true;
	}
	
	public boolean isEditNotPresent() {
		if(tableRows.isDisplayed() != true) {
			if(editIcon.isDisplayed()!=true) {
				
				System.out.println("No table data, no edit icon");
				return true;
			}
		}
			 
		
		return false;
	}
	
	public boolean isDeleteIconPresent() {
		if(tableRows.isDisplayed()) 
			 deleteIcon.isDisplayed();
		
		return true;
	}
	
	public boolean isDeleteNotPresent() {
		if(tableRows.isDisplayed() != true) {
			if(deleteIcon.isDisplayed()!=true) {
				
				System.out.println("No table data, no delete icon");
				return true;
			}
			
		}
		return false;
		
	}
	
	public boolean isSortPresent() {
		if(sortClassId.isDisplayed() && sortStudentId.isDisplayed() && sortPresent.isDisplayed()) {
			return true;
		}
		else return false;
	}
	
	public boolean isCheckboxPresent() {
		
		 numofrows =tableRows.findElements(By.tagName("tr")).size();
	    for(int i=1;i<numofrows;i++) {
	    	
	    	checkbox.isDisplayed();	
	    	
	    	return true;
	    }
			return false;
		}
	
	public boolean showDatatableEntries() {
		String pagText= paginationText.getText();
		if(pagText.matches("Showing ([0-9]+) to ([0-9]+) of"+numofrows +"entries")) {
			return true;
		} else return false;
	}
	
	public boolean isPagination() {
		if(prevArrow.isDisplayed() && nextArrow.isDisplayed() && firstArrow.isDisplayed() && lastArrow.isDisplayed()) {
			return true;
		}
		else return false;
	}
	
	public boolean verifyFooterEntries() {
		String footerEntry= footerText.getText();
		if(footerEntry.matches("In total there are"+numofrows +"Attendances")) {
			return true;
			
		}else return false;
	} 
	
	
	//2.Attendance Details popup
	public void clickNewAttendance() {
		newAttendanceButton.click();
	}
	
	public boolean correctSpelling() {
		popupactual.add(programNameLabel.getText());
		popupactual.add(classNameLabel.getText());
		popupactual.add(studentNameLabel.getText());
		popupactual.add(attendanceLabel.getText());
		popupactual.add(attendanceDateLabel.getText());
		popupexpected.add("Program Name");
		popupexpected.add("Class Name");
		popupexpected.add("Student Name");
		popupexpected.add("Attendance");
		popupexpected.add("Attendance Date");
		if (popupactual.equals(popupexpected) == true) {
			System.out.println("Spellings are correct");
		}
		return true;
	}
	
	public int dropdownCount() {
		int noofdropdown=dropDown.findElements(By.tagName("a")).size();
		return noofdropdown;
	}
	
	public String getTextColor() {
		return programNameDropdown.getCssValue("color");
	}
	
	public boolean closeRightTopAligned() {
		if(closeIcon.getCssValue("vertical-align")=="top" && closeIcon.getCssValue("horizontal-align")=="right") {
			System.out.println("Close icon is right top aligned");
		}
		return true;			
	}
	
	public boolean saveBtn() {
		return saveButton.isDisplayed();
	}
	
	public String firstDropdownText() {
		return programNameDropdown.getText();
	}
	
	public String secondDropdownText() {
		return classNameDropdown.getText();
	}
	
	public String thirdDropdownText() {
		return studentNameDropdown.getText();
	}
	
	public String fourthDropdownText() {
		return attendanceDropdown.getText();
	}
	
	public boolean cancelBtn() {
		return cancelButton.isDisplayed();
	}
	
	public boolean closeBtn() {
		return closeIcon.isDisplayed();
	}
	
	public boolean orderofLabels() {
	if(
	driver.findElement(By.cssSelector("div#dropDown > div:nth-child(1) > label#program-name")).isDisplayed()&&
	driver.findElement(By.cssSelector("div#dropDown > div:nth-child(2) > label#class-name")).isDisplayed()&&
	driver.findElement(By.cssSelector("div#dropDown > div:nth-child(3) > label#student-name")).isDisplayed()&&
	driver.findElement(By.cssSelector("div#dropDown > div:nth-child(4) > label#attendance")).isDisplayed()&&
	driver.findElement(By.cssSelector("div#dropDown > div:nth-child(5) > label#attendance-date")).isDisplayed()) {
		System.out.println("Labels are in order");
	}return true;
	} 
	
	//3.Attendance Details Popup window
	
	public boolean isOnAttendanceDetailsPopup() {
		return attendanceDetailsPopup.isDisplayed();
	}
	
	public void clickProgramNameDropdown() {
		programNameDropdown.click();
	}
	
	public void clickClassNameDropdown() {
		programNameDropdown.click();
	}
	public void clickStudentNameDropdown() {
		programNameDropdown.click();
	}
	public void clickAttendanceDropdown() {
		programNameDropdown.click();
	}
	
	
	public String clickDatePicker() {
		datePicker.click();
		//List<WebElement> columns = datePicker.findElements(By.tagName("td"));
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt + "\n");
        todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
        return todayStr;
	}
	
	public boolean isSelectedDatePresent() {
		String date=attendanceDateTextbox.getText();
		if(todayStr.equals(date)) {
			return true;
		}
		else return false;
	}
	
	public boolean verifyAttendanceFields() {
		attendanceDropdown.click();
		String expectedOptions []= {"Present","Absent","Late","Excused"};
		Select select = new Select(attendanceDropdown);
		List<WebElement> allOptions = select.getOptions();
		for(int i=0; i<allOptions.size(); i++) {
		   Assert.assertEquals(allOptions.get(i).getText(), expectedOptions[i]);
		   return true;
		}
		return false;
	}
	
	public boolean verifyCorrectSpellinginDropDown() {
		String prgnamedd=programNameDropdown.getText();
		String classdd=programNameDropdown.getText();
		String studentdd=programNameDropdown.getText();
		String attendancedd=programNameDropdown.getText();
		if (prgnamedd=="Select a Program name" && classdd=="Select Class Name" && studentdd=="Select students" && attendancedd=="Select Attendance") {
			return true;
		}
		return false;
	}
	public void clickLeftArrow() {
		leftArrow.click();
	}
	public void clickRightArrow() {
		rightArrow.click();
	}
	public boolean dateFormat() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("mm/dd/yyyy");
		dtf.parse(todayStr);
		return true;	
	}
	
	public Date futureDate(){
		datePicker.click();
        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.DATE, 10);
        cal.add(Calendar.MONTH, 2);
        cal.add(Calendar.YEAR, 1);
        Date d =cal.getTime();
        return d;
        
    }
	
	public boolean previousMonth() {
		datePicker.click();
		String monthyearvalue=currentDisplayDate.getText();
		String month=monthyearvalue.split("")[0].trim();
		leftArrow.click();
		String monthyearvalue1=currentDisplayDate.getText();
		String month1=monthyearvalue1.split("")[0].trim();
		
		return true;
	}
	
	public boolean nextMonth() {
		datePicker.click();
		String monthyearvalue=currentDisplayDate.getText();
		String month=monthyearvalue.split("")[0].trim();
		rightArrow.click();
		Calendar cal= Calendar.getInstance(); 
		String month1 = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		return true;
	}
	
	public String getDropdownClassName() {
		String dropdownClassname = new Select(classNameDropdown).getFirstSelectedOption().getText();
		return dropdownClassname;
	}
	public String getDropdownProgramName() {
		String dropdownProgramname = new Select(programNameDropdown).getFirstSelectedOption().getText();
		return dropdownProgramname;
	}
	
	//4. Add Edit attendance
	public void selectFutureDateAndSave() {
		datePicker.click();
        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.DATE, 10);
        cal.add(Calendar.MONTH, 2);
        cal.add(Calendar.YEAR, 1);
		saveButton.click();
	}
	
	
	public void fillAllValuesAndSave() {
		Select progname = new Select(programNameDropdown);
		progname.selectByIndex(0);
		Select classname = new Select(classNameDropdown);
		classname.selectByIndex(0);
		Select studname = new Select(studentNameDropdown);
		studname.selectByIndex(0);
		Select attendancestatus = new Select(attendanceDropdown);
		attendancestatus.selectByIndex(0);
		datePicker.click();
		month.click();
		date.click();
		year.click();
		saveButton.click();
		String footerEntry= footerText.getText();
		int value = Integer.parseInt(footerEntry.replaceAll("[^0-9]", ""));
		if(numofrows== value-1) {
			System.out.println("Attendance details Successfully added");
		}
			
	}
	
	public String getSuccessMsg() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return successMsg.getText();
	}
	
	
	public void missingProgramNameAndSave() {
		Select classname = new Select(classNameDropdown);
		classname.selectByIndex(0);
		Select studname = new Select(studentNameDropdown);
		studname.selectByIndex(0);
		Select attendancestatus = new Select(attendanceDropdown);
		attendancestatus.selectByIndex(0);
		datePicker.click();
		month.click();
		date.click();
		year.click();
		saveButton.click();
	}
	public void missingClassNameAndSave() {
		Select progname = new Select(programNameDropdown);
		progname.selectByIndex(0);
		Select studname = new Select(studentNameDropdown);
		studname.selectByIndex(0);
		Select attendancestatus = new Select(attendanceDropdown);
		attendancestatus.selectByIndex(0);
		datePicker.click();
		month.click();
		date.click();
		year.click();
		saveButton.click();
	}
	public void missingStudentNameAndSave() {
		Select progname = new Select(programNameDropdown);
		progname.selectByIndex(0);
		Select classname = new Select(classNameDropdown);
		classname.selectByIndex(0);
		Select attendancestatus = new Select(attendanceDropdown);
		attendancestatus.selectByIndex(0);
		datePicker.click();
		month.click();
		date.click();
		year.click();
		saveButton.click();
	}
	public void missingAttendanceAndSave() {
		Select progname = new Select(programNameDropdown);
		progname.selectByIndex(0);
		Select classname = new Select(classNameDropdown);
		classname.selectByIndex(0);
		Select studname = new Select(studentNameDropdown);
		studname.selectByIndex(0);
		datePicker.click();
		month.click();
		date.click();
		year.click();
		saveButton.click();
	}
	public void missingAttendanceDateAndSave() {
		Select progname = new Select(programNameDropdown);
		progname.selectByIndex(0);
		Select classname = new Select(classNameDropdown);
		classname.selectByIndex(0);
		Select studname = new Select(studentNameDropdown);
		studname.selectByIndex(0);
		Select attendancestatus = new Select(attendanceDropdown);
		attendancestatus.selectByIndex(0);
		saveButton.click();
	}
	
	public String GetErrorMsg() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String errormessage=errorMsg.getText();
		return errormessage;
	}
	public void updateAllValuesSuccessful() {
		editIcon.click();
		saveButton.click();
	}
	
	public boolean isNextPageEnabled() {
		return nextPage.isEnabled();
	}
	public boolean isNextPageDisabled() {
		if(nextPage.isEnabled()) {
			System.out.println("NextPage is disabled since entries in table are less than or equal to 5");
		}
		return false;
	}
	public void clickEdit() {
		editIcon.click();
	}
	
	public void editValidAttendance() {	
		
		Select progname = new Select(programNameDropdown);
		progname.selectByIndex(1);
		Select classname = new Select(classNameDropdown);
		classname.selectByIndex(1);
		Select studname = new Select(studentNameDropdown);
		studname.selectByIndex(1);
		Select attendancestatus = new Select(attendanceDropdown);
		attendancestatus.selectByIndex(1);
		datePicker.click();
		month.click();
		date.click();
		year.click();
		saveButton.click();
		String footerEntry= footerText.getText();
		int value = Integer.parseInt(footerEntry.replaceAll("[^0-9]", ""));
		if(numofrows== value) {
			System.out.println("Attendance details Successfully edited");
		
			}
	}
	
	public void editMissingProgramNameAndSave() {
		
		Select classname = new Select(classNameDropdown);
		classname.selectByIndex(1);
		Select studname = new Select(studentNameDropdown);
		studname.selectByIndex(1);
		Select attendancestatus = new Select(attendanceDropdown);
		attendancestatus.selectByIndex(1);
		datePicker.click();
		month.click();
		date.click();
		year.click();
		saveButton.click();
	}
	public void editMissingClassNameAndSave() {
	
		Select progname = new Select(programNameDropdown);
		progname.selectByIndex(1);
		Select studname = new Select(studentNameDropdown);
		studname.selectByIndex(1);
		Select attendancestatus = new Select(attendanceDropdown);
		attendancestatus.selectByIndex(1);
		datePicker.click();
		month.click();
		date.click();
		year.click();
		saveButton.click();
	}
	public void editMissingStudentNameAndSave() {
		
		Select progname = new Select(programNameDropdown);
		progname.selectByIndex(1);
		Select classname = new Select(classNameDropdown);
		classname.selectByIndex(1);
		Select attendancestatus = new Select(attendanceDropdown);
		attendancestatus.selectByIndex(1);
		datePicker.click();
		month.click();
		date.click();
		year.click();
		saveButton.click();
	}
	public void editMissingAttendanceAndSave() {
		
		Select progname = new Select(programNameDropdown);
		progname.selectByIndex(1);
		Select classname = new Select(classNameDropdown);
		classname.selectByIndex(1);
		Select studname = new Select(studentNameDropdown);
		studname.selectByIndex(1);
		datePicker.click();
		month.click();
		date.click();
		year.click();
		saveButton.click();
	}
	public void editMissingAttendanceDateAndSave() {
	
		Select progname = new Select(programNameDropdown);
		progname.selectByIndex(1);
		Select classname = new Select(classNameDropdown);
		classname.selectByIndex(1);
		Select studname = new Select(studentNameDropdown);
		studname.selectByIndex(1);
		Select attendancestatus = new Select(attendanceDropdown);
		attendancestatus.selectByIndex(1);
		saveButton.click();
	}
	
	
	// 5. Delete Attendance Validation
	
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}   // isAlertPresent()
	
	
	public void deleteIcon() {
		deleteIcon.click();
	}
	public String alertpopdeletedetails() {
    	try {
    		 alert = driver.switchTo().alert().getText();		
    		
    		} catch (Exception e) {
    		//exception handling
    		}
     return alert;
    }
	
	public boolean verifyYes() {
		return alert.contains("Yes");
	}

	public boolean verifyNo() {
		return alert.contains("No");
	}

    public void alertpopupayes() {
    	
    		Alert alert = driver.switchTo().alert(); // switch to alert
    		alert.accept();
    		

    		String alertMessage= driver.switchTo().alert().getText(); // capture alert message

    				alert.accept();
    	}

    public void alertpopupano() {
    	
    	Alert alert = driver.switchTo().alert(); // switch to alert
    	alert.accept();
    	

    	String alertMessage= driver.switchTo().alert().getText(); // capture alert message

    			alert.dismiss();
    }
    	
    	
    	public boolean  verifydelete()
    	{
       boolean isDeleted = deletedAttendanceRow.isDisplayed();
         if (!isDeleted) {
        	 System.out.println("Item deletion verification sucess");
        	 return true;
        
         } else {
        	 System.out.println("Item deletion verification failed.");
        	 return false;
         }

    }
	
    	//6. Delete Multiple Attendance Validation
    	public void clickFirstRowCheckbox() {
    		webtableFirstCheckbox.click();
    		
    	}
    	
    	public boolean isHeaderDeleteEnabled() {
    		return headerdeletebtnmulti.isEnabled();
    	}
    	public WebElement clickAnyCheckbox() {
    		for(int i=2;i<=numofrows;i++) {
    			anycheckBox=driver.findElement(By.xpath("//table//tbody//tr[1]//td["+i+"]"));
    			anycheckBox.click();
    			
    		}
			return anycheckBox;
    	}
    	public void clickMultipleCheckbox() {
    		clickAnyCheckbox();
    		clickAnyCheckbox();
    	}
    	
    	public void isChecked() {
    		webtableFirstCheckbox.isSelected();
    	}
    	public boolean isCheckedMultiple() {
    		WebElement ele1=clickAnyCheckbox();
    		WebElement ele2=clickAnyCheckbox();
    		if(ele1.isSelected() && ele2.isSelected()) {
    			return true;
    		}
    		else return false;
    	}
    	
    	public boolean isAlertPresentHeaderDel() 
    	{ 
    		clickAnyCheckbox();
    		headerdeletebtnmulti.click();
    	    try 
    	    { 
    	        driver.switchTo().alert(); 
    	        return true; 
    	    }   // try 
    	    catch (NoAlertPresentException Ex) 
    	    { 
    	        return false; 
    	    }   // catch 
    	}   
    	
    	
    	//7. Pagination in Manage Attendance
    	
    	public boolean printDatatable() {
    		int tabledata =dataTable.findElements(By.tagName("td")).size();
    		if(tabledata>=1) {
    			return dataTable.isDisplayed();
    		}
    		return false;
    	}
    	
    	public void firstpagecount()
	    {
	    	
	    	//  WebElement pageCountElement = dataTable.findElement(By.id("page-count"));
	            String pageCountText = pageCountElement.getText();
	            int pageCount = Integer.parseInt(pageCountText);
	            if (pageCount == 1) {
	            	System.out.println("The admin in the first page");
	            } 

	    }
       public boolean checkrightarrow()
       
       {
    	  // List<WebElement> assignmentElements = driver.findElements((By) assignmentRow);
	    	
	    	//  int assignmentCount = assignmentElements.size();
	    	  if(assignmentCount>5)
	    	  {
    	   try {
    	   boolean isRightArrowEnabled = pagrightArrow.isEnabled();
       
    	   
       if (isRightArrowEnabled) {
    	   return true;
       } 
    	   
       else {
    	   return false;
       }
    	   }
    catch (Exception e) {
       e.printStackTrace();

       }}
			return false;
	    
	    
       }
       public boolean checkleftarrow()
       {
    	   try {
    		   boolean isLeftArrowDisabled = ! pagleftArrow.isEnabled();

               if (isLeftArrowDisabled) {
            	   return true;
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
		return false; 
       }
       
       public void checkRightArrow2Page_Pagination_enable()
       {
    	   if(assignmentCount>5)
    	   {
    		   pagrightArrow.click();
    		   if(assignmentCount>10)
    		   {
    			   boolean isRightArrowEnabled = pagrightArrow.isEnabled();
    		       	   
    		       if (isRightArrowEnabled) {
    		    	   System.out.println("Right arrow is enabled on 2nd page one when entries are more than 10 available in assignment.");
    		       } 	   
    		   }
    	   }
       }
       
       public void checkleftArrow2Page()
       {
    	   if(assignmentCount>5)
    	   {
    		   pagrightArrow.click();
    		  
    		   	boolean isLefttArrowEnabled = pagleftArrow.isEnabled();         	   
    		       if (isLefttArrowEnabled) {
    		    	   System.out.println("Left arrow is enabled on 2nd page one when entries");
    		       } 			   
    		   }
    	   }
       public void pagination_disable()
       {
    	   if(assignmentCount<5)
    	   {
    			   boolean isLefttArrowEnabled = pagleftArrow.isEnabled();
    			   boolean isRightArrowEnabled= pagrightArrow.isEnabled();    	   
    		       if (!isLefttArrowEnabled) {
    		    	   System.out.println("Left arrow is disabled");
    		       } 
    		       
    		       if (!isRightArrowEnabled) {
    		          System.out.println("Right arrow is disabled");
    		       } 
    		            			   
    		   }
       
       }
       
       // 8. Navigation Function Validation
       
       public void clicklinkonnavbar(String module) {
			
			 switch(module) {
			
			 case "Program" :  program.click();;break;
			 case "Student"	: student.click();break;
			 case "Batch"	: batch.click();break;
			 case "Class"	: class1.click();break;
			 case "User"	: user.click();break;
			 case "Assignment"	:assignment.click();break;
			 case "Attendance"	: attendance.click();;break;
			
			 }
}
    	
	
}