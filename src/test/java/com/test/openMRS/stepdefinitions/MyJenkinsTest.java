package com.test.openMRS.stepdefinitions;

import com.test.openMRS.pages.LoginPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class MyJenkinsTest {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    @Then("I print something")
    public void i_print_something() {
        System.out.println("Hello World");
    }

}
