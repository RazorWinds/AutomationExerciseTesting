Feature: Login
  Scenario: As a User, I want to be able to log into my account so that I can continue shopping with my personalised settings.
    Given Given: I am on the login signup page of Automation Exercises
    And I have previously made an account
    When I input my details into the fields
    And I press the login button
    Then I will be logged in

  Scenario: As a User, I want to be able to log into my account so that I can continue shopping with my personalised settings. Bad path
    Given Given: I am on the login signup page of Automation Exercises
    And I have previously made an account
    When I input incorrect details into the fields
    And I press the login button
    Then I will be shown an error message
