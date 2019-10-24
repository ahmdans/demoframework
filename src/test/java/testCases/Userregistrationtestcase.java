package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserregistrationPage;

public class Userregistrationtestcase extends TestBase
{
	HomePage homeObj ;
	UserregistrationPage regObj ; 
	LoginPage lgnObj;
	
	// registration test method 
	@Test(priority = 1 , alwaysRun = true)
	public void userregistrationsuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openreglink();
		regObj = new UserregistrationPage(driver);
		regObj.userRegistration("Ahmad","Hamdy","testw3cw3c@ttestttt.com","asd2102535");
		Assert.assertTrue(regObj.regresult.getText().contains("Your registration completed"));
	}
	
	// logout test method 
	@Test(dependsOnMethods = "userregistrationsuccessfully")
	public void usercanlogoutsuccessfully()
	{
		regObj.userlogout();
	}
	
	// login test method 
	@Test(dependsOnMethods = "usercanlogoutsuccessfully")
	public void usercanloginsuccessfully()
	{
		lgnObj=new LoginPage(driver);
		homeObj.openloginPage();
		lgnObj.userlogin("testw3cw3c@ttestttt.com", "asd2102535");
		Assert.assertTrue(regObj.logoutBtn.isDisplayed());
	}
}
