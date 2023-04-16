Feature: Product

  Scenario: [POS] GET - Check GET All Products API
    Given I set "GET" endpoints
    When I send GET HTTP request
    Then I receive valid HTTP response code "200"
    And I receive array type for the retrieved data
    And I receive the correct attributes for object within array

  Scenario: [NEG] GET - Check GET All Products API
    Given I set "GET" endpoints
    When I send GET HTTP request
    Then I will not receive more than 20 data

  Scenario Outline: [POS] GET - Check GET Products By ID API
    Given I set "GET" endpoints
    When I send GET By ID HTTP request given valid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive object type for the retrieved data
    And I receive the correct attributes and ID: "<id>" for the object
    Examples:
      | id |
      | 1  |
      | 20 |

  Scenario Outline: [NEG] GET - Check GET Products By ID API
    Given I set "GET" endpoints
    When I send GET By ID HTTP request given invalid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive null value as response
    Examples:
      | id |
      | 21 |
      | 100|

  Scenario Outline: [POS] GET - Check GET Products With Limit API
    Given I set "GET" endpoints
    When I send GET with limit HTTP request with limit as "<limit>"
    Then I receive valid HTTP response code "200"
    And I receive array type for the retrieved data with length matching limit value of "<limit>"
    And I receive the correct attributes for object within array
    Examples:
      | limit |
      | 5     |
      | 2     |

  Scenario Outline: [NEG] GET - Check GET Products With Limit API
    Given I set "GET" endpoints
    When I send GET with limit HTTP request with limit as "<limit>"
    Then I receive valid HTTP response code "200"
    And I receive fallback array size of "20"
    Examples:
      | limit |
      | 21    |
      | dua   |
      | 0     |


  Scenario: [POS] GET - Check GET Products With Sort API Desc
    Given I set "GET" endpoints
    When I send GET with sort HTTP request with sort as "desc"
    Then I receive valid HTTP response code "200"
    Then I receive array with product sorted based on ID with descending order

  Scenario: [POS] GET - Check GET Products With Sort API Asc
    Given I set "GET" endpoints
    When I send GET with sort HTTP request with sort as "asc"
    Then I receive valid HTTP response code "200"
    Then I receive array with product sorted based on ID with ascending order

  Scenario Outline: [NEG] GET - Check GET Products With Sort API
    Given I set "GET" endpoints
    When I send GET with sort HTTP request with sort as "<invalidSort>"
    Then I receive valid HTTP response code "200"
    And I receive array with product sorted based on ID with ascending order
    Examples:
    | invalidSort |
    | test        |
    | descasc     |

  Scenario: [POS] GET - Check GET Product Categories API
    Given I set "GET" endpoints
    When I send GET product categories HTTP request
    Then I receive valid HTTP response code "200"
    And I receive array of strings for all categories exist on all product data

  Scenario Outline: [POS] GET - Check GET Products With Categories API
    Given I set "GET" endpoints
    When I send GET based on category HTTP request with category as "<category>"
    Then I receive valid HTTP response code "200"
    And I receive array with product with category equals to the provided "<category>" input
    Examples:
    | category    |
    | jewelery    |
    | electronics |

  Scenario Outline: [NEG] GET - Check GET Products With Categories API
    Given I set "GET" endpoints
    When I send GET based on category HTTP request with category as "<category>"
    Then I receive valid HTTP response code "200"
    And I receive empty array value as response
    Examples:
      | category    |
      | notExisting |
      | car         |

  Scenario Outline: [POS] Post - Check POST Products API
    Given I set "POST" endpoints
    When I send POST product HTTP request with data as: "<title>", "<price>", "<description>", "<image>", "<category>"
    Then I receive valid HTTP response code "200"
    And I receive response matching with the given input: "<title>", "<price>", "<description>", "<image>", "<category>"
    And I will see new ID created as "21"
    Examples:
    | title                       | price| description           | image                 | category   |
    | test product                | 13.5 | this is a description | https://i.pravatar.cc | electronic |
    | test another 123 product    | 2000 | this is a description | https://i.pravatar.cc | jewelery   |

  Scenario Outline: [NEG] Post - Check POST Products API Added Atribute
    Given I set "POST" endpoints
    When I send POST product HTTP request with data added with id as: "<title>", "<price>", "<description>", "<image>", "<category>", "<id>"
    Then I receive valid HTTP response code "200"
    And I will see new ID created as "21"
    Examples:
      | title                       | price| description           | image                 | category   | id  |
      | test product                | 13.5 | this is a description | https://i.pravatar.cc | electronic | 1   |
      | test another 123 product    | 2000 | this is a description | https://i.pravatar.cc | jewelery   | 15  |

  Scenario Outline: [NEG] Post - Check POST Products API Mismatch Type
    Given I set "POST" endpoints
    When I send POST product HTTP request with mismatch attribute type as: "<title>", "<price>", "<description>", "<image>", "<category>"
    Then I receive valid HTTP response code "200"
    And I will see new ID created as "21"
    Examples:
      | title                       | price| description           | image                 | category   |
      | 1                           | harga| 1                     | https://i.pravatar.cc | electronic |
      | 2                           | test | 3                     | https://i.pravatar.cc | jewelery   |


  Scenario Outline: [NEG] Post - Check POST Products API Missing Attribute
    Given I set "POST" endpoints
    When I send POST product HTTP request with missing attribute as: "<title>", "<price>"
    Then I receive valid HTTP response code "200"
    And I will see new ID created as "21"
    Examples:
      | title                       | price|
      | test product                | 13.5 |
      | test another 123 product    | 2000 |


  Scenario: [NEG] Post - Check POST Products API Empty Body
    Given I set "POST" endpoints
    When I send POST product HTTP request with empty body
    Then I receive valid HTTP response code "200"
    And I will see new ID created as "21"

  Scenario Outline: [POS] Put - Check PUT Products API
    Given I set "Put" endpoints
    When I send PUT product HTTP request with valid ID as "<id>" and data as: "<title>", "<price>", "<description>", "<image>", "<category>"
    Then I receive valid HTTP response code "200"
    And I receive response matching with the given input: "<title>", "<price>", "<description>", "<image>", "<category>"
    And I will see new ID created as "<id>"
    Examples:
      | title                       | price| description           | image                 | category   | id   |
      | test product                | 13.5 | this is a description | https://i.pravatar.cc | electronic | 1    |
      | test another 123 product    | 2000 | this is a description | https://i.pravatar.cc | jewelery   | 11   |

  Scenario Outline: [NEG] Put - Check PUT Products API
    Given I set "Put" endpoints
    When I send PUT product HTTP request with invalid ID as "<id>" and data as: "<title>", "<price>", "<description>", "<image>", "<category>"
    Then I receive valid HTTP response code "200"
    And I receive response matching with the given input: "<title>", "<price>", "<description>", "<image>", "<category>"
    And I will see new ID created as "<id>"
    Examples:
      | title                       | price| description           | image                 | category   | id     |
      | test product                | 13.5 | this is a description | https://i.pravatar.cc | electronic | 111    |
      | test another 123 product    | 2000 | this is a description | https://i.pravatar.cc | jewelery   | 150    |

  Scenario Outline: [POS] Patch - Check Patch Products API
    Given I set "Patch" endpoints
    When I send Patch product HTTP request with valid ID as "<id>" and data as: "<title>", "<price>", "<description>", "<image>", "<category>"
    Then I receive valid HTTP response code "200"
    And I receive response matching with the given input: "<title>", "<price>", "<description>", "<image>", "<category>"
    And I will see new ID created as "<id>"
    Examples:
      | title                       | price| description           | image                 | category   | id   |
      | test product                | 13.5 | this is a description | https://i.pravatar.cc | electronic | 1    |
      | test another 123 product    | 2000 | this is a description | https://i.pravatar.cc | jewelery   | 11   |

  Scenario Outline: [NEG] Patch - Check Patch Products API
    Given I set "Patch" endpoints
    When I send Patch product HTTP request with invalid ID as "<id>" and data as: "<title>", "<price>", "<description>", "<image>", "<category>"
    Then I receive valid HTTP response code "200"
    And I receive response matching with the given input: "<title>", "<price>", "<description>", "<image>", "<category>"
    And I will see new ID created as "<id>"
    Examples:
      | title                       | price| description           | image                 | category   | id   |
      | test product                | 13.5 | this is a description | https://i.pravatar.cc | electronic | 11   |
      | test another 123 product    | 2000 | this is a description | https://i.pravatar.cc | jewelery   | 150  |

  Scenario Outline: [POS] DELETE - Check DELETE Products By ID API
    Given I set "DELETE" endpoints
    When I send DELETE By ID HTTP request given valid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I receive object type for the retrieved data
    And I receive the correct attributes and ID: "<id>" for the object
    Examples:
      | id |
      | 1  |
      | 20 |

  Scenario Outline: [NEG] DELETE - Check DELETE Products By ID API
    Given I set "DELETE" endpoints
    When I send DELETE By ID HTTP request given invalid ID as "<id>"
    Then I receive valid HTTP response code "200"
    And I received null value as response
    Examples:
      | id |
      | 21 |
      | 100|







