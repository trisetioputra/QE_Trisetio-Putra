Feature: Login

#Positive case covered on E2E

 Scenario: [NEGATIVE] [AUT-12] As a user i will not be able to login given unregistered credentials  
    Given I open altashop homepage
    When I press login button
    And I enter unregistered credentials on form
    And I press login submit button
    Then I will see warning icon
    And I will see error message for record not found

 Scenario Outline: [NEGATIVE] [AUT-13] As a user i will not be able to login given wrong password  
    Given I open altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter valid full name as <full name>, password as <password>, and email as: <email>
    And I press register button
    Then I will be directed to login page
    When I use different credentials on the email and password form
    And I press login submit button
    And I will see error message for email or password is invalid
    Examples:
    | full name | password   | email              |
    | Testing   | Testing123 | randomized email   |

  Scenario Outline: [NEGATIVE] [AUT-14] As a user i will not be able to login given empty attribute provided on form  
    Given I open altashop homepage
    When I press login button
    And I enter invalid credentials on form: <email> and <password>
    And I press login submit button
    Then I will see warning icon
    And I will see error message for <missing> is required
    Examples:
    | password   | email              | missing |
    | Testing123 | empty              | email   |
    | empty      | randomized email   | password|


   Scenario Outline: [POSITIVE] [AUT-15] As a user i want to be able to logout from my account  
    Given I open altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter valid full name as <full name>, password as <password>, and email as: <email>
    And I press register button
    Then I will be directed to login page
    When I use the same credentials on the email and password form
    And I press login submit button
    Then I will be directed to homepage with user permission
    When I press logout option
    Then I will be directed to login page
    Examples:
    | full name | password   | email              |
    | Testing   | Testing123 | randomized email   |


