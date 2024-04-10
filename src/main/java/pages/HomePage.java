package pages;



import java.io.File;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import utilities.LoggerLoad;
import net.sourceforge.tess4j.ITesseract;
import org.openqa.selenium.Point;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath= "//div[contains(text(),'LEARNING')]")WebElement textLearning;
	@FindBy(xpath= "//div[contains(text(),'MANAGEMENT')]")WebElement textManagement;
	@FindBy(xpath= "//div[contains(text(),'SYSTEM')]")WebElement textSystem;
	@FindBy(linkText="Login")WebElement loginButton;
	@FindBy(xpath="//img[@src='//herokuapp.com/lms/logo.png']") WebElement logoImage;
	@FindBy(xpath="//img[@src='//numpyninja/logo.png']") WebElement numpyImage;
	
	@FindBy(xpath="//a[text()='404 brokenlink']") WebElement badRequest;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	// Get the image source URL

	public  void clickOnLoginButton() {
		
		loginButton.click();
	}
	public String getLogoSource()
	{
		return logoImage.getAttribute("src");
	}
	public boolean checkVisible()
	{
		return loginButton.isDisplayed();
	}
	
	public boolean loginButtonEnable()
	{
		return loginButton.isEnabled();
	}
	public boolean verifyBrokenLink() throws IOException {
		WebElement element=driver.findElement(By.linkText("a"));
		// using href attribute we can get url of required link
		String url=element.getAttribute("href");
		URL link=new URL(url);
		HttpURLConnection httpConn=(HttpURLConnection) link.openConnection();
		httpConn.connect();
		int rescode=httpConn.getResponseCode();
		if(rescode>400) {
			System.out.println(url+" is a broken link");
			return true;
		}
		else return false;
			
	}

	
	public int CheckHTTPResponse(String url) throws IOException
	{
		HttpURLConnection httpURLConnection;
		URL link = new URL(url);
		
		httpURLConnection= (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(3000); 
		httpURLConnection.connect();
		return httpURLConnection.getResponseCode();
	}
	public void imageTextExtraction() {
	    String imageSrc = logoImage.getAttribute("src");
        // Download the image using the URL
        driver.get(imageSrc);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File outputImage = new File("screenshot.png");
        try {
            FileUtils.copyFile(screenshot, outputImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Perform OCR to extract text from the image
        ITesseract tesseract = new Tesseract();
        try {
            String extractedText = tesseract.doOCR(outputImage);

            // Validate extracted text against expected values
          
            String[] expectedTexts = {"LEARNING", "MANAGEMENT", "SYSTEM"};
            for (String expectedText : expectedTexts) {
                if (extractedText.toLowerCase().contains(expectedText.toLowerCase())) {
                	LoggerLoad.info("Text validation passed! Expected text: " + expectedText);
                    break;
                }
            }
        }
        catch (TesseractException e) {
            e.printStackTrace();
        }
		
	
	}
	
	   // Get the source URL of the logo image
   
    


// Validate the logo image against expected source URL
public static boolean validateLogo(String logoSrc) {
    String expectedLogoSrc = "expected_logo_url";
    return logoSrc.contains(expectedLogoSrc);
}

public void logoAllignmentCheck() {
	//Getting the logo's position 
	Point logoLocation = numpyImage.getLocation();
	int logoXCordinate=logoLocation.getX();
	int logoYCordinate=logoLocation.getY();
	
	//Getting the logo size
	Dimension logoSize=numpyImage.getSize();
	int logoWidth = logoSize.getWidth();
	int logoHeight = logoSize.getHeight();
	//Expected allignment values
	int expectedX = 100;  
	int expectedY = 200;
	
	if (logoXCordinate == expectedX && logoYCordinate==expectedY)
		
		LoggerLoad.info("numpyLogo is properly aligned!");

	else {
	LoggerLoad.info("numpyLogo is not properly aligned.");
}
	
}
}
