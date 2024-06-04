Feature: Product searching
  Scenario: As a customer, I should be able to search for specific products so that I can locate exactly what I want.
    Given I am on the products page
    When I enter a specific product name (e.g., "blue top") into the search bar
    Then the user should be redirected to the search results page
    And the URL should be updated with the search query "blue top"
    And the products matching the search term "blue top" should be displayed

  Scenario: As a customer, I should see a message letting me know if a searched product does not exist.
    Given I am on the products page
    When I enter a specific product name (e.g., "pink top") into the search bar
    Then the user should be redirected to the search results page
    And the URL should be updated with the search query "pink top"
    And a message should be displayed indicating no products were found matching the search term "pink top"

  Scenario: User searches with an empty search query
    Given I am on the products page
    When I search an empty search term
    Then No change to the product page should take place