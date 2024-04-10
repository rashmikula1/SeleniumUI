package utilities;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.openqa.selenium.WebDriver;

import pages.PageObjectManager;
public class TestContextSetup {
	// sharing the states among multiple step definitions
	// having this class to avoid creating objects in step defs using constructor
	public String url;
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public LoggerLoad loggerLoad;
	public HttpURLConnection httpURLConnection;
	public String Listclasstopic;
	public String listofprogramname;

	public TestContextSetup() throws IOException{
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());

		
	}
	

}