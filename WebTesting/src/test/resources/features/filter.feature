Feature: Product filtering
  Scenario: As a customer, I want to filter products by gender, product category, from the home page, so that I only see products relevant to me
    Given I am on the home page
    When I click the WOMEN option in the categories menu
    And I click the DRESS option in the dropdown menu that opens
    Then I should be taken to the page for Women's dresses
    And the heading "WOMEN - DRESS PRODUCTS" should be displayed at the top of the page
    And each product shown should be in the category Women > Dress

  Scenario: As a customer, I want to filter products by gender, product category, from the products page so that I only see products relevant to me
    Given I am on the products page
    When I click the WOMEN option in the categories menu
    And I click the DRESS option in the dropdown menu that opens
    Then I should be taken to the page for Women's dresses
    And the heading "WOMEN - DRESS PRODUCTS" should be displayed at the top of the page
    And each product shown should be in the category Women > Dress

  Scenario: As a customer, I want to filter products by brand, from the products page so that I only see products relevant to me
    Given I am on the products page
    When I click the POLO option from the BRANDS menu
    Then I should be taken to the page for Polo products
    And the heading "BRAND - POLO PRODUCTS" should be displayed at the top of the page
    And each product shown should have the brand Polo
    And the number of products shown should equal the number displayed next to POLO in the BRANDS menu

  Scenario: As a customer, I want to filter products by gender, product category, and brand, from the products page so that I only see products relevant to me
    Given I am on the products page
    When I click the WOMEN option in the categories menu
    And I click the DRESS option in the dropdown menu that opens
    And I click the POLO option from the BRANDS menu
    Then each product shown should be in the category Women > Dress
    And each product shown should have the brand Polo
    And the number of products shown should equal the number displayed next to POLO in the BRANDS menu