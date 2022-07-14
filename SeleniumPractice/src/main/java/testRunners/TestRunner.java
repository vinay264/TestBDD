package testRunners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src//main//java//featureFiles", 
				 tags = "@End2End_1", 
				 dryRun = false, 
				 glue = "stepDefinitions", 
				 plugin = {"pretty", 
						   "html:test-output/cucumber-reports/html-report.html",
						   "json:test-output/cucumber-reports/json-report.json",
						   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						   }, 
				 monochrome = true)

public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}
	
	@Test(groups = "cucumber scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runScenario(pickleEvent.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
		return testNGCucumberRunner.provideScenarios();
	}
	
}
