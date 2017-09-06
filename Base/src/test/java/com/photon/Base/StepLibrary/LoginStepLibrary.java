package com.photon.Base.StepLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

import com.photon.Base.Objects.LoginObjects;
import com.photon.Base.Utilities.BaseStep;
import com.photon.Base.Utilities.CommonUtilities;

public class LoginStepLibrary extends BaseStep {

	
	CommonUtilities utils = new CommonUtilities(webDriver);
	Logger log = Logger.getLogger(this.getClass().getSimpleName());

	public void validateHomePage() throws Throwable{
		Thread.sleep(1000);
		WebElement logo = utils.getElementByProperty(LoginObjects.logo);	
		Thread.sleep(1000);
		System.out.println(logo.getText());
		assertTrue("Button is not displayed in the home page",logo.isDisplayed());				
	}
	
	public void validateWidget() throws Throwable{
		WebElement widget = webDriver.findElement(By.className("shadow-box"));
		Thread.sleep(1000);
		assertTrue("Widget is not displayed in the home page",widget.isDisplayed());	
	}
}