Feature: Search in BlazeDemo

  Scenario: Seek for flights available
    When I navigate to "https://blazedemo.com/"
    And I press Find Flights
    And I press Enter
    Then I should be shown results including "Flights from Paris to Buenos Aires"