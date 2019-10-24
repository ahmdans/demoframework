package runner;

import cucumber.api.CucumberOptions;

import testCases.TestBase;

@CucumberOptions  
		(
		features = "src\\test\\java\\features",
		glue	 = {"steps"},
		plugin 	 = {"pretty","html:target\\cucumber-html-report"}
		)
public class TestRunner extends TestBase
{

}
