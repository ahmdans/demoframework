package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserregistrationPage;

public class UserregistrationtestcaseDDTandJSON extends TestBase
{
	HomePage homeObj ;
	UserregistrationPage regObj ; 
	LoginPage lgnObj;
	CSVReader reader ;

	// registration test method 
	@Test(priority = 1 , alwaysRun = true)
	public void userregistrationsuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openreglink();
		regObj = new UserregistrationPage(driver);
		//	regObj.userRegistration(firstname,lastname,mail,pass);
		Assert.assertTrue(regObj.regresult.getText().contains("Your registration completed"));
		regObj.userlogout();
		lgnObj=new LoginPage(driver);
		homeObj.openloginPage();
		//	lgnObj.userlogin(mail, pass);
		regObj.userlogout();
	}
}
