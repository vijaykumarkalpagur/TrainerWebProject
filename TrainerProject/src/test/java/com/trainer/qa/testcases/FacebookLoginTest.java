package com.trainer.qa.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.trainer.qa.module.actions.FacebookAction;
import com.trainer.qa.module.helpers.BrowserSetup;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class FacebookLoginTest {

	static WebDriver driver;
	static String browserName;
	
@BeforeClass
public void TrainerSocialBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");
	browserName = Constant.browserName;	
	driver = BrowserSetup.openBrowser(browserName);}	

@Test (dataProvider = "FacebookLogin" , dataProviderClass = LoginDataProvider.class)
public static void FacebookLogin(String Facebookid,String FacebookPswd) throws Exception{	
	FacebookAction.socialFacebookLogin(driver, Facebookid, FacebookPswd);
//	LogoutAction.UserLogOut(driver);
	Log.info("Successfully validated FacebookLogin functionality with valid inputs");}

@AfterClass
public void teardown() throws Exception{
	Thread.sleep(7000);
	driver.quit();}
}

