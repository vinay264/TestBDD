package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class LoginPage {

	WebDriver driver;
	BaseClass baseClass;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		baseClass = new BaseClass(driver);
	}
	
	@FindBy(id = "username")
	WebElement loginUsername;

	@FindBy(id = "password")
	WebElement loginPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginBtn;

	@FindBy(id = "reg_username")
	WebElement regUsername;

	@FindBy(id = "reg_email")
	WebElement regEmail;

	@FindBy(id = "reg_password")
	WebElement regPassword;

	@FindBy(xpath = "//button[text()='Register']")
	WebElement regBtn;

	public void Register_Action(String uName, String email, String pwd) {
		regUsername.sendKeys(uName);
		regEmail.sendKeys(email);
		regPassword.sendKeys(pwd);
		regBtn.click();
	}

	public void LogIn_Action(String uName, String pwd) {
		loginUsername.sendKeys(uName);
		loginPassword.sendKeys(pwd);
		loginBtn.click();
	}
}
