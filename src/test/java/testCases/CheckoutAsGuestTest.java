package testCases;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CheckoutAsGuestTest extends TestBase
{
	CartPage cartObj;
	SearchPage searchObj;
	ProductDetailsPage prodObj; 
	@Test 
	public void usercanBuyProductAsGuest()
	{
		searchObj = new SearchPage(driver);
		searchObj.searchusingautocomplete("asus");
		prodObj = new ProductDetailsPage(driver);
		prodObj.clickonaddtocart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		cartObj = new CartPage(driver);
		cartObj.buyAproductAsguest("ahmaaaad", "hammmdy", "abcccccccccc@ffffff.com", "testaddress", "12965", "01127662313");
		
	}
}
