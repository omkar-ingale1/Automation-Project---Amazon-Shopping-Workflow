package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class homePage extends abstractComponent {

	public WebDriver driver;
	
	// Constructor
	public homePage(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// location dismiss pop up
	@FindBy (css= "input[data-action-type='DISMISS']")
	WebElement locationDismiss;
	
	// search box
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	// search button
	@FindBy(css = "input[value='Go']")
	WebElement searchButton;
	
	 // Navigating to amazon web site
	public void visitAmazon() 
	{
		driver.get("https://www.amazon.com/");
	}
	// searching for product
	public void searchBox(String productName)
	{
		searchBox.sendKeys(productName);
	}
	// clicking on search button
	public void searchButton()
	{
		searchButton.click();
	}
	// dismissing the location pop up
	public void locationDismiss()
	{
		locationDismiss.click();
	}
}
