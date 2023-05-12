Feature: Registration

 Scenario Outline: [POSITIVE] [AUT-9] As a new user i want to be able to order product on altashop  
    Given I open altashop homepage
    When I press login button
    And I press register hyperlink
    And I enter valid full name as <full name>, password as <password>, and email as: <email>
    And I press register button
    Then I will be directed to login page
    When I use the same credentials on the email and password form
    And I press login submit button
    Then I will be directed to homepage with user permission
    When I press buy button on multiple product cards
    And I click at cart icon
    And I press pay button
    Then I will be directed to transaction page
    And I will see purchased item being present on the list 
    Examples:
    | full name | password   | email              |
    | Testing   | Testing123 | randomized email   |
