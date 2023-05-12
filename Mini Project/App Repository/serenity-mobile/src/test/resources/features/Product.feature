Feature: Product List

  Scenario: [POSITIVE] [AUT-1] As a user i want to see all products cards in a list format
    Given I am on altashop homepage
    Then I will see multiple product cards
    When I check at the first product card
    Then I will see product title and price

  Scenario: [POSITIVE] [AUT-2] As a user i want to be able to add multiple products to cart
    Given I am on altashop homepage
    When I press buy button on multiple product cards
    Then I will see increasing value on cart icon counter