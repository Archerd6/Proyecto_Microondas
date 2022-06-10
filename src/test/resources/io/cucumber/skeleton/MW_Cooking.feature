Feature: Testing fifth State

  Scenario: Cook correctly
    Given Testing fourth State
    When Increase the power 10 times
    And We settle timer at 60 s
    And Press start cooking
    Then We are in the fifth State
    And Heating heats
    And Lamp turns on
    And Turntable turns
    
  Scenario: Testing change while runing 1
    Given  A running microwave with 2000 power and 60 timer
    When Increase the power 1 times
    Then Screen value is "2010"

  Scenario: Testing change while runing 2
    Given  A running microwave with 800 power and 1 timer
    When We settle timer at 2 s
    Then Screen value is "2"

  Scenario: Testing change while runing 3
    Given  A running microwave with 800 power and 2 timer
    When We settle timer at 1 s
    Then Screen value is "1"

  Scenario Outline: Testing Display
    Given Testing fourth State
    When We settle timer at <S> s
    And Increase the power <T> times
    Then Screen value is "<D>"

    Examples: 
      |  S  | T  |  D  |
      | 15  | 63 | 630 |
      | 30  | 75 | 750 |
      | 100 | 89 | 890 |