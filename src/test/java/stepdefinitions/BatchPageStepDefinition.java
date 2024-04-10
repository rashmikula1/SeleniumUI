package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import utilities.ExcelReader;
import utilities.GenericUtils;
import utilities.LoggerLoad;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.BatchPage;
import pages.ProgramPage;
import utilities.TestBase;
import utilities.TestContextSetup;

public class BatchPageStepDefinition {
	GenericUtils genericUtils;
	public WebDriver driver;
	TestContextSetup testContextSetup;
	BatchPage batchPage;
	TestBase Tsb;
	ProgramPage programPage;
	ExcelReader reader;
	String xlPath=System.getProperty(("user.dir")+"//LMSAutomation//exceldata//TestData.xlsx");

	public BatchPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.batchPage=testContextSetup.pageObjectManager.getBatchPage();
		this.programPage=testContextSetup.pageObjectManager.getProgramPage();

	}
//BATCHPAGEVALIDATION_SD
	@Given("Logged on the LMS portal")
	public void logged_on_the_lms_portal() throws IOException {
		LoggerLoad.info("Logged on the LMS portal");
		Tsb.WebDriverManager().get("https://lms.app.com/LMSlogin");
		 //clicklogin method
	}

	@Given("Admin is on dashboard page after Login in batch")
	public void admin_is_on_dashboard_page_after_login_in_batch() throws IOException {
		LoggerLoad.info("Admin is on dashboard page after Login in batch");

		Tsb.WebDriverManager().get("https://lms.app.com/LMSdashboard");
	}

	@When("Admin clicks {string} from navigation bar in batch")
	public void admin_clicks_from_navigation_bar_in_batch(String string) {
		LoggerLoad.info("Admin clicks {string} from navigation bar in batch");

		programPage.clicklinkondashboard(string);
	}

	@Then("Admin should see the {string} in the URL in batch")
	public void admin_should_see_the_in_the_url_in_batch(String url) {
		LoggerLoad.info("Admin should see the {string} in the URL in batch");

		String title="https://lms.app.com/Batch program";
		 Assert.assertEquals(title.contains("Batch program"),url);	}

	@Then("Admin should see the {string} in the header in batch")
	public void admin_should_see_the_in_the_header_in_batch(String hdng) {
		
		LoggerLoad.info("Admin should see the {string} in the header in batch");
String headingtext=programPage.appearonheading();
		 Assert.assertEquals(headingtext,hdng);
	}

	@Then("Admin should see the pagination controls {string} and {string} under the data table in batch")
	public void admin_should_see_the_pagination_controls_under_the_data_table_in_batch(String pagination) {
		LoggerLoad.info("Admin should see the pagination controls {string} and {string} under the data table in batch");

		String paginationtext=programPage.appearonpaginationicon();
		 Assert.assertEquals(paginationtext,pagination);
	}

	@Then("Admin Should see the data table with headers {string} in batch")
public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete_in_batch(String batch) {
		LoggerLoad.info("Admin Should see the data table with headers {string} in batch");
batchPage.batchheadercolumn(batch);
	}

	@Then("Admin should be able to see the {string} icon button that is disabled in batch")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled_in_batch(String string) {
		LoggerLoad.info("Admin should be able to see the {string} icon button that is disabled in batch");

		boolean disabled=programPage.checkdisableddeleteicon();
		Assert.assertEquals(disabled,false);	}

	@Then("Admin should be able to see the {string} button in batch")
	public void admin_should_be_able_to_see_the_button_in_batch(String string) {
		LoggerLoad.info("Admin should be able to see the {string} button in batch");

		String addnewbatch=batchPage.appearingaddnewbatch();
		Assert.assertEquals(addnewbatch,string);
		
	}

	@Then("Each row in the data table should have a checkbox in batch")
	public void each_row_in_the_data_table_should_have_a_checkbox_in_batch() {
		LoggerLoad.info("Each row in the data table should have a checkbox in batch");

		programPage.checkboxcheck();
	}

	@Then("Each row in the data table should have a edit icon that is enabled in batch")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled_in_batch() {
		LoggerLoad.info("Each row in the data table should have a edit icon that is enabled in batch");

		programPage.editcheck();
	}

	@Then("Each row in the data table should have a delete icon that is enabled in batch")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled_in_batch() {
		LoggerLoad.info("Each row in the data table should have a delete icon that is enabled in batch");

		programPage.deletecheck();	}

	@When("Admin clicks {string} button in batch")
	public void admin_clicks_button_in_batch(String string) {
		LoggerLoad.info("Admin clicks {string} button in batch");

		programPage.clicklinkondashboard(string);

	}

	@Then("A new pop up with Batch details appears in batch")
	public void a_new_pop_up_with_batch_details_appears_in_batch() {
		LoggerLoad.info("A new pop up with Batch details appears in batch");

		genericUtils.SwitchWindowToChild();	}

	//ADDNEWBATCH
	@Then("The pop up should include the fields Name, Number of classes and Description as text box,Program Name as drop down,Status as radio button,Number of classes as text box in batch")
	public void the_pop_up_should_include_the_fields_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button_number_of_classes_as_text_box_in_batch() {
		genericUtils.SwitchWindowToChild();

		batchPage.textboxcheckinbatch();
		batchPage.popaddbatchradiobutton();
		batchPage.batchdropdown();
	}

	@When("Fill in all the fields {string} and {int} except description with valid values in batch")
	public void fill_in_all_the_fields_except_description_with_valid_values_in_batch(String Sheetname,int RowNumber) throws InvalidFormatException, IOException {
		genericUtils.SwitchWindowToChild();

		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("batchname");
		String cellvalue2=data.get(RowNumber).get("noofclasses");
		batchPage.entertextbatchname(cellvalue1);
		batchPage.entertextnoofclasses(cellvalue2);
		batchPage.batchdropdown();
		batchPage.clickradiobtnbatchstatusactive();
		programPage.clicksavebtn();
	}

	@Then("The newly added batch {string} should be present in the data table in Manage Batch page in batch")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page_in_batch(String Name) {
	boolean result = batchPage.validateNewBatch(Name);
	Assert.assertEquals(result, true);
	}

	@When("Fill in all the fields with valid values {string} and {int} and click save in batch")
	public void fill_in_all_the_fields_with_valid_values_and_click_save_in_batch(String Sheetname,int RowNumber,String slectdropdown) throws InvalidFormatException, IOException {
		genericUtils.SwitchWindowToChild();

		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("batchname");
		String cellvalue2=data.get(RowNumber).get("noofclasses");
		String cellvalue3=data.get(RowNumber).get("batchdescription");

		batchPage.entertextbatchname(cellvalue1);
		batchPage.entertextnoofclasses(cellvalue2);
		batchPage.entertextbatchdesc(cellvalue3);
		batchPage.selectfromdropdown(slectdropdown);
		batchPage.clickradiobtnbatchstatusactive();
		programPage.clicksavebtn();
 
	}

	@When("any of the fields have invalid values {string} and {int} as valid  in batch"
			)
	public void any_of_the_fields_have_invalid_values_in_batch(String Sheetname,int RowNumber) throws InvalidFormatException, IOException {
		genericUtils.SwitchWindowToChild();

		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("batchname");
		String cellvalue2=data.get(RowNumber).get("noofclasses");
		String cellvalue3=data.get(RowNumber).get("batchdescription");

		batchPage.entertextbatchname(cellvalue1);
		batchPage.entertextnoofclasses(cellvalue2);
		batchPage.entertextbatchdesc(cellvalue3);
		
		batchPage.clickradiobtnbatchstatusactive();
		programPage.clicksavebtn();
  
	}
	@Then("Error message should {string} appear in batch")
	public void error_message_should_appear_in_batch(String failmsg) {
		String unSucessMsg=programPage.alertpopdeletedetails();
		Assert.assertEquals(unSucessMsg,failmsg);	}

	@When("Any of the mandatory fields are blank and valid details {string}and {int} in batch")
	public void any_of_the_mandatory_fields_are_blank_in_batch(String Sheetname,int RowNumber) throws InvalidFormatException, IOException {
		genericUtils.SwitchWindowToChild();

		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("batchname");
		String cellvalue2=data.get(RowNumber).get("noofclasses");
		String cellvalue3=data.get(RowNumber).get("batchdescription");

		batchPage.entertextbatchname(cellvalue1);
		batchPage.entertextnoofclasses(cellvalue2);
		batchPage.entertextbatchdesc(cellvalue3);
		
		batchPage.clickradiobtnbatchstatusactive();
		programPage.clicksavebtn();
	}


//EDITBATCH
	@Given("Logged on the LMS portal Admin is on dashboard")
	public void logged_on_the_lms_portal_admin_is_on_dashboard() {
		
		String title="https://lms.app.com/Dashboard";
}

	@Given("The edit icon on row level in data table is enabled in batch")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled_in_batch() {
		batchPage.editenabled();	}

	@When("Admin clicks the edit icon in batch")
	public void admin_clicks_the_edit_icon_in_batch() {
		programPage.clickeditprogram();
	}
	
	@Then("Then A new pop up with Batch details appears in batch")
	public void Then_new_pop_up__with_batch_details_appears_in_batch_the_edit_icon_in_batch() {
	genericUtils.SwitchWindowToChild();}

       

	@Given("Admin clicks the edit button in batch")
	public void admin_clicks_the_edit_button_in_batch() {
		programPage.clickeditprogram();
}

	@When("Update the fields with valid values {string} and {int} and click save in batch")
	public void update_the_fields_with_valid_values_and_click_save_in_batch(String Sheetname,int RowNumber,String slectdropdown) throws InvalidFormatException, IOException {
		programPage.cleartextfornameedit();
		programPage.cleartextfordescriptionedit();
		batchPage.cleartextfornoofclassesedit();
		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("batchname");
		String cellvalue2=data.get(RowNumber).get("noofclasses");
		String cellvalue3=data.get(RowNumber).get("batchdescription");
		batchPage.entertextbatchname(cellvalue1);
		batchPage.entertextnoofclasses(cellvalue2);
		batchPage.entertextbatchdesc(cellvalue3);
		batchPage.selectfromdropdown(slectdropdown);
		batchPage.clickradiobtnbatchstatusinactive();
		programPage.clicksavebtn();


	}

	@Then("The updated batch details should {string},{string} appear on the data table in batch")
	public void the_updated_batch_details_should_appear_on_the_data_table_in_batch(String Name,String batchdesc) {
		boolean result1 = batchPage.validate_edit_batchName(Name);
		Assert.assertEquals(result1, true);
		boolean result2 = batchPage.validate_edit_batchName(batchdesc);
		Assert.assertEquals(result2, true);
		
	}

	@When("Update the fields with invalid values {string} and {int} and click save in batch")
	public void update_the_fields_with_invalid_values_and_click_save_in_batch(String Sheetname,int RowNumber,String slectdropdown) throws InvalidFormatException, IOException {
		programPage.cleartextfornameedit();
		programPage.cleartextfordescriptionedit();
		batchPage.cleartextfornoofclassesedit();
		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("batchname");
		String cellvalue2=data.get(RowNumber).get("noofclasses");
		String cellvalue3=data.get(RowNumber).get("batchdescription");
		batchPage.entertextbatchname(cellvalue1);
		batchPage.entertextnoofclasses(cellvalue2);
		batchPage.entertextbatchdesc(cellvalue3);
		batchPage.selectfromdropdown(slectdropdown);
		batchPage.clickradiobtnbatchstatusinactive();
		programPage.clicksavebtn();
	}
	
	@When("Erase data from mandatory field {string} and {int} in batch")
	public void erase_data_from_mandatory_field_in_batch(String Sheetname,int RowNumber,String slectdropdown) throws InvalidFormatException, IOException {
		programPage.cleartextfornameedit();
		programPage.cleartextfordescriptionedit();
		batchPage.cleartextfornoofclassesedit();
		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("batchname");
		String cellvalue2=data.get(RowNumber).get("noofclasses");
		String cellvalue3=data.get(RowNumber).get("batchdescription");
		batchPage.entertextbatchname(cellvalue1);
		batchPage.entertextnoofclasses(cellvalue2);
		batchPage.entertextbatchdesc(cellvalue3);
		batchPage.selectfromdropdown(slectdropdown);
		batchPage.clickradiobtnbatchstatusinactive();
		programPage.clicksavebtn();  	
	}
	@When("Erase data from description field {string} and {int} and enters valid details in batch")
	public void erase_data_from_description_field_in_batch(String Sheetname,int RowNumber,String slectdropdown) throws InvalidFormatException, IOException {
		programPage.cleartextfornameedit();
		batchPage.cleartextfornoofclassesedit();
		List<Map<String,String>> data=reader.getData(xlPath , Sheetname);
		String cellvalue1=data.get(RowNumber).get("batchname");
		String cellvalue2=data.get(RowNumber).get("noofclasses");
		batchPage.entertextbatchname(cellvalue1);
		batchPage.entertextnoofclasses(cellvalue2);
		batchPage.selectfromdropdown(slectdropdown);
		batchPage.clickradiobtnbatchstatusinactive();
		programPage.clicksavebtn();  
	}
	
//DELETEBATCH
	@Given("The delete icon on row level in data table is enabled in batch")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled_in_batch() {
	    genericUtils.SwitchWindowToChild();
	    batchPage.CHECK_delete_ICON();}

	@When("Admin clicks the delete icon on batch")
	public void admin_clicks_the_delete_icon_on_batch() {
	    programPage.clickdeleteprogram()	;}

	@Then("Admin should see a alert open with heading {string} along with {string} and {string} button for deletion in batch")
	public void alert_appears_with_yes_and_no_option_in_batch(String confirm,String yes,String No) {
		genericUtils.SwitchWindowToChild();

		String alertText=programPage.alertpopdeletedetails();
		Assert.assertEquals(alertText.contains(confirm), true);
		Assert.assertEquals(alertText.contains(yes), true);
		Assert.assertEquals(alertText.contains(No), true);}

	@Given("Admin clicks the delete icon in batch")
	public void admin_clicks_the_delete_icon_in_batch() {
		programPage.clickdeleteprogram();
	}

	@When("You click yes option in batch")
	public void you_click_yes_option_in_batch() {
		programPage.alertpopupayes();
	}

	@Then("Batch deleted alert pops and batch {string} is no more available in data table in batch")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table_in_batch(String Name) {
		boolean result1 = batchPage.validatedltBatch(Name);
		Assert.assertEquals(result1, false);
	}

	@When("you click No option in batch")
	public void you_click_no_option_in_batch() {
		programPage.alertpopupano();

	}

	@Then("Batch is still listed {string} in data table in batch")
	public void batch_is_still_listed_in_data_table_in_batch(String Name) {
		boolean result1 = batchPage.validatedltBatch(Name);
		Assert.assertEquals(result1, true);
	}


//MULTIPLEDELETEBATCH
	@Given("None of the checkboxes in data table are selected in batch")
	public void none_of_the_checkboxes_in_data_table_are_selected_in_batch() throws IOException {
		testContextSetup.testBase.WebDriverManager().get("https://lms.app.com/Managabatch");

	}

	@Then("The delete icon under the manage batch header should be disabled in batch")
	public void the_delete_icon_under_the_header_should_be_disabled_in_batch(String string) {
		programPage.checkheaderdlticon();
	}

	@When("Click delete icon below Manage Batch header in batch")
	public void click_delete_icon_below_header_in_batch(String string) {
		programPage.click_headerdelete_icon();
		genericUtils.SwitchWindowToChild();
	}
	@Given("One of the checkboxes row is selected in batch")
	public void _checkboxes_row_is_selected_in_batch() {
		programPage.clickdeleteprogram();}


	@Then("The respective row {string} in the data table is deleted in batch")
	public void the_respective_row_in_the_data_table_is_deleted_in_batch(String Name) {
		boolean result1 = batchPage.validatedltBatch(Name);
		Assert.assertEquals(result1, false);
	}
	@Then("The respective rows {string},{string} in the data table is deleted in batch")
	public void the_respective_rows_in_the_data_table_is_deleted_in_batch(String NameA,String NameB) {
		boolean resultA = batchPage.validatedltBatch(NameA);
		Assert.assertEquals(resultA, false);
	   boolean resultB = batchPage.validatedltBatch(NameB);
	Assert.assertEquals(resultB, false);
	}


	@Given("Two or more checkboxes row is selected in batch")
	public void two_or_more_checkboxes_row_is_selected_in_batch() {
		programPage.clickMultipleCheckbox();
	}
	}
