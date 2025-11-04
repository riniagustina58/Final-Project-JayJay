@Checkout
Feature: Checkout

  @ui @Checkout-item
  Scenario: Checkout item
    Given user open homepage for checkout
    When user click category phone for checkout
    And  show category phone product for checkout "Samsung galaxy s6"
    And  user click one product for checkout
    And show detail product for checkout "Samsung galaxy s6"
    And add to chart
    Then show Alert success "Product added"
    And user click menu chart
    And user on chart page "Samsung galaxy s6";
    And User click place order
    Then User On Checkout dialog "Place order"

