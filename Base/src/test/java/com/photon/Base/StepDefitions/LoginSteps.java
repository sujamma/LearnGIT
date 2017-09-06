package com.photon.Base.StepDefitions;

import com.photon.Base.StepLibrary.LoginStepLibrary;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginSteps extends LoginStepLibrary {
	
	@Given("^user is able to navigate to Sentara home page as a guest user$")
	public void sentara_home_page(){
		String url = webDriver.getCurrentUrl();
		System.out.println("Successfully navigated to sentara home page  "+ url);
		
	}
	
	@Then("^user should be able to see the title as Sentara$")
	public void title_name() throws Throwable{
		validateHomePage();
	}
	
	@And("^user should be able to see the widget on the sentara homepage$")
	public void widget()throws Throwable{
		validateWidget();
	}
	
}