package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class checkoutPage extends abstractComponent {

	public WebDriver driver;
	
	// constructor
	public checkoutPage (WebDriver driver)
	{
		super (driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Document ID skip radio button
	@FindBy(css = "label[for='kyc-xborder-radio-skip'] i[class='a-icon a-icon-radio']")
	 WebElement radioButton;
	
	// continue button for payment page
	@FindBy (id ="kyc-xborder-continue-button")
	WebElement continueButton;
	
	@FindBy(css= "*[class='a-color-link clickable-heading']")
	WebElement backButton;
	
	@FindBy (id ="a-autoid-3-announce")
	WebElement cartButton;
	
	public void skipradioButton()
	{
		radioButton.click();
	}
	
	public void clickOnContinueButton() throws InterruptedException
	{
		continueButton.click();
		Thread.sleep(3000);
	}
	
	public void returnToCart()
	{
		backButton.click();
		cartButton.click();
	}
	
	
}
