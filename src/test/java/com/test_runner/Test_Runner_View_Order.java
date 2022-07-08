package com.test_runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		junit= "--step-notifications",
				plugin = {"json:target/cucumber.json", 
						"html:target", 
						"junit:target/Cucumber.xml",
						//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						},
		features="Feature",
		glue={"com.step_defination"}
		,tags={"@vieworder"}
		)
public class Test_Runner_View_Order {

}
