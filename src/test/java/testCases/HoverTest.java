package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
public class HoverTest extends TestBase
{
	HomePage homeObj;
	 
	@Test
	public void usercanHoverItem()
	{
		homeObj= new HomePage(driver);
		homeObj.hoverinitem(); 
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
