Feature: Details

  Scenario: [POSITIVE] [AUT-3] As a user i want to be able to navigate to product detail page 
    Given I open altashop homepage
    When I press detail button for a random product card
    Then I will see the same product detail page
    And I will see product price, rating icon for the product, and rating count