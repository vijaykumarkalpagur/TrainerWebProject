package com.trainer.qa.module.actions;

import org.openqa.selenium.WebDriver;

public class CloseBrowserAction {

public static void Application(WebDriver driver) throws Exception{	
	Thread.sleep(3000);
	driver.close();
	Thread.sleep(2000);
	driver.quit();
}
}

