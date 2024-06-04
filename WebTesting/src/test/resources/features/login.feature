Feature: Login
  Scenario: As a User, I want to be able to log into my account so that I can continue shopping with my personalised settings.
    Given I am on the login signup page of Automation Exercises
    And I have previously made an account
    When I input my details into the fields
    And I press the login button
    Then I will be logged in

  Scenario: As a User, I want to be able to log into my account so that I can continue shopping with my personalised settings. Bad path
    Given I am on the login signup page of Automation Exercises
    And I have previously made an account
    When I input incorrect details into the fields
    And I press the login button
    Then I will be shown an error message

  Scenario: As a User, I want to be able to log out of my account so that no one will be able to access my account while im not at my computer
    Given I am logged into Automation Exercises
    When I press the log out button
    Then I will be logged out

  Scenario: As a User I want to be able to create an account so that I can make purchases
    Given I am on the login signup page of Automation Exercises
    When I Input my name and email and press signup
    And I input my address on the signup page
    Then My account will be created
