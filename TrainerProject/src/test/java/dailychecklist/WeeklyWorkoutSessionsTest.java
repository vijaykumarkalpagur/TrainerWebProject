package dailychecklist;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.trainer.qa.module.actions.FacebookAction;
import com.trainer.qa.module.actions.GmailAction;
import com.trainer.qa.module.actions.LoginAction;
import com.trainer.qa.module.actions.WeeklySessionAction;
import com.trainer.qa.module.helpers.BrowserSetup;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class WeeklyWorkoutSessionsTest {

	static WebDriver driver;
	String browserName;

@BeforeMethod
public void OpenBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");
	browserName = Constant.browserName;
	driver = BrowserSetup.openBrowser(browserName);}

@Test (priority = 1 ,dataProvider = "UserLogin" , dataProviderClass = LoginDataProvider.class)
public void singleWorkoutSession(String Username ,String Password) throws Exception{
	LoginAction.TrainerLogin(driver,Username,Password);
	WeeklySessionAction.WeeklySession(driver);
	Log.info("Successfully validated Weekly Session functionlity with using normal Login with valid inputs");}

@Test (priority = 3 , dataProvider = "GmailLogin" , dataProviderClass = LoginDataProvider.class)
public static void GmailLogin(String Gmailid,String GmailPswd) throws Exception{	
	GmailAction.socialGmailLogin(driver, Gmailid, GmailPswd);
	WeeklySessionAction.WeeklySession(driver);
//	LogoutAction.UserLogOut(driver);
	Log.info("Successfully validated Weekly Session functionlity with using Gmail Login with valid inputs");}

@Test (priority = 3 , dataProvider = "FacebookLogin" , dataProviderClass = LoginDataProvider.class)
public static void FacebookLogin(String Facebookid,String FacebookPswd) throws Exception{	
	FacebookAction.socialFacebookLogin(driver, Facebookid, FacebookPswd);
	WeeklySessionAction.WeeklySession(driver);
//	LogoutAction.UserLogOut(driver);
	Log.info("Successfully validated Weekly Session functionlity with using Facebook Login with valid inputs");}

@AfterMethod
   public void teardown() throws Exception{	
	Thread.sleep(10000);
	driver.quit();
}
}
