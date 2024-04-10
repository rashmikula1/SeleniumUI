package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.ClassPage;
import utilities.LoggerLoad;
import utilities.TestBase;
import utilities.TestContextSetup;

public class ClassPageStepDefinition {

	TestContextSetup testContextSetup;
	TestBase testbase;
	ClassPage classPage;
	// PageObjectManager objectManager;

	public ClassPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.classPage = testContextSetup.pageObjectManager.getClassPage();
	}

	// Manage ClassPage Verification

	@Given("Admin  on the Browser")
	public void admin_on_the_browser() {
		classPage.Browser();

	}

	@When("Admin  enter the LMS url")
	public void admin_enter_the_lms_url() {
		classPage.URL();
	}

	@Then("Admin  is able to see LMS LoginPage")
	public void admin_is_able_to_see_lms_login_page() {
		classPage.LoginPagedisplay();

	}

	@Given("Admin on LoginPage header")
	public void admin_on_login_page_header() {
		classPage.Header();
	}

	@When("Admin  enter the {string} and {string}")
	public void admin_enter_the_and(String string, String string2) {
		classPage.LoginUserPass("UserName", "Password");
	}

	@When("Click the LoginButton")
	public void click_the_login_button() {
		classPage.Loginclick();
	}

	@Then("Admin  is able to see LMS Dashboard Page")
	public void admin_is_able_to_see_lms_dashboard_page() {
		classPage.DashboardPagedisplay();

	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		classPage.DashboardPagedisplay();
	}

	@When("Admin clicks {string} button on the navigation bar")
	public void admin_clicks_button_on_the_navigation_bar(String string) {
		classPage.appearonheading("Class");
	}

	@Then("Admin should see the \"Manage Class\"Page")
	public void admin_should_see_the_manage_class_page() {
		classPage.classmanagepage();
		LoggerLoad.info("Admin enter in to the MangeClassPage");
	}

	@Then("Get the response time for navigation from dashboard page to manage class page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_class_page() {
		classPage.ClassnavigationTime();
	}

	@Then("Admin should see header with {string}")
	public void admin_should_see_header_with(String string) {
		classPage.Manageclassheading("ManageClass");
	}

	@Then("Admin should see correct spelling for the all the fields") //
	public void admin_should_see_correct_spelling_for_the_all_the_fields() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see disabled delete icon below the {string}")
	public void admin_should_see_disabled_delete_icon_below_the(String string) {
		classPage.topleftdelete(string);
	}

	@Then("Admin should see search bar on the class page")
	public void admin_should_see_search_bar_on_the_class_page() {
		classPage.textsearch();
	}

	@Then("Admin should see +Add New Class button on the class page")
	public void admin_should_see_add_new_class_button_on_the_class_page() {
		classPage.Addnewprogram();
	}

	@Then("Admin should see data table on the Manage Class Page With following column headers.")
	public void admin_should_see_data_table_on_the_manage_class_page_with_following_column_headers(
			DataTable datatable) {

		List<List<String>> Addpage = datatable.asLists(String.class);
		for (List<String> a : Addpage) {
			// System.out.println(a);

			System.out.println(Addpage.get(0).get(0));// |Check box symbol|
			System.out.println(Addpage.get(0).get(1));// |Batch Id|
			System.out.println(Addpage.get(0).get(2));// |Class No|
			System.out.println(Addpage.get(0).get(3));// |Class Date|
			System.out.println(Addpage.get(0).get(4));// |Class Topic|
			System.out.println(Addpage.get(0).get(5));// |Staff Id|
			System.out.println(Addpage.get(0).get(6));// |Description|
			System.out.println(Addpage.get(0).get(7));// |Comments|
			System.out.println(Addpage.get(0).get(8));// |Notes|
			System.out.println(Addpage.get(0).get(9));// |Recording|
			System.out.println(Addpage.get(0).get(10));// |Edit|
			System.out.println(Addpage.get(0).get(11));// |Delete|
		}
	}

	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		classPage.Edit();
	}

	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		classPage.Rowdelete();
	}

	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
		classPage.BatchUPclick();
		classPage.BatchDOWNclick();
	}

	@Then("Admin should see check box in the all rows  of data table")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table() {
		classPage.SingleCheck();
	}

	@Then("Above the footer Admin should see the text as {string} in the table")
	public void above_the_footer_admin_should_see_the_text_as_in_the_table(String string) {
		classPage.Footerentery();
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		classPage.footerdisplay();
	}

	@Then("Admin should see the text with total number classes in the data table")
	public void admin_should_see_the_text_with_total_number_classes_in_the_data_table() {
		classPage.Footerentery();
	}

	@Given("Admin is on Manage Class Page")
	public void admin_is_on_manage_class_page() {
		classPage.classmanagepage();
	}

	@When("Admin enters batch id into search box")
	public void admin_enters_batch_id_into_search_box() {
		classPage.searchforBacthId();
	}

	@Then("Displays entries with that batch Id")
	public void displays_entries_with_that_batch_id() {
		classPage.BatchIddisplay();
	}

	@When("Admin enters batch id which is not existing the table into search box")
	public void admin_enters_batch_id_which_is_not_existing_the_table_into_search_box() {
		classPage.BatchIddisplay();
	}

	@Then("Displays empty details in the data table")
	public void displays_empty_details_in_the_data_table() {
		classPage.isItemPresentInTable(null, null);

	}

	@When("Admin enters class no into search box")
	public void admin_enters_class_no_into_search_box() {
		classPage.Noofclasses();
	}

	@Then("Displays entries with that class no")
	public void displays_entries_with_that_class_no() {
		classPage.searchforNoofClasses();
	}

	@When("Admin enters class no which is not existing the table into search box")
	public void admin_enters_class_no_which_is_not_existing_the_table_into_search_box() {
		classPage.isItemPresentInTable(null, null);
	}

	@When("Admin enters class topic into search box")
	public void admin_enters_class_topic_into_search_box() {
		classPage.ClassTopic();
	}

	@Then("Displays entries with that  class topic")
	public void displays_entries_with_that_class_topic() {
		classPage.ClassTopicdisplay();
	}

	@When("Admin enters class topic which is not existing the table into search box")
	public void admin_enters_class_topic_which_is_not_existing_the_table_into_search_box() {
		classPage.isItemPresentInTable(null, null);
	}

	@When("Admin enters staff id into search box")
	public void admin_enters_staff_id_into_search_box() {
		classPage.searchStaffId();
	}

	@Then("Displays entries with that  staff id")
	public void displays_entries_with_that_staff_id() {
		classPage.StaffIddisplay();
	}

	@When("Admin enters staff id which is not existing the table into search box")
	public void admin_enters_staff_id_which_is_not_existing_the_table_into_search_box() {
		classPage.isItemPresentInTable(null, null);
	}

	@When("Admin enters class date into search box")
	public void admin_enters_class_date_into_search_box() {
		classPage.searchclassDate();
	}

	@Then("Displays entries with that  class date")
	public void displays_entries_with_that_class_date() {
		classPage.ClassDatedisplay();
	}

	@When("Admin enters invalid class date into search box") //
	public void admin_enters_invalid_class_date_into_search_box() {

	}
//Class detail Popup Window verification

	@Given("Admin navigate to the Manage class Page")
	public void admin_navigate_to_the_manage_class_page() {
		classPage.classmanagepage();
	}

	@When("Admin click +Add New Class button")
	public void admin_click_add_new_class_button() {
		classPage.Addnewprogram();
	}

	@Then("Admin should see a popup  with  heading {string}")
	public void admin_should_see_a_popup_with_heading(String string) {
		classPage.PopupAddpage(string, string);
	}

	@Then("Admin should see input fields Text \\(Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)")
	public void admin_should_see_input_fields_text_batch_id_no_of_classes_class_date_class_topic_staff_id_class_description_comments_notes_recordings() {
		String message = classPage.appearonheading("Class");
		// Assert.assertEquals(message, "Class");
		Assert.assertTrue(message.equals("DashboardPage"));

	}

	@Then("Multiple textbox should be  present in Class details popup window")
	public void multiple_textbox_should_be_present_in_class_details_popup_window() {
		classPage.MultipleCheckintabledisplay();
	}

	@Then("Admin should see  dropdown option for Batch ID")
	public void admin_should_see_dropdown_option_for_batch_id() {
		classPage.dropdownBatchID();
	}

	@Then("Admin should see  dropdown option for Staff Id")
	public void admin_should_see_dropdown_option_for_staff_id() {
		classPage.StaffID();
	}

	@Then("Admin should see  calendar icon for class date")
	public void admin_should_see_calendar_icon_for_class_date() {
		classPage.Date();
	}

	@Then("Admin should see  save button in the class detail popup window")
	public void admin_should_see_save_button_in_the_class_detail_popup_window() {
		classPage.savebutton();
	}

	@Then("Admin should see  cancel button in the class detail popup window")
	public void admin_should_see_cancel_button_in_the_class_detail_popup_window() {
		classPage.cancel();
	}

	@Then("Admin should see  close button on the class details popup window")
	public void admin_should_see_close_button_on_the_class_details_popup_window() {
		classPage.Clickable();
	}
	// Add New Class

	@Given("Admin is in  class detail popup window")
	public void admin_is_in_class_detail_popup_window() {
		classPage.PopupAddpage("ClassPageaddpage", "newAddPage");
	}

	@When("Admin clicks  Batch ID dropdown")
	public void admin_clicks_batch_id_dropdown() {
		classPage.dropdownBatchID();
	}

	@Then("Batch id in the drop down should match with Batch id manage batch page table")
	public void batch_id_in_the_drop_down_should_match_with_batch_id_manage_batch_page_table() {
		classPage.BatchIDcompare();
	}

	@When("Admin enters values in all fields with valid data and clicks save button")
	public void admin_enters_values_in_all_fields_with_valid_data_and_clicks_save_button() {
		classPage.savebutton();
	}

	@Then("Admin should see new class details is added in the data table")
	public void admin_should_see_new_class_details_is_added_in_the_data_table(DataTable dataTable) {

		List<List<String>> newclassAddpage = dataTable.asLists(String.class);
		for (List<String> a : newclassAddpage) {
			System.out.println(a);
		}
	}

	@When("Admin enters all mandatory field values with valid data and clicks save button \\( Batch ID , No of Classes, Class Date, Staff Id)")
	public void admin_enters_all_mandatory_field_values_with_valid_data_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id() {
		classPage.dropdownBatchID();
		classPage.Noofclasses();
		classPage.Date();
		classPage.dropdownstaffID();
		classPage.savebutton();
	}

	@When("Admin enters all mandatory field values with valid data and clicks save button")
	public void admin_enters_all_mandatory_field_values_with_valid_data_and_clicks_save_button(DataTable validdata) {

		List<List<String>> valid = validdata.asLists(String.class);
		for (List<String> a : valid) {
			System.out.println(a);
		}
		classPage.savebutton();
	}

	@When("Admin enters all mandatory field values with invalid data and clicks save button")
	public void admin_enters_all_mandatory_field_values_with_invalid_data_and_clicks_save_button(DataTable invalid) {

		List<List<String>> invaliddata = invalid.asLists(String.class);
		for (List<String> a : invaliddata) {
			System.out.println(a);
		}

		classPage.savebutton();
	}

	@Then("Error message should appear in alert")
	public void error_message_should_appear_in_alert() {
		classPage.alert(null);
	}

	@When("Admin enters with invalid data in optional fields and clicks save button \\( Class Topic,Class description, Comments, Notes, Recordings)")
	public void admin_enters_with_invalid_data_in_optional_fields_and_clicks_save_button_class_topic_class_description_comments_notes_recordings() {
		classPage.Missingvalue();
		classPage.savebutton();
	}

	@When("Admin enters  data missing value in Batch ID and clicks save button \\(No of Classes, Class Date, Staff Id)")
	public void admin_enters_data_missing_value_in_batch_id_and_clicks_save_button_no_of_classes_class_date_staff_id() {
		classPage.MissingvalueMandatory();
		classPage.savebutton();
	}

	@Then("Batch Id is missing")
	public void batch_id_is_missing() {
		classPage.MissingvalueMandatory();
	}

	@When("Admin enters data missing value in No of class and clicks save button \\(Batch ID ,  Class Date, Staff Id, )")
	public void admin_enters_data_missing_value_in_no_of_class_and_clicks_save_button_batch_id_class_date_staff_id() {
		classPage.Missingvalue();
	}

	@Then("No of classes is missing")
	public void no_of_classes_is_missing() {
		classPage.Missingvalue();
	}

	@When("Admin enters data missing value in  class date and clicks save button \\(Batch ID , No of Classes, Staff Id, )")
	public void admin_enters_data_missing_value_in_class_date_and_clicks_save_button_batch_id_no_of_classes_staff_id() {
		classPage.MissingvalueMandatory();
	}

	@Then("class date is missing")
	public void class_date_is_missing() {
		classPage.MissingvalueMandatory();
	}

	@When("Admin enters data missing value in staff id and clicks save button \\(Batch ID , No of Classes, Class Date )")
	public void admin_enters_data_missing_value_in_staff_id_and_clicks_save_button_batch_id_no_of_classes_class_date() {
		classPage.MissingvalueMandatory();
		classPage.savebutton();
	}

	@Then("staff id is missing")
	public void staff_id_is_missing() {
		classPage.MissingvalueMandatory();

	}

	@When("Admin enters passed date in the class date field and clicks save button \\( Batch ID , No of Classes, Class Date, Staff Id)")
	public void admin_enters_passed_date_in_the_class_date_field_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id() {
		classPage.futuredate();
		classPage.savebutton();
	}

	@Then("class cannot be  created for the passed date and error message come.")
	public void class_cannot_be_created_for_the_passed_date_and_error_message_come() {
		classPage.alert();
	}

	@When("Admin clicks date from date picker")
	public void admin_clicks_date_from_date_picker() {
		classPage.datePicker();
	}

	@Then("selected date should be their in class date text box")
	public void selected_date_should_be_their_in_class_date_text_box() {
		classPage.Date();
	}

	@Then("selected date should be in  mm\\/dd\\/yyyy format")
	public void selected_date_should_be_in_mm_dd_yyyy_format() {
		classPage.Dateformat();
	}

	@When("Admin clicks right arrow in the date picker near month")
	public void admin_clicks_right_arrow_in_the_date_picker_near_month() {
		classPage.DateRightclick();
	}

	@Then("Next month calender should visible")
	public void next_month_calender_should_visible() {
		classPage.nextmonth();
	}

	@When("Admin clicks left arrow in the date picker near month")
	public void admin_clicks_left_arrow_in_the_date_picker_near_month() {
		classPage.DateLeftclick();
	}

	@Then("previous month calender should visible")
	public void previous_month_calender_should_visible() {
		classPage.previousmonth();

	}

	@When("Admin clicks date picker button")
	public void admin_clicks_date_picker_button() {
		classPage.datePicker();
	}

	@Then("Admin should see current date is highled in the date picker")
	public void admin_should_see_current_date_is_highled_in_the_date_picker() {
		classPage.HightlightValidation();
	}

	@When("Admin clicks date picker button and selects future date")
	public void admin_clicks_date_picker_button_and_selects_future_date() {
		classPage.futuredate();
	}

	@Then("Admin should see selected date is highled in the date picker")
	public void admin_should_see_selected_date_is_highled_in_the_date_picker() {
		classPage.HightlightValidation();
	}

	@When("Admin clicks Cancel button without entering values in the fields")
	public void admin_clicks_cancel_button_without_entering_values_in_the_fields() {
		classPage.cancel();
	}

	@Then("Admin should land on Manage Class page")
	public void admin_should_land_on_manage_class_page() {
		classPage.classmanagepage();

	}

	@When("Admin clicks Cancel button entering values in the fields")
	public void admin_clicks_cancel_button_entering_values_in_the_fields() {
		classPage.cancel();
	}

	@Then("Admin should land on Manage Class Page and validate new class is not created in the data table")
	public void admin_should_land_on_manage_class_page_and_validate_new_class_is_not_created_in_the_data_table() {
		classPage.classmanagepage();
	}

//EditClass Validation

	@Given("Admin is in Manage class page")
	public void admin_is_in_manage_class_page() {
		classPage.classmanagepage();
	}

	@When("Admin clicks Edit button in data table")
	public void admin_clicks_edit_button_in_data_table() {
		classPage.Edit();
	}

	@Then("Edit popup window appears with heading Class Details")
	public void edit_popup_window_appears_with_heading_class_details() {
		classPage.PopupEditpage("ClassPageEditPage", "EditNewClass");
	}

	@When("Admin clicks Edit button from one of the row in data table")
	public void admin_clicks_edit_button_from_one_of_the_row_in_data_table() {
		classPage.Edit();
	}

	@Then("Edit popup window appears with same row values in the all fields")
	public void edit_popup_window_appears_with_same_row_values_in_the_all_fields() {
		classPage.Edit();
	}

	@Given("Admin is in  Edit class detail popup window")
	public void admin_is_in_edit_class_detail_popup_window() {
		classPage.PopupEditpage("ClassPageEditPage", "EditNewClass");
	}

	@Then("Admin should see particular class details is updated in the data table")
	public void admin_should_see_particular_class_details_is_updated_in_the_data_table() {
		classPage.Classwebtable();
	}

	@When("Admin enters with invalid data in optional fields and clicks save button \\( Batch ID , No of Classes, Class Date, Staff Id)")
	public void admin_enters_with_invalid_data_in_optional_fields_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id() {
		classPage.savebutton();
	}

	@Then("class cannot be updated for the passed date and through error message.")
	public void class_cannot_be_updated_for_the_passed_date_and_through_error_message() {
		classPage.alert();
	}

	@Then("Admin should land on Manage Class Page and validate particular class details are not changed  in the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_not_changed_in_the_data_table() {
		classPage.classmanagepage();
	}

//Delete ClassValidation

	@When("Admin clicks delete button in data table row level")
	public void admin_clicks_delete_button_in_data_table_row_level() {
		classPage.Rowdelete();
	}

	@Then("Admin should see alert")
	public void admin_should_see_alert() {
		classPage.deletealert();

	}

	@Then("Alert should have {string} button to reject")
	public void alert_should_have_button_to_reject(String string) {
		classPage.cancel();
	}

	@Given("Admin is in delete alert")
	public void admin_is_in_delete_alert() {
		classPage.deletealert();
	}

	@When("Admin clicks yes button")
	public void admin_clicks_yes_button() {
		classPage.DeleteYes();
	}

	@Then("Success message and validate particular class details are deleted from the data table")
	public void success_message_and_validate_particular_class_details_are_deleted_from_the_data_table() {
		classPage.deletemessage();
	}

	@When("Admin clicks no button")
	public void admin_clicks_no_button() {
		classPage.DeleteNo();
	}

	@Then("Admin should land on manage class page and validate particular class details are not deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_not_deleted_from_the_data_table() {

		classPage.classmanagepage();
		classPage.deletemessage();
	}

//Delete Multiple Class Validation

	@When("Admin clicks single  row level check box in the data table")
	public void admin_clicks_single_row_level_check_box_in_the_data_table() {
		classPage.clickFirstRowCheckbox();
	}

	@Then("Admin should see delete icon below the header is enabled")
	public void admin_should_see_delete_icon_below_the_header_is_enabled() {
		classPage.isHeaderDeleteEnabled();
	}

	@Then("Admin should see tick mark in check box")
	public void admin_should_see_tick_mark_in_check_box() {
		classPage.SingleCheck();
	}

	@When("Admin clicks multiple row level check box in the data table")
	public void admin_clicks_multiple_row_level_check_box_in_the_data_table() {
		classPage.clickMultipleCheckbox();
	}

	@Then("Admin should see tick mark in check box  of the selected rows")
	public void admin_should_see_tick_mark_in_check_box_of_the_selected_rows() {
		classPage.MultipleCheckintabledisplay();
	}

	@When("Admin clicks No button")
	public void admin_clicks_No_button() {
		classPage.DeleteNo();
	}

//Verify SortfunctionClassPage

	@Then("Admin should land on manage class page and validate particular class details are deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_deleted_from_the_data_table() {
		classPage.classmanagepage();
	}

	@When("Admin click on Batch id column header to sort")
	public void admin_click_on_batch_id_column_header_to_sort() {
		classPage.BatchDOWNclick();
	}

	@Then("Admin should see data table sorted in descending order")
	public void admin_should_see_data_table_sorted_in_descending_order() {
		classPage.BatchIddescorder();
	}

	@When("Admin double click on Batch id column header to sort")
	public void admin_double_click_on_batch_id_column_header_to_sort() {
		classPage.BatchUPclick();
	}

	@Then("Admin should see data table sorted in ascending  order")
	public void admin_should_see_data_table_sorted_in_ascending_order() {
		classPage.BatchIdascorder();
	}

//Pagination

	@Then("Data table should display {int} page  when entries available")
	public void data_table_should_display_page_when_entries_available(Integer int1) {
		classPage.firstpagecount();
	}

	@Then("Right arrow should be enabled in page one  when entries are more than {int} available")
	public void right_arrow_should_be_enabled_in_page_one_when_entries_are_more_than_available(Integer int1) {
		classPage.checkrightarrow();
	}

	@Then("Left arrow should be disabled in page one  when entries are more than {int} available")
	public void left_arrow_should_be_disabled_in_page_one_when_entries_are_more_than_available(Integer int1) {
		classPage.checkleftarrow();
	}

	@Then("Right arrow should be enabled in page two when entries are more than {int} available")
	public void right_arrow_should_be_enabled_in_page_two_when_entries_are_more_than_available(Integer int1) {
		classPage.checkRightArrow2Page_Pagination_enable();
	}

	@Then("Left arrow should be enabled in page two")
	public void left_arrow_should_be_enabled_in_page_two() {
		classPage.checkLeftArrow2Page_Pagination_enable();
	}

	@Then("Data table should display  page {int} on entries available")
	public void data_table_should_display_page_on_entries_available(Integer int1) {
		classPage.firstpagecount();
	}

	@Then("entering more than {int} in data table pagination controls enabled")
	public void entering_more_than_in_data_table_pagination_controls_enabled(Integer int1) {
		classPage.pagination_disable();
	}

	@Then("entering less than {int} in data table pagination controls disabled")
	public void entering_less_than_in_data_table_pagination_controls_disabled(Integer int1) {
		classPage.pagination_disable();
	}

	@Given("Admin is in add class details popup window")
	public void admin_is_in_add_class_details_popup_window() {
		classPage.PopupAddpage("ClassPageAddPage", "AddNewPage");
	}

	@When("Admin creates {int} new class")
	public void admin_creates_new_class(Integer int1) {
		classPage.Addnewprogram();
	}

	@Then("entering total class entries above {int} next page is enabled \\( On multiples of {int} new page will be enabled)")
	public void entering_total_class_entries_above_next_page_is_enabled_on_multiples_of_new_page_will_be_enabled(
			Integer int1, Integer int2) {
		classPage.checkrightarrow();
	}

	@When("Admin creates less than or equal to {int} new class")
	public void admin_creates_less_than_or_equal_to_new_class(Integer int1) {
		classPage.pagination_disable();
	}

	@Then("entering total class entries  {int} or below next page is disabled")
	public void entering_total_class_entries_or_below_next_page_is_disabled(Integer int1) {
		classPage.checkleftarrow();
	}

//Navigation from class Page to other pages

	@When("Admin clicks {string} button in the navigation bar")
	public void admin_clicks_button_in_the_navigation_bar(String string) {
		classPage.clicklinkondashboard(string);
	}

	@Then("Admin should able to land on student page")
	public void admin_should_able_to_land_on_student_page() {
		classPage.clicklinkondashboard("Student");
	}

	@Then("Admin should able to land on program page")
	public void admin_should_able_to_land_on_program_page() {
		classPage.clicklinkondashboard("Program");
	}

	@Then("Admin should able to land on batch page")
	public void admin_should_able_to_land_on_batch_page() {
		classPage.clicklinkondashboard("batch");
	}

	@Then("Admin should able to land on user page")
	public void admin_should_able_to_land_on_user_page() {
		classPage.clicklinkondashboard("User");
	}

	@Then("Admin should able to land on Assignment page")
	public void admin_should_able_to_land_on_assignment_page() {
		classPage.clicklinkondashboard("Assignment");
	}

	@Then("Admin should able to land on Attendance page")
	public void admin_should_able_to_land_on_attendance_page() {
		classPage.clicklinkondashboard("Attendance");
	}

	@Then("Admin should able to land on login page")
	public void admin_should_able_to_land_on_login_page() {
		classPage.clicklinkondashboard("Login");
	}

}