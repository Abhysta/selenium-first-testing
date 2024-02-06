@All
  Feature: Login
    @Test1 @Positive
    Scenario: Login
      Given User is in login page
      When User fill username and password
      And User click login button
      Then User verify login result

    @Test2 @Negative
    Scenario: Login
      Given User is in login page
      When User fill invalid username and password
      And User click login button
      Then User get error message