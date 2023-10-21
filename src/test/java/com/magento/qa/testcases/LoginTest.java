package com.magento.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.LoginPage;

public class LoginTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest() {
		super(); //to call superclass constructor
	}
	
	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
				
		@BeforeMethod
		public void setUp() {
			// @Given("I am on the login page")
			initialization();
			
			loginPage = new LoginPage();
			homePage = new HomePage();

		}
		
		//*******************Hybrid Page Object Model Approach**************
		@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Log in to Magento"))
		public void signin() throws InterruptedException {
			loginPage.enterEmail(prop.getProperty("email"));
	        loginPage.enterPassword(prop.getProperty("password"));
	        loginPage.clickSignIn();
	        Thread.sleep(5000);
		}

		@Test(priority = 2, groups = "Regression", description = "Test Case Description: Invalid login verification")
		public void loginWithInvalidCredentials() {
		    // Input incorrect credentials
		    loginPage.enterEmail("invalid@example.com");
		    loginPage.enterPassword("invalidPassword"); 
		    loginPage.clickSignIn();

		    try {
		        Thread.sleep(3000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }

		    // Assert that the error message is displayed
		    Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");

		    String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."; 
		    Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage, "Error message text mismatch");
		}

		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
}
