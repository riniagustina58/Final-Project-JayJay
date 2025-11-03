@about
Feature: About Us

  @web @about-us
  Scenario: show Information About website
    Given user open homepage about
    When user click about menu
    And user is on about dialog
    Then validate dialog "About us"
