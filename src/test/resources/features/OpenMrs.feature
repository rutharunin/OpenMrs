Feature: As an admin, user should be able to login
  Background:
    Given User navigates to the wabpage and user validates the 'title'
  Scenario Outline: Happy Path Login
    When User enters valid username and valid password
    And User chooses location '<location>'
    And User clicks the login button
    Then User validates the header contains text '<user>'
    And User validates the header contains text '<location>'
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
  Scenario: User should not be able to login with valid both username and password but no location

    This is version 6

