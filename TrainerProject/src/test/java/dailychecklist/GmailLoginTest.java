package dailychecklist;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.trainer.qa.module.actions.GmailAction;
import com.trainer.qa.module.helpers.BrowserSetup;
import com.trainer.qa.module.testdata.LoginDataProvider;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;


public class GmailLoginTest {

	static WebDriver driver;
	static String browserName;
	
@BeforeClass
public void TrainerSocialBrowser() throws Exception {	
	PropertyConfigurator.configure("log4j.properties");
	browserName = Constant.browserName;	
	driver = BrowserSetup.openBrowser(browserName);}	

@Test (dataProvider = "GmailLogin" , dataProviderClass = LoginDataProvider.class)
public static void GmailLogin(String Gmailid,String GmailPswd) throws Exception{	
	GmailAction.socialGmailLogin(driver, Gmailid, GmailPswd);
//	LogoutAction.UserLogOut(driver);
	Log.info("Successfully validated GmailLogin functionality with valid inputs");}

//@AfterClass
//public void teardown() throws Exception{	
//	driver.quit();}
}

