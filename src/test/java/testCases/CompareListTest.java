package testCases;

import org.testng.annotations.Test;

import pages.SearchPage;

public class CompareListTest extends TestBase 
{
	SearchPage searchObj ; 	
	@Test (priority = 1)
	public void UserCansearchforproduct()
	{
		searchObj = new SearchPage(driver);
		searchObj.searchusingautocomplete("asus");
	}
	
}
