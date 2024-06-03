Feature: As a customer I should be able to checkout with valid basket and card details so that I can place orders.
  Scenario: As a customer, I should be able to checkout with 1 item in my basket, so that I can buy a single item if I want to.
    Given I have 1 item in their basket
      And I am on the basket page
    When I click the Proceed to Checkout button
    Then I should be redirected to the checkout page where I can see product details.


  Scenario: As a customer, I should not be able to checkout with no items in my basket.
    Given I have 0 items in my basket
    When I am on the basket page
    Then The checkout button should not be displayed.
      And Some text should appear stating There is nothing in your basket
      And There should be a link to direct back to the products page


  Scenario: As a customer, I should be able to checkout with valid card information and see conformation so I know that the order was placed.
    Given I have clicked place order on the checkout page
    When I enter va lid card details
      And click the Pay and confirm button
    Then Text should appear saying ORDER PLACED!
      And A button to continue shopping should appear


    Scenario: As a customer I should not be able to pay with invalid card information.
    Given I have clicked place order on the checkout page
    When I enter invalid card details
      And click the Pay and confirm button
    Then An order should not be placed
      And An error prompting to try again should be shown.