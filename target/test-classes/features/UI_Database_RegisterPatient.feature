Feature: Two-layer User can register a patient
  Scenario: UI register patient and Database delete
#    UI TEST SECTION
    Given User navigates to the wabpage and user validates the url
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
#    DATABASE TEST SECTION
    And User validates that the patient ID in UI matches patient ID in database
    And User deletes patient ID in database and close database connection
    And User refreshes the UI page and search for the patient using patient ID
    And User validate message 'No Data Available'