package com.test.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MedicalRecordPage {

    public MedicalRecordPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public static String patientID;
    @FindBy(xpath = "//div[@class='identifiers']/span")
    WebElement newPatientID;
    @FindBy(xpath = "//i[@class='icon-home small']")
    WebElement homeIcon;
    @FindBy(xpath = "//a[@id='org.openmrs.module.coreapps.deletePatient']")
    WebElement deletePatient;
    @FindBy(css = "#delete-reason")
    WebElement deleteReasonBox;
    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']//button[@class='confirm right']")
    WebElement confirmButton;

    public void initPatientID(){
       patientID=newPatientID.getText();
    }
    public void clickHome(WebDriver driver){
        driver.navigate().refresh();
        initPatientID();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        homeIcon=wait.until(ExpectedConditions.visibilityOf(homeIcon));
        homeIcon.click();
    }
    public void deletePatient(String reason){
        deletePatient.click();
        deleteReasonBox.sendKeys(reason);
        confirmButton.click();
    }
}
