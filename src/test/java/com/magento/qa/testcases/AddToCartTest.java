package com.magento.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.AddToCartPage;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.LoginPage;

public class AddToCartTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	
	public AddToCartTest() {
		super(); //to call superclass constructor
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		// @Given("I am on Product Page")
		initialization();
		
		loginPage = new LoginPage();
		homePage = new HomePage();
		addToCartPage = new AddToCartPage();
		
		loginPage.enterEmail(prop.getProperty("email"));
        loginPage.enterPassword(prop.getProperty("password"));
        loginPage.clickSignIn();
        
        String searchTerm = "Tees"; 
        homePage.enterSearchTerm(searchTerm);
        homePage.clickAddToCart();
	}
	
	@Test
    public void testAddToCartFlow() {
       
		addToCartPage.selectColor("Red");
		addToCartPage.selectSize("M");
		addToCartPage.enterQuantity(2);

		addToCartPage.clickAddToCart();
		addToCartPage.clickCart(); 

        // To do, add assertions 
    }

}
