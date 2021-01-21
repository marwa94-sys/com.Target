package com.target.steps;

import org.junit.Assert;

import com.target.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TargetSteps extends CommonMethods {
	
	
	@Given("user is landed on target front page")
	public void user_is_landed_on_target_front_page() {
		
		boolean flag = targetDash.tarVerify.isDisplayed();
		Assert.assertTrue("The verification has passed", flag);
		
	   
	}

	@When("user clicks on signIn")
	public void user_clicks_on_signIn() {
	   
		click(targetDash.targDropdown);
	}

	@When("user selects create Account")
	public void user_selects_create_Account() {

		click(targetDash.crtAccount);
	}
	
	

}
