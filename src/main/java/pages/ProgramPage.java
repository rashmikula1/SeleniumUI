package pages;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.TestContextSetup;

public class ProgramPage {
	TestContextSetup testContextSetup;
	public WebDriver driver;
	String alert;
	String editprogramname;
	String editprogramdesc;
	String editprogramstatus;
	boolean check;
	int numofrows;
	String editedprogramstatus;

	 
	//managevalidation
	@FindBy(xpath="//a[text()='program']") WebElement program;
	@FindBy(xpath="//a[text()='student']") WebElement student;
	@FindBy(xpath="//a[text()='batch']") WebElement batch;
	@FindBy(xpath="//a[text()='user']") WebElement user;
	@FindBy(xpath="//a[text()='class']") WebElement classname;
	@FindBy(xpath="//a[text()='Assignment']") WebElement assignment;
	@FindBy(xpath="//a[text()='Attendance']") WebElement attendance;
	@FindBy(xpath="//a[text()='Logout']") WebElement Logout;

    @FindBy(xpath="<label for=\\\"heading\\\">Showing heading?</label>") WebElement heading;
	@FindBy(xpath="<label for=\"showing entries\">Showing x to y of z entries?</label>") WebElement showingnoofentries ;
	@FindBy(xpath="<label for=\"total entries\">Showing z entries?</label>")WebElement totalentries;
	@FindBy (xpath="//input[@value='Delete']")WebElement topleftdelete;
	@FindBy (xpath="//input[@value='AddNewProgram']")WebElement Addnewprogram;
	@FindBy(xpath="//table[@id='users_table']/tbody")WebElement Webtablerows;
	@FindBy(xpath="<h1 id = “h1>programname</h1>")WebElement programnameheader;
	@FindBy(xpath="<h2 id = “h2>programdescription</h2>")WebElement programdescriptionheader ;
	@FindBy(xpath="<h3 id = “h3>programstatus</h3>")WebElement programstatusheader ;
	@FindBy(xpath="<h4 id = “h4>edit</h4>")WebElement editheader;
	@FindBy(xpath="<h4 id = “h4>delete</h4>")WebElement deleteheader;
    @FindBy(id="upsortarrow1")WebElement programnameupsortarrow;
	@FindBy(id="upsortarrow2")WebElement programdescriptionupsortarrow;
	@FindBy(id="upsortarrow3")WebElement programstatusupsortarrow;
	@FindBy(id="downsortarrow1")WebElement programnamedownsortarrow;
	@FindBy(id="downsortarrow2")WebElement programdescriptiondownsortarrow;
	@FindBy(id="downsortarrow3")WebElement programstatusdownsortarrow;

	@FindBy (name="search") WebElement search;
	
	//add program
	@FindBy(name = "name") WebElement entername;
	@FindBy(name = "description") WebElement enterdescription;
	@FindBy(xpath = "//a[text()='save']") WebElement clicksave;
	@FindBy(xpath = "//a[text()='cancel']") WebElement clickcancel;
	@FindBy(xpath="//input[@value='active']") WebElement activeradiobtnstatus;
	@FindBy(xpath="//input[@value='inactive']") WebElement inactiveradiobtnstatus;
	@FindBy(xpath = "//a[text()='save']") WebElement clickclose;
	
	//edit program
	@FindBy(xpath="/parent::td//preceding-sibling::td(1)//input[@type=‘editbutton’]") WebElement editbtn1;
   //delete program
	@FindBy(xpath="/parent::td//preceding-sibling::td(1)//input[@type=‘deletebutton’]") WebElement deletebtn1;
    
	@FindBy(xpath="/parent::td//preceding-sibling::td(1)//input[@type=‘program’]") WebElement firstrecord;
   //multipledelete
	
	@FindBy(xpath="id = “>delete<") WebElement headerdeletebtnmulti;

    
    //sorting validation
    //pagination
	@FindBy(xpath="//input[@class='a-icon a-icon-previous']") WebElement singlepreviousarrow;
	@FindBy(xpath="//input[@class='a-icon a-icon-next']")WebElement singlenextarrow;
	@FindBy(xpath="//input[@class='a_icon a_icon->>next']")WebElement doublenextarrow;
	@FindBy(xpath="//input[@class='a_icon a_icon-<<previous']")WebElement doublepreviousarrow;

	

	public ProgramPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//managevalidation
	public void clicklinkondashboard(String module) {
		
		 switch(module) {
		
		 case "Program" :  program.click();break;
		 case "Student"	: student.click();break;
		 case "Batch"	: batch.click();break;
		 case "Class"	: classname.click();break;
		 case "User"	: user.click();break;
		 case "Assignment"	: assignment.click();break;
		 case "Attendance"	: attendance.click();break;
		 case "Logout" : Logout.click();
		 }
		
	}
	public String appearonheading() {
		String hdng=heading.getText();
		return hdng;
	}
	
	public String appearonpaginationicon() {
		String pagn= showingnoofentries.getText();
		return pagn;
	}
	public String totalentiespaginationicon() {
		String pagn= totalentries.getText();
		return pagn;
	}
 public boolean checkdisableddeleteicon() {
	boolean disableicon= topleftdelete.isEnabled();
	 return false;
 }
 public String appearingaddnewprog() {
	 String addnewpg=Addnewprogram.getText();
	 return addnewpg;
 }
	
public int webtablerows() {
	
	List<WebElement>TotalRowsList =Webtablerows.findElements(By.tagName("tr"));
	//System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
	int Rowcount=TotalRowsList.size();
	return Rowcount ;
}
public void headercolumn(String data) {
	switch(data) {
	case "Program Name": programnameheader.isDisplayed();break;
	case "Program Description": programdescriptionheader.isDisplayed();break;
	case "Program Status": programstatusheader.isDisplayed();break;
	case "Edit":editheader.isDisplayed();break;
	case "Delete": deleteheader.isDisplayed();}		
}
public void sortarrowbutton() {
	 programnameupsortarrow.isDisplayed();
	programdescriptionupsortarrow.isDisplayed();
	 programstatusupsortarrow.isDisplayed();
	 programnamedownsortarrow.isDisplayed();
	 programdescriptiondownsortarrow.isDisplayed();
	programstatusdownsortarrow.isDisplayed();

}
public void checkboxcheck() {
	int checkboxlist =Webtablerows.findElements(By.tagName("tr")).size();
    String beforepath="//*[@id=\"resultTable\"]/tbody/tr[";
    for(int i=1;i<checkboxlist;i++) {
    	driver.findElement(By.xpath("/parent::td//preceding-sibling::td//input[@type=‘checkbox’]")).isDisplayed();	
}
}
public void editcheck() {
	int checkboxlist =Webtablerows.findElements(By.tagName("tr")).size();
	String beforepath="//*[@id=\"resultTable\"]/tbody/tr[";
    for(int i=1;i<checkboxlist;i++) {
    	driver.findElement(By.xpath("/parent::td//preceding-sibling::td//input[@type=‘editbutton’]")).isDisplayed();
    }
}
public void deletecheck() {
	int checkboxlist =Webtablerows.findElements(By.tagName("tr")).size();
	String beforepath="//*[@id=\"resultTable\"]/tbody/tr[";
    for(int i=1;i<checkboxlist;i++) {
    	driver.findElement(By.xpath("/parent::td//preceding-sibling::td//input[@type=‘deletebutton’]")).isDisplayed();
    }
}
public String textsearch() {
	String searchboxtext=search.getText();
	return searchboxtext;
}

public void searchforprogname() {
	
	int rows =Webtablerows.findElements(By.tagName("tr")).size();
	
    for(int i=1;i<rows;i++) {
    	driver.findElement(By.xpath("/parent::td//preceding-sibling::td//input[@type=‘text’]")).isDisplayed();
    }
	
	}
public void searchforprogdescription() {
	
	int rows =Webtablerows.findElements(By.tagName("tr")).size();
	
    for(int i=1;i<rows;i++) {
    	driver.findElement(By.xpath("/parent::td//preceding-sibling::td//input[@type=‘text’]")).isDisplayed();
    }
	
	}
public void searchforprogstatus() {
	
	int rows =Webtablerows.findElements(By.tagName("tr")).size();
	
    for(int i=1;i<rows;i++) {
    	driver.findElement(By.xpath("/parent::td//preceding-sibling::td//input[@type=‘text’]")).isDisplayed();
    }
	}
public boolean searchwithzeroentries() {
	
	int rows =Webtablerows.findElements(By.tagName("tr")).size();
	if(rows==0)
	return true;
	else
		return false;
    }
public void enterinsearch(String data) {
	search.sendKeys(data);
}
public void displayenternameinsearch() {
	search.click();
}
//addprogram

public void clicknewprogram() {
	Addnewprogram.click();	
}
public boolean clickbtnscheckinaddprog() {
	
	if( clicksave.isDisplayed() && clickcancel.isDisplayed()&& clickclose.isDisplayed()) {
		return true;
	}
	else
		return false;
}
	
public boolean textboxcheckinaddprog() {
	
	if(entername.isDisplayed() && enterdescription.isDisplayed()) {
		return true;
	}
	else
		return false;
	}
public boolean popaddprogrmaradiobutton() {
	
	if(activeradiobtnstatus.isDisplayed() && inactiveradiobtnstatus.isDisplayed()) {
		return true;
	}
	else
		return false;
	}
public boolean validateNewProgram(String programName) {
	boolean result = false;
	search.sendKeys(programName);
	search.sendKeys(Keys.ENTER);
	
	WebElement table = driver.findElement(By.id("items"));
	List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
	for (int i=0; i<=updatedrows.size(); i++) {
		if (updatedrows.get(i).getAttribute("Program Name") == programName) {
			System.out.println("Newly added Program is visible in the datatable.");
			result = true;
		} else {
			result = false;
		}
	}
	return result;
}

public void clicksavebtn() {
	clicksave.click();
}
public void clickcancelbtn() {
	clickcancel.click();
}
public void clickclosebtn() {
	clickclose.click();
}
public String alertmsg() {
	return 
	driver.switchTo().alert().getText();
}
public void entertextprogramname(String name) {
	entername.sendKeys(name);
	
}
public void entertextprogramdescription(String description) {
	enterdescription.sendKeys(description);
	
}
	
public void clickradiobtnprogramstatusactive() {
	activeradiobtnstatus.click();
	
}
public void clickradiobtnprogramstatusinactive() {
	editedprogramstatus=inactiveradiobtnstatus.getText();
	inactiveradiobtnstatus.click();
	
}
//edit program
public void clickeditprogram() {
	
	editbtn1.click();
}
public void cleartextfornameedit() {
	entername.clear();
}
public void cleartextfordescriptionedit() {
	enterdescription.clear();
}
public boolean validate_edit_ProgramName(String Name) {
	boolean result = false;
	
	search.sendKeys(Name);
	search.sendKeys(Keys.ENTER);
	
	WebElement table = driver.findElement(By.id("items"));
	List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
	for (int i=0; i<=updatedrows.size(); i++) {
		if (updatedrows.get(i).getAttribute("ProgramName") == Name) {
			System.out.println("Newly edited Program is visible in the datatable.");
			result = true;
		} else {
			result = false;
		}
	}
	return result;
}
public boolean validate_edit_Programdesccription(String ProgramDescription) {
	boolean result = false;
	
	search.sendKeys(ProgramDescription);
	search.sendKeys(Keys.ENTER);
	
	WebElement table = driver.findElement(By.id("items"));
	List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
	for (int i=0; i<=updatedrows.size(); i++) {
		if (updatedrows.get(i).getAttribute("ProgramDescription") == ProgramDescription) {
			System.out.println("Newly edited Program is visible in the datatable.");
			result = true;
		} else {
			result = false;
		}
	}
	return result;
}

public String Programnameforstoring() {
	List<WebElement> storingprogramname = driver.findElements(By.tagName("a"));
	System.out.println(storingprogramname.size());
	for (int i = 0; i < storingprogramname.size(); i++) {
		testContextSetup.listofprogramname = storingprogramname.get(i).getText();
	}
	return testContextSetup.listofprogramname;
}

public boolean validate_editProgram_status() {
	boolean result = false;
	
	search.sendKeys(editedprogramstatus);
	search.sendKeys(Keys.ENTER);
	
	WebElement table = driver.findElement(By.id("items"));
	List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
	for (int i=0; i<=updatedrows.size(); i++) {
		if (updatedrows.get(i).getAttribute("ProgramStatus") == editedprogramstatus) {
			System.out.println("Newly edited Program is visible in the datatable.");
			result = true;
		} else {
			result = false;
		}
	}
	return result;
}

//delete program
public void clickdeleteprogram() {
	String record1=firstrecord.getText();
	deletebtn1.click();
}

public String alertpopdeletedetails() {
	try {
		 String alert = driver.switchTo().alert().getText();		
		
		} catch (Exception e) {
		//exception handling
		}
return alert;
}


public void alertpopupayes() {
	
		Alert alert = driver.switchTo().alert(); 
		alert.accept();
		
		alert.accept();
	}

public void alertpopupano() {
	
	Alert alert = driver.switchTo().alert(); 
	alert.accept();
	
alert.dismiss();
}
public boolean validatedltProgram(String programName) {
	boolean result = false;
	search.sendKeys(programName);
	search.sendKeys(Keys.ENTER);
	
	WebElement table = driver.findElement(By.id("items"));
	List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
	for (int i=0; i<=updatedrows.size(); i++) {
		if (updatedrows.get(i).getAttribute("Program Name") == programName) {
			System.out.println("Newly deleted Program is visible in the datatable.");
			result = true;
		} else {
			result = false;
		}
	}
	return result;
}


//MULTIPLE DELETION
public boolean checkheaderdlticon() {
	if(headerdeletebtnmulti.isEnabled()) {
		return true;
		
	}
	else{
		return false;
	}
	
}
public void click_headerdelete_icon() {
	headerdeletebtnmulti.click();	
}
public void clickAnyCheckbox() {
		for(int i=2;i<=numofrows;i++) {
		WebElement anycheckBox=driver.findElement(By.xpath("//table//tbody//tr[1]//td["+i+"]"));
		anycheckBox.click();
	}
}
public void clickMultipleCheckbox() {
	clickAnyCheckbox();
	clickAnyCheckbox();
}

//sortingvalidation

public void prognameupsortclick() {
	programnameupsortarrow.click();
	

}
public void prognamedownsortclick() {
	programnameupsortarrow.click();
}
public boolean datavalidationpgnameasc() {
	
	List<WebElement> prgdesc=driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
	String[] beforesort=new String[prgdesc.size()];
	for(int i=0;i<prgdesc.size();i++) {
		beforesort[i]=prgdesc.get(i).getText().trim();	
	}
	for(int i=0;i<prgdesc.size();i++) {
		Arrays.sort(beforesort);
	}
	programnameupsortarrow.click();
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

public boolean datavalidationpgnamedesc() {
	
	List<WebElement> prgdesc=driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
	ArrayList<String> beforesort=new ArrayList<>();
	for(int i=0;i<prgdesc.size();i++) {
	 beforesort.add(prgdesc.get(i).getText().trim());	
	}
	for(int i=0;i<prgdesc.size();i++) {
		Collections.sort(beforesort);
		Collections.reverse(beforesort);
	}
	programnamedownsortarrow.click();
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
public void progdescupsortclick() {
	programdescriptionupsortarrow.click();
	

}
public void progndescdownsortclick() {
	programdescriptionupsortarrow.click();
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
	programdescriptionupsortarrow.click();
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
	programdescriptiondownsortarrow.click();
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
public void progstatusupsortclick() {
	programstatusupsortarrow.click();
	

}
public void prognstatusdownsortclick() {
	programstatusupsortarrow.click();
}


public boolean datavalidationprgstatusasc() {
	
	List<WebElement> prgdesc=driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
	String[] beforesort=new String[prgdesc.size()];
	for(int i=0;i<prgdesc.size();i++) {
		beforesort[i]=prgdesc.get(i).getText().trim();	
	}
	for(int i=0;i<prgdesc.size();i++) {
		Arrays.sort(beforesort);
	}
	programstatusupsortarrow.click();
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

public boolean datavalidationprgstatusdesc() {
	
	List<WebElement> prgdesc=driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
	ArrayList<String> beforesort=new ArrayList<>();
	for(int i=0;i<prgdesc.size();i++) {
	 beforesort.add(prgdesc.get(i).getText().trim());	
	}
	for(int i=0;i<prgdesc.size();i++) {
		Collections.sort(beforesort);
		Collections.reverse(beforesort);
	}
	programstatusdownsortarrow.click();
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

//PAGINATION
public void nextpagelink() {
	singlenextarrow.click();	
}
public void nextpagedisplay() {
	List<WebElement> nextPageList = driver.findElements (By.xpath ("//input[@class='a-icon a-icon-next']")); 
	if (nextPageList.size () > 0) 
	{ System.out.println ("Next page rows is present"); 
	} else { System.out.println ("Next page link is not present"); }
	
	}
public void lastpageclick() {
doublenextarrow.click();}

public void lastpagerecord() {
	
WebElement simpleTable = driver.findElement(By.id("items"));
List<WebElement> lastPageRows = simpleTable.findElements(By.tagName("tr"));
if(lastPageRows.size() > 0) {
	System.out.println("Rows are present in Last page");
}else {
	System.out.println("Last page is empty");
}
}

public boolean paginataionsinglerightarrrowdisabled() {
	if (singlenextarrow.isEnabled()){
		return true;	
	}
	
	else {
		return false;
	}
}
public void startpageclick() {
doublepreviousarrow.click();
}
public void firstpageclick() {
	singlenextarrow.click();	
}
public void firstpagerecord() {

WebElement simpleTable = driver.findElement(By.id("items"));
List<WebElement> firstPageRows = simpleTable.findElements(By.tagName("tr"));
if(firstPageRows.size()==5) {
	System.out.println("Rows are present in first page");
}else {
	System.out.println("First page is empty");
}
}
public void startpagerecord() {

WebElement simpleTable = driver.findElement(By.id("items"));
List<WebElement> startPageRows = simpleTable.findElements(By.tagName("tr"));
if(startPageRows.size()== 0) {
	System.out.println("Rows are present in start page");
}else {
	System.out.println("start page is empty");
}
}

public boolean paginataionsingleleftarrrowdisabled() {
	if (singlepreviousarrow.isEnabled()){
		return true;	
	}
	
	else {
		return false;
	}
}







//NAVIGATION

}

