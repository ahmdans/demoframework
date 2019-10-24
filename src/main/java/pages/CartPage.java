package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends PageBase
{
	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(id = "termsofservice")
	WebElement termsconditionsBtn;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/input[1]")
	WebElement checkoutAsguestBtn;
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement FirstName;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastName;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement Email;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement Country;
	
	/*@FindBy(id="BillingNewAddress_City")
	WebElement City;*/
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement Address;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement ZipCode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement PhoneNumber;
	
	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
	WebElement ContinueBtn;
	
	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement ContinueBtn2;
	
	//@FindBy(id = "paymentmethod_1")
	//WebElement paymentradioBtn;
	
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement ContinueBtn3;
	
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement ContinueBtn4;
	
	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement ConfirmBtn;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
	public WebElement successMsg;
	
	public void buyAproductAsguest(String Fname,String Lname ,String mail, String Address ,String zipcode, String phonenumber )
	{
		clickbutton(termsconditionsBtn);
		clickbutton(checkoutBtn);
		clickbutton(checkoutAsguestBtn);
		SetTexttoElement(FirstName, Fname);
		SetTexttoElement(lastName, Lname);
		SetTexttoElement(Email, mail);
		select = new Select(Country);
		select.deselectByIndex(1);
		SetTexttoElement(this.Address, Address);
		SetTexttoElement(ZipCode, zipcode);
		SetTexttoElement(PhoneNumber, phonenumber);
		clickbutton(ContinueBtn);
		clickbutton(ContinueBtn2);
		clickbutton(ContinueBtn3);
		clickbutton(ContinueBtn4);
		clickbutton(ConfirmBtn);
	}
}
