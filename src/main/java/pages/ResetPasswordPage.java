package pages;

import java.util.ArrayList;


import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.LoggerLoad;

public class ResetPasswordPage {
public WebDriver driver;
	
	public ResetPasswordPage(WebDriver driver) {
		this.driver=driver;
	}


	//Object Repo
	
	@FindBy(xpath="//a[text()='Submit']") private WebElement submitLinkBtn;
		@FindBy(xpath="//*[contains(text(),'Type in new Password')]")private WebElement typeNewPwd;
	@FindBy(xpath="//*[contains(text(),'ReType Password')]")private WebElement RetypePwd;
	@FindBy(xpath="//a[contains(text(),'Reset']")private WebElement resetPasswordLink;
	@FindBy(xpath="//*[contains(text(),'Type in new Password')]")private WebElement errorMsg;
	@FindBy(xpath="//div[@role='alert']")WebElement errorMessg;
	
	public String errorMessg() {
		return errorMessg.getText();
	}
	
	public void clickOnSubmit() {
		submitLinkBtn.click();
	}
	public void clickOntypeNew() {
		typeNewPwd.click();
	}
	public void clickOnRetype() {
		RetypePwd.click();
	}
	public void resetPwd() {
		resetPasswordLink.click();
	}
	public boolean AreVisible()
	{
		return submitLinkBtn.isDisplayed();
	}

	public boolean correctSpelling() {
		
		ArrayList<String> loginActualText = new ArrayList<String>();
		ArrayList<String> loginExpectedText = new ArrayList<String>();
		loginActualText.add(submitLinkBtn.getText());
		loginActualText.add(typeNewPwd.getText());
		loginActualText.add(RetypePwd.getText());
		loginActualText.add(resetPasswordLink.getText());
	
		loginExpectedText.add("Type in new Password");
		loginExpectedText.add("ReType Password");
		loginExpectedText.add("Submit");
		loginExpectedText.add("Reset Password Page");
		
		if (loginActualText.equals(loginExpectedText) == true) {
			LoggerLoad.info("Spellings are correct");
		}
		return true;
	}
	
	public boolean AreFieldsInCenter() {
		 // Get the size and location of the first field
      Point submitBtnLocation = submitLinkBtn.getLocation();
      int btnX = submitBtnLocation.getX() + submitLinkBtn.getSize().getWidth() / 2;
      int btnY = submitBtnLocation.getY() + submitLinkBtn.getSize().getHeight() / 2;

      // Calculate the center coordinates of the page
      int centerX = driver.manage().window().getSize().getWidth() / 2;
      int centerY = driver.manage().window().getSize().getHeight() / 2;

      // Validate if field positioned at the center
      boolean isBtnCentered = btnX == centerX && btnY == centerY;
    

      if (isBtnCentered) {
      	LoggerLoad.info("Send link at the center of the page.");
      } else {
   	 	LoggerLoad.info("Send link not at the center of the page");
      }
		return isBtnCentered;

		}
	public boolean displayField1() {
		
		return typeNewPwd.isDisplayed();
	}
	public boolean displayField2() {
		
		return RetypePwd.isDisplayed();
	}
	public String field1Text() {
		return typeNewPwd.getText();
	}
	public String field2Text() {
		return RetypePwd.getText();
	}
	public boolean enableField() {
		
		return RetypePwd.isEnabled() && typeNewPwd.isEnabled();
	}
	
	  public boolean areFieldsDisabled() {
	        boolean isField1Disabled = !typeNewPwd.isEnabled();
	        boolean isField2Disabled = !RetypePwd.isEnabled();

	        return isField1Disabled && isField2Disabled;
	    }
	
}
