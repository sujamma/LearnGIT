@LHCP_Regression
Feature: As a user,I should able to navigate to content entery home page.

  #________________________________________________________________________________________________
  @LHCP_ContentProtalLaunching
  Scenario: user should able to land content entry portal
    Given user launch the Browser
    Then user navigte to content entry home page

  #________________________________________________________________________________________________
  @LHCP_AddMessageScreen
  Scenario: Check user should navigate to Add a message page
    Given user launch the Browser
    Then user navigte to content entry home page
    And user verifies Add new icon in listing page
    When user tap on Add new icon
    Then user navigate to Add a message page
