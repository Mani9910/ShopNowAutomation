package com.shopnow.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\features" }, 
                 glue = { "com.shopnow.stepdefs"},
		         plugin = { "pretty", "html:target/cucumber-reports" },
		         monochrome = true ,
		         publish = true,
		         tags = "@checkoutprocess"
		         )
public class Featurerunner {

}
