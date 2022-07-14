package stepDefinitions;

import io.cucumber.java.en.When;
import pageObjects.CartPage;
import utilities.TestContext;

public class CartPageSteps {
	
	TestContext testContext;
	CartPage cartPage;
	
	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}
	
	@When("user moves to checkout from mini cart")
	public void moves_to_checkout_from_mini_cart(){
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
	}

}
