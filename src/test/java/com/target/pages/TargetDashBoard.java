package com.target.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.target.utils.CommonMethods;

public class TargetDashBoard extends CommonMethods {
	
	@FindBy(xpath="//span[@class='AccountLink__SvgUserWrapper-gx13jw-0 cmGbcQ']")
	public WebElement targDropdown;
	
	@FindBy(xpath="//li[@id='accountNav-createAccount']")
	public WebElement crtAccount;
	
	@FindBy(xpath="//span[contains(text(),'shopping')]")
	public WebElement tarVerify;
	
	public TargetDashBoard() {	
		
		PageFactory.initElements(driver, this);
	}

}
