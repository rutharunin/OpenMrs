package com.test.openMRS.pages;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.Duration;

public class FindPatientRecordPage {

    public FindPatientRecordPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//tbody//td)[1]")
    WebElement patientIDLink;
    @FindBy(xpath = "//input[@id='patient-search']")
    WebElement searchPatientBox;
    @FindBy(xpath = "//tr/td[2]")
    WebElement nameLink;
    @FindBy(xpath = "//li/i[@class='icon-remove']")
    WebElement deletePatientLink;
    @FindBy(css = "#delete-reason")
    WebElement deleteReasonBox;
    @FindBy(xpath = "(//button[@class='confirm right']/i)[3]")
    WebElement confirmButton;
    @FindBy(css = ".dataTables_empty")
    WebElement noPatientRecordMessage;


    public static String patientID;
    public static String getPatientID() {
        return patientID;
    }
    public void validatePatientCreated(){
        patientID=patientIDLink.getText();
        Assert.assertTrue(patientIDLink.isDisplayed());
    }
    public void goToMedicalRecord(){
        patientIDLink.click();
    }
    public void validatePatientName(String patientName){
        searchPatientBox.sendKeys(patientName);
        Assert.assertTrue(nameLink.getText().contains(patientName));
    }
    public void deletePatientWithName(String reasonToDelete,WebDriver driver){
        nameLink.click();
        deletePatientLink.click();
        deleteReasonBox.sendKeys(reasonToDelete);
        BrowserUtils.clickWithJS(driver,confirmButton);
    }
    public void searchWithPatientID(){
        searchPatientBox.sendKeys(patientID);
    }
    public void validateNoPatientRecord(String expected){
        Assert.assertEquals(expected,BrowserUtils.getText(noPatientRecordMessage));
    }
}
