package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase
{ 

	public SearchPage(WebDriver driver)
	{
		super(driver); 
	}
	@FindBy(id = "small-searchterms")
	WebElement searchbox ;
	
	@FindBy(xpath = "//*[@id=\"small-search-box-form\"]/input[2]")
	WebElement searchBtn; 
	
	@FindBy(id = "ui-id-2")
	List<WebElement> autocomplete ;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement proTitle ;
	
	public void productsearch(String query)
	{
		SetTexttoElement(searchbox, query);
		clickbutton(searchBtn);
 	}
	public void openprodetails()
	{
		clickbutton(proTitle);
	}
	public void searchusingautocomplete(String srchtxt)
	{
		SetTexttoElement(searchbox, srchtxt);
		autocomplete.get(0).click();; 
	}
	
}
