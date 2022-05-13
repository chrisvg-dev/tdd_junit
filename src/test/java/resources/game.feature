Feature: Game Rock, Paper, or Scissors

  Scenario: The user wins when chooses Rock and computer chooses Scissors
    Given the user will choose "rock"
    And the computter will choose "scissors"
    When they play
    Then verify that the computer chose "scissors"
    Then the user wins

  Scenario: The user wins when chooses Scissors and computer chooses Paper
    Given the user will choose "scissors"
    And the computter will choose "paper"
    When they play
    Then verify that the computer chose "paper"
    Then the user wins

  Scenario: The user wins when chooses Paper and computer chooses Rock
    Given the user will choose "paper"
    And the computter will choose "rock"
    When they play
    Then verify that the computer chose "rock"
    Then the user wins

  Scenario: The user lose when chooses Rock and computer chooses Paper
    Given the user will choose "rock"
    And the computter will choose "paper"
    When they play
    Then verify that the computer chose "paper"
    Then the user lose

  Scenario: The user tie when chooses Rock and computer chooses Rock
    Given the user will choose "rock"
    And the computter will choose "rock"
    When they play
    Then verify that the computer chose "rock"
    Then the user tie