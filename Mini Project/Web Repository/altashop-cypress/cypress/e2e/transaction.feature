Feature: transaction page

Scenario: [POSITIVE] [AUT-16] As a user i want to be able to change pagination size and position on transaction page
    Given I open altashop homepage
    When I press login button
    And I enter valid credentials on form: testingdev@gmail.com and testing123
    And I press login submit button
    Then I will be directed to homepage with user permission
    When I press transaction option
    Then I will see the item shown as 10 item per page
    And I change rows per page shown to: 5
    Then I will see the item shown as 5 item per page
    And I can see the data start from count: 1
    When I press right arrow
    Then I can see the data start from count: 6
    When I press left arrow
    Then I can see the data start from count: 1
