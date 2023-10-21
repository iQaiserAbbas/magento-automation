package com.magento.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;

public class CheckoutPage extends TestBase{
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[2]/td[1]")
    WebElement shippingMethodRadioButton;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button")
    WebElement nextButton;

    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[2]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button/span") 
    WebElement placeOrderButton;

    // Constructor to initialize page elements
    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectShippingMethod() {
        shippingMethodRadioButton.click();
    }

    public void clickNext() {
        nextButton.click();
    }

    public void placeOrder() {
        placeOrderButton.click();
    }
}
