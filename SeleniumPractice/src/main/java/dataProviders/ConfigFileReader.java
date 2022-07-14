package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "E:\\SeleniumPractice\\src\\main\\java\\configs\\Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public long getImplicitWaitTime() {
		String implicitWaitTime = properties.getProperty("implicitWaitTime");
		if (implicitWaitTime != null)
			return Long.parseLong(implicitWaitTime);
		else
			throw new RuntimeException("implicitWaitTime not specified in the Configuration.properties file.");
	}

	public String getHomePageUrl() {
		String homePageURL = properties.getProperty("homePageURL");
		if (homePageURL != null)
			return homePageURL;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getBrowserName() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return "chrome";
		else if (browserName.equalsIgnoreCase("firefox"))
			return browserName;
		else if (browserName.equals("ie"))
			return browserName;
		else if (browserName.equals("edge"))
			return browserName;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	public String getPersonalDetailsJsonPath() {
		String personalDetailsJsonPath = properties.getProperty("personalDetailsJsonPath");
		if (personalDetailsJsonPath != null)
			return personalDetailsJsonPath;
		else
			throw new RuntimeException(
					"Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
	}

}
