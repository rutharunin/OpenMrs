package com.test.openMRS.stepdefinitions;

import com.test.openMRS.api.RegisterPatientAPI;
import com.test.openMRS.jdbc.ValidateCreatePersonJDBC;
import io.cucumber.java.en.Then;

public class ThreeLayerCreatePerson {
    RegisterPatientAPI registerPatientAPI=new RegisterPatientAPI();
    ValidateCreatePersonJDBC validateCreatePersonJDBC=new ValidateCreatePersonJDBC();

    @Then("User enters the uuid given from the API response and validates the uuid from API matches the uuid in the database")
    public void user_enters_the_uuid_given_from_the_api_response_and_validates_the_uuid_from_api_matches_the_uuid_in_the_database() {
        validateCreatePersonJDBC.createPersonTest(registerPatientAPI.getPersonID());
    }
    @Then("user delete the person and validates the person uuid is null")
    public void user_delete_the_person_and_validates_the_person_uuid_is_null() {
        validateCreatePersonJDBC.deletePersonTest();
        validateCreatePersonJDBC.validateDeletePerson();
    }
}
