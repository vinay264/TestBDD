package stepDefinitions;

import pageObjects.ProfilePage;
import utilities.TestContext;

public class ProfilePageSteps {

	TestContext testContext;
	ProfilePage profilePage;
	
	public ProfilePageSteps(TestContext context) {
		testContext = context;
		profilePage = testContext.getPageObjectManager().getProfilePage();
	}
	
}
