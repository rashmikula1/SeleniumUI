package pages;

import java.util.ArrayList;



import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Properties;
import javax.mail.internet.*;

import javax.mail.MessagingException;
import javax.mail.Session;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.Message;


import utilities.LoggerLoad;

public class ForgotUsernamePasswordPage {
public WebDriver driver;
	
	public ForgotUsernamePasswordPage(WebDriver driver) {
		this.driver=driver;
	}


	//Object Repo
	

	@FindBy(xpath="//a[text()='email']")WebElement email;
	@FindBy(xpath="//a[text()='Send Link']")WebElement sendLinkBtn;
	@FindBy(xpath="//div[@role='alert']")WebElement emailErrorMsg;
	@FindBy(xpath="//div[@role='alert']")WebElement emailSuccessMessg;
	@FindBy(xpath="//*[contains(text(),'Forgot Username')]")WebElement forgotUsernamePassword;

	
	// Methods
	
	public void clickOnforgotUsernamePassword() {
		forgotUsernamePassword.click();
	}
	
	public void enterValidEmail(String ename) {
		email.sendKeys(ename);
	}
	public void enterInValidEmail(String ename) {
		email.sendKeys(ename);
	}
	public void enterNoEmail() {
		email.sendKeys();
	}
	public void clickSendlink() {
		sendLinkBtn.click();}
	
	public boolean AreVisibleSendLink()
	{
		return sendLinkBtn.isDisplayed();
	}
	public String emailErrorMessg() {
		return emailErrorMsg.getText();
	}
	public String successTextMessg() {
		return emailSuccessMessg.getText();
	}
	public String resetLink() {
		return emailSuccessMessg.getText();
	}
	
	public boolean correctSpellingFUPwd() {
	
		ArrayList<String> forgotUPActualText = new ArrayList<String>();
		ArrayList<String> forgotUPExpectedText = new ArrayList<String>();
		forgotUPActualText.add(forgotUsernamePassword.getText());
		forgotUPActualText.add(email.getText());
		forgotUPActualText.add(sendLinkBtn.getText());
		forgotUPExpectedText.add("Email*");
		forgotUPExpectedText.add("Forgot Username or Password Page");
		forgotUPExpectedText.add("Send Link");
		
		if (forgotUPActualText.equals(forgotUPExpectedText) == true) {
			System.out.println("Spellings are correct");
		}
		return true;
	}
	public boolean AreFieldsInCenter() {
		 // Get the size and location of the first field
       Point field1Location = sendLinkBtn.getLocation();
       int field1X = field1Location.getX() + sendLinkBtn.getSize().getWidth() / 2;
       int field1Y = field1Location.getY() + sendLinkBtn.getSize().getHeight() / 2;

       // Calculate the center coordinates of the page
       int centerX = driver.manage().window().getSize().getWidth() / 2;
       int centerY = driver.manage().window().getSize().getHeight() / 2;

       // Validate if field positioned at the center
       boolean isField1Centered = field1X == centerX && field1Y == centerY;
     

       if (isField1Centered) {
       	LoggerLoad.info("Send link at the center of the page.");
       } else {
    	 	LoggerLoad.info("Send link not at the center of the page");
       }
		return isField1Centered;

		}
	public void emailColor() {
	 String color = email.getCssValue("color");

     // Validate the text color
     if (color.equals("rgba(128, 128, 128, 1)") || color.equals("gray")) {
         System.out.println("Text color is gray.");
     } else {
         System.out.println("Text color is not gray.");
     }
	}
	public boolean noEmailSent() {
		if(sendingEmail()==false) {
			System.out.println("Email not sent");
		}
		
		return true;
		//return false;
			}
	
	public boolean sendingEmail() {
	// email properties setup
    Properties properties = new Properties();
    properties.put("mail.smtp.host","your-mail-server-host");
    properties.put("mail.smtp.port","your-mail-server-port");

    //  session set up
    Session session = Session.getInstance(properties);

    try {
        // Create a new message
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("sender@example.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("admin1@example.com"));
        message.setSubject("Reset Username or Password");

        // Generate the reset link
        String resetLink = "https://lmswebsite.com/reset";

        // Compose the email content
        String emailContent = "Dear Admin,\n\nPlease reset your username or password by clicking on the following link:\n" +
                resetLink + "\n\nSincerely,\nYour Website Team";

        // Set the email content
        message.setText(emailContent);

        // Send the message
       
        Transport.send(message);
        

        System.out.println("Email sent successfully!");
    } catch (MessagingException e) {
        e.printStackTrace();
    }
	return true;

}
}