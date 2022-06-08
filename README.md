# cucumber-calculadora-java
## David Ramírez

#### Especificación de pruebas usando Cucumber y Gherkin

#### El archivo *Test.feature* contiene todas las pruebas como distintos scenarios

- *Suma*: Contiene pruebas del método Calculadora.suma()    &nbsp; &nbsp; &nbsp;    **Escenario Outline**\
Estructura:\
   Scenario Outline: Suma\
   Given I have a Calculator\
   When I sum <a> and <b>\
   Then the result is <value>

- *Resta*: Contiene pruebas del método Calculadora.resta()    &nbsp; &nbsp; &nbsp;    **Escenario**\
Estructura:\
   Scenario: Resta\
   Given I have a Calculator\
   When I substract 88 value 8\
   Then the result is 80

- *Multiplicacion*: Contiene pruebas del método Calculadora.mult()    &nbsp; &nbsp; &nbsp;    **Escenario**\
Estructura:\
    Given I have a Calculator\
    When I multiply 88 value 8\
    Then the result is 704

- *Division*: Contiene pruebas del método Calculadora.divide()    &nbsp; &nbsp; &nbsp;    **Escenario**\
Estructura:\
    Given I have a Calculator\
    When I divide 88 value 8\
    Then the result is 11

- *Factorial*: Contiene pruebas del método Calculadora.fact()    &nbsp; &nbsp; &nbsp;    **Escenario**\
Estructura:\
    Given I have a Calculator\
    When I select the factorial of 3\
    Then the result is 6

- *Primo*: Contiene pruebas del método Calculadora.esPrimo()    &nbsp; &nbsp; &nbsp;    **Escenario**\
Estructura:\
    Given I have a Calculator\
    When I ask if 7542 is prime\
    Then the result boolean as int is 0