package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserregistrationPage;

public class UserregistrationtestcaseWithJavaFaker extends TestBase
{
	HomePage homeObj ;
	UserregistrationPage regObj ; 
	LoginPage lgnObj;
	Faker fakerData = new Faker(); 
	String firstname = fakerData.name().firstName();
	String lastname = fakerData.name().lastName();
	String emailfake= fakerData.internet().emailAddress();
	String password = fakerData.number().digits(8).toString();
	
	// registration test method 
	@Test(priority = 1 , alwaysRun = true)
	public void userregistrationsuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openreglink();
		regObj = new UserregistrationPage(driver);
		regObj.userRegistration(firstname,lastname,emailfake,password);
		System.out.println("the user data is  "+firstname +" "+lastname+" "+emailfake+" "+password);
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
		lgnObj.userlogin(emailfake,password);
		Assert.assertTrue(regObj.logoutBtn.isDisplayed());
	}
}
