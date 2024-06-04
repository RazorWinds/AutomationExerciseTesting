Feature: Contact Page
  Scenario: As a customer, I should receive a confirmation message when submitting a request with valid contact details so that I know they are correct.
    Given I am on the Contact us page
    When I fill out the contact form with valid information (name, email, subject, message)
    And click the Submit button
    Then a confirmation message should be displayed indicating that the message has been sent