package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Email2FriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserregistrationPage;

public class Email2friendTest extends TestBase
{

	HomePage homeObj ;
	UserregistrationPage regObj ; 
	String productname = "Apple MacBook Pro 13-inch";
	SearchPage searchObj ; 
	ProductDetailsPage proObj ;
	Email2FriendPage mailObj;
	String FRiendmail = "wer@wer.com";
	String personalMsg = "Hello my friend , i recommend this product for you ";

	// registration test method 
	@Test
	public void userregistrationsuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openreglink();
		regObj = new UserregistrationPage(driver);
		regObj.userRegistration("Ahmad","Hamdy","esso@eseso.com","asd2102535");
		Assert.assertTrue(regObj.regresult.getText().contains("Your registration completed"));
	}
	
	// user search for product 
	@Test 
	public void UserCansearchforproduct()
	{
		searchObj = new SearchPage(driver);
		proObj = new ProductDetailsPage(driver);
		searchObj.searchusingautocomplete("MAC");
		Assert.assertTrue(proObj.ProductfromSearchresult.getText().equalsIgnoreCase(productname));
	}
	
	// user can send mail 2 friend 
	@Test 
	public void userCanSendMAil2Friend()
	{
		proObj = new ProductDetailsPage(driver);
		proObj.openSendEmail();
		mailObj = new Email2FriendPage(driver);
		mailObj.usercansendmail2friend(FRiendmail, personalMsg);
		Assert.assertTrue(mailObj.successMsg.getText().equalsIgnoreCase("Your message has been sent."));
	}
	
	// logout test method 
	@Test(dependsOnMethods = "userregistrationsuccessfully")
	public void usercanlogoutsuccessfully()
	{
		regObj.userlogout();
	}
}
