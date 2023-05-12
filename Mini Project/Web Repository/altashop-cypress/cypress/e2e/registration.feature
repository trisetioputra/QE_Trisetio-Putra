Feature: Registration

#Positive case covered on E2E

 Scenario Outline: [NEGATIVE] [AUT-10] As a user i will not be able to register given missing values  
    Given I open altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter invalid datas: full name as <full name>, password as <password>, and email as <email>
    And I press register button
    Then I will see warning icon
    Examples:
    | full name      | password   | email                 |
    | empty          | testing123 | randomized email      |
    | testingman     | empty      | randomized email      |
    | testingman     | testing123 | empty                 |

  Scenario: [NEGATIVE] [AUT-11] As a user i will not be able to register given already registered email  
    Given I open altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter invalid datas: full name as testing, password as testing123, and email as testing@gmail.com
    And I press register button
    Then I will see warning icon

