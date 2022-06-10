Feature: Testing fourth State
    
  Scenario: Cook
    Given Testing fourth State
    When Set power to 10
    And We settle timer at 90 s
    And Press start cooking
    Then We are in the fifth State
    
  Scenario Outline: Setting power
    Given Testing fourth State
    When Set power to <T>
    Then Screen value is "<D>"

    Examples: 
      |  T  |  D  |
      |  10 | 100 |
      |   0 |   0 |
      |  -1 |   0 |

  Scenario Outline: Setting timer
    Given Testing fourth State
    When We settle timer at <S> s
    Then Screen value is "<D>"

    Examples: 
      |  S  |  D  |
      |  88 |  88 |
      |   0 |   0 |
      |-888 |   0 |