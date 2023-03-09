package com.test.openMRS.stepdefinitions;

import com.test.openMRS.api.RegisterPatientAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class TwoLayerCreatePatient {

    RegisterPatientAPI registerPatientAPI=new RegisterPatientAPI();

    @Given("User has valid API URL to get patient ID")
    public void user_has_valid_api_url_to_get_patient_id() {
        RestAssured.baseURI="http://codefish.ninja/openmrs";
        RestAssured.basePath="module/idgen/generateIdentifier.form";
    }
    @When("User sends GET request for patient ID")
    public void user_sends_get_request_for_patient_id() {
        registerPatientAPI.getID();
    }
    @Then("Get patient ID statue code is {int}")
    public void get_patient_id_statue_code_is(Integer expectedStatusCode) {
        registerPatientAPI.validateStatusCode(expectedStatusCode);
    }
    @Given("User has valid API URL to get patient ID type")
    public void user_has_valid_api_url_to_get_patient_id_type() {
        RestAssured.baseURI="http://codefish.ninja/openmrs";
        RestAssured.basePath="ws/rest/v1/patientidentifiertype";
    }
    @When("User sends GET request for Id type")
    public void user_sends_get_request_for_id_type() {
        registerPatientAPI.getIdType();
    }
    @Then("Get patient ID type statue code is {int}")
    public void get_patient_id_type_statue_code_is(Integer expectedStatusCode) {
        registerPatientAPI.validateStatusCode(expectedStatusCode);
    }
    @Given("User has valid API URL to get location ID")
    public void user_has_valid_api_url_to_get_location_id() {
        RestAssured.baseURI="http://codefish.ninja/openmrs";
        RestAssured.basePath="ws/rest/v1/location";
    }
    @When("User sends GET request for location id")
    public void user_sends_get_request_for_location_id() {
        registerPatientAPI.getLocation();
    }
    @Then("Get location ID statue code is {int}")
    public void get_location_id_statue_code_is(Integer expectedStatusCode) {
        registerPatientAPI.validateStatusCode(expectedStatusCode);
    }
    @Given("User has valid API URL to post a patient")
    public void user_has_valid_api_url_to_post_a_patient() {
        RestAssured.baseURI="http://codefish.ninja/openmrs";
        RestAssured.basePath="/ws/rest/v1/patient";
    }
    @When("User sends post request to create a patient with the responses information")
    public void user_sends_post_request_to_create_a_patient_with_the_responses_information() {
        registerPatientAPI.postPatient();
    }
}
