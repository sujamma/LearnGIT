package com.photon.lh.StepDefinition;

import com.photon.lh.StepLibrary.CommonLibrary;
import com.photon.lh.StepLibrary.PushScreenStepLibrary;


import cucumber.api.java.en.Then;

public class PushScreenSteps {

	
	@Then("^user select push and validate other configuration options$")
	public void user_select_push_and_validate_other_configuration_options() throws Throwable {
		new PushScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifyConfiguration();
	}

	@Then("^user verify submit button enabled$")
	public void user_verify_submit_button_enabled() throws Throwable {
		new PushScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifySubmitEnabled();
	}
}
