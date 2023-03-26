Feature: Sepulsa.com

  Scenario Outline: As a registered user i want to be able to login
    Given I open sepulsa.com login page
    When I enter credentials on "<email>" and "<password>" fields
    And I press submit button
    Then I will successfully redirect to homepage
    Examples:
      | email                 | password     |
      | avenger3350@gmail.com | Testing1234$ |

  Scenario Outline: As a non registered user i want to try login with invalid credentials
    Given I open sepulsa.com login page
    When I enter credentials on "<email>" and "<password>" fields
    And I press submit button
    Then I will see error message
    Examples:
      | email                 | password     |
      | testing@gmail.com     | Testing1234$ |
      | testing123@gmail.com  | Testsaja     |

    Scenario Outline: As a user i can select product on homepage
    Given I open sepulsa.com homepage
    When I press at "<product>" product icon
    Then I will be directed to the correct "<product>" product page
    Examples:
      | product               |
      | Pulsa                 |
      | Voucher Game          |

  Scenario Outline: As a user i want to be able to order pulsa product
    Given I open sepulsa.com homepage
    When I press at "<product>" product icon
    Then I will be directed to the correct "<product>" product page
    And I enter "<phone number>" at form field
    And I select the first pulsa package
    Then I will be directed to payment page
    When I enter valid "<email address>" at form field
    And I select payment method
    And I select Bayar Sekarang button
    Then I will be directed to finish transaction page
    Examples:
      | product | phone number | email address         |
      | Pulsa   | 081212121212 | Testing1234@gmail.com |

