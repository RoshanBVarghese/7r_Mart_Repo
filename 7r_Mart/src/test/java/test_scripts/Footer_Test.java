package test_scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Footer_Page;
import pages.Login_Page;
import utilities.Excel_Utility;

public class Footer_Test extends Base{

	@Test(description = "verify That the USer is Able to Update the Details on Footer Page Successfully")
	public void verifyTheUserIsabletoUpdatetheCurrentDetails() throws IOException {
		//String username_value = "admin";
		//String password_value = "admin";
		//String address = "HelloWorld, Obsqura" ;
		String address = Excel_Utility.getStringData(1, 0, "Manage_Footer");
		String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		
		Footer_Page footer = new Footer_Page(driver);
		footer.clickMoreinfo();
		footer.clickEditButton();
		footer.EntertheDetails(address);
		footer.clickUpdateButton();
		//footer.isAlertboxDisplayed();
		boolean isAlertBoxDisplayed =footer.isAlertboxDisplayed();
		Assert.assertTrue(isAlertBoxDisplayed);
	}
	
	@Test(description = "verify The Update button is Displayed")
	public void checkwhethertheUpdateButtonisEnabled() throws IOException {
		//String username_value = "admin";
		//String password_value = "admin";
		
		String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		
		Footer_Page footer = new Footer_Page(driver);
		footer.clickMoreinfo();
		footer.clickEditButton();
		boolean isUpdateButtonEnabled = footer.isUpdateButtondisplayed();
		System.out.println("Update Button is Displayed successfully");
		Assert.assertTrue(isUpdateButtonEnabled);
	}
	
}
