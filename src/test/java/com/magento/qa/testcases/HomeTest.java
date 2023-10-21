package com.magento.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.LoginPage;

public class HomeTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public HomeTest() {
		super(); //to call superclass constructor
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		// @Given("I am Logged in page")
		initialization();
		
		loginPage = new LoginPage();
		homePage = new HomePage();
		
		loginPage.enterEmail(prop.getProperty("email"));
        loginPage.enterPassword(prop.getProperty("password"));
        loginPage.clickSignIn();
	}
	
	@Test(priority = 1, groups = "Regression", description = "Test Case Description: Verify product search functionality")
    public void verifyProductSearch() {
        // Step 1: Perform a search from the home page
        String searchTerm = "Tees"; 
        homePage.enterSearchTerm(searchTerm);

        
        String expectedProductTitle = "Typhon Performance Fleece-lined Jacket";
        String actualProductTitle = homePage.getProductTitle();
        Assert.assertTrue(actualProductTitle.contains(expectedProductTitle), "Search result validation failed. Expected product not found.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
