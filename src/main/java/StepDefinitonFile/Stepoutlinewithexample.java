package StepDefinitonFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Stepoutlinewithexample {
public static WebDriver driver;
	
@Before()
public static void startTest()

{
	System.out.println("before");

}



@After()
public void afterScenario(Scenario scenario) throws IOException{
	try
	{
	if (scenario.isFailed()) 

	{
		//This takes a screenshot from the driver at save it to the specified location
		 String screenshotName = scenario.getName().replaceAll(" ", "_");
	
	File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
	
	DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");	   
	Date date = new Date(); 	 
	String ReportName= screenshotName+"_"+dateFormat.format(date);		
//	reports=new ExtentReports("..\\POMWithBDDFramework\\Reports\\" + ReportName + ".html");
	//Building up the destination path for the screenshot to save
	 //Also make sure to create a folder 'screenshots'
	File destinationPath = new File(System.getProperty("user.dir") + "/screenshot/" + ReportName + ".png");

	 //Copy taken screenshot from source location to destination location
	Files.copy(sourcePath, destinationPath); 
	//This attach the specified screenshot to the test
	Reporter.addScreenCaptureFromPath(destinationPath.toString());
	}
	}

catch(Exception e){
    scenario.write("WARNING. Failed to take screenshot with following exception : "+e.getMessage());
    }
	
	System.out.println("after");
}

	@Given("^On Home Page$")
	public void On_Home_Page(){
		// Write code here that turns the phrase above into concrete actions\
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vraja\\workspace\\ExampleoutlineCucumber\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(title);
		//Assertion
		Assert.assertEquals("Free CRM software for any Business", title);
	}
	@When("^User try to Navigate to LogIn Page$")
	public void user_try_to_Navigate_to_LogIn_Page() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		//explicit  wait
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement expwait= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")));
		expwait.click();

	}
	
	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String username, String password) throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		//Javascriptexecutor for button
		WebElement element = driver.findElement(By.xpath("//div[text()='Login']"));
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",element );
	}
	@Then("^User moves to new contact page$")
	public void user_moves_to_new_contact_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[text()='Calendar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//button[@class='ui linkedin button']//i[@class='edit icon']")).click();
		
		}
	
	
	
	
	@Then("^user check the contact already available \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_check_the_contact_already_available_and(String firstname, String lastname) throws Throwable {
	 
		
		WebElement tablecolumn =driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid']//thead//tr"));
		List<WebElement> column = tablecolumn.findElements(By.tagName("th"));
		int columnsize=column.size();
		System.out.println(columnsize);
		for(int i=0;i<columnsize;i++)
		{
		System.out.println(column.get(i).getText());
		}
		WebElement table =driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid']//tbody"));
		List<WebElement> row = table.findElements(By.tagName("tr"));
		int rowsize=row.size();
		System.out.println(rowsize);
		for(int i=0;i<rowsize;i++)
		{
		System.out.println(row.get(i).getText());
		}
		for(int j=1;j<=rowsize;j++)
		{
			WebElement Namecolumn;
			String valuenew=firstname +" "+lastname;
			
		    //Namecolumn=driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid']//tbody//tr["+j+"]//td[2]"));
		    Namecolumn=driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid']//tbody//tr//td[contains(text(),'"+valuenew.trim()+"')]"));
			System.out.println(Namecolumn.getText());
			
			
			
		if(Namecolumn.getText().contains(valuenew.trim()))
		{
			System.out.println("Pass");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid']//tbody//tr//td[contains(text(),'"+valuenew+"')]//following-sibling::td//child::i[@class='trash icon']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("(//i[@class='trash icon'])[1]")).click();
			//Thread.sleep(2000);
		//	driver.findElement(By.xpath("//button[text()='Delete']")).click();
		}
		else
		{
			driver.findElement(By.xpath("//button[@class='ui linkedin button']//i[@class='edit icon']")).click();
		}
		}
		
	}
		 
		 
		 
		 
		 
		 
		 
	@Then("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void user_enters_contact_details(String firstname, String lastname, String position) throws Throwable {
		 {
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);
		driver.findElement(By.xpath("//div[@name='channel_type']")).click();
		//selection of element
		WebElement obj= driver.findElement(By.xpath("//div[@class='visible menu transition']"));
		List<WebElement> lisobj=obj.findElements(By.tagName("div")); 
		//System.out.println(lisobj);
		for(int i=0; i<lisobj.size();i++)          
		{
			String textofdiv=lisobj.get(i).getText();
			System.out.println(textofdiv);
			Thread.sleep(1000);
			if(textofdiv.equalsIgnoreCase("LinkedIn"))
			{
				lisobj.get(i).findElement(By.tagName("span")).click();
				break;
			}

		}
		driver.findElement(By.xpath("//input[@name='position']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='day']")).sendKeys("78");
		driver.findElement(By.xpath("//input[@name='year']")).sendKeys("2016");
		driver.findElement(By.xpath("//div[@name='month']")).click();
		WebElement monthobj= driver.findElement(By.xpath("//div[@class='visible menu transition']"));
		List<WebElement> monthlisobj=monthobj.findElements(By.tagName("div")); 
		//System.out.println(lisobj);
		for(int i=0; i<monthlisobj.size();i++)
		{
			String textofdivmonth=monthlisobj.get(i).getText();
			System.out.println(textofdivmonth);
			Thread.sleep(1000);
			if(textofdivmonth.equalsIgnoreCase("May"))
			{
				monthlisobj.get(i).findElement(By.tagName("span")).click();

				break;
			}

		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='ui linkedin button']//i[@class='edit icon']")).click();



	}}
	@Then("^Close the browser$")
	public void brower_closed()  {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
		System.out.println("Brower closed");
	}

}
