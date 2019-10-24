package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ReviewPage;
import pages.SearchPage;
import pages.UserregistrationPage;

public class ReviewTest extends TestBase
{
	HomePage homeObj;
	ProductDetailsPage prodObj;
	ReviewPage revObj; 
	SearchPage searchObj ; 
	UserregistrationPage regObj;  

	// registration test method 
	@Test(priority = 1)
	public void userregistrationsuccessfully() 
	{
		homeObj = new HomePage(driver);
		homeObj.openreglink();
		regObj = new UserregistrationPage(driver);
		regObj.userRegistration("Ahmad","Hamdy","ahmad@hamdy.com","asd2102535");
		//Assert.assertTrue(regObj.regresult.getText().contains("Your registration completed"));
	}
	@Test (priority = 2)
	public void UserCansearchforproduct()
	{
		searchObj = new SearchPage(driver);
		prodObj = new ProductDetailsPage(driver);
		searchObj.searchusingautocomplete("MAC"); 
		//Assert.assertTrue(prodObj.ProductfromSearchresult.getText().equalsIgnoreCase(productname));
	}
	@Test (priority = 3)
	public void reguserCanAddReview()
	{
		prodObj=new ProductDetailsPage(driver);
		prodObj.openReviewPage();
		revObj=new ReviewPage(driver);
		revObj.Addreview("Test Review Title ", "Test Review Text");
		Assert.assertTrue(revObj.revsuccessMsg.getText().contains("Existing reviews"));
		System.out.println("review added successfully ya abo elso7ab =D  ");
		//System.out.println(revObj.revsuccessMsg.getText());
	}
}
