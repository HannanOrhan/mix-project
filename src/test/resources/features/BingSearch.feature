@bing @smoke
Feature: Bing search functionality
  Agile story: As a user, when I am on the Bing search page
  I should be able to search and see relevant results

  Scenario: Search page default title verification
    When user is on the Bing search page
    Then user should see title is Bing


  Scenario: Search result title verification
    Given user is on the Bing search page
    When user searches for orange
    Then user should see orange in the title


  Scenario: Search result title verification
    Given user is on the Bing search page
    When user searches for "orange"
    Then user should see "orange" in the title
