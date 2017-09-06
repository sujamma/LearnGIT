@SplashScreen
Feature: Verify user should able to install and launch Stay Healthy app

  @LaunchStayHealthyApp
  Scenario: verify user should able to install and launch Stay healthy app
    Given user launch the LegacyHealth app
    Then user should able to verify install the app
    When user launch stay healthy app and verify splash screen
    Then user able to check the OS promt for seeking the user location access

  #________________________________________________________________________________________________
  @LH_Allow
  Scenario: verify user should be in landing page and show portland map when user tap on Allow
    Given user launch the LegacyHealth app
    Then user should able to verify install the app
    Then user able to check the OS promt for seeking the user location access
    And user tap on Allow and verify user location

  #________________________________________________________________________________________________
  @LH_Don'tAllow
  Scenario: verify user should be in landing page and neighborhood map when user tap on Don'tAllow
    Given user launch the LegacyHealth app
    Then user should able to verify install the app
    Then user able to check the OS promt for seeking the user location access
    And user tap on Don't allow and verify user location
  #________________________________________________________________________________________________
