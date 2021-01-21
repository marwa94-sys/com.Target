package com.target.steps;

import com.target.testbase.BaseClass;
import com.target.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void start() {
		BaseClass.setup();
		
	}
	
	
	@After
	public void end(Scenario scenario) {
		byte[] pic;
		
		if(scenario.isFailed()) {
			pic = CommonMethods.takeScreenShot("/failed/"+scenario.getName());
			
		} else {
			pic = CommonMethods.takeScreenShot("/passed/"+scenario.getName());
		}
		
		scenario.attach(pic, "/imge/png", scenario.getName());
		
		BaseClass.tearDown();
	}
	
	

}
