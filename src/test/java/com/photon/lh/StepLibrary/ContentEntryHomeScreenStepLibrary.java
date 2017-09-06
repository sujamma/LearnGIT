package com.photon.lh.StepLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.photon.lh.StepDefinition.CommonStep;

public class ContentEntryHomeScreenStepLibrary extends CommonStep {

	public static Logger logger = Logger.getLogger(new Object() {
	}.getClass().getEnclosingClass());

	WebDriver webDriver;

	public ContentEntryHomeScreenStepLibrary(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	private SoftAssert softAssert;

	// Messaging Portal
	private By messagingProtal = By.xpath("//div[contains(text(),'Messaging Portal')]");

	// Tips
	private By tips = By.xpath("//li[contains(text(),'Tips ')]");

	// Alert
	private By alert = By.xpath("//li[contains(text(),'Alerts')]");
	
	//Pushes
	private By pushes = By.xpath("//li[contains(text(),'Pushes')]");
	
	//Add Button
	private By addButton = By.xpath("//a[@data-automation-id='header-add-button']");
	
	//Add Img
	private By addImg =By.xpath("//a/img[@class='add']");
	
	//Add a Message
	private By add_a_message =By.xpath("//div[contains(text(),'Add a Message')]");
	

	public void verifyUserNavigateToContentEntryHomeScreen() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		logger.info("Verify user Navigate to Content entry portal");
   		softAssert.assertEquals("Messaging Portal", webDriver.findElement(messagingProtal).getText().trim(),
				"Messaging Portal text not as expected");
		logger.info("Messaging Portal text verified");
		softAssert.assertAll();
		logger.info("soft Assert All method executed");

	}

	public void userCheckAllUIElementsContentEntryHomeScreen() {
		softAssert = new SoftAssert();
		logger.info("Verify user Navigate to Content entry portal");
		logger.info("Messaging Portal text verified");
		softAssert.assertTrue(webDriver.findElement(tips).getText().trim().contains("Tips"), "Tips text not displayed");
		logger.info("Tips text verified");
		softAssert.assertTrue(webDriver.findElement(alert).getText().trim().contains("Alert"), "Alert text not displayed");
		logger.info("Alert text verified");
		softAssert.assertTrue(webDriver.findElement(pushes).getText().trim().contains("Pushes"), "Pushes text not isplayed");
		logger.info("Pushes text verified");
		
		softAssert.assertAll();
		logger.info("soft Assert All method executed");
		
	}

	public void verifyAddNewIcon() {
		softAssert = new SoftAssert();
		softAssert.assertTrue(webDriver.findElement(addButton).isDisplayed(), "Add button not displayed");
		logger.info("Add button verified");
		softAssert.assertTrue(webDriver.findElement(addImg).isDisplayed(), "Add Img not displayed");
		logger.info("Add Button Img verified");
		softAssert.assertAll();
		
	}

	public void userTapOnAddNewIcon() {
	
		softAssert = new SoftAssert();
		
		clickElement(webDriver.findElement(addImg), "clicked on Add button");
		
		logger.info("user tapped on Add button Img");
	}

	public void verifyUserNavigateToAddMessageScreen() {
		softAssert = new SoftAssert();
		softAssert.assertEquals("Add a Message", webDriver.findElement(add_a_message).getText().trim(),
				"Add a Message text not as expected");
		
	}

}
