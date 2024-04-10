package stepdefinitions;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AttendancePage;
import pages.ClassPage;
import pages.LoginPage;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class AttendancePageStepDefinition {
	AttendancePage attendancePage;
	public WebDriver driver;
	TestContextSetup testContextSetup;
	LoginPage loginPage;
	
	public AttendancePageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.attendancePage =testContextSetup.pageObjectManager.getAttendancePage(); //initialize object because constructor executes first before all methods
		
	}
	
	//1.Manage Attendance 
	

	@Given("Logged on the LMS portal as Admin")
	public void logged_on_the_lms_portal_as_admin() {
		
	   loginPage.enterCredentials("Rashmi", "Rashmi!1");
	   loginPage.clickOnlogInBtn();
	}
	@Given("Admin is on dashboard page after Login in attendance")
	public void admin_is_on_dashboard_page_after_login_in_attendance() {
		attendancePage.verifyDashboard();
	}
	
	@When("Admin clicks {string} on the navigation bar in attendance")
	public void admin_clicks_on_the_navigation_bar_in_attendance(String string) {
	    attendancePage.clickAttendance();
	}
	
	@Then("Admin should see the Manage attendance in header in attendance")
	public void admin_should_see_the_manage_attendance_in_header_in_attendance() {
	    attendancePage.verifyManageAttendance();
	    LoggerLoad.info("User is in Manage Attendance page");
	}
	
	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds in attendance")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds_in_attendance(Integer int1) {
	    attendancePage.navigationTime();
	}

	@Then("HTTP response >= {int} then the link is broken in attendance")
	public void http_response_then_the_link_is_broken_in_attendance(Integer int1) throws IOException {
	   attendancePage.verifyBrokenLink();
	  
	}
	
	@Then("Admin should see LMS -Learning Management System  as title in attendance")
	public void admin_should_see_lms_learning_management_system_as_title_in_attendance() {
	  String lmstitle= attendancePage.pageTitle();
	  Assert.assertEquals(lmstitle, "LMS -Learning Management System");
	   
	}
	
	@Then("Manage attendance header should be in left side of the page in attendance")
	public void manage_attendance_header_should_be_in_left_side_of_the_page_in_attendance() {
	    attendancePage.isleftAligned();
	}
	@When("Admin get all text from the portal page in attendance")
	public void admin_get_all_text_from_the_portal_page_in_attendance() {
	   attendancePage.getStrings();
	}
	
	@Then("Admin should see correct spelling for the all the fields in attendance")
	public void admin_should_see_correct_spelling_for_the_all_the_fields_in_attendance() {
		attendancePage.spellingCheck();		
	}
	
	@Then("Admin should see disabled delete icon below the {string} in attendance")
	public void admin_should_see_disabled_delete_icon_below_the_in_attendance(String string) {
	    attendancePage.isDeleteIconDisabled();
	}
	
	@Then("Admin should see search bar on the attendance page in attendance")
	public void admin_should_see_search_bar_on_the_attendance_page_in_attendance() {
	    attendancePage.isSearchPresent();
	}
	
	@Then("Admin should see +Add New Attendance button on the attendance page in attendance")
	public void admin_should_see_add_new_attendance_button_on_the_attendance_page_in_attendance() {
	    attendancePage.isAddNewAttendancePresent();
	}
	
	@Then("Admin should see data table on the Manage Attendance Page With following {string} in attendance")
	public void admin_should_see_data_table_on_the_manage_attendance_page_with_following_in_attendance(String string) {
	    attendancePage.isDatatableDisplayed();
	}
	
	@Then("Edit Icon in each row of data table only when entries are available in attendance")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available_in_attendance() {
	    attendancePage.isEditIconPresent();
	}
	
	@Then("Edit Icon will not be present in data table in attendance")
	public void edit_icon_will_not_be_present_in_data_table_in_attendance() {
	    attendancePage.isEditNotPresent();
	}
	
	@Then("Delete Icon in each row of data table only  when entries are available in attendance")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available_in_attendance() {
	    attendancePage.isDeleteIconPresent();
	}
	
	@Then("Admin cant see delete  Icon in data table in attendance")
	public void admin_cant_see_delete_icon_in_data_table_in_attendance() {
	    attendancePage.isDeleteNotPresent();
	}
	
	@Then("Admin should see sort icon near the column headers except for Edit and Delete in attendance")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete_in_attendance() {
	   attendancePage.isSortPresent();
	}
	
	@Then("Admin should see check box in the all rows  of data table in attendance")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table_in_attendance() {
	    attendancePage.isCheckboxPresent();
	}
	
	@Then("Above the footer Admin should see the text as {string} below the table in attendance")
	public void above_the_footer_admin_should_see_the_text_as_below_the_table_in_attendance(String string) {
	   attendancePage.showDatatableEntries();
	}

	@Then("Admin should see the pagination controls under the data table in attendance")
	public void admin_should_see_the_pagination_controls_under_the_data_table_in_attendance() {
	    attendancePage.isPagination();
	}
	
	@Then("Admin should see the text with total number attendances in the data table in attendance")
	public void admin_should_see_the_text_with_total_number_attendances_in_the_data_table_in_attendance() {
	   attendancePage.verifyFooterEntries();
	}
	
	
	//2. Attendance Details
	
	@Given("Admin is in manage attendance page")
	public void admin_is_in_manage_attendance_page() {
	    attendancePage.verifyManageAttendance();
	}
	
	@When("Admin clicks {string} button in attendance page")
	public void admin_clicks_button_in_attendance_page(String string) {
	    attendancePage.clickNewAttendance();
	}
	
	@Then("Admin should see correct spellings in the label on attendance details popup")
	public void admin_should_see_correct_spellings_in_the_label_on_attendance_details_popup() {
	    attendancePage.correctSpelling();
	}
	
	@Then("{string} dropdown should be present on attendance details popup")
	public void dropdown_should_be_present_on_attendance_details_popup(String string) {
		int num=attendancePage.dropdownCount();
		Assert.assertEquals(num, string);
	}
	
	@Then("Admin  should see text in gray color in dropdown on attendance details popup")
	public void admin_should_see_text_in_gray_color_in_dropdown_on_attendance_details_popup() {
		String txtclr=attendancePage.getTextColor();
		Assert.assertEquals(txtclr, "gray");
	}
	
	@Then("Close button should on the top right corner on attendance details popup")
	public void close_button_should_on_the_top_right_corner_on_attendance_details_popup() {
	    attendancePage.closeRightTopAligned();
	}
	@Then("Admin should see save button on attendance details popup")
	public void admin_should_see_save_button_on_attendance_details_popup() {
	    attendancePage.saveBtn();
	}
	@Then("Third dropdown box {string} text should be present on attendance details popup")
	public void third_dropdown_box_text_should_be_present_on_attendance_details_popup(String string) {
		String s=attendancePage.thirdDropdownText();
	    Assert.assertEquals(s, string);
	}
	
	@Then("Second dropdown box {string} text should be present on attendance details popup")
	public void second_dropdown_box_text_should_be_present_on_attendance_details_popup(String string) {
		String s=attendancePage.secondDropdownText();
	    Assert.assertEquals(s, string);
	}
	
	
	@Then("Order of the label should be Program name, Class Name, Student Name, Attendance, Attendance Date on attendance details popup")
	public void order_of_the_label_should_be_program_name_class_name_student_name_attendance_attendance_date_on_attendance_details_popup() {
	    attendancePage.orderofLabels();
	}
	@Then("Admin should see  cancel button on attendance details popup")
	public void admin_should_see_cancel_button_on_attendance_details_popup() {
	    attendancePage.cancelBtn();
	}
	@Then("Admin should see  close button on the attendance details popup window")
	public void admin_should_see_close_button_on_the_attendance_details_popup_window() {
	   attendancePage.closeBtn();
	}
	
	@Then("Fourth dropdown box {string} text should be present on attendance details popup")
	public void fourth_dropdown_box_text_should_be_present_on_attendance_details_popup(String string) {
		String s=attendancePage.fourthDropdownText();
	    Assert.assertEquals(s, string);
	}
	
	
	@Then("First dropdown box {string} text should be present on attendance details popup")
	public void first_dropdown_box_text_should_be_present_on_attendance_details_popup(String string) {
	    String s=attendancePage.firstDropdownText();
	    Assert.assertEquals(s, string);
	}
	
	
	//3. Attendance popup verification
	
	@Given("Admin is in attendance details popup window")
	public void admin_is_in_attendance_details_popup_window() {
		testContextSetup.genericUtils.SwitchWindowToChild();
	    attendancePage.isOnAttendanceDetailsPopup();
	}
	
	@Then("Admin should see correct spellings in dropdown text in attendance details popup")
	public void admin_should_see_correct_spellings_in_dropdown_text_in_attendance_details_popup() {
	    attendancePage.verifyCorrectSpellinginDropDown();
	}
	@When("Admin clicks left arrow in the date picker near month in attendance details popup")
	public void admin_clicks_left_arrow_in_the_date_picker_near_month_in_attendance_details_popup() {
	    attendancePage.clickLeftArrow();
	}
	@Then("previous month calender should visible in attendance details popup")
	public void previous_month_calender_should_visible_in_attendance_details_popup() {
	   attendancePage.previousMonth();
	}
	
	@When("Admin clicks attendance dropdown in attendance details popup")
	public void admin_clicks_attendance_dropdown_in_attendance_details_popup() {
	   attendancePage.clickAttendanceDropdown();
	}
	@Then("Attendance field should have keywords such as present, absent, late, excused in attendance details popup")
	public void attendance_field_should_have_keywords_such_as_present_absent_late_excused_in_attendance_details_popup() {
	    attendancePage.verifyAttendanceFields();
	}
	
	
	@When("Admin clicks program name dropdown in attendance details popup")
	public void admin_clicks_program_name_dropdown_in_attendance_details_popup() {
	   attendancePage.clickProgramNameDropdown();
	}
	@Then("Program Name in the drop down should match with program name in manage program page table in attendance details popup")
	public void program_name_in_the_drop_down_should_match_with_program_name_in_manage_program_page_table_in_attendance_details_popup() {
		String dropdownClassName=attendancePage.getDropdownProgramName();
		Assert.assertEquals(dropdownClassName, testContextSetup.listofprogramname);
	}
	
	@When("Admin clicks date picker button in attendance details popup")
	public void admin_clicks_date_picker_button_in_attendance_details_popup() {
	   attendancePage.clickDatePicker();
	}
	@Then("Admin should see current date is highlighted in the date picker in attendance details popup")
	public void admin_should_see_current_date_is_highlighted_in_the_date_picker_in_attendance_details_popup() {
	   attendancePage.isSelectedDatePresent();
	}

	@When("Admin clicks date picker button and selects future date in attendance details popup")
	public void admin_clicks_date_picker_button_and_selects_future_date_in_attendance_details_popup() {
	    attendancePage.futureDate();
	}
	@Then("Admin should see selected date is highlighted in the date picker in attendance details popup")
	public void admin_should_see_selected_date_is_highlighted_in_the_date_picker_in_attendance_details_popup() {
	    attendancePage.isSelectedDatePresent();
	}
	
	@Then("selected date should be in  mm\\/dd\\/yyyy format in attendance details popup")
	public void selected_date_should_be_in_mm_dd_yyyy_format_in_attendance_details_popup() {
	    attendancePage.dateFormat();
	}
	@When("Admin clicks class name dropdown in attendance details popup")
	public void admin_clicks_class_name_dropdown_in_attendance_details_popup() {
	   attendancePage.clickClassNameDropdown();
	}
	@Then("Class Name in the drop down should match with class name in manage class page table in attendance details popup")
	public void class_name_in_the_drop_down_should_match_with_class_name_in_manage_class_page_table_in_attendance_details_popup() {
		String dropdownClassName=attendancePage.getDropdownClassName();
		Assert.assertEquals(dropdownClassName, testContextSetup.Listclasstopic);
	}
	
	@When("Admin clicks right arrow in the date picker near month in attendance details popup")
	public void admin_clicks_right_arrow_in_the_date_picker_near_month_in_attendance_details_popup() {
	   attendancePage.clickRightArrow();
	}
	@Then("Next month calender should visible in attendance details popup")
	public void next_month_calender_should_visible_in_attendance_details_popup() {
	    attendancePage.nextMonth();
	}
	
	@When("Admin clicks date from date picker in attendance details popup")
	public void admin_clicks_date_from_date_picker_in_attendance_details_popup() {
	    attendancePage.clickDatePicker();
	}
	@Then("selected date should be there in attendance date text box in attendance details popup")
	public void selected_date_should_be_there_in_attendance_date_text_box_in_attendance_details_popup() {
	    attendancePage.isSelectedDatePresent();
	}
	
	
	//4. AddEditAttendance
	
	@When("Admin fills values with future date  and click save in attendance details popup")
	public void admin_fills_values_with_future_date_and_click_save_in_attendance_details_popup() {
	    attendancePage.selectFutureDateAndSave();
	}
	
	@Then("Invalidate attendance date error in attendance")
	public void invalidate_attendance_date_error_in_attendance() {
		String message= attendancePage.GetErrorMsg();
	    Assert.assertTrue(message.equals("Invalidate attendance date error"));
	}
	@When("Admin fills values missing student name and click save in attendance details popup")
	public void admin_fills_values_missing_student_name_and_click_save_in_attendance_details_popup() {
		attendancePage.missingStudentNameAndSave();
	}
	@Then("student name is missing error in attendance")
	public void student_name_is_missing_error_in_attendance() {
		String message= attendancePage.GetErrorMsg();
	    Assert.assertTrue(message.equals("Student name is missing"));
	}
	
	@When("Admin fills values missing attendance date and click save in attendance details popup")
	public void admin_fills_values_missing_attendance_date_and_click_save_in_attendance_details_popup() {
	    attendancePage.missingAttendanceDateAndSave();
	}
	@Then("Attendance date is missing error in attendance")
	public void attendance_date_is_missing_error_in_attendance() {
		String message= attendancePage.GetErrorMsg();
	    Assert.assertTrue(message.equals("Student name is missing"));
	}
	
	@When("Admin creates less than or equal to {int} new attendance data")
	public void admin_creates_less_than_or_equal_to_new_attendance_data(Integer int1) {
	    attendancePage.isNextPageDisabled();
	}
	@Then("when total attendance entries {int} or below next page is disabled in attendance")
	public void when_total_attendance_entries_or_below_next_page_is_disabled_in_attendance(Integer int1) {
		attendancePage.fillAllValuesAndSave();
		attendancePage.fillAllValuesAndSave();
		attendancePage.fillAllValuesAndSave();
		attendancePage.fillAllValuesAndSave();
	}
	
	@When("Admin creates {int} new attendance in attendance page")
	public void admin_creates_new_attendance_in_attendance_page(Integer int1) {
	   attendancePage.fillAllValuesAndSave();
	   attendancePage.fillAllValuesAndSave();
	   attendancePage.fillAllValuesAndSave();
	   attendancePage.fillAllValuesAndSave();
	   attendancePage.fillAllValuesAndSave();
	   attendancePage.fillAllValuesAndSave();
	}
	@Then("when total attendance entries are above {int} next page is enabled in attendancce")
	public void when_total_attendance_entries_are_above_next_page_is_enabled_in_attendancce(Integer int1) {
	   attendancePage.isNextPageEnabled();
	}

	
	@When("Admin fills all the values and click save in attendance details popup")
	public void admin_fills_all_the_values_and_click_save_in_attendance_details_popup() {
		attendancePage.fillAllValuesAndSave();
	 
	}
	@Then("Admin should see success message in popup window and sees new attendance details in manage attendance details database")
	public void admin_should_see_success_message_in_popup_window_and_sees_new_attendance_details_in_manage_attendance_details_database() {
	   String message= attendancePage.getSuccessMsg();
	   Assert.assertTrue(message.equals("Attendance Details successfully added"));
	}
	
	
	@When("Admin fills values missing class name and click save in attendance details popup")
	public void admin_fills_values_missing_class_name_and_click_save_in_attendance_details_popup() {
	   attendancePage.missingClassNameAndSave();
	}
	@Then("class name is missing error in attendance")
	public void class_name_is_missing_error_in_attendance() {
		String message= attendancePage.GetErrorMsg();
	    Assert.assertTrue(message.equals("Class name is missing"));
	}
	
	@When("Admin fills values missing attendance and click save in attendance details popup")
	public void admin_fills_values_missing_attendance_and_click_save_in_attendance_details_popup() {
	    attendancePage.missingAttendanceAndSave();
	}
	@Then("Attendance is missing error in attendance")
	public void attendance_is_missing_error_in_attendance() {
		String message= attendancePage.GetErrorMsg();
	    Assert.assertTrue(message.equals("Attendance is missing"));
	}

	@When("Admin fills values missing program name and click save in attendance details popup")
	public void admin_fills_values_missing_program_name_and_click_save_in_attendance_details_popup() {
	   attendancePage.missingProgramNameAndSave();
	}
	@Then("Program name is missing error in attendance")
	public void program_name_is_missing_error_in_attendance() {
		String message= attendancePage.GetErrorMsg();
	    Assert.assertTrue(message.equals("Program name is missing"));
	}
	
	
	@When("Admin fills all the values and click save in attendance")
	public void admin_fills_all_the_values_and_click_save_in_attendance() {
	    attendancePage.fillAllValuesAndSave();
	    LoggerLoad.info("Attendance details added successfully");
	}
	
	@When("Admin fills values with future date  and click save in attendance details popup edit")
	public void admin_fills_values_with_future_date_and_click_save_in_attendance_details_popup_edit() {
	   attendancePage.clickEdit();
	   testContextSetup.genericUtils.SwitchWindowToChild();
	   attendancePage.selectFutureDateAndSave();
	}
	
	@When("Admin fills values missing attendance and click save in attendance details popup edit")
	public void admin_fills_values_missing_attendance_and_click_save_in_attendance_details_popup_edit() {
		attendancePage.clickEdit();
		testContextSetup.genericUtils.SwitchWindowToChild();
	    attendancePage.editMissingAttendanceAndSave();
		
	}
	
	@When("Admin fills values missing student name and click save in attendance details popup edit")
	public void admin_fills_values_missing_student_name_and_click_save_in_attendance_details_popup_edit() {
		 attendancePage.clickEdit();
		testContextSetup.genericUtils.SwitchWindowToChild();
		attendancePage.editMissingStudentNameAndSave();
	}
	
	@When("Admin fills values missing class name and click save in attendance details popup edit")
	public void admin_fills_values_missing_class_name_and_click_save_in_attendance_details_popup_edit() {
		 attendancePage.clickEdit();
		 testContextSetup.genericUtils.SwitchWindowToChild();
		attendancePage.editMissingClassNameAndSave();
	}
	
	@When("Admin fills values missing program name and click save in attendance details popup edit")
	public void admin_fills_values_missing_program_name_and_click_save_in_attendance_details_popup_edit() {
		 attendancePage.clickEdit();
		   testContextSetup.genericUtils.SwitchWindowToChild();
		attendancePage.editMissingProgramNameAndSave();
	}
	
	@When("Admin fills values missing attendance date and click save in attendance details popup edit")
	public void admin_fills_values_missing_attendance_date_and_click_save_in_attendance_details_popup_edit() {
		 attendancePage.clickEdit();
		   testContextSetup.genericUtils.SwitchWindowToChild();
		attendancePage.editMissingAttendanceDateAndSave();
	}
	
	@When("Admin fills all the values and click save in attendance details popup edit")
	public void admin_fills_all_the_values_and_click_save_in_attendance_details_popup_edit() {
		 attendancePage.clickEdit();
		 testContextSetup.genericUtils.SwitchWindowToChild();
		attendancePage.editValidAttendance();
	    LoggerLoad.info("Attendance Details edit successfully");
	}


	//5.Delete Attendance Validation
	

	@Then("Alert should have {string} button to accept in attendance")
	public void alert_should_have_button_to_accept_in_attendance(String string) {
	    attendancePage.verifyYes();
	}
	
	
	@Then("Admin should see alert in attendance")
	public void admin_should_see_alert_in_attendance() {
	   attendancePage.isAlertPresent();
	}
	@When("Admin clicks no button	in alert attendance")
	public void admin_clicks_no_button_in_alert_attendance() {
		 attendancePage.alertpopupano();
	}
	@Then("Redirected to manage attendance page and selected attendance details are not deleted from the data table")
	public void redirected_to_manage_attendance_page_and_selected_attendance_details_are_not_deleted_from_the_data_table() {
	    attendancePage.verifydelete();
	}
	
	@When("Admin clicks delete button in data table row level in attendance")
	public void admin_clicks_delete_button_in_data_table_row_level_in_attendance() {
	   attendancePage.deleteIcon();
	}
	@Then("Alert should have {string} button to reject in attendance")
	public void alert_should_have_button_to_reject_in_attendance(String string) {
		attendancePage.verifyNo();
	}
	
	@When("Admin clicks yes button in alert attendance")
	public void admin_clicks_yes_button_in_alert_attendance() {
		attendancePage.alertpopupayes();
	}
	@Then("Delete Successful message is displayed and selected attendance details are deleted from the data table")
	public void delete_successful_message_is_displayed_and_selected_attendance_details_are_deleted_from_the_data_table() {
	    attendancePage.verifydelete();
	}
	@Given("Admin is in delete alert after clicking row level delete button on manage attendance page")
	public void admin_is_in_delete_alert_after_clicking_row_level_delete_button_on_manage_attendance_page() {
		attendancePage.isAlertPresent();
	}
	
	//6.Delete Multiple Attendance Validation
	
	@Given("Admin is in delete alert popup after clicking delete under header after selecting single check box in data table")
	public void admin_is_in_delete_alert_popup_after_clicking_delete_under_header_after_selecting_single_check_box_in_data_table() {
		attendancePage.isAlertPresentHeaderDel();
	}
	@When("Admin clicks no button in delete attendance alert")
	public void admin_clicks_no_button_in_delete_attendance_alert() {
	    attendancePage.alertpopupano();
	}
	@Then("Redirected to manage attendance page and selected attendance row is not deleted from the data table")
	public void redirected_to_manage_attendance_page_and_selected_attendance_row_is_not_deleted_from_the_data_table() {
	   attendancePage.verifydelete();
	   attendancePage.verifyFooterEntries();
	}
	
	@Then("Redirected to manage attendance page and selected attendance rows are not deleted from the data table")
	public void redirected_to_manage_attendance_page_and_selected_attendance_rows_are_not_deleted_from_the_data_table() {
		 attendancePage.verifyFooterEntries();
	}
	@When("Admin clicks yes button in delete attendance alert")
	public void admin_clicks_yes_button_in_delete_attendance_alert() {
	   attendancePage.alertpopupayes();
	}
	@Then("Success message is displayed and selected attendance detail are deleted from the data table")
	public void success_message_is_displayed_and_selected_attendance_detail_are_deleted_from_the_data_table() {
	    attendancePage.verifydelete();
	}
	
	@When("Admin clicks single row level check box in the data table in attendance")
	public void admin_clicks_single_row_level_check_box_in_the_data_table_in_attendance() {
	   attendancePage.clickFirstRowCheckbox();
	}
	@Then("Admin should see delete icon below the header is enabled in attendance")
	public void admin_should_see_delete_icon_below_the_header_is_enabled_in_attendance() {
		attendancePage.isHeaderDeleteEnabled();
	}
	
	@When("Admin clicks multiple row level check box in the data table in attendance")
	public void admin_clicks_multiple_row_level_check_box_in_the_data_table_in_attendance() {
	    attendancePage.clickMultipleCheckbox();
	}
	@Then("Admin should see tick mark in check box of the selected rows in attendance")
	public void admin_should_see_tick_mark_in_check_box_of_the_selected_rows_in_attendance() {
		attendancePage.isCheckedMultiple();
	}
	
	
	@Then("Admin should see tick mark in check box in attendance")
	public void admin_should_see_tick_mark_in_check_box_in_attendance() {
		attendancePage.isChecked();
	}
	
	
	//7. Pagination in manage attendance module
	
	@When("Admin clicks {string} button on the navigation bar in attendance")
	public void admin_clicks_button_on_the_navigation_bar_in_attendance(String string) {
	    attendancePage.clickAttendance();
	}
	@Then("Right arrow should be enabled in page one when entries available are more than {int} in attendance data table")
	public void right_arrow_should_be_enabled_in_page_one_when_entries_available_are_more_than_in_attendance_data_table(Integer int1) {
		attendancePage.checkrightarrow();
	}

	
	@Then("Data table should display {int} page when entries are available in attendance")
	public void data_table_should_display_page_when_entries_are_available_in_attendance(Integer int1) {
		attendancePage.firstpagecount();
	}
	
	@Then("Left arrow should be disabled in page one when entries available are more than {int} in attendance data table")
	public void left_arrow_should_be_disabled_in_page_one_when_entries_available_are_more_than_in_attendance_data_table(Integer int1) {
		attendancePage.checkleftarrow();
	}
	
	@Then("Left arrow should be enabled in page two when entries available are less than {int} in attendance data table")
	public void left_arrow_should_be_enabled_in_page_two_when_entries_available_are_less_than_in_attendance_data_table(Integer int1) {
		attendancePage.checkleftArrow2Page();
	}
	
	
	@Then("when entries are less than {int} in data table pagination controls disabled in attendance")
	public void when_entries_are_less_than_in_data_table_pagination_controls_disabled_in_attendance(Integer int1) {
		attendancePage.pagination_disable();
	}

	
	@Then("Right arrow should be enabled in page two when entries available are more than {int} in attendance data table")
	public void right_arrow_should_be_enabled_in_page_two_when_entries_available_are_more_than_in_attendance_data_table(Integer int1) {
		attendancePage.checkRightArrow2Page_Pagination_enable();
	}
	
	
	@Then("when entries are more than {int} in data table pagination controls are enabled in attendance")
	public void when_entries_are_more_than_in_data_table_pagination_controls_are_enabled_in_attendance(Integer int1) {
		attendancePage.checkRightArrow2Page_Pagination_enable();
	}
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
	    attendancePage.verifyDashboard();
	}
	
	@Then("Data table should display page {int} when entries available")
	public void data_table_should_display_page_when_entries_available(Integer int1) {
	   attendancePage.printDatatable();
	}
	
	// 8. Navigation Function Validation
	
	@When("Admin clicks {string} button in the navigation bar in attendance")
	public void admin_clicks_button_in_the_navigation_bar_in_attendance(String string) {
	     attendancePage.clicklinkonnavbar(string);
	}
	@Then("Admin should able to land on program page from attendance")
	public void admin_should_able_to_land_on_program_page_from_attendance(String Program) {
		attendancePage.clicklinkonnavbar(Program);
	}
	
	@Then("Admin should able to land on batch page from attendance")
	public void admin_should_able_to_land_on_batch_page_from_attendance(String Batch) {
		attendancePage.clicklinkonnavbar(Batch);
	}
	
	@Then("Admin should able to land on login page from attendance")
	public void admin_should_able_to_land_on_login_page_from_attendance(String Login) {
		attendancePage.clicklinkonnavbar(Login);
	}
	
	
	@Then("Admin should able to land on Assignment page from attendance")
	public void admin_should_able_to_land_on_assignment_page_from_attendance(String Assignment) {
		attendancePage.clicklinkonnavbar(Assignment);
	}
	
	@Then("Admin should able to land on class page from attendance")
	public void admin_should_able_to_land_on_class_page_from_attendance(String Class) {
		attendancePage.clicklinkonnavbar(Class);
	}
	
	
	@Then("Admin should able to land on user page from attendance")
	public void admin_should_able_to_land_on_user_page_from_attendance(String User) {
		attendancePage.clicklinkonnavbar(User);
	}
	
	@Then("Admin should able to land on student page from attendance")
	public void admin_should_able_to_land_on_student_page_from_attendance(String Student) {
		attendancePage.clicklinkonnavbar(Student);
	}
		
}