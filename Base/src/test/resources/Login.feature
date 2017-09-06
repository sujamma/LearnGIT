#Author : Monaliza.K.L

Feature: Login feature

@sampletest
Scenario: Verify user is able to Sentara home page as a guest user
Given user is able to navigate to Sentara home page as a guest user
Then user should be able to see the title as Sentara
And user should be able to see the widget on the sentara homepage

@test1
Scenario: Verify user is able to login to sentara application with valid credentials
When user enters Sentara ID in MySentara ID input field under Current User Login widget
And user enters password in Password input field under Current User Login widget
When user clicks on SIGN IN button
Then user should be able to navigate to sentara home page as a logged in user 

@test2
Scenario Outline: Verify user is able to recover the MySentara ID
Given user is able to navigate to Sentara home page as a guest user
When user clicks on <input> under Current User login widget
Then user should be able to navigate to recovery page

Examples:
|	input								|
|	Forgot My Sentara ID|
|	Forgot Password			|

@test3
Scenario: Verify user is able to get the error message for the invalid MySentara ID
Given user is able to navigate to Sentara home page as a guest user
When user enters invalid MySentara ID 
Then user should be able to get the error message 

@test4
Scenario: Verify user is able to get the error message for the invalid combination of credentials
Given user is able to navigate to Sentara home page as a guest user
When user tries to login with the invalid credentials
Then user should be able to get the error message
