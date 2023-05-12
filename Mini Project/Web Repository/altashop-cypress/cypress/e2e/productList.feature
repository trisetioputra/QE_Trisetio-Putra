Feature: Product List

  Scenario: [POSITIVE] [AUT-1] As a user i want to see all products cards in a list format
    Given I open altashop homepage
    Then I will see multiple product cards
    When I check at the first product card
    Then I will see product title, price, and description
