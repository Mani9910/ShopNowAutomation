package com.shopnow.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import com.shopnow.stepdefs.Stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
	private final static Log logger = LogFactory.getLog(Hooks.class);
	WebDriver driver;
	public Hooks() {
	this.driver =Stepdefinitions.driver;
	}
	
	public static Scenario scenario;
	@After
	public void tearDown(Scenario scenario) {
		WebDriver driver=Stepdefinitions.driver;
		logger.info("after hooks triggered ");
			driver.close();
			driver.quit();
			logger.info("Webdriver closed ");
			
	}
}
