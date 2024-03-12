package com.shopnow.pages;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopnow.stepdefs.Stepdefinitions;

public class Homepage {
	public WebDriver driver;
	SoftAssertions softAssertions = new SoftAssertions();
	Log logger = LogFactory.getLog(Homepage.class);

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@title,'Search') and (@type='text')]")
	WebElement Searchbox;

	/**
	 * @author Manikandan G
	 * This method will search for the product from the search bar in the home page
	 * @param productname - product name to search 
	 */
	public void searchproduct(String productName) throws InterruptedException {
		logger.info("User is now searching for product");
		Searchbox.click();
		Searchbox.sendKeys(productName);
		Searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}

}