@regression @jenkins @parallel
Feature: Add new payee under pay bills


  Scenario: Add a new payee
    Given the user is logged in
    When the user navigates to "Online Banking" tab
    And the user navigates to "Pay Bills" module
    And the user accesses the "Add New Payee" tab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed