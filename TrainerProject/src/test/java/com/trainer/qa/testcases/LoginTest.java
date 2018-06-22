package com.trainer.qa.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.trainer.qa.module.actions.CloseBrowserAction;
import com.trainer.qa.module.actions.LoginAction;
import com.trainer.qa.module.actions.LogoutAction;
import com.trainer.qa.module.helpers.BrowserSetup;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class LoginTest {

	WebDriver driver;
	String browserName;

@BeforeClass
public void OpenBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");
	browserName = Constant.browserName;
	driver = BrowserSetup.openBrowser(browserName);}

@Test (dataProvider = "UserLogin" , dataProviderClass = LoginDataProvider.class)
public void TrainerLogin(String Username ,String Password) throws Exception{
	LoginAction.TrainerLogin(driver,Username,Password);
	LogoutAction.UserLogOut(driver);
	Log.info("Successfully validated Login functionality with valid input");}

@AfterClass
   public void teardown() throws Exception{	
	CloseBrowserAction.Application(driver);
	}
}

