@api-delete-user
Feature: API Delete User

  @api @delete-user
  Scenario: API delete User By Id
    Given insert end point to create delete user "https://dummyapi.io/data/v1/user/create"
    And create user with first name "Rini" and last name "Agustina" and email "rini_agustina123@gmail.com"
    And send request create delete user
    And response code create delete user 200
    And insert end point to delete user "https://dummyapi.io/data/v1/user"
    And send request delete user
    Then response code delete user 200



  @api @delete-user-already-delete
  Scenario: API delete User By Id but already delete
    Given insert end point to create delete user "https://dummyapi.io/data/v1/user/create"
    And create user with first name "Rini" and last name "Agustina" and email "rini_agustina123@gmail.com"
    And send request create delete user
    And response code create delete user 200
    And insert end point to delete user "https://dummyapi.io/data/v1/user"
    And send request delete user
    And send request delete user again
    And response code delete user 404
    Then response message "RESOURCE_NOT_FOUND"


  @api @delete-user-by-invalid-id
  Scenario: API delete User By invalid Id
    Given insert end point to create delete user "https://dummyapi.io/data/v1/user"
    And insert delete user id "6906d40e0d21c61fc2887ecbxx"
    And send request delete user
    And response code delete user 400
    Then response message "PARAMS_NOT_VALID"