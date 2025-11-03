@chart
Feature: checkout product

  @web @chart-checkout
  Scenario: process an product until success checkout
    Given user open homepage for checkout
    When user click category phone for checkout
    And  show category phone product for checkout "Samsung galaxy s6"
    And  user click one product for checkout
    And show detail product for checkout "Samsung galaxy s6"
    And add to chart
    Then show Alert success "Product added"
    And user click menu chart
    When user on chart page "Samsung galaxy s6";
    And User click place order
    And User On Checkout dialog "Place order"


