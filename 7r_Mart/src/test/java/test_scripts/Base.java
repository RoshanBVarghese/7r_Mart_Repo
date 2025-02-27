package test_scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants_7r.Constants_7r;
import utilities.ScreenShot_Utility;
import utilities.Wait_Utility;

public class Base {

	
	ScreenShot_Utility scrshot;
	WebDriver driver;
	public Properties properties;
	FileInputStream fileinputstream;
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void intializebrowser(String browser) throws Exception {
		
		try {
			properties = new Properties();
			fileinputstream = new FileInputStream(Constants_7r.CONFIGFILE);
			properties.load(fileinputstream);
		}
		
		catch(Exception e){
			System.out.println("Invalid program");
		}
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Browser is not correcct / invalid");
		}
		//driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize(); //window maxi
		
	}
	
//	@AfterMethod(alwaysRun = true)
//	public void QuitandClose() {
//		//driver.quit();
//		driver.close();
//	}
	
	public void browserQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenShot_Utility();
			scrshot.getScreenshot(driver, iTestResult.getName());
		}

		// driver.quit();
	}
	

}