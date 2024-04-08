package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class signOutPage extends abstractComponent {

	public WebDriver driver;
	//constructor
	public signOutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// signOut hyperlink
	@FindBy(linkText = "Sign Out")
	WebElement signOut;
	
	// clicking on sign out link
	public void clickOnSignOut()
	{
		signOut.click();
	}
}
