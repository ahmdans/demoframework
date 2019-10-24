package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserregistrationPage;

public class UserregistrationtestcasewithDDTandEXcel extends TestBase
{
	HomePage homeObj ;
	UserregistrationPage regObj ; 
	LoginPage lgnObj;
	@DataProvider (name="USERdata")
	public Object [][] userregisterdata() throws IOException
	{
		ExcelReader EXcelreader = new  ExcelReader();
		return EXcelreader.Getexceldata();
	}
	// registration test method 
	@Test(priority = 1 , alwaysRun = true , dataProvider = "USERdata")
	public void userregistrationsuccessfully(String firstname, String lastname , String mail , String pass) 
	{
		homeObj = new HomePage(driver);
		homeObj.openreglink();
		regObj = new UserregistrationPage(driver);
		regObj.userRegistration(firstname,lastname,mail,pass);
		Assert.assertTrue(regObj.regresult.getText().contains("Your registration completed"));
		regObj.userlogout();
		lgnObj=new LoginPage(driver);
		homeObj.openloginPage();
		lgnObj.userlogin(mail, pass); 
		regObj.userlogout();
	}
}
