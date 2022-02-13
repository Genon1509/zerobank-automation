
Feature: Find Transactions in Account Activity

  @wip
  Scenario: Search date range
    Given the user is logged in
    When the user navigates to "Online Banking" tab
    And the user navigates to "Account Activity" module
    And the user accesses the "Find Transactions" tab
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks Find
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks Find
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should not contain transactions dated "2012-09-01"

