Feature: Login

  Scenario: [NEGATIVE] [AUT-8] As a user i will not be able to login given unregistered credentials
    Given I am on altashop homepage
    When I press login button on homepage
    And I enter unregistered credentials on form
    And I press login submit button
    Then I will see error message for invalid email or password

  Scenario: [NEGATIVE] [AUT-9] As a user i will not be able to login given missing values
    Given I am on altashop homepage
    When I press login button on homepage
    And I enter "invalid" input: password as "empty", and email as: "randomized email"
    And I press login submit button
    Then I will see warning message for "password" on login page

  Scenario: [NEGATIVE] [AUT-10] As a user i will not be able to login given missing values
    Given I am on altashop homepage
    When I press login button on homepage
    And I enter "invalid" input: password as "testing123", and email as: "empty"
    And I press login submit button
    Then I will see warning message for "email" on login page

  Scenario Outline: [NEGATIVE] [AUT-11] As a new user i will not be able to login given wrong password
    Given I am on altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter "valid" full name as "<full name>", password as "<password>", and email as: "<email>"
    And I press register button
    Then I will be directed to home page
    When I press login button on homepage
    And I enter "invalid" input: password as "wrong password", and email as: "previous email"
    And I press login submit button
    Then I will see error message for invalid email or password
    Examples:
      | full name | password      | email              |
      | Testing   | testing123    | randomized email   |