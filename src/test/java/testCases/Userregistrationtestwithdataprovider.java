package testCases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserregistrationPage;

public class Userregistrationtestwithdataprovider extends TestBase
{
	HomePage homeObj ;
	UserregistrationPage regObj ; 
	LoginPage lgnObj;

	@DataProvider (name = "testdataReg")
	public static Object[][] userdata()
	{ 
		return new Object [][]
				{
					{"esraa","saber","esraa11452220000@gmaillll.com","123456"}
					,
					{"ahmad","hamdi","ana450s1a2ns@gmailll.com","1234568"}
					,
					{"hamdiii","ali","ali04521aaa@djkf.com","PassW0rd"}
				};
	}
	// registration test method 
	@Test(priority = 1 , alwaysRun = true , dataProvider = "testdataReg")
	public void userregistrationsuccessfully(String stName,String ndname ,String email,String pass) 
	{
		homeObj = new HomePage(driver);
		homeObj.openreglink();
		regObj = new UserregistrationPage(driver);
		regObj.userRegistration(stName,ndname,email,pass);
		Assert.assertTrue(regObj.regresult.getText().contains("Your registration completed"));
		regObj.userlogout();
		lgnObj=new LoginPage(driver);
		homeObj.openloginPage();
		lgnObj.userlogin(email, pass);
		Assert.assertTrue(regObj.logoutBtn.isDisplayed());
		regObj.userlogout();
	}
}
