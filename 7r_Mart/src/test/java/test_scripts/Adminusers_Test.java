package test_scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Adminusers_Page;
import pages.LogOut_Page;
import pages.Login_Page;
import utilities.Excel_Utility;
import utilities.Faker_Utility;

public class Adminusers_Test extends Base {
	LogOut_Page logoutpage;
	Adminusers_Page adminusers;
	
	@Test(description = "verify that the Admin is able to create new Users Succesfully")
	public void verifywhethertheUserisableviewtheAdminUsersList() throws IOException {
//		String username_value = "admin";
//		String password_value = "admin";
		String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value).enterPassword(password_value);
		//loginpage.enterPassword(password_value);
		logoutpage = loginpage.clickonSigninButton();

		// String username = "Sony";
		// String username = Excel_Utility.getStringData(1, 0, "Admin_User");
		Faker_Utility fakerutility = new Faker_Utility();
		String username = fakerutility.creatARandomFirstName();
		// String password = "Sony20";
		String password = Excel_Utility.getStringData(1, 1, "Admin_User");

//		Adminusers_Page adminusers = new Adminusers_Page(driver);
//		adminusers.ClickonMoreinfoAdminPage();
		adminusers = logoutpage.ClickonMoreinfoAdminPage();
		adminusers.ClickonNewButton().EnterUsername(username).EnterPassword(password).Dropdown().ClicktheSaveButton();
//		adminusers.EnterUsername(username);
//		adminusers.EnterPassword(password);
//		adminusers.Dropdown();
//		adminusers.ClicktheSaveButton();
		boolean isalertmessagedisplayed = adminusers.isAlertDisplayed();
		Assert.assertTrue(isalertmessagedisplayed);
	}

	@Test(dataProvider = "LoginProvider", description = "verify that the Save Button is Displayed")
	public void verifyWhethertheSaveButtonisDisplayed(String username_value, String password_value) throws IOException {
//		String username_value = "admin";
//		String password_value = "admin";
		// String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		// String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value).enterPassword(password_value);
		//loginpage.enterPassword(password_value);
		logoutpage = loginpage.clickonSigninButton();

//		Adminusers_Page adminusers = new Adminusers_Page(driver);
//		adminusers.ClickonMoreinfoAdminPage();
		adminusers = logoutpage.ClickonMoreinfoAdminPage();
		adminusers.ClickonNewButton();
		boolean isSaveButtonDisplayed = adminusers.isSavebuttonDisplayed();
		System.out.println("Save Button is Displayed successfully");
		Assert.assertTrue(isSaveButtonDisplayed);
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ Excel_Utility.getStringData(1, 0, "Login_Page"), Excel_Utility.getStringData(1, 1, "Login_Page") } };

	}

}
