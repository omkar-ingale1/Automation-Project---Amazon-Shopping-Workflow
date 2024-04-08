package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class signInPage extends abstractComponent {

	public WebDriver driver;
	
	// constructor
	public signInPage  (WebDriver driver)
	{
		super (driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	// sign in button
	@FindBy(css  = "a[data-nav-role='signin']")
	WebElement signInButton;
	
	//email or mobile number field
	@FindBy(xpath ="//input[@name='email']")
	WebElement mobileNumberField;
	
	//submit button
	@FindBy(className = "a-button-input")
	WebElement submitButton;
	
	// password field
	@FindBy(id = "ap_password")
	WebElement passwordField;
	
	//finalSignIn
	@FindBy(css = "input[id='signInSubmit']")
	WebElement finalSignInButton;
	
	//clicking on sign in button
	public void clickSignInButton()
	{
		signInButton.click();
	}
	// entering email or mobile number
	public void enteringEmailOrMobileNo(String emailOrMobile)
	{
		mobileNumberField.sendKeys(emailOrMobile);
	}
	// clicking on submit button
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	// entering password
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	// final SignIn Button
	public void finalSignInButton()
	{
		finalSignInButton.click();
	}
}

