package stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserPage;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class UserPageStepDefinition {
	
	UserPage userPage;
	public WebDriver driver;
	TestContextSetup testContextSetup;
	
	public UserPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.userPage =testContextSetup.pageObjectManager.getUserPage(); //initialize object because constructor executes first before all methods
		
	}
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login_in_user() {
	    userPage.dashboard();
	    LoggerLoad.info("The admin is on the dashboard");
		
	}

	@When("Admin clicks User from navigation bar")
	public void admin_clicks_user_from_navigation_bar() {
		userPage.ManageUser();
	   
		
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_manage_user_in_the_url() {
		userPage.VerifyManageUserurl();
	}

	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_manage_user_in_the_header() {
		userPage.VerifyManageUserHeading();
	   
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		
		userPage.VerifyPaginationControl();
	}

	@Then("Admin Should see the data table with headers")
	public void admin_should_see_the_data_table_with_headers() {
		userPage.Verify_DataTabele_Header();
	   
	}

	@Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_delete_icon_button_that_is_disabled() {
		userPage.Verify_delete_button();
	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_a_new_user_button() {
		userPage.Verify_add_new_user_button();
	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_assign_staff_button() {
		userPage.Verify_add_assign_staff_button();
	}

	@Then("Admin should be able to see the search text box")
	public void admin_should_be_able_to_see_the_search_text_box() {
		
		userPage.Verify_Search_box();
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
		userPage.Verify_CheckBox();
	}

	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		userPage.Verify_Edit();
		
	}

	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		userPage.Verify_Delete();
	    
	}

	@Given("Admin is on dashboard page after Login and Admin clicks {string} from navigation bar")
	public void admin_is_on_dashboard_page_after_login_and_admin_clicks_user_from_navigation_bar() {
		userPage.VerifyManageUserurl();
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_a_new_user_button() {
		userPage.click_AddNewUSer();
	    
	}

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears_in_user() {
		testContextSetup.genericUtils.SwitchWindowToChild();
		userPage.verifyaddnewuserpopup();
	    
	}
	
	//AddNewUser
		

//	  @When("Admin clicks {string} from navigation bar")
//	  public void admin_clicks_from_navigation_bar(String string) {
//		userPage.ManageUser();
//	  }

	@Then("Admin clicks {string} button\"")
	public void admin_clicks_button(String string) {
		userPage.Addnewuser();
	}

	@Given("A new pop up with user details appears")
	public void a_new_pop_up_with_user_details_appears() {
	    userPage.PopupAddpage("UserPageaddPage", "AddNewUser");
	}

	@When("User Clicks on {string}")
	public void user_clicks_on(String string) {
		userPage.Addnewuser();
	}

	@Then("The pop up should include this fields.")
	public void the_pop_up_should_include_this_fields(DataTable dataTable) {
		List<List<String>> Addpage = dataTable.asLists(String.class);
		for (List<String> a : Addpage) {
			 System.out.println(a);
	}}

	@Given("A new pop up with {string} appears")
	public void a_new_pop_up_with_appears(String string) {
	    userPage.alertpopupappear();
	}

	@When("Fill in all the fields except optional fields with valid values and click submit")
	public void fill_in_all_the_fields_except_optional_fields_with_valid_values_and_click_submit() {
		 userPage.alertpopupappear();
		 userPage.submit();
	}

	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
	   userPage.validateNewUser("ID");
	}

	@When("Fill in all the fields with valid values and click submit")
	public void fill_in_all_the_fields_with_valid_values_and_click_submit() {
	    userPage.FirstName();
	    userPage.Middlename();
	    userPage.LastName();
	    userPage.Location();
	    userPage.Phone();
	    userPage.Email();
	    userPage.LinkedIn();
	    userPage.PostGraduate();
	    userPage.Timezone();
	    userPage.Usercomment();
	    userPage.UserRole();
	    userPage.VisaStatus();
	    userPage.submit();
	    
	}

	@When("any of the fields have invalid values")
	public void any_of_the_fields_have_invalid_values() {
		userPage.Invaliderrormessage();
	}

	@Then("Error message should appear")
	public void error_message_should_appear() {
	    userPage.Invaliderrormessage();
	}

	@When("Any of the mandatory fields are blank")
	public void any_of_the_mandatory_fields_are_blank() {
	userPage.MissingvalueMandatory();

	}

	//Edit User

	@When("The edit icon on row level in data table is enabled")
		public void the_edit_icon_on_row_level_in_data_table_is_enabled1() {
		userPage.ValidatingEditbuttonRowlevel();
		}

	@Given("Admin clicks the edit icon")
		public void admin_clicks_the_edit_icon1() {
		   userPage.Editbutton();
		}

		@Then("A new pop up with User details appears")
		public void a_new_pop_up_with_user1_details_appears() {
		   userPage.PopupEditpage("UserPageEditPage", "EditNewUser");
		}

		/*@Given("Admin clicks the edit icon")
		public void admin_clicks_the_edit1_icon() {
		    userPage.clickEdditButton4();
		}*/

	      

		@When("Update the fields with valid values and click submit")
		public void update_the_fields_with_valid_values_and_click_submit() {
		   userPage.validate_edit_ID("ID");
		   userPage.validate_edit_Name("Name");
		   userPage.submit();
		}

		@Then("The updated user details should appear on the data table")
		public void the_updated_user_details_should_appear_on_the_data_table() {
			userPage.ValidationofUpdateUserDetails();
		    
		  }

		@When("Update the fields with invalid values and click submit")
		public void update_the_fields_with_invalid_values_and_click_submit() {
		    
		    userPage.ValidationofUpdateUserDetails();
		    userPage.submit();
		}

		@Then("Error message should appear")
		public void error_message1_should_appear() {
			userPage.Invaliderrormessage();
		}

		@When("Erase data from mandatory field")
		public void erase_data_from_mandatory_field() {
		   userPage.alertmsg();
		}

		
	
	//4. Delete User 
	
	@Given("The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
	    userPage.isDeleteEnabled();
	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() {
		testContextSetup.genericUtils.isAlertPresent();
	}

	@Given("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
		userPage.clickDeleteButton();
	}

	@When("Admin click yes option")
	public void admin_click_yes_option() {
		testContextSetup.genericUtils.alertpopupayes();
	}

	@Then("User deleted alert pops and user is no more available in data table")
	public void user_deleted_alert_pops_and_user_is_no_more_available_in_data_table() {
	   userPage.verifydelete();
	}

	@When("Admin click No option")
	public void admin_click_no_option() {
		testContextSetup.genericUtils.alertpopupano();
	}

	@Then("User is still listed in data table")
	public void user_is_still_listed_in_data_table() {
		userPage.verifyFooterEntries();
	}
	
	// 5. Delete Multiple User
	
	@Given("One of the checkbox or row is selected")
	public void One_of_the_checkbox_or_row_is_selected(){
		userPage.clickAnyCheckbox();
	}
	
	@Given("Admin is on dashboard page after Login in user")
	public void admin_is_on_dashboard_page_after_login() {
	   userPage.verifyDashboard();
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
	  userPage.clickUser();
	}

	@Then("Admit directed to Manage User Page")
	public void admit_directed_to_manage_user_page() {
	   userPage.verifyManageUser();
	}

	@Given("None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() {
	   userPage.noCheckboxSelected();
	}

	@When("No action performed")
	public void no_action_performed() {
	    userPage.verifyFooterEntries();
	}

	@Then("The delete icon under the {string} header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled(String string) {
	   userPage.isHeaderDelDisabled();
	}

	@When("Click delete icon below {string} header")
	public void click_delete_icon_below_header(String string) {
	   userPage.clickHeaderDelete();
	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() {
		userPage.validatedltProgram("Steve Job");
	}

	@Given("Two or more checkboxes or row is selected")
	public void two_or_more_checkboxes_row_is_selected() {
	   userPage.clickMultipleCheckbox();
	}
	

}
