package com.photon.lh.MobileStepDefinition;

import org.apache.log4j.Logger;

import com.photon.lh.MobileStepLibrary.CommonLibrary;
import com.photon.lh.MobileStepLibrary.SplashScreenStepLIbrary;





import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SplashScreenStepDefinition {
	public static Logger logger=Logger.getLogger(new Object() { }.getClass().getEnclosingClass());
	
	@Then("^user should able to verify install the app$")
	public void user_should_able_to_verify_install_the_app() throws Throwable {
	
		new SplashScreenStepLIbrary(CommonLibrary.getAppiumInstance()).verifyUserInstalledLegacyHealthApp();  
	}

	@When("^user launch stay healthy app and verify splash screen$")
	public void user_launch_stay_healthy_app_and_verify_splash_screen() throws Throwable {
		new SplashScreenStepLIbrary(CommonLibrary.getAppiumInstance()).userLauchStayHealthyApp();  
	}

	@Then("^user able to check the OS promt for seeking the user location access$")
	public void user_able_to_check_the_OS_promt_for_seeking_the_user_location_access() throws Throwable {
		new SplashScreenStepLIbrary(CommonLibrary.getAppiumInstance()).verifyOSPromt();  
	}
	
	@And("^user tap on Allow and verify user location$")
	public void user_tap_on_Allow_and_verify_user_location() throws Throwable {
		new SplashScreenStepLIbrary(CommonLibrary.getAppiumInstance()).tapOnAllow();
	}

	@And("^user tap on Don't allow and verify user location$")
	public void user_tap_on_Don_t_allow_and_verify_user_location() throws Throwable {
		new SplashScreenStepLIbrary(CommonLibrary.getAppiumInstance()).tapOnDonotAllow();
	}
	
	
	@Then("^user tap choose ok on out side neighbourhood alert$")
	public void user_tap_choose_ok_on_out_side_neighbourhood_alert() throws Throwable {
		new SplashScreenStepLIbrary(CommonLibrary.getAppiumInstance()).tapOnOKoutSideAlert();
	}

}
