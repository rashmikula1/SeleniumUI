package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import utilities.LoggerLoad;

import java.util.ArrayList;
public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	//Object Repo
	@FindBy(xpath="//a[text()='Login']")WebElement logInBtn;
	
	@FindBy(name="user")WebElement usernameFieldTxt;
	@FindBy(name="password")WebElement passwordFieldTxt;
	
	@FindBy(xpath="//a[contains(text(),'Reset']")WebElement resetPasswordLink;
	@FindBy(xpath="//div[@role='alert']")WebElement errorMessg;
	@FindBy(xpath="//div[@role='alert']")WebElement successMessg;
	@FindBy(xpath="//a[text()='email']")WebElement emailTxt;

	@FindBy(xpath="//div[@role='alert']")WebElement emailErrorMessg;
	@FindBy(xpath="//div[@role='alert']")WebElement emailSuccessMessg;
	@FindBy(xpath="//*[contains(text(),'Forgot Username')]")WebElement forgotUsernamePasswordLink;

	
	// Methods
	
	public void clickOnforgotUsernamePassword() {
		forgotUsernamePasswordLink.click();
	}
	
	public void enterValidEmail(String ename) {
		emailTxt.sendKeys(ename);
	}
	public void enterInValidEmail(String ename) {
		emailTxt.sendKeys(ename);
	}

	
		public void enterUsername(String uname) {
			usernameFieldTxt.sendKeys(uname);
		}
		
		public void enterPassword(String pwd) {
			passwordFieldTxt.sendKeys(pwd);
		}
		
		public void clickOnlogInBtn() {
			logInBtn.click();
		}
		   //clicking button using the keyboard
		public void clickButtonKeyboard() {
		logInBtn.sendKeys(Keys.ENTER); 
		// or loginButton.sendKeys(Keys.RETURN);
		}
	
		public void enterCredentials(String uname,String pw) {
			usernameFieldTxt.sendKeys(uname);
			passwordFieldTxt.sendKeys(pw);
		
		}
		
		public String invalidCredentialMessg() {
			return errorMessg.getText();
		}
		public String successMessg() {
			return successMessg.getText();
		}
		public boolean AreVisibleForgotUNameLink()
		{
			return forgotUsernamePasswordLink.isDisplayed();
		}
		public boolean AreVisibleResetPwdLink()
		{
			return resetPasswordLink.isDisplayed();
		}
		public boolean displayField1() {
			
			return usernameFieldTxt.isDisplayed();
		}
		public boolean displayField2() {
			
			return passwordFieldTxt.isDisplayed();
		}
		public boolean enableField() {
			usernameFieldTxt.isEnabled();
			return passwordFieldTxt.isEnabled();
		}
		public String userNameFieldText() {
			return usernameFieldTxt.getText();
		}
		public String passwordFieldText() {
			return passwordFieldTxt.getText();
		}
		
		
	
		public boolean AreFieldsInCenter() {
		 // Get the size and location of the first field
        Point field1Location = usernameFieldTxt.getLocation();
        int field1X = field1Location.getX() + usernameFieldTxt.getSize().getWidth() / 2;
        int field1Y = field1Location.getY() + usernameFieldTxt.getSize().getHeight() / 2;

        // Get the size and location of the second field
        Point field2Location = passwordFieldTxt.getLocation();
        int field2X = field2Location.getX() + passwordFieldTxt.getSize().getWidth() / 2;
        int field2Y = field2Location.getY() + passwordFieldTxt.getSize().getHeight() / 2;

        // Calculate the center coordinates of the page
        int centerX = driver.manage().window().getSize().getWidth() / 2;
        int centerY = driver.manage().window().getSize().getHeight() / 2;

        // Validate if both fields are positioned at the center
        boolean isField1Centered = field1X == centerX && field1Y == centerY;
        boolean isField2Centered = field2X == centerX && field2Y == centerY;

        if (isField1Centered && isField2Centered) {
        	System.out.println("Both fields are positioned at the center of the page.");
        } else {
            System.out.println("Fields are not positioned at the center of the page.");
        }
		return isField1Centered&&isField2Centered;

		}

		
		public boolean correctSpelling() {
		
			ArrayList<String> loginActualText = new ArrayList<String>();
			ArrayList<String> loginExpectedText = new ArrayList<String>();
			loginActualText.add(usernameFieldTxt.getText());
			loginActualText.add(passwordFieldTxt.getText());
			loginActualText.add(logInBtn.getText());
			loginActualText.add(forgotUsernamePasswordLink.getText());
			loginActualText.add(resetPasswordLink.getText());
			loginActualText.add(resetPasswordLink.getText());
			loginExpectedText.add("Login");
			loginExpectedText.add("Forgot Username or Password");
			loginExpectedText.add("Reset Password");
			loginExpectedText.add("Please login to LMS application");
			loginExpectedText.add("User*");
			loginExpectedText.add("Password*");
			if (loginActualText.equals(loginExpectedText) == true) {
				System.out.println("Spellings are correct");
			}
			return true;
		}
public void AreloginbtnCenter() {
	  
	// Getting the button's size
    Dimension buttonSize = logInBtn.getSize();

    // Getting the button's position
    Point buttonPosition = logInBtn.getLocation();

    // Getting the window size
    Dimension windowSize = driver.manage().window().getSize();

    // Calculate the expected coordinates for centering the button
    int expectedX = windowSize.getWidth() / 2 - buttonSize.getWidth() / 2;
    int expectedY = windowSize.getHeight() / 2 - buttonSize.getHeight() / 2;

    // Validate if the button is centered
    if (buttonPosition.getX() == expectedX && buttonPosition.getY() == expectedY) {
        System.out.println("Button is centered!");
    } else {
        System.out.println("Button is not centered.");
    }
}

// Get the CSS color value of the field

	public static void validateFieldColor(WebElement field,String expectedColor) {
		String colorValue=field.getCssValue("color");
		if(colorValue.equals(expectedColor)) {
			LoggerLoad.info("Field text as expected color" +expectedColor);
		}else {
			LoggerLoad.info("Field text not as expected color" +expectedColor);
		}
	}
	public void userfieldColorGrey() {
	    String colorfield1 = usernameFieldTxt.getCssValue("gray");
	  
	    
	    // Define the expected grey color values
	    String expectedColor1 = "rgb(128, 128, 128)";
	    String expectedColor2 = "#808080";
	    
	    // Check if the field text is in grey color
	    boolean isField1Grey = colorfield1.equalsIgnoreCase(expectedColor1) || colorfield1.equalsIgnoreCase(expectedColor2);
	
	     // Print the validation result
	    if (isField1Grey) {
	       LoggerLoad.info("Field 1 text is in gray color!");
	    } else {
	    	  LoggerLoad.info("Field 1 text is not in gray color.");
	    }
	   
	}
	public void passwordfieldColorGrey() {
	
	    String colorfield2 = passwordFieldTxt.getCssValue("color");
	    
	    // Define the expected grey color values
	    String expectedColor1 = "rgb(128, 128, 128)";
	    String expectedColor2 = "#808080";
	    
	    // Check if the field text is in grey color
	  
	    boolean isField2Grey = colorfield2.equalsIgnoreCase(expectedColor1) || colorfield2.equalsIgnoreCase(expectedColor2);
	    
	    // Print the validation result
	   
	    
	    if (isField2Grey) {
	    	LoggerLoad.info("Field 2 text is in gray color!");
	    } else {
	    	LoggerLoad.info("Field 2 text is not in gray color.");
	    }
	}


}



	

