@api-get-user
Feature: API Get User

  @api @get-all-user
  Scenario: API get All user
    Given insert end point to get user "https://dummyapi.io/data/v1/user"
    And send request
    Then user received list data user with response 200 and total data more than 0

  @api @get-user-by-id
  Scenario: API get user by id
    Given insert end point to get user "https://dummyapi.io/data/v1/user"
    And insert id user "60d0fe4f5311236168a109ee"
    And send request by id
    And user received list data user with response 200
    Then user first name = "Beatriz" and user last name "Gutierrez"

  @api @get-user-by-id-invalid-id
  Scenario: API get user by invalid id
    Given insert end point to get user "https://dummyapi.io/data/v1/user"
    And insert id user "60d0fe4f5311236168a109eexx"
    And send request by invalid id
    And user received list data user with response 400
    Then error "PARAMS_NOT_VALID"

