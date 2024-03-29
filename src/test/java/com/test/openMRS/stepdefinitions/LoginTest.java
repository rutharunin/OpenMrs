package com.test.openMRS.stepdefinitions;

import com.test.openMRS.pages.HomePage;
import com.test.openMRS.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginTest {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("User navigates to the wabpage and user validates the url")
    public void user_navigates_to_the_wabpage_and_user_validates_the_url() {
        Assert.assertEquals(ConfigReader.readProperty("openmrsURL"), driver.getCurrentUrl());
    }
    @When("User enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        loginPage.login(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
    }
    @When("User chooses location {string}")
    public void user_chooses_location(String locat) {
        loginPage.chooseLocation(locat);
    }
    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("User validates the header contains text {string}")
    public void user_validates_the_header_contains_text(String user) {
        Assert.assertTrue(homePage.getHeader().contains(user));
    }
    @Then("User validates the header contains word {string}")
    public void user_validates_the_header_contains_word(String location) {
        Assert.assertTrue(homePage.getHeader().contains(location));
    }
    @Then("User clicks logout")
    public void user_clicks_logout() {
        homePage.clickLogOut(driver);
    }
}
