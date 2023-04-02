Feature: Post

  Scenario: [POS] Get - As admin I have be able to get all post in list
    Given I set "GET" endpoints
    When I send GET HTTP request
    Then I receive valid HTTP response code "200"
    And I receive array type for the retrieved data
    And I receive valid data type for sample post data

  Scenario Outline: [POS] Get - As admin I want to be able to retrieve post data given valid Id
    Given I set "GET" endpoints
    When I send GET HTTP request based on "<ID>"
    Then I receive valid HTTP response code "200"
    And I receive data based on matching with "<ID>"
    And I receive valid data type for post data response
    Examples:
      | ID  |
      | 1   |
      | 100 |

  Scenario Outline: [NEG] Get - As admin I will not be able to retrieve post data given invalid Id
    Given I set "GET" endpoints
    When I send GET HTTP request based on "<ID>"
    Then I receive valid HTTP response code "404"
    And I receive empty response body
    Examples:
      | ID   |
      | 0    |
      | 9999 |
      | satu |

  Scenario Outline: [POS] Post - As admin I want to be able to send the correct post data
    Given I set "POST" endpoints
    When I send POST HTTP request given valid <userId>, "<title>", and "<body>"
    Then I receive valid HTTP response code "201"
    And I receive response based on matching the sent <userId>, "<title>", and "<body>"
    Examples:
      | userId | title     | body         |
      | 1      | Hello     | Test         |
      | 100    | Just test | Body test    |
      | 100    |           | body test    |
      | 81     | Just test |              |

  Scenario Outline: [NEG] Post - As admin I want to make sure ID created will not override old IDs
    Given I set "POST" endpoints
    When I send POST HTTP request given valid <id>, <userId>, "<title>", and "<body>"
    Then I receive valid HTTP response code "201"
    And I will see id with different values than <id>
    Examples:
      | id | userId | title     | body         |
      | 5  | 1      | Hello     | Test         |

  Scenario Outline: [POS] Put - As admin I want to be able to update the correct data
    Given I set "PUT" endpoints
    When I send PUT HTTP request given valid <id>, <userId>, "<title>", and "<body>"
    Then I receive valid HTTP response code "200"
    And I receive response based on matching the sent <id>, <userId>, "<title>", and "<body>"
    Examples:
      | id | userId | title     | body         |
      | 5  | 1      | Hello     | Test         |
      | 100| 1      | Just test |              |

  Scenario Outline: [NEG] Put - As admin I wil not be able to update data when providing invalid ID
    Given I set "PUT" endpoints
    When I send PUT HTTP request given invalid <id> and valid <userId>, "<title>", and "<body>"
    Then I receive valid HTTP response code "500"
    Examples:
      | id    | userId | title     | body         |
      | 0     | 1      | Hello     | Test         |
      | 9999  | 1      | Just test |              |

  Scenario Outline: [POS] DELETE - As admin I want to be able to delete the correct data
    Given I set "DELETE" endpoints
    When I send DELETE HTTP request based on "<ID>"
    Then I receive valid HTTP response code "200"
    And I receive empty response body
    Examples:
      | ID   |
      | 1    |
      | 100  |