package com.test.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h4")
    WebElement header;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logOutButton;

    @FindBy(xpath = "//div[@id='apps']/a[3]")
    WebElement registerPatientLink;

    @FindBy(xpath = "//div[@id='apps']/a[1]")
    WebElement findPatientLink;

    @FindBy(xpath = "//div[@id='apps']/a[8]")
    WebElement systemAdministrationLink;


    public String getHeader() {

        return BrowserUtils.getText(header);
    }
    public void clickLogOut() {
        logOutButton.click();
    }
    public void clickRegisterPatient(){
        registerPatientLink.click();
    }
    public void findPatient(){
        findPatientLink.click();
    }
    public void clickSystemAdministration(){
        systemAdministrationLink.click();
    }
}
