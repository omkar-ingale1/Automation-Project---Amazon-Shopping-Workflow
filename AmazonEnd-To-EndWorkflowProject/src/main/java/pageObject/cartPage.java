package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class cartPage extends abstractComponent {

	public WebDriver driver;
	
	//Constructor
	public cartPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='a-truncate-cut']")
	WebElement cartProductName;
	
	// removing the product from the cart
	@FindBy(xpath = "//input[@value='Delete']")
	WebElement delete;
	
	// empty cart text
	@FindBy(css=".a-spacing-mini.a-spacing-top-base")
	WebElement emptyCart;
	
	public String cartProductName() 
	{
		return cartProductName.getText();
	}
	
	// removing product from the cart
	public void removeCartProduct()
	{
		delete.click();
	}
	
	// grabbing empty cart text 
	public String emptyCartText()
	{
		return emptyCart.getText();
	}
	
}
