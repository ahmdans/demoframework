package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactusPage;
import pages.HomePage;

public class ContactUsTest extends TestBase
{
	String name = "Ahmad Hamdy ";
	String mail = "asd@asd.com";
	String eNqiury = "how to create abc";
	ContactusPage contactusObj; 
	HomePage homeObj;
	@Test
	public void userCancontactUs()
	{
		homeObj = new HomePage(driver);
		homeObj.opencontactuspage();
		contactusObj = new ContactusPage(driver);
		contactusObj.contacUs(name, mail, eNqiury);
		Assert.assertTrue(contactusObj.SuccessMsg.getText().equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));
	} 
}
