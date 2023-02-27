Feature: Library login feature

  User Story:
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student, admin

  Background: For all scenarios user is on the login page of the Library application
      Given user is on the login page of the application

  @regression
  Scenario: Login as Librarian
    When user enters librarian user name
    And user enters librarian password
    Then user should see the dashboard


  Scenario: Login as Student
    When user enters student user name
    And user enters student password
    Then user should see the dashboard

  Scenario: Login as admin
    When user enters admin user name
    And user enters admin password
    Then user should see the dashboard
