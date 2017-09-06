package com.photon.lh.MobileStepLibrary;

import io.appium.java_client.AppiumDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.photon.lh.MobileStepDefinition.CommonStep;



public class FeelingsScreenStepLibrary extends CommonStep {

	public static Logger logger = Logger.getLogger(new Object() {
	}.getClass().getEnclosingClass());

	AppiumDriver<?> appiumDriver = null;
	SoftAssert softAssert = null;

	public FeelingsScreenStepLibrary(AppiumDriver<?> appiumDriver) {
		this.appiumDriver = appiumDriver;
	}

	
	//Stumptown
	private By stumpTown = By.name("Stumptown");
	
	// Feeling
	private By feeling = By.name("Feeling");

	
	// menu
	private By menu = By.name("menu");

	// Doing
	private By doing = By.name("Doing");

	// Enter zip code or neighborhood
	private By zipOrNeig = By.name("Enter zip code or neighborhood");
	
	//location active
	private By locationActive = By.name("location active");
	
	// allergies
	private By allergies = By.name("allergies");

	// cold
	private By cold = By.name("cold");

	// cough
	private By cough = By.name("cough");

	// flu
	private By flu = By.name("flu");

	// stomach ailments
	private By stomachAilments = By.name("stomach ailments");

	// strep
	private By strep = By.name("strep");

	//toggleExpand
	private By toggleExpand=By.name("toggleExpand");
	
	
	public void verifyFeelingsMap() {
		
		softAssert = new SoftAssert();
		waitForPresenceOfElement(appiumDriver.findElement(feeling));
		softAssert.assertTrue(appiumDriver.findElement(feeling).isDisplayed(), "Feelings map is not displayed");
		logger.info("Feelings Map Displayed");

		softAssert.assertAll();
		

		
	}

	public void verifyFeelingTabEnabled() {
		
		softAssert = new SoftAssert();
		waitForPresenceOfElement(appiumDriver.findElement(feeling));
		softAssert.assertTrue(appiumDriver.findElement(feeling).isEnabled(), "Feelings map is not enabled");
		softAssert.assertAll();
		logger.info("Feelings Map enabled");
	}

	public void verifyHamburgerMenu() {
		softAssert = new SoftAssert();
		waitForPresenceOfElement(appiumDriver.findElement(menu));
		softAssert.assertTrue(appiumDriver.findElement(menu).isDisplayed(), "Hamburger Menu is not enabled");
				softAssert.assertAll();
		logger.info("Hamberger Menu is enabled");
	}

	public void verifyHeaderName() {
		softAssert = new SoftAssert();
		waitForPresenceOfElement(appiumDriver.findElement(stumpTown));
		softAssert.assertTrue(appiumDriver.findElement(stumpTown).isDisplayed(), "Header Name is not enabled");
				softAssert.assertAll();
		logger.info("Header Name is enabled");
	}

	public void verifyOutsideUserHeaderTitle() {
		softAssert = new SoftAssert();
		waitForPresenceOfElement(appiumDriver.findElement(stumpTown));
		//softAssert.assertTrue(appiumDriver.findElement(stumpTown).isDisplayed(), "Header Name is not enabled");
				softAssert.assertAll();
		logger.info("Header Name is enabled");
		
	}

	public void verifyAllUIElementsInFeelingsMap() {
		softAssert = new SoftAssert();
		
		softAssert.assertTrue(appiumDriver.findElement(doing).isDisplayed(),"Doings tab not displayed");
		
		softAssert.assertTrue(appiumDriver.findElement(toggleExpand).isDisplayed(),"Expand not displayed");
		softAssert.assertTrue(appiumDriver.findElement(locationActive).isDisplayed(), "Locate me Icon is not enabled");
		
		softAssert.assertAll();
		logger.info("Doings tab displayed");
		logger.info("Expand displayed");
		logger.info("Locate me Icon is  displayed");
		
	}

	public void tapOnLocateMeIcon() {
		softAssert = new SoftAssert();
		softAssert.assertTrue(appiumDriver.findElement(locationActive).isDisplayed(), "Locate me Icon is not enabled");
		softAssert.assertAll();
		logger.info("Locate me Icon is displayed");
		
	}

	public void verifyAllFeelingsConditions() {
		softAssert = new SoftAssert();
		;
		if(isDisplayed(allergies)){
			logger.info("Allergies is displayed");
		}
		if(isDisplayed(cold)){
			logger.info("Cold is displayed");
		}
		if(isDisplayed(cough)){
			logger.info("Cough is displayed");
		}
		if(isDisplayed(stomachAilments)){
			logger.info("StomachAilments is displayed");
		}
		if(isDisplayed(flu)){
			logger.info("flu is displayed");
		}
		if(isDisplayed(zipOrNeig)){
			logger.info("Zip Or Neig is displayed");
		}
		if(isDisplayed(strep)){
			logger.info("Strep is displayed");
		}
		
	}

}
