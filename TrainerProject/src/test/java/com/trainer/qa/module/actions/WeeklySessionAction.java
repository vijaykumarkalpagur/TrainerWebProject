package com.trainer.qa.module.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.trainer.qa.module.helpers.CreateSchedule;
import com.trainer.qa.module.pages.WeeklySessionPage;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class WeeklySessionAction {

	static WebDriver driver;
	
public static void WeeklySession(WebDriver driver) throws Exception{
	WeeklySessionPage WeeklySession = new WeeklySessionPage(driver);
				
	WeeklySession.CreateScheduleButton.isDisplayed();
	WeeklySession.CreateScheduleButton.isEnabled();
	WeeklySession.CreateScheduleButton.click();
	Thread.sleep(1000);
	Log.info("Click action performed on CreateScheduleButton.");
			
	WeeklySession.NameoftheWorkoutSession.isDisplayed();
	WeeklySession.NameoftheWorkoutSession.clear();
	WeeklySession.NameoftheWorkoutSession.sendKeys(CreateSchedule.singleworkoutsession());
    Thread.sleep(1000);
	Log.info("Entered name of the workoutsession");
			
	WeeklySession.TypeofWorkout.isDisplayed();
	WeeklySession.TypeofWorkout.click();
	WeeklySession.TypeofWorkout.sendKeys(CreateSchedule.TypeofWorkout());
	Log.info("Session TypeofWorkout is selected");
			
	WeeklySession.ClickonGroupSize.click();
	WeeklySession.GroupSize.sendKeys(CreateSchedule.GroupSession());
	Log.info("Group Session size is selected");
			
	WeeklySession.WorkoutActivity.isDisplayed();
	WeeklySession.WorkoutActivity.click();
	WeeklySession.WorkoutAcvtivitySelection.clear();
	WeeklySession.WorkoutAcvtivitySelection.sendKeys(CreateSchedule.WorkoutActivity());
	Thread.sleep(3000);	
	WeeklySession.ClickonWorkoutAcvtivity.click();
	Thread.sleep(1000);
	Log.info("Session WorkoutActivity is selected");
			
	WeeklySession.TrainingLevel.isDisplayed();
	WeeklySession.TrainingLevel.click();
	WeeklySession.TrainingLevel.sendKeys(CreateSchedule.TrainingLevel());
	Thread.sleep(1000);
	Log.info("Session TrainingLevel is selected");
	
	WeeklySession.RecurringSessionRadio.isDisplayed();
	WeeklySession.RecurringSessionRadio.click();
	Thread.sleep(3000);
	
	WeeklySession.WeeklySessionRadioButton.isDisplayed();
	WeeklySession.WeeklySessionRadioButton.click();
	
	WeeklySession.ClickonSelectDay.isDisplayed();
	WeeklySession.ClickonSelectDay.click();
	WeeklySession.SelectWeekDay.sendKeys(CreateSchedule.SelectDay(driver));
	WeeklySession.ClickonWebElement.click();
	Log.info("Weekly Session days is selected");
	
	WeeklySession.SessionStartDate.isDisplayed();
	WeeklySession.SessionStartDate.click();
	WeeklySession.SessionStartDate.sendKeys(CreateSchedule.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.StartDate));
	Thread.sleep(2000);
	Log.info("Session Start Date is selected");
	
	WeeklySession.DailySessionEndDate.isDisplayed();
	WeeklySession.DailySessionEndDate.click();
	WeeklySession.DailySessionEndDate.sendKeys(CreateSchedule.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.EndDate));
	Thread.sleep(2000);
	Log.info("Session End Date is selected");
	
	WeeklySession.SessionTime.isDisplayed();
	WeeklySession.SessionTime.clear();
	WeeklySession.SessionTime.sendKeys(CreateSchedule.randomTimeGenerate("hh:mm a"));
	Log.info("Session time is selected");
	
	WeeklySession.SessionDuration.isDisplayed();
	WeeklySession.SessionDuration.click();
	WeeklySession.SessionDuration.sendKeys(CreateSchedule.Duration("Minutes"));
	Log.info("Session Duration is selected");
	Thread.sleep(3000);
	
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).build().perform();
	
	WeeklySession.PublishButton.isDisplayed();
	WeeklySession.PublishButton.isEnabled();
	WeeklySession.PublishButton.click();
    Thread.sleep(9000);
	Log.info("Click action performed on Publish Button.");	
}	
}
