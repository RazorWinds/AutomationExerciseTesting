Feature: Purchasing

  Scenario: As a customer, I should be able to checkout with 1 item in my basket, so that I can buy a single item if I want to.
    Given I am logged into Automation Exercises
    And I have 1 item in my basket
    And I am on the basket page
    When I click the Proceed to Checkout button
    Then I should be redirected to the checkout page where I can see product details.


  Scenario: As a customer, I should not be able to checkout with no items in my basket.
    Given I have no items in my basket
    When I am on the basket page
    Then The checkout button should not be displayed.
    And Some text should appear stating There is nothing in your basket
    And There should be a link to direct back to the products page


  Scenario: As a customer, I should be able to checkout with valid card information and see conformation so I know that the order was placed.
    Given I am logged into Automation Exercises
    And I have clicked place order on the checkout page
    When I enter valid card details
    And click the Pay and confirm button
    Then Text should appear saying ORDER PLACED!


  Scenario: As a customer I should not be able to pay with invalid card information.
    Given I am logged into Automation Exercises
    And I have clicked place order on the checkout page
    When I enter invalid card details
    And click the Pay and confirm button
    Then An error prompting to try again should be shown.