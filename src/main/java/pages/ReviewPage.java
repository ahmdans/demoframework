package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends PageBase
{

	public ReviewPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitle; 
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxt; 
	
	//@FindBy(id = "addproductrating_5")
	//WebElement rate ; 
	
	@FindBy(xpath  = "//*[@id=\"review-form\"]/form/div[2]/input")
	WebElement submitreviewBtn;
	
	@FindBy(className = "result" )
	public WebElement revsuccessMsg; 
	
	public void Addreview(String revtitle, String revTxt )
	{
		SetTexttoElement(reviewTitle, revtitle);
		SetTexttoElement(reviewTxt, revTxt);
		//clickbutton(rate);
	}

}
