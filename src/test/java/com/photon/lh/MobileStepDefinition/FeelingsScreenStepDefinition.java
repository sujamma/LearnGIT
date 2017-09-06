package com.photon.lh.MobileStepDefinition;

import org.apache.log4j.Logger;

import com.photon.lh.MobileStepLibrary.CommonLibrary;
import com.photon.lh.MobileStepLibrary.FeelingsScreenStepLibrary;
import com.photon.lh.MobileStepLibrary.SplashScreenStepLIbrary;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeelingsScreenStepDefinition {
	
	public static Logger logger=Logger.getLogger(new Object() { }.getClass().getEnclosingClass());
	
	@Then("^verify that feeling map displaying after the post splash screen$")
	public void verify_that_feeling_map_displaying_after_the_post_splash_screen() throws Throwable {
		new FeelingsScreenStepLibrary(CommonLibrary.getAppiumInstance()).verifyFeelingsMap();  
	}

	@Then("^user should check feeling tab should enabled$")
	public void user_should_check_feeling_tab_should_enabled() throws Throwable {
		new FeelingsScreenStepLibrary(CommonLibrary.getAppiumInstance()).verifyFeelingTabEnabled();
	}

	@Then("^user verify hamburger menu$")
	public void user_verify_hamburger_menu() throws Throwable {
		new FeelingsScreenStepLibrary(CommonLibrary.getAppiumInstance()).verifyHamburgerMenu();
	}

	@Then("^verify user identified user name as header name$")
	public void verify_user_identified_user_name_as_header_name() throws Throwable {
		new FeelingsScreenStepLibrary(CommonLibrary.getAppiumInstance()).verifyHeaderName();
	}

	@Then("^user in not located \"([^\"]*)\" should be default label$")
	public void user_in_not_located_should_be_default_label(String arg1) throws Throwable {
		new FeelingsScreenStepLibrary(CommonLibrary.getAppiumInstance()).verifyOutsideUserHeaderTitle();
	}

	@Then("^verify all Displayed elements in feelings screen$")
	public void verify_all_Displayed_elements_in_feelings_screen() throws Throwable {
		new FeelingsScreenStepLibrary(CommonLibrary.getAppiumInstance()).verifyAllUIElementsInFeelingsMap();
	}

	@When("^user tap on locate me icon to zoom the map$")
	public void user_tap_on_locate_me_icon_to_zoom_the_map() throws Throwable {
		new FeelingsScreenStepLibrary(CommonLibrary.getAppiumInstance()).tapOnLocateMeIcon();
	}

	@When("^user check active conditions$")
	public void user_check_active_conditions() throws Throwable {
		new FeelingsScreenStepLibrary(CommonLibrary.getAppiumInstance()).verifyAllFeelingsConditions();
	}



}
