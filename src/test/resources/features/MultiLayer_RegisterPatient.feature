Feature: Multi-layer Test Create a Person-Patient
  Background:

#    API TEST SECTION
    Given User has valid API URL to post a person
    When User sends POST request to create a person named 'Baks', lastname 'Aaabbb',gender 'M', birthdate '1997-10-02', address1 '5555 w LLLL', address2 'APT 207', cityVillage 'Heaven', stateProvince 'IL', country 'USA', postalCode '60000'
    Then Post person statue code is 201

  Scenario: Two-layer Test Create a Person: create with API validate with UI

#    UI TEST SECTION
    And User validates person name, person gender, and person age match with the request body '1997-10-02'
    And User navigates to the wabpage and user validates the url
    When User enters valid username and valid password
    And User chooses location 'Inpatient Ward'
    And User clicks the login button
    When User clicks System Administration button
    And User clicks Advanced Administration button
    And User clicks Manage Persons link
    And User enters the name 'Baks' of the person created with API in the Person Name box
    Then User validates address1 '5555 w LLLL', address2 'APT 207', city 'Heaven', state 'IL', country 'USA', zip '60000', and birthdate '1997-10-02'
    And User clicks Delete Person Forever two times and ok button one time
    And User validates 'No matching records found' in the search result
    And User clicks logout from the page

  Scenario: Two-layer Test Create a Patient: create with API validate with UI

#    API TEST SECTION
    And User validates person name, person gender, and person age match with the request body '1997-10-02'
    Given User has valid API URL to get patient ID
    When User sends GET request for patient ID
    Then Get patient ID statue code is 200
    Given User has valid API URL to get patient ID type
    When User sends GET request for Id type
    Then Get patient ID type statue code is 200
    Given User has valid API URL to get location ID
    When User sends GET request for location id
    Then Get location ID statue code is 200
    Given User has valid API URL to post a patient
    When User sends post request to create a patient with the responses information
#    Then Post patient statue code is 201
#    Then User validates the name and ID in response body match with the request body
#    UI TEST SECTION
    And User navigates to the wabpage and user validates the url
    When User enters valid username and valid password
    And User chooses location 'Inpatient Ward'
    And User clicks the login button
    And User clicks Find Patient Record
    Then User enters the name 'Baks' posted in API call and validates that it is displayed
#    And User validates the ID is the same as the one in API sent in the API request body
    And User clicks on the name on the first row and clicks delete, enters the reason 'test', and clicks confirm
    And User clicks logout

  Scenario: Three-layer Test Create a Person: create with API validate with UI and database

#    UI TEST SECTION
    And User validates person name, person gender, and person age match with the request body '1997-10-02'
    And User navigates to the wabpage and user validates the url
    When User enters valid username and valid password
    And User chooses location 'Inpatient Ward'
    And User clicks the login button
    When User clicks System Administration button
    And User clicks Advanced Administration button
    And User clicks Manage Persons link
    And User enters the name 'Baks' of the person created with API in the Person Name box
    Then User validates address1 '5555 w LLLL', address2 'APT 207', city 'Heaven', state 'IL', country 'USA', zip '60000', and birthdate '1997-10-02'
    And User clicks logout from the page
#     DATABASE TEST SECTION
    Then User enters the uuid given from the API response and validates the uuid from API matches the uuid in the database
    And user delete the person and validates the person uuid is null and close the database connection

  Scenario: Two-layer Test Create a Patient: create with API validate database

#    API TEST SECTION
    And User validates person name, person gender, and person age match with the request body '1997-10-02'
    Given User has valid API URL to get patient ID
    When User sends GET request for patient ID
    Then Get patient ID statue code is 200
    Given User has valid API URL to get patient ID type
    When User sends GET request for Id type
    Then Get patient ID type statue code is 200
    Given User has valid API URL to get location ID
    When User sends GET request for location id
    Then Get location ID statue code is 200
    Given User has valid API URL to post a patient
    When User sends post request to create a patient with the responses information
#     DATABASE TEST SECTION
    Then User validates that the API patient uuid matches database patient uuid
    And User deletes patient uuid in database and validates that it is null
    And user delete the person and validates the person uuid is null and close the database connection


