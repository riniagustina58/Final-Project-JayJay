@category
Feature: Product

  @web @category-phone
  Scenario: show category phone product
    Given user open homepage product
    When user click category phone
    And show category phone product "Samsung galaxy s6"
    And  user click one product
    Then show detail product "Samsung galaxy s6"


  @web @category-laptops
  Scenario: show category laptops product
    Given user open homepage product
    When user click category laptops
    And show category laptops product "Sony vaio i5"
    And  user click one product laptops
    Then show detail product "Sony vaio i5"


  @web @category-monitor
  Scenario: show category monitor product
    Given user open homepage product
    When user click category monitor
    And show category monitor product "Apple monitor 24"
    And  user click one product monitor
    Then show detail product "Apple monitor 24"