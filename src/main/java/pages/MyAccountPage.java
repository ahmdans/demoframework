package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase
{

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
	WebElement changePasswordpage;
	
	@FindBy(xpath ="//*[@id=\"OldPassword\"]")
	WebElement oldpasswordTxtbox;
	
	@FindBy(id="NewPassword")
	WebElement newpasswordTxtbox;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confnewpasswordTxtbox;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/input")
	WebElement ChangePasswordBtn;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div")
	public WebElement passchangesuccessmsg;
	
	public void openchangePasswordPge ()
	{
		clickbutton(changePasswordpage);
	}
	public void changepassword(String Oldpass , String Newpass)
	{
		SetTexttoElement(oldpasswordTxtbox, Oldpass);
		SetTexttoElement(newpasswordTxtbox, Newpass);
		SetTexttoElement(confnewpasswordTxtbox, Newpass);
		clickbutton(ChangePasswordBtn);
	}
}
