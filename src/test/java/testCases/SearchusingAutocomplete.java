package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchusingAutocomplete extends TestBase
{
	String productname = "Apple MacBook Pro 13-inch";
	SearchPage searchObj ; 
	ProductDetailsPage proObj ;
	
	@Test 
	public void UserCansearchforproduct()
	{
		searchObj = new SearchPage(driver);
		proObj = new ProductDetailsPage(driver);
		searchObj.searchusingautocomplete("asus");
		Assert.assertTrue(proObj.ProductfromSearchresult.getText().equalsIgnoreCase(productname));
	}
}
 