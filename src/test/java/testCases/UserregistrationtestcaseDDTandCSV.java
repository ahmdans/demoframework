package testCases;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserregistrationPage;

public class UserregistrationtestcaseDDTandCSV extends TestBase
{
	HomePage homeObj ;
	UserregistrationPage regObj ; 
	LoginPage lgnObj;
	CSVReader reader ;
	
	// registration test method 
	
	@Test(priority = 1 , alwaysRun = true)
	public void userregistrationsuccessfully() throws IOException 
	{
		String csv_file= System.getProperty("user.dir")+"\\src\\test\\java\\data\\usersdata.csv";
		reader = new CSVReader(new FileReader(csv_file));
		String[] CSVcel;
		while ((CSVcel = reader.readNext())!=null)
		{
			String firstname = CSVcel[0];
			String lastname  = CSVcel[1];
			String mail      = CSVcel[2];
			String pass      = CSVcel[3];
			homeObj = new HomePage(driver);
			homeObj.openreglink();
			regObj = new UserregistrationPage(driver);
			regObj.userRegistration(firstname,lastname,mail,pass);
			Assert.assertTrue(regObj.regresult.getText().contains("Your registration completed"));
			regObj.userlogout();
			lgnObj=new LoginPage(driver);
			homeObj.openloginPage();
			lgnObj.userlogin(mail, pass);
			regObj.userlogout();
		}
		
	}
}
