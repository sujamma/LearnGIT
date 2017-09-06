package com.photon.lh.MobileStepLibrary;

import io.appium.java_client.AppiumDriver;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.photon.lh.MobileStepDefinition.CommonStep;



public class SplashScreenStepLIbrary extends CommonStep {
	public static Logger logger = Logger.getLogger(new Object() {
	}.getClass().getEnclosingClass());

	AppiumDriver<?> appiumDriver = null;
	SoftAssert softAssert = null;

	public SplashScreenStepLIbrary(AppiumDriver<?> appiumDriver) {
		this.appiumDriver = appiumDriver;
	}

	
	
	//Cancel
	private By cancel =By.name("Cancel");
	
	//Ok
	private By ok =By.name("Ok");
	
	//Neighbourhood
	private By outNeighbourhood = By.name("/XCUIElementTypeApplication[@name='Stay Healthy']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]");
	
	//Stay Healthy,
	private By stayHealty =By.name("Stay Healthy,");
	
	//Stumptown!
	private By stumpTown =By.name("Stumptown!");
	
	// Don’t Allow
	private By dontAllow = By.name("Don’t Allow");

	// Allow
	private By allow = By.name("Allow");

	// Alert Text
	private By alertText = By.name("Allow “Stay Healthy” to access your location while you use the app?");

	public void verifyUserInstalledLegacyHealthApp() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		logger.info(appiumDriver);
		
		waitForPresenceOfElement(appiumDriver.findElement(allow));
		softAssert.assertTrue(appiumDriver.findElement(allow).isDisplayed(), "Stay healthy app splash screen allow displayed");
		
		/*waitForPresenceOfElement(appiumDriver.findElement(stayHealty));
		softAssert.assertTrue(appiumDriver.findElement(stayHealty).isDisplayed(), "Stay healthy app splash screen stayhealthy displayed");
		
		waitForPresenceOfElement(appiumDriver.findElement(stumpTown));
		softAssert.assertTrue(appiumDriver.findElement(stumpTown).isDisplayed(), "Stay healthy app splash screen stumpTown displayed");*/
		logger.info("Stay healthy app splash screen launched");

		softAssert.assertAll();
		logger.info("soft Assert All method executed");

	}

	public void userLauchStayHealthyApp() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		waitForPresenceOfElement(appiumDriver.findElement(dontAllow));
		softAssert.assertTrue(appiumDriver.findElement(dontAllow).isDisplayed(), "Stay healthy app is launched");
		logger.info("Stay healthy app is launched");

		softAssert.assertAll();
		logger.info("soft Assert All method executed");

	}

	public void verifyOSPromt() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		waitForPresenceOfElement(appiumDriver.findElement(dontAllow));
		softAssert.assertTrue(appiumDriver.findElement(dontAllow).isDisplayed(),
				"Don't Allow option displayd in the prompt");
		logger.info("Don't Allow option displayd in the prompt");
		softAssert.assertTrue(appiumDriver.findElement(allow).isDisplayed(), "Allow option displayed in the Prompt");
		logger.info("Allow option displayed in the Prompt");
		softAssert.assertTrue(appiumDriver.findElement(alertText).isDisplayed(),
				"Allow “Stay Healthy” to access your location while you use the app?");
		logger.info("Allow “Stay Healthy” to access your location while you use the app?");
		logger.info("Promt Displayed");

		softAssert.assertAll();
		logger.info("soft Assert All method executed");
	}

	public void tapOnAllow() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		waitForPresenceOfElement(appiumDriver.findElement(allow));
		softAssert.assertTrue(appiumDriver.findElement(allow).isDisplayed(),
				"Allow option displayd in the prompt");
		logger.info("Allow option displayd in the prompt");
		clickElement(appiumDriver.findElement(allow), "Allow option not displayd in the prompt");
		softAssert.assertAll();
		logger.info("soft Assert All method executed");
	}

	public void tapOnDonotAllow() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		waitForPresenceOfElement(appiumDriver.findElement(dontAllow));
		softAssert.assertTrue(appiumDriver.findElement(dontAllow).isDisplayed(),
				"Don't Allow option displayd in the prompt");
		logger.info("Don't Allow option displayd in the prompt");
		clickElement(appiumDriver.findElement(dontAllow), "Don't Allow option not displayd in the prompt");
		softAssert.assertAll();
		logger.info("soft Assert All method executed");
		
	}

	public void tapOnOKoutSideAlert() {
		logger.info("Soft Assertion instance created ");
		softAssert = new SoftAssert();
		waitForPresenceOfElement(appiumDriver.findElement(ok));
		softAssert.assertTrue(appiumDriver.findElement(ok).isDisplayed(),
				"ok option displayd in the prompt");
		logger.info("ok option displayd in the prompt");
		clickElement(appiumDriver.findElement(ok), "ok option not displayd in the prompt");
		softAssert.assertAll();
		logger.info("soft Assert All method executed");
		
	}
}
