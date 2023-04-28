Feature: switch page using pagination
@netlify
  Scenario: verify user can switch the page with the last page and the first page
   Given user on the netlifyApp
   When user click on the next can go to the last page
   Then user return back to the first page
