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
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	private WebElement moreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	private WebElement contact;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	private WebElement footermoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement newsmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")
	private WebElement productmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement categorymoreinfo;
	
	public Adminusers_Page ClickonMoreinfoAdminPage() {
		moreinfo.click();
		return new Adminusers_Page(driver);
	}
	
	public Contact_Page ClickontheManageContactMoreInfo() {
		contact.click();
		return new Contact_Page(driver);
	}
	
	public Footer_Page clickMoreinfoFooterPage() {
		footermoreinfo.click();
		return new Footer_Page(driver);
	}
	
	public ManageNews_Page clickonMoreinfoManageNews() {
		newsmoreinfo.click();
		return new ManageNews_Page(driver);
	}
	
	public Product_Page clickMoreinfoProductPage() {
		productmoreinfo.click();
		return new Product_Page(driver);
	}
	
	public Subcategory_Page clickOnMoreInfoSubcategoryPage() {
		categorymoreinfo.click();
		return new Subcategory_Page(driver);
	}
	
	public void clickonAdminButtonLogoutPage() {
		admin.click();
	}
	
	public void clickonLogoutButton() {
		logout.click();
	}
	
	public boolean isSubmitButtonDisplayed() {
		return submitbutton.isDisplayed();
	}
}
