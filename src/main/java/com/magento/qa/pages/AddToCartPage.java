package com.magento.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;

public class AddToCartPage extends TestBase{
	Actions action = new Actions(driver);
	
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div[1]/div[3]") 
    WebElement colorOption;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div[1]/div[3]")
    WebElement sizeOption;

    @FindBy(id = "qty")
    WebElement quantityInput;

    @FindBy(id = "product-addtocart-button")
    WebElement addToCartButton;
    
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    WebElement cartButton;
    
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    WebElement proceedToCheckoutButton;

    // Constructor to initialize page elements
    public AddToCartPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectColor(String color) {
    	action.moveToElement(colorOption).perform();
    	colorOption.click();
    }

    public void selectSize(String size) {
    	action.moveToElement(sizeOption).perform();
    	sizeOption.click();
    }

    public void enterQuantity(int quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void clickAddToCart() {
        addToCartButton.click();
        cartButton.click();
    }
    
    public CheckoutPage clickCart() {
    	proceedToCheckoutButton.click();
        return new CheckoutPage();
    }

}
