@api-crate-user
Feature: API Create User

  @api @create-user
  Scenario: API create new user
    Given insert end point to create user "https://dummyapi.io/data/v1/user/create"
    And insert first name "Rini"
    And insert last name "Agustina"
    And insert email "rini_agustina???@gmail.com"
    And send request create user
    And response code create user 200
    Then user first name = "Rini" and user last name "Agustina" and have id


  @api @create-user-negative-already-register
  Scenario: API create new user duplicate
    Given insert end point to create user "https://dummyapi.io/data/v1/user/create"
    And insert first name "Rini"
    And insert last name "Agustina"
    And insert email "rini_agustina@gmail.com"
    And send request create duplicate user
    And response code create user 400
    Then error "BODY_NOT_VALID" and error body message "Email already used";