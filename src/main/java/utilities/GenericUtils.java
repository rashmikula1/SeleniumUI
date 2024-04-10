package utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.LoginPage;




//reusable methods
public class GenericUtils {
	public WebDriver driver;
	ExcelReader reader;
	LoginPage loginPage;
	
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}
	//explicit wait, parse string all common methods
	public void SwitchWindowToChild() {
		// Parent -child window handler
		Set<String> s1= driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}
	
	String xlPath=System.getProperty(("user.dir")+"//LMSAutomation//exceldata//TestData.xlsx");

	public void readingData(String sheetName,Integer rowNumber) throws InvalidFormatException, IOException 
	{
	List<Map<String,String>>testData =reader.getData(xlPath,sheetName);
	String uName = testData.get(rowNumber).get("UserName");
	String pwd = testData.get(rowNumber).get("PassWord");
	loginPage.enterCredentials(uName,pwd);
	}
	
	public void navigateBack() {
		 
		  driver.navigate().back();
		   	  	  
		  }
	
	public void navigateForward() {
		 
		  driver.navigate().forward();
		 		  	  
		  }
	public String getTitleOfThePage() 
	{
		return driver.getTitle();
	}
	
	
	public static boolean checkVisibility(WebElement element) 
	{
		boolean value;
		try 
		{
			value=element.isDisplayed();
			return value;
		}
		catch (Exception e)
		{
			return false;
		}		
	}
	
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}   // isAlertPresent()
	
	public void alertpopupayes() {
    	
		Alert alert = driver.switchTo().alert(); // switch to alert
		alert.accept();
		

		String alertMessage= driver.switchTo().alert().getText(); // capture alert message

				alert.accept();
	}

	public void alertpopupano() {
	
	Alert alert = driver.switchTo().alert(); // switch to alert
	alert.accept();
	

	String alertMessage= driver.switchTo().alert().getText(); // capture alert message

			alert.dismiss();
	}
	
	public boolean verifyBrokenLink() throws IOException {
		WebElement element=driver.findElement(By.linkText("a"));
		
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
	
}
