@api-update-user
Feature: API Update User

  @api @update-user
  Scenario: API update User By Id
    Given insert end point to update user "https://dummyapi.io/data/v1/user"
    And insert id "60d0fe4f5311236168a109f6"
    And insert update first name "Rini"
    And insert update last name "Agustina"
    And send request update user
    And response code update user 200
    Then user update first name = "Rini" and user last name "Agustina"


  @api @update-user-invalid-id
  Scenario: API update User By invalid Id
    Given insert end point to update user "https://dummyapi.io/data/v1/user"
    And insert id "60d0fe4f5311236168a109f6xx"
    And insert update first name "Rini"
    And insert update last name "Agustina"
    And send request update invalid user
    And response code update invalid user 400
    Then error update "PARAMS_NOT_VALID"

  @api @update-user-email
  Scenario: API update User email
    Given insert end point to update user "https://dummyapi.io/data/v1/user"
    And insert id "60d0fe4f5311236168a109f6"
    And insert update email "rini_agustina@gmail.com"
    And send request update email
    And response code update invalid user 200
    Then email should be not updated "rini_agustina@gmail.com"