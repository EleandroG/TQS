Feature: Search in BlazeDemo
 
  Scenario: Seek for flights available
    When I navigate to "https://blazedemo.com/"
    And I press Find Flights
    Then I should be shown results including "Flights"