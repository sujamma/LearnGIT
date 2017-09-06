package com.photon.lh.StepLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.photon.lh.StepDefinition.CommonStep;

public class TipsScreenLibrary extends CommonStep{


	public static Logger logger = Logger.getLogger(new Object() {
	}.getClass().getEnclosingClass());

	WebDriver webDriver;

	private SoftAssert softAssert;
	
	public TipsScreenLibrary(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
			//Tips
			private By tips = By.xpath("//label[contains(text(),'Tip')]");
		
			//Tips Radio Button
			private By tipsRB= By.xpath("//input[@value='tip']");
			
			//Push Radio Button
			private By pushRB= By.xpath("//input[@value='push']");
			

			//NewsAndAlert Radio Button
			private By newsRB= By.xpath("//input[@value='news']");
	
			//Make this text a link
			private By makeThisTextALink = By.xpath("//label[contains(text(),'Make this text a link')]");
			
			//Make this text a link checkBox
			private By makeThisTextALinkCB= By.xpath("//input[@value='link']");
	
			//Enter URL text box
			private By urlText = By.id("link-url");
			
			//Enter URL PlaceHolder
			private By enterURLPlaceHolder = By.xpath("//input[@placeholder='Enter URL']");
			
			//Please enter a valid URL
			
			private By enterURL = By.xpath("//label[contains(text(),'Please enter a valid URL')]")	;
			
			//Include "Legacy-GoHealth Urgent Care" link
			private By urgentCare = By.xpath("//label[contains(text(),'Include \"Legacy-GoHealth Urgent Care\" link')]");
			
			//Include "Legacy-GoHealth Urgent Care" link Check Box
			private By urgentCareCB= By.xpath("//input[@value='go-health']");
			
			//For which Condition(s)?
			
			private By whichConditions = By.cssSelector("body > my-app > div > add-message > div > div.category-container > div > tip-component > div > div.condition-container > label");
			
			//Allergies
			private By allergies = By.xpath("//label[contains(text(),'Allergies')]");
			
			//Allergies CB
			private By allergiesCB = By.xpath("//input[@value='Allergies']");
			//Asthma
			
			private By asthma = By.xpath("//label[contains(text(),'Asthma')]");
			
			//Asthma CB
			private By asthmaCB = By.xpath("//input[@value='Asthma']");
			//Cold
			
			private By cold = By.xpath("//label[contains(text(),'Cold')]");
			
			//Cold CB
			private By coldCB = By.xpath("//input[@value='Cold']");
			
			//Fever
			private By fever = By.xpath("//label[contains(text(),'Fever')]");
			
			//Fever CB
			private By feverCB = By.xpath("//input[@value='Fever']");
			
			//Flu
			private By flu = By.xpath("//label[contains(text(),'Flu')]");
			
			//Flu CB
			private By fluCB = By.xpath("//input[@value='Flu']");
			
			//Rash 
			private By rash = By.xpath("//label[contains(text(),'Rash')]");
			
			//Rash CB
			private By rashCB = By.xpath("//input[@value='Rash']");
			
			//Streps
			private By streps = By.xpath("//label[contains(text(),'Streps')]");
			
			
			//Streps CB
			private By strepsCB = By.xpath("//input[@value='Streps']");
			
			//SUBMIT TEXT
			private By submit =By.xpath("//button[contains(text(),'SUBMIT')]");
			
			//Submit Disabled
			private By sumitDisabled = By.xpath("//button[contains(@class,'submit-button disabled')]");
			
			public void clickOnTip(){
				
				
				logger.info("Verify Tip functionality");
				
				waitForPresenceOfElement(webDriver.findElement(tips));
				
				clickElement(webDriver.findElement(tipsRB), "user clicked on Tip");
				logger.info("Tip radio button checked");
			}
			
	
	public void verifyConfiguration() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		logger.info("Verify Tip functionality");
		clickOnTip();
		waitForPresenceOfElement(webDriver.findElement(makeThisTextALink));
		softAssert.assertEquals("Make this text a link", webDriver.findElement(makeThisTextALink).getText().trim(),
				"Make this text a link text not as expected");
		
		softAssert.assertEquals("Include \"Legacy-GoHealth Urgent Care\" link", webDriver.findElement(urgentCare).getText().trim(),
				"Urgent care text not as expected");
		softAssert.assertEquals("For which Condition(s)?", webDriver.findElement(whichConditions).getText().trim(),
				"For which Condition(s)? text not as expected");
		softAssert.assertEquals("SUBMIT", webDriver.findElement(submit).getText().trim(),
				"SUBMIT text not as expected");
		
		softAssert.assertAll();
		logger.info("soft Assert All method executed");
		
	}


	public void verifyUncheckOptions() {
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		softAssert.assertFalse(webDriver.findElement(makeThisTextALinkCB).isSelected(), "Make this text a link checkBox box not enabled");
		softAssert.assertFalse(webDriver.findElement(newsRB).isSelected(), "News/Alert radio button enabled");
		softAssert.assertFalse(webDriver.findElement(pushRB).isSelected(), "Push radio button enabled");
		softAssert.assertFalse(webDriver.findElement(urgentCareCB).isSelected(), "Urgent Care check box  enabled");
		logger.info("Pushes text verified");
		softAssert.assertAll();
		
	}


	public void verifyUncheckOptionsUnderWhichConditions() {
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		softAssert.assertFalse(webDriver.findElement(allergiesCB).isSelected(), "Allergies check box enabled");
		logger.info("verified Allergies checkBox disabled");
		softAssert.assertFalse(webDriver.findElement(asthmaCB).isSelected(), "Asthma check box enabled");
		logger.info("verified Asthma checkBox disabled");
		softAssert.assertFalse(webDriver.findElement(feverCB).isSelected(), "Fever check box enabled");
		logger.info("verified Fever checkBox disabled");
		softAssert.assertFalse(webDriver.findElement(fluCB).isSelected(), "Flu check box enabled");
		logger.info("verified Flu checkBox disabled");
		softAssert.assertFalse(webDriver.findElement(rashCB).isSelected(), "Rash check box enabled");
		logger.info("verified Rash checkBox disabled");
		softAssert.assertFalse(webDriver.findElement(strepsCB).isSelected(), "Streps check box enabled");
		logger.info("verified Streps checkBox disabled");
		logger.info("Pushes text verified");
		softAssert.assertAll();
		
	}


	public void clickMakeThisTextaLink() {
		
		logger.info("Selected Check box of Make this text a link");
			
		
		clickElement(webDriver.findElement(makeThisTextALinkCB), "user clicked on make this text a link");
		logger.info("Make this text a link radio button checked");
	}


	public void verifyURlTextBox() {
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		/*softAssert.assertEquals("Please enter a valid URL", webDriver.findElement(enterURL).getText().trim(),
				"Please enter a valid URL text not as expected");*/
		softAssert.assertTrue(webDriver.findElement(enterURLPlaceHolder).isDisplayed(), "URL Place holder not displayed");
		softAssert.assertAll();
		
	}


	public void verifySubmitDisabled() {
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		softAssert.assertEquals("SUBMIT", webDriver.findElement(submit).getText().trim(),
				"SUBMIT text not as expected");
		softAssert.assertFalse(webDriver.findElement(sumitDisabled).isSelected(), "Submit button not disaled");
		softAssert.assertAll();
		
	}


	public void enterURL() {
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		sendkey( webDriver.findElement(urlText), "http://ec2-52-88-227-214.us-west-2.compute.amazonaws.com");
		softAssert.assertAll();
		
	}


	public void checkUrgentCare() {

	
		
		waitForPresenceOfElement(webDriver.findElement(urgentCare));
		
		clickElement(webDriver.findElement(urgentCareCB), "user clicked on include \"Legacy-GoHealth Urgent Care\" link");
		logger.info("User clicked on include \"Legacy-GoHealth Urgent Care\" link");
		
		
	}


	public void checkMultiOptions() {
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		clickElement(webDriver.findElement(allergiesCB), "user clicked on Allergies");
		logger.info("user clicked on Allergies check box");
		
		clickElement(webDriver.findElement(asthmaCB), "user clicked on Asthma");
		logger.info("user clicked on Asthma check box");
		
		clickElement(webDriver.findElement(strepsCB), "user clicked on Streps");
		logger.info("user clicked on Streps check box");
		softAssert.assertAll();
		
	}


	public void clickedOnSubmit() {
		logger.info("verify catagory radio button disabled");
		softAssert = new SoftAssert();
		clickElement(webDriver.findElement(submit), "user clicked on submit");
		logger.info("user clicked on submit check box");
		softAssert.assertAll();
		
	}


	
	
}
