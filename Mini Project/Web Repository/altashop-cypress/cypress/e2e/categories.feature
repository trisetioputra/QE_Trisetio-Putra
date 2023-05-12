Feature: Categories

  Scenario: [POSITIVE] [AUT-2] As a user i want to see all available product categories 
    Given I open altashop homepage
    When I press select category button
    Then I will see all available categories in a list
    When I click at one of the categories
    Then I will see the same categories on the category placeholder
    When I press remove category button
    Then I will see the category removed from the placeholder

