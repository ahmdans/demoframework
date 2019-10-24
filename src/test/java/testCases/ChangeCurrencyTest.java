package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

public class ChangeCurrencyTest extends TestBase
{
	HomePage homeObj;
	ProductDetailsPage proddetObj;
	@Test 
	public void changecurrencylist()
	{
		homeObj = new HomePage(driver);
		proddetObj = new ProductDetailsPage(driver);
		homeObj.changeCurrency();
		Assert.assertTrue(proddetObj.price.getText().contains("Ђ1548.00"));
		System.out.print("currency changed ya prince");
	}
}
