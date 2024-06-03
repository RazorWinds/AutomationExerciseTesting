Feature: As a customer, I want to be able to navigate to certain product categories so that I can find a specific kind of product.
  Scenario: Navigate to a product category
    Given I'm on the home page
    When I click on a product category "WOMEN" link, and then the "DRESS" link in the navigation menu
    Then I should be directed to the "Women's Dresses" category page
    And The heading above the products should say "WOMEN - DRESS PRODUCTS"

  Scenario: Navigate to cart
    Given I'm on the home page
    When I click on the Cart link in the nav menu
    Then I should be redirected to the cart page
    And the cart page should be displayed showing any items in the cart

  Scenario: Navigate to contact page.
    Given I'm on the home page
    When I click on the "Contact us" link in the navigation menu
    Then I should be redirected to the contact page
    And the contact form should be displayed

  Scenario: Can go back to home page from other pages.
    Given I am on any page of the website
    When I click on the "Home" link in the navigation menu
    Then I should be redirected to the home page

  Scenario: Cannot navigate to categories that do not exist.
    Given I'm on the home page
    When the user manually enters a non-existent category URL in the browser
    Then I should be redirected to the home page