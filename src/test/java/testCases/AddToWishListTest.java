package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToWishListTest extends TestBase
{
	HomePage homeOgj;
	SearchPage searchObj;
	ProductDetailsPage prodObj;
	
	@Test (priority = 1)
	public void UserCansearchforproduct()
	{
		searchObj = new SearchPage(driver);
		prodObj = new ProductDetailsPage(driver);
		searchObj.searchusingautocomplete("asus");
	}
	@Test(priority = 2)
	public void userCanAddprod2wishlist()
	{
		prodObj = new ProductDetailsPage(driver);
		prodObj.Addtowishlist();
		homeOgj= new HomePage(driver);
		homeOgj.openWishlist();
		Assert.assertTrue(prodObj.prodName.getText().contains("Asus N551JK-XO076H Laptop"));
	}
}
