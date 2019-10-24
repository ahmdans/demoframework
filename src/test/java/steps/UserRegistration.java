package steps;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import com.github.javafaker.Faker;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.UserregistrationPage;
import testCases.TestBase;

public class UserRegistration extends TestBase
{
	HomePage homeObj;
	UserregistrationPage regObj;
	/*Faker fakerData = new Faker(); 
	String firstname = fakerData.name().firstName();
	String lastname = fakerData.name().lastName();
	String emailfake= fakerData.internet().emailAddress();
	String password = fakerData.number().digits(8).toString();*/
	
	@Given("^the user in the home page$")
	public void the_user_in_home_page()
	{
		homeObj= new HomePage(driver);
		homeObj.openreglink();
	}
	@When("^i click on the register link$")
	public void i_clickon_regiter_link()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	/*@When("^i entered the user data$")
	public void i_entered_Data()
	{
		regObj = new UserregistrationPage(driver);
		regObj.userRegistration(firstname, lastname, emailfake, password);
	}*/
	@When("i entered {string},{string},{string},{string}")
	public void i_entered_Data(String firstname,String lastname,String email,String password)
	{
		regObj = new UserregistrationPage(driver);
		regObj.userRegistration(firstname,lastname,email,password);
	}
	@Then("^i can register to the web site$")
	public void i_can_register_tothe_websit()
	{
		regObj.userlogout();
	}
}
