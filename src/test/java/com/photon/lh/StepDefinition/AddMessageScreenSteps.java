package com.photon.lh.StepDefinition;

import org.apache.log4j.Logger;

import com.photon.lh.StepLibrary.AddMessageScreenStepLibrary;
import com.photon.lh.StepLibrary.CommonLibrary;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddMessageScreenSteps {
	public static Logger logger=Logger.getLogger(new Object() { }.getClass().getEnclosingClass());
	
	@When("^user tap on close button$")
	public void user_tap_on_close_button() throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).userTapOnCloseButton();   
	}

	@Then("^user navigate back to home page$")
	public void user_navigate_back_to_home_page() throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).userNavigateBackToHomePage();   
	}
	
	@Then("^user able to see \"([^\"]*)\" inside text editor$")
	public void user_able_to_see_inside_text_editor(String sugMsg) throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).suggestiveMessage(sugMsg);   
	}

	@Then("^user abelt to check \"([^\"]*)\"$")
	public void user_abelt_to_check(String charLeft) throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).characterLeftMsg(charLeft);   
	}

	@Then("^user enter \"([^\"]*)\" in text editor$")
	public void user_enter_in_text_editor(String text) throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).enterText(text);   
	}

	@Then("^user validate reverse character count message$")
	public void user_validate_reverse_character_count_message() throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).reverseCharaterCount();   
	}

	@Then("^user delete message and verify increase character count message$")
	public void user_delete_message_and_verify_increase_character_count_message() throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).deleteAndVerifyCharCount();   
	}

	@Then("^user able to validate red color when user reaches the limit$")
	public void user_able_to_validate_red_color_when_user_reaches_the_limit() throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).redColorReachesLimit();   
	}

	@Then("^user able to enter alphanumeric special and Symbols$")
	public void user_able_to_enter_alphanumeric_special_and_Symbols() throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).enterAlphaNumberSpecialCharIntoEditor(); 
	}

	@Then("^user able to check that space is counted as charater and line changing is not counted in textbox$")
	public void user_able_to_check_that_space_is_counted_as_charater_and_line_changing_is_not_counted_in_textbox() throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).spaceCountAndLineChangeCount(); 
	}

	@Then("^user ablet to copy past the text and validate the charter count message$")
	public void user_ablet_to_copy_past_the_text_and_validate_the_charter_count_message() throws Throwable {
		new AddMessageScreenStepLibrary(CommonLibrary.getWebDriverInstance()).copyPastVeriyCharCount(); 
	}


}
