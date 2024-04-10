package pages;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import java.util.Date;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.it.Data;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

//import dspageobjectmodel.Homepage;

public class ClassPage {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	String headername;
	int Classcount;

	String popupactual;
	String popupexpected;

	// Browser-Just checking Purpose
	@FindBy(xpath = "//a[text()='browser']")
	WebElement Browser;
	@FindBy(xpath = "//a[text()='Logheader']")
	WebElement Loginheader;

	// Login
	@FindBy(xpath = "//*[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement Login;

	// Dashboard Navigation
	@FindBy(xpath = "//a[text()='program']")
	WebElement program;
	@FindBy(xpath = "//a[text()='student']")
	WebElement student;
	@FindBy(xpath = "//a[text()='batch']")
	WebElement batch;
	@FindBy(xpath = "//a[text()='user']")
	WebElement user;
	@FindBy(xpath = "//a[text()='class']")
	WebElement classname;
	@FindBy(xpath = "//a[text()='Assignment']")
	WebElement assignment;
	@FindBy(xpath = "//a[text()='Attendance']")
	WebElement attendance;

	// Dashboard Table
	@FindBy(xpath = "<label for=\\\"heading\\\">Showing heading?</label>")
	WebElement heading;

	// ManageClassPage
	@FindBy(xpath = "//a[text()='Class']")
	WebElement ClassModule;
	@FindBy(xpath = "//a[text()='Class']")
	WebElement ClassHeading;

	@FindBy(xpath = "<label for=\"showing entries\">Showing x to y of z entries?</label>")
	WebElement showingnoofentriesClass;
	@FindBy(xpath = "<label for=\"total entries\">Showing z entries?</label>")
	WebElement classwebtableentry;

	@FindBy(xpath = "//input[@value='Delete']")
	WebElement topleftdelete;

	@FindBy(xpath = "//input[@value='AddNewClass']")
	WebElement Addnewprogram;

	@FindBy(xpath = "//table[@id='users_table']/tbody")
	WebElement Webtablerows;

	@FindBy(xpath = "<h1 id = href1>Id</h1>")
	WebElement dropdownBatchId;
	@FindBy(xpath = "<h2 id = href2>no of classes</h2>")
	WebElement Noofclasses;
	@FindBy(xpath = "<h3 id = href3>Date</h3>")
	WebElement ClassDate;
	@FindBy(xpath = "<h3 id = href3>DateRightarrow</h3>")
	WebElement ClassDateRight;
	@FindBy(xpath = "<h3 id = href3>Dateleftarrow</h3>")
	WebElement ClassDateLeft;
	@FindBy(xpath = "<h3 id = href3>HighlightedDate</h3>")
	WebElement ClassDateHighlight;
	@FindBy(xpath = "<h4 id = href4>Topics</h4>")
	WebElement Classtopic;
	@FindBy(xpath = "<h5 id = href4>ID</h5>")
	WebElement StaffId;
	@FindBy(xpath = "<h6 id = href4>dcescrpition</h6>")
	WebElement Classdescrption;
	@FindBy(xpath = "<h7 id = href4>comments</h7>")
	WebElement comments;
	@FindBy(xpath = "<h8 id = href4>Note</h8>")
	WebElement Notes;
	@FindBy(xpath = "<h9 id = href4>Record</h9>")
	WebElement Records;
	@FindBy(xpath = "//input[@value='Missing']")
	WebElement MissingDataMan;
	@FindBy(xpath = "//input[@value='Missing']")
	WebElement MissingData;

	@FindBy(xpath = "//input[@id='cancel']")
	WebElement cancel;
	@FindBy(xpath = "//input[@id='save']")
	WebElement save;
	@FindBy(xpath = "//input[@id='Click']")
	WebElement click;

	@FindBy(id = "sortarrow1")
	WebElement BatchIdsortarrow;
	@FindBy(id = "sortarrow2")
	WebElement Noofclassessortarrow;
	@FindBy(id = "sortarrow3")
	WebElement classdatesortarrow;
	@FindBy(id = "sortarrow4")
	WebElement Classtopicsortarrow;
	@FindBy(id = "sortarrow5")
	WebElement StaffIdsortarrow;
	@FindBy(id = "sortarrow6")
	WebElement Classdescrptionsortarrow;
	@FindBy(id = "sortarrow7")
	WebElement commentssortarrow;
	@FindBy(id = "sortarrow8")
	WebElement Notessortarrow;
	@FindBy(id = "sortarrow9")
	WebElement Recordssortarrow;

	@FindBy(name = "search")
	WebElement searchclass;
	@FindBy(xpath = "//input[@value='Rowdelete']")
	WebElement Rowdelete;
	@FindBy(xpath = "//input[@value='deleteYes']")
	WebElement Yesdelete;
	@FindBy(xpath = "//input[@value='deleteNo']")
	WebElement Nodelete;
	@FindBy(xpath = "//input[@value='delete(1)']")
	WebElement singlecheckbox;
	@FindBy(xpath = "//input[@value='delete(n)']")
	WebElement topdeletebutton;

	@FindBy(xpath = "//input[@value='Edit']")
	WebElement Edit;
	@FindBy(xpath = "//tr[td[contains(text(), '")
	WebElement emptyitem;

	@FindBy(xpath = "//tab[@id='table']/tbody/tr/td[3]")
	WebElement BatchIdupsortarrow;
	@FindBy(xpath = "//tab[@id='table']/tbody/tr/td[4]")
	WebElement BatchIddownsortarrow;

	@FindBy(xpath = "//input[@value='$frright']")
	WebElement classRightarrow;
	@FindBy(xpath = "//input[@value='$frleft']")
	WebElement classLeftarrow;

	public ClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Browser

	public void Browser() {
		Browser.click();
	}

	public void URL() {
		driver.get("https://www.LMS.com/");
	}

	// LoginPage

	public void LoginPagedisplay() {
		boolean isDisplayed = driver.findElement(By.xpath("//input[@value='Login']")).isDisplayed();
		if (isDisplayed) {
			System.out.println(" Login Page Displayed");
		} else {
			System.out.println("Login Page is not Displayed");
		}
	}

	public void Header() {
		Loginheader.click();
	}

	public void LoginUserPass(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
	}

	public void Loginclick() {
		Login.click();
	}

	// DashboardPage

	public void DashboardPagedisplay() {
		boolean isDisplayed = driver.findElement(By.xpath("<label for=\\\"heading\\\">Showing heading?</label>"))
				.isDisplayed();
		if (isDisplayed) {
			System.out.println(" Dashboard Page Displayed");
		} else {
			System.out.println("Dashboard is not Displayed");
		}
	}

	public String appearonheading(String Class) {
		String hdng = heading.getText();
		return hdng;
	}

	// Manage ClassPage

	public void Footerentery() {

		WebElement footer = driver.findElement(By.className("c-foot_Links"));
		List<WebElement> noofentry = footer.findElements(By.tagName("a"));
		int Classcount = noofentry.size();
		System.out.println("The Number of the Entry in the footer is" + Classcount);
	}

	public void footerdisplay() {
		boolean isDisplayed = driver.findElement(By.className("c-foot_Links")).isDisplayed();
		if (isDisplayed) {
			System.out.println("footer button Displayed");
		} else {
			System.out.println("footer button not Displayed");
		}
	}

	public void searchforBacthId() {
		List<WebElement> SearchBatchId = driver.findElements(By.tagName("a"));
		System.out.println(SearchBatchId.size());
		for (int i = 0; i < SearchBatchId.size(); i++) {
			String ListofBatchID = SearchBatchId.get(i).getText();
		}
	}

	public void BatchIddisplay() {
		boolean isDisplayed = driver.findElement(By.tagName("a")).isDisplayed();
		if (isDisplayed) {
			System.out.println("BatchId button Displayed");
		} else {
			System.out.println("BatchId button not Displayed");
		}
	}

	public void searchforNoofClasses() {
		List<WebElement> SearchNoofclass = driver.findElements(By.tagName("a"));
		System.out.println(SearchNoofclass.size());
		for (int i = 0; i < SearchNoofclass.size(); i++) {
			String ListofNoofclass = SearchNoofclass.get(i).getText();
		}
	}

	public void Noofclassdisplay() {
		boolean isDisplayed = driver.findElement(By.tagName("a")).isDisplayed();
		if (isDisplayed) {
			System.out.println("No ofclass button Displayed");
		} else {
			System.out.println("No of class button not Displayed");
		}
	}

	public String ClassTopic() {
		List<WebElement> Searchforclasstopic = driver.findElements(By.tagName("a"));
		System.out.println(Searchforclasstopic.size());
		for (int i = 0; i < Searchforclasstopic.size(); i++) {
			testContextSetup.Listclasstopic = Searchforclasstopic.get(i).getText();
			
		}
		return testContextSetup.Listclasstopic;
	}

	public void ClassTopicdisplay() {
		boolean isDisplayed = driver.findElement(By.tagName("a")).isDisplayed();
		if (isDisplayed) {
			System.out.println("class topic button Displayed");
		} else {
			System.out.println("class topic button not Displayed");
		}
	}

	public void searchStaffId() {
		List<WebElement> SearchforstaffId = driver.findElements(By.tagName("a"));
		System.out.println(SearchforstaffId.size());
		for (int i = 0; i < SearchforstaffId.size(); i++) {
			String ListstaffId = SearchforstaffId.get(i).getText();
		}
	}

	public void StaffIddisplay() {
		boolean isDisplayed = driver.findElement(By.tagName("a")).isDisplayed();
		if (isDisplayed) {
			System.out.println("staffId button Displayed");
		} else {
			System.out.println("staffId button not Displayed");
		}
	}

	public void searchclassDate() {
		List<WebElement> Searchforclassdate = driver.findElements(By.tagName("a"));
		System.out.println(Searchforclassdate.size());
		for (int i = 0; i < Searchforclassdate.size(); i++) {
			String Listclassdate = Searchforclassdate.get(i).getText();
		}
	}

	public void ClassDatedisplay() {
		boolean isDisplayed = driver.findElement(By.tagName("a")).isDisplayed();
		if (isDisplayed) {
			System.out.println("classdate button Displayed");
		} else {
			System.out.println("classdatebutton not Displayed");
		}
	}

	// Add NewClassPage

	public void classmanagepage() {
		ClassModule.click();
	}

	public boolean ClassnavigationTime() {
		long start = System.currentTimeMillis();
		ClassModule.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(ClassHeading));
		long timeToLoad = (System.currentTimeMillis() - start);
		if (timeToLoad < 30)
			return true;
		else
			return false;
	}

	/*
	 * public boolean correctSpelling()
	 * 
	 * { popupactual.add(dropdownBatchId.getText());
	 * popupactual.add(Noofclasses.getText()); popupactual.add(ClassDate.getText());
	 * popupactual.add(Classtopic.getText()); popupactual.add(StaffId.getText());
	 * popupexpected.add("dropdownBatchId"); popupexpected.add("Noofclasses");
	 * popupexpected.add("ClassDate"); popupexpected.add("Classtopic");
	 * popupexpected.add("StaffId"); if (popupactual.equals(popupexpected) == true)
	 * { System.out.println("Spellings are correct"); } return true; }
	 */

	public void Manageclassheading(String Manageclass) {
		String heading = ClassHeading.getText(); // Replace with the heading you want to validate
	}

	public void noofentry() {
		showingnoofentriesClass.click();
	}

	public void Classwebtable() // Seeing Webtable Entries
	{
		classwebtableentry.click();
	}

	public void topleftdelete(String Class) {
		topleftdelete.click();
	}

	public void Addnewprogram() {
		Addnewprogram.click();
	}

	public boolean dropdownBatchID() {
		return false;
	}

	{
		WebElement dr;
		if (dropdownBatchId.isDisplayed()) {
			System.out.println("Dropdown element exists.");
		} else {
			System.out.println("Dropdown element does not exist.");
		}
	}

	public boolean dropdownstaffID() {
		return false;
	}

	{
		WebElement dr;
		if (StaffId.isDisplayed()) {
			System.out.println("Dropdown element exists.");
		} else {
			System.out.println("Dropdown element does not exist.");
		}
	}

	public void Dateformat() {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss z");
		Date date1 = new Date();
		formatDate.setTimeZone(TimeZone.getTimeZone("EST"));
		System.out.println(formatDate.format(date1));
	}

	// Alert Message
	public void alert() {
		JOptionPane.showMessageDialog(null, "ALERT MESSAGE", "Warning:invalid data", JOptionPane.WARNING_MESSAGE);
	}

	public void deletealert() {
		JOptionPane.showMessageDialog(null, "ALERT MESSAGE", "Warning:you are trying to delete class data",
				JOptionPane.WARNING_MESSAGE);
	}

	// Popup AddPagewindow

	public void PopupAddpage(String ClassPageaddpage, String AddNewClass) {
		JOptionPane.showMessageDialog(null, "ClassPageaddPage", "AddNewClass ", JOptionPane.INFORMATION_MESSAGE);
	}

	// Comparing dropdown batchID and Manage classPage batchID

	public void BatchIDcompare() {
		String s1 = "dropdown BatchID";
		String s2 = "ManageClass BatchID";

		System.out.println(s1.equals(s2));// false
		System.out.println(s1.equalsIgnoreCase(s2));// true
	}

	// Alert message
	public void alert(String str) {
		JOptionPane.showMessageDialog(null, str);
	}

	public void Noofclasses() {
		Noofclasses.click();
	}

	public void Date() {
		ClassDate.click();
	}

	public void DateRightclick() {
		ClassDateRight.click();
	}

	public void DateLeftclick() {
		ClassDateLeft.click();
	}

	/*
	 * public void DateHighlight() { ClassDateHighlight.click(); }
	 */
	public void Topic() {
		Classtopic.click();
	}

	public void StaffID() {
		StaffId.click();
	}

	public void ClassDescrption() {
		Classdescrption.click();
	}

	public void comments() {
		comments.click();
	}

	public void Notes() {
		Notes.click();
	}

	public void Records() {
		Records.click();
	}

	public void Rowdelete() {
		Rowdelete.click();
	}

	public void Edit() {
		Edit.click();
	}

	public void cancel() {
		cancel.click();
	}

	public void savebutton() {
		save.click();
	}

	public void Clickable() {
		click.click();
	}

	public void Missingvalue() {
		MissingData.click();
	}

	public void MissingvalueMandatory() {
		MissingDataMan.click();
	}

	// EditPage

	// Popup EditPagewindow

	public void PopupEditpage(String ClassPageEditPage, String EditNewClass) {
		JOptionPane.showMessageDialog(null, "ClassPageEditPage", "EditNewClass ", JOptionPane.INFORMATION_MESSAGE);
	}

	public String textsearch() {
		String searchboxtext = searchclass.getText();
		return searchboxtext;
	}

	public boolean HightlightValidation() {
		return false;
	}

	{
		String textColor = ClassDate.getCssValue("black");
	}

	// Delete button

	public void deletemessage() {

		Rowdelete.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		boolean isItemPresent = isItemPresentInTable(driver, "Item to delete");
		if (!isItemPresent) {
			System.out.println("Item has been successfully deleted.");
		} else {
			System.err.println("Item deletion verification failed.");
		}
	}

	public static boolean isItemPresentInTable(WebDriver driver, String itemName) {

		try {

			driver.findElement(By.xpath("//tr[td[contains(text(), '" + itemName + "')]]"));
			return true; // Item is present
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false; // Item is not present
		}
	}

	public void DeleteYes() {
		Yesdelete.click();
	}

	public void DeleteNo() {
		Nodelete.click();
	}

	// Multiple deletion

	public void clickFirstRowCheckbox() {
		topdeletebutton.click();

	}

	public boolean isHeaderDeleteEnabled() {
		return singlecheckbox.isEnabled();
	}

	public WebElement clickAnyCheckbox() {
		WebElement anycheckBox = null;
		int numofrows = 5;

		for (int i = 2; i <= numofrows; i++) {
			anycheckBox = driver.findElement(By.xpath("//table//tbody//tr[1]//td[" + i + "]"));
			anycheckBox.click();

		}
		return anycheckBox;
	}

	public void deleteenabled() {
		boolean isEnabled = driver.findElement(By.xpath("//input[@value='Rowdelete']")).isEnabled();
		if (isEnabled) {
			System.out.println("Delete button Enabled");
		} else {
			System.out.println("Delete button not Enabled");
		}
	}

	public void SingleCheck() {
		singlecheckbox.click();
	}
	/*
	 * public void MultipleCheckintable() { multiplecheck.click(); }
	 */

	public void clickMultipleCheckbox() {
		clickAnyCheckbox();
		clickAnyCheckbox();
	}

	public void isChecked() {
		topdeletebutton.isSelected();
	}

	public boolean isCheckedMultiple() {
		WebElement ele1 = clickAnyCheckbox();
		WebElement ele2 = clickAnyCheckbox();
		if (ele1.isSelected() && ele2.isSelected()) {
			return true;
		} else
			return false;
	}

	public boolean isAlertPresentHeaderDel() {
		clickAnyCheckbox();
		singlecheckbox.click();
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	public void MultipleCheckintabledisplay() {
		boolean isDisplayed = driver.findElement(By.xpath("//input[@value='delete(n)']")).isDisplayed();
		if (isDisplayed) {
			System.out.println("Delete button Displayed");
		} else {
			System.out.println("Delete button not Displayed");
		}
	}

	// ClassPageSorting

	public void BatchUPclick() {
		BatchIdupsortarrow.click();
	}

	public boolean BatchIdascorder() {

		List<WebElement> batchIdascorder = driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
		String[] beforesort = new String[batchIdascorder.size()];
		for (int i = 0; i < batchIdascorder.size(); i++) {
			beforesort[i] = batchIdascorder.get(i).getText().trim();
		}
		for (int i = 0; i < batchIdascorder.size(); i++) {
			Arrays.sort(beforesort);
		}
		BatchIdupsortarrow.click();
		batchIdascorder = driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
		String[] aftersort = new String[batchIdascorder.size()];
		for (int i = 0; i < batchIdascorder.size(); i++) {
			aftersort[i] = batchIdascorder.get(i).getText().trim();
		}
		if (beforesort == aftersort) {
			return true;
		} else
			return false;

	}

	public void BatchDOWNclick() {
		BatchIddownsortarrow.click();
	}

	public boolean BatchIddescorder() {

		List<WebElement> batchIddesc = driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[4]"));
		ArrayList<String> beforesort = new ArrayList<>();
		for (int i = 0; i < batchIddesc.size(); i++) {
			beforesort.add(batchIddesc.get(i).getText().trim());
		}
		for (int i = 0; i < batchIddesc.size(); i++) {
			Collections.sort(beforesort);
			Collections.reverse(beforesort);
		}
		BatchIddownsortarrow.click();
		batchIddesc = driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[4]"));
		ArrayList<String> aftersort = new ArrayList<>();
		for (int i = 0; i < batchIddesc.size(); i++) {
			aftersort.add(batchIddesc.get(i).getText().trim());
		}
		if (beforesort == aftersort) {
			return true;
		} else
			return false;

	}

	// Pagination

	public void classpageRightarrow() {
		classRightarrow.click();
	}

	public void classpageLeftarrow() {
		classLeftarrow.click();
	}

	public void firstpagecount() {

		WebElement footer = driver.findElement(By.className("c-foot_Links"));
		List<WebElement> noofentry = footer.findElements(By.tagName("a"));
		int Classcount = noofentry.size();
		System.out.println("The Number of the Entry in the footer is" + Classcount);
	}

	/*
	 * public void CheckClassPageRightarrow() { boolean isEnabled
	 * =driver.findElement(By.xpath("//input[@value='$frright']")).isEnabled();
	 * if(isEnabled) { System.out.println("Delete button Enabled"); }else {
	 * System.out.println("Delete button not Enabled"); } }
	 * 
	 * public void CheckClassPageLeftarrow() { boolean isEnabled
	 * =driver.findElement(By.xpath("//input[@value='$frleft']")).isEnabled();
	 * if(isEnabled) { System.out.println("Delete button Enabled"); }else {
	 * System.out.println("Delete button not Enabled"); } }
	 */

	public void checkrightarrow()

	{
		if (Classcount > 5) {
			try {
				boolean isRightArrowEnabled = classRightarrow.isEnabled();

				if (isRightArrowEnabled) {
					LoggerLoad.info(
							"Right arrow is enabled on page one when entries are more than 5 available in class.");
				}

				else {
					LoggerLoad.info(
							"Right arrow is not enabled on page one when entries are more than 5 available in class.");
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

	public void checkleftarrow() {
		try {
			boolean isLeftArrowDisabled = !classLeftarrow.isEnabled();

			if (isLeftArrowDisabled) {
				LoggerLoad.info("Left arrow is disabled on page one when entries are more than 5 available in Class");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkRightArrow2Page_Pagination_enable() {
		if (Classcount > 5) {
			classRightarrow.click();
			if (Classcount > 10) {
				boolean isRightArrowEnabled = classRightarrow.isEnabled();

				if (isRightArrowEnabled) {
					LoggerLoad.info(
							"Right arrow is enabled on 2nd page one when entries are more than 10 available in class.");
				}
			}
		}
	}

	public void checkLeftArrow2Page_Pagination_enable() {
		if (Classcount > 5) {
			classRightarrow.click();
			if (Classcount > 10) {
				boolean isRightArrowEnabled = classRightarrow.isEnabled();

				if (isRightArrowEnabled) {
					LoggerLoad.info(
							"Left arrow is enabled on 2nd page one when entries are more than 10 available in class.");
				}
			}
		}
	}

	public void pagination_disable() {
		if (Classcount < 5) {

			boolean isLefttArrowEnabled = classLeftarrow.isEnabled();
			boolean isRightArrowEnabled = classRightarrow.isEnabled();

			if (!isLefttArrowEnabled) {
				LoggerLoad.info("Left arrow is disabled");
			}

			if (!isRightArrowEnabled) {
				LoggerLoad.info("Right arrow is disabled");
			}

		}

	}

	// Navigation Page
	public void clicklinkondashboard(String module) {

		switch (module) {

		case "Program":
			program.click();
			break;
		case "Student":
			student.click();
			break;
		case "Batch":
			batch.click();
			break;
		case "Class":
			classname.click();
			break;
		case "User":
			user.click();
			break;
		case "Assignment":
			assignment.click();
			break;
		case "Attendance":
			attendance.click();
			break;

		}

	}

	public void datePicker() {

		WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));

		selectDate.click();
	}

	public void nextmonth() {

		String dateTime = "13/09/2023 2:00 PM";

		WebElement nextLink = driver.findElement(By.xpath(
				"//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
		String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");

		// int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])-
		// Calendar.getInstance().get(Calendar.YEAR);
		int monthdiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.MONTH);

		if (monthdiff != 0) {

			if (monthdiff > 0) {

				for (int i = 0; i < monthdiff; i++) {

					System.out.println("monthdiff->" + i);

					nextLink.click();

				}
			}
		}

	}

	public void previousmonth() {

		String dateTime = "13/09/2023 2:00 PM";
		WebElement previousLink = driver.findElement(By.xpath(
				"//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]"));

		String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");

		// int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])-
		// Calendar.getInstance().get(Calendar.YEAR);
		int monthDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.MONTH);

		if (monthDiff < 0) {

			for (int i = 0; i < (monthDiff * (-1)); i++) {

				System.out.println("monthDiff->" + i);

				previousLink.click();

			}

		}
	}

	public void futuredate() {

		String dateTime = "13/09/2023 2:00 PM";

		WebElement nextdateLink = driver.findElement(By.xpath(
				"//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
		String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");

		// int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])-
		// Calendar.getInstance().get(Calendar.YEAR);
		int daydiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.DATE);

		if (daydiff != 0) {

			if (daydiff > 0) {

				for (int i = 0; i < daydiff; i++) {

					System.out.println("daydiff->" + i);

					nextdateLink.click();

				}
			}
		}

	}

}