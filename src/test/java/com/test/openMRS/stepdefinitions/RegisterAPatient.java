package com.test.openMRS.stepdefinitions;

import com.test.openMRS.pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class RegisterAPatient {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    RegisterPatientPage registerPatientPage=new RegisterPatientPage(driver);
    MedicalRecordPage medicalRecordPage=new MedicalRecordPage(driver);
    FindPatientRecordPage findPatientRecordPage=new FindPatientRecordPage(driver);


    @When("User clicks Register a Patient and validates header contains text {string}")
    public void user_clicks_register_a_patient_and_validates_header_contains_text(String expectedHeader) {
        homePage.clickRegisterPatient();
        Assert.assertTrue(registerPatientPage.validateHeader().equalsIgnoreCase(expectedHeader));
    }
    @When("User enters name {string} and last name {string}")
    public void user_enters_name_and_last_name(String string, String string2) {
        registerPatientPage.fillOutName(string,string2);
    }
    @When("User enters the gender")
    public void user_enters_the_gender()  {
        registerPatientPage.fillOutGenderMale();
    }
    @When("User enters birthdate {int}, {string}, {int}")
    public void user_enters_birthdate(Integer int1, String string, Integer int2) {
        registerPatientPage.fillOutBirthdate(int1,string,int2);
    }
    @When("User enters address {int} {string}, {string}, {string}, {string},{int}")
    public void user_enters_address(Integer int1, String string, String string2, String string3, String string4, Integer int2) {
        registerPatientPage.fillOutAddress(int1, string, string2, string3, string4, int2);
    }
    @When("User enters phone number {string} and click confirm two times")
    public void user_enters_phone_number_and_click_confirm_two_times(String string) {
        registerPatientPage.fillOutPhone(string);
        registerPatientPage.confirm();
    }
    @Then("User validate the title {string}")
    public void user_validate_the_title(String string) {
        Assert.assertEquals(string,driver.getTitle());
    }
    @Then("User clicks home button and clicks Find Patient Record")
    public void user_clicks_home_button_and_clicks_find_patient_record() {
        medicalRecordPage.clickHome(driver);
        homePage.findPatient();
    }
    @Then("User validates the generated userID is displayed")
    public void user_validates_the_generated_user_id_is_displayed() {
        findPatientRecordPage.validatePatientCreated();
    }
    @Then("User clicks the patient link then clicks delete, gives the reason {string}, and clicks confirm")
    public void user_clicks_the_patient_link_then_clicks_delete_gives_the_reason_and_clicks_confirm(String string) {
        findPatientRecordPage.goToMedicalRecord();
        medicalRecordPage.deletePatient(string);
    }
}
