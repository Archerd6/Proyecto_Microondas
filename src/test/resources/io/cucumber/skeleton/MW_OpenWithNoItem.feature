Feature: Testing second State

  Scenario Outline: Setting power
    Given Testing second State
    When Set power to <a>
    Then Screen value is "<b>"

    Examples: 
      | a   | b   |
      |   0 |   0 |
      |   8 |  80 |

    
  Scenario Outline: Setting timer
    Given Testing second State
 		When We settle timer at <a> s
    Then Screen value is "<b>"

    Examples: 
      | a   | b   |
      |  -1 |   0 |
      |   0 |   0 |
      |  60 |  60 |