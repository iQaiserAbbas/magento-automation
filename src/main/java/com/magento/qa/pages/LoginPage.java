package com.magento.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id="email")
	WebElement emailInput;

	@FindBy(id="pass")
	WebElement passwordInput;
	
	@FindBy(id="send2")
	WebElement signInButton;
	
	@FindBy(xpath="//*[@id='maincontent']/div[2]/div[2]/div/div/div")
	WebElement errorMessageElement;

	    
	 // Initializing the Page Objects:
	 		public LoginPage() {
	 			PageFactory.initElements(driver, this);
	 		}

	    public void enterEmail(String email) {
	        emailInput.sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        passwordInput.sendKeys(password);
	    }
	    
	    public HomePage clickSignIn() {
	        signInButton.click();
	        return new HomePage();
	    }

	    public boolean isErrorMessageDisplayed() {
	        return errorMessageElement.isDisplayed();
	    }
	    
	    public String getErrorMessageText() {
	        return errorMessageElement.getText();
	    }
}
