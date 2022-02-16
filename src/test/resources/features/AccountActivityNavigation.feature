@regression
Feature: Navigating to specific accounts in Accounts Activity


  Scenario Outline: <link> account redirect
    Given the user is logged in
    When the user navigates to "Online Banking" tab
    And the user navigates to "Account Summary" module
    And the user clicks on "<link>" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "<link>" selected

    Examples:
      | link        |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |