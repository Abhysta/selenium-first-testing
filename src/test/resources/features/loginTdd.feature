Feature: Login TDD

  @Tdd
  Scenario Outline: Login
    Given User is in login page
    When User input <username> and <password>
    And User click login button
    Then User get verify login <result>

    Examples:
    | username | password | result |
    | standard_user | secret_sauce | Passed |
    | secret_sauce | secret_sauce | Failed |