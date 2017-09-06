package com.photon.lh.StepDefinition;

import org.apache.log4j.Logger;






import com.photon.lh.StepLibrary.CommonLibrary;
import com.photon.lh.StepLibrary.ContentEntryHomeScreenStepLibrary;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContentEntryHomeScreenSteps {
	
public static Logger logger=Logger.getLogger(new Object() { }.getClass().getEnclosingClass());
	
	@Then("^user navigte to content entry home page$")
	public void user_navigte_to_content_entery_home_page() throws Throwable {
		new ContentEntryHomeScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifyUserNavigateToContentEntryHomeScreen();
	}

	@Then("^verify all UI elements in add address page$")
	public void verify_all_UI_elements_in_add_address_page() throws Throwable {
		new ContentEntryHomeScreenStepLibrary(CommonLibrary.getWebDriverInstance())
				.userCheckAllUIElementsContentEntryHomeScreen();
	}
	
	
	@Then("^user verifies Add new icon in listing page$")
	public void user_verifies_Add_new_icon_in_listing_page() throws Throwable {
		new ContentEntryHomeScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifyAddNewIcon();
	}

	@When("^user tap on Add new icon$")
	public void user_tap_on_Add_new_icon() throws Throwable {
		new ContentEntryHomeScreenStepLibrary(CommonLibrary.getWebDriverInstance()).userTapOnAddNewIcon();
	}

	@Then("^user navigate to Add a message page$")
	public void user_navigate_to_Add_a_message_page() throws Throwable {
		new ContentEntryHomeScreenStepLibrary(CommonLibrary.getWebDriverInstance()).verifyUserNavigateToAddMessageScreen();
	}

}
