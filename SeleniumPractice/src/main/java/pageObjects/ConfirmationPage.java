package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class ConfirmationPage {

	WebDriver driver;
	BaseClass baseClass;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		baseClass = new BaseClass(driver);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "order")
	private WebElement orderNumber;
	
	@FindAll(@FindBy(how = How.CSS, using = ".order_item"))
	private List<WebElement> prd_List;
	
	@FindBy(how = How.CLASS_NAME, using = "entry-content")
	private WebElement orderContainer;
	
	public void takeScreenshotOfOrder() {
		baseClass.scrollToElement(orderContainer);
		baseClass.takeScreenshot();
	}
	
	public List<String> getProductNames() {
		baseClass.waitVisibleElement(orderContainer, 5);
		List<String> productNames = new ArrayList<>();
		for(WebElement element : prd_List) {
			productNames.add(element.findElement(By.cssSelector(".product-name")).getText());
		}
		return productNames;
	}
	
	

	
}
