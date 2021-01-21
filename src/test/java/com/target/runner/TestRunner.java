package com.target.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
		
			
			features= "src/test/resources/Features",
			glue = "com/target/steps",
			dryRun = false,
			monochrome = false,
			strict = false,
			tags = "@smoke"
			,plugin= {
					"pretty",//prints gherkin steps in console
					"html:target/cucumber-default-report",//create basic html report in specified location
					"json:target/cucumber.json",
					"rerun:target/failed.txt"
			
			}
		)


	public class TestRunner {
}
