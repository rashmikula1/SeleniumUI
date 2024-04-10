package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.ProgramPage;
import utilities.ExcelReader;
import utilities.GenericUtils;
import utilities.LoggerLoad;
import utilities.TestBase;
import utilities.TestContextSetup;

public class ProgramPageStepDefinition {
//MANAGEVALIDATION-SD	
	public WebDriver driver;
	TestContextSetup testContextSetup;
	ProgramPage programPage;
	TestBase Tsb;
	ExcelReader reader ;
	GenericUtils genericUtils;

	String xlPath=System.getProperty(("user.dir")+"//LMSAutomation//exceldata//TestData.xlsx");
	
		public ProgramPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	

 @Given("Logged on the LMS portal as Admin")
public void logged_on_the_lms_portal_as_admin() {
	 LoggerLoad.info("Logged on the LMS portal as Admin");
    //temp
	 //testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/LMSlogin");
	 //programPage.clicklogin();//from login stepdef
}

	@Given("Admin is on dashboard page after Login in program")
	public void admin_is_on_dashboard_page_after_login_in_program() throws IOException {
		 LoggerLoad.info("Admin is on dashboard page after Login in program");

		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/LMSdashboard");
	}

	@When("Admin clicks {string} on the navigation bar in program")
	public void admin_clicks_on_the_navigation_bar_in_program(String string) {
		LoggerLoad.info("Admin clicks {string} on the navigation bar in program");
		programPage.clicklinkondashboard(string);	}

	@Then("Admin should see URL with {string} in program")
	public void admin_should_see_url_with_in_program(String url) throws IOException {
		LoggerLoad.info("Admin should see URL with {string} in program");
		String title="https://lms.app.com/Manage program";
		 Assert.assertEquals(title.contains("Manage program"),url);}

	@Then("Admin should see a heading with text {string} on the page in program")
	public void admin_should_see_a_heading_with_text_on_the_page_in_program(String hdng) {
		LoggerLoad.info("Admin should see a heading with text {string} on the page in program");
		String headingtext=programPage.appearonheading();
		 Assert.assertEquals(headingtext,hdng);
}

	@Then("Admin should see the text as {string} along with Pagination icon in program.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table_in_program(String pagination) {
		LoggerLoad.info("Admin should see the text as {string} along with Pagination icon in program.");
		String paginationtext=programPage.appearonpaginationicon();
		 Assert.assertEquals(paginationtext,pagination);

	}

	@Then("Admin should see the footer as {string} in program.")
	public void admin_should_see_the_footer_as_in_program(String totalzentry) {
		LoggerLoad.info("Admin should see the footer as {string} in program.");

		String ttlentries=programPage.totalentiespaginationicon();
		Assert.assertEquals(ttlentries,totalzentry);
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled in program")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled_in_program() {
		LoggerLoad.info("Admin should see a Delete button on the top left hand side as Disabled in program");
		boolean disabled=programPage.checkdisableddeleteicon();
		Assert.assertEquals(disabled,false);
	}

	@Then("Admin should see a {string} button on the program page above the data table in program")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table_in_program(String newpg) {
		String appaddnewprog=programPage.appearingaddnewprog(); 
		Assert.assertEquals(appaddnewprog,newpg);

	}

	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int} in program")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are_in_program(Integer int1) {
		int rowcount=programPage.webtablerows();
		Assert.assertEquals(rowcount,int1);
		
	}

	@Then("Admin should see data table on the Manage Program Page with column headers {string},{string},{string},{string},{string} in program")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_in_program(String name,String Desc,String status,String edit,String delete) {
		programPage.headercolumn(name);
		programPage.headercolumn(Desc);
		programPage.headercolumn(status);
		programPage.headercolumn(edit);
		programPage.headercolumn(delete);
}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete in program")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete_in_program() {
		programPage.sortarrowbutton();
		
	}

	@Then("Admin should see check box on the left side in all rows of the data table in program")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table_in_program() {
		programPage.checkboxcheck();
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table in program")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table_in_program() {
		programPage.editcheck();
		programPage.deletecheck();
	}

	@Then("Admin should see Search bar with text as {string} in program")
	public void admin_should_see_search_bar_with_text_as_in_program(String text) {
		String searchboxtext=programPage.textsearch();
		Assert.assertEquals(searchboxtext,text);

	}

	@Given("Admin is on Manage Program Page in program")
	public void admin_is_on_manage_program_page_in_program() throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");
 
	}

	@When("Admin enters {string} into search box in program.")
	public void admin_enters_into_search_box_in_program(String programname) {
		programPage.enterinsearch(programname);
		}
	

	@Then("Admin should see the Programs displayed based on the Program Name in program")
	public void admin_should_see_the_programs_based_on_the_program_name_in_program() {
		//programPage.displayenternameinsearch();
		programPage.searchforprogname();}

	@When("Admin enters {string} into the search box in program.")
	public void admin_enters_into_the_search_box_in_program(String programdescription) {
		programPage.enterinsearch(programdescription);
	}

	@Then("Admin should see the Programs displayed based on the Program Description in program")
	public void admin_should_see_the_programs_displayed_based_on_the_program_description_in_program() {
		//programPage.displayenternameinsearch();
		programPage.searchforprogdescription();
	}

	@When("Admin enters {string} in search box in program.")
	public void admin_enters_in_search_box_in_program(String programstatus) {
		programPage.enterinsearch(programstatus);	}

	@Then("Admin should see the Programs displayed based on the Program Status in program")
	public void admin_should_see_the_programs_displayed_based_on_the_program_status_in_program() {
		//programPage.displayenternameinsearch();
		programPage.searchforprogstatus();

   }

	@When("Admin enters the keywords not present in the data table {string} on the Search box in program")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box_in_program(String notrelated) {
		programPage.enterinsearch(notrelated);
		
	}

	@Then("Admin should see zero entries on the data table in program")
	public void admin_should_see_zero_entries_on_the_data_table_in_program() {
		programPage.searchwithzeroentries();
		
	}


//ADDPROGRAM-SD
	@Given("Admin is on dashboard page after Login and clicks Program on the navigation bar")
	public void admin_is_on_dashboard_page_after_login_and_clicks_program_on_the_navigation_bar(String string) throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/LMSdashboard");
		programPage.clicklinkondashboard(string);
	}

	@When("Admin clicks <A New Program>button in program")
	public void admin_clicks_a_new_program_button_in_program() {
		programPage.clicknewprogram();
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close Icon on the top right corner of the window in program")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window_in_program() {
		programPage.clickbtnscheckinaddprog();
		genericUtils.SwitchWindowToChild();
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window in program")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window_in_program() {
		genericUtils.SwitchWindowToChild();

		programPage.textboxcheckinaddprog();
	}

	@Then("Admin should see two radio button for Program Status in program")
	public void admin_should_see_two_radio_button_for_program_status_in_program() {
		genericUtils.SwitchWindowToChild();

		programPage.popaddprogrmaradiobutton();
	}

	@Given("Admin is on Manage Program Page after clicks Program on the navigation bar")
	public void admin_is_on_manage_program_page_after_clicks_program_on_the_navigation_bar() throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");

	}

	@Given("Admin is on Program Details Popup window in program")
	public void admin_is_on_Program_Detailspopup_window_in_program(String string) {
		programPage.clicknewprogram();
		genericUtils.SwitchWindowToChild();

	}

	@When("Admin clicks <Save>button without entering any data in program")
	public void admin_clicks_save_button_without_entering_any_data_in_program() {
		programPage.clicksavebtn();
		
	}

	@Then("Admin gets a Error message alert {string} in program")
	public void admin_gets_a_error_message_alert_in_program(String failmsg) {
		String unSucessMsg=programPage.alertpopdeletedetails();
		Assert.assertEquals(unSucessMsg,failmsg);

	}

	@When("Admin enters only {string} in text box and clicks Save button in program")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button_in_program(String Sheetname,int RowNumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("ProgramName");
		programPage.entertextprogramname(cellvalue1);
		
		programPage.clicksavebtn();
	}

	@Then("Admin gets a message alert in program")
	public void admin_gets_a_message_alert_in_program(String failmsg) {
		String unSucessMsg=programPage.alertpopdeletedetails();
		Assert.assertEquals(unSucessMsg,failmsg);

	}

	@When("Admin enters only {string} in text box and clicks Save button in program")
	public void admin_enters_only_program_description_in_text_box_and_clicks_save_button_in_program(String Sheetname,int RowNumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("ProgramDesc");
		programPage.entertextprogramdescription(cellvalue1);
		
		programPage.clicksavebtn(); 
	}

	@When("Admin selects only Status and clicks Save button in program")
	public void admin_selects_only_status_and_clicks_save_button_in_program() {
		programPage.clickradiobtnprogramstatusactive();
		programPage.clicksavebtn(); 
	}

	@When("Admin enters only numbers or special char {string} and {string} in name and desc column in program")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column_in_program(String Sheetname,int RowNumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(xlPath ,Sheetname );
		String cellvalue1=data.get(RowNumber).get("ProgramName");
		String cellvalue2=data.get(RowNumber).get("ProgramDesc");
		programPage.entertextprogramname(cellvalue1);

		programPage.entertextprogramdescription(cellvalue2);
		
		programPage.clicksavebtn();
	}

	@When("Admin clicks Cancel or Close Icon on Program Details form in program")
	public void admin_clicks_cancel_close_x_icon_on_program_details_form_in_program() {
		LoggerLoad.info("Admin clicks Cancel or Close Icon on Program Details form in program");
		programPage.clickcancelbtn();
		programPage.clickclosebtn();
	}

	@Then("Program Details popup window should be closed without saving in program")
	public void program_details_popup_window_should_be_closed_without_saving_in_program(String programName) throws IOException {
		LoggerLoad.info("Program Details popup window should be closed without saving in program");
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");
		boolean result = programPage.validateNewProgram(programName);
		Assert.assertEquals(result, false);


	}

	@When("Enter all the required fields with valid values {string} and {string} and click Save button in program")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button_in_program(String Sheetname,int RowNumber) throws InvalidFormatException, IOException {
		LoggerLoad.info("Enter all the required fields with valid values and click Save button in progra");

		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("ProgramName");
		String cellvalue2=data.get(RowNumber).get("ProgramDesc");
		programPage.entertextprogramname(cellvalue1);
		programPage.entertextprogramdescription(cellvalue2);
		programPage.clickradiobtnprogramstatusactive();
		
		programPage.clicksavebtn();
	}

	@Then("Admin gets a message {string} alert and able to see the {string} added in the data table in program")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table_in_program(String successmessage, String programName) {
		LoggerLoad.info("Admin gets a message {string} alert and able to see the new program added in the data table in program");
		String success=programPage.alertpopdeletedetails();
		Assert.assertEquals(success,successmessage);
		boolean result = programPage.validateNewProgram(programName);
		Assert.assertEquals(result, true);
	}
	

	@When("Admin clicks <Cancel>button in program")
	public void admin_clicks_cancel_button_in_program() {
		LoggerLoad.info("Admin clicks <Cancel>button in program");
		
		programPage.clickcancelbtn();
	}

	@Then("Admin can see the Program details popup disappears without creating any {string} in program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program_in_program(String programName) throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");
		boolean result = programPage.validateNewProgram(programName);
		Assert.assertEquals(result, false);
	}


//EDITPROGRAM-SD
	@When("Admin clicks <Edit> button on the data table for any row in program")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row_in_program() {
		programPage.clickeditprogram();
	}

	@Then("Admin should see a popup open for Program details to edit in program")
	public void admin_should_see_a_popup_open_for_program_details_to_edit_in_program() {
		genericUtils.SwitchWindowToChild();

		programPage.clickeditprogram();
	}

	@Given("Admin is on Program Details Popup window to Edit in program")
	public void admin_is_on_program_details_popup_window_to_edit_in_program() {
		programPage.clickeditprogram(); 
		genericUtils.SwitchWindowToChild();

	}

	@When("Admin edits the {string} and clicks save button in program")
	public void admin_edits_the_name_column_and_clicks_save_button_in_program(String Sheetname,int RowNumber) throws InvalidFormatException, IOException {
		programPage.cleartextfornameedit();
		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("ProgramName");
		programPage.entertextprogramname(cellvalue1);
		
		programPage.clicksavebtn();  
	}

	@Then("Admin gets a message {string} alert and able to see the {string} in the table for the particular program in program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program_in_program(String updatedname,String Name) {
		String success=programPage.alertpopdeletedetails();
		Assert.assertEquals(success,updatedname);
		boolean result = programPage.validate_edit_ProgramName(Name);
		Assert.assertEquals(result, true);}

	@When("Admin edits the {string} and then clicks save button in program")
	public void admin_edits_the_description_column_and_clicks_save_button_in_program(String Sheetname,int RowNumber) throws InvalidFormatException, IOException {
		programPage.cleartextfordescriptionedit();
		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("ProgramDesc");
		programPage.entertextprogramdescription(cellvalue1);
		
		programPage.clicksavebtn();  
	}

	@Then("Admin gets a message {string} alert and able to see the updated {string} in the table for the particular program in program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program_in_program(String updateddesc,String description) {
		String success=programPage.alertpopdeletedetails();
		Assert.assertEquals(success,updateddesc);
		boolean result = programPage.validate_edit_Programdesccription(description);
		Assert.assertEquals(result, true);}

	

	@When("Admin changes the Status and clicks save button in program")
	public void admin_changes_the_status_and_clicks_save_button_in_program() {
		programPage.clickradiobtnprogramstatusinactive();
		programPage.clicksavebtn();  

	}

	@Then("Admin gets a message {string} alert and able to see the updated {string}  in the table for the particular program in program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program_in_program(String updatedstatus) {
		
		String success=programPage.alertpopdeletedetails();
		Assert.assertEquals(success,updatedstatus);
		boolean result = programPage.validate_editProgram_status();
		Assert.assertEquals(result, true);}
		
	
	@When("Admin enters only numbers or special char {string} and {string} in name and desc column in programedit")
public void Admin_enters_only_numbers_or_special_char(String Sheetname,int RowNumber) throws InvalidFormatException, IOException {
		programPage.cleartextfordescriptionedit();
		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("ProgramDesc");
		programPage.entertextprogramdescription(cellvalue1);
		
		programPage.clicksavebtn(); 
	}

	@When("Admin clicks <Cancel>button on edit popup in program")
	public void admin_clicks_cancel_button_on_edit_popup_in_program() {
		programPage.clickcancelbtn();	}

	@Then("Admin can see the Program details popup disappears and cannot see changed {string},{string} for particular program in program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program_in_program(String Name,String description) throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");
		boolean result = programPage.validate_edit_ProgramName(Name);
		Assert.assertEquals(result, true);
		boolean result1 = programPage.validate_edit_Programdesccription(description);
		Assert.assertEquals(result1, false);}


	

	@When("Admin clicks <Save>button on edit popup in program")
	public void admin_clicks_save_button_on_edit_popup_in_program() {
		programPage.clicksavebtn();	}

	@Then("Admin gets a message {string} alert and able to see the updated details {string} in the table for the particular program in program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program_in_program(String success,String Name) {
		String updatesuccess=programPage.alertpopdeletedetails();
		Assert.assertEquals(updatesuccess, success);
		
		boolean result = programPage.validate_edit_ProgramName(Name);
		Assert.assertEquals(result, true);}


//DELETEPROGRAM-SD
	@When("Admin clicks <Delete> button on the data table for any row in program")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row_in_program() {
		programPage.clickAnyCheckbox();	
	}

	@Then("Admin should see a alert open with heading {string} along with {string} and {string} button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion_in_program(String confirm,String yes,String no) {
		genericUtils.SwitchWindowToChild();

		String alertText=programPage.alertpopdeletedetails();
		Assert.assertEquals(alertText.contains(confirm), true);
		Assert.assertEquals(alertText.contains(yes), true);
		Assert.assertEquals(alertText.contains(no), true);

		}
	
	@Then("Admin should see a message {string} in program")
	public void admin_should_see_a_message_in_program(String details) {
		String dlt=programPage.alertpopdeletedetails();
		Assert.assertEquals(dlt,details);
	}
	@Given("Admin is on Confirm Deletion alert in program")
	public void admin_is_on_confirm_deletion_alert_in_program() {
	     programPage.clickdeleteprogram();
			genericUtils.SwitchWindowToChild();

	}

	@When("Admin clicks <YES> button on the alert in program")
	public void admin_clicks_yes_button_on_the_alert_in_program() {
		programPage.alertpopupayes();
	}

	@Then("Admin gets a message {string} alert and able to see that {string} deleted in the data table in program")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table_in_program(String success,String Name) throws IOException {
		
		String text1=programPage.alertpopdeletedetails();
		Assert.assertEquals(text1,success);
		boolean result = programPage.validatedltProgram(Name);
		Assert.assertEquals(result, false);}

		@When("Admin clicks <NO> button on the alert in program")
	public void admin_clicks_no_button_on_the_alert_in_program() {
		programPage.alertpopupano();
	}

	@Then("Admin can see the deletion alert disappears without deleting in program")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting_in_program() throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");

	}

	@When("Admin clicks Cancel or Close Icon on Deletion alert in program")
	public void admin_clicks_cancel_close_x_icon_on_deletion_alert_in_program() {
		programPage.alertpopupano();
 
	}

	@Then("Admin can see the deletion alert disappears without any changes in {string} in delete alert")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes_in_program(String Name) throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");
		boolean result = programPage.validatedltProgram(Name);
		Assert.assertEquals(result, true);}

	


//MULTIPLEDELETIONPROGRAM-SD
	@Given("Admin is on Manage Program page in program")
	public void admin_is_in_manage_program_page_in_program() throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");
	}

	@When("Admin clicks any checkbox in the data table in program")
	public void admin_clicks_any_checkbox_in_the_data_table_in_program() {
		programPage.clickAnyCheckbox();	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program_v() {
		programPage.checkheaderdlticon();
		}

	@Given("Admin clicks delete button under header after selecting the check box in the data table")
	public void admin_clicks_delete_button_under_header_after_selecting_the_check_box_in_the_data_table() {
		programPage.clickAnyCheckbox();
		programPage.click_headerdelete_icon();

	}

	@Then("Admin should land on Manage Program page and can see the selected program {string} is deleted from the data table in program")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table_in_program(String Name) throws IOException {

		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");
		boolean result = programPage.validatedltProgram(Name);
		Assert.assertEquals(result, false);
		}



	@Then("Admin should land on Manage Program page and can see the selected program {string} is not deleted from the data table in program")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table_in_program(String Name) throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");
		boolean result = programPage.validatedltProgram(Name);
		Assert.assertEquals(result, true);
	}

	@Given("Admin clicks delete button under header after selecting multiple checkboxes in the data table")
	public void admin_clicks_delete_button_under_header_after_selecting_multiple_checkboxes_in_the_data_table() {
		programPage.clickMultipleCheckbox();
		programPage.click_headerdelete_icon();
}

	@Then("Admin should land on Manage Program page and can see the selected programs are deleted {string} from the data table in program")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table_in_program(String Name1,String Name2) throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");
		boolean result = programPage.validatedltProgram(Name1);
		Assert.assertEquals(result, false);
		boolean result1 = programPage.validatedltProgram(Name2);
		Assert.assertEquals(result1, false);
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are not deleted {string} from the data table in program")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table_in_program(String Name1,String Name2) throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Manage program");
		boolean result = programPage.validatedltProgram(Name1);
		Assert.assertEquals(result, true);
		boolean result1 = programPage.validatedltProgram(Name2);
		Assert.assertEquals(result1, true);
	}

//SORTINGVALIDATION IN PROGRAM

	@When("Admin clicks the sort icon of program name column in program")
	public void admin_clicks_the_sort_icon_of_program_name_column_in_program() {
		programPage.prognameupsortclick();
		programPage.prognamedownsortclick();
	}

	@Then("The data get sorted on the table based on the program name column values in ascending order in program")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order_in_program() {
		programPage.datavalidationpgnameasc();
		}

	@Given("The data is in the ascending order on the table based on Program Name column in program")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column_in_program() {

		programPage.datavalidationpgnameasc();
	}

	@Then("The data get sorted on the table based on the program name column values in descending order in program")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order_in_program() {
		programPage.datavalidationpgnamedesc();}

	@When("Admin clicks the sort icon of program Desc column in program")
	public void admin_clicks_the_sort_icon_of_program_desc_column_in_program() {
		programPage.progdescupsortclick();
		programPage.progndescdownsortclick();}

	@Then("The data get sorted on the table based on the program description column values in ascending order in program")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order_in_program() {
		programPage.datavalidationprgdescasc();
	}

	@Given("The data is in the ascending order on the table based on Program Description column in program")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column_in_program() {
		programPage.datavalidationprgdescasc();
	}

	@Then("The data get sorted on the table based on the program description column values in descending order in program")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order_in_program() {
		programPage.datavalidationprgdescdesc();	
		}

	@When("Admin clicks the sort icon of program Status column in program")
	public void admin_clicks_the_sort_icon_of_program_status_column_in_program() {
		programPage.progstatusupsortclick();
		programPage.prognstatusdownsortclick();}

	@Then("The data get sorted on the table based on the program status column values in ascending order in program")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order_in_program() {
		programPage.datavalidationprgstatusasc();
	}

	@Given("The data is in the ascending order on the table based on Program Status column in program")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column_in_program() {
		programPage.datavalidationprgstatusasc();
	}

	@Then("The data get sorted on the table based on the program status column values in descending order in program")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order_in_program() {
		programPage.datavalidationprgstatusdesc();	}



//PAGINATIONIN PROGRAM
	@When("Admin clicks Next page link on the program table in program")
	public void admin_clicks_next_page_link_on_the_program_table_in_program() {
		programPage.nextpagelink();
	}

	@Then("Admin should see the Pagination has Next page in program")
	public void admin_should_see_the_pagination_has_link_in_program(String string) {
		programPage.nextpagedisplay();
	}

	@When("Admin clicks Last page link in program")
	public void admin_clicks_last_page_link_in_program() {
		programPage.lastpageclick();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled in program")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled_in_program() {
		programPage.lastpagerecord();
		programPage.paginataionsinglerightarrrowdisabled();}

	@When("Admin clicks First page link in program")
	public void admin_clicks_first_page_link_in_program() {
		programPage.startpageclick();
		programPage.firstpageclick();}

	@Then("Admin should see the current page record on the table with pagination has previous page link in program")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_in_program() {
		programPage.firstpagerecord();
		programPage.paginataionsingleleftarrrowdisabled();
	}

	@When("Admin clicks Start page link in program")
	public void admin_clicks_start_page_link_in_program() {
		programPage.startpageclick();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabledFeature: Pagination in program")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled_feature_pagination_in_program() {
		programPage.startpagerecord();
		programPage.paginataionsingleleftarrrowdisabled();

	}


//NAVIGATION IN PROGRAM

@When("Admin clicks on Student link on Manage Program page in program")
public void admin_clicks_on_student_link_on_manage_program_page_in_program(String student) {
	programPage.clicklinkondashboard(student);
}

@Then("Admin is re-directed to Student page in program")
public void admin_is_re_directed_to_student_page_in_program(String url) {
	String title="https://lms.app.com/Student program";
	 Assert.assertEquals(title.contains("student program"),url);
	 }

@When("Admin clicks on Batch link on Manage Program page in program")
public void admin_clicks_on_batch_link_on_manage_program_page_in_program(String batch) {
	programPage.clicklinkondashboard(batch); 
}

@Then("Admin is re-directed to Batch page in program")
public void admin_is_re_directed_to_batch_page_in_program(String url) {
	String title="https://lms.app.com/Batch program";
	 Assert.assertEquals(title.contains("Batch program"),url);

}

@When("Admin clicks on class link on Manage Program page in program")
public void admin_clicks_on_class_link_on_manage_program_page_in_program(String classlink) {
	programPage.clicklinkondashboard(classlink); 
 }

@Then("Admin is re-directed to class page in program")
public void admin_is_re_directed_to_class_page_in_program(String url) {
	String title="https://lms.app.com/Class program";
	 Assert.assertEquals(title.contains("Class program"),url);
}

@When("Admin clicks on user link on Manage Program page in program")
public void admin_clicks_on_user_link_on_manage_program_page_in_program(String user) {
	programPage.clicklinkondashboard(user); 
	}

@Then("Admin is re-directed to user page in program")
public void admin_is_re_directed_to_user_page_in_program(String url) {
	String title="https://lms.app.com/User program";
	 Assert.assertEquals(title.contains("User program"),url); 
}

@When("Admin clicks on Assignment link on Manage Program page in program")
public void admin_clicks_on_assignment_link_on_manage_program_page_in_program(String Assignment) {
	programPage.clicklinkondashboard(Assignment); 

}

@Then("Admin is re-directed to Assignment page in program")
public void admin_is_re_directed_to_assignment_page_in_program(String url) {
	String title="https://lms.app.com/Assignment program";
	 Assert.assertEquals(title.contains("Assignment program"),url); }

@When("Admin clicks on Attendance link on Manage Program page in program")
public void admin_clicks_on_attendance_link_on_manage_program_page_in_program(String Attendance) {
	programPage.clicklinkondashboard(Attendance); 

}

@Then("Admin is re-directed to Attendance page in program")
public void admin_is_re_directed_to_attendance_page_in_program(String url) {
	String title="https://lms.app.com/Attendance program";
	 Assert.assertEquals(title.contains("Attendance program"),url); }

@When("Admin clicks on Logout link on Manage Program page in program")
public void admin_clicks_on_logout_link_on_manage_program_page_in_program(String out) {
	programPage.clicklinkondashboard(out); 

}

@Then("Admin is re-directed to Login page in program")
public void admin_is_re_directed_to_login_page_in_program(String url) {
	String title="https://lms.app.com/Login";
	 Assert.assertEquals(title.contains("Login"),url); 
}


}
