package com.photon.lh.MobileStepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.google.common.base.Function;
import com.photon.lh.MobileStepLibrary.CommonLibrary;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CommonStep {
	public static Configuration config = null;
	static HSSFWorkbook workBook = null;
	static FileInputStream fis = null;
	static HSSFSheet workSheet = null;
	static HSSFRow row = null;
	 public static long waitSeconds = 30;
	 public static Logger logger=Logger.getLogger(new Object() { }.getClass().getEnclosingClass());

	@Before
	public void launchBrowser() throws ConfigurationException, FileNotFoundException, IOException {
		new CommonLibrary();

	}
	@Given("^user launch the LegacyHealth app$")
	public void user_launch_the_LegacyHealth_app() throws Throwable {
		try{
			CommonLibrary.initiateBrowser();
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Given("^user relaunch the LegacyHealth app$")
	public void user_relaunch_the_LegacyHealth_app() throws Throwable {
		try{
			CommonLibrary.getAppiumInstance().launchApp();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Given("^user launch the Browser$")
	public void Customer_launch_the_Browser() throws IOException, InterruptedException, ConfigurationException {
		try{
			CommonLibrary.initiateBrowser();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Given("^user Close the Browser$")
	public void Customer_Close_the_Browser() throws IOException, InterruptedException {
		try{
			CommonLibrary.closeBrowser();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	@Then("^user navigate back$")
	public void Customer_navigate_back() throws IOException, InterruptedException {
		try{
			CommonLibrary.browserNavigation_Back();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	




	@After
	public void closeBrowser() {
		try{
			CommonLibrary.quitApp();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void reportCucumberTest() {
		// Initiates the extent report and generates the output in the

		// output/Run_/report.html file by default.

//			Reporter.i

		ExtentCucumberFormatter.initiateExtentCucumberFormatter();
		String path=System.getProperty("user.dir")+ "\\Report.xml";
		System.out.println(path);
		
		ExtentCucumberFormatter.loadConfig(new File( System.getProperty("user.dir")+ File.separator+"Report.xml"));
		//ExtentCucumberFormatter.loadConfig(new File( "C:\\essonAutomation\\Report.xml"));
		ExtentCucumberFormatter.addSystemInfo("paltFormName", "IOS");

		ExtentCucumberFormatter.addSystemInfo("Application", "leagcyHealthApp");

		ExtentCucumberFormatter.addSystemInfo("Environment ", "Dev");
		
	}

		
		


private static Wait<? extends WebElement> wait(WebElement element) {
	return new FluentWait<WebElement>(element).withTimeout(waitSeconds, TimeUnit.SECONDS).pollingEvery(2,
			TimeUnit.SECONDS);
}

public void waitForClickable(WebElement element) {
	wait(element).until(new Function<WebElement, Boolean>() {
		public Boolean apply(WebElement el) {
			return el.isEnabled();
		}
	});
}
public static boolean verifyDisplay(WebElement el) {
	boolean flag = false;
	try {
		if (el.isDisplayed())
			flag = true;
	} catch (Exception e) {
	}
	return flag;
}

public void clickElement(WebElement el, String message) {
	try {
		if (verifyDisplay(el)) {
			el.click();
			
		}
	} catch (NoSuchElementException ex) {
		Assert.fail("NoSuchElementException raised for the element " + message + ". So you cannot click");

	}
}




public static void  sendkey(WebElement element, String string) {

	try {
		if (verifyDisplay(element)) {
			element.sendKeys(string);
		}

	} catch (NoSuchElementException ex) {
		Assert.fail("NoSuchElementException raised for the element. So you can not Type");
	}
}
	public static void  clearText(WebElement element) {

		try {
			if (verifyDisplay(element)) {
				element.clear();
			}

		} catch (NoSuchElementException ex) {
			Assert.fail("NoSuchElementException raised for the element. So you can not Type");
		}
}
public void waitForPresenceOfElement(WebElement element) {
	
	
	new FluentWait<WebElement>(element).withTimeout(waitSeconds, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS)
			.until(new Function<WebElement, Boolean>() {

				public Boolean apply(WebElement element) {
					return element.isDisplayed();
				}
			});
}


public boolean isDisplayed(By by) {
	boolean flag = false;
	try {
		CommonLibrary.appiumDriver.findElement(by).isDisplayed();
		 logger.info("Alert is Displayed");
		flag = true;
	} catch (NoSuchElementException e) {
	logger.info("Alert not Displayed");
	}
	return flag;
}

	
}
