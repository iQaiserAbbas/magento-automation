package com.magento.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(id="search")
    WebElement searchInput;
	
	@FindBy(xpath="/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/div/strong/a")
    WebElement productTitle;
	
	@FindBy(xpath="/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/div/div[3]/div/div[1]/form/button/span")
    WebElement addToCartButton;

    // Initializing the Page Objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterSearchTerm(String searchTerm) {
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.RETURN); // hitting the "Enter" key
    }
    
    public String getProductTitle() {
        return productTitle.getText();
    }
    
    public void clickAddToCart() {
    	addToCartButton.click();
    }

    public boolean isProductShown(String productName) {
        // To do, locate the product element dynamically based on product name. 
    	//This could be complex in such a short time

        try {
            return driver.findElement(By.xpath("//h2[contains(text(),'" + productName + "')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}