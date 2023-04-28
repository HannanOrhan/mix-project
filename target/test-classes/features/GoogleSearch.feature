@google @smoke
Feature: Google search functionality
  Agile story: As a user, when I am on the Google search page
  I should be able to search and see relevant results

  Scenario: Search page default title verification
    When user is on the Google search page
    Then user should see title is Google


  Scenario: Search result title verification
    Given user is on the Google search page
    When user searches for apple
    Then user should see apple in the title

  @wip_hannan
  Scenario: Search result title verification
    Given user is on the Google search page
    When user searches for "keyword" key
    Then user should see "keyword" key in the title
