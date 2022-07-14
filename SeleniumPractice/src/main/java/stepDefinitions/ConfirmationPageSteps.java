package stepDefinitions;

import org.testng.Assert;

import enums.Context;
import io.cucumber.java.en.Then;
import pageObjects.ConfirmationPage;
import utilities.TestContext;

public class ConfirmationPageSteps {

	TestContext testContext;
	ConfirmationPage confirmationPage;

	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}
	
	@Then("take screenshot of order")
	public void takeScreenshot_ofOrder() {
		confirmationPage.takeScreenshotOfOrder();
	}
	
	@Then("verify the order details")
	public void verify_the_order_details(){
		String productName = (String)testContext.scenarioContext.getContext(Context.PRODUCT_NAME);
		Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.contains(productName.toLowerCase())).findFirst().get().length()>0);		
	}
	
}
