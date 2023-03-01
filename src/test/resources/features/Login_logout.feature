 Feature: As an admin, user should be able to login and logout
  Background:
    Given User navigates to the wabpage and user validates the 'Correct Url'
  Scenario Outline: Happy Path Login
    When User enters valid username and valid password
    And User chooses location '<location>'
    And User clicks the login button
    Then User validates the header contains text '<user>'
    And User validates the header contains text '<location>'
    And User clicks logout
    Examples:
      | location          | user  |
      | Inpatient Ward    | admin |
      | Isolation Ward    | admin |
      | Laboratory        | admin |
      | Outpatient Clinic | admin |
      | Pharmacy          | admin |
      | Registration Desk | admin |


  Scenario: User should not be able to login with valid username but invalid password
    When User enters valid username and invalid password 'blablabla'
    And User chooses a location 'Inpatient Ward '
    And User clicks the login button
    Then User validates the error message

  Scenario: User should not be able to login with invalid username but valid password
    When User enters invalid username 'ahmet' and valid password
    And User chooses a location 'Inpatient Ward '
    And User clicks the login button
    Then User validates the error message

  Scenario: User should not be able to login with invalid both username and password
  Scenario: User should not be able to login with valid username but no password
  Scenario: User should not be able to login with no username but valid password
  Scenario: User should not be able to login with no both username and password


    This is version 7

