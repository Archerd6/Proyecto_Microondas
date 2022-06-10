Feature: Testing third State

  Scenario Outline: Setting power
    Given Testing third State
    When Set power to <a>
    Then Screen value is "<b>"

    Examples: 
      | a   | b   |
      |   1 |  10 |
      |   0 |   0 |

  Scenario Outline: Setting timer
    Given Testing third State
    When We settle timer at <a> s
    Then Screen value is "<b>"

    Examples: 
      | a   | b   |
      |  -1 |   0 |
      |   0 |   0 |
      |  60 |  60 |