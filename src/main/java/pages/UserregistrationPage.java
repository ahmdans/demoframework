package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserregistrationPage extends PageBase
{

	public UserregistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(className ="gender")
	WebElement GenderradioBtn;

	@FindBy(id="FirstName")
	WebElement firstname;

	@FindBy(id="LastName")
	WebElement lastName;

	@FindBy(id= "Email")
	WebElement email;

	@FindBy (id= "Password")
	WebElement password;

	@FindBy(id="ConfirmPassword")
	WebElement conpassword;

	@FindBy(id="register-button")
	WebElement regBtn;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/form/div/div[2]/div[1]")
	public WebElement regresult;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public WebElement logoutBtn;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	public WebElement myAccBtn;

	public void userRegistration(String FName,String Lname,String Email , String Password)
	{
		clickbutton(GenderradioBtn);
		SetTexttoElement(firstname, FName);
		SetTexttoElement(lastName, Lname);
		SetTexttoElement(email, Email);
		SetTexttoElement(password, Password);
		SetTexttoElement(conpassword, Password);
		clickbutton(regBtn);
	}

	public void userlogout()
	{
		clickbutton(logoutBtn);
	}

	public void openmyAccpage()
	{
		clickbutton(myAccBtn);
	}
}
