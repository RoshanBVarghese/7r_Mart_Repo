package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut_Page {
	
	WebDriver driver;
	public LogOut_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement logout;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitbutton;
	
	public void clickonAdminButton() {
		admin.click();
	}
	
	public void clickonLogoutButton() {
		logout.click();
	}
	
	public boolean isSubmitButtonDisplayed() {
		return submitbutton.isDisplayed();
	}
}
