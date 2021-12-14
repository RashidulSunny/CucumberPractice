Feature: Mortgage calculator


  @CalculateApr_test
  Scenario: Calculate real APR Rate
    Given user is in mortgage calculator home page
    And user navigate to Real Apr page
    When user click on Calculate button upon entering the data
      | HomePrice | DownPayment | InterestRate |
      | 200000    | 15000       | 3            |
    Then the Real Apr is "3.130%"