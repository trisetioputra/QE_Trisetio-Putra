Feature: Registration

  Scenario Outline: [POSITIVE] [AUT-3] As a new user i want to be able to successfully register
    Given I am on altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter "valid" full name as "<full name>", password as "<password>", and email as: "<email>"
    And I press register button
    Then I will be directed to home page
    Examples:
      | full name | password   | email              |
      | Testing   | Testing123 | randomized email   |

  Scenario: [NEGATIVE] [AUT-4] As a user i will not be able to register given missing values
    Given I am on altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter "invalid" full name as "empty", password as "testing123", and email as: "randomized email"
    And I press register button
    Then I will see warning message for "fullname"

  Scenario: [NEGATIVE] [AUT-5] As a user i will not be able to register given missing values
    Given I am on altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter "invalid" full name as "testingman", password as "testing123", and email as: "empty"
    And I press register button
    Then I will see warning message for "email"

  Scenario: [NEGATIVE] [AUT-6] As a user i will not be able to register given missing values
    Given I am on altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter "invalid" full name as "testingman", password as "empty", and email as: "randomized email"
    And I press register button
    Then I will see warning message for "password"

  Scenario: [NEGATIVE] [AUT-7] As a user i will not be able to register given already registered email
    Given I am on altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter "invalid" full name as "testingman", password as "testing123", and email as: "testing@gmail.com"
    And I press register button
    Then I will stay on registration page
