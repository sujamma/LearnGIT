package com.photon.lh.StepDefinition;

import com.photon.lh.StepLibrary.CommonLibrary;
import com.photon.lh.StepLibrary.TipsScreenLibrary;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class TipsScreenSteps {
	
	
	
	
	
	
	@Then("^user select Tips and validate other configuration options$")
	public void user_select_Tips_and_validate_other_configuration_options() throws Throwable {
		new TipsScreenLibrary(CommonLibrary.getWebDriverInstance()).verifyConfiguration();
	  
	}

	@Then("^user check chekbox option is unselected for Tips$")
	public void user_check_chekbox_option_is_unselected_for_Tips() throws Throwable {
		new TipsScreenLibrary(CommonLibrary.getWebDriverInstance()).verifyUncheckOptions();
		
	}

	

	@Then("^user check all check boxs under For Which Conditions section$")
	public void user_check_all_check_boxs_under_For_Which_Conditions_section() throws Throwable {
		new TipsScreenLibrary(CommonLibrary.getWebDriverInstance()).verifyUncheckOptionsUnderWhichConditions();
	  
	}

	@Then("^user selected make this text a link$")
	public void user_selected_make_this_text_a_link() throws Throwable {
		new TipsScreenLibrary(CommonLibrary.getWebDriverInstance()).clickMakeThisTextaLink();
		
	  
	}
	
	@And("^user verify enter url text box$")
	public void user_verify_enter_url_text_box() throws Throwable{
		new TipsScreenLibrary(CommonLibrary.getWebDriverInstance()).verifyURlTextBox();
	}

	@Then("^user verify sumbit button disabled$")
	public void user_verify_sumbit_button_disabled() throws Throwable {
		new TipsScreenLibrary(CommonLibrary.getWebDriverInstance()).verifySubmitDisabled();
	  
	}

	@Then("^verify user able to enter valid URL$")
	public void verify_user_able_to_enter_valid_URL() throws Throwable {
		new TipsScreenLibrary(CommonLibrary.getWebDriverInstance()).enterURL();
	  
	}

	@Then("^user able to check include legacy go health urgent care link$")
	public void user_able_to_check_include_legacy_go_health_urgent_care_link() throws Throwable {
		new TipsScreenLibrary(CommonLibrary.getWebDriverInstance()).checkUrgentCare();
	  
	}

	

	

	@Then("^user able to check multiple check box for conditions section$")
	public void user_able_to_check_multiple_check_box_for_conditions_section() throws Throwable {
		new TipsScreenLibrary(CommonLibrary.getWebDriverInstance()).checkMultiOptions();
	  
	}

	@Then("^user ablt to click on submit buttion$")
	public void user_ablt_to_click_on_submit_buttion() throws Throwable {
		new TipsScreenLibrary(CommonLibrary.getWebDriverInstance()).clickedOnSubmit();
	  
	}



}
