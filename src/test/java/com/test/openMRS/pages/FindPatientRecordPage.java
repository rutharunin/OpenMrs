package com.test.openMRS.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class FindPatientRecordPage {
    public FindPatientRecordPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//tbody//td)[1]")
    WebElement patientID;

    public void validatePatientCreated(){

        Assert.assertEquals(patientID.getText(),BrowserUtils.getText(patientID));
    }

    public void goToMedicalRecord(){
        patientID.click();
    }
}
