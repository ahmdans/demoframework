package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserregistrationPage;

public class MyAccountTests extends TestBase
{
	HomePage homeObj ;
	UserregistrationPage regObj ; 
	LoginPage lgnObj;
	MyAccountPage myaccObj;
	
	String Opass="12321112025135";
	String Npass= Opass+11;
	String E_mail="ahmaasdd.ham1v54tyty5bbdy@as1ga5455tech.com";
	// user registration 
	@Test(priority = 1)
	public void userregistrationsuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openreglink();
		regObj = new UserregistrationPage(driver);
		regObj.userRegistration("Ahmad","Hamdy",E_mail,Opass);
		Assert.assertTrue(regObj.regresult.getText().contains("Your registration completed"));
	}
	// change password
	@Test (priority = 2)
	public void usercnchangepassword()
	{
		myaccObj=new MyAccountPage(driver);
		regObj.openmyAccpage();
		myaccObj.openchangePasswordPge();
		myaccObj.changepassword(Opass, Npass);
		Assert.assertTrue(myaccObj.passchangesuccessmsg.isDisplayed());
	}

	// logout test method 
	@Test(priority = 3)
	public void usercanlogoutsuccessfully()
	{
		regObj.userlogout();
	}
	
	// login test method 
	@Test(priority = 4)
	public void usercanloginsuccessfully()
	{
		lgnObj=new LoginPage(driver);
		homeObj.openloginPage();
		lgnObj.userlogin(E_mail, Npass);
		Assert.assertTrue(regObj.logoutBtn.isDisplayed());
	}
}
