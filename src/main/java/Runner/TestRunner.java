package Runner;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
 features = "src\\main\\java\\featuresFile\\scenariooutlineexample.feature", 
 glue={"StepDefinitonFile"},
 format = { "pretty","html:test-output" ,
		 "json:jsonreport/cucumber.json","junit:juit_xmlreport/cucumber.xml"},
 dryRun = false,
 monochrome=true
 )

public class TestRunner {
	@AfterClass
	public static void setup() throws IOException
	{
		Reporter.loadXMLConfig(new File("..\\ExampleoutlineCucumber\\src\\main\\java\\resources\\extent-config.xml"));
		

		//		//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		Reporter.setSystemInfo("User Name", "Cucumber User");
		Reporter.setSystemInfo("Application Name", "Test App ");
		//Reporter.setSystemInfo("Operating System Type", prop.getProperty("OS").toString());
		Reporter.setSystemInfo("Environment", "Production");
		//Reporter.setSystemInfo("User Name", prop.getProperty("Selenium"));
		//Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" +"  "+ "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		Reporter.setSystemInfo("Machine", "Windows 10" +"  "+ "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		//Reporter.addScreenCaptureFromPath("C:\\Users\\vraja\\workspace\\POMWithBDDFramework\\Driver");
//hjkhkjhjkhjkjkkhk




		

	}

}
