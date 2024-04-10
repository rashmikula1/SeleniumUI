package pages;

import org.openqa.selenium.WebDriver;

//role :  create objects for each page object and assign driver
public class PageObjectManager {
	public LoginPage loginPage;
	public HomePage homePage;
	public ForgotUsernamePasswordPage forgotUsernamePasswordPage;
	public ResetPasswordPage resetPasswordPage;
	public DashboardPage dashboardPage;
	public StudentPage studentPage;
	public ProgramPage programPage;
	public BatchPage batchPage;
	public ClassPage classPage;
	public UserPage userPage;
	public AssignmentPage assignmentPage;
	public AttendancePage attendancePage;
	
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public LoginPage getLoginPage() {
		loginPage=new LoginPage(driver);
		return loginPage;
	}
	public HomePage getHomePage() {
		homePage=new HomePage(driver);
		return homePage;
	}
	public LoginPage loginPage() {
		loginPage=new LoginPage(driver);
		return loginPage;
	}
	public  ForgotUsernamePasswordPage getforgotUsernamePasswordPage() {
		forgotUsernamePasswordPage=new ForgotUsernamePasswordPage(driver);
		return forgotUsernamePasswordPage;
	}
	public DashboardPage getDashboardPage() {
		dashboardPage= new DashboardPage(driver);
		return dashboardPage;
	}
	public ResetPasswordPage getResetPwdPage() {
		resetPasswordPage= new ResetPasswordPage(driver);
		return resetPasswordPage;
	}
	public StudentPage getStudentPage() {
		studentPage= new StudentPage(driver);
		return studentPage;
	}
	public ProgramPage getProgramPage() {
		programPage= new ProgramPage(driver);
		return programPage;
	}
	public BatchPage getBatchPage() {
		batchPage= new BatchPage(driver);
		return batchPage;
	}
	public ClassPage getClassPage() {
		classPage= new ClassPage(driver);
		return classPage;
	}
	public UserPage getUserPage() {
		userPage= new UserPage(driver);
		return userPage;
	}
	public AssignmentPage getAssignmentPage() {
		assignmentPage= new AssignmentPage(driver);
		return assignmentPage;
	}
	public AttendancePage getAttendancePage() {
		attendancePage= new AttendancePage(driver);
		return attendancePage;
	}

}
