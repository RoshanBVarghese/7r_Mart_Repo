package test_scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_Page;
import pages.ManageNews_Page;
import utilities.Excel_Utility;


public class ManageNews_Test extends Base{

	@Test(retryAnalyzer = retry.Retry.class, description = " verify that User can Create News Successfully")
	public void verifyTheUserIsabletoLoginSuccessfully() throws IOException {
//		String username_value = "admin";
//		String password_value = "admin";
		String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");
		
		//String news = "Automation Makes big Difference";
		String news = Excel_Utility.getStringData(1, 0, "Manage_News");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();

		ManageNews_Page managenews = new ManageNews_Page(driver);
		managenews.clickonMoreinfoButton();
		managenews.clickonManageNewsButton();
		managenews.EnterTheNews(news);
		managenews.ClickTheSaveButton();
		boolean isalertmessagedisplayed = managenews.isAlertDisplayed();
		Assert.assertTrue(isalertmessagedisplayed);
	}
	
}
