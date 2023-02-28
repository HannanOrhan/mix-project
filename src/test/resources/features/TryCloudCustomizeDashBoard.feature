@tryCloud @regression
Feature: TryCloud application customizing the dashboard
  Agile story: As a user, I should be able to customize the Dashboard.

  Background:
    Given user on the login page and enter valid credentials

  Scenario: Go to home page, click “customize” button and see nine clickable widgets on the dashboard
    When user on the home page
    And user should be click on the “customize” button
    Then verify you see the nine clickable widgets

  Scenario: User can check nine widgets options on the dashboard
    When user on the home page
    And user should be click on the “customize” button
    Then verify user can click the nine clickable widgets
