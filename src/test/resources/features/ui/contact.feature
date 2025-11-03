@contact
Feature: Contact Us

  @web @contact-us
  Scenario: show Information Contact website
    Given user open homepage contact
    When user click contact menu
    And user is on contct dialog
    And validate dialog contact "New message"
    And user insert email "riniagustina@gmail.com"
    And user insert contact name "rini"
    And user insert message "ini adalah pesan"
    And user click send
    Then message already send, show alert "Thanks for the message!!"
