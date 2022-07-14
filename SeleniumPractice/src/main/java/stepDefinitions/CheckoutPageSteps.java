package stepDefinitions;

import configs.PersonalDetails;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.CheckoutPage;
import utilities.TestContext;

public class CheckoutPageSteps {

	TestContext testContext;
	CheckoutPage checkoutPage;

	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}
	
	@When("user enters {string} personal details on checkout page")
	public void enter_personal_details_on_checkout_page(String customerName){
		PersonalDetails personalDetails = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		checkoutPage.fill_PersonalDetails(personalDetails);
	}
	
	@When("user selects same delivery address")
	public void select_same_delivery_address(){
		checkoutPage.check_ShipToDifferentAddress(false);
	}
	
	@When("user selects payment method as {string}")
	public void select_payment_method_as_payment(String arg1){
		checkoutPage.select_PaymentMethod(arg1);
	}
	
	@When("user accepts terms and conditions")
	public void acceptTerms() throws InterruptedException {
		checkoutPage.check_TermsAndCondition(true);
	}

	@Then("place the order")
	public void placeOrder() {
		checkoutPage.clickOn_PlaceOrder();		
	}	

}
