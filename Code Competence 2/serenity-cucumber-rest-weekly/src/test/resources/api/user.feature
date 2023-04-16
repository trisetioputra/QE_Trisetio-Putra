Feature: User

  Scenario: [POS] DELETE - Check DELETE All Users API
    Given I set "DELETE" endpoints
    When I send DELETE Users HTTP request
    Then I receive valid HTTP response code "200"
    And I receive array type for the retrieved user data
    And I receive the correct attributes for object within array for users

  Scenario: [NEG] DELETE - Check DELETE All Users API
    Given I set "DELETE" endpoints
    When I send DELETE Users HTTP request
    Then I will not receive more than 10 user data

  Scenario Outline: [POS] DELETE - Check DELETE User By ID API
    Given I set "DELETE" endpoints
    When I send DELETE Users By ID HTTP request given valid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive object type for the retrieved user data
    And I receive the correct attributes and ID: "<id>" for the user object
    Examples:
      | id |
      | 1  |
      | 5  |

  Scenario Outline: [NEG] DELETE - Check DELETE User By ID API
    Given I set "DELETE" endpoints
    When I send DELETE Users By ID HTTP request given invalid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive null value as response on user
    Examples:
      | id |
      | 21 |
      | 100|

  Scenario: [POS] DELETE - Check DELETE Users With Sort API Desc
    Given I set "DELETE" endpoints
    When I send DELETE Users with sort HTTP request with sort as "desc"
    Then I receive valid HTTP response code "200"
    Then I receive array with Users sorted based on ID with descending order

  Scenario: [POS] DELETE - Check DELETE Users With Sort API Asc
    Given I set "DELETE" endpoints
    When I send DELETE Users with sort HTTP request with sort as "asc"
    Then I receive valid HTTP response code "200"
    Then I receive array with Users sorted based on ID with ascending order

  Scenario Outline: [NEG] DELETE - Check DELETE Users With Sort API
    Given I set "DELETE" endpoints
    When I send DELETE Users with sort HTTP request with sort as "<invalidSort>"
    Then I receive valid HTTP response code "200"
    And I receive array with Users sorted based on ID with ascending order
    Examples:
      | invalidSort |
      | test        |
      | descasc     |
#
  Scenario Outline: [POS] DELETE - Check DELETE Users With Limit API
    Given I set "DELETE" endpoints
    When I send DELETE Users with limit HTTP request with limit as "<limit>"
    Then I receive valid HTTP response code "200"
    And I receive user array type for the retrieved data with length matching limit value of "<limit>"
    And I receive the correct attributes for object within array for user
    Examples:
      | limit |
      | 5     |
      | 2     |

  Scenario Outline: [NEG] DELETE - Check DELETE Users With Limit API
    Given I set "DELETE" endpoints
    When I send DELETE Users with limit HTTP request with limit as "<limit>"
    Then I receive valid HTTP response code "200"
    And I receive fallback user array size of "10"
    Examples:
      | limit |
      | 21    |
      | dua   |
      | 0     |

  # Expected to failed
  Scenario Outline: [POS] Post - Check POST Users API
    Given I set "POST" endpoints
    When I send POST user HTTP request with data as: "<email>", "<username>", "<password>", "<firstname>", "<lastname>", "<phone>", "<lat>", "<long>", "<city>", "<street>", "<number>", "<zipcode>"
    Then I receive valid HTTP response code "200"
    And I receive user response matching with the given input: "<email>", "<username>", "<password>", "<firstname>", "<lastname>", "<phone>", "<lat>", "<long>", "<city>", "<street>", "<number>", "<zipcode>"
    And I will see new user ID created as "11"
    Examples:
    | email            | username                     | password           | firstname   | lastname | phone     | lat       | long | city | street | number  | zipcode  |
    | test@gmail.com   | testname                     | pas@1234           | John        | Doe      | 081212313 | -12.21113 | 1211 | jkt  | jalanan| 0812121 | 13950    |

  Scenario Outline: [NEG] Post - Check POST Products API Added Atribute
    Given I set "POST" endpoints
    When I send POST user HTTP request with added data as:  "<email>", "<username>", "<password>", "<firstname>", "<lastname>", "<phone>", "<lat>", "<long>", "<city>", "<street>", "<number>", "<zipcode>" and id: "<id>"
    Then I receive valid HTTP response code "200"
    And I will see new user ID created as "11"
    Examples:
      | email            | username                     | password           | firstname   | lastname | phone     | lat       | long | city | street | number  | zipcode  | id |
      | test@gmail.com   | testname                     | pas@1234           | John        | Doe      | 081212313 | -12.21113 | 1211 | jkt  | jalanan| 0812121 | 13950    | 1  |

  #Expected to failed
  Scenario Outline: [POS] PUT - Check PUT Users API
    Given I set "PUT" endpoints
    When I send PUT user HTTP request with data as: "<email>", "<username>", "<password>", "<firstname>", "<lastname>", "<phone>", "<lat>", "<long>", "<city>", "<street>", "<number>", "<zipcode>" and ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I will see new user ID created as "<id>"
    Examples:
      | email            | username                     | password           | firstname   | lastname | phone     | lat       | long | city | street | number  | zipcode  | id |
      | test@gmail.com   | testname                     | pas@1234           | John        | Doe      | 081212313 | -12.21113 | 1211 | jkt  | jalanan| 0812121 | 13950    | 2  |
  # Expected to failed
  Scenario Outline: [NEG] PUT - Check PUT Products API Added Attribute
    Given I set "PUT" endpoints
    When I send PUT user HTTP request with data as: "<email>", "<username>", "<password>", "<firstname>", "<lastname>", "<phone>", "<lat>", "<long>", "<city>", "<street>", "<number>", "<zipcode>" and ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I will see new user ID created as "<id>"
    Examples:
      | email            | username                     | password           | firstname   | lastname | phone     | lat       | long | city | street | number  | zipcode  | id   |
      | test@gmail.com   | testname                     | pas@1234           | John        | Doe      | 081212313 | -12.21113 | 1211 | jkt  | jalanan| 0812121 | 13950    | 122  |

  # Expected to failed
  Scenario Outline: [POS] PATCH - Check PATCH Users API
    Given I set "PATCH" endpoints
    When I send PATCH user HTTP request with data as: "<email>", "<username>", "<password>", "<firstname>", "<lastname>", "<phone>", "<lat>", "<long>", "<city>", "<street>", "<number>", "<zipcode>" and ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I will see new user ID created as "<id>"
    Examples:
      | email            | username                     | password           | firstname   | lastname | phone     | lat       | long | city | street | number  | zipcode  | id |
      | test@gmail.com   | testname                     | pas@1234           | John        | Doe      | 081212313 | -12.21113 | 1211 | jkt  | jalanan| 0812121 | 13950    | 2  |
  # Expected to failed
  Scenario Outline: [NEG] PATCH - Check PATCH Products API Added Attribute
    Given I set "PATCH" endpoints
    When I send PATCH user HTTP request with data as: "<email>", "<username>", "<password>", "<firstname>", "<lastname>", "<phone>", "<lat>", "<long>", "<city>", "<street>", "<number>", "<zipcode>" and ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I will see new user ID created as "<id>"
    Examples:
      | email            | username                     | password           | firstname   | lastname | phone     | lat       | long | city | street | number  | zipcode  | id   |
      | test@gmail.com   | testname                     | pas@1234           | John        | Doe      | 081212313 | -12.21113 | 1211 | jkt  | jalanan| 0812121 | 13950    | 122  |


  Scenario Outline: [POS] DELETE - Check DELETE User By ID API
    Given I set "DELETE" endpoints
    When I send DELETE Users By ID HTTP request given valid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive object type for the retrieved user data
    And I receive the correct attributes and ID: "<id>" for the user object
    Examples:
      | id |
      | 1  |
      | 5  |

  Scenario Outline: [NEG] DELETE - Check DELETE User By ID API
    Given I set "DELETE" endpoints
    When I send DELETE Users By ID HTTP request given invalid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive null value as response on user
    Examples:
      | id |
      | 21 |
      | 100|