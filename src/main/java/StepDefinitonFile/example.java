package StepDefinitonFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class example {
	public static Properties prop;
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

	
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\StepDefinitonFile\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vraja\\workspace\\ExampleoutlineCucumber\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(title);
		//Assertion
		//Assert.assertEquals("Free CRM software for any Business", title);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		//explicit  wait
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement expwait= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")));
		expwait.click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prop.getProperty("username"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
		//Javascriptexecutor for button
		WebElement element = driver.findElement(By.xpath("//div[text()='Login']"));
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",element );
		driver.findElement(By.xpath("//span[text()='Calendar']")).click();
		Thread.sleep(2000);//span[text()='Calendar']
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		Thread.sleep(5000);
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
			String valuenew=prop.getProperty("firstname") +" "+ prop.getProperty("lastname");
			
		    //Namecolumn=driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid']//tbody//tr["+j+"]//td[2]"));
		    Namecolumn=driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid']//tbody//tr//td[contains(text(),'"+valuenew.trim()+"')]"));
			System.out.println(Namecolumn.getText());
			
			
			
		if(Namecolumn.getText().contains(valuenew.trim()))
		{
			System.out.println("Pass");
			//Thread.sleep(3000);
			//driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid']//tbody//tr//td[contains(text(),'"+valuenew+"')]//following-sibling::td//child::i[@class='trash icon']")).click();
			//Thread.sleep(2000);
			//driver.findElement(By.xpath("//button[text()='Delete']")).click();
			//Thread.sleep(3000);
			//driver.findElement(By.xpath("(//i[@class='trash icon'])[1]")).click();
			//Thread.sleep(2000);
		//	driver.findElement(By.xpath("//button[text()='Delete']")).click();
		}
		}
		
		
//		driver.findElement(By.xpath("//button[@class='ui linkedin button']//i[@class='edit icon']")).click();
//		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(prop.getProperty("firstname"));
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(prop.getProperty("lastname"));
//		driver.findElement(By.xpath("//div[@name='channel_type']")).click();
//		//selection of element
//		WebElement obj= driver.findElement(By.xpath("//div[@class='visible menu transition']"));
//		List<WebElement> lisobj=obj.findElements(By.tagName("div")); 
//		//System.out.println(lisobj);
//		for(int i=0; i<lisobj.size();i++)          
//		{
//			String textofdiv=lisobj.get(i).getText();
//			System.out.println(textofdiv);
//			Thread.sleep(1000);
//			if(textofdiv.equalsIgnoreCase("LinkedIn"))
//			{
//				lisobj.get(i).findElement(By.tagName("span")).click();
//				break;
//			}
//
//		}
//		driver.findElement(By.xpath("//input[@name='position']")).sendKeys(prop.getProperty("position"));
//		
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='Save']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@class='ui linkedin button']//i[@class='edit icon']")).click();



	}

}
