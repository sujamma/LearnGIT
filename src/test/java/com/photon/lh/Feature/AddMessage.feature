@LHCP_Regression
Feature: As a user,I should able to see the entry form to enter content for the Stay healthy app so that Alerts & Tips can be shown on app

  #________________________________________________________________________________________________
  @LHCP_NavBack
  Scenario: As a user,I should able to navigate back whe tap on close button in Add a message
    Given user launch the Browser
    Then user navigte to content entry home page
    When user tap on Add new icon
    Then user navigate to Add a message page
    When user tap on close button
    Then user navigate back to home page

  #________________________________________________________________________________________________
  @LHCP_TextEditor
  Scenario: As a user,I should able to view the text editor on the entry form so that i can enter text for the app
    Given user launch the Browser
    Then user navigte to content entry home page
    When user tap on Add new icon
    Then user navigate to Add a message page
    Then user able to see "Type message here" inside text editor
    And user abelt to check "140 characters left"
    Then user enter "This is my text editor input" in text editor
    And user validate reverse character count message
    #And user delete message and verify increase character count message
    And user able to validate red color when user reaches the limit
    #And user able to enter alphanumeric special and Symbols
    And user able to check that space is counted as charater and line changing is not counted in textbox
    And user ablet to copy past the text and validate the charter count message

  #________________________________________________________________________________________________
  @LHCP_cat_newsAlert
  Scenario: As a user,I should able to assign entered content to respective News and Alert category
    Given user launch the Browser
    Then user navigte to content entry home page
    When user tap on Add new icon
    Then user navigate to Add a message page
    Then user check all options to categorize the message Tips,News/Alert and Push
    And user shold able see the "This is a ..." text message
    Then user verify all radio buttons are unchecked
    And user can check on catagorize at a time
    Then user select News/Alerts and validate other configuration options
    And user check chekbox option is  unselected
    Then user verify default feeling and Doing unselected under For which section

  #________________________________________________________________________________________________
  @LHCP_cat_Tips
  Scenario: As a user,I should able to assign entered content to respective Tips category
    Given user launch the Browser
    Then user navigte to content entry home page
    When user tap on Add new icon
    Then user navigate to Add a message page
    Then user select Tips and validate other configuration options
    And user check chekbox option is unselected for Tips
    Then user check all check boxs under For Which Conditions section
    And user selected make this text a link
    And user verify enter url text box
    And user verify sumbit button disabled
    Then verify user able to enter valid URL
    And user able to check include legacy go health urgent care link
    Then user able to check multiple check box for conditions section
    And user ablt to click on submit buttion

  #________________________________________________________________________________________________
  @LHCP_cat_Push
  Scenario: As a user,I should able to assign entered content to respective Push category
    Given user launch the Browser
    Then user navigte to content entry home page
    When user tap on Add new icon
    Then user navigate to Add a message page
    And user verify sumbit button disabled
    Then user enter "This is my text editor input" in text editor
    Then user select push and validate other configuration options
    Then user verify submit button enabled

  #________________________________________________________________________________________________
  @LHCP_cat_newsAlert_feelings
  Scenario: As a user,I should able to assign entered content to respective News and Alert category
    Given user launch the Browser
    Then user navigte to content entry home page
    When user tap on Add new icon
    Then user navigate to Add a message page
    Then user select News/Alerts and validate other configuration options
    And user check chekbox option is  unselected
    And user verify default feeling and Doing unselected under For which section
    Then user select feelings option
    And user verify sub configuration items for feeling
    Then user enter start date as "11/11/2017" and End Date as "19/11/2017"
    And user enter Start time as "00:13" and End time as "11:13"

  #________________________________________________________________________________________________
  @LHCP_cat_newsAlert_doing
  Scenario: As a user,I should able to assign entered content to respective doing category
    Given user launch the Browser
    Then user navigte to content entry home page
    When user tap on Add new icon
    Then user navigate to Add a message page
    Then user select News/Alerts and validate other configuration options
    And user check chekbox option is  unselected
    And user verify default feeling and Doing unselected under For which section
    Then user select doing option
    And user verify sub configuration items for doing
    Then user enter start date as "10/11/2017" and End Date as "19/11/2017"
    And user enter Start time as "00:13" and End time as "11:13"
