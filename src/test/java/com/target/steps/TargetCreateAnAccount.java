package com.target.steps;

import com.target.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TargetCreateAnAccount extends CommonMethods {
	

@When("user clicks on signIn to selects create Account")
public void user_clicks_on_signIn_to_selects_create_Account() {

	click(targetDash.targDropdown);
	click(targetDash.crtAccount);
	
}

@When("user enter {string}, {string}, {string}, {string} and {string}")
public void user_enter_and(String emailAddress, String firstName, String lastName, String numPhone, String password) {
  
	sentText(createAcnt.emailAddress, emailAddress);
	sentText(createAcnt.firstName, firstName);
	sentText(createAcnt.lastName, lastName);
	sentText(createAcnt.numPhone, numPhone);
	sentText(createAcnt.password, password);
	wait(5);
	
	
}

@Then("user can click on create an account button")
public void user_can_click_on_create_an_account_button() {
	click(createAcnt.CreateAccount);
}

@Then("{string}, {string}, {string}, {string} and {string} is added successfully")
public void and_is_added_successfully(String string, String string2, String string3, String string4, String string5) {
    }




}
