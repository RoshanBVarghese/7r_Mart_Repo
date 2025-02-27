package test_scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_Page;
import pages.Product_Page;
import utilities.Excel_Utility;

public class Product_Test extends Base{

	@Test(description = " verify That The User is Able to Delete The Items")
	public void verifywhethertheUserisabletoDeletetheProducts() throws IOException {
//		String username_value = "admin";
//		String password_value = "admin";
		String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		
		Product_Page product = new Product_Page(driver);
		product.clickMoreinfo();
		product.clickDeletebutton();
		boolean isalertboxdisplayed = product.isAlertboxDisplayed();
		Assert.assertTrue(isalertboxdisplayed);
	}
	
}
