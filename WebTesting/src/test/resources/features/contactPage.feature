Feature: Contact Page
  Scenario: As a customer, I should receive a confirmation message when submitting a request with valid contact details so that I know they are correct.
    Given I am on the Contact us page
    When I fill out the contact form with valid information (name, email, subject, message)
    And I click the Submit button
    Then a confirmation message should be displayed indicating that the message has been sent

  Scenario: As a customer, I should see an error when leaving fields blank so that I know which fields need to be filled out.
    Given I am on the Contact us page
    When I click the Submit button but the fields are empty
    Then an error should appear telling the user to fill in the fields
    And the form should not be submitted.

  Scenario: As a customer, I should be told if my email is invalid so that I can fix it if needed.
    Given I am on the Contact us page
    When the email they have entered is invalid (ie: FakeEmail.com)
    And I click the Submit button
    Then an error should appear telling the user what is missing from the email
    And the form should not be submitted.