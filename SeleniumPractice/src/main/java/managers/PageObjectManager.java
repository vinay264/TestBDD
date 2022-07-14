package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.ProfilePage;

public class PageObjectManager {

	private WebDriver driver;

	private ProductPage productPage;

	private CartPage cartPage;

	private HomePage homePage;

	private CheckoutPage checkoutPage;
	
	private LoginPage loginPage;
	
	private ProfilePage profilePage;
	
	private ConfirmationPage confirmationPage;
	
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public HomePage getHomePage() {

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}

	public ProductPage getProductPage() {

		return (productPage == null) ? productPage = new ProductPage(driver) : productPage;

	}

	public CartPage getCartPage() {

		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;

	}

	public CheckoutPage getCheckoutPage() {

		return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;

	}
	
	public LoginPage getLoginPage() {

		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

	}
	
	public ProfilePage getProfilePage() {

		return (profilePage == null) ? profilePage = new ProfilePage(driver) : profilePage;

	}
	
	public ConfirmationPage getConfirmationPage() {

		return (confirmationPage == null) ? confirmationPage = new ConfirmationPage(driver) : confirmationPage;

	}
	
}
