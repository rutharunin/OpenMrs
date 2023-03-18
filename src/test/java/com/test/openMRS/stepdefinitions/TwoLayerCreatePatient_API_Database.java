package com.test.openMRS.stepdefinitions;

import com.test.openMRS.jdbc.ValidateCreatePatientJDBC;
import io.cucumber.java.en.Then;

public class TwoLayerCreatePatient_API_Database {

    ValidateCreatePatientJDBC validateCreatePatientJDBC=new ValidateCreatePatientJDBC();
    @Then("User validates that the API patient uuid matches database patient uuid")
    public void user_validates_that_the_api_patient_uuid_matches_database_patient_uuid() {
        validateCreatePatientJDBC.createResultSet();
        validateCreatePatientJDBC.deletePatientTest();
    }
    @Then("User deletes patient uuid in database and validates that it is null")
    public void user_deletes_patient_uuid_in_database_and_validates_that_it_is_null() {
        validateCreatePatientJDBC.validateDeletePatient();
    }
}
