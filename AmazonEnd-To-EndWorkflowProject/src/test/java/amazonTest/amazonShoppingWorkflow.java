package amazonTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractComponent.abstractComponent;
import OmkarIngale.TestComponents.baseTest;
import pageObject.cartPage;
import pageObject.checkoutPage;
import pageObject.signInPage;
import pageObject.signOutPage;

public class amazonShoppingWorkflow extends baseTest {

	String productName = "OnePlus Nord Buds 2";
	                                         
	@Test
	public void amazoneWorkflow() throws InterruptedException {
		homePage.locationDismiss();
		// sign in
		signInPage signInPage = new signInPage(driver); // sign in page object
		// click on sign in button
		signInPage.clickSignInButton();

		// entering email or mobile
		signInPage.enteringEmailOrMobileNo("9665298602");

		// click on submitButton
		signInPage.clickSubmitButton();

		// enteringPassword
		signInPage.enterPassword("amazonPassword");

		// clicking on sign in button
		signInPage.finalSignInButton();
		
		// close location pop up
		//homePage.locationDismiss();
		
		// search for the required product
		homePage.searchBox(productName);

		// clicking on search button
		homePage.searchButton();

		// abstract component object
		abstractComponent abstractComponent = new abstractComponent(driver);

		// explicit wait
		abstractComponent.waitForElementAppear(driver.findElement(By.cssSelector("div[data-cy='title-recipe']")));

		// page scroll down
		abstractComponent.scrollingDown();

		// gathering all the product list to find and select exact product which we want
		List<WebElement> productList = driver.findElements((By.cssSelector("div[data-cy='title-recipe']")));

		// using loop to select and add to cart a required product among all the products
		for (int i = 0; i <= productList.size(); i++) {
			String name = productList.get(i).getText();
			if (name.contains("Buds 2")) {
				driver.findElements(By.cssSelector("button[class=\"a-button-text\"]")).get(i).click(); // clicking on the add to cart button																						
				break;
			}
		}
		// explicit wait for buffer while product adding into cart
		abstractComponent.waitForElementAppear(driver.findElement(By.cssSelector("span[data-a-class=\"quantity\"]")));

		// scroll Up
		abstractComponent.scrollingUp();

		// explicit wait for toast message get disappear
		abstractComponent.waitForElementDissappear(driver.findElement(By.cssSelector("strong[class ='a-size-small']")));

		// moving to cart page
		abstractComponent.goToCartPage();

		// getting the name and description of the product which has added into cart.
		cartPage cartPage = new cartPage(driver);
		String name = cartPage.cartProductName();

		// splitting the string into 2 parts and getting only the name of the product
		// for assertions
		String[] splittedString = name.split("True");

		String finalCartProductName = splittedString[0].trim(); 

		// checking whether the correct product is added into cart or not	
		String productNameWithComma = "OnePlus Nord Buds 2,";
		if (finalCartProductName.equals(productName) )
		{
			Assert.assertEquals(finalCartProductName, productName);
		}
		else
		{
			Assert.assertEquals(finalCartProductName, productNameWithComma);
		}
		
		// moving to checkout page
		abstractComponent.goToCheckoutPage();

		// creating checkoutPage Object
		checkoutPage checkoutPage = new checkoutPage(driver);

		// page scroll down
		abstractComponent.waitForElementAppear(driver.findElement(By.id("orderSummaryPrimaryActionBtn-announce")));
		abstractComponent.scrollingDown();

		// clicking on document skip radio button
		checkoutPage.skipradioButton();

		// click on continue to move payment page
		abstractComponent.waitForElementAppear(driver.findElement(By.id("kyc-xborder-continue-button")));
		checkoutPage.clickOnContinueButton();

		// returning to the cart
		checkoutPage.returnToCart();

		// removing the product from the cart
		cartPage.removeCartProduct();

		// asserting the whether cart is empty or not
		String expectedText = cartPage.emptyCartText().trim();
		String actualText = "Your Amazon Cart is empty.";
		Assert.assertEquals(expectedText, actualText);

		// signing out
		abstractComponent.mouseHovering(driver.findElement(By.id("nav-link-accountList")));
		signOutPage signOutPage = new signOutPage (driver); // sign out page object
		signOutPage.clickOnSignOut();
		
		// Thank You For looking 

	}

}
