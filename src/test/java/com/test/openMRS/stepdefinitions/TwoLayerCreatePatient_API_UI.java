package com.test.openMRS.stepdefinitions;

import com.test.openMRS.api.RegisterPatientAPI;
import com.test.openMRS.pages.FindPatientRecordPage;
import com.test.openMRS.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class TwoLayerCreatePatient_API_UI {

    WebDriver driver=DriverHelper.getDriver();
    RegisterPatientAPI registerPatientAPI=new RegisterPatientAPI();
    HomePage homePage=new HomePage(driver);
    FindPatientRecordPage findPatientRecordPage=new FindPatientRecordPage(driver);

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
    @When("User clicks Find Patient Record")
    public void user_clicks_find_patient_record() {
        homePage.findPatient();
    }
    @Then("User enters the name {string} posted in API call and validates that it is displayed")
    public void user_enters_the_name_posted_in_api_call_and_validates_that_it_is_displayed(String patientName) {
        findPatientRecordPage.validatePatientName(patientName);
    }
    @When("User clicks on the name on the first row and clicks delete, enters the reason {string}, and clicks confirm")
    public void user_clicks_on_the_name_on_the_first_row_and_clicks_delete_enters_the_reason_and_clicks_confirm(String reason) {
        findPatientRecordPage.deletePatientWithName(reason,driver);
    }
}
