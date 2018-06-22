package com.trainer.qa.module.helpers;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class BrowserSetup {

	public static WebDriver driver;

	public static WebDriver openBrowser(String browserName) throws Exception{

	try {
		if(browserName.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", "C://Users//Vijay//Dummy//chromedriver.exe");	
				driver = new ChromeDriver();
				Log.info("Chrome Driver initiated ");}
		
		else if(browserName.equalsIgnoreCase("FireFox")){
			    System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			    driver = new FirefoxDriver();
			    Log.info("FireFox Driver initiated ");}
		
		else if(browserName.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.ie.driver",".\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				Log.info("InternetExplorer1 Driver initiated ");}
	}		
				catch (Exception e) {
					e.getMessage();}
	
	driver.get(Constant.URL);
	Log.info("Fitbase home page opened");
	driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.SECONDS);	
	
	driver.findElement(By.xpath("//li[@class='trainer']/a")).click();
	Log.info("Clicked action performed on SIGNUP AS TRAINER button");
	driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
	
	Set<String> WindowCount = driver.getWindowHandles();
	Iterator<String> iter = WindowCount.iterator();
	
	@SuppressWarnings("unused")
	String parentwindowid = iter.next();
	String Childwindowid = iter.next();
	driver.switchTo().window(Childwindowid);
	Thread.sleep(10000);
	
	driver.findElement(By.xpath("//*[@id='signuplogin']/a")).click();
	Log.info("Clicked action performed on SIGNUP/LOGINbutton");
	Thread.sleep(5000);  
	
	return driver;
	}
}
