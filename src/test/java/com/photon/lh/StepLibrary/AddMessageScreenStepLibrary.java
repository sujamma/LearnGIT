package com.photon.lh.StepLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.photon.lh.StepDefinition.CommonStep;

public class AddMessageScreenStepLibrary extends CommonStep {
	public static Logger logger = Logger.getLogger(new Object() {
	}.getClass().getEnclosingClass());

	WebDriver webDriver = null;
	SoftAssert softAssert = null;

	public AddMessageScreenStepLibrary(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	// Add Button
	private By addButton = By.xpath("//a[@data-automation-id='header-add-button']");

	// Add Img
	private By addImg = By.xpath("//a/img[@class='add']");

	// Add a Message
	private By add_a_message = By.xpath("//span[contains(text(),'Add a Message')]");

	// Close Img
	private By closeImg = By.xpath("//a/img[@class='close']");

	// Messaging Portal
	private By messagingProtal = By.xpath("//div[contains(text(),'Messaging Portal')]");

	// Type Message Here
	private By typeMessageHere = By.xpath("//textarea[@placeholder='Type message here']");

	private By charCountLable = By.xpath("//label[@data-automation-id='char-count-label']");

	// text Area
	private By textArea = By.xpath("//textarea[@data-automation-id='message-text-area']");
	
	

	public void userTapOnCloseButton() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		waitForPresenceOfElement(webDriver.findElement(closeImg));
		softAssert.assertTrue(webDriver.findElement(closeImg).isDisplayed(), "Close text not isplayed");
		logger.info("Close Img  text verified");
		clickElement(webDriver.findElement(closeImg), "Close Img clicked");
		logger.info("close button clicked");
		softAssert.assertAll();
		logger.info("soft Assert All method executed");

	}

	public void userNavigateBackToHomePage() {
		softAssert = new SoftAssert();
		logger.info("Verify user Navigate to Content entry portal");
		waitForPresenceOfElement(webDriver.findElement(messagingProtal));
		softAssert.assertEquals("Messaging Portal", webDriver.findElement(messagingProtal).getText().trim(),
				"Messaging Portal text not as expected");
		logger.info("Messaging Portal text verified");
		softAssert.assertAll();
		logger.info("soft Assert All method executed");
	}

	public void suggestiveMessage(String sugMsg) {
		softAssert = new SoftAssert();
		
		waitForPresenceOfElement(webDriver.findElement(typeMessageHere));
		softAssert.assertEquals(sugMsg, webDriver.findElement(typeMessageHere).getAttribute("placeholder").trim(),
				"Type Message text not as expected");
		logger.info("Type message text verified");
		softAssert.assertAll();
		logger.info("soft Assert All method executed");
	}

	public void characterLeftMsg(String charLeft) {
		
		softAssert = new SoftAssert();
		
		waitForPresenceOfElement(webDriver.findElement(charCountLable));
		softAssert.assertEquals(charLeft, webDriver.findElement(charCountLable).getText().trim(),
				charLeft+"Char count text not as expected"+webDriver.findElement(charCountLable).getText().trim());
		logger.info("Char count text verified");
		softAssert.assertAll();
		logger.info("CharacterLeftMsg:soft Assert All method executed");
		
	}

	public void enterText(String text) {
		softAssert = new SoftAssert();
		
		waitForPresenceOfElement(webDriver.findElement(typeMessageHere));
		sendkey(webDriver.findElement(typeMessageHere), text);
		logger.info("send input text to TextEditor");
		softAssert.assertAll();
		logger.info("Enter Text:soft Assert All method executed");
		
	}

	public void reverseCharaterCount() {
		softAssert = new SoftAssert();
		
		waitForPresenceOfElement(webDriver.findElement(charCountLable));
		softAssert.assertEquals("112 characters left", webDriver.findElement(charCountLable).getText().trim(),
				"Char count text not as expected");
		logger.info("Char count text verified");
		softAssert.assertAll();
		logger.info("reverseCharCount:soft Assert All method executed");
		
	}

	public void deleteAndVerifyCharCount() {
		
		softAssert = new SoftAssert();
		
		waitForPresenceOfElement(webDriver.findElement(textArea));
		clearText(webDriver.findElement(textArea));
		logger.info("cleared text in TextEditor");
		characterLeftMsg("140 characters left");
		softAssert.assertAll();
		logger.info("reverse Character:soft Assert All method executed");
	}

	public void redColorReachesLimit() {
		softAssert = new SoftAssert();
		String  textMsg="Check that at the bottom corner within the text box, there should be character count displayed, ‘140 characters left’.Please verify the giv";
		
		waitForPresenceOfElement(webDriver.findElement(textArea));
		sendkey(webDriver.findElement(textArea), textMsg);
		logger.info("send input text to TextEditor");
		characterLeftMsg("0 characters left");
		String color=webDriver.findElement(charCountLable).getCssValue("color");
		logger.info("verified validate :"+color);
		softAssert.assertAll();
		logger.info("Enter Text:soft Assert All method executed");
		
		
		
	}

	public void enterAlphaNumberSpecialCharIntoEditor() {
		
		softAssert = new SoftAssert();
		
		waitForPresenceOfElement(webDriver.findElement(textArea));
		sendkey(webDriver.findElement(textArea), "This my text having *))) akdfaslkfi %#8883");
		logger.info("send input text to TextEditor");
		characterLeftMsg("98 characters left");
		softAssert.assertAll();
		logger.info("Enter Text:soft Assert All method executed");
	}

	public void spaceCountAndLineChangeCount() {
	
		
		softAssert = new SoftAssert();
				String  textMsg="Software Quality Assurance & Testing Stack\n"
						+ "Exchange is a question and answer\n "
						+ "site for software quality control experts\n"
						+ ", automation engineers";
				
				waitForPresenceOfElement(webDriver.findElement(textArea));
				sendkey(webDriver.findElement(textArea), textMsg);
				logger.info("send input text to TextEditor");
				characterLeftMsg("0 characters left");
				String color=webDriver.findElement(charCountLable).getCssValue("color");
				logger.info("verified validate :"+color);
				softAssert.assertAll();
				logger.info("Enter Text:soft Assert All method executed");
	}

	public void copyPastVeriyCharCount() {
		
	softAssert = new SoftAssert();
		
		waitForPresenceOfElement(webDriver.findElement(textArea));
		clearText(webDriver.findElement(textArea));
		new Actions( webDriver ).contextClick(webDriver.findElement(textArea) ).sendKeys( "copy and past verification" ).perform();
		
		logger.info("send input text to TextEditor");
		softAssert.assertAll();
		logger.info("Enter Text:soft Assert All method executed");
		
		
		
	}

}
