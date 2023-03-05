package com.test.openMRS.stepdefinitions;

import com.test.openMRS.api.RegisterPatientAPI;
import com.test.openMRS.pages.AdvancedAdminPage;
import com.test.openMRS.pages.HomePage;
import com.test.openMRS.pages.PersonPage;
import com.test.openMRS.pages.SystemAdministrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.text.ParseException;

public class TwoLayerCreatePerson {

    WebDriver driver=DriverHelper.getDriver();
    RegisterPatientAPI registerPatientAPI=new RegisterPatientAPI();
    HomePage homePage=new HomePage(driver);
    SystemAdministrationPage systemAdministrationPage=new SystemAdministrationPage(driver);
    AdvancedAdminPage advancedAdminPage=new AdvancedAdminPage(driver);
    PersonPage personPage=new PersonPage(driver);

    @Given("User has valid API URL")
    public void user_has_valid_api_url() {
        RestAssured.baseURI="http://codefish.ninja/openmrs";
        RestAssured.basePath="ws/rest/v1/person";
    }
    @When("User sends POST request to create a person named {string}, lastname {string},gender {string}, birthdate {string}, address1 {string}, address2 {string}, cityVillage {string}, stateProvince {string}, country {string}, postalCode {string}")
    public void user_sends_post_request_to_create_a_person_named_lastname_gender_birthdate_address1_address2_city_village_state_province_country_postal_code(String name, String lastname, String gender, String dob, String add1, String add2, String city, String state, String country, String zip) {
        registerPatientAPI.postPerson(name,lastname,gender,dob,add1,add2,city,state,country,zip);
    }
    @Then("Statue code is {int}")
    public void statue_code_is(Integer int1) {
        registerPatientAPI.validateResponseCode(int1);
    }
    @Then("User validates person name, person gender, and person age match with the request body {string}")
    public void user_validates_person_name_person_gender_and_person_age_match_with_the_request_body(String postedDate) throws ParseException {
        registerPatientAPI.validateResponseInfo(postedDate);
    }
    @When("User clicks System Administration button")
    public void user_clicks_system_administration_button() {
        homePage.clickSystemAdministration();
    }
    @When("User clicks Advanced Administration button")
    public void user_clicks_advanced_administration_button() {
        systemAdministrationPage.clickAdvancedAdministration();
    }
    @When("User clicks Manage Persons link")
    public void user_clicks_manage_persons_link() {
        advancedAdminPage.clickManagePersons();
    }
    @When("User enters the name {string} of the person created with API in the Person Name box")
    public void user_enters_the_name_of_the_person_created_in_api_with_the_person_name_box(String personName) {
        personPage.findPerson(personName);
    }
    @Then("User validates address1 {string}, address2 {string}, city {string}, state {string}, country {string}, zip {string}, and birthdate {string}")
    public void user_validates_address1_address2_city_state_country_zip_and_birthdate(String add1, String add2, String city, String state, String country, String zip, String birthdate) throws ParseException {
        personPage.ValidatePersonInfo(add1,add2,city,state,country,zip,birthdate);
    }
    @Then("User clicks Delete Person Forever two times and ok button one time")
    public void user_clicks_delete_person_forever_two_times_and_ok_button_one_time() {
        personPage.deletePerson(driver);
    }
    @Then("User validates {string} in the search result")
    public void user_validates_in_the_search_result(String expectedMessage) {
        Assert.assertEquals(expectedMessage,personPage.validateNoPerson(driver));
    }
    @Then("User clicks logout from the page")
    public void user_clicks_logout_from_the_page() {
        personPage.logout();
    }
}
