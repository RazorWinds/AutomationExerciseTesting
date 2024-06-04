Feature: As a shopper, I want to view information about an item, so that I can decide whether I want to buy it
  Scenario: User wants to view a specific item details

    Given I am browsing items
    When I click on view product
    Then I am taken to the details page

  Scenario: Details page displays the relevant information

    Given I am browsing items
    When I click on view product
    Then I see the item image, name, availability, condition, brand, and price.

  Scenario: User can add the item to their cart from the details page

    Given I am browsing items
    When I click on view product
    And I click the add to cart button
    Then the product is added to my cart, and I see a confirmation message