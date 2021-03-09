@HotelSearchFeature @Sanity
Feature: LoginFeature

  Background:
  User navigate to Blibli travel page and click on hotel tab
    Given  User is on Blibli Travel page
#  @Test1
#  Scenario: Verify Hotel search with hotel name
#    When User Clicks on hotel tab
#    And User enter hotel name as "Sanya Yuhuayuan Seaview Hotel"
#    Then Hotel should be found

  @Test2
  Scenario: Verify Hotel search with different formats
    When User Clicks on hotel tab
    And User enter search name as country name, state name , hotel name
    Then Hotel should be found

#  @Test3
#  Scenario: Verify Hotel search with state name
#    When User Clicks on hotel tab
#    And User enter state name as "Karnataka"
#    Then Hotel should be found
#
#  @Test4
#  Scenario: Verify Hotel search with city name
#    When User Clicks on hotel tab
#    And User enter city name as "Bangalore"
#    Then Hotel should be found
#
#  @Test5
#  Scenario: Verify Hotel search with point of location name
#    When User Clicks on hotel tab
#    And User enter location name as "Stay Inn, Ba ngalore, Bangalore, Karnataka, India"
#    Then Hotel should be found

