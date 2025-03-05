package test_scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LogOut_Page;
import pages.Login_Page;
import utilities.Excel_Utility;

public class LogOut_Test extends Base{
	
	@Test(retryAnalyzer = retry.Retry.class, description = "verify if the USer is able to LogOut Succesfully")
	public void verifywhethertheUserisabletoLogOut() throws IOException {
		
//		String username_value = "admin";
//		String password_value = "admin";
		String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		
		LogOut_Page logout = new LogOut_Page(driver);
		logout.clickonAdminButtonLogoutPage();
		logout.clickonLogoutButton();
	}
	
}
