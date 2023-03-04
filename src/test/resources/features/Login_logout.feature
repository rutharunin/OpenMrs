<<<<<<< HEAD
Feature: As an admin, user should be able to login and logout
Given User navigates to the wabpage and user validates the url
=======
<<<<<<< HEAD
 Feature: As an admin, user should be able to login and logout
=======
Feature: User can login
Given User navigates to the wabpage and user validates the url
>>>>>>> 2929f876539455da5b0c63221a922b91dbe8a7de
>>>>>>> main
  Background:
  Scenario Outline: Happy Path Login
    When User enters valid username and valid password
    And User chooses location '<location>'
    And User clicks the login button
    Then User validates the header contains text '<user>'
<<<<<<< HEAD
    And User validates the header contains text '<location>'
=======
<<<<<<< HEAD
    And User validates the header contains text '<location>'
=======
    And User validates the header contains word '<location>'
>>>>>>> 2929f876539455da5b0c63221a922b91dbe8a7de
>>>>>>> main
    And User clicks logout
    Examples:
      | location          | user  |
      | Inpatient Ward    | admin |
      | Isolation Ward    | admin |
      | Laboratory        | admin |
      | Outpatient Clinic | admin |
      | Pharmacy          | admin |
      | Registration Desk | admin |


<<<<<<< HEAD

=======
<<<<<<< HEAD
>>>>>>> main
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

<<<<<<< HEAD
=======
=======
#  Scenario: User should not be able to login with valid username but invalid password
#    When User enters valid username and invalid password invalidPassword
#    And User chooses a location 'Inpatient Ward' and clicks the login button
#    Then User validates the error message 'Invalid username/password. Please try again.'
>>>>>>> 2929f876539455da5b0c63221a922b91dbe8a7de

>>>>>>> main
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

