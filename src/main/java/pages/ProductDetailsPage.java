package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase
{

	public ProductDetailsPage(WebDriver driver) 
	{
		super(driver); 
	}
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[1]/h1")
	public WebElement ProductfromSearchresult;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[1]/span")
	public WebElement price; 
	
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[10]/div[3]/input")
	WebElement emailBtn;
	
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[3]/div[2]/a[2]")
	WebElement reviewBTn; 
	
	@FindBy(id = "add-to-wishlist-button-5")
	WebElement add2wishlistBtn; 
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[5]/a")
	public WebElement prodName;
	//@FindBy(xpath = "/html/body/div[6]/div[3]/div[2]/div[2]/div/div[1]/h1")
	//public WebElement notebookh;
	
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[8]/div[2]/input")
	WebElement Add2compareBtn;
	
	@FindBy(id = "add-to-cart-button-5")
	WebElement addtocartBtn; 
	
	public void openSendEmail()
	{
		clickbutton(emailBtn);
	}
	public void openReviewPage()
	{
		clickbutton(reviewBTn);
	}
	public void Addtowishlist()
	{
		clickbutton(add2wishlistBtn);
	}
	public void clickonaddtocompare()
	{
		clickbutton(add2wishlistBtn);
	}
	public void clickonaddtocart()
	{
		clickbutton(addtocartBtn);
	}
}
