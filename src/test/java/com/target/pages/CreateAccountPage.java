package com.target.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.target.utils.CommonMethods;

public class CreateAccountPage  extends CommonMethods{
	
	
	@FindBy(xpath="//input[@id='username']")
	public WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='firstname']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	public WebElement lastName;
	
	@FindBy (xpath="//input[@id='phone']")
	public WebElement numPhone;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//button[@id='createAccount']")
	public WebElement CreateAccount;
	
	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	

}
