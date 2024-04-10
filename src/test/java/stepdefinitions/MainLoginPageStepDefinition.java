package stepdefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utilities.ExcelReader;

import io.cucumber.java.en.*;

import pages.ForgotUsernamePasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ResetPasswordPage;
import utilities.LoggerLoad;
import utilities.TestContextSetup;

public class MainLoginPageStepDefinition {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	HomePage homePage;
	LoginPage loginPage;
	ForgotUsernamePasswordPage forgotUsernamePasswordPage;
	ResetPasswordPage resetPasswordPage;
	public int statuscode;
	public HttpURLConnection httpURLConnection;

	
	public MainLoginPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.homePage=testContextSetup.pageObjectManager.getHomePage();
		this.loginPage=testContextSetup.pageObjectManager.getLoginPage();
		this.forgotUsernamePasswordPage=testContextSetup.pageObjectManager.getforgotUsernamePasswordPage();
		this.resetPasswordPage=testContextSetup.pageObjectManager.getResetPwdPage();
	}
	

	//*****************Home Page Verification************************ 
	


	@When("Admin enter the correct LMS portal URL")
	public void admin_enter_the_correct_LMS_portal_URL() throws IOException {
		testContextSetup.testBase.WebDriverManager().get(testContextSetup.testBase.url);
		
		driver.manage().window().maximize();
		LoggerLoad.info("********Admin in homepage using correct LMS*********");
		}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
	
		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Home Page");
		LoggerLoad.info("****Admin should land on home page***");
	}
	   @Then ("HTTP response >={int} page not found error")
	   public void http_response_page_not_found_error() throws IOException {
		   homePage.verifyBrokenLink();
		   LoggerLoad.info("**** 404 Page not found ***");
	   }
	   
	  
	@When("Admin enter the incorrect LMS portal URL")
	public void admin_enter_the_incorrect_lms_portal_url() throws IOException {
		testContextSetup.testBase.WebDriverManager().get(testContextSetup.testBase.invalidURL);
		driver.manage().window().maximize();
		LoggerLoad.info("Admin enter incorrect LMS URL ");
	}
		
	@Then("HTTP response >= {int} the {string} is broken")
	public void http_response_the_is_broken(Integer statuscodeFeatureFile, String url, String invalidURL) {
		try
		{
			if (url=="url")
			{
				statuscode = homePage.CheckHTTPResponse(url);
			}
			else if (url=="invalidLMSURL")
			{
				statuscode = homePage.CheckHTTPResponse(invalidURL);
			}
			if (statuscode>=statuscodeFeatureFile) 
			{				
				LoggerLoad.info(url + " : " + httpURLConnection.getResponseMessage() + " :" + "is a broken link");
			}	
					
		}
		catch (Exception e) 
		{
			 e.printStackTrace();
		}	
		
		}
	
			
	@Then("Admin should see correct spellings in all fields of homepage")
	public void admin_should_see_correct_spellings_in_all_fields_of_homepage() {
		homePage.imageTextExtraction();
		LoggerLoad.info("correct spellings in all fields of homepage");
	}

	@Then("Admin should see correct logo of the LMS")
	public void admin_should_see_correct_logo_of_the_lms(String logoSrc) {
     
		
// Validate the correct logo image
	boolean isValidLogo = HomePage.validateLogo(logoSrc);

	if (isValidLogo) {
	    System.out.println("Correct logo is displayed!");
	} else {
	    System.out.println("Incorrect or missing logo!");
	}
		}

	@Then("Admin should see logo is properly aligned")
	public void admin_should_see_logo_is_properly_aligned() {
	  
		homePage.logoAllignmentCheck();
		
		LoggerLoad.info("logo is properly aligned");
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	
	Assert.assertEquals(homePage.checkVisible(),true);
		
	LoggerLoad.info("Check visiblity of login button in home page");
	}

	@Then("Admin should able to click the Login button")
	public void admin_should_able_to_click_the_login_button() {
	 Assert.assertEquals(homePage.loginButtonEnable(),true);
	}

	@When("Admin clicks Login button")
	public void admin_clicks_login_button() {
	    homePage.clickOnLoginButton();
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
	 
		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Login Page");
		LoggerLoad.info("****Admin should land on login page***");
	}

	@Given ("Admin user is in home page")
	public void admin_user_is_in_home_page() {
		
	}
	
	//*****************LOGIN PAGE********************************
	
	@Given ("Admin is on home page")
	public void admin_is_on_home_page() throws IOException {

		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Home Page");
		LoggerLoad.info("****Admin is on home page***");
	}
		
	
	
	@Then("Admin should see {string} in the header")
  public void admin_should_see_in_the_header(String loginMessageHeader) {
		  String actualHeaderMesg=loginPage.successMessg();
		   Assert.assertEquals(actualHeaderMesg,loginMessageHeader);
		
	}
	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		Assert.assertTrue(loginPage.displayField1(),"Login field not visible");
		Assert.assertTrue(loginPage.displayField2(),"Password field not visible");
		
	}

	@Then("Admin should see {string} in the first text field")
public void admin_should_see_in_the_first_text_field(String expFirstTextField) {
		 String firstTextField=loginPage.userNameFieldText();
		   Assert.assertEquals(firstTextField,expFirstTextField);
		
	}
	
	@Then("Admin should see {string} in the second text field")
public void admin_should_see_in_the_second_text_field(String expSecondTextField) {
		 String secondTextField=loginPage.passwordFieldText();
		   Assert.assertEquals(secondTextField,expSecondTextField);
		
		}

	@Then("Admin should see {string} symbol next to user text")
public void admin_should_see_symbol_next_to_user_text(String expSymbolNextToUser) {
		String userTextField=loginPage.userNameFieldText();
	   char symbolAfterUser= userTextField.charAt(userTextField.length()-1);
	   Assert.assertEquals(symbolAfterUser,expSymbolNextToUser);
	}
	@Then("Admin should see {string} symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text(String expSymbolNextToPassword) {
		String passwordField=loginPage.passwordFieldText();
		   char symbolAfterUser= passwordField.charAt(passwordField.length()-1);
		   Assert.assertEquals(symbolAfterUser,expSymbolNextToPassword);
		}
	
	@Then("Admin should see input field on the centre of the page")
public void admin_should_see_input_field_on_the_centre_of_the_page() {
		loginPage.AreFieldsInCenter();
		
	}
	@Then("Admin should see login button on the centre of the page")
   public void admin_should_see_login_button_on_the_centre_of_the_page() {
		loginPage.AreloginbtnCenter();
	}
	

	@Then("Admin should see forgot username or password link") 
	  public void admin_should_see_forgot_username_or_password_link() {
		Assert.assertTrue(loginPage.AreVisibleForgotUNameLink(),"Forgot Username field not visible");
		}

	@Then("Admin should see reset password link")
	 public void admin_should_see_reset_password_link() {
		Assert.assertTrue(loginPage.AreVisibleResetPwdLink(),"Reset Password field not visible");
	}


	@Then ("Admin should see user in gray color")
	 public void admin_should_see_user_in_gray_color() {
		loginPage.userfieldColorGrey();
		}


	@Then ("Admin should see password in gray color")
	 public void admin_should_see_password_in_gray_color() {
		loginPage.passwordfieldColorGrey();
	}
	@Then("Admin should see correct spellings in all fields of login page")
	public void admin_should_see_correct_spellings_in_all_fields_of_login_page() {
		
		loginPage.correctSpelling();
		LoggerLoad.info("****correct spellings all fields of login page***");
	   	}
	//******* Login page validation************************************

@Given("Admin is in login page")
public void admin_is_in_login_page() {
	String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
	Assert.assertEquals(titleOfThePage, "Login Page");
	LoggerLoad.info("****Admin should be in login page***");
 
}

@When("Admin enter valid username {string} and  valid password {int}")
public void admin_enter_valid_username_and_valid_password(String sheetName ,Integer rowNumber) throws InvalidFormatException, IOException {

	testContextSetup.genericUtils.readingData(sheetName,rowNumber);
	LoggerLoad.info("****Admin enter valid credential***");
}


@Then("Admin should land on dashboard page")
public void admin_should_land_on_dashboard_page() {
	String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
	Assert.assertEquals(titleOfThePage, "Dashboard Page");
	LoggerLoad.info("****Admin landed in dashboard page***");
}

@When("clicks login button through keyboard")
public void clicks_login_button_through_keyboard() {
    loginPage.clickButtonKeyboard();
}



@When("user clicks login button through mouse")
public void user_clicks_login_button_through_mouse() {
	loginPage.clickOnlogInBtn();
  
}

@When("Admin enter invalid username {string} and  invalid password {int}")
public void admin_enter_invalid_username_and_invalid_password(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	
	testContextSetup.genericUtils.readingData(sheetName,rowNumber);
	LoggerLoad.info("****Admin enter invalid credential***");
}

@When("Admin user clicks login button")
public void admin_user_clicks_login_button() {
loginPage.clickOnlogInBtn();
}

@Then("Error message please check username or password")
public void error_message_please_check_username_password() {
  LoggerLoad.info("Invalid User name and password enterd by user : "+loginPage.invalidCredentialMessg());
	
}

@When("Admin enter blank username {string} and  valid password {int}")
public void admin_enter_blank_username_and_valid_password(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	testContextSetup.genericUtils.readingData(sheetName,rowNumber);
	LoggerLoad.info("****blank username and valid password ***");
		
}


@When("Admin enter valid username {string} and  blank password {int}")
public void admin_enter_valid_username_and_blank_password(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	testContextSetup.genericUtils.readingData(sheetName,rowNumber);
	LoggerLoad.info("**** valid username blank password***");
}



@When("Admin enter valid username {string} and  invalid password {int}")
public void admin_enter_valid_username_and_invalid_password(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	testContextSetup.genericUtils.readingData(sheetName,rowNumber);
	LoggerLoad.info("**** valid username invalid password***");
}

@When("Admin enter invalid username {string} and  valid password {int}")
public void admin_enter_invalid_username_and_valid_password(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	testContextSetup.genericUtils.readingData(sheetName,rowNumber);
	LoggerLoad.info("**** invalid username valid password***");
}

   

@When("Admin clicks login button with blank username {string} and  blank password {int}")
public void admin_clicks_login_button_with_blank_username_and_blank_password(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	testContextSetup.genericUtils.readingData(sheetName,rowNumber);
	LoggerLoad.info("**** blank username blank password***");
}

	
	//*******************Forgot username,password page **************************
	
	@When("Admin clicks forgot username or password link")
	public void admin_clicks_forgot_username_or_password_link() {
		loginPage.clickOnforgotUsernamePassword();
		LoggerLoad.info("clicks forgot username or password link");
	}
	@Then("Admin should land on forgot username or password page")
	public void admin_should_land_on_forgot_username_or_password_page() {
		String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
		Assert.assertEquals(titleOfThePage, "Forgot Username or Password  Page");
		LoggerLoad.info("****Admin landed in Forgot Username or Password page***");
	}
	@Then ("HTTP response >=404 page not found error in forgotUsername")
	   public void http_response_page_not_found_error_in_forgotUsername() throws IOException {
		   homePage.verifyBrokenLink();
		   LoggerLoad.info("**** 404 Page not found ***");
	   }
	
	@Then("Admin should see {string} text in gray color")
	public void admin_should_see_text_in_gray_color(String string) {
		forgotUsernamePasswordPage.emailColor();
	}
	@Then("Admin should see {string} in text field")
	public void admin_should_see_in_text_field(String Email) {
		String actualemailText=forgotUsernamePasswordPage.successTextMessg();
		   Assert.assertEquals(actualemailText,Email);
	}
	@Then("Admin should see {string} button")
	public void admin_should_see_button(String string) {
		LoggerLoad.info("admin see send Link button "+forgotUsernamePasswordPage.AreVisibleSendLink());
	}
	@Then("Admin should see {string} symbol near Email")
	public void admin_should_see_symbol_near_email(String expSymbolNextToEmail) {
		 {
			String emailTextField=forgotUsernamePasswordPage.successTextMessg();
		   char symbolAfterEmail= emailTextField.charAt(emailTextField.length()-1);
		   Assert.assertEquals(symbolAfterEmail,expSymbolNextToEmail);
		}
	}
	
	@Then("Admin should see correct spellings in forgot username password fields")
	public void admin_should_see_correct_spellings_in_forgot_username_password_fields() {
		forgotUsernamePasswordPage.correctSpellingFUPwd();
	}
	
	
	@Then("Admin should see send link button in center of the page")
	public void admin_should_see_send_link_button_in_center_of_the_page() {
		forgotUsernamePasswordPage.AreFieldsInCenter();
	}
	
	@When ("Admin enters valid {string} and clicks send link button")	
	public void admin_enters_valid_and_clicks_send_link_button(String email) {
		forgotUsernamePasswordPage.enterValidEmail(email);
		
		forgotUsernamePasswordPage.clickSendlink();
		}


@When("Admin enters invalid {string} and clicks send link button")	
public void admin_enters_invalid_and_clicks_send_link_button(String email) {
	forgotUsernamePasswordPage.enterInValidEmail(email);
	forgotUsernamePasswordPage.clickSendlink();
	}
@When("Admin clicks send link button without any email")
public void admin_clicks_send_link_button_without_any_email(){
	forgotUsernamePasswordPage.enterNoEmail();
	forgotUsernamePasswordPage.clickSendlink();
	}

@Then("Admin should get a message {string}")
public void admin_should_get_a_message(String expMessage) {
	  String actualMesg=forgotUsernamePasswordPage.emailErrorMessg();
	   Assert.assertEquals(actualMesg,expMessage);
}

@Then("Admin should receive link in mail for reset username or password")
public void admin_should_receive_link_in_mail_for_reset_username_or_password() {
	forgotUsernamePasswordPage.sendingEmail();
	LoggerLoad.info("receive link in mail for reset username or password");
	}
@Then("Admin should not receive link in mail for reset username or password")
public void admin_should_not_receive_link_in_mail_for_reset_username_or_password() {
	forgotUsernamePasswordPage.noEmailSent();
	
	}


	//***************ResetPassword*****************


@When("Admin clicks reset password link and landed on reset password page")
public void admin_clicks_reset_password_link_and_landed_on_reset_password_page() {
	resetPasswordPage.resetPwd();

	String titleOfThePage=testContextSetup.genericUtils.getTitleOfThePage();
	Assert.assertEquals(titleOfThePage, "Reset Password");
	LoggerLoad.info("****Admin should land on Reset Password***");
}

@Then("Admin should see correct spellings in all reset password fields")
public void admin_should_see_correct_spellings_in_all_reset_password_fields() {
	resetPasswordPage.correctSpelling();
	
}	  

@Then("Admin should see {string}  button in reset password page")
public void admin_should_see_button_in_reset_password_page(String string) {
	resetPasswordPage.AreVisible();
	LoggerLoad.info("****Admin saw submit button***");
}

@Then("Admin should see submit button in center of the reset password page")
public void admin_should_see_submit_button_in_center_of_the_reset_password_page() {
	resetPasswordPage.AreFieldsInCenter();
}

@Then("Admin should see two text box in reset password page")
public void admin_should_see_two_text_box_in_reset_password_page() {
	Assert.assertTrue(resetPasswordPage.displayField1(),"Login field not visible");
	Assert.assertTrue(resetPasswordPage.displayField2(),"Password field not visible");
}

@Then("Admin should see {string} in the first label text")
public void admin_should_see_in_the_first_label_text(String expFirstTxtField) {
   String firstTxtField=resetPasswordPage.field1Text();
   Assert.assertEquals(firstTxtField,expFirstTxtField);
}

@Then("Admin should see {string} in the second label text")
public void admin_should_see_in_the_second_label_text(String expSecondTxtField) {
	String secondTxtField=resetPasswordPage.field2Text();
	   Assert.assertEquals(secondTxtField,expSecondTxtField);
}

@Then("Admin should see text box in disabled state in reset password page")
public void admin_should_see_text_box_in_disabled_state_in_reset_password_page() {
	if(resetPasswordPage.areFieldsDisabled())
	{
		LoggerLoad.info("Both fields are disabled");
	}
	else{
		LoggerLoad.info("At lease One field is enabled");
		}
}

@When("Admin clicks on type in new password field")
public void admin_clicks_on_type_in_new_password_field() {
	resetPasswordPage.clickOntypeNew();
	LoggerLoad.info("Type new password clicked ");
}

@Then("Admin should see text box is enabled state")
public void admin_should_see_text_box_is_enabled_state() {
	resetPasswordPage.enableField();
	LoggerLoad.info("Reset Password page text boxes are enabled");
}

@When("Admin clicks on retype password field")
public void admin_clicks_on_retype_password_field() {
	resetPasswordPage.clickOnRetype();
	LoggerLoad.info("Re type  password clicked ");
}

@When("Admin enters same password from {string} and {int} in both field")
public void admin_enters_same_password_from_and_in_both_field(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	testContextSetup.genericUtils.readingData(SheetName,RowNumber);
	LoggerLoad.info("Same password entered ");
}

@When("click submit button")
public void click_submit_button() {
	resetPasswordPage.clickOnSubmit();
}

@Then("Admin should recieve : {string}. Please click here to login")
public void admin_should_recieve_please_click_here_to_login(String expErrMessage)
{
		String actualErrMessage=resetPasswordPage.errorMessg();
	   Assert.assertEquals(actualErrMessage,expErrMessage);
	
    
}

@When("Admin enters  invalid password from {string} and {int} in both field")
public void admin_enters_invalid_password_from_and_in_both_field(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	testContextSetup.genericUtils.readingData(SheetName,RowNumber);
	LoggerLoad.info("Invalid password entered ");
}


@Then("Admin clicks submit button	Error message will be {string}")
public void admin_clicks_submit_button_error_message_will_be(String expErrMessage) {
    
	resetPasswordPage.clickOnSubmit();

	String actualErrMessage=resetPasswordPage.errorMessg();
   Assert.assertEquals(actualErrMessage,expErrMessage);
   LoggerLoad.info("Error Message:Please try again");
	
}

@When("Admin doesnot enter  any passwords from {string} and {int}")
public void admin_doesnot_enter_any_passwords_from_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	testContextSetup.genericUtils.readingData(SheetName,RowNumber);
	LoggerLoad.info("No Entry");
}



@When("Admin enters  mismatch values from {string} and {int}")
public void admin_enters_mismatch_values_from_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	testContextSetup.genericUtils.readingData(SheetName,RowNumber);
	LoggerLoad.info("Mismatch value");
}



}
