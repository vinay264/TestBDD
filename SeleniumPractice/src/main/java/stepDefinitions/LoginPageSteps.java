package stepDefinitions;

import pageObjects.LoginPage;
import utilities.TestContext;

public class LoginPageSteps {

	TestContext testContext;
	LoginPage loginPage;
	
	public LoginPageSteps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}
}
