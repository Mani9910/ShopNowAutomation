package com.shopnow.pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public WebDriver driver;
	SoftAssertions softAssertions = new SoftAssertions();
	Log logger = LogFactory.getLog(Homepage.class);

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='_2Kn22P gBNbID']")
	WebElement productnamecart;

	@FindBy(xpath = "//button//span[contains(text(),'Place Order')]")
	public WebElement placeOrderBtnInCart;

	
	/**
	 * @author Manikandan G
	 * This method will verify whether the product added in Product Details page is available in cart page or not
	 * @param productname - name of the selected/added product 
	 */
	
	public void verifycartproduct(String productname) {
		logger.info(productname);
		logger.info(productnamecart.getText());
		softAssertions.assertThat(productname.contains(productnamecart.getText().trim()))
				.as("Added product is nor available in cart").isTrue();
		softAssertions.assertAll();
		logger.info("Added product is available in cart");

	}
	
	/**
	 * @author Manikandan G
	 * This method will verify click on place order button in cart page
	 */
	public void clickonplaceorderbutton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		placeOrderBtnInCart.click();

	}

}
