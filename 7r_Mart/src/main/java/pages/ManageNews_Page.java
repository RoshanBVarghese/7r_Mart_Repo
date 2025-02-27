package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews_Page {

	WebDriver driver;

	public ManageNews_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement moreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newsbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enterthenews;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;


	public void clickonMoreinfoButton() {
		moreinfo.click();
	}

	public void clickonManageNewsButton() {
		newsbutton.click();
	}

	public void EnterTheNews(String news) {
		enterthenews.sendKeys(news);
	}

	public void ClickTheSaveButton() {
		savebutton.click();
	}

	public boolean isAlertDisplayed() {
		return alertbox.isDisplayed();
	}
	
}
