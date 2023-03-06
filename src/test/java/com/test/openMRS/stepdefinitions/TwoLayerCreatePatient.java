package com.test.openMRS.stepdefinitions;

import com.test.openMRS.api.RegisterPatientAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class TwoLayerCreatePatient {

    RegisterPatientAPI registerPatientAPI=new RegisterPatientAPI();

    @Given("User sends GET request for patient ID")
    public void user_sends_get_request_for_patient_id() {
        registerPatientAPI.getID();
    }
    @Given("User sends GET request for Id type")
    public void user_sends_get_request_for_id_type() {
        registerPatientAPI.getIdType();
    }
    @Given("User sends GET request for location id")
    public void user_sends_get_request_for_location_id() {
        registerPatientAPI.getLocation();
    }
    @When("User sends post request to create a patient with the responses information")
    public void user_sends_post_request_to_create_a_patient_with_the_responses_information() {
        registerPatientAPI.postPatient();
    }
}
