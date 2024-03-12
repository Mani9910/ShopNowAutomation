package com.shopnow.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	public WebDriver driver;
	SoftAssertions softAssertions = new SoftAssertions();
	Log logger = LogFactory.getLog(ProductDetailsPage.class);

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(.,'Add to cart')]")
	WebElement Addtocartbutton;

	@FindBy(xpath = "//a[contains(@href,'cart')]")
	WebElement carticon;

	@FindBy(xpath = "//h1[@class='yhB1nd']//span")
	WebElement ProductnamePDP;

	// This method is to add the product to cart from the product details page and
	// this method will return product name to verify it in the cart page
	/**
	 * @author Manikandan G
	 * This method is to add the product to cart from the product details page  
	 * This method will return product name to verify it in the cart page
	 */
	public String Addproducttocart() throws InterruptedException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// driver.close();
		// driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		String pdpproductname = ProductnamePDP.getText();
		logger.info("product name PDP:" + pdpproductname);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Addtocartbutton);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		Addtocartbutton.click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		carticon.click();
		logger.info("Product is added to cart");
		return pdpproductname;
	}

}
