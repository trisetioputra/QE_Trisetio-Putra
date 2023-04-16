Feature: Cart

  Scenario: [POS] GET - Check GET All Carts API
    Given I set "GET" endpoints
    When I send GET Carts HTTP request
    Then I receive valid HTTP response code "200"
    And I receive array type for the retrieved cart data
    And I receive the correct attributes for object within array for carts

  Scenario: [NEG] GET - Check GET All Carts API
    Given I set "GET" endpoints
    When I send GET Carts HTTP request
    Then I will not receive more than 7 cart data

  Scenario Outline: [POS] GET - Check GET Carts By ID API
    Given I set "GET" endpoints
    When I send GET Carts By ID HTTP request given valid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive object type for the retrieved cart data
    And I receive the correct attributes and ID: "<id>" for the cart object
    Examples:
      | id |
      | 1  |
      | 5  |

  Scenario Outline: [NEG] GET - Check GET Carts By ID API
    Given I set "GET" endpoints
    When I send GET Carts By ID HTTP request given invalid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive null value as response on cart
    Examples:
      | id |
      | 21 |
      | 100|

  Scenario: [POS] GET - Check GET Carts With Sort API Desc
    Given I set "GET" endpoints
    When I send GET Carts with sort HTTP request with sort as "desc"
    Then I receive valid HTTP response code "200"
    Then I receive array with Carts sorted based on ID with descending order

  Scenario: [POS] GET - Check GET Carts With Sort API Asc
    Given I set "GET" endpoints
    When I send GET Carts with sort HTTP request with sort as "asc"
    Then I receive valid HTTP response code "200"
    Then I receive array with Carts sorted based on ID with ascending order

  Scenario Outline: [NEG] GET - Check GET Carts With Sort API
    Given I set "GET" endpoints
    When I send GET with sort HTTP request with sort as "<invalidSort>"
    Then I receive valid HTTP response code "200"
    And I receive array with Carts sorted based on ID with ascending order
    Examples:
    | invalidSort |
    | test        |
    | descasc     |

  Scenario Outline: [POS] GET - Check GET Carts With Limit API
    Given I set "GET" endpoints
    When I send GET Carts with limit HTTP request with limit as "<limit>"
    Then I receive valid HTTP response code "200"
    And I receive cart array type for the retrieved data with length matching limit value of "<limit>"
    And I receive the correct attributes for object within array for carts
    Examples:
      | limit |
      | 5     |
      | 2     |

  Scenario Outline: [NEG] GET - Check GET Carts With Limit API
    Given I set "GET" endpoints
    When I send GET Carts with limit HTTP request with limit as "<limit>"
    Then I receive valid HTTP response code "200"
    And I receive fallback cart array size of "7"
    Examples:
      | limit |
      | 21    |
      | dua   |
      | 0     |


  Scenario Outline: [POS] GET - Check GET Carts By Date API
    Given I set "GET" endpoints
    When I send GET Carts By Date HTTP request given valid start date as "<startdate>" and end date as "<enddate>"
    Then I receive valid HTTP response code "200"
    And I receive cart array type for the retrieved data with date matching start date as "<startdate>" and end date as "<enddate>"
    Examples:
      | startdate         | enddate         |
      | 2020-03-01        | 2020-10-10      |

  Scenario Outline: [NEG] GET - Check GET Carts By Date API
    Given I set "GET" endpoints
    When I send GET Carts By Date HTTP request given invalid start date as "<startdate>" and end date as "<enddate>"
    Then I receive error HTTP response code "400"
    And I can see error message of wrong date format
    Examples:
      | startdate         | enddate         |
      | 2020-15-01        | 2020-12-41      |

# Expected to be false
  Scenario Outline: [POS] GET - Check GET Carts By User API
    Given I set "GET" endpoints
    When I send GET Carts By User HTTP request given valid userId as "<userId>"
    Then I receive valid HTTP response code "200"
    And I receive cart array type for the retrieved data with userId matching the input "<userId>"
    Examples:
      | userId     |
      | 1          |
      | 3          |

  Scenario Outline: [POS] Post - Check POST Cart API
    Given I set "POST" endpoints
    When I send POST cart HTTP request with data as: "<userId>", "<date>", "<productId>", "<quantity>"
    Then I receive valid HTTP response code "200"
    And I receive cart response matching with the given input: "<userId>", "<date>", "<productId>", "<quantity>"
    And I will see new cart ID created as "11"
    Examples:
    | userId            | date                     | productId           | quantity   |
    | 1                 | 2020-01-01T00:00:00.000Z | 1                   | 3          |
    | 3                 | 2020-01-01T00:00:00.000Z | 2                   | 2          |

  Scenario Outline: [NEG] Post - Check POST Cart API Added Atribute
    Given I set "POST" endpoints
    When I send POST cart HTTP request with added data as: "<userId>", "<date>", "<productId>", "<quantity>" and id: "<id>"
    Then I receive valid HTTP response code "200"
    And I will see new cart ID created as "11"
    Examples:
      | userId            | date                     | productId           | quantity   | id |
      | 1                 | 2020-01-01T00:00:00.000Z | 1                   | 3          | 2  |
      | 3                 | 2020-01-01T00:00:00.000Z | 2                   | 2          | 3  |


  Scenario Outline: [PUT] Post - Check PUT Cart API
    Given I set "PUT" endpoints
    When I send PUT cart HTTP request with data as: "<userId>", "<date>", "<productId>", "<quantity>" and ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive cart response matching with the given input: "<userId>", "<date>", "<productId>", "<quantity>"
    And I will see cart ID as "<id>"
    Examples:
      | userId            | date                     | productId           | quantity   | id  |
      | 1                 | 2020-01-01T00:00:00.000Z | 1                   | 3          | 1   |
      | 3                 | 2020-01-01T00:00:00.000Z | 2                   | 2          | 3   |

  Scenario Outline: [PUT] Post - Check PUT Cart API
    Given I set "PUT" endpoints
    When I send PUT cart HTTP request with data as: "<userId>", "<date>", "<productId>", "<quantity>" and invalid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive cart response matching with the given input: "<userId>", "<date>", "<productId>", "<quantity>"
    And I will see cart ID as "<id>"
    Examples:
      | userId            | date                     | productId           | quantity   | id    |
      | 1                 | 2020-01-01T00:00:00.000Z | 1                   | 3          | 111   |
      | 3                 | 2020-01-01T00:00:00.000Z | 2                   | 2          | 311   |

  Scenario Outline: [PATCH] Post - Check PATCH Cart API
    Given I set "PATCH" endpoints
    When I send PATCH cart HTTP request with data as: "<userId>", "<date>", "<productId>", "<quantity>" and ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive cart response matching with the given input: "<userId>", "<date>", "<productId>", "<quantity>"
    And I will see cart ID as "<id>"
    Examples:
      | userId            | date                     | productId           | quantity   | id  |
      | 1                 | 2020-01-01T00:00:00.000Z | 1                   | 3          | 1   |
      | 3                 | 2020-01-01T00:00:00.000Z | 2                   | 2          | 3   |

  Scenario Outline: [PATCH] Post - Check PATCH Cart API
    Given I set "PATCH" endpoints
    When I send PATCH cart HTTP request with data as: "<userId>", "<date>", "<productId>", "<quantity>" and invalid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive cart response matching with the given input: "<userId>", "<date>", "<productId>", "<quantity>"
    And I will see cart ID as "<id>"
    Examples:
      | userId            | date                     | productId           | quantity   | id    |
      | 1                 | 2020-01-01T00:00:00.000Z | 1                   | 3          | 111   |
      | 3                 | 2020-01-01T00:00:00.000Z | 2                   | 2          | 311   |

  Scenario Outline: [POS] DELETE - Check DELETE Carts By ID API
    Given I set "DELETE" endpoints
    When I send DELETE Carts By ID HTTP request given valid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive object type for the retrieved cart data
    And I receive the correct attributes and ID: "<id>" for the cart object
    Examples:
      | id |
      | 1  |
      | 5  |

  Scenario Outline: [NEG] DELETE - Check DELETE Carts By ID API
    Given I set "DELETE" endpoints
    When I send DELETE Carts By ID HTTP request given invalid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive null value as response on cart
    Examples:
      | id |
      | 21 |
      | 100|