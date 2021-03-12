@HotelSearchFeature @Sanity
Feature: LoginFeature

  Background:
  User navigate to Blibli travel page and click on hotel tab
    Given  User is on Blibli Travel page

  @Test1
  Scenario: Verify Hotel search with different formats
    When User Clicks on hotel tab
    And User enter search name as country name, state name , hotel name
    Then Hotel should be found
