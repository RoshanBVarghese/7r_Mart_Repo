package pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Wait_Utility;


public class Login_Page {

	WebDriver driver;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement button;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertbox;

	public Login_Page enterUsername(String username_value) {
		usernameField.sendKeys(username_value);
		return this;
	}

	public Login_Page enterPassword(String password_value) {
		password.sendKeys(password_value);
		return this;
	}

	public LogOut_Page clickonSigninButton() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(button));
//		button.click();
		
//		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(5))
//				.ignoring(NoSuchElementException.class);
//				fluentWait.until(ExpectedConditions.elementToBeClickable(button));
//				button.click();
		Wait_Utility waitutility = new Wait_Utility();
		waitutility.waitForClick(driver, button);
		button.click();
		return new LogOut_Page(driver);
	}
	
	public boolean isDashboardLoaded() {
		return dashboard.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alertbox.isDisplayed();
	}

}
