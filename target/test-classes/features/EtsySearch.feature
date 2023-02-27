@etsy
Feature: Etsy search functionality
  Agile Story: User should be able to type any keyword and see relevant information

  Background:
    Given User is on the etsy homepage

  Scenario:Etsy Title Verification
    Then User should see title is as expected
    #expected title:Etsy - Shop for handmade, vintage, custom, and unique gifts for
    #everyone

  Scenario: Etsy Search Functionality Title Verification (without parameterization)
    When User types Wooden Spoon in the search box
    And  User clicks search button
    Then sees Wooden Spoon is in the title
  @etsy3
  Scenario: Etsy Search Functionality Title Verification (with parameterization)
    When User types "Wooden Spoon" in the search box
    And User clicks search button
    Then User sees "Wooden Spoon" is in the title