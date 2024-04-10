package stepdefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.BatchPage;
import pages.StudentPage;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class StudentPageStepDefinition {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	StudentPage studentPage;
	public int statuscode;
	BatchPage batchPage;
	public HttpURLConnection httpURLConnection;
	public StudentPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.studentPage=testContextSetup.pageObjectManager.getStudentPage();
	}
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Student Page");
		LoggerLoad.info("****Admin is in Student  page***");
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
		studentPage.clicklinkondashboard(string);
	}

	@Then("Admin should see the Student details Page Title")
	public void admin_should_see_the_student_details_page_title() {
		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Student Page");
		LoggerLoad.info("****Admin user is on student page***");
		
		
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
		studentPage.navigationTime();
		 LoggerLoad.info("******Max navigation time *********");
		
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) throws IOException {
		testContextSetup.genericUtils.verifyBrokenLink();
		 LoggerLoad.info("******Link broken Student page *********");
	}

	@Then("Student Detail title should be in centre of the page")
	public void student_detail_title_should_be_in_centre_of_the_page() {
		studentPage.AreFieldInCenter();
	}

	@Then("{int} dropdowns should be present in the page")
	public void dropdowns_should_be_present_in_the_page(Integer int1) {
		Assert.assertTrue(studentPage.ArePresentDropdowns());
		 LoggerLoad.info("******both Dropdown present *********");
	}

	@Then("Admin should see search box inside batch id drop down")
	public void admin_should_see_search_box_inside_batch_id_drop_down() {
		Assert.assertTrue(studentPage.AreSearchBoxForDisplay());
		 LoggerLoad.info("******Search box present *********");
	}

	@Then("Admin should see correct spelling select student name")
	public void admin_should_see_correct_spelling_select_student_name() {
		studentPage.isStudentNameCorrect("Select Student Name");
		 LoggerLoad.info("******Correct Spelling of Select Student Name*********");
	}

	@Then("Admin should see correct spelling select batch id text")
	public void admin_should_see_correct_spelling_select_batch_id_text() {
		studentPage.isStudentNameCorrect("Select Batch Id");
		 LoggerLoad.info("******Correct Spelling of Select Batch Id*********");
	}
	

	@Then("Admin should see only numbers inside batch id drop down")
	public void admin_should_see_only_numbers_inside_batch_id_drop_down() {
		studentPage.getTextDropDownforbatch();
	}

	@Then("Admin should see select student name in gray color")
	public void admin_should_see_select_student_name_in_gray_color() {
	
		String txtclr=studentPage.getTextColor1();
		Assert.assertEquals(txtclr, "gray");
		LoggerLoad.info("******select student name  in gray color*********");
	}

	@Then("Admin should see select batch ID in gray color")
	public void admin_should_see_select_batch_id_in_gray_color() {
		String txtclr=studentPage.getTextColor2();
		Assert.assertEquals(txtclr, "gray");
		LoggerLoad.info("******select batch id in gray color*********");
	}

	@Then("Admin should see select student name in first")
	public void admin_should_see_select_student_name_in_first() {
		String txtdropdown1=studentPage.getTextDropDown1();
		Assert.assertEquals(txtdropdown1, "Select Student Name");
		LoggerLoad.info("******select student name in first********");
	}
	@Given("Admin is on student details page")
	public void admin_is_on_student_details_page_() {
		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Student Page");
		LoggerLoad.info("****Admin is in Student  page***");
	}


	@Then("Admin should see select batch id in second")
	public void admin_should_see_select_batch_id_in_second() {
		String txtdropdown2=studentPage.getTextDropDown1();
		Assert.assertEquals(txtdropdown2, "Select Student Name");
		LoggerLoad.info("******select student name in first********");
	}

	@Then("Admin should able to scroll down to select the name")
	public void admin_should_able_to_scroll_down_to_select_the_name() {
		studentPage.studentnameropdown();
		studentPage.scrollAndSelectNameOrMethod();
	}

	@Then("Admin should able to scroll down to select the batch id")
	public void admin_should_able_to_scroll_down_to_select_the_batch_id() {
		studentPage.batchdropdown();
		studentPage.scrollAndSelectNameOrMethod();
	}
	@When ("Admin select student name from the drop down")
public void Admin_select__name_from_the_drop_down(){
		studentPage.studentnameropdown();

}
	@When ("Admin selects only batch id from the drop down")
	public void Admin_select__batch_name_from_the_drop_down(){
			studentPage.batchdropdown();}



	@Then("Admin should not see select {string} name text")
	public void admin_shouldn_t_see_select_student_name_text(String data) {
		LoggerLoad.info("Admin shouldn't see select {string} name text");
		studentPage.selectstudentfromdropdown(data);
	}

	@Then("Admin should not see select {string} id text")
	public void admin_shouldn_t_see_select_batch_id_text(int num) {
		studentPage.selectbatchfromdropdown(num);
		LoggerLoad.info("Admin shouldn't see select {string} id text");

	}

	@Then("Admin should see student name start with x is listed below")
	public void admin_should_see_student_name_start_with_x_is_listed_below() {
		String userTextField=studentPage.getTextDropDown1();
		   char symbolAfterUser= userTextField.charAt(userTextField.length()-1);
		   Assert.assertEquals(symbolAfterUser,"*");
	}

	@Then("Admin should see batch id start with x is listed below")
	public void admin_should_see_batch_id_start_with_x_is_listed_below() {
		String userTextField=studentPage.getTextDropDown2();
		   char symbolAfterUser= userTextField.charAt(userTextField.length()-1);
		   Assert.assertEquals(symbolAfterUser,"*");
	}

	@Then("Student details shouldn't be displayed")
	public void student_details_shouldn_t_be_displayed() {
		studentPage.isStudentDetailsDisplayed();
		
	}
	@When("Admin selects student name and batch id from drop down")
		public void Admin_selects_student_name_and_batch_id_from_drop_down(){
		studentPage.studentnameropdown();
		studentPage.batchdropdown();
	}

	@Then("Particular student informations {string},{string},{string} should be display")
	public void particular_student_informations_should_be_display(String string,int data,String stringname) {
		studentPage.checkstudentdetailsinfo(string,data);
		studentPage.validatestudentname(stringname);
	}
	

	//Navigation
	@Given("Admin is on student details page")
	public void admin_is_manage_assignment_page_after_logged_in() {
		
		studentPage.verifystudentpage();
	}


	@When("Admin clicks on {string} link on student page")
	public void admin_clicks_button_in_the_navigation_bar(String string) {
		studentPage.clicklinkondashboard(string);
	}

	@Then("Admin is redirected to Student page")
	public void admin_should_able_to_land_on_student_page(String Student) {
		studentPage.clicklinkondashboard(Student);
		
	}

	@Then("Admin is redirected to Program page")
	public void admin_should_able_to_land_on_program_page(String Program) {
		studentPage.clicklinkondashboard(Program);
	    
	}

	@Then("Admin is redirected to Batch page")
	public void admin_should_able_to_land_on_batch_page(String Batch) {
		studentPage.clicklinkondashboard(Batch);
	   
	}

	@Then("Admin is redirected to User page")
	public void admin_should_able_to_land_on_user_page(String User) {
		studentPage.clicklinkondashboard(User);
	   
	}

	@Then("Admin is redirected to Class page")
	public void admin_should_able_to_land_on_class_page(String Class) {
		studentPage.clicklinkondashboard(Class);
	    
	}

	@Then("Admin is redirected to Attendance page")
	public void admin_should_able_to_land_on_attendance_page(String Attendence) {
		studentPage.clicklinkondashboard(Attendence);
	   
	}

	@Then("Admin is redirected to Login page")
	public void admin_should_able_to_land_on_login_page(String login) {
		studentPage.clicklinkondashboard(login);
	   
	}
	@Then("Admin is redirected to Assignment page")
	public void admin_should_able_to_land_on_assignment_page(String Assignment) {
		studentPage.clicklinkondashboard(Assignment);
	}


}
