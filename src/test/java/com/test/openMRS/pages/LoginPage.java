package com.test.openMRS.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.util.List;

public class LoginPage {
WebDriver driver;


    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameBox;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordBox;

    @FindBy(xpath = "//ul[@id='sessionLocation']//li")
    List<WebElement> locations;

    @FindBy(xpath = "//input[@id='loginButton']")
    WebElement loginButton;

//    @FindBy(xpath = "//li[@id='Inpatient Ward']")
//    WebElement locationInpatientWard;
//
//    @FindBy(xpath = "//li[@id='Isolation Ward']")
//    WebElement locationIsolationWard;
//
//    @FindBy(xpath = "//li[@id='Laboratory']")
//    WebElement locationLaboratory;
//
//    @FindBy(xpath = "//li[@id='Outpatient Clinic'] ")
//    WebElement locationOutpatientClinic;
//
//    @FindBy(xpath = "//li[@id='Pharmacy']")
//    WebElement locationPharmacy;
//
//    @FindBy(xpath = "//li[@id='Registration Desk']")
//    WebElement locationRegistrationDesk;




    public void chooseLocation(String locat){
        for(WebElement location: locations){
            if (BrowserUtils.getText(location).equalsIgnoreCase(locat)){
                location.click();
            }
        }
    }
    public void login(String username,String password){
        userNameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        }

        public void clickLoginButton(){
        loginButton.click();
        }
}
