package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class ProductPage {

	WebDriver driver;
	BaseClass baseClass;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		baseClass = new BaseClass(driver);
	}

	@FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	private List<WebElement> prd_List;

	@FindBy(how = How.ID, using = "pa_color")
	private WebElement ddown_color;

	@FindBy(how = How.ID, using = "pa_size")
	private WebElement ddown_size;

	@FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
	private WebElement btn_AddToCart;

	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
	}

	public String getProductName(int productNumber) {
		return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
	}

	public void select_color_and_size(String color, String size) {
		baseClass.selectOptionByText(ddown_color, color);
		baseClass.selectOptionByText(ddown_size, size);
	}

	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}
}
