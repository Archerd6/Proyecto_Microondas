Feature: TestGlobal

   Scenario Outline: Suma
    Given I have a Calculator
    When I sum <a> and <b>
    Then the result is <value>

    Examples: 
         | a |  b  |  value  |
         | 5 |  1  |    6    |
         |123|  9  |   132   |
         |876| 557 |   1433  |
         | 2 | 5543|   5545  |


   Scenario: Resta
    Given I have a Calculator
    When I substract 88 value 8
    Then the result is 80
    
   Scenario: Multiplicacion
    Given I have a Calculator
    When I multiply 88 value 8
    Then the result is 704
    
   Scenario: Division
    Given I have a Calculator
    When I divide 88 value 8
    Then the result is 11
   
   Scenario: Factorial
    Given I have a Calculator
    When I select the factorial of 3
    Then the result is 6
    
   Scenario: Primo
    Given I have a Calculator
    When I ask if 7542 is prime
    Then the result boolean as int is 0