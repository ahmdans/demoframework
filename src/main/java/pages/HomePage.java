package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase 
{

	public HomePage(WebDriver driver)
	{
		super(driver);
		jse=(JavascriptExecutor) driver ; 
		action = new Actions(driver);
	}
	@FindBy(linkText="Register")
	WebElement reglink ;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement loginBtn ; 
	
	@FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[1]/ul/li[6]/a")
	WebElement contactusBtn;
	
	@FindBy(id = "customerCurrency")
	WebElement currencylist ;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement comuterslist;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement notebookslist;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[1]")
	WebElement wishlist;
	
	public void openreglink () 
	{
		clickbutton(reglink);
	} 
	public void openloginPage ()
	{
		clickbutton(loginBtn);
	}
	public void opencontactuspage()
	{
		Scrolltobottom();
		clickbutton(contactusBtn);
	}
	public void changeCurrency ()
	{
		select = new Select(currencylist);
		select.selectByVisibleText("Euro");
	}
	public void hoverinitem()
	{
		action.moveToElement(comuterslist)
		.moveToElement(notebookslist)
		.click()
		.build()
		.perform();
	}
	public void openWishlist()
	{
		clickbutton(wishlist);
	}
}
