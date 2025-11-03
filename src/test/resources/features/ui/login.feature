@login
Feature: Login

  @web @valid-login
  Scenario: Login with valid username and password
    Given user open homepage
    When user click login menu
    And user is on login dialog
    And  user input username text box with "tia231"
    And user input password pada text box with "123456"
    And user click login button
    Then user is on homepage "tia231"


  @web @invalid-login-wrong-password
  Scenario: Login with valid username and password
    Given user open homepage
    When user click login menu
    And user is on login dialog
    And  user input username text box with "tia231"
    And user input password pada text box with "51515151"
    And user click login button
    Then show alert wrong password "Wrong password."

  @web @invalid-login-user-does-not-exist
  Scenario: Login with valid username and password
    Given user open homepage
    When user click login menu
    And user is on login dialog
    And  user input username text box with "mira587"
    And user input password pada text box with "51515151"
    And user click login button
    Then show alert user does not exist "User does not exist."

