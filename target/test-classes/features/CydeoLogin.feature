@cydeoLogin @regression
Feature: Cydeo Login Functionality
  Agile Story: As a user I should be able to login with valid credentials

  Background:
    Given user is on the Web Table login page

  @firstCydeoLogin
  Scenario: Login scenario
    When user enters correct username
    And user enters correct password
    And user clicks login button
    Then user should see URL ends with orders word
  #Expected: URL should end with “orders”
  #username: Test password: Tester

  @secondCydeoLogin
  Scenario: Login scenario
    When user enters username as "keyword" and  password as "keyword"
    And user clicks login button
    Then user should see URL ends with orders word

  @thirdCydeoLogin
  Scenario: Login scenario
    When user enters below correct credentials
      | username | Test   |
      | password | Tester |
    And user clicks login button
    Then user should see URL ends with orders word

