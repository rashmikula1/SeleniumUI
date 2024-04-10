package pages;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage {
public WebDriver driver;
int numofrows;
WebElement anycheckBox;
	
	public UserPage(WebDriver driver) {
		this.driver=driver;
	}
	final int rowsCount = 0;

    String headername;
   
		// 1. User page validation
		
		@FindBy(xpath="//*[@id='dashboarheading']") WebElement Dashboard;
		@FindBy(xpath="//a[text()='User']") WebElement ManageUser;
		@FindBy(xpath="//*@id='pagination-controls']") WebElement paginationControls;
		@FindBy(xpath="//*@id='datatable']") WebElement dataTable;
		@FindBy(xpath="//*@id='datatable/header']") WebElement DTHeader;
		@FindBy(xpath="//*@id='deletebutton']") WebElement deleteButton;
		@FindBy(xpath="//*@id='addnewuserbutton']") WebElement addNewUserButton;
		@FindBy(xpath="//*@id='addassignstaffbutton']") WebElement addAssignStaffButton;
		@FindBy(xpath="//*@id='search']") WebElement search;
		@FindBy(xpath="//*@id='checkbox']") WebElement checkbox;
		@FindBy(xpath="//*@id='checkbox']") WebElement editbutton;
		@FindBy(xpath="//*@id='delete']") WebElement deletebutton;
		int rcount=driver.findElements(By.id("datatable.rows")).size();
		@FindBy(xpath="//*@id='addnewuserpopup']") WebElement addnewuserpopup;
		@FindBy(xpath="<h24 id = Manager User Header")WebElement ManageUserHeader;
		
		
		//2. Add and Edit
		
		 // Dashboard Table
	     @FindBy(xpath = "<label for=\\\"heading\\\">Showing heading?</label>")WebElement heading;
	     @FindBy(xpath="<h3 id = Delete button")WebElement TopRowDeletebutton ;
	 	 @FindBy(xpath="<h4 id = Checkbox1")WebElement Checkbox;
	 	 @FindBy(xpath="<h9 id = Editbutton1")WebElement Editbutton;
	 	 @FindBy(xpath="<h11 id = Deletebutton1")WebElement Deletebutton;
		@FindBy(xpath="<h1 id = 'Search'") WebElement SearchOption ;
		
	    @FindBy(xpath="<h1 id = '+  Add New User'")WebElement Addnewuser;
		@FindBy(xpath="<h2 id = '+ Assign Staff' ")WebElement Assignstaff ;
		
		
		//@FindBy(xpath="<h5 id = Checkbox2")WebElement Checkbox2 ;
		
		@FindBy(xpath="<h6 id = Name.Sort")WebElement NameSort;
		@FindBy(xpath="<h7 id = Location.Sort")WebElement LocationSort;
		@FindBy(xpath="<h8 id = PhoneNumber.Sort")WebElement PhoneNumberSort;
		
		//@FindBy(xpath="<h9 id = Editbutton1")WebElement Editbutton;
		//@FindBy(xpath="<h10 id = Editbutton2")WebElement Editbutton2;
		
		//@FindBy(xpath="<h11 id = Deletebutton1")WebElement Deletebutton;
		//@FindBy(xpath="<h12 id = Deletebutton2")WebElement Deletebutton2;
		
		@FindBy(xpath="<h13 id = Pagination")WebElement Pagination;
		@FindBy(xpath="<h14 id = Pop Up")WebElement Popup;
		
		@FindBy(xpath="<h15 id = First name")WebElement FirstName;
		@FindBy(xpath="<h16 id = Middle Name ")WebElement Middlename ;
		@FindBy(xpath="<h17 id = Last Name")WebElement LastName;
		@FindBy(xpath="<h18 id = Location")WebElement Location ;
		@FindBy(xpath="<h19 id = Phone ")WebElement Phone ;
		@FindBy(xpath="<h20 id = Email ")WebElement Email;
		@FindBy(xpath="<h21 id = Linkedin URL")WebElement LinkedIn;
		@FindBy(xpath="<h19 id = Post Graduate ")WebElement PostGraduate ;
		@FindBy(xpath="<h20 id = Time Zone ")WebElement Timezone;
		@FindBy(xpath="<h21 id = User Comment")WebElement Usercomment;
		@FindBy(xpath="<h38 id = UserRole")WebElement UserRole;
		@FindBy(xpath="<h39 id = Visa Status")WebElement VisaStatus;
		
		@FindBy(xpath="<h22 id = Submit")WebElement Submit;
		
		
		@FindBy(xpath="<h23 id = Cancel")WebElement Cancel;
		@FindBy(xpath="<h25 id = Manager User Table")WebElement ManageUserTable;
		@FindBy(xpath="<h26 id = New User Added")WebElement NewUserAdded;
		@FindBy(xpath="<h27 id = Editbutton3")WebElement Editbutton3;
		@FindBy(xpath="<h28 id = Description")WebElement Description;
		@FindBy(xpath="<h29 id = Yes Option")WebElement Yes;
		@FindBy(xpath="<h30 id = No Option")WebElement No;
		@FindBy(xpath="<h31 id = Row deleted")WebElement RowDeleted;
		@FindBy(xpath="<h32 id = Delete 3")WebElement DeleteButton3;
		@FindBy(xpath="<h33 id = Row to be deleted1")WebElement Rowtodelete;
		@FindBy(xpath="<h34 id = Row to be deleted2")WebElement Rowtodelete2;
		@FindBy(xpath="<h35 id = Navigation Bar")WebElement NavigationBar;
		@FindBy(xpath="<h36 id = User Button")WebElement Userbutton;
		@FindBy(xpath="<h37 id = Error Message")WebElement Error;
		
		
		@FindBy(xpath="<h40 id = Edit Button")WebElement EditButton4;
		@FindBy(xpath="<h41 id = Summit Button")WebElement SummitButton1;
		@FindBy(xpath="<h42 id = Update User Detail")WebElement UpdateUserDetail;
		@FindBy(xpath="<h43 id = Delete Enable")WebElement DeleteEnable;
		@FindBy(xpath="<h44 id = String Btn")WebElement StringButton;
		
	//4. Delete User
	@FindBy(xpath="<h11 id = Deletebutton1")WebElement rowlevelDelbutton;
	@FindBy(id="user1") WebElement deletedUserRow;
	@FindBy (xpath="//*[starts-with(@id,'In total there')]") WebElement footerText;
	@FindBy (xpath="//*[@id='user']/tbody/tr ") WebElement tableRows;
	
	// 5. Delete Multiple User
	@FindBy(xpath="//h1[text()='Manage Program']") WebElement dashboardPageHeader;
	@FindBy(linkText="User") WebElement userModuleLink;
	@FindBy(xpath="//h1[text()='Manage User']") WebElement userPageHeader;
	@FindBy(xpath="id = “>delete<") WebElement headerdeletebtnmulti;
	
	//1. User Page Validation
	

	public void dashboard()
	{
		String DHeading=Dashboard.getText();
		if(DHeading.contains("Dashboard Page"))
		{
			return;
		}
		
	}
	
	public void ManageUser() {
	 ManageUser.click();
	 
	}
	 
	public void VerifyManageUserurl() {
	String userurl= driver.getCurrentUrl();
	
		 if (userurl.contains("User")) {
	            System.out.println("Admin sees 'Manage User' in the URL.");
	        } else {
	            System.out.println("Admin does not see 'Manage User' in the URL.");
	        }
	 }
	 
	public void VerifyManageUserHeading()
	{
	String ManageUserHeading= ManageUserHeader.getText();
	 if (ManageUserHeading.contains("Manage User Page")) {
            System.out.println("Admin sees 'Manage User Page' on the header.");
        } else {
            System.out.println("Admin sees 'Manage User Page' on the header.");
        }
	
		}
	public void VerifyPaginationControl()
	{
	if (paginationControls.isDisplayed()) {
        System.out.println("Pagination controls are displayed.");
    } else {
        System.out.println("Pagination controls are not displayed.");
    }
	}

	public void Verify_DataTabele_Header()
	{
	 if (DTHeader.isDisplayed()) {
         System.out.println("Data table with headers is displayed.");
     } else {
         System.out.println("Data table with headers is not displayed.");
     }
	}

	public void Verify_delete_button()
	{
	if (deleteButton.isDisplayed() && !deleteButton.isEnabled()) {
        System.out.println("Delete icon button is displayed and disabled.");
    } else {
        System.out.println("Delete icon button is not displayed or not disabled.");
    }
	}

	public void Verify_add_new_user_button()
	{
	 if (addNewUserButton.isDisplayed()) {
         System.out.println("+ A New User button is displayed.");
     } else {
         System.out.println("+ A New User button is not displayed.");
     }
	}

	public void Verify_add_assign_staff_button()
	{
	 if (addAssignStaffButton.isDisplayed()) {
         System.out.println("+ Assign Staff button is displayed.");
     } else {
         System.out.println("+ Assign Staff button is not displayed.");
     }
	}

	public void Verify_Search_box()
	{
	 if (search.isDisplayed()) {
         System.out.println("search box is displayed.");
     } else {
         System.out.println("+ search box is not displayed.");
     }
	}




	public void Verify_CheckBox()
	{
	
	for(int i=1; i<=rcount; i++)
	{
		if(checkbox.isDisplayed())
		{
			 return;
        } 
           			
	}
}

	public void Verify_Edit()
	{
	
	for(int i=1; i<=rcount; i++)
	{
		if(editbutton.isEnabled())
		{
			System.out.println("Edit icon is enabled.");
        } 
           
		else
		{
			System.out.println("Edit icon is disabled.");
		}
			
	}
	}

	public void Verify_Delete()
	{
	
	for(int i=1; i<=rcount; i++)
	{
		if(deletebutton.isEnabled())
		{
			System.out.println("Delete button is enabled.");
        } 
           
		else
		{
			System.out.println("Delete button is disabled.");
		}
			
	}
}

	public void click_AddNewUSer()
	{
	addNewUserButton.click();
	}

	public void verifyaddnewuserpopup()
	{
	if(addnewuserpopup.isDisplayed())
	{
		System.out.println("Add new user pop up is displayed");
    } 
       
	else
	{
		System.out.println("Add new user pop up is not displayed");
	}
		
	}



    //Add New UserPage
 //*******************//
	
	public void Dashboard() {
		heading.click();
}
	

	public void Addnewuser()
   {
  	 Addnewuser.click();

   }
	// Popup AddPagewindow
	
     	public void PopupAddpage(String UserPageaddPage, String AddNewUser) {
			JOptionPane.showMessageDialog(null, "UserPageaddPage", "AddNewUser ", JOptionPane.INFORMATION_MESSAGE);
		}
     	
       public void alertpopupappear() {
     		
     		Alert alert = driver.switchTo().alert(); 
     		alert.accept();
     		
     	alert.dismiss();
     	}
     	
     	public void submit() 
	     {
	    	 	
			 Submit.click();
	        }   
     	public void search() 
   	
  	 {
  		SearchOption.click(); 
  	 }

     	public boolean validateNewUser(String ID) {
     		boolean result = false;
     		SearchOption.sendKeys(ID);
     		SearchOption.sendKeys(Keys.ENTER);
     		
     		WebElement table = driver.findElement(By.id("items"));
     		List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
     		for (int i=0; i<=updatedrows.size(); i++) {
     			if (updatedrows.get(i).getAttribute("ID") == ID) {
     				System.out.println("Newly added User is visible in the datatable.");
     				result = true;
     			} else {
     				result = false;
     			}
     		}
     		return result;
     	}
     	
     	public void FirstName() 
   	
     	 {
     		FirstName.sendKeys("firstname");
        }
     	public void Middlename() 
   	
    	 {
     		Middlename.sendKeys("Middlename");
    	 }
     	public void LastName() 
   	
   	 {
     		LastName.sendKeys("LastName");
   	 }
     	public void Location() 
   	
   	 {
     		Location.sendKeys("Location");
   	 }
     	public void Phone() 
   	
   	 {
     		Phone.sendKeys("Phone");
   	 }
     	public void Email() 
   	
   	 {
     		Email.sendKeys("Email");
   	 }
     	public void LinkedIn() 
   	
   	 {
     		LinkedIn.sendKeys("LinkedIn");
   	 }
     	public void PostGraduate() 
   	
   	 {
     		PostGraduate.sendKeys("PostGraduate");
   	 }public void Timezone() 
   	
    	 {
   		 Timezone.sendKeys("Timezone");
    	 }
   	 public void Usercomment() 
    	
    	 {
   		 Usercomment.sendKeys("Usercomment");
    	 }
   	 public void UserRole() 
     	
    	 {
   		 UserRole.sendKeys("UserRole");
    	 }
   	 public void VisaStatus() 
      	
    	 {
   		 VisaStatus.sendKeys("VisaStatus");
    	 }
     	
   	 public void Invaliderrormessage() {
   			JOptionPane.showMessageDialog(null, "Error MESSAGE", "Warning:you are entering invalid data",
   					JOptionPane.WARNING_MESSAGE);
   		}

   	 public void MissingvalueMandatory() {
   		 boolean isDisplayed = driver.findElement(By.tagName("a")).isDisplayed();
   			if (isDisplayed) {
   				System.out.println("Mandatory value Displayed");
   			} else {
   				System.out.println("Mandatory value not Displayed");
   			}
   		}
   	 
   	//-----------------AddPage-------------//
   	
   	//Edit User
  //**********************//
   	 
   	 public void Editbutton() 
       	
    	 {
   		 Editbutton.click();
    	 }
   	 
   	 public void ValidatingEditbuttonRowlevel() {
   		 boolean isEnabled = driver.findElement(By.tagName("a")).isEnabled();
   			if (isEnabled) {
   				System.out.println("Editbutton Displayed");
   			} else {
   				System.out.println("Editbutton is not Displayed");
   			}
   		}
   	// Popup AddPagewindow
   		
      	public void PopupEditpage(String UserPageEditPage, String EditNewUser) {
			JOptionPane.showMessageDialog(null, "UserPageEditdPage", "editNewUser ", JOptionPane.INFORMATION_MESSAGE);
		}
   	 //Edit validation of UserID
      	public boolean validate_edit_ID(String ID) {
      		boolean result = false;
      		
      		SearchOption.sendKeys(ID);
      		SearchOption.sendKeys(Keys.ENTER);
      		
      		WebElement table = driver.findElement(By.id("items"));
      		List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
      		for (int i=0; i<=updatedrows.size(); i++) {
      			if (updatedrows.get(i).getAttribute("UserID") == ID) {
      				System.out.println("Newly edited User is visible in the datatable.");
      				result = true;
      			} else {
      				result = false;
      			}
      		}
      		return result;
      	}
       //Edit validation of UserName
      	public boolean validate_edit_Name(String Name) {
      		boolean result = false;
      		
      		SearchOption.sendKeys(Name);
      		SearchOption.sendKeys(Keys.ENTER);
      		
      		WebElement table = driver.findElement(By.id("items"));
      		List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
      		for (int i=0; i<=updatedrows.size(); i++) {
      			if (updatedrows.get(i).getAttribute("UserName") == Name) {
      				System.out.println("Newly edited User is visible in the datatable.");
      				result = true;
      			} else {
      				result = false;
      			}
      		}
      		return result;
      	}
      	
      	public void  ValidationofUpdateUserDetails() {
      	 boolean isDisplayed = driver.findElement(By.tagName("a")).isDisplayed();
			if (isDisplayed) {
				System.out.println(" UpdateUserDetails Displayed");
			} else {
				System.out.println(" UpdateUserDetails not Displayed");
			}
	     }
      	
      	public String alertmsg() {
      		return 
      		driver.switchTo().alert().getText();
      	}
	
	
	// 4. Delete User
	
	public void clickDeleteButton() {
		rowlevelDelbutton.click();
	}
	
	public void isDeleteEnabled() {
		rowlevelDelbutton.isEnabled();
	}
	public boolean  verifydelete()
	{
	boolean isDeleted = deletedUserRow.isDisplayed();
     if (!isDeleted) {
    	 System.out.println("Item deletion verification sucess");
    	 return true;
    
     } else {
    	 System.out.println("Item deletion verification failed.");
    	 return false;
     }

}
	public boolean verifyFooterEntries() {
		String footerEntry= footerText.getText();
		if(footerEntry.matches("In total there are"+numofrows +"Users")) {
			return true;
			
		}else return false;
	} 
	
	public void totalRows() {
		numofrows =tableRows.findElements(By.tagName("tr")).size();
	}
	
	// 5. Delete Multiple User
	
	public boolean verifyDashboard() {
		return dashboardPageHeader.isDisplayed();
	}
	public void clickUser() {
		userModuleLink.click();
	}
	public boolean verifyManageUser() {
		return userPageHeader.isDisplayed();
	}
	public boolean isHeaderDelDisabled() {
		if(!headerdeletebtnmulti.isEnabled()) {
			return true;
		}
		else return false;
	}
	
	public WebElement clickAnyCheckbox() {
		for(int i=2;i<=numofrows;i++) {
			anycheckBox=driver.findElement(By.xpath("//table//tbody//tr[1]//td["+i+"]"));
			anycheckBox.click();
			
		}
		return anycheckBox;
	}
	
	public boolean noCheckboxSelected() {
		for(int i=2;i<=numofrows;i++) {
			anycheckBox=driver.findElement(By.xpath("//table//tbody//tr[1]//td["+i+"]"));
			boolean checked=anycheckBox.isSelected();
				if(checked==true) {
					return false;
				}
				else return true;		
		}
		
		return true;
	}
	
	public void clickMultipleCheckbox() {
		clickAnyCheckbox();
		clickAnyCheckbox();
	}
	
	public void clickHeaderDelete() {
		headerdeletebtnmulti.click();
	}
	
	public boolean validatedltProgram(String userName) {
		boolean result = false;
		search.sendKeys(userName);
		search.sendKeys(Keys.ENTER);
		
		WebElement table = driver.findElement(By.id("items"));
		List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
		for (int i=0; i<=updatedrows.size(); i++) {
			if (updatedrows.get(i).getAttribute("User Name") == userName) {
				System.out.println("Newly deleted User is visible in the datatable.");
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}

}
