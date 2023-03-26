Feature: LinkedIn Home

  Scenario: As a Non-login user i want to be able to see homepage
    When I try to open linkedIn homepage
    Then I will see linkedIn homepage

  Scenario: As a Non-login user i want to be able to go to login page from homepage
    When I try to open linkedIn homepage
    And I press login button on header
    Then I will be directed to login page

  Scenario: As a Non-login user i want to be able to go to registration page from homepage
    When I try to open linkedIn homepage
    And I press register button for new user
    Then I will be directed to registration page

  Scenario Outline: As a Non-login user i want to be able to search popular job vacancy using recommended keyword
    When I try to open linkedIn homepage
    And I press "<keyword>" recommendation
    Then I will be directed to job search page for the recommended "<keyword>"
    Examples:
      | keyword     |
      | Engineering |
      | Finance     |


