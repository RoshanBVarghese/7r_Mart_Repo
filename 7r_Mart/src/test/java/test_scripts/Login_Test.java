package test_scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Login_Page;
import utilities.Excel_Utility;

public class Login_Test extends Base {

	@Test(description = " verify that The User is Able to Login into THe Site ")
	public void verifyTheUserIsabletoLoginusingvalidcredentials() throws IOException {
		//String username_value = "admin";
		//String password_value = "admin";
		String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		boolean ishomepageavailable = loginpage.isDashboardLoaded();
		Assert.assertTrue(ishomepageavailable);
	}
	
	@Test(description = "verify The USer is Able to Login Using Invalid Password")
	public void verifyTheUserisabletoLoginUsinginvalidPassword() {
		String username_value = "admin";
		String password_value = "hello";

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		boolean isalertmessagedisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertmessagedisplayed);
	}

	@Test(description = "verify if the User is Able to Login Using Invalid Details")
	public void verifyTheUserisabletoLoginusingInvalidCredentials() {
		String username_value = "HEY";
		String password_value = "hello";

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		boolean isalertmessagedisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertmessagedisplayed);
	}

	@Test(description = "verify The User is able To Login into the Site USing Invalid Username")
	public void verifyTheUserisabletoLoginusingInvalidUsername() {
		String username_value = "HEY";
		String password_value = "admin";

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		boolean isalertmessagedisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertmessagedisplayed);
	}

	@Test(description = "verify That the User is Able to Login using Invalid Username and Password")
	public void verifyTheUserisabletoLoginusingInvaliduserandInvalidpassword() {
		String username_value = "ADMIN";
		String password_value = "admin";

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		boolean isalertmessagedisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertmessagedisplayed);
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ Excel_Utility.getStringData(1, 0, "Login_Page"), Excel_Utility.getStringData(1, 1, "Login_Page") } };

	}
}