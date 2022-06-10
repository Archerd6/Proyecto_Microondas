Feature: Testing first State
    
  Scenario Outline: Setting power
    Given Testing first State
    When Set power to <T>
    Then Screen value is "<D>"

    Examples: 
      |  T  |  D  |
      |  10 | 100 |
      |   0 |   0 |
      |  -1 |   0 |

  Scenario Outline: Setting timer
    Given Testing first State
    When We settle timer at <T> s
    Then Screen value is "<D>"

    Examples: 
      |  T  |  D  |
      |-888 |   0 |
      |   0 |   0 |
      |  88 |  88 |