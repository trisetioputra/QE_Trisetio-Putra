Feature: Login

  Scenario Outline: [POS] Post - Check POST Login API
    Given I set "POST" endpoints
    When I send POST login HTTP request with valid credential as email: "<email>" and password: "<password>"
    Then I receive valid HTTP response code "200"
    And I will receive Token value on response
    Examples:
    | email                          | password                  |
    | john@gmail.com                 | m38rmF$                   |
    | morrison@gmail.com             | 83r5^_                    |

  Scenario Outline: [NEG] Post - Check POST Login API
    Given I set "POST" endpoints
    When I send POST login HTTP request with invalid credential as email: "<email>" and password: "<password>"
    Then I receive valid HTTP response code "401"
    And I will receive Token value on response
    Examples:
      | email                          | password                  |
      | john@gmail.com                 | m38smF$                   |
      | morrison@gmail.com             | 83rd^_                    |