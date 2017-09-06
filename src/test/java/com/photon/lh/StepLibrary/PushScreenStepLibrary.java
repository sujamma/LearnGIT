package com.photon.lh.StepLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.photon.lh.StepDefinition.CommonStep;

public class PushScreenStepLibrary  extends CommonStep{

	public static Logger logger = Logger.getLogger(new Object() {
	}.getClass().getEnclosingClass());

	WebDriver webDriver;

	private SoftAssert softAssert;
	
	public PushScreenStepLibrary(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	

	//Tips
	private By tips = By.xpath("//label[contains(text(),'Tip')]");

	//Tips Radio Button
	private By tipsRB= By.xpath("//input[@value='tip']");
	
	//Push Radio Button
	private By pushRB= By.xpath("//input[@value='push']");
	//Pushes
		private By push = By.xpath("//label[contains(text(),'Push')]");

	//NewsAndAlert Radio Button
	private By newsRB= By.xpath("//input[@value='news']");
	
	//SUBMIT TEXT
	private By submit =By.xpath("//button[contains(text(),'SUBMIT')]");
	
	//Submit Enabled
	private By sumitEnabled = By.xpath("//button[contains(@class,'submit-button')]");
	
	public void clickOnPush(){
		
		
		logger.info("Verify Tip functionality");
		
		waitForPresenceOfElement(webDriver.findElement(pushRB));
		
		clickElement(webDriver.findElement(pushRB), "user clicked on push");
		logger.info("push radio button checked");
	}


		
		
		public void verifyConfiguration() {
			logger.info("Soft Assertion instance created ");
			softAssert = new SoftAssert();
			logger.info("Verify Push functionality");
			waitForPresenceOfElement(webDriver.findElement(push));
			softAssert.assertTrue(webDriver.findElement(push).getText().trim().contains("Push"), "Push text not isplayed");
			logger.info("Push text verified");
			clickOnPush();			
			softAssert.assertAll();
			logger.info("soft Assert All method executed");
			
		
		
	}




		public void verifySubmitEnabled() {
			
			softAssert = new SoftAssert();
			softAssert.assertEquals("SUBMIT", webDriver.findElement(submit).getText().trim(),
					"SUBMIT text not as expected");
			softAssert.assertTrue(webDriver.findElement(sumitEnabled).isEnabled(), "Submit button not enabled");
			
			logger.info("verified Submit button not enabled");
			softAssert.assertAll();
		}
}
