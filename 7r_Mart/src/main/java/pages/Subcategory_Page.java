package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants_7r.Constants_7r;
import utilities.FileUpload_Utility;
import utilities.Page_Utility;

public class Subcategory_Page {

	WebDriver driver;

	public Subcategory_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
//	private WebElement categorymoreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newbutton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement categorybutton;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subtext;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement image;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement green_alert;

//	public void clickOnMoreInfoSubcategoryPage() {
//		categorymoreinfo.click();
//	}

	public void clickonNewButton() {
		newbutton.click();
	}

	public void selectanyCategory() {
//		Select drop = new Select(categorybutton);
//		// drop.selectByValue("burger");
//		drop.selectByVisibleText("burger");
		Page_Utility pageutility = new Page_Utility();
		pageutility.selectByVisibleText(categorybutton, "burger");
	}

	public void enterTheCategoryText(String text) {
		subtext.sendKeys(text);
	}

	public void clickTheUploadImageButton() throws AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", image);
		FileUpload_Utility fileuploadutility_sendkeys = new FileUpload_Utility();
		fileuploadutility_sendkeys.fileUploadUsingRobotClass(image, Constants_7r.BURGERIMAGE);
		//fileuploadutilityRobot.fileUploadUsingRobotClass(image, Constants_7r.BURGERIMAGE);
	}

	public void clickOnSaveButton() {
		savebutton.click();
	}
	
	public boolean isGreenAlertBoxDisplayed() {
		return green_alert.isDisplayed();
	}
}
