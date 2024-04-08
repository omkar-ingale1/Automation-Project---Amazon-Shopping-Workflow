package OmkarIngale.TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class baseTest {
 
	public WebDriver driver;
	public pageObject.homePage homePage;
	public WebDriver initializeDriver() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod (alwaysRun = true)
	public pageObject.homePage launchApplication() throws InterruptedException
	{
		driver = initializeDriver();
		 homePage = new pageObject.homePage(driver);
		 homePage.visitAmazon();
		 Thread.sleep(7000); 
		 return homePage;	
	}
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser() throws InterruptedException
	{	
		Thread.sleep(4000);
		driver.quit();
	}
	
	
	
}
