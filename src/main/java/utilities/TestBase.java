package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {
	
	public WebDriver driver;
		public String url;
		public String invalidURL;
			public Properties prop;
		//String testDataPath;
		public WebDriver WebDriverManager() throws IOException {
		//ResourceBundle baseProperty = ResourceBundle.getBundle("global");
		//XLUtils xlutils=new XLUtils(baseProperty.getString("TestDataPath"));
		
		
		
	
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url=prop.getProperty("LmsUrl");
		invalidURL=prop.getProperty("LmsIncorrectUrl");
		//testDataPath=prop.getProperty("TestDataPath");
		String browser_properties=prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		// result = Test condition ? value1 : value2
		String browser = browser_maven!=null ? browser_maven : browser_properties; 
		
		//all page objects should invoke this driver, avoid using driver in step defs	
		if(driver == null) {
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver(); 
			}
			if(browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver(); 
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.get(url);
		driver.get(invalidURL);
		//driver.get(testDataPath);
		
		}
		return driver;
	}

}
