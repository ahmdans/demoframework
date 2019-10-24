package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserregistrationPage;

public class UserregistrationtestcaseDDTproperties extends TestBase
{
	HomePage homeObj ;
	UserregistrationPage regObj ; 
	LoginPage lgnObj;
	String FirstName = LoadProperties.userdata.getProperty("firstname");
	String LastName = LoadProperties.userdata.getProperty("lastname");
	String MAil = LoadProperties.userdata.getProperty("mail");
	String Password = LoadProperties.userdata.getProperty("pawwoerd");
	// registration test method 
	@Test(priority = 1 , alwaysRun = true)
	public void userregistrationsuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openreglink();
		regObj = new UserregistrationPage(driver);
		regObj.userRegistration(FirstName,LastName,MAil,Password);
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
		lgnObj.userlogin(MAil,Password);
		Assert.assertTrue(regObj.logoutBtn.isDisplayed());
	}
}
