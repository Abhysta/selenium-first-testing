Feature:
  @PositiveRegister
  Scenario: Success Register ParaBank
    Given User is in parabank homepage
    When User click register button
    Then User is in register page
    When User input name
    And User input detail address
    And User fill valid username and password
    And User input confirm password
    When User click registered button
    Then User already registered

  @NegativeRegister
  Scenario: Failed Register ParaBank
    Given User is in parabank homepage
    When User click register button
    Then User is in register page
    When User input name
    And User input detail address
    And User fill valid username and password
    And User input invalid confirm password
    When User click registered button
    Then User get error password message