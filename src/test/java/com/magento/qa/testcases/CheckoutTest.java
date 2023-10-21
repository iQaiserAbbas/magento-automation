package com.magento.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.AddToCartPage;
import com.magento.qa.pages.CheckoutPage;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.LoginPage;

public class CheckoutTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	
	public CheckoutTest() {
		super(); //to call superclass constructor
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		
		loginPage = new LoginPage();
		homePage = new HomePage();
		addToCartPage = new AddToCartPage();
		checkoutPage = new CheckoutPage();
		
		loginPage.enterEmail(prop.getProperty("email"));
        loginPage.enterPassword(prop.getProperty("password"));
        loginPage.clickSignIn();
        
        String searchTerm = "Tees"; 
        homePage.enterSearchTerm(searchTerm);
        homePage.clickAddToCart();
        
        addToCartPage.selectColor("Red");
		addToCartPage.selectSize("M");
		addToCartPage.enterQuantity(2);

		addToCartPage.clickAddToCart();
 
	}
	
	@Test
    public void testCheckoutFlow() {
        checkoutPage.selectShippingMethod();  // This selects the shipping method.
        checkoutPage.clickNext();  // Proceeds to the next step.
        
        // To do: add some validations or wait statements here to ensure
        // that all the information loads or that the steps are valid.

        checkoutPage.placeOrder();  // Final step to place the order.
    }

}
