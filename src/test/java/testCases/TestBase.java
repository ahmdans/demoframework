package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import uility.Helper;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver ;
	@BeforeSuite
	@Parameters({"browser"})
	public void startdriver (@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\drivers\\chromedriver.exe") );
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+("\\drivers\\geckodriver.exe") );
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+("\\drivers\\IEDriverServer.exe") );
			driver = new InternetExplorerDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome-headless")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\drivers\\chromedriver.exe") );
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("headless"))
		{
			String PATH=System.getProperty("user.dir")+("\\drivers\\phantomjs.exe") ;
			DesiredCapabilities caps= new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,PATH);
			String [] phantomjsArgus = {"--web-security=no","--ignore-ssl-errors=yes","--webdriver-loglevel=NONE"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, phantomjsArgus);
			driver = new PhantomJSDriver(caps);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	@AfterSuite
	public void Teardowndriver ()
	{
		driver.quit();
	}
	@AfterMethod
	public void takeScreenshotonFailure(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("this test case is failed -->> taking screenshot ....");
			Helper.CaptureScreenshot(driver, result.getTestName());
		}
	}

}
