package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.TestContext;

public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("user is on Home Page")
	public void userInHomePage(){
		homePage.navigateTo_HomePage();	
	}

	@When("user searches for {string}")
	public void he_search_for(String arg1)  {
		homePage.perform_Search(arg1);
	}

}
