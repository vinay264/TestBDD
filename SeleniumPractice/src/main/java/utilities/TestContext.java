package utilities;

import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;

	public TestContext() {
		driverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
		scenarioContext = new ScenarioContext();
	}

	public DriverManager getDriverManager() {
		return driverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}
