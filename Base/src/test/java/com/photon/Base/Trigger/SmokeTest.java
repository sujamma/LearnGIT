package com.photon.Base.Trigger;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.cucumber.listener.Reporter;
import com.photon.Base.Utilities.BaseStep;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources", glue = {"com.photon.Base.StepDefinition","com.photon.Base.Trigger"}, monochrome = true, plugin = {
		"pretty", "html:target/Report/cucumber",
		"json:target/cucumber/report.json",
		"usage:target/cucumber/cucumber-usage.json","com.cucumber.listener.ExtentCucumberFormatter:"}, tags = { "@sampletest" })

public class SmokeTest extends AbstractTestNGCucumberTests {

	Logger log = Logger.getLogger(this.getClass().getSimpleName());
	BaseStep base = new BaseStep();
	public static String reportFilePath;
	
	@After
	public void takeScreenShot(Scenario scenario){
		base.takeScreenShotonFailure(scenario);
	}
	
	@BeforeSuite
	public void initialize() {
		try {			
			base.initialize();			
			log.info("Property File Initialized");						
		} catch (Exception | Error e) {
			log.info(e.getStackTrace());
		}
	}

	@Parameters({ "browser"})
	@BeforeTest
	public void setup(String browser) throws Exception {
		try {
			//If we don't have mongo command this below code
			reportFilePath = "output" + File.separator
					+ this.getClass().getSimpleName() + File.separator+browser+File.separator
					+ "report.html";
			FileUtils.deleteDirectory(new File("output" + File.separator
					+ this.getClass().getSimpleName()+browser+File.separator));
			base.reportSetup(reportFilePath);
			log.info("Extended Cucumber Report Setup Done");
			
			base.LaunchApp(browser);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Parameters({ "browser"})
	@AfterTest
	public void shutDown(String browser) throws IOException, InterruptedException {
		
		Reporter.loadXMLConfig(BaseStep.curdir+"/config/Report.xml");
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", System.getProperty("os.name"));	
		Reporter.setSystemInfo("Browser", browser);
		
		base.closeDriver();
		log.info(browser+" is Quit");
	}

}
