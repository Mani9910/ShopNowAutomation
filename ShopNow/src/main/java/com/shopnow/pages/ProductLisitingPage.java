package com.shopnow.pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLisitingPage {
	public WebDriver driver;
	SoftAssertions softAssertions = new SoftAssertions();
	Log logger = LogFactory.getLog(Homepage.class);

	public ProductLisitingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[contains(@class,'1At')]//a[@target='_blank'])[4]")
	WebElement productinplp;

	/**
	 * @author Manikandan G
	 * This method will click on product in plp/search suggestions	 
	 */
	public void clickonaproductinplp() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productinplp);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productinplp.click();
		

	}
}
