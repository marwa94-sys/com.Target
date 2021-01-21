package com.target.testbase;

import com.target.pages.CreateAccountPage;
import com.target.pages.TargetDashBoard;

public class PageInit {
	
	public static TargetDashBoard targetDash;
	public static CreateAccountPage createAcnt;
	
	
	public static void initialize() {
		
		targetDash = new TargetDashBoard();
		createAcnt=new CreateAccountPage();
		
		
	}
	
	

}
