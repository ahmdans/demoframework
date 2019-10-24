package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(id="Email")
	WebElement emaillogined ;
	
	@FindBy(id="Password")
	WebElement passwordd;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")
	WebElement lgnBtn ; 
	
	public void userlogin(String email , String password)
	{
		SetTexttoElement(emaillogined, email);
		SetTexttoElement(passwordd, password);
		clickbutton(lgnBtn);
	}
}
