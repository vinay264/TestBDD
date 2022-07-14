package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class CartPage {

	WebDriver driver;
	BaseClass baseClass;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		baseClass = new BaseClass(driver);
	}
	
	@FindBy(how = How.CSS, using = ".cart-button")
	private WebElement btn_Cart;

	@FindBy(how = How.CSS, using = ".checkout-button.alt")
	private WebElement btn_ContinueToCheckout;

	public void clickOn_Cart() {
		btn_Cart.click();
	}

	public void clickOn_ContinueToCheckout() {
		btn_ContinueToCheckout.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

}
