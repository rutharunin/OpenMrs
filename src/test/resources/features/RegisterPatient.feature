Feature: User can register a patient
    Given User navigates to the wabpage and user validates the url
  Background:
  Scenario: Happy Path register a patient
    When User enters valid username and valid password
    And User chooses location 'Inpatient Ward'
    And User clicks the login button
    Then User validates the header contains text 'admin'
    And User validates the header contains word 'Inpatient Ward'
    When User clicks Register a Patient and validates header contains text 'Register a patient'
    And User enters name 'bobobo' and last name 'bebebe'
    And User enters the gender
    And User enters birthdate 1, 'January', 2000
    And User enters address 2222 'Chicago AVE', 'Chicago', 'IL', 'USA',60000
    And User enters phone number '7777777777' and click confirm two times
    Then User validate the title 'OpenMRS Electronic Medical Record'
    And User clicks home button and clicks Find Patient Record
    And User validates the generated userID is displayed
    And User clicks the patient link then clicks delete, gives the reason 'test', and clicks confirm