//This project is implemented using POM and this file will act as a glue code for steps in the feature file
//This project is implemented using POM and PageFactory
package com.shopnow.stepdefs;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.shopnow.pages.CartPage;
import com.shopnow.pages.CheckoutPage;
import com.shopnow.pages.Homepage;
import com.shopnow.pages.Hooks;
import com.shopnow.pages.ProductDetailsPage;
import com.shopnow.pages.ProductLisitingPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Stepdefinitions {
	public static WebDriver driver;
	SoftAssertions softAssertions = new SoftAssertions();
	Log logger = LogFactory.getLog(Stepdefinitions.class);
	Homepage homepage;
	ProductLisitingPage plp;
	ProductDetailsPage pdp;
	CartPage cart;
	CheckoutPage checkoutpg;
	Hooks hooks = new Hooks();
	String PDPname;

	
	/**
	 * @author Manikandan G
	 * This method will initialize the webdriver
	 */
	@Given("^Im on the browser$")
	public void launchbrowser() {
		String path = System.getProperty("user.dir");
		// System.setProperty("webdriver.chrome.driver",
		// path+"/src/test/resources/drivers/chromedriver.exe");
		// driver=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", path + "/src/test/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		// driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();

	}
 
	/**
	 * @author Manikandan G
	 * This method will launch the application using the URL of the web application
	 * @param SiteURL - site URL to launch
	 */
	@When("^Navigate to (.*)$")
	public void launchsite(String SiteURL) throws InterruptedException {
		driver.navigate().to(SiteURL);
		// driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		// driver.wait(2000);
		String hompageURL = driver.getCurrentUrl();
		softAssertions.assertThat(hompageURL.equals(SiteURL)).as("User is not on hompage").isTrue();
		softAssertions.assertAll();
		logger.info("User is now on the homepage of Flipcart");

	}

	
	/**
	 * @author Manikandan G
	 * This method will call a method from Homepage class which verifies whether user is on Homepage
	 * @param product - product name to search
	 */
	@And("^search for a '(.*)' on homepage$")
	public void Searchproduct(String product) throws InterruptedException {
		homepage = new Homepage(driver);
		homepage.searchproduct(product);

	}

	/**
	 * @author Manikandan G
	 * This method will call a method from Product Listing Page which will select a product from PLP
	 */
	@And("^click on any one product from search result$")
	public void clickonproductinPLP() {
		plp = new ProductLisitingPage(driver);
		plp.clickonaproductinplp();

	}

	/**
	 * @author Manikandan G
	 * This method will call a method from Product Details Page which will add the selected product to cart
	 */
	@And("^Add the product to cart from product details page$")
	public void Addproducttocart() throws InterruptedException {
		pdp = new ProductDetailsPage(driver);
		PDPname = pdp.Addproducttocart();

	}

	/**
	 * @author Manikandan G
	 * This method will call a method from Cart Page which will verify whether the product added from the PDP page is available in cart or not
	 */
	@And("^verify the added product in cart$")
	public void verifycartproduct() {
		cart = new CartPage(driver);
		cart.verifycartproduct(PDPname.trim());

	}
	
	/**
	 * @author Manikandan G
	 * This method will call a method from Cart Page which will click on the Place order button on Cart Page
	 */

	@And("^click on place order$")
	public void clickonplaceorderbutton() {
		cart.clickonplaceorderbutton();

	}

	/**
	 * @author Manikandan G
	 * This method will call a method from checkout page which will login the user into the site using email and OTP to proceed the checkout process
	 * @param email - e-mail for login 
	 * @param otp - Otp to login
	 */
	@And("^proceed with checkout after login '(.*)' '(.*)'")
	public void checkoutprocessandlogin(String email, String otp) {
		checkoutpg = new CheckoutPage(driver);
		checkoutpg.checkoutpagelogin(email, otp);

	}

}
