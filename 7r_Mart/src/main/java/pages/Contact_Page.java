package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_Page {

	WebDriver driver;

	public Contact_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	private WebElement contact;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	private WebElement editbutton;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phonefield;
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	private WebElement deliverytimefield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;

	public void ClickontheManageContact() {
		contact.click();
	}

	public void ClickonEditButton() {
		editbutton.click();
	}

	public void Enterthevalues(String phn) {
		phonefield.clear();
		phonefield.sendKeys(phn);
	}

	public void Enterthedeliverytime(String time) {
		deliverytimefield.clear();
		deliverytimefield.sendKeys(time);
	}

	public void Clicktheupdatebutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", updatebutton);

	}

	public boolean isAlertBoxDisplayed() {
		return alertbox.isDisplayed();
	}

	public boolean isUpdateButtonDisplayed() {
		return updatebutton.isEnabled();
	}

}
