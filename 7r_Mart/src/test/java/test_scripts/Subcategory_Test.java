package test_scripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_Page;
import pages.Subcategory_Page;
import utilities.Excel_Utility;

public class Subcategory_Test extends Base{

	@Test(description = "verify That the User is Upload Image and Add some Details")
	public void verifyTheUserIsabletoAddDetailsWithImage() throws AWTException, IOException {
		//String username_value = "admin";
		//String password_value = "admin";
		//String sub_text = "Burger" ;
		String sub_text = Excel_Utility.getStringData(1, 0, "Manage_Subcategory");
		
		String username_value = Excel_Utility.getStringData(1, 0, "Login_Page");
		String password_value = Excel_Utility.getStringData(1, 1, "Login_Page");

		Login_Page loginpage = new Login_Page(driver);
		loginpage.enterUsername(username_value);
		loginpage.enterPassword(password_value);
		loginpage.clickonSigninButton();
		
		Subcategory_Page sub = new Subcategory_Page(driver);
//		sub.clickOnMoreInfoSubcategoryPage();
		sub.clickonNewButton();
		sub.selectanyCategory();
		sub.enterTheCategoryText(sub_text);
		sub.clickTheUploadImageButton();
		sub.clickOnSaveButton();
		boolean isGreenalertboxDisplayed = sub.isGreenAlertBoxDisplayed();
		Assert.assertTrue(isGreenalertboxDisplayed);
	}
		
	
}
