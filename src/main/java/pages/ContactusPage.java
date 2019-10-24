package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactusPage extends PageBase
{

	public ContactusPage(WebDriver driver) 
	{
		super(driver);
	}	
	@FindBy(id = "FullName")
	WebElement fullName; 
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id="Enquiry")
	WebElement enquiry;  
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/input")
	WebElement submitBtn;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
	public WebElement SuccessMsg;
	
	public void contacUs (String Fulname, String emaill , String enquiryy)
	{
		SetTexttoElement(fullName, Fulname);
		SetTexttoElement(email, emaill);
		SetTexttoElement(enquiry, enquiryy);
		clickbutton(submitBtn);
	}
}
