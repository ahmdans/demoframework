package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Email2FriendPage extends PageBase
{
	public Email2FriendPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id="FriendEmail")
	WebElement frindmail;
	
	/*@FindBy(id = "YourEmailAddress")
	WebElement urmail;*/
	
	@FindBy(id = "PersonalMessage")
	WebElement personalmsg;
	
	@FindBy(xpath= "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/input")
	WebElement sendmailBtn;
	
	@FindBy(xpath ="/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
	public WebElement successMsg;
	
	public void usercansendmail2friend(String Fmail , String MSG)
	{
		SetTexttoElement(frindmail, Fmail);
		SetTexttoElement(personalmsg, MSG);
		clickbutton(sendmailBtn);
	}
}
