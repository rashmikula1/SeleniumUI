package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.DashboardPage;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class DashboardPageStepDefinition {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	DashboardPage dashBoardPage;
	ExcelReader reader;
	public DashboardPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.dashBoardPage=testContextSetup.pageObjectManager.getDashboardPage();
	}
	@Given("Admin user is in login page")
	public void admin_user_is_in_login_page() {
		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Login Page");
		LoggerLoad.info("****Admin user is on login page***");
	}

	@When("Admin user enter valid {} with {}  and clicks login button")
	public void admin_user_enter_valid_with_and_clicks_login_button(String string,String string2,DataTable dataTable) {
		
		
		
		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		dashBoardPage.enterUsernameAndPasswordOnly(username, password);
		dashBoardPage.clickLogin();
	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {
	
		 if (dashBoardPage.isManageProgramHeaderDisplayed()) {
			 LoggerLoad.info("Manage Program header is displayed!");
		    } else {
		    	 LoggerLoad.info("Manage Program header is not displayed.");
		    }
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
		dashBoardPage.navigationTime();
		 LoggerLoad.info("******Max navigation time *********");
		
	}

	 @Then ("HTTP response >={int}.The link boken")
	   public void http_response_the_link_broken() {
		 dashBoardPage.verifyBrokenLink();
		   LoggerLoad.info("**** 400 Dashboard page broken link ***");
	   }
	   

	@Then("Admin should see LMS -Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Dashboard Page");
		LoggerLoad.info("****Admin should land on dashboard page***");
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		// returns true when the title is at the left corner
	    Assert.assertTrue(dashBoardPage.istitleLeftCorner());
	    LoggerLoad.info("****Admin should land on dashboard page***");
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
		dashBoardPage.correctSpelling();
		  LoggerLoad.info("****correct spelling in navigation bar tex***");
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		dashBoardPage.spellSpaceCheck();
		LoggerLoad.info("****correct spelling and space in LMS title***");
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		dashBoardPage.navigationBarRightTopSide();
		LoggerLoad.info("****Navigation Bar top right***");
	}
	
	@Then("Admin should see student in the 1st place {string} and {int}")
	public void admin_should_see_student_in_the_1st_place_and(String Menuname,Integer Position_no ) {
		dashBoardPage.navigationMenu(Menuname, Position_no);
			LoggerLoad.info("****Admin in 1st***");
	}
	

	@Then("Admin should see program in the 2nd place {string} and {int}")
	public void admin_should_see_program_in_the_2nd_place_and(String Menuname,Integer Position_no) {
		dashBoardPage.navigationMenu(Menuname, Position_no);
		LoggerLoad.info("****Admin in 2nd***");
	}

	@Then("Admin should see batch in the 3rd place {string} and {int}")
	public void admin_should_see_batch_in_the_3rd_place_and(String Menuname,Integer Position_no) {
		dashBoardPage.navigationMenu(Menuname, Position_no);
		LoggerLoad.info("****Admin in 3rd***");
	}

	@Then("Admin should see class in the 4th place {string} and {int}")
	public void admin_should_see_class_in_the_4th_place_and(String Menuname,Integer Position_no){
		dashBoardPage.navigationMenu(Menuname, Position_no);
		LoggerLoad.info("****Admin in 4th***");
	}

	@Then("Admin should see student in the  5th user {string} and {int}")
	public void admin_should_see_student_in_the_5th_user(String Menuname,Integer Position_no) {
		dashBoardPage.navigationMenu(Menuname, Position_no);
		LoggerLoad.info("****Admin in 5th***");
	}

	@Then("Admin should see student in the  6th attendance {string} and {int}")
	public void admin_should_see_student_in_the_6th_attendance(String Menuname,Integer Position_no) {
		dashBoardPage.navigationMenu(Menuname, Position_no);
				
		LoggerLoad.info("****Admin in 6th***");
	}

	@Then("Admin should see student in the  7th attendance {string} and {int}")
	public void admin_should_see_student_in_the_7th_attendance(String Menuname,Integer Position_no) {
		dashBoardPage.navigationMenu(Menuname, Position_no);
		LoggerLoad.info("****Admin in 7th***");
	}

	@Then("Admin should see student in the 8th logout {string} and {int}")
	public void admin_should_see_student_in_the_8th_logout(String Menuname,Integer Position_no) {
		dashBoardPage.navigationMenu(Menuname, Position_no);
		LoggerLoad.info("****Admin in 8th***");
	}

	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {
		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Dashboard Page");
		LoggerLoad.info("****Admin is in dashboard page***");
	}

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		dashBoardPage.clickLogout();
	}

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() {
		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Login Page");
		LoggerLoad.info("****Admin should land on login page***");
	}


}
