package com.test.openMRS.stepdefinitions;

import com.test.openMRS.jdbc.ValidateCreatePatient_UI_JDBC;
import com.test.openMRS.pages.FindPatientRecordPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class TwoLayerCreatePatient_UI_Database_UI {

    WebDriver driver=DriverHelper.getDriver();
    ValidateCreatePatient_UI_JDBC validateCreatePatientUiJdbc=new ValidateCreatePatient_UI_JDBC();
    FindPatientRecordPage findPatientRecordPage=new FindPatientRecordPage(driver);

    @Then("User validates that the patient ID in UI matches patient ID in database")
    public void user_validates_that_the_patient_id_in_ui_matches_patient_id_in_database() {
        validateCreatePatientUiJdbc.createResultSet();
        validateCreatePatientUiJdbc.validateCreatePatientTest();
    }
    @Then("User deletes patient ID in database and close database connection")
    public void user_deletes_patient_id_in_database_and_close_database_connection() {
        validateCreatePatientUiJdbc.deletePatientTest();
        validateCreatePatientUiJdbc.closeDatabaseConnection();
    }
    @Then("User refreshes the UI page and search for the patient using patient ID")
    public void user_refreshes_the_ui_page_and_search_for_the_patient_using_patient_id() {
        driver.navigate().refresh();
        findPatientRecordPage.searchWithPatientID();
    }
    @Then("User validate message {string}")
    public void user_validate_message(String string) {
        findPatientRecordPage.validateNoPatientRecord(string);
    }
}
