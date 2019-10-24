package testCases;
 
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchproductTest extends TestBase
{
	String productname = "Apple MacBook Pro 13-inch";
	SearchPage searchObj ; 
	ProductDetailsPage proObj ;
	
	@Test 
	public void UserCansearchforproduct()
	{
		searchObj = new SearchPage(driver);
		proObj = new ProductDetailsPage(driver);
		searchObj.productsearch(productname);
		searchObj.openprodetails();
		Assert.assertTrue(proObj.ProductfromSearchresult.getText().equalsIgnoreCase(productname));
	}
}
