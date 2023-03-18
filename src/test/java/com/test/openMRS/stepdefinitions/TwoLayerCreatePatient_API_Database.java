package com.test.openMRS.stepdefinitions;

import com.test.openMRS.jdbc.ValidateCreatePatient_API_JDBC;
import io.cucumber.java.en.Then;

public class TwoLayerCreatePatient_API_Database {

    ValidateCreatePatient_API_JDBC validateCreatePatientAPIJDBC =new ValidateCreatePatient_API_JDBC();

    @Then("User validates that the API patient uuid matches database patient uuid")
    public void user_validates_that_the_api_patient_uuid_matches_database_patient_uuid() {
        validateCreatePatientAPIJDBC.createResultSet();
        validateCreatePatientAPIJDBC.validateCreatePatientTest();
    }
    @Then("User deletes patient uuid in database and validates that it is null")
    public void user_deletes_patient_uuid_in_database_and_validates_that_it_is_null() {
        validateCreatePatientAPIJDBC.deletePatientTest();
        validateCreatePatientAPIJDBC.validateDeletePatient();
    }
}
