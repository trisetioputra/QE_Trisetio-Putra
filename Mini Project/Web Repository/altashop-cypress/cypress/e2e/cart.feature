Feature: Cart

  Scenario: [POSITIVE] [AUT-4] As a user i want to be able to add multiple products to cart 
    Given I open altashop homepage
    When I press buy button on multiple product cards
    Then I will see increasing value on cart icon counter
    When I click at cart icon
    Then I will see the matching products displayed on cart
  Scenario: [NEGATIVE] [AUT-5] As a user i cannot add the same product to the cart multiple times
    Given I open altashop homepage
    When I press buy button on for the same product multiple times
    Then I will not see increasing value on cart icon counter
    When I click at cart icon
    Then I will see the quantity for the product matching the amounts of clicks
  Scenario Outline: [POSITIVE] [AUT-6] As a user i want to be able to edit product quantity on cart page 
    Given I open altashop homepage
    When I press buy button on sample product cards
    And I click at cart icon
    And I click at <type> quantity icon for <clickTimes> times
    Then I will see the item quantity changed according with the click times <clickTimes> and type <type>
    And I will see total price and total quantity also edited
    Examples:
        | type                   | clickTimes |
        | increase               | 5          |
        | increase and decrease  | 4          |
  Scenario: [POSITIVE] [AUT-7] As a user i can remove the product from cart if quantity is zero and less
    Given I open altashop homepage
    When I press buy button on sample product cards
    And I click at cart icon
    And I click at "reduce" quantity icon for "1" times
    Then I will see order is empty message
  Scenario: [NEGATIVE] [AUT-8] As a non-login user i will not be able to proceed to payment page 
    Given I open altashop homepage
    When I press buy button on sample product cards
    And I click at cart icon
    And I press pay button
    Then I will be directed to login page


