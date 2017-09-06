package com.photon.Base.Utilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;



public class BaseStep {
	@SuppressWarnings("rawtypes")
	public MobileDriver driver;
	public boolean initilizestatus = false;
	public InputStream isConfig;
	public static String curdir;
//	public WebDriver webDriver;
	@SuppressWarnings("rawtypes")
	public AndroidDriver androidDriver;
	@SuppressWarnings("rawtypes")
	public IOSDriver iOSDriver;
	private Logger Log = Logger.getLogger("BaseStep");
	public WebElement element;
	public static Configuration config = null;
	//static AppiumServer server = new AppiumServer();
	public static WebDriver webDriver = null;
	
	public void initialize() {		
		curdir = System.getProperty("user.dir");	
			
		if (!initilizestatus) {
			Log.info("------------------initilizing----------------");
			try {
				ConfigurationFactory factory = new ConfigurationFactory(
						"config/config.xml");
				config = factory.getConfiguration();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
			initilizestatus = true;

		} else {
			Log.info("Initilization is Already Done");
		}
	}

	public void LaunchApp(String browser) throws Exception {		
		if (config.getString("breakPoint").equalsIgnoreCase("Desktop")) {
			DesiredCapabilities capabilities = null;
			if (browser.equalsIgnoreCase("fireFox")) {
				Log.info("Starting FireFox Browser");
				capabilities = DesiredCapabilities.firefox();
		        capabilities.setCapability("browserName", browser);				
			} else if (browser.equalsIgnoreCase("chrome")) {
				Log.info("Starting Chrome Browser");
				if ("Windows".equalsIgnoreCase(config
						.getString("machineOS"))) {
//					capabilities = DesiredCapabilities.chrome();
//			        capabilities.setCapability("browserName", browser);
					System.setProperty("webdriver.chrome.driver", curdir+"/drivers/chromedriver.exe");	
					webDriver = new ChromeDriver();
				} else {					
					capabilities = DesiredCapabilities.chrome();
			        capabilities.setCapability("browserName", browser);
				}				
			} else if (browser.equalsIgnoreCase("IE")) {
			} else if (browser.equalsIgnoreCase("safari")) {
				Log.info("Starting Safari Browser");
				capabilities = DesiredCapabilities.safari();
		        capabilities.setCapability("browserName", browser);
				Log.info("Started with Safari Browser");
			} else {
				System.out
						.println("**********Given Browser Name is Wrong************");
			}			
			Log.info("Started with "+browser+" Browser");
			webDriver.manage().window().maximize();
			webDriver.get(config.getString("applicationURL"));
		} 
	}
	public File getScreenShotFile() throws IOException {
		File screenshot = null;
		if(config.getString("operatingSystem").equalsIgnoreCase("Windows")){
			screenshot = ((TakesScreenshot) webDriver)
					.getScreenshotAs(OutputType.FILE);
			Reporter.addScreenCaptureFromPath(screenshot.getAbsolutePath());			
		}else{
			screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);	
			Reporter.addScreenCaptureFromPath(screenshot.getAbsolutePath());
		}		
		return screenshot;
	}

	public void takeScreenShotonFailure(Scenario scenario) {
		if (scenario.getStatus().equalsIgnoreCase("failed")) {
			try {
				File scrFile = getScreenShotFile();
				byte[] data = FileUtils.readFileToByteArray(scrFile);
				scenario.embed(data, "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			Log.info("Screen Shot taken");
		}
	}
	public void closeDriver() {
		if(driver!=null){
			driver.quit();
		//	server.stopServer();
		}else if(webDriver!=null){
			webDriver.quit();
		}		
		Log.info("Application Closed");
	}
	public void reportSetup(String filePath) {
		ExtentProperties extentReport = ExtentProperties.INSTANCE;
		extentReport.setReportPath(filePath);
	
	}
	public static String objectProperty(String webProperty,String iosProperty,
			String androidProperty) {
		String value = null;
		if(BaseStep.config.getString("operatingSystem").equalsIgnoreCase(
				"Windows")){
			value = webProperty;
		}else if (BaseStep.config.getString("operatingSystem").equalsIgnoreCase(
				"Android")) {
			value = androidProperty;
		} else {
			value = iosProperty;

		}
		return value;
	}
}
