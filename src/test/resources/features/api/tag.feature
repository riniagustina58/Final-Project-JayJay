@api-get-tag
Feature: API Get Tag

  @api @get-all-tag
  Scenario: API get All tag
    Given insert end point to get tag "https://dummyapi.io/data/v1/tag"
    And send request tag
    Then user received list tag with response 200 and total data more than 0