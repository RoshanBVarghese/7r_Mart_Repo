package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer_Page {

	WebDriver driver;

	public Footer_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	private WebElement moreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")
	private WebElement editbutton;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement details;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;

//	public void clickMoreinfoFooterPage() {
//		moreinfo.click();
//	}

	public void clickEditButton() {
		editbutton.click();
	}

	public void EntertheDetails(String address) {
		details.clear();
		details.sendKeys(address);
	}

	public void clickUpdateButton() {
		update.click();
	}

	public boolean isAlertboxDisplayed() {
		return alertbox.isDisplayed();
	}

	public boolean isUpdateButtondisplayed() {
		return update.isEnabled();
	}

}
