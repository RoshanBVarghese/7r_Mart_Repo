package test_scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Contact_Page;
import pages.Login_Page;
import utilities.Excel_Utility;

public class Contact_Test extends Base{
	@Test(description = "verify that User is Able to Change the Phone number  and Delivery Time")
	public void verifyTheUserIsabletoUpdatetheCurrentDetails() throws IOException {
		//String username_value = "admin";
		//String password_value = "admin";
//		String phn = "956755522" ;
//		String time = "7pm";
		String phn = Excel_Utility.getIntegerData(1, 0, "Manage_Contact");
		String time =Excel_Utility.getIntegerData(1, 1, "Manage_Contatc");
		String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		
		Contact_Page contact = new Contact_Page(driver);
		contact.ClickontheManageContact();
		contact.ClickonEditButton();
		contact.Enterthevalues(phn);
		contact.Enterthedeliverytime(time);
		contact.Clicktheupdatebutton();
		boolean isAlertBoxDisplayed =contact.isAlertBoxDisplayed();
		Assert.assertTrue(isAlertBoxDisplayed);
	}
	
	@Test(description = "verify That the Update Button is Displayed")
	public void checkwhethertheUpdateButtonisEnabled() throws IOException {
		//String username_value = "admin";
		//String password_value = "admin";
		
		String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		
		Contact_Page contact = new Contact_Page(driver);
		contact.ClickontheManageContact();
		contact.ClickonEditButton();
		boolean isUpdateButtonEnabled = contact.isUpdateButtonDisplayed();
		System.out.println("Update Button is Displayed successfully");
		Assert.assertTrue(isUpdateButtonEnabled);
	}
}
