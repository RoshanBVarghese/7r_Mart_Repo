package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Page {

	WebDriver driver;

	public Product_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")
//	private WebElement productmoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	private WebElement delete;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;

//	public void clickMoreinfoProductPage() {
//		productmoreinfo.click();
//	}

	public void clickDeletebutton() {
		delete.click();
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
	}

	public boolean isAlertboxDisplayed() {
		return alertbox.isDisplayed();
	}

}
