package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Page_Utility;

public class Adminusers_Page {

	WebDriver driver;

	public Adminusers_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
//	private WebElement moreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username_field;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password_field;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement dropdown;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;

//	public Adminusers_Page ClickonMoreinfoAdminPage() {
//		moreinfo.click();
//		return this;
//	}

	public Adminusers_Page ClickonNewButton() {
		newbutton.click();
		return this;
	}

	public Adminusers_Page EnterUsername(String username) {
		username_field.sendKeys(username);
		return this;
	}

	public Adminusers_Page EnterPassword(String password) {
		password_field.sendKeys(password);
		return this;
	}

	public Adminusers_Page Dropdown() {
//		Select select = new Select(dropdown);
//		select.selectByIndex(3);
		Page_Utility pageutility = new Page_Utility();
		pageutility.selectByIndex(dropdown, 3);
		return this;
	}

	public Adminusers_Page ClicktheSaveButton() {
		save.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertbox.isDisplayed();
	}

	public boolean isSavebuttonDisplayed() {
		return save.isDisplayed();
	}
// hi
}
