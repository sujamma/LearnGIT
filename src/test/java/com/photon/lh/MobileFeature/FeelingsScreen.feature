@FeelingsScreen
Feature: Verify user should able to view feeling screen and validate all current conditions around city.

  @FeelingsMap
  Scenario: verify user should able to veiw feeling screen and validate all options
    Given user launch the LegacyHealth app
    #Then user should able to verify install the app
    #When user launch stay healthy app and verify splash screen
     Then user tap choose ok on out side neighbourhood alert
    Then verify that feeling map displaying after the post splash screen
    And user should check feeling tab should enabled
    Then user verify hamburger menu
    And verify user identified user name as header name
    And user in not located "StumpTown" should be default label
    And verify all Displayed elements in feelings screen
    When user tap on locate me icon to zoom the map
    And user check active conditions

  #________________________________________________________________________________________________
  @LaunchScenario
  Scenario: verify user should able to install and launch Stay healthy app
  
    #________________________________________________________________________________________________
