package com.shopnow.pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	public WebDriver driver;
	SoftAssertions softAssertions = new SoftAssertions();
	Log logger = LogFactory.getLog(Homepage.class);

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	public WebElement emailField;

	@FindBy(xpath = "//div//span[contains(text(),'CONTINUE')]")
	public WebElement continueBtn;


	/**
	 * @author Manikandan G
	 * This method is for login in to the site from checkout page	
	 * @param email - e-mail for login 
	 * @param OTP - Otp to login
	 */
	public void checkoutpagelogin(String email, String OTP) {
		emailField.sendKeys(email);
		continueBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
