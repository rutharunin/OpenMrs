<<<<<<< HEAD
Feature: Login Functionalities
  Background:
    Given User navigates to the wabpage and user validates the 'title'
=======
Feature: User can login
Given User navigates to the wabpage and user validates the url
  Background:
>>>>>>> f9adcc906a00f5f515fc6e8e3c488dde4fbd5981
  Scenario Outline: Happy Path Login
    When User enters valid username and valid password
    And User chooses location '<location>'
    And User clicks the login button
    Then User validates the header contains text '<user>'
    And User validates the header contains word '<location>'
    And User clicks logout
    Examples:
      | location          | user  |
      | Inpatient Ward    | admin |
      | Isolation Ward    | admin |
      | Laboratory        | admin |
      | Outpatient Clinic | admin |
      | Pharmacy          | admin |
      | Registration Desk | admin |


#  Scenario: User should not be able to login with valid username but invalid password
#    When User enters valid username and invalid password invalidPassword
#    And User chooses a location 'Inpatient Ward' and clicks the login button
#    Then User validates the error message 'Invalid username/password. Please try again.'

#  Scenario: User should not be able to login with invalid username but valid password
#    When User enters invalid username 'ahmet' and valid password
#    And User chooses a location 'Inpatient Ward' and clicks the login button
#    Then User validates the error message
#
#  Scenario: User should not be able to login with invalid both username and password
#  Scenario: User should not be able to login with valid username but no password
#  Scenario: User should not be able to login with no username but valid password
#  Scenario: User should not be able to login with no both username and password
#  Scenario: User should not be able to login with valid both username and password but no location
#
#   # This is version 4

