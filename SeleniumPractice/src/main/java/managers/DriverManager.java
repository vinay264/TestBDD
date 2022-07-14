package managers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private WebDriver driver;
	private String browserName;

	public DriverManager() {
		browserName = FileReaderManager.getInstance().getConfigReader().getBrowserName();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
			break;
		}

		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(
				Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicitWaitTime()));
		return driver;
	}

	public void quitDriver() {
		driver.quit();
	}

}
