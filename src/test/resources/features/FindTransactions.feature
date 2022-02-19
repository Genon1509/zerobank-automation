@regression @parallel @wip
Feature: Find Transactions in Account Activity

  Background:
    Given the user is logged in
    When the user navigates to "Online Banking" tab
    And the user navigates to "Account Activity" module
    And the user accesses the "Find Transactions" tab


  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks Find
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks Find
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should not contain transactions dated "2012-09-01"


  Scenario: Search description
    When the user enters description "ONLINE"
    And clicks Find
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And clicks Find
    Then results table should only show descriptions containing "OFFICE"
    But results table should not show descriptions containing "ONLINE"

  @fail
#  Should fail searching is case sensitive
#  Scenario: Search description case insensitive
#    When the user enters description "ONLINE"
#    And clicks Find
#    Then results table should only show descriptions containing "ONLINE"
#    When the user enters description "online"
#    And clicks Find
#    Then results table should only show descriptions containing "ONLINE"


  Scenario: Type
    When clicks Find
    Then results table should show at least one result under Deposit
    Then results table should show at least one result under Withdrawal
    When user selects type "Deposit"
    And clicks Find
    Then results table should show at least one result under Deposit
    But results table should show no result under Withdrawal
    When user selects type "Withdrawal"
    And clicks Find
    Then results table should show at least one result under Withdrawal
    But results table should show no result under Deposit