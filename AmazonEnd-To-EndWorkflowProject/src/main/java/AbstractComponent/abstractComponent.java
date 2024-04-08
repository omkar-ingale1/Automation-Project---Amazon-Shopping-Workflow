package AbstractComponent;


import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class abstractComponent {

	public WebDriver driver;
	
	//Constructor
	public abstractComponent (WebDriver driver)
	{  // initialize driver
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		}
	// go to cart page 
	@FindBy(id ="nav-cart")
	WebElement cartPage;
	
	@FindBy(css = "*[value='Proceed to checkout']")
	WebElement checkoutPage;
	
	// Explicit wait written here so we can use multiple times by just calling it.
	public void waitForElementAppear (WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementDissappear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void scrollingDown()
	{
	JavascriptExecutor js =  (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,300)");
	}
	public void scrollingUp()
	{
	JavascriptExecutor js =  (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,-300)");
	}
	
	public void mouseHovering(WebElement element)
	{
	Actions a = new Actions (driver);
	a.moveToElement(element).build().perform();
	}
	
	// go to cart page
	public void goToCartPage() 
	{
		cartPage.click();
	}
	// go to checkout page
	public void goToCheckoutPage()
	{
		checkoutPage.click();
	}
	
	
}
	

