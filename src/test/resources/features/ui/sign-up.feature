@sign-up
Feature: Sign up

  @web @valid-sign-up
  Scenario: Sign up succesfull
    Given user on the homepage
    When user click sign up menu
    And user is on login dialog sign up
    And  user input username on  text box with "rini???"
    And user input password  on text box with "123456"
    And user click sign up button
    Then show alert message sign up succesfull "Sign up successful."


  @web @valid-sign-up-user-exist
  Scenario: Sign up with existing account
    Given user on the homepage
    When user click sign up menu
    And user is on login dialog sign up
    And  user input username on  text box with "fajar11"
    And user input password  on text box with "admin123"
    And user click sign up button
    Then show alert message sign up succesfull "This user already exist."