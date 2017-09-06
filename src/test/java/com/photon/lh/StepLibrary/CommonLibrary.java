package com.photon.lh.StepLibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.photon.lh.Constant.UserConfig;

import cucumber.api.DataTable;


public class CommonLibrary {
	public static AppiumDriver<?> appiumDriver;
	public static WebDriver webDriver;
	public static AppiumDriver<?> webDriverConvert = null;
	public static WebElement element = null;
	static WebDriverWait browserWithElementWait = null;
	static long t1 = 0;
	static long t2 = 0;
	static long timeTaken = 0;
	String actual = null;
	public static String expecte = null;
	public static String X = null;
	public static String Y = null;
	static Integer Ycoordinate = null;
	static Integer Xcoordinate = null;
	static Integer img_Width = null;
	static Integer img_Height = null;
	static String imgLocation;
	static String imgSize;
	public static Configuration config = null;
	public static Logger logger=Logger.getLogger(new Object() { }.getClass().getEnclosingClass());
	
	public CommonLibrary() throws ConfigurationException, IOException {
		ConfigurationFactory factory = new ConfigurationFactory("config/config.xml");
		config = factory.getConfiguration();
	}

	public static void initiateBrowser() throws ConfigurationException, IOException, InterruptedException {
		if (config.getString("breakPoint").equalsIgnoreCase("Desktop")) {
			if ("Yes".equalsIgnoreCase(config.getString("fireFox"))) {
			
				webDriver = new FirefoxDriver();
			} else if ("Yes".equalsIgnoreCase(config.getString("chrome"))) {
				if("Windows".equalsIgnoreCase(config.getString("operatingSystem"))) {
				} else {
				
					ChromeDriverManager.getInstance().setup();
					webDriver = new ChromeDriver();
					webDriver.get(config.getString("applicationURL"));
					logger.info("================================************************==========================================");
					logger.info("Application URL:"+config.getString("applicationURL"));
					logger.info("================================************************==========================================");
					
					webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}
			} else if ("Yes".equalsIgnoreCase(config.getString("IE"))) {
			} else if ("Yes".equalsIgnoreCase(config.getString("safari"))) {
			} else {
				System.out.println("**********Given Browser Name is Wrong************");
			}
			webDriver.manage().window().maximize();
			if ("iOS".equalsIgnoreCase(config.getString("operatingSystem"))) {
				initiateBrowser_iOS();
			} else if("android".equalsIgnoreCase(config.getString("operatingSystem"))) {
				initiateBrowser_Android();
			} 
			
		}else if(config.getString("breakPoint").equalsIgnoreCase("MobileIOSApp")) {
			if ("iOS".equalsIgnoreCase(config.getString("operatingSystem"))) {
				initiateIOSApp();
			}
		}

	}

	public static void closeBrowser(){
		webDriver.quit();
	}
public   static void initiateAndroidApp() throws MalformedURLException{
	
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("unicodeKeyboard", "true");
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("appActivity", UserConfig.activity);
		capabilities.setCapability("appPackage", UserConfig.pack);
		capabilities.setCapability("app", UserConfig.app_Path);
		//capabilities.setCapability("unicodeKeyboard", "true");
		capabilities.setCapability("full-reset", true);
		//capabilities.setCapability("no-reset", "true");
		capabilities.setCapability("autoLaunch", "true");
		// capabilities.setCapability("autoAcceptAlerts", true);
		// capabilities.setCapability("autoDismissAlerts", true);

		appiumDriver = new AndroidDriver<MobileElement>(new URL(UserConfig.appiumURL), capabilities);
		appiumDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger.info("Android Driver Initialized");
		
		
	
}

public   static void initiateIOSApp() throws MalformedURLException{
	
	logger.info("Launching App in iOS Device");

	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("deviceName", "iPhone 6S");
	capabilities.setCapability("automationName", "XCUITest");
	capabilities.setCapability("bundleId",UserConfig.iOSbundleID);
	capabilities.setCapability("udid",UserConfig.iOSUDID );
	capabilities.setCapability("app",UserConfig.iOS_app_Path);
	//capabilities.setCapability("xcodeConfigfile", "/abs/path/to/xcodeConfigfile");
	capabilities.setCapability("full-reset", true);
	//capabilities.setCapability("no-reset", true);
	capabilities.setCapability("autoLaunch", "true");
	// capabilities.setCapability("autoAcceptAlerts", true);
	// capabilities.setCapability("autoDismissAlerts", true);
	//capabilities.setCapability("unicodeKeyboard", "true");
	appiumDriver = new IOSDriver<MobileElement>(new URL(UserConfig.appiumIOS_URL), capabilities);
	appiumDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	logger.info("IOSAppium Driver Initialized");
	

}



	public static void initiateBrowser_Android() throws IOException, InterruptedException {
		try {
			String adbPath = UserConfig.sdk_location + File.separator + "platform-tools";
			Runtime.getRuntime().exec(UserConfig.projectLocation + File.separator + "Extensions/Killchromedriver.sh" + " start");
			Thread.sleep(1000 * 2);
			Thread.sleep(1000);
			Runtime.getRuntime().exec(adbPath + "/adb" + " start-server");
			Thread.sleep(1000);
			Runtime.getRuntime().exec(UserConfig.projectLocation + "/drivers/chromedriver");
			Thread.sleep(1000);//UserConfig
			System.out.println("initialising the browser");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("androidPackage", "com.android.chrome");
			options.setExperimentalOption("androidDeviceSerial", UserConfig.deviceId);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setPlatform(Platform.ANDROID);
			capabilities.setCapability("device", "android");
			capabilities.setCapability("app", "chrome");
			webDriver = new RemoteWebDriver(new URL(UserConfig.chromeDriver_location), capabilities);
			webDriver.manage().deleteAllCookies();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void initiateBrowser_iOS() throws IOException, InterruptedException {
		try {
			System.out.println("initialising the Ios browser");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME,"safari");
			capabilities.setCapability("app", "safari");
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", UserConfig.platform_Version);
			capabilities.setCapability("deviceName", "iPhone");
			capabilities.setCapability("device", "iPhone");
			capabilities.setCapability("-U", UserConfig.deviceUDID); 
			capabilities.setCapability("app", UserConfig.safarilauncherLocation); 
			capabilities.setCapability("noReset", true);
			capabilities.setCapability("autoAcceptAlerts", true);
			webDriver=new RemoteWebDriver(new URL(UserConfig.appiumServerURL_iOS), capabilities);
			webDriver.manage().deleteAllCookies();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/*
	 *  Methods for 
	 */

	public static void validateImagePosition(String objectProperty,String imgLocation, String imgName) {
		try {
			element = getElementByProperty(objectProperty, webDriver);
			Point point = element.getLocation();
			String[] imgsp=imgLocation.split("X");
			Xcoordinate = Integer.parseInt(imgsp[0]);
			Ycoordinate = Integer.parseInt(imgsp[1]);
			if (Xcoordinate.equals(point.x) && Ycoordinate.equals(point.y) ) {
				System.out.println("------------------------------------------------------------------------------");
				System.out.println(imgName+" Image Position :: X & Y coordinate value are Same");
			}else {
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("Mismatch of "+imgName+" Image Position X & Y coordinate");
				System.out.println("Actual X and Y Coordinate of Image "+point.x +","+point.y);
				System.out.println("Expected X and Y Coordinate of Image "+Xcoordinate+","+Ycoordinate);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	/*
	 *  Methods for 
	 */

	public static void validateImageSize(String objectProperty,String imgSize, String imgName) {
		try {
			element = getElementByProperty(objectProperty, webDriver);
			Dimension dimensions= element.getSize();
			String[] imgsize=imgSize.split("X");
			img_Width = Integer.parseInt(imgsize[0]);
			img_Height = Integer.parseInt(imgsize[1]);
			if(img_Width.equals(dimensions.width) && img_Height.equals(dimensions.height)) {
				System.out.println(imgName+" Image Width & Height value are Same");
			}else {
				System.out.println("Mismatch of "+imgName+" Image Width & Height");
				System.out.println("Actual Width and Height of Image "+dimensions.width +","+dimensions.height);
				System.out.println("Expected Width and Height of Image "+img_Width+","+img_Height);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	/*
	 *  Methods for 
	 */

	public static void accessibilityValidation(String objectProperty,String Text, String imgName) {
		try {
			element = getElementByProperty(objectProperty, webDriver);
			String alt = element.getAttribute("alt");
			if(alt.equalsIgnoreCase(Text)) {
				System.out.println(imgName+" Image accessibility expected and actual name are Same");
			}else {
				System.out.println(imgName+" Image accessibility expected and actual name are not Same");
				System.out.println("Accessibility-Actual : "+alt);
				System.out.println("Accessibility-Expected : "+Text);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	/*
	 *  Methods for 
	 */

	public static void linkText_Validation(String objectProperty,String Text) {
		try {
			element = getElementByProperty(objectProperty, webDriver);
			String linkText = element.getText();
			if(linkText.equalsIgnoreCase(Text)) {
				System.out.println("Link Text expected and actual text are Same");
			}else {
				System.out.println("Link Text expected and actual text are not Same");
				System.out.println("Link Text - Actual : "+linkText);
				System.out.println("Link Text -Expected : "+Text);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	/*
	 *  Methods for 
	 */

	public static void performanceValidation(long t1,long t2, String perf_Expected) throws Exception, IOException, InterruptedException {
		try {
			timeTaken = (t2-t1)/1000;
			long expected = Long.parseLong(perf_Expected);
			if(timeTaken<=expected){
			} else {
				System.out.println(" Page Load Time is High while Navigating to ::"+webDriver.getTitle() );
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	/*
	 *  Methods for 
	 */

	public static WebElement getElementByProperty(String objectProperty, WebDriver webDriver) {
		String propertyType = null;
		WebDriverWait browserWithElementWait = null;
		try{
			if (browserWithElementWait == null) {
				browserWithElementWait = new WebDriverWait(webDriver, config.getInt("elementWaitInSeconds"));
			}
			propertyType = StringUtils.substringAfter(objectProperty, "~");
			objectProperty = StringUtils.substringBefore(objectProperty, "~");
			if (propertyType.equalsIgnoreCase("CSS")) {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("XPATH")) {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("ID")) {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.id(objectProperty)));
				// highlightElement(webElement, browser);
			} else if (propertyType.equalsIgnoreCase("NAME")) {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.name(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("LINKTEXT")) {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(objectProperty)));
				highlightElement(element, webDriver);
			} else {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectProperty)));
				//		highlightElement(webElement, browser);	//to avoid overlapping of elements commented the following line of code -Angeline-03AUG2015
			}
		}catch(Exception e){

		}

		return element;
	}


	/*
	 * Common Methods for Element Verification
	 */

	public static boolean isElementPresentVerification(String objectProperty) throws Exception {
		boolean isElementPresent = false;
		browserWithElementWait = new WebDriverWait(webDriver,30);
		try {
			element = getElementByProperty(objectProperty, webDriver);
			if (element != null) {
				isElementPresent = true;
				t2=System.currentTimeMillis();
			} else {
				throw new Exception("Object Couldn't be retrieved and verified");
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementPresent;
	}


	/*
	 *  Methods for 
	 */

	public static boolean clearAndEnterText(String objectProperty, String Text) {
		boolean isTextEnteredResult = false;
		try {
			if ("-".equals(Text)) {
				// ignore this field
				isTextEnteredResult = true;
			} else {
				WebElement textBox = getElementByProperty(objectProperty, webDriver);
				textBox.clear();
				Thread.sleep(2000);
				textBox.sendKeys(Text);
				isTextEnteredResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return isTextEnteredResult;
	}



	/*
	 *  Methods for Highlight the Elements
	 */
	public static void highlightElement(WebElement element,WebDriver webDriver) {
		for (int i = 0; i < 1; i++) {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 3px solid black;");
		}
	}


	/*
	 *  Methods for 
	 */
	public static void browserNavigation_Back() {
		try {
			webDriver.navigate().back();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 *  Methods for 
	 */
	public static void refresh_Page() {
		webDriver.navigate().refresh();
	}


	/*
	 *  Common Method for Click
	 */
	public static boolean isElementPresentVerifyClick(String objectProperty) {
		boolean isVerifiedAndClicked = false;
		browserWithElementWait = new WebDriverWait(webDriver,30);
		try {
			element = getElementByProperty(objectProperty, webDriver);
			if (element != null) {
				t1=System.currentTimeMillis();
				element.click();
				isVerifiedAndClicked = true;
			} else {
				throw new Exception("Object Couldn't be retrieved and clicked");
			}
		} catch (Exception e) {
			element = null;
		}
		return isVerifiedAndClicked;
	}



	/*
	 *  Methods for 
	 */

	public static void getscreenshot(String screenShotName) throws Exception 
	{
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		FileUtils.copyFile(scrFile, new File(UserConfig.projectLocation+"/FailureScreenShot/"+screenShotName+".png"));
	}


	/*
	 *  Methods for 
	 */

	public static void scrollTo(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", element);
	}


	/*
	 *  Methods for 
	 */

	public static Map<String, List<String>> getHorizontalData(DataTable dataTable) {
		Map<String, List<String>> dataMap = null;
		try {
			dataMap = new HashMap<String, List<String>>();
			List<String> headingRow = dataTable.raw().get(0);
			int dataTableRowsCount = dataTable.getGherkinRows().size() - 1;
			ArrayList<String> totalRowCount = new ArrayList<String>();
			totalRowCount.add(Integer.toString(dataTableRowsCount));
			dataMap.put("totalRowCount", totalRowCount);
			for (int i = 0; i < headingRow.size(); i++) {
				List<String> dataList = new ArrayList<String>();
				dataMap.put(headingRow.get(i), dataList);
				for (int j = 1; j <= dataTableRowsCount; j++) {
					List<String> dataRow = dataTable.raw().get(j);
					dataList.add(dataRow.get(i));
				}
			}
		} catch (Exception e) {

		}
		return dataMap;
	}


	/*
	 *  Methods for 
	 */

	public static Map<String, List<String>> getVerticalData(DataTable dataTable) {
		Map<String, List<String>> dataMap = null;
		try {
			int dataTableRowsCount = dataTable.getGherkinRows().size();
			dataMap = new HashMap<String, List<String>>();
			for (int k = 0; k < dataTableRowsCount; k++) {
				List<String> dataRow = dataTable.raw().get(k);
				String key = dataRow.get(0);
				dataRow.remove(0);
				dataMap.put(key, dataRow);
			}
		} catch (Exception e) {

		}
		return dataMap;
	}


	/*
	 *  Methods for 
	 */

	public static String getXLSTestData (String FileName,String SheetName, String RowId,String column) throws IOException {

		String col1 = null;
		DataFormatter df = new DataFormatter();
		FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir") +"/InputData"+ File.separator +FileName+".xls"));
		HSSFWorkbook book = new HSSFWorkbook(file);
		HSSFSheet sheet = book.getSheet(SheetName);

		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int rowIterator = 1; rowIterator<=rowCount;rowIterator++) {
			String row = sheet.getRow(rowIterator).getCell(0).getStringCellValue();
			if (row.equalsIgnoreCase(RowId)) {
				for (int colIterator = 1;colIterator<sheet.getRow(rowIterator).getLastCellNum();colIterator++) {
					String col = sheet.getRow(0).getCell(colIterator).getStringCellValue();
					if (col.equalsIgnoreCase(column)) {
						Cell cellvalue = sheet.getRow(rowIterator).getCell(colIterator);
						col1 = df.formatCellValue(cellvalue);
						break;
					}
				}
			}
		}
		return col1;
	}

	
	
	public static WebDriver getWebDriverInstance() {
		if((webDriver==null)){
			webDriver=appiumDriver;
		
		}
		return webDriver;
	}

	
}
