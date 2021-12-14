@login_test
Feature: Test login functionalities

  Background:
    Given user is on the login page

  @positive_test
  Scenario: Check login is successful with valid credentials

    When user enters username "Sunny" and password "12345"
    And click on login button
    Then user is navigated to home page


  @positive_test @dataDriven_test
  Scenario Outline: Check login is successful with valid credentials

    When user enters username "<username>" and password "<password>"
    And click on login button
    Then user is navigated to home page

    Examples:
      | username | password |
      | Sunny    | 12345    |
      | Razu     | 12345    |
      | Asif     | 12345    |
      | Parvez   | 12345    |

  @positive_test @dataDriven_test
    Scenario: Check login is successful using data table

      When user click on login button using entering credentials
        | username | password |
        | Sunny    | 12345    |
      Then user is navigated to home page

   @negative_test
   Scenario: Check login is unsuccessful with invalid password

     When user enters username "Sunny" and password "4444444"
     And click on login button
     Then user is failed to login

