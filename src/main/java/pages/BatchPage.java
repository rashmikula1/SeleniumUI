package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BatchPage {
	public WebDriver driver;
	ProgramPage programPage;
	WebElement search;
	
	public BatchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//BATCH VALIDATION
	@FindBy(xpath="<h1 id = “h1>batchname</h1>")WebElement batchnameheader;
	@FindBy(xpath="<h2 id = “h2>batchdescription</h2>")WebElement batchdescriptionheader ;
	@FindBy(xpath="<h3 id = “h3>batchstatus</h3>")WebElement batchstatusheader ;
	@FindBy(xpath="<h3 id = “h3>batchstatus</h3>")WebElement batchnoofclasses;
	@FindBy(xpath="<h5 id = “h1>programname</h5>")WebElement programnameheader;

	@FindBy(xpath="<h6 id = “h4>edit</h4>")WebElement editheader;
	@FindBy(xpath="<h4 id = “h4>delete</h4>")WebElement deleteheader;
	@FindBy (xpath="//input[@value='AddNewBatch']")WebElement Addnewbatch;
//ADDBATCH
@FindBy(xpath="//input[text='name']")WebElement batchname;
@FindBy(xpath="//input[type='textbox']")WebElement batchnametextbox;
@FindBy(xpath="//input[text='description")WebElement batchdescritpion;
@FindBy(xpath="//input[type='descriptiontextbox")WebElement batchdescritpiontextbox;

@FindBy(xpath="//input[text='noofclasses")WebElement noofclasses;
@FindBy(xpath="//input[type='noofclasses")WebElement noofclassestextbox;

@FindBy(xpath="//select[@class=\"dropdown_marginbelow\"]/option[@value='programname']")WebElement dropdown1;;
@FindBy(xpath="//input[@value='active']") WebElement activeradiobtnstatus;
@FindBy(xpath="//input[@value='inactive']") WebElement inactiveradiobtnstatus;
	
	//DELETE BATCH
@FindBy(xpath="/parent::td//preceding-sibling::td(1)//input[@type=‘deletebutton’]") WebElement deletebtn1;

	
	
	
	
	
	
	//Batchvalidation
	public void batchheadercolumn(String data) {
		switch(data) {
		case "Batch Name": batchnameheader.isDisplayed();break;
		case "BatchDescription": batchdescriptionheader.isDisplayed();break;
		case "Batch Status": batchstatusheader.isDisplayed();break;
		case "No of classes": batchnoofclasses.isDisplayed();break;
		case "Program Name" : programnameheader.isDisplayed();break;
		case "Edit":editheader.isDisplayed();break;
		case "Delete": deleteheader.isDisplayed();}		
	}
	public String appearingaddnewbatch() {
		 String addnewpg=Addnewbatch.getText();
		 return addnewpg;
	 }
	//add program
	public boolean textboxcheckinbatch() {
		
		if(batchname.isDisplayed() && batchnametextbox.isDisplayed()
				&& batchdescritpion.isDisplayed() && batchdescritpiontextbox.isDisplayed()
				&& noofclasses.isDisplayed()&&noofclassestextbox.isDisplayed() ) {
			return true;
		}
		else
			return false;
		}
	public boolean popaddbatchradiobutton() {
		
		if(activeradiobtnstatus.isDisplayed() && inactiveradiobtnstatus.isDisplayed()) {
			return true;
		}
		else
			return false;
		}
	public void batchdropdown() {
		dropdown1.isDisplayed();
			}
	public void entertextbatchname(String name) {
		batchnametextbox.sendKeys(name);
	}
	public void entertextbatchdesc(String desc) {
		batchdescritpiontextbox.sendKeys(desc);
	}
	public void entertextnoofclasses(String num) {
		noofclassestextbox.sendKeys(num);
	}	
	public void clickradiobtnbatchstatusactive() {
		activeradiobtnstatus.click();
		
	}
	public void clickradiobtnbatchstatusinactive() {
		inactiveradiobtnstatus.click();
		
	}
	
	public void selectfromdropdown(String string) {
		Select pgname = new Select(dropdown1);
	  pgname.selectByVisibleText("string");}
	
	
	public boolean validateNewBatch(String BatchName) {
		boolean result = false;
		
		search.sendKeys(BatchName);
		search.sendKeys(Keys.ENTER);
		
		WebElement table = driver.findElement(By.id("items"));
		List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
		for (int i=0; i<=updatedrows.size(); i++) {
			if (updatedrows.get(i).getAttribute("Batch Name") == BatchName) {
				System.out.println("Newly added batch is visible in the datatable.");
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}

	
	
	//EDIT BATCH
	public void cleartextfornoofclassesedit() {
		noofclassestextbox.clear();}
	
public void editenabled() {
   	 boolean isEnabled =driver.findElement(By.xpath("/parent::td//preceding-sibling::td//input[@type=‘editbutton’]")).isEnabled();
	if(isEnabled) {
		System.out.println("Delete button Enabled");
	}else {
		System.out.println("Delete button not Enabled");
	}
		}
public boolean validate_edit_batchName(String Name) {
	boolean result = false;
	
	search.sendKeys(Name);
	search.sendKeys(Keys.ENTER);
	
	WebElement table = driver.findElement(By.id("items"));
	List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
	for (int i=0; i<=updatedrows.size(); i++) {
		if (updatedrows.get(i).getAttribute("batchname") == Name) {
			System.out.println("Newly edited batch is visible in the datatable.");
			result = true;
		} else {
			result = false;
		}
	}
	return result;
}
public boolean validate_edit_batchdesccription(String Batchdescription) {
	boolean result = false;
	
	search.sendKeys(Batchdescription);
	search.sendKeys(Keys.ENTER);
	
	WebElement table = driver.findElement(By.id("items"));
	List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
	for (int i=0; i<=updatedrows.size(); i++) {
		if (updatedrows.get(i).getAttribute("Batchdescription") == Batchdescription) {
			System.out.println("Newly edited Program is visible in the datatable.");
			result = true;
		} else {
			result = false;
		}
	}
	return result;
}



//DELETE BATCH
public void CHECK_delete_ICON() {
	deletebtn1.click();
}
public boolean validatedltBatch(String Name) {
	boolean result = false;
	search.sendKeys(Name);
	search.sendKeys(Keys.ENTER);
	
	WebElement table = driver.findElement(By.id("items"));
	List<WebElement>updatedrows = table.findElements(By.tagName("tr"));
	for (int i=0; i<=updatedrows.size(); i++) {
		if (updatedrows.get(i).getAttribute("Program Name") == Name) {
			System.out.println("Newly deleted batch is visible in the datatable.");
			result = true;
		} else {
			result = false;
		}
	}
	return result;
}
}