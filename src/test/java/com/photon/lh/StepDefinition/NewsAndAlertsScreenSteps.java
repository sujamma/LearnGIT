package com.photon.lh.StepDefinition;

import com.photon.lh.StepLibrary.CommonLibrary;
import com.photon.lh.StepLibrary.NewsAndAlertsScreenStepLibrary;

import cucumber.api.java.en.Then;

public class NewsAndAlertsScreenSteps {

	
	
	
	
	@Then("^user check all options to categorize the message Tips,News/Alert and Push$")
	public void user_check_all_options_to_categorize_the_message_Tips_News_Alert_and_Push() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifyAllCategorizations();
	}

	@Then("^user shold able see the \"([^\"]*)\" text message$")
	public void user_shold_able_see_the_text_message(String arg1) throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifyThisIsATextMessage();
	}

	@Then("^user verify all radio buttons are unchecked$")
	public void user_verify_all_radio_buttons_are_unchecked() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifyAllRadioButtonsUnchecked();
	}

	@Then("^user can check on catagorize at a time$")
	public void user_can_check_on_catagorize_at_a_time() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifySingleCatagoryAtAtime();
	}

	@Then("^user select News/Alerts and validate other configuration options$")
	public void user_select_News_Alerts_and_validate_other_configuration_options() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifyUserTapOnNewsAndAlert();
	}

	@Then("^user check chekbox option is  unselected$")
	public void user_check_chekbox_option_is_unselected() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifyUncheckOfMakeThisTextALink();
	}

	@Then("^user verify default feeling and Doing unselected under For which section$")
	public void user_verify_default_feeling_and_Doing_unselected_under_For_which_section() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifyFeelingAndDoings();
	}
	
	
	@Then("^user select feelings option$")
	public void user_select_feelings_option() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).selectFeelings();
	}
	
	@Then("^user select doing option$")
	public void user_select_doing_option() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).selectDoing();
	}

	@Then("^user verify sub configuration items for doing$")
	public void user_verify_sub_configuration_items_for_doing() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifySubConfigurationItemsForDoing();
	}
	@Then("^user verify sub configuration items for feeling$")
	public void user_verify_sub_configuration_items_for_feeling() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifySubConfigurationItemsFeeling();
	}

	@Then("^user provide effect period$")
	public void user_provide_effect_period() throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).chooseDateAndTime();
	}
	
	@Then("^user enter start date as \"([^\"]*)\" and End Date as \"([^\"]*)\"$")
	public void user_enter_start_date_as_and_End_Date_as(String startDate, String endDate) throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).chooseDate(startDate, endDate);
	}

	@Then("^user enter Start time as \"([^\"]*)\" and End time as \"([^\"]*)\"$")
	public void user_enter_Start_time_as_and_End_time_as(String startTime, String endTime) throws Throwable {
		new NewsAndAlertsScreenStepLibrary(CommonLibrary.getWebDriverInstance()).chooseTime(startTime, endTime);
	}   
}
