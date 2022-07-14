package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import utilities.BaseClass;

public class HomePage {

	WebDriver driver;
	BaseClass baseClass;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		baseClass = new BaseClass(driver);
	}
	
	@FindBy(linkText = "Dismiss")
	WebElement dismissBtn;
	
	@FindBy(xpath = "//div[@class='navbar-wrapper']//a[@class='noo-search']")
	WebElement searchBtn;
	
	@FindBy(linkText = "My Account")
	WebElement myAccountBtn;
	
	@FindBy(linkText = "Checkout")
	WebElement checkoutBtn;
	
	@FindBy(xpath = "//input[@name='s']")
	WebElement searchBox;
	
	public void dismiss_TestPage_info() {
		dismissBtn.click();
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getHomePageUrl());
		dismissBtn.click();
	}
	
	public void navigateTo_LoginPage() {
		myAccountBtn.click();
	}
	
	public void navigateTo_CheckoutPage() {
		checkoutBtn.click();
	}
	
	public void perform_Search(String search) {
		searchBtn.click();
		baseClass.waitVisibleElement(searchBox, 3).sendKeys(Keys.chord(search, Keys.ENTER));
	}
	
}
