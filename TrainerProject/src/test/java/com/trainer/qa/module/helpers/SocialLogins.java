package com.trainer.qa.module.helpers;

import org.openqa.selenium.WebDriver;

import com.trainer.qa.module.pages.SocialLoginPage;

public class SocialLogins {

	public static WebDriver driver;
	public static String SocialLogin;	

public static WebDriver SocialLogin(WebDriver driver ,String SocialLogin) throws Exception{

	SocialLoginPage Gmail = new SocialLoginPage(driver);
	
try{
   if(SocialLogin.equalsIgnoreCase("Facebook")){
		
//	   ClickonWebElements.ClickonFacebookbutton(driver);
	}
   else if(SocialLogin.equalsIgnoreCase("Gmail")){
	
	   Gmail.ClickonGmailbutton.click();
		Thread.sleep(2000);
	}
}
   catch(Exception e){
	   e.getMessage();
	}
PopupWindow.PopupWindows(driver);
return driver;		 
}
}
