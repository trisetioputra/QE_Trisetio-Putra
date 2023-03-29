Feature: LinkedIn Home

  Scenario: As a Non-login user i want to be able to see homepage
    When I try to open linkedIn homepage
    Then I will see linkedIn homepage


  Scenario Outline: As a Non-registered user i will not be able to login on homepage
    When I try to open linkedIn homepage
    And I enters unregistered "<email>" and "<password>"
    And I press sign in button
    Then I will not be directed to homepage
    Examples:
      | email                            | password   |
      | CheckTesting123zzz@gmail.com     | Test123    |
      | HelloManTestasidjsx@gmail.com    | Testing@@1 |

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

  Scenario: As a Non-login user i want to be able to see job posting page redirection from homepage
    When I try to open linkedIn homepage
    And I select create job posting button
    Then I will be directed to job posting page

  Scenario Outline: As a Non-login user i want to be able to find content topics based on suggestion
    When I try to open linkedIn homepage
    And I press "<keyword>" topic suggestion
    Then I will be directed to topic page for the recommended "<keyword>"
    Examples:
      | keyword      |
      | Workplace    |
      | Internships  |


