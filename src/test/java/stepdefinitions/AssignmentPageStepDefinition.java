package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AssignmentPage;
import pages.LoginPage;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class AssignmentPageStepDefinition {
	long endTime;
	 long startTime;
	
	//Manage Assignment Page Verification
	public WebDriver driver;
	TestContextSetup testContextSetup;
    AssignmentPage assignmentPage;
    LoginPage loginPage;
	public AssignmentPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.assignmentPage=testContextSetup.pageObjectManager.getAssignmentPage();
	}
	
	@Given("Logged on the LMS portal as Admin")
	public void logged_on_the_lms_portal_as_admin() {
		
	   loginPage.enterCredentials("Rashmi", "Rashmi!1");
	   loginPage.clickOnlogInBtn();
	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		
	    LoggerLoad.info("The admin is on the dashboard");
	    startTime = System.currentTimeMillis();
	}

	@When("Admin clicks {string} button on the navigation bar")
	public void admin_clicks_button_on_the_navigation_bar(String string) {
	   assignmentPage.clickassignment();
	 
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
		
		assignmentPage.Assertfun(string);
		 endTime = System.currentTimeMillis();
		
	    
	}

	@Then("Get the response time for navigation from dashboard page to manage assignment page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_assignment_page() {
	  
		long totalTime = endTime - startTime;
		LoggerLoad.info("Response time:"+totalTime);
	}

	@Then("Admin should see header with {string}")
	public void admin_should_see_header_with(String headerName) {
		
	    assignmentPage.validateheader(headerName);
	}

	@When("Admin clicks {string} button on the navigation bar and get all text from the portal page")
	public void admin_clicks_button_on_the_navigation_bar_and_get_all_text_from_the_portal_page(String string) {
		   assignmentPage.clickassignment();
		
	    
	}

	@Then("Admin should see correct spelling for the all the fields")
	public void admin_should_see_correct_spelling_for_the_all_the_fields() {
		assignmentPage.verifyCorrectSpelling();
	    
	}

	@Then("Admin should see disabled delete icon below the {string}")
	public void admin_should_see_disabled_delete_icon_below_the(String string) {
		
		assignmentPage.deletebutton();
		
	}

	@Then("Admin should see search bar on the manage assignment page")
	public void admin_should_see_search_bar_on_the_manage_assignment_page() {
		
		assignmentPage.serchboxcheck();
	}

	@Then("Admin should see +Add New assignment button on the manage assignment page")
	public void admin_should_see_add_new_assignment_button_on_the_manage_assignment_page() {
		assignmentPage.addNewAssignmnetbuttoncheck();
	    
	}

	@Then("Admin should see data table on the manage assignment page With following column headers.")
	public void admin_should_see_data_table_on_the_manage_assignment_page_with_following_column_headers_check_box_symbol_assignment_name_assignment_description_assignment_date_assignment_grade_edit_delete(String data) {
		assignmentPage.headercolum(data);
	    
	}

	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		assignmentPage.check_entries();
		assignmentPage.editcheck();
	   
	}

	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {
		LoggerLoad.info("Edit Icon is not present");
	    
	}

	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
	    
		assignmentPage.deletecheck();
	}

	@Then("Delete Icon will not be present in data table")
	public void delete_icon_will_not_be_present_in_data_table() {
		LoggerLoad.info("Delete icon is not present");
	    
	}

	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
		assignmentPage.sortarrowbutton();
	    
	}

	@Then("Admin should see check box in the all rows  of data table when entries available")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table_when_entries_available() {
		
	    assignmentPage.check_entries();
	}

	@Then("Above the footer Admin should see the text as Showing x to y of z entries below the table.")
	public void above_the_footer_admin_should_see_the_text_as_showing_x_to_y_of_z_entries_below_the_table() {
		assignmentPage.showentry();
		
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		
		assignmentPage.showpagination();
	}

	@Then("Admin should see the text with total number assignments in the data table.")
	public void admin_should_see_the_text_with_total_number_assignments_in_the_data_table(String string) {
		assignmentPage.showtotalentries();
	}

	@Given("Admin logged into LMS portal and clicks assignment button on the navigation bar")
	public void admin_logged_into_lms_portal_and_clicks_assignment_button_on_the_navigation_bar() {
		assignmentPage.login();
	   
	}

	@Given("Admin is on manage assignment page")
	public void admin_is_on_manage_assignment_page() {
		assignmentPage.clickassignment();
	   
	}

	@When("Admin enters assignment name into search box")
	public void admin_enters_assignment_name_into_search_box(String assignmentname) {
		assignmentPage.serachtext(assignmentname);
	    
	}

	@Then("Displays entries with that assignment name")
	public void displays_entries_with_that_assignment_name() {
		assignmentPage.entries();
	   
	}

	@When("Admin enters assignment  name is not existing the table into search box")
	public void admin_enters_assignment_name_is_not_existing_the_table_into_search_box(String string1) {
		assignmentPage.serachtext(string1);
	    
	}

	@Then("Displays empty details in the data table")
	public void displays_empty_details_in_the_data_table() {
	   assignmentPage.entries();
	}

	@When("Admin enters assignment description into search box")
	public void admin_enters_assignment_description_into_search_box(String string1) {
		assignmentPage.serachtext(string1);
	   
	}

	@Then("Displays entries with that assignment description")
	public void displays_entries_with_that_assignment_description() {
		assignmentPage.entries();
	    
	}

	@When("Admin enters assignment description which is not existing the table into search box")
	public void admin_enters_assignment_description_which_is_not_existing_the_table_into_search_box(String string1) {
			assignmentPage.serachtext(string1);
	}

	@When("Admin enters assignment due date into search box")
	public void admin_enters_assignment_due_date_into_search_box(String string1) {
		assignmentPage.serachtext(string1);
	    
	}

	@Then("Displays entries with that assignment due date")
	public void displays_entries_with_that_assignment_due_date() {
		assignmentPage.entries();
	    
	}

	@When("Admin enters assignment due date which is not existing the table into search box")
	public void admin_enters_assignment_due_date_which_is_not_existing_the_table_into_search_box(String string1) {
		assignmentPage.serachtext(string1);
	}

	@When("Admin enters grade value  into search box")
	public void admin_enters_grade_value_into_search_box(String string1) {
		assignmentPage.serachtext(string1);
	    
	}

	    
	

	@When("Admin enters grade value which is not existing the table into search box")
	public void admin_enters_grade_value_which_is_not_existing_the_table_into_search_box(String random) {
		assignmentPage.serachtext(random);
		
	    
	}

	@Then("Displays entries with that assignment  grade")
	public void displays_entries_with_that_assignment_grade() {
		assignmentPage.entries();
	}

	// Assignment Details Popup Window Verification
	


	@When("Admin click +Add new assignment button")
	public void admin_click_add_new_assignment_button() {
		
		assignmentPage.add_new_assignment_click();
		 testContextSetup.genericUtils.SwitchWindowToChild();
	    
	}

	@Then("Admin should see a popup  with  heading {string}")
	public void admin_should_see_a_popup_with_heading(String string) {
	    
		assignmentPage.add_new_assignment_heading();
		
	}

	@Then("Admin should see input fields Text")
	public void admin_should_see_input_fields_text_program_name_batch_number_assignment_name_assignment_description_grade_by_assignment_due_date_assignment_file1_assignment_file_assignment_file_assignment_file_assignment_file(Integer int1, Integer int2, Integer int3, Integer int4) {
	    assignmentPage.validate_popup_fields();
		
	}

	@Then("{int} textbox should be  present in Assignment details popup window")
	public void textbox_should_be_present_in_assignment_details_popup_window(Integer int1) {
		assignmentPage.validate_textbox();
	    
	}

	@Then("Admin should see  dropdown option for Batch Number")
	public void admin_should_see_dropdown_option_for_batch_number() {
		
		assignmentPage.Validate_BatchNumber_dropdown();
	}

	@Then("Admin should see  dropdown option for Program name")
	public void admin_should_see_dropdown_option_for_program_name() {
	    assignmentPage.Validate_ProgramName_dropdown();
	}

	@Then("Admin should see  calendar icon for assignment due date")
	public void admin_should_see_calendar_icon_for_assignment_due_date() {
		assignmentPage.validate_calender_icon();
	   
	}

	@Then("Admin should see  save button in the Assignment detail popup window")
	public void admin_should_see_save_button_in_the_assignment_detail_popup_window() {
		assignmentPage.validate_save_button();
		
	}

	@Then("Admin should see  cancel button in the Assignment detail popup window")
	public void admin_should_see_cancel_button_in_the_assignment_detail_popup_window() {
	  
		assignmentPage.validate_cancel_button();
		
	}

	@Then("Admin should see  close button on the Assignment details popup window")
	public void admin_should_see_close_button_on_the_assignment_details_popup_window() {
		assignmentPage.validate_close_button();
		
	}
	
	// Add New Assignment 
	
	@Given("Admin click +Add new assignment button after reaching to manage assignment page")
	public void admin_click_add_new_assignment_button_after_reaching_to_manage_assignment_page() {
	   
		assignmentPage.add_new_assignment_click();
		 testContextSetup.genericUtils.SwitchWindowToChild();
	}

	@Given("Admin is in  assignment details popup window")
	public void admin_is_in_assignment_details_popup_window() {
	    
		LoggerLoad.info("Admin is in assignment POP up window");
	}

	@When("Admin enters all mandatory field values with valid data and clicks save button")
	public void admin_enters_all_mandatory_field_values_with_valid_data_and_clicks_save_button_program_name_batch_number_assignment_name_grade_by_assignment_due_date_in_assignmment(String AssignmentName) {
	    assignmentPage.fillValuesAndSave(AssignmentName);
		
	}

	@Then("Admin should see new assignment details is added in the data table")
	public void admin_should_see_new_assignment_details_is_added_in_the_data_table() {
		
		assignmentPage.getSucessMsg();
	    
	}

	@When("Admin enters all mandatory field values with invalid data and clicks save button")
	public void admin_enters_all_mandatory_field_values_with_invalid_data_and_clicks_save_button_program_name_batch_number_assignment_name_grade_by_assignment_due_date_in_assignment(String random) {
		assignmentPage.fillValuesAndSave(random);
		
	}

	@Then("Error message should appear in alert in assignment")
	public void error_message_should_appear_in_alert_in_assignment() {
		
		assignmentPage.getErrorMsg();
	    
	}


	@Then("Program Name is missing error  appear in assignment")
	public void program_name_is_missing_error_appear_in_assignment() {
	    
		assignmentPage.getErrorMsg();
	}


	@Then("Batch number is missing error appears in assignment")
	public void batch_number_is_missing_error_appears_in_assignment() {
		
		assignmentPage.getErrorMsg();
	}



	@Then("Assignment due date is missing error appears")
	public void assignment_due_date_is_missing_error_appears() {
		assignmentPage.getErrorMsg();
	    
	}

	@When("Admin enters data missing value in grade by  and clicks save button")
	public void admin_enters_data_missing_value_in_grade_by_and_clicks_save_button_program_name_batch_number_assignment_name_assignment_due_date() {
	assignmentPage.missingValue();
		
	}

	@Then("Grade by is missing appears in assignment")
	public void grade_by_is_missing_appears_in_assignment() {
		String message= assignmentPage.getErrorMsg();
		
	    Assert.assertTrue(message.contains("Grade by is missing"));
	}

	@When("Admin enters passed date in the due date field and clicks save button")
	public void admin_enters_passed_date_in_the_due_date_field_and_clicks_save_button_program_name_batch_number_assignment_name_grade_by_assignment_due_date() {
	    
		assignmentPage.selectPastDateAndSave();
	}

	@Then("Assignment cannot be created for the passed date")
	public void assignment_cannot_be_created_for_the_passed_date() {
		
String message= assignmentPage.getErrorMsg();
		
	    Assert.assertTrue(message.contains("Assignment is not created"));
	}

	@When("Admin clicks date from date picker in assignment")
	public void admin_clicks_date_from_date_picker_in_assignment() {
		assignmentPage.clickDatePicker();
	    
	}

	@Then("selected date should be their in class date text box in assignment")
	public void selected_date_should_be_their_in_class_date_text_box_in_assignment() {
		assignmentPage.isSelectedDatePresent();
	   
	}

	@Then("selected date should be in  mm\\/dd\\/yyyy format in assignment")
	public void selected_date_should_be_in_mm_dd_yyyy_format_in_assignment() {
		assignmentPage.dateFormat();
	    
	}

	@When("Admin clicks right arrow in the date picker near month in assignment")
	public void admin_clicks_right_arrow_in_the_date_picker_near_month_in_assignment() {
		assignmentPage.Calander_clickRightArrow();
	  
	}

	@Then("Next month calender should visible in assignment")
	public void next_month_calender_should_visible_in_assignment() {
		assignmentPage.nextMonth();
	    
	}

	@When("Admin clicks left arrow in the date picker near month in assignment")
	public void admin_clicks_left_arrow_in_the_date_picker_near_month_in_assignment() {
		
		assignmentPage.Calander_clickLeftArrow();
	    
	}

	@Then("previous month calender should visible in assignment")
	public void previous_month_calender_should_visible_in_assignment() {
		assignmentPage.previousMonth();
	    
	}

	@When("Admin clicks date picker button in assignment")
	public void admin_clicks_date_picker_button_in_assignment() {
		assignmentPage.datepick();
	    
	}

	@Then("Admin should see current date is highled in the date picker in assignment")
	public void admin_should_see_current_date_is_highled_in_the_date_picker_in_assignment() {
		assignmentPage.highlightcurrentdate();
	   
	}

	@When("Admin clicks date picker button and selects future date in assignment")
	public void admin_clicks_date_picker_button_and_selects_future_date_in_assignment() {
		
		assignmentPage.futureDate();
	}

	@Then("Admin should see selected date is highled in the date picker in assignment")
	public void admin_should_see_selected_date_is_highled_in_the_date_picker_in_assignment() {
	    
		assignmentPage.highlightfutureDate();
		
	}

	@When("Admin clicks Cancel button without entering values in the fields in assignment")
	public void admin_clicks_cancel_button_without_entering_values_in_the_fields_in_assignment() {
		
	    assignmentPage.cancelAssignmentPopup();
	}

	@Then("Admin should land on manage assignment page")
	public void admin_should_land_on_manage_assignment_page() {
	    
		String url= driver.getCurrentUrl();
		 Assert.assertTrue(url.equals("www.lms.com"));
	}

	@When("Admin clicks Cancel button entering values in the fields in assignment")
	public void admin_clicks_cancel_button_entering_values_in_the_fields_in_assignment(String Name) {
		
	    assignmentPage.AssignmentPOPupWithInputs(Name);
	    assignmentPage.cancelAssignmentPopup();
	}

	@Then("Admin should land on manage assignment Page and validate new assignment is not created in the data table")
	public void admin_should_land_on_manage_assignment_page_and_validate_new_assignment_is_not_created_in_the_data_table() {
	   

		String url= driver.getCurrentUrl();
		 Assert.assertTrue(url.equals("www.lms.com/assignmentpage"));
	}
// Edit Assignment Validation
	@Given("Admin is in manage assignment page")
	public void admin_is_in_manage_assignment_page() {
		 assignmentPage.clickassignment();
	    
	}

	@When("Admin clicks Edit button in data table  in assignment")
	public void admin_clicks_edit_button_in_data_table_in_assignment() {
		
		assignmentPage.ClickEdit();
		 testContextSetup.genericUtils.SwitchWindowToChild();
	}

	@Then("Edit popup window appears with heading Assignment Details")
	public void edit_popup_window_appears_with_heading_assignment_details() {
	    assignmentPage.verifyeditpopup();
		
	}

	@When("Admin clicks Edit button from one of the row in data table in assignment")
	public void admin_clicks_edit_button_from_one_of_the_row_in_data_table_in_assignment() {
		
		assignmentPage.ClickEdit();
	}

	@Then("Edit popup window appears with same row values in the all fields in assignment")
	public void edit_popup_window_appears_with_same_row_values_in_the_all_fields_in_assignment() {
		
	    assignmentPage.verifydata();
	}

	@Given("Admin clicks Edit button in manage assignment after reaching manage assignment page")
	public void admin_clicks_edit_button_in_manage_assignment_after_reaching_manage_assignment_page() {
		assignmentPage.ClickEdit();
	}

	

	@When("Admin enters all mandatory field values with valid data and clicks save button")
	public void admin_enters_all_mandatory_field_values_with_valid_data_and_clicks_save_button_program_name_batch_number_assignment_name_grade_by_assignment_due_date(String Name) {
	  
		assignmentPage.EditfillValuesAndSave(Name);
	}

	@Then("Admin should see updated assignment details is added in the data table")
	public void admin_should_see_updated_assignment_details_is_added_in_the_data_table() {
		LoggerLoad.info("The assignment is scuessfully edited");
	}

	@When("Admin enters all mandatory field values with invalid data and clicks save button")
	public void admin_enters_all_mandatory_field_values_with_invalid_data_and_clicks_save_button_program_name_batch_number_assignment_name_grade_by_assignment_due_date(String r) {
	    assignmentPage.fillIValuesAndSave(r);
		
	}

	@When("Admin enters values in all fields with valid data and clicks save button")
	public void admin_enters_values_in_all_fields_with_valid_data_and_clicks_save_button_program_name_batch_number_assignment_name_assignment_description_grade_by_assignment_due_date_assignment_file1_assignment_file_assignment_file_assignment_file_assignment_file(String name) {
		assignmentPage.fillIValuesAndSave1(name);
		
	}

	@When("Admin enters with invalid data in optional fields and clicks save button")
	public void admin_enters_with_invalid_data_in_optional_fields_and_clicks_save_button_assignment_file1_assignment_file_assignment_file_assignment_file_assignment_file(String Aname, String Adesc, String FileLoc1, String FileLoc2, String FileLoc3) {
		assignmentPage.InvalidOptionalField(Aname, Adesc, FileLoc1, FileLoc2, FileLoc3);
	}

	@When("Admin enters  data missing value in program name and clicks save button")
	public void admin_enters_data_missing_value_in_program_name_and_clicks_save_button_batch_number_assignment_name_assignment_description_grade_by_assignment_due_date_assignment_file1_assignment_file_assignment_file_assignment_file_assignment_file(String name) {
		assignmentPage.PnamefillIValuesAndSave1(name);
	}

	@Then("Program Name is missing in assignment")
	public void program_name_is_missing_in_assignment() {
		
		String message= assignmentPage.getErrorMsg();
		LoggerLoad.info(message);
	}

	@When("Admin enters data missing value in Batch number and clicks save button")
	public void admin_enters_data_missing_value_in_batch_number_and_clicks_save_button_program_name_assignment_name_assignment_description_grade_by_assignment_due_date_assignment_file1_assignment_file_assignment_file_assignment_file_assignment_file(String name) {
		assignmentPage.BNumfillIValuesAndSave1(name);
	}

	@Then("Batch number is missing in assignment")
	public void batch_number_is_missing_in_assignment() {
		String message= assignmentPage.getErrorMsg();
		LoggerLoad.info(message);
	}

	@When("Admin enters data missing value in Assignment name and clicks save button")
	public void admin_enters_data_missing_value_in_assignment_name_and_clicks_save_button_program_name_batch_number_assignment_name_grade_by_assignment_due_date() {
		assignmentPage.ANamefillIValuesAndSave1();
	}

	@Then("Assignment name is missing")
	public void assignment_name_is_missing() {
		String message= assignmentPage.getErrorMsg();
		LoggerLoad.info(message);
	}

	@Given("Admin is in Edit assignment detail popup window")
	public void admin_is_in_edit_assignment_detail_popup_window() {
		 assignmentPage.clickassignment();
	    
	}

	@When("Admin enters data missing value in Assignment due date and clicks save button")
	public void admin_enters_data_missing_value_in_assignment_due_date_and_clicks_save_button_program_name_batch_number_assignment_name_grade_by(String name) {
		assignmentPage.DdatefillIValuesAndSave1(name);
	}

	@Then("Assignment due date is missing")
	public void assignment_due_date_is_missing() {
		String message= assignmentPage.getErrorMsg();
		LoggerLoad.info(message);
	    
	}

	@Then("Grade by is missing in assignment")
	public void grade_by_is_missing_in_assignment() {
	   
		String message= assignmentPage.getErrorMsg();
		LoggerLoad.info(message);
	}


	@Then("Assignment cannot be updated for the passed date")
	public void assignment_cannot_be_updated_for_the_passed_date() {
		String message= assignmentPage.getErrorMsg();
		LoggerLoad.info(message);
	    
	}

	//Delete Assignment Validation
	
	@When("Admin clicks delete button in data table row level in assignment")
	public void admin_clicks_delete_button_in_data_table_row_level_in_assignment() {
		assignmentPage.check_first_row();

		assignmentPage.delete_first_record();
		testContextSetup.genericUtils.SwitchWindowToChild();

	}

	@Then("Admin should see dialog box in assignment")
	public void admin_should_see_dialog_box_in_assignment() {
		
		assignmentPage.alertpopdeletedetails();
	}

	@Then("Alert should have yes button to accept in assignment")
	public void alert_should_have_yes_button_to_accept_in_assignment() {
		assignmentPage.alertpopdeletedetails();
	    
	}

	@Then("Alert should have No button to reject in assignment")
	public void alert_should_have_no_button_to_reject_in_assignment() {
		assignmentPage.alertpopdeletedetails();
	    
	}

	@Given("Admin clicks row level delete button after landing to manage assignment page")
	public void admin_clicks_row_level_delete_button_after_landing_to_manage_assignment_page() {
		assignmentPage.alertpopupayes();
	}

	@Given("Admin is in delete alertin assignment")
	public void admin_is_in_delete_alertin_assignment() {
		
		assignmentPage.alertpopdeletedetails();
	}

	
	//Delete Multiple Class Validation
	
	@Given("Admin clicks delete button under header after selecting the check box in the data table")
	public void admin_clicks_delete() {
		assignmentPage.checktopleftfelete();
	}

	@When("Admin clicks single  row level check box in the data table in assignment")
	public void admin_clicks_single_row_level_check_box_in_the_data_table_in_assignment() {
		
		assignmentPage.check_first_row();
		
	    
	}

	@Then("Admin should see delete icon below the header is enabled in assignment")
	public void admin_should_see_delete_icon_below_the_header_is_enabled_in_assignment() {
		assignmentPage.checktopleftfelete();
		assignmentPage.multidelete();
		
	}

	@Given("Admin is in delete alert in assignment")
	public void admin_is_in_delete_alert_in_assignment() {
		
		assignmentPage.alertpopdeletedetails();
	}

	@When("Admin clicks yes button in assignment")
	public void admin_clicks_yes_button_in_assignment() {
	    
		assignmentPage.alertpopupayes();
	}

	@Then("Redirected to assignment page and selected assignment details are deleted from the data table")
	public void redirected_to_assignment_page_and_selected_assignment_details_are_deleted_from_the_data_table() {
	    
		assignmentPage.VerifyMultipleItemsDeletion();
		
	}

	@When("Admin clicks no button in assignment")
	public void admin_clicks_no_button_in_assignment() {
		assignmentPage.alertpopupano();
	    
	}

	@Then("Redirected to assignment page and selected assignment details are not deleted from the data table")
	public void redirected_to_assignment_page_and_selected_assignment_details_are_not_deleted_from_the_data_table() {
	    
	String url= driver.getCurrentUrl();
	Assert.assertTrue(url.equals("www.lms.com/assignment"));
	}


	// Verify Sort Function In Manage Asiignment Page
	
	@When("Admin click on assignment name column header to sort")
	public void admin_click_on_assignment_name_column_header_to_sort() {
		
	    assignmentPage.assignmentname_dscending_sort();
	}

	@Then("Admin should see data table sorted in descending order")
	public void admin_should_see_data_table_sorted_in_descending_order() {
		assignmentPage.datavalidationprgdescdesc();
	    
	}

	@When("Admin double click on assignment name column header to sort")
	public void admin_double_click_on_assignment_name_column_header_to_sort() {
	
		assignmentPage.assignmentname_ascending_sort();
	}

	@Then("Admin should see data table sorted in ascending  order")
	public void admin_should_see_data_table_sorted_in_ascending_order() {
    assignmentPage.datavalidationprgdescasc();
	    
	}
	
	//Pagination In Manage Assignment 
	@Given("Admin is on dashboard page after Login in assignment")
	public void admin_is_on_dashboard_page_after_login_in_assignment() {
		assignmentPage.login();
	   
	}

	@Then("Data table should display {int} page  when entries available in assignment")
	public void data_table_should_display_page_when_entries_available_in_assignment(Integer int1) {
		
	   assignmentPage.firstpagecount();
	}

	@Then("Right arrow should be enabled in page one  when entries are more than {int} available in assignment")
	public void right_arrow_should_be_enabled_in_page_one_when_entries_are_more_than_available_in_assignment(Integer int1) {
	    assignmentPage.checkrightarrow();
	}

	@Then("Left arrow should be disabled in page one  when entries are more than {int} available in assignment")
	public void left_arrow_should_be_disabled_in_page_one_when_entries_are_more_than_available_in_assignment(Integer int1) {
	   assignmentPage.checkleftarrow();
	}

	@Then("Right arrow should be enabled in page two when entries are more than {int} available in assignment")
	public void right_arrow_should_be_enabled_in_page_two_when_entries_are_more_than_available_in_assignment(Integer int1) {
	 
		assignmentPage.checkRightArrow2Page_Pagination_enable();
	}

	@Then("Left arrow should be enabled in page two  in assignment")
	public void left_arrow_should_be_enabled_in_page_two_in_assignment() {
		assignmentPage.checkleftArrow2Page();
	    
	}

	
	@Then("When entries are more than {int} in data table pagination controls enabled in assignment")
	public void when_entries_are_more_than_in_data_table_pagination_controls_enabled_in_assignment(Integer int1) {
	
		assignmentPage.checkRightArrow2Page_Pagination_enable();
	}

	@Then("When entries are less than {int} in data table pagination controls disabled in assignment")
	public void when_entries_are_less_than_in_data_table_pagination_controls_disabled_in_assignment(Integer int1) {
	
		assignmentPage.pagination_disable();
	}

	

	@Given("Admin is in add assignment details popup window")
	public void admin_is_in_add_assignment_details_popup_window() {
		assignmentPage.add_new_assignment_click();
		 testContextSetup.genericUtils.SwitchWindowToChild();
		
	}

	@When("Admin creates {int} new assignment")
	public void admin_creates_new_assignment(String name) {
		
		assignmentPage.add5Data(name);
	}

	@Then("When total class entries above {int} next page is enabled in assignment")
	public void when_total_class_entries_above_next_page_is_enabled_in_assignment() {
		
	  assignmentPage.checkrightarrow(); 
	}

	@When("Admin creates less than or equal to {int} new  assignment")
	public void admin_creates_less_than_or_equal_to_new_assignment(String name) {
		assignmentPage.fillIValuesAndSave(name);
	}

	@Then("When total class entries  {int} or below next page is disabled in assignment")
	public void when_total_class_entries_or_below_next_page_is_disabled_in_assignment(Integer int1) {
	 assignmentPage.pagination_disable();   
	}

//Navigation Function Validation From Manage Assignment PAge


		@Given("Admin is manage assignment page after logged in")
		public void admin_is_manage_assignment_page_after_logged_in() {
			assignmentPage.login();
		   
		}


		@When("Admin clicks {string} button in the navigation bar")
		public void admin_clicks_button_in_the_navigation_bar(String string) {
		   assignmentPage.clicklinkonnavbar(string);
		}

		@Then("Admin should able to land on student page")
		public void admin_should_able_to_land_on_student_page(String Student) {
			assignmentPage.clicklinkonnavbar(Student);
		    
		}

		@Then("Admin should able to land on program page")
		public void admin_should_able_to_land_on_program_page(String Program) {
			assignmentPage.clicklinkonnavbar(Program);
		    
		}

		@Then("Admin should able to land on batch page")
		public void admin_should_able_to_land_on_batch_page(String Batch) {
			assignmentPage.clicklinkonnavbar(Batch);
		   
		}

		@Then("Admin should able to land on user page")
		public void admin_should_able_to_land_on_user_page(String User) {
			assignmentPage.clicklinkonnavbar(User);
		   
		}

		@Then("Admin should able to land on class page")
		public void admin_should_able_to_land_on_class_page(String Class) {
			assignmentPage.clicklinkonnavbar(Class);
		    
		}

		@Then("Admin should able to land on Attendance page")
		public void admin_should_able_to_land_on_attendance_page(String Attendence) {
			assignmentPage.clicklinkonnavbar(Attendence);
		   
		}

		@Then("Admin should able to land on login page")
		public void admin_should_able_to_land_on_login_page(String login) {
			assignmentPage.clicklinkonnavbar(login);
		   
		}
	

}
