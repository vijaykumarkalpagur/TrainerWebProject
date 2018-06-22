package com.trainer.qa.module.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.trainer.qa.module.helpers.CreateSchedule;
import com.trainer.qa.module.pages.CreateSingleSessionPage;
import com.trainer.qa.utility.Constant;
import com.trainer.qa.utility.Log;

public class SingleSessionAction {

static WebDriver driver;
	
public static void WorkoutSession(WebDriver driver) throws Exception{
	CreateSingleSessionPage singlesession = new CreateSingleSessionPage(driver);
			
		singlesession.CreateScheduleButton.isDisplayed();
		singlesession.CreateScheduleButton.isEnabled();
		singlesession.CreateScheduleButton.click();
	    Thread.sleep(1000);
		Log.info("Click action performed on CreateScheduleButton.");
		
		singlesession.NameoftheWorkoutSession.isDisplayed();
		singlesession.NameoftheWorkoutSession.clear();
		singlesession.NameoftheWorkoutSession.sendKeys(CreateSchedule.singleworkoutsession());
	    Thread.sleep(1000);
		Log.info("Entered name of the workoutsession");
		
		singlesession.TypeofWorkout.isDisplayed();
		singlesession.TypeofWorkout.click();
		singlesession.TypeofWorkout.sendKeys(CreateSchedule.TypeofWorkout());
		Log.info("Session TypeofWorkout is selected");
		
		singlesession.ClickonGroupSize.click();
		singlesession.GroupSize.sendKeys(CreateSchedule.GroupSession());
		Log.info("Group Session size is selected");
		
		singlesession.WorkoutActivity.isDisplayed();
		singlesession.WorkoutActivity.click();
		
		singlesession.WorkoutAcvtivitySelection.clear();
		singlesession.WorkoutAcvtivitySelection.sendKeys(CreateSchedule.WorkoutActivity());
		Thread.sleep(3000);
		
		singlesession.ClickonWorkoutAcvtivity.click();
	    Thread.sleep(1000);
		Log.info("Session WorkoutActivity is selected");
		
		singlesession.TrainingLevel.isDisplayed();
		singlesession.TrainingLevel.click();
		singlesession.TrainingLevel.sendKeys(CreateSchedule.TrainingLevel());
	    Thread.sleep(1000);
		Log.info("Session TrainingLevel is selected");
		
		singlesession.SessionDate.isDisplayed();
		singlesession.SessionDate.click();
		singlesession.SessionDate.sendKeys(CreateSchedule.AddDatestocurrentSystemDate("mm/dd/yyyy",Constant.StartDate));
		Thread.sleep(2000);
		Log.info("Session Date is selected");
		
		singlesession.SessionTime.isDisplayed();
		singlesession.SessionTime.clear();
		singlesession.SessionTime.sendKeys(CreateSchedule.randomTimeGenerate("hh:mm a"));
		Log.info("Session time is selected");
		
		singlesession.SessionDuration.isDisplayed();
		singlesession.SessionDuration.click();
		singlesession.SessionDuration.sendKeys(CreateSchedule.Duration("Minutes"));
		Log.info("Session Duration is selected");
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		singlesession.PublishButton.isDisplayed();
		singlesession.PublishButton.isEnabled();
		singlesession.PublishButton.click();
	    Thread.sleep(9000);
		Log.info("Click action performed on Publish Button.");
	}	
}
