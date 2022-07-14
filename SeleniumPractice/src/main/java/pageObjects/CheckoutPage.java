package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import configs.PersonalDetails;
import utilities.BaseClass;

public class CheckoutPage {

	WebDriver driver;
	BaseClass baseClass;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		baseClass = new BaseClass(driver);
	}

	@FindBy(how = How.CSS, using = "#billing_first_name")
	private WebElement txtbx_FirstName;

	@FindBy(how = How.CSS, using = "#billing_last_name")
	private WebElement txtbx_LastName;

	@FindBy(how = How.CSS, using = "#billing_email")
	private WebElement txtbx_Email;

	@FindBy(how = How.CSS, using = "#billing_phone")
	private WebElement txtbx_Phone;

//	@FindBy(how = How.CSS, using = "#billing_country_field .select2-arrow")
//	private WebElement drpdwn_CountryDropDownArrow;
//
//	@FindBy(how = How.CSS, using = "#billing_state_field .select2-arrow")
//	private WebElement drpdwn_CountyDropDownArrow;

	@FindBy(how = How.ID, using = "billing_country")
	private WebElement ddown_country;

	@FindBy(how = How.ID, using = "billing_state")
	private WebElement ddown_state;

//	@FindAll(@FindBy(how = How.CSS, using = "#select2-drop ul li"))
//	private List<WebElement> country_List;

	@FindBy(how = How.CSS, using = "#billing_city")
	private WebElement txtbx_City;

	@FindBy(how = How.CSS, using = "#billing_address_1")
	private WebElement txtbx_Address;

	@FindBy(how = How.CSS, using = "#billing_postcode")
	private WebElement txtbx_PostCode;

	@FindBy(how = How.CSS, using = "#ship-to-different-address-checkbox")
	private WebElement chkbx_ShipToDifferetAddress;

	@FindAll(@FindBy(how = How.CSS, using = "ul.wc_payment_methods li"))
	private List<WebElement> paymentMethod_List;

	@FindBy(how = How.ID, using = "terms")
	private WebElement chkbx_AcceptTermsAndCondition;

	@FindBy(how = How.CSS, using = "#place_order")
	private WebElement btn_PlaceOrder;

	public void fill_PersonalDetails(PersonalDetails personalDetails) {
		txtbx_FirstName.sendKeys(personalDetails.firstName);
		txtbx_LastName.sendKeys(personalDetails.lastName);
		baseClass.selectOptionByText(ddown_country, personalDetails.address.country);
		txtbx_Address.sendKeys(personalDetails.address.streetAddress);
		txtbx_City.sendKeys(personalDetails.address.city);
		baseClass.selectOptionByText(ddown_state, personalDetails.address.state);
		txtbx_PostCode.sendKeys(personalDetails.address.postCode);
		txtbx_Phone.sendKeys(personalDetails.phoneNumber.mob);
		txtbx_Email.sendKeys(personalDetails.emailAddress);

//		select_Country(personalDetails.address.country);
//		select_County(personalDetails.address.county);
	}

	public void check_TermsAndCondition(boolean value) throws InterruptedException {
		if (value) {
			baseClass.scrollToElement(txtbx_Address);
//			baseClass.waitClickableElement(chkbx_AcceptTermsAndCondition, 10).click();
			Thread.sleep(3000);
			chkbx_AcceptTermsAndCondition.click();
		}
	}

	public void clickOn_PlaceOrder() {
		btn_PlaceOrder.submit();
	}

	public void check_ShipToDifferentAddress(boolean value) {
		if (!value)
			chkbx_ShipToDifferetAddress.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}

	public void select_PaymentMethod(String paymentMethod) {
		if (paymentMethod.equals("CheckPayment")) {
			paymentMethod_List.get(0).click();
		} else if (paymentMethod.equals("Cash")) {
			paymentMethod_List.get(1).click();
		} else {
			new Exception("Payment Method not recognised : " + paymentMethod);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

	}

//	public void select_Country(String countryName) {
//		drpdwn_CountryDropDownArrow.click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//		}
//
//		for (WebElement country : country_List) {
//			if (country.getText().equals(countryName)) {
//				country.click();
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//				}
//				break;
//			}
//		}
//	}
//
//	public void select_County(String countyName) {
//		drpdwn_CountyDropDownArrow.click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//		}
//
//		for (WebElement county : country_List) {
//			if (county.getText().equals(countyName)) {
//				county.click();
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//				}
//				break;
//			}
//		}
//	}

}
