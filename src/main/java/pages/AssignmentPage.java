package pages;

import java.util.Locale;

import org.testng.Assert;
import org.testng.AssertJUnit;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;




//import junit.framework.Assert;

import utilities.LoggerLoad;
import java.util.Date;



public class AssignmentPage {
	
	public WebDriver driver;
   String headername;
   String alert;
   private Date d;
   // private Locators elements;
   
   //Manage assignment Page verification
   @FindBy(xpath="[//a[text()='Program']") public WebElement program;
   @FindBy(xpath="[//a[text()='Student']") public WebElement student;
   @FindBy(xpath="[//a[text()='Attendance']") public WebElement attendance;
   @FindBy(xpath="[//a[text()='Batch']") public WebElement batch;
	@FindBy(xpath="[//a[text()='Class']") public WebElement class1;
	@FindBy(xpath="[//a[text()='User']") public WebElement user;
	@FindBy(xpath="[//a[text()='assignment']") WebElement assignment;
	@FindBy(xpath="[//a[text()='logout']") WebElement logout;
	
	@FindBy (xpath="//input[@value='AddNewAssignment']")WebElement AddNewAssignment;
	@FindBy(xpath="<label for=\"showing entries\">Showing x to y of z entries?</label>") WebElement showingnoofentries ;
	@FindBy(xpath="<label for=\"total entries\">Showing z entries?</label>")WebElement totalentries;
	@FindBy(xpath="<label for=\"1,2,3\">pagination</label>")WebElement pagination;
	@FindBy (xpath="//input[@value='Delete']")WebElement topleftdelete;
	@FindBy (xpath="//input[@value='AddNewAssignmrnt']")WebElement AddnewAssignment;
	@FindBy(xpath="//table[@id='users_table']/tbody")WebElement Webtablerows;
	@FindBy(xpath="<h1 id = “h1>assignmentname</h1>")WebElement assignmentnameheader;
	@FindBy(xpath="<h2 id = “h2>assignmentdescription</h2>")WebElement assignmentdescriptiontionheader ;
	@FindBy(xpath="<h3 id = “h3>assignmentduedate</h3>")WebElement assignmentduedateheader ;
	@FindBy(xpath="<h3 id = “h3>assignmentgrade</h3>")WebElement assignmentgradeheader ;
	@FindBy(xpath="<h4 id = “h4>edit</h4>")WebElement editheader;
	@FindBy(xpath="<h4 id = “h4>delete</h4>")WebElement deleteheader;
	@FindBy(xpath="<h4 id = “h4>ckbox</h4>") WebElement checkbox;
	@FindBy(id="sortarrow1")WebElement assignmentnamesortarrow;
	@FindBy(id="sortarrow2")WebElement assignmentdescriptionsortarrow;
	@FindBy(id="sortarrow3")WebElement assignmenttatussortarrow;
	@FindBy (name="search") WebElement search;
	@FindBy(xpath="/*[@id='attendance']/tbody/tr[2]/td") WebElement TotalNoColumns;
	@FindBy(xpath="//*[@id='attendance']/tbody/tr ") WebElement TotalNoRows;
	@FindBy(xpath="//*[@id='assignmentenry") WebElement assignmententries;
	@FindBy(xpath="//*[@id='delete\')") WebElement DeleteFirstRecord;
	@FindBy(xpath="//*[@id='checkbox\')") WebElement checkFirstRecord;
	@FindBy(xpath="////tab[@id='table']/tbody/tr/td[3]") WebElement ItemDelete1;
	String ItemDeleted= ItemDelete1.getText();
	@FindBy(xpath="/parent::td//preceding-sibling::td(1)//input[@type=‘editbutton’]") WebElement editbtn1;
	
	//pagination
	@FindBy(xpath="//[@id='data-table-id']") WebElement dataTable;
	 @FindBy(xpath="//[@class='right-arrow']") WebElement rightArrow;
	 @FindBy(xpath="//[@class='2right-arrow']") WebElement secondPagerightArrow;
	 @FindBy(xpath="//[@class='left-arrow']") WebElement leftArrow;
	 @FindBy(xpath="//[@id='next-page-button']") WebElement nextPageButton;
	 @FindBy(xpath="//[@id='aasignment-row']") WebElement assignmentRow;
	 WebElement pageCountElement = dataTable.findElement(By.id("page-count"));
	 List<WebElement> assignmentElements = driver.findElements((By) assignmentRow);
	 @FindBy(id="assignment-1") WebElement deleteAssignmentRow;
	  int assignmentCount = assignmentElements.size();
	@FindBy(xpath="//[@id='popupheadin']") WebElement popHeading;
	//WebElement deletedAssignmentRow = driver.findElement(By.id("assignment-1"));
	@FindBy(id="assignment1") WebElement deletedAssignmentRow;
	
	
	//Add new assignment
	@FindBy (xpath="//input[@value='AddNewAssignment']")WebElement Addnewassignment;
	@FindBy(xpath="//*[@id=popup]") WebElement assignmentpopup;
	@FindBy(xpath="//@id='textbox567") WebElement textbox;
	private int textboxcount= driver.findElements(By.xpath("//@id='textbox567")).size();
	String mainWindowHandle;
	@FindBy(xpath="//@id='Batch dropdown-in-popup'") WebElement BatchDropDown;
	@FindBy(xpath="//@id='Program dropdown-in-popup'") WebElement ProgramDropDown;
	@FindBy(xpath="//[@id='calendar-icon']") WebElement CalanderIcon;
	@FindBy(xpath="//[@id='save-button']") WebElement SaveButton;
	@FindBy(xpath="//[@id='cancel-button']") WebElement CancelButton;
	@FindBy(xpath="//[@id='close-button']") WebElement CloseButton;
	@FindBy(xpath="//*[@id='assignmnettextbox']") WebElement AssignmentTextBox;
	@FindBy(xpath="//*[@id='month']") WebElement Month;
	@FindBy(xpath="//*[@id='date']")WebElement Date;
	@FindBy(xpath="//*[@id='Year']")WebElement Year;
	@FindBy(xpath="//*[@id='success']") WebElement SuccessMsg;
	@FindBy(xpath="//*[@id='error']") WebElement ErrorMsg;
	@FindBy(xpath="//*[@id='assgnmentDate']") WebElement assignmentDateTextbox;
	@FindBy(xpath="//*[@id='CRightArrow']") WebElement CalanderRightArrow;
	@FindBy(xpath="//*[@id='CLefttArrow']") WebElement CalanderLfttArrow;
	
	//Locator for Edit Assignment
	@FindBy(xpath="//*[@id='edit1']") WebElement EditButton;
	@FindBy(xpath="//*[@id='editAssignmentHeadin']") WebElement EditpopupHeading;
	@FindBy(xpath="//tr/td[1]") WebElement ProgramNAme;
	@FindBy(xpath="//tr/td[1]") WebElement BatchName;
	@FindBy(xpath="//tr/td[1]") WebElement AssignmentNAme;
	@FindBy(xpath="//tr/td[1]") WebElement AssignmentDueDate;
	@FindBy(xpath="//*[@id='AssignmentDesc") WebElement AssignmentDescTextbox;
	@FindBy(xpath="//*[@id='GradeBy") WebElement GradeByTextbox;
	@FindBy(xpath="//*[@id='AssignmentFile1") WebElement AssignmentDescFile1;
	@FindBy(xpath="//*[@id='AssignmentFile2") WebElement AssignmentDescFile2;
	@FindBy(xpath="//*[@id='AssignmentFile3") WebElement AssignmentDescFile3;
	
	public AssignmentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
   
	//Manage assignment Page verification
   public void login()
   {
	   
   }
	
	public void clickassignment() {
		assignment.click();
		
	}
	
	public boolean validateheader(String headerName)
	{
		String header= assignmentnameheader.getText();
		//assert.assertTrue(headerName.contains(header));
		boolean detect=headerName.contains(header);
		return true;
	
	}
	
	public boolean deletebutton()
	
	{
		
		//assert.asserFalse(topleftdelete.isEnabled());
		boolean deletedetect=topleftdelete.isEnabled();
		return false;
		
	}
	public void serchboxcheck()
	{
		if(search.isDisplayed())
		{
			LoggerLoad.info("Search box is displayed");
		}
		LoggerLoad.info("Search box is not displayed");
		
	}
	
	public void addNewAssignmnetbuttoncheck()
	{
		if(AddNewAssignment.isDisplayed())
		{
			LoggerLoad.info("Add new assignment button is displayed");
		}
		LoggerLoad.info("Add new assignment button is not displayed");
		
	}

	public void webtablerows() {
		List<WebElement>TotalRowsList =Webtablerows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
	}
	public void sortarrowbutton() {
		assignmentnamesortarrow.isDisplayed();
		assignmentdescriptionsortarrow.isDisplayed();
		assignmenttatussortarrow.isDisplayed();
	}
	public void checkboxcheck() {
		int checkboxlist =Webtablerows.findElements(By.tagName("tr")).size();
	    String beforepath="//*[@id=\"resultTable\"]/tbody/tr[";
	    for(int i=1;i<checkboxlist;i++) {
	    	driver.findElement(By.xpath(beforepath+i+ "]/td[i]")).isDisplayed();	
	}}
	
	    public void editcheck() {
	    	int checkboxlist =Webtablerows.findElements(By.tagName("tr")).size();
	    	String beforepath="//*[@id=\"resultTable\"]/tbody/tr[";
	        for(int i=1;i<checkboxlist;i++) {
	        	driver.findElement(By.xpath("/parent::td//preceding-sibling::td//input[@type=‘editbutton’]")).isDisplayed();
	        }
	    }
	    //Verify spelling of the collumn header
		    
	    public boolean verifyCorrectSpelling() {
			String programtext=program.getText();
			String classtext=class1.getText();
			String studenttext=student.getText();
			String attendancetext=attendance.getText();
			String assignmenttext =assignment.getText();
			String logouttext=logout.getText();
			if (programtext=="Program" && classtext=="Class" && studenttext=="Student" && attendancetext=="Attendance" && assignmenttext=="Assignment" &&logouttext=="Logout") {
				return true;
			}
			return false;
		}

	    public void deletecheck() {
	    	int checkboxlist =Webtablerows.findElements(By.tagName("tr")).size();
	    	String beforepath="//*[@id=\"resultTable\"]/tbody/tr]";
	        for(int i=1;i<checkboxlist;i++) {
	        	driver.findElement(By.xpath("/parent::td//preceding-sibling::td//input[@type=‘deletebutton’]")).isDisplayed();
	        }
	    }
	    public String textsearch() {
	    	String searchboxtext=search.getText();
	    	return searchboxtext;
	    }
	    
	    public void serachtext(String random)
	    
	    {
	    	search.sendKeys(random);
	    	search.sendKeys(Keys.ENTER);
	    	
	    }
	    public void checkentry()
	    {
	    	List<WebElement>TotalRowsList =Webtablerows.findElements(By.tagName("tr"));
	    	if(TotalRowsList.size()>0)
	    	{
	    		LoggerLoad.info("Entries are displayed");
	    	}
	    	
	    }
	    public void entries() {
	    	List<WebElement>TotalRowsList =Webtablerows.findElements(By.tagName("tr"));
	    	if(TotalRowsList.size()==0)
	    	{
	    		LoggerLoad.info("Zero entries");
	    	}
	    	else
	    	for(int i=1;i<TotalRowsList.size();i++) 
	    	{
	    	
	    	{
	    	List<WebElement> cells= Webtablerows.findElements(By.tagName("td"));

	    	for(int j=1;j<cells.size();j++){
	    	List<WebElement> cellSubRow= cells.get(i).findElements(By.tagName("td"));
	    	System.out.println(cellSubRow.get(j).getText());
	    	}
	    	}}
	    	
	    }
	      public void Assertfun(String title)
	    {
	    	String currenturl= driver.getCurrentUrl();
	    	AssertJUnit.assertTrue(currenturl.contains(title));
	    	
	    	
		
		LoggerLoad.info("The admin the manage assignment");
					
	    
			
	    }
	    
	    public void headercolum(String data) {
	    	switch(data)
	    	{
	    	case "Check Box": checkbox.isDisplayed(); break;
	    	case "Assignment Name":assignmentnameheader.isDisplayed(); break;
	    	case "Assignment Description": assignmentdescriptiontionheader.isDisplayed(); break;
	    	case "Assignment Due Date": assignmentduedateheader.isDisplayed(); break;
	    	case "Assignment Grade": assignmentgradeheader.isDisplayed(); break;
	    	case "Edit":editheader.isDisplayed(); break;
	    	case "Delete":deleteheader.isDisplayed(); break;
	    	}
	    	
	    }
	    
	    public void check_entries()
	    {
	    	String entry=assignmententries.getText();
	    	if(entry.contains("0"))
	    	{
	    		
	    	}
	    }
	    
	    public void showentry()
	    {
	    	AssertJUnit.assertTrue(showingnoofentries.isDisplayed());
	    	LoggerLoad.info(showingnoofentries.getText());
	    }
	    public void showpagination()
	    {
	    	AssertJUnit.assertTrue(pagination.isDisplayed());
	    	LoggerLoad.info(pagination.getText());
	    }
	    public void showtotalentries()
	    {
	    	AssertJUnit.assertTrue(totalentries.isDisplayed());
	    	LoggerLoad.info(totalentries.getText());
	    }
	    
	    
	    
	   
	   
	   
	    
	    
	    
	   
       //add new assignment
       
       public void add_new_assignment_click()
       {
    	   AddnewAssignment.click();
    	   
    	   String mainWindowHandle = driver.getWindowHandle();
           for (String popupHandle : driver.getWindowHandles()) {
               if (!popupHandle.equals(mainWindowHandle)) {
                   driver.switchTo().window(popupHandle);
                   break;
               }
           }
       }
       //Verify Pop-up heading
       public void add_new_assignment_heading()
       {
    	   String heading= popHeading.getText();
    	   if(heading.contains("Assignment Details"))
    	   {
    		   return;
    	   }
    	   	
       }
       
       public void validate_popup_fields()
       
       {
    	   String popupfields= assignmentpopup.getText();
    	   if(popupfields.contains("Program Name"))
    	   {
    		   return;
    	   }
    	   if(popupfields.contains("Batch Number"))
    	   {
    		   return;
    	   }
    	   if(popupfields.contains("Assignment Name"))
    	   {
    		   return;
    	   }
    	   if(popupfields.contains("Assignment Description"))
    	   {
    		   return;
    	   }
    	   if(popupfields.contains("Grade By"))
    	   {
    		   return;
    	   }
    	   if(popupfields.contains("Assignmnet Due Date"))
    	   {
    		   return;
    	   }
    	   if(popupfields.contains("Assignmnet File 1"))
    	   {
    		   return;
    	   }
    	   if(popupfields.contains("Assignmnet File 2"))
    	   {
    		   return;
    	   } if(popupfields.contains("Assignmnet File 3"))
    	   {
    		   return;
    	   }
    	   
    	   
       }
       
       public void validate_textbox()
       {
    	   int textboxcount= driver.findElements(By.xpath("//@id='textbox567")).size();
    	   if(textboxcount==8)
    	   {
    		   return;
    	   }
       }
       
       public void Validate_BatchNumber_dropdown()
       {
    	  
           if (BatchDropDown.isDisplayed()) {
               return;
           
           }

           
           driver.switchTo().window(mainWindowHandle);
       }
       
       public void Validate_ProgramName_dropdown()
       {
    	  
           if (ProgramDropDown.isDisplayed()) {
               return;
           
           }

           
        driver.switchTo().window(mainWindowHandle);
       }
       
       public void validate_calender_icon()
       {

           if (CalanderIcon.isDisplayed()) {
               return;
           
           }
           driver.switchTo().window(mainWindowHandle);
       }
       public void validate_save_button()
       {

           if (SaveButton.isDisplayed()) {
               return;
           
           }
           driver.switchTo().window(mainWindowHandle);
       }
       
       public void validate_cancel_button()
       {

           if (SaveButton.isDisplayed()) {
               return;
           
           }
           driver.switchTo().window(mainWindowHandle);
       }
       
       public void validate_close_button()
       {

           if (SaveButton.isDisplayed()) {
               return;
           
           }
           driver.switchTo().window(mainWindowHandle);
       }
       
       //Add new assignment
       
       public void fillValuesAndSave(String AssName) 
       {
   		
		Select progname = new Select(ProgramDropDown);
   		progname.selectByIndex(0);
   		Select batchNumber = new Select(BatchDropDown);
   		batchNumber.selectByIndex(0);
   		AssignmentTextBox.sendKeys(AssName);
   		CalanderIcon.click();
   		Month.click();
   		Date.click();
   		Year.click();
   		SaveButton.click();
   		String footerEntry= showingnoofentries.getText();
   		int value = Integer.parseInt(footerEntry.replaceAll("[^0-9]", ""));
   		int numofrows = 0;
		if(numofrows== value-1) {
   			System.out.println("Assignment details Successfully added");
   		}
       }
       
		public String getSucessMsg() {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return SuccessMsg.getText();
}
		public String getErrorMsg()
		{
		
			
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return ErrorMsg.getText();
		}
		
		public void missingValue()
		{
			SaveButton.click();
		}
		
		public void save_pdate( String AssignmentName)
		{
			Select progname = new Select(ProgramDropDown);
	   		progname.selectByIndex(0);
	   		Select batchNumber = new Select(BatchDropDown);
	   		batchNumber.selectByIndex(0);
	   		AssignmentTextBox.sendKeys(AssignmentName);
	   		
			
		}
		
		 public void selectPastDateAndSave() {
			 CalanderIcon.click();
		        Calendar cal= Calendar.getInstance();
		        cal.add(Calendar.DATE, -10);
		        cal.add(Calendar.MONTH, -2);
		        cal.add(Calendar.YEAR, -1);
				SaveButton.click();
			}
		 
		 public String clickDatePicker() {
				CalanderIcon.click();
				List<WebElement> columns = CalanderIcon.findElements(By.tagName("td"));
				Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
				int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		        System.out.println("Today Int: " + todayInt + "\n");
		        String todayStr = Integer.toString(todayInt);
		        System.out.println("Today Str: " + todayStr + "\n");
		        return todayStr;
			}
			
			public boolean isSelectedDatePresent() {
				CalanderIcon.click();
				List<WebElement> columns = CalanderIcon.findElements(By.tagName("td"));
				Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
				int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		        System.out.println("Today Int: " + todayInt + "\n");
		        String todayStr = Integer.toString(todayInt);
		        System.out.println("Today Str: " + todayStr + "\n");
				String date=assignmentDateTextbox.getText();
				if(todayStr.equals(date)) {
					return true;
				}
				else return false;
			}
			
			public boolean dateFormat() {
				DateTimeFormatter dtf=DateTimeFormatter.ofPattern("mm/dd/yyyy");
				Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
				int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
				String todayStr = Integer.toString(todayInt);
				dtf.parse(todayStr);
				return true;	
			}
			
			public void Calander_clickRightArrow() {
				CalanderIcon.click();
				CalanderRightArrow.click();
				
			}
			public boolean nextMonth() {
				
				
				Calendar cal= Calendar.getInstance(); 
				String month1 = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
				LoggerLoad.info(month1);
				return true;
			}
			
			public void Calander_clickLeftArrow() {
				CalanderIcon.click();
				 CalanderLfttArrow.click();
			}
			
			public boolean previousMonth() {
				
				
				Calendar cal= Calendar.getInstance(); 
				String month1 = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
				LoggerLoad.info(month1);
				return true;
			}
			
			public Date futureDate(){
				CalanderIcon.click();
		        Calendar cal= Calendar.getInstance();
		        cal.add(Calendar.DATE, 10);
		        cal.add(Calendar.MONTH, 2);
		        cal.add(Calendar.YEAR, 1);
		        Date d =cal.getTime();
		        return d;
		        
		    }
			public void datepick()
			{
				CalanderIcon.click();
			}
         public void highlightcurrentdate()
         {
        	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
             Date currentDate = Calendar.getInstance().getTime();
             String expectedDate = dateFormat.format(currentDate);
             String datePickerText = CalanderIcon.getText();
             if (datePickerText.contains(expectedDate)) {
                 System.out.println("Current date is highlighted in the date picker: " + expectedDate);
             } else {
                 System.out.println("Current date is not highlighted in the date picker: " + expectedDate);
             }
        	 
         }
         
         public void highlightfutureDate()
         
         {
        	
        	
        	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        	 String expectedDate = dateFormat.format(d);
        	 String datePickerText = CalanderIcon.getText();
             if (datePickerText.contains(expectedDate)) {
                 System.out.println("Future date is highlighted in the date picker: " + expectedDate);
             } else {
                 System.out.println("Future date is not highlighted in the date picker: " + expectedDate);
             }
        	 
        	 
         }
         
         public void cancelAssignmentPopup()
         {
        	 CancelButton.click();
        	 driver.switchTo().defaultContent();
         }
         
         public void AssignmentPOPupWithInputs(String Name)
         {
        	 Select progname = new Select(ProgramDropDown);
        		progname.selectByIndex(0);
        		Select batchNumber = new Select(BatchDropDown);
        		batchNumber.selectByIndex(0);
        		AssignmentTextBox.sendKeys(Name);
        		CalanderIcon.click();
        		Month.click();
        		Date.click();
        		Year.click();
         }

         
         //Edit Assignment Validation
         
         public void ClickEdit()
         {
        	 EditButton.click();
        	 String mainWindowHandle = driver.getWindowHandle();
             for (String popupHandle : driver.getWindowHandles()) {
                 if (!popupHandle.equals(mainWindowHandle)) {
                     driver.switchTo().window(popupHandle);
                     break;
                 }
             }
         }
             
             public void verifyeditpopup()
             {
            	String s=  EditpopupHeading.getText();
            	 Assert.assertTrue(s.equals("Edit Assignment"));
            	 
             }
        	 
           
             
             public boolean verifydata()
             {
            	 String programName=ProgramNAme.getText();
     			String Batchname=BatchName.getText();
     			String AssignmentName=AssignmentNAme.getText();
     			String AssignmentDuedate=AssignmentDueDate.getText();
     			String AssignmentName1=AssignmentTextBox.getText();
     		   String ProgramName1=BatchDropDown.getText();
     			String BatchName1= BatchDropDown.getText();
     			String AssignmentDueDate1=CalanderIcon.getText();
     					
       			if (programName==ProgramName1 && Batchname==BatchName1 && AssignmentName==AssignmentName1 && AssignmentDuedate==AssignmentDueDate1) {
     				return true;
     			}
     			return false;
             }
         
             
             public void EditfillValuesAndSave(String AssName1) 
             {
         		
      		Select progname = new Select(ProgramDropDown);
         		progname.selectByIndex(1);
         		Select batchNumber = new Select(BatchDropDown);
         		batchNumber.selectByIndex(1);
         		AssignmentTextBox.sendKeys(AssName1);
         		CalanderIcon.click();
         		Month.click();
         		Date.click();
         		Year.click();
         		String programName=ProgramNAme.getText();
     			String Batchname=BatchName.getText();
     			String AssignmentName=AssignmentNAme.getText();
     			String AssignmentDuedate=AssignmentDueDate.getText();
     			String AssignmentName1=AssignmentTextBox.getText();
      		   String ProgramName1=BatchDropDown.getText();
      			String BatchName1= BatchDropDown.getText();
      			String AssignmentDueDate1=CalanderIcon.getText();
         		SaveButton.click();
         		
         		if (programName==ProgramName1 && Batchname==BatchName1 && AssignmentName==AssignmentName1 && AssignmentDuedate==AssignmentDueDate1) {
     				
         	   		
         			return;
         		}
             }
			
             
             public void fillIValuesAndSave(String AssName) 
             {
         		
      		Select progname = new Select(ProgramDropDown);
         		progname.selectByIndex(-1);
         		Select batchNumber = new Select(BatchDropDown);
         		batchNumber.selectByIndex(-1);
         		AssignmentTextBox.sendKeys(AssName);
         		
         		SaveButton.click();
             }
             public void fillIValuesAndSave1(String Name) 
             {
         		
      		Select progname = new Select(ProgramDropDown);
         		progname.selectByIndex(2);
         		Select batchNumber = new Select(BatchDropDown);
         		batchNumber.selectByIndex(2);
         		AssignmentTextBox.sendKeys(Name);
         		CalanderIcon.click();
         		
         		SaveButton.click();
             }
             public void PnamefillIValuesAndSave1(String Name) 
             {
         		
      		
         		Select batchNumber = new Select(BatchDropDown);
         		batchNumber.selectByIndex(2);
         		AssignmentTextBox.sendKeys(Name);
         		CalanderIcon.click();
         		
         		SaveButton.click();
             }
             public void BNumfillIValuesAndSave1(String Name) 
             {
         		
      		Select progname = new Select(ProgramDropDown);
         		progname.selectByIndex(2);
         		
         		AssignmentTextBox.sendKeys(Name);
         		CalanderIcon.click();
         		
         		SaveButton.click();
             }
             public void DdatefillIValuesAndSave1(String Name) 
             {
         		
      		Select progname = new Select(ProgramDropDown);
         		progname.selectByIndex(2);
         		Select batchNumber = new Select(BatchDropDown);
         		batchNumber.selectByIndex(2);
         		AssignmentTextBox.sendKeys(Name);
         		
         		
         		SaveButton.click();
             }
             
             public void ANamefillIValuesAndSave1() 
             {
         		
      		Select progname = new Select(ProgramDropDown);
         		progname.selectByIndex(2);
         		Select batchNumber = new Select(BatchDropDown);
         		batchNumber.selectByIndex(2);
         		
         		CalanderIcon.click();
         		
         		SaveButton.click();
             }
         		
         		public void InvalidOptionalField(String name, String s1,String s2, String s3, String s4) 
                {
         			AssignmentTextBox.sendKeys(name);
         		Select progname = new Select(ProgramDropDown);
            		progname.selectByIndex(2);
            		Select batchNumber = new Select(BatchDropDown);
            		batchNumber.selectByIndex(2);
            		
            		CalanderIcon.click();
            		
            		AssignmentDescTextbox.sendKeys(s1);
            		GradeByTextbox.sendKeys(s2);;
            	    AssignmentDescFile1.sendKeys(s3);;
            	    AssignmentDescFile2.sendKeys(s4);;
            		 AssignmentDescFile3.sendKeys(s4);;
            		
            		
            		SaveButton.click();
            		
         		
             }
         		//Delete
         		 
        	    public String alertpopdeletedetails() {
        	    	try {
        	    		 alert = driver.switchTo().alert().getText();		
        	    		
        	    		} catch (Exception e) {
        	    		//exception handling
        	    		}
                 return alert;
        	    }

        	    public void alertpopupayes() {
        	    	
        	    		Alert alert = driver.switchTo().alert(); // switch to alert
        	    		alert.accept();
        	    		

        	    		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        	    		alert.getText();
            	    	if(alert.getText().contains("yes"))
            	    	{
            	    		return;
            	    	}
        	    			
        	    		alert.accept();
        	    	}

        	    public void alertpopupano() {
        	    	
        	    	Alert alert = driver.switchTo().alert(); // switch to alert
        	    	alert.accept();
        	    	alert.getText();
        	    	if(alert.getText().contains("no"))
        	    	{
        	    		return;
        	    	}
        	    	alert.dismiss();
        	    }
        	    
        	    
        	    public void check_first_row()
        	    {
        	    	checkFirstRecord.click();
        	    	
        	    	
        	    }
        	    
        	    public void delete_first_record()
        	    
        	    {
        	    	String ItemDeleted= ItemDelete1.getText();
        	    	DeleteFirstRecord.click();
        	    }
        	    
        	    public void checktopleftfelete()
        	    {
        	    	if(topleftdelete.isEnabled())
        	    	{
        	    		return;
        	    	}
        	    }
        	    
        	    
     
         		
         		 public void verifydelete()
         	    {
         	    	
         	    	
                    boolean isDeleted = deletedAssignmentRow.isDisplayed();
         	    	
                     
         	         if (!isDeleted) {
         	             LoggerLoad.info("Item deletion verification sucess");
         	         } else {
         	             LoggerLoad.info("Item deletion verification failed.");
         	         }

         	    }
         	    
         		 public void multidelete()
         		 {
         			topleftdelete.click();
         			 
         		 }
         	    
         	    public void VerifyMultipleItemsDeletion()
         	    {
         	    	  List<WebElement> itemCheckboxes = driver.findElements(By.xpath("item-checkbox"));
         	    	 for (int i = 0; i < 2; i++) {
                         itemCheckboxes.get(i).click();
                        
                     }

         	    	WebElement deleteButton = driver.findElement(By.id("delete-button"));
                    deleteButton.click();
                    for (int i = 0; i < 2; i++) {
                        
                        boolean itemExists = isElementPresent(driver, By.id("item-" + i)); 
                        if (!itemExists) {
                            System.out.println("Item " + i + " has been successfully deleted.");
                        } else {
                            System.out.println("Item " + i + " was not deleted.");
                        }
                    }
         	    }
         	    
         	   private static boolean isElementPresent(WebDriver driver, By by) {
         	        try {
         	            driver.findElement(by);
         	            return true;
         	        } catch (org.openqa.selenium.NoSuchElementException e) {
         	            return false;
         	        }
         	    }
         	

                
         		
             
             
             
			//Verify Sort Function
			
			public void assignmentname_ascending_sort()
		    {
		    	assignmentnamesortarrow.click();
		    	if (!assignmentnameheader.getAttribute("aria-sort").equals("ascending")) {
		            assignmentnameheader.click();
		            
		        }
		    }
		    public void assignmentname_dscending_sort()
		    {
		    	assignmentnamesortarrow.click();
		    	if (assignmentnameheader.getAttribute("aria-sort").equals("ascending")) {
		            assignmentnameheader.click();
		            
		        }
		    }
		    
		    public boolean datavalidationprgdescasc() {
		    	
		    	List<WebElement> prgdesc=driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
		    	String[] beforesort=new String[prgdesc.size()];
		    	for(int i=0;i<prgdesc.size();i++) {
		    		beforesort[i]=prgdesc.get(i).getText().trim();	
		    	}
		    	for(int i=0;i<prgdesc.size();i++) {
		    		Arrays.sort(beforesort);
		    	}
		    	assignmentnamesortarrow.click();
		    	prgdesc=driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
		    	String[] aftersort=new String[prgdesc.size()];
		    	for(int i=0;i<prgdesc.size();i++) {
		    		aftersort[i]=prgdesc.get(i).getText().trim();	
		    	}
		    	if(beforesort==aftersort) {
		    		return true;
		    	}
		    	else
		    		return false;
		    	
		    }
		    
		    public boolean datavalidationprgdescdesc() {
		    	
		    	List<WebElement> prgdesc=driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
		    	ArrayList<String> beforesort=new ArrayList<>();
		    	for(int i=0;i<prgdesc.size();i++) {
		    	 beforesort.add(prgdesc.get(i).getText().trim());	
		    	}
		    	for(int i=0;i<prgdesc.size();i++) {
		    		Collections.sort(beforesort);
		    		Collections.reverse(beforesort);
		    	}
		    	assignmentnamesortarrow.click();
		    	prgdesc=driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
		    	ArrayList<String> aftersort=new ArrayList<>();
		    	for(int i=0;i<prgdesc.size();i++) {
		    		aftersort.add(prgdesc.get(i).getText().trim());	
		    	}
		    	if(beforesort==aftersort) {
		    		return true;
		    	}
		    	else
		    		return false;
		    	
		    }
			
		    
			//pagination
				    
				    public void firstpagecount()
				    {
				    	
				    	
				            String pageCountText = pageCountElement.getText();
				            int pageCount = Integer.parseInt(pageCountText);
				            if (pageCount == 1) {
				                LoggerLoad.info("The admin in the first page");
				            } 

				    }
			       public void checkrightarrow()
			       
			       {
			    	  // List<WebElement> assignmentElements = driver.findElements((By) assignmentRow);
				    	
				    	//  int assignmentCount = assignmentElements.size();
				    	  if(assignmentCount>5)
				    	  {
			    	   try {
			    	   boolean isRightArrowEnabled = rightArrow.isEnabled();
			       
			    	   
			       if (isRightArrowEnabled) {
			           LoggerLoad.info("Right arrow is enabled on page one when entries are more than 5 available in assignment.");
			       } 
			    	   
			       else {
			           LoggerLoad.info("Right arrow is not enabled on page one when entries are more than 5 available in assignment.");
			       }
			    	   }
			    catch (Exception e) {
			       e.printStackTrace();

			       }}
				    
				    
			       }
			       public void checkleftarrow()
			       {
			    	   try {
			    		   boolean isLeftArrowDisabled = !leftArrow.isEnabled();

			               if (isLeftArrowDisabled) {
			            	   LoggerLoad.info("Left arrow is disabled on page one when entries are more than 5 available in assignment.");
			               }
			           } catch (Exception e) {
			               e.printStackTrace();
			           } 
			       }
			       
			       public void checkRightArrow2Page_Pagination_enable()
			       {
			    	   if(assignmentCount>5)
			    	   {
			    		   rightArrow.click();
			    		   if(assignmentCount>10)
			    		   {
			    			   boolean isRightArrowEnabled = rightArrow.isEnabled();
			    		       
			    	    	   
			    		       if (isRightArrowEnabled) {
			    		           LoggerLoad.info("Right arrow is enabled on 2nd page one when entries are more than 10 available in assignment.");
			    		       } 
			    		    	   
			    		       
			    			   
			    		   }
			    	   }
			       }
			       
			       public void checkleftArrow2Page()
			       {
			    	   if(assignmentCount>5)
			    	   {
			    		   rightArrow.click();
			    		  
			    			   boolean isLefttArrowEnabled = leftArrow.isEnabled();
			    		       
			    	    	   
			    		       if (isLefttArrowEnabled) {
			    		           LoggerLoad.info("Left arrow is enabled on 2nd page one when entries");
			    		       } 
			    		    	   
			    		       
			    			   
			    		   }
			    	   }
			       public void pagination_disable()
			       {
			    	   if(assignmentCount<5)
			    	   {
			    		   
			    		  
			    			   boolean isLefttArrowEnabled = leftArrow.isEnabled();
			    			   boolean isRightArrowEnabled= rightArrow.isEnabled();
			    		       
			    	    	   
			    		       if (!isLefttArrowEnabled) {
			    		           LoggerLoad.info("Left arrow is disabled");
			    		       } 
			    		       
			    		       if (!isRightArrowEnabled) {
			    		           LoggerLoad.info("Right arrow is disabled");
			    		       } 
			    		        
			    		       
			    			   
			    		   }
			       
			       }
			       
			       public void add5Data(String name)
			       {
			    	   for(int i=0; i<7;i++)
			    	   {
			    	   Select progname = new Select(ProgramDropDown);
			      		progname.selectByIndex(0);
			      		Select batchNumber = new Select(BatchDropDown);
			      		batchNumber.selectByIndex(0);
			      		AssignmentTextBox.sendKeys(name);
			      		CalanderIcon.click();
			      		Month.click();
			      		Date.click();
			      		Year.click();
			      		SaveButton.click();
			      		String footerEntry= showingnoofentries.getText();
			      		int value = Integer.parseInt(footerEntry.replaceAll("[^0-9]", ""));
			      		int numofrows = 0;
			   		if(numofrows== value-1) {
			      			System.out.println("Assignment details Successfully added");
			      		}
			    	   }
			       }
			
			
				
			//Navigation Funcation Validation
		    
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
       
       
       


		
