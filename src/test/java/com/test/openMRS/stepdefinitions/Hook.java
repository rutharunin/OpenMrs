package com.test.openMRS.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class Hook {
    WebDriver driver= DriverHelper.getDriver();
    @Before
    public void setup(){
        driver.get(ConfigReader.readProperty("openmrsURL"));
    }
}
