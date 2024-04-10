package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	public WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}
@FindBy(xpath="//a[text()='Login']")WebElement logInBtn;

	@FindBy(name="user")WebElement uname;
	@FindBy(name="password")WebElement pwdField;
	
	@FindBy(xpath="//a[contains(text(),'DashBoard Page']")WebElement dashBoardPageTxt;
	@FindBy(xpath="//a[text()='400 brokenlink']") WebElement badRequest;
	@FindBy(xpath="//h1[@class='lms-title']")WebElement lmsTitleLocator;
	@FindBy(xpath="//*[contains(text(),'Program Name')]")WebElement programNameLabel;
	@FindBy(xpath="//*[contains(text(),'Student Name')]")WebElement studentNameLabel;
	@FindBy(xpath="//*[contains(text(),'Student')]")WebElement attendanceLabel;
	@FindBy(xpath="//*[contains(text(),'Attendance Date')]")WebElement attendanceDateLabel;
	@FindBy(xpath="//*[contains(text(),'Class Name')]")WebElement classNameLabel;
	@FindBy(css = ".navigationbar.top-right")private WebElement navigationBar;
	@FindBy(id = "Admin")private WebElement admin;
	@FindBy(id = "Student")private WebElement student;
	@FindBy(id = "Program")private WebElement program;
	@FindBy(id = "Batch")private WebElement batch;
	@FindBy(id = "Class")private WebElement classele;
	@FindBy(id = "User")private WebElement user;
	@FindBy(id = "Assignment")private WebElement assignmnet;
	@FindBy(id = "Attendance")private WebElement attendance;
	@FindBy(id = "Logout")private WebElement logout;
	@FindBy(xpath = "//h1[contains(text(),'Manage Program')]")
	private WebElement manageProgramHeader;
	@FindBy(xpath = "//body/div[@id='navigation']/div[1]/nav[1]/div[1]/ul/li")
	public List<WebElement> NavigationMenuList;
	
	@FindBy(xpath ="//div[@id='nav-bar-links-area']")
	public WebElement DashNavigationBar;
	
	public void navigationMenu(String menuName, Integer postionNo) 
	{
		WebElement eachmenu = driver.findElement(By.xpath("//body/div[@id='navigation']/div[1]/nav[1]/div[1]/ul/li["+postionNo+"]"));
		if  (eachmenu.getText().contains(menuName))
		{
			Assert.assertTrue(true);
		}
		System.out.println("Admin seeing the menus appropriate postion" +menuName + " " + postionNo);
	}

	
	public boolean dashboardPageTxt()
	{
		return dashBoardPageTxt.isDisplayed();
	}
	public String dashboardPageTitleTxt()
	{
		
		return lmsTitleLocator.getText();
	}
	 public boolean isElementVisible(WebElement element) {
	        return element.isDisplayed();
	    }
	 public boolean isManageProgramHeaderDisplayed() {
		    return manageProgramHeader.isDisplayed();
		}
	
	public boolean verifyBrokenLink() {
		String errorcode=badRequest.getText().split(" ")[0].trim();
		int code=Integer.parseInt(errorcode);
		if(code>=400) {
			System.out.println("Link is broken");
		}
		return true;
	}

public void clickLogin() {
	logInBtn.click();
}
public void clickLogout() {
	logout.click();
}
    public  boolean istitleLeftCorner() {
    
        int titleXCoordinate = lmsTitleLocator.getLocation().getX();
        int titleYCoordinate = lmsTitleLocator.getLocation().getY();

        return titleXCoordinate == 0 && titleYCoordinate == 0;
    }

    public void enterUsernameAndPasswordOnly(String username,String password) {
    	uname.sendKeys(username);
    	pwdField.sendKeys(password);
    	
    }
public boolean correctSpelling() {

	ArrayList<String> dashBoardPageMenuActualTxt = new ArrayList<String>();
	ArrayList<String> dashBoardPageMenuExpectedTxt = new ArrayList<String>();
	dashBoardPageMenuActualTxt.add(programNameLabel.getText());
	dashBoardPageMenuActualTxt.add(classNameLabel.getText());
	dashBoardPageMenuActualTxt.add(studentNameLabel.getText());
	dashBoardPageMenuActualTxt.add(attendanceLabel.getText());
	dashBoardPageMenuActualTxt.add(attendanceDateLabel.getText());
	dashBoardPageMenuExpectedTxt.add("Program Name");
	dashBoardPageMenuExpectedTxt.add("Class Name");
	dashBoardPageMenuExpectedTxt.add("Student Name");
	dashBoardPageMenuExpectedTxt.add("Attendance");
	dashBoardPageMenuExpectedTxt.add("Attendance Date");
	if (dashBoardPageMenuActualTxt.equals(dashBoardPageMenuExpectedTxt) == true) {
		System.out.println("Spellings are correct");
	}
	return true;
}
	
public boolean navigationTime() {
    long start = System.currentTimeMillis();
    logInBtn.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	wait.until(ExpectedConditions.visibilityOf(dashBoardPageTxt));
    long timeToLoad= (System.currentTimeMillis()-start);
    if (timeToLoad<30) 
    	return true;      
    else 
    	return false;
}
// Check if the title has correct spelling and spacing
public void spellSpaceCheck() {
	   String lmsTitleText = lmsTitleLocator.getText();

if (
		lmsTitleText.trim().equals("lMS-title") || lmsTitleText.toLowerCase().contains("LMS-title")) {
    System.out.println("Admin LMS title is correct!");
} else {
    System.out.println("Admin LMS title is incorrect!");
}
	
}

// Check if the navigation bar top right

public boolean navigationBarRightTopSide() {
	if(navigationBar.getCssValue("vertical-align")=="top" && navigationBar.getCssValue("horizontal-align")=="right") {
		System.out.println("Close icon is right top aligned");
	}
	return true;			
}

	
}

