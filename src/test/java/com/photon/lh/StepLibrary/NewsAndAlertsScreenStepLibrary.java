package com.photon.lh.StepLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.photon.lh.StepDefinition.CommonStep;

public class NewsAndAlertsScreenStepLibrary extends CommonStep {

	public static Logger logger = Logger.getLogger(new Object() {
	}.getClass().getEnclosingClass());

	WebDriver webDriver;

	private SoftAssert softAssert;

	public NewsAndAlertsScreenStepLibrary(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	// This is a ...
	private By thisIsA_text = By.xpath("//div[2]//label[contains(text(),'This is a …')]");

	// Tips
	private By tips = By.xpath("//label[contains(text(),'Tip')]");

	// Tips Radio Button
	private By tipsRB = By.xpath("//input[@value='tip']");

	// NewsAndAlert
	private By newsAndAlert = By.xpath("//label[contains(text(),'News/Alert')]");

	// NewsAndAlert Radio Button
	private By newsRB = By.xpath("//input[@value='news']");

	// Push
	private By push = By.xpath("//label[contains(text(),'Push')]");

	// Push Radio Button
	private By pushRB = By.xpath("//input[@value='push']");

	// Make this text a link
	private By makeThisTextAlink = By.xpath("//label[contains(text(),'Make this text a link')]/text()");

	// label[contains(text(),'Make this text a link')]
	// SUBMIT TEXT
	private By submit = By.xpath("//button[contains(text(),'SUBMIT')]");

	// Submit Disabled
	private By sumitDisabled = By.xpath("//button[contains(@class,'submit-button disabled')]");

	// For which Section
	private By forWhichSection = By.xpath("//label[contains(text(),'For which Section?')]");

	// Feelings
	private By feelings = By.xpath("//label[contains(text(),'Feeling')]");

	// Feelings Radio Button
	private By feelingsRB = By.xpath("//input[@value='feeling']");

	// Doing
	private By doing = By.xpath("//label[contains(text(),'Doing')]");

	// Doing Radio Button
	private By doingRB = By.xpath("//input[@value='doing']");

	// What’s the Effect Period?
	private By effectPeriod = By.xpath("//label[contains(text(),'What’s the Effect Period?')]");

	// Include as Push notification
	private By includePushNotification = By.xpath("//label[contains(text(),'Include as Push notification')]");

	private By name = By.xpath("//input[@data-automation-id='checkbox-push']");

	// Start Date
	private By startDate = By.xpath("//label[contains(text(),'Start Date*')]");

	// Start Date Input
	private By startDateInput = By.id("startDate");

	// End Date
	private By endDate = By.xpath("//label[contains(text(),'End Date*')]");

	// End Date Input
	private By endDateInput = By.id("endDate");

	// Start Time
	private By startTime = By.xpath("//label[contains(text(),'Start Time')]");

	// /Start Time Input
	private By startTimeInput = By.id("startTime");

	// End Time
	private By endTime = By.xpath("//label[contains(text(),'End Time')]");

	// End Time Input
	private By endTimeInput = By.id("endTime");

	// required
	private By required = By.xpath("//label[contains(text(),'* required')]");

	public void verifyAllCategorizations() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		logger.info("Verify user Navigate to Content entry portal");
		waitForPresenceOfElement(webDriver.findElement(thisIsA_text));
		softAssert.assertEquals("Tip", webDriver.findElement(tips).getText().trim(), "Tip text not as expected");
		softAssert.assertEquals("News/Alert", webDriver.findElement(newsAndAlert).getText().trim(),
				"News/Alert text not as expected");
		softAssert.assertEquals("Push", webDriver.findElement(push).getText().trim(), "Push text not as expected");
		softAssert
				.assertEquals("SUBMIT", webDriver.findElement(submit).getText().trim(), "SUBMIT text not as expected");

		softAssert.assertAll();
		logger.info("soft Assert All method executed");

	}

	public void verifyThisIsATextMessage() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();

		softAssert.assertEquals("This is a …", webDriver.findElement(thisIsA_text).getText().trim(),
				"This is a ... text not as expected");
		softAssert.assertAll();
	}

	public void verifyAllRadioButtonsUnchecked() {
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		softAssert.assertFalse(webDriver.findElement(tipsRB).isSelected(), "Tips radio button enabled");
		softAssert.assertFalse(webDriver.findElement(newsRB).isSelected(), "News/Alert radio button enabled");
		softAssert.assertFalse(webDriver.findElement(pushRB).isSelected(), "Push radio button enabled");
		logger.info("Pushes text verified");
		softAssert.assertAll();
	}

	public void verifySingleCatagoryAtAtime() {

		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		softAssert.assertFalse(webDriver.findElement(tipsRB).isSelected(), "Tips radio button enabled");
		logger.info("Pushes text verified");
		softAssert.assertAll();
	}

	public void verifyUserTapOnTips() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		logger.info("Verify user Navigate to Content entry portal");
		softAssert.assertAll();
	}

	public void verifyUncheckOfMakeThisTextALink() {
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		softAssert.assertEquals("Make this text a link", webDriver.findElement(makeThisTextAlink).getText().trim(),
				"Make this text a link text not as expected");
		softAssert.assertFalse(webDriver.findElement(makeThisTextAlink).isSelected(),
				"Make this text a link check Box button enabled");
		softAssert.assertAll();
	}

	public void verifyFeelingAndDoings() {
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		softAssert.assertFalse(webDriver.findElement(feelingsRB).isSelected(), "Feelings radio button enabled");
		softAssert.assertFalse(webDriver.findElement(doingRB).isSelected(), "Doings radio button enabled");
		softAssert.assertEquals("Feeling", webDriver.findElement(feelings).getText().trim(),
				"Feeling text not as expected");
		softAssert.assertEquals("Doing", webDriver.findElement(doing).getText().trim(), "Doing text not as expected");
		logger.info("Pushes text verified");
		softAssert.assertAll();

	}

	public void verifyUserTapOnNewsAndAlert() {
		logger.info("User tap on News and Alert");
		
		clickElement(webDriver.findElement(newsRB), "clicked on News/Alert Radio Button");

	}

	public void selectFeelings() {
	
		
		clickElement(webDriver.findElement(feelingsRB), "Selected feelings Radio button");
		logger.info("User selected feelings radio button");
	}

	public void verifySubConfigurationItemsFeeling() {
		logger.info("verify catagory radio button disabled");
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		
		softAssert.assertFalse(webDriver.findElement(doingRB).isSelected(), "Doings radio button enabled");
		softAssert.assertEquals("What’s the Effect Period?", webDriver.findElement(effectPeriod).getText().trim(),
				"What’s the Effect Period? text not as expected");
		
		softAssert.assertEquals("Include as Push notification", webDriver.findElement(includePushNotification).getText().trim(),
				"Include as Push notification text not as expected");
		
		softAssert.assertEquals("Start Date*", webDriver.findElement(startDate).getText().trim(),
				"Start Date* text not as expected");
		
		softAssert.assertEquals("End Date*", webDriver.findElement(endDate).getText().trim(),
				"End Date* text not as expected");
		
		softAssert.assertEquals("Start Time", webDriver.findElement(startTime).getText().trim(),
				"Start Time text not as expected");
		
		softAssert.assertEquals("End Time", webDriver.findElement(endTime).getText().trim(),
				"End Time text not as expected");
		
		softAssert.assertEquals("* required", webDriver.findElement(required).getText().trim(),
				"* required not as expected");
		softAssert.assertAll();
	}
	
	public void verifySubConfigurationItemsForDoing() {
		logger.info("verify catagory radio button disabled");
	
		softAssert = new SoftAssert();
		
		softAssert.assertFalse(webDriver.findElement(feelingsRB).isSelected(), "Feeling radio button enabled");
		softAssert.assertEquals("What’s the Effect Period?", webDriver.findElement(effectPeriod).getText().trim(),
				"What’s the Effect Period? text not as expected");
		
		softAssert.assertEquals("Include as Push notification", webDriver.findElement(includePushNotification).getText().trim(),
				"Include as Push notification text not as expected");
		
		softAssert.assertEquals("Start Date*", webDriver.findElement(startDate).getText().trim(),
				"Start Date* text not as expected");
		
		softAssert.assertEquals("End Date*", webDriver.findElement(endDate).getText().trim(),
				"End Date* text not as expected");
		
		softAssert.assertEquals("Start Time", webDriver.findElement(startTime).getText().trim(),
				"Start Time text not as expected");
		
		softAssert.assertEquals("End Time", webDriver.findElement(endTime).getText().trim(),
				"End Time text not as expected");
		
		softAssert.assertEquals("* required", webDriver.findElement(required).getText().trim(),
				"* required not as expected");
		softAssert.assertAll();
	}

	public void chooseDateAndTime() {
		logger.info("enter start date and end date period");
		sendkey(webDriver.findElement(startDateInput), "11/11/2017");
		
	}

	public void chooseDate(String startDate, String endDate) {
		logger.info("enter start date and end date period");
		((JavascriptExecutor)webDriver).executeScript ("document.getElementById('startDate').removeAttribute('readonly',0);"); // Enables the from date box
		sendkey(webDriver.findElement(startDateInput), startDate);
		((JavascriptExecutor)webDriver).executeScript ("document.getElementById('endDate').removeAttribute('readonly',0);"); // Enables the from date box
		
		sendkey(webDriver.findElement(endDateInput), endDate);
		
	}

	public void chooseTime(String startTime, String endTime) {
		logger.info("enter start date and end date period");
		((JavascriptExecutor)webDriver).executeScript ("document.getElementById('startTime').removeAttribute('readonly',0);"); // Enables the from date box
		
		sendkey(webDriver.findElement(startTimeInput), startTime);
		((JavascriptExecutor)webDriver).executeScript ("document.getElementById('endTime').removeAttribute('readonly',0);"); // Enables the from date box
		
		sendkey(webDriver.findElement(endTimeInput), endTime);
		
		logger.info("entered start date and end date period");
		
	}

	public void selectDoing() {

		clickElement(webDriver.findElement(doingRB), "Selected Doing Radio button");
		logger.info("User selected feelings radio button");
	}

}
