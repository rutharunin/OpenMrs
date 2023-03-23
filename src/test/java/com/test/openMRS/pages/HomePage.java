package com.test.openMRS.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

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
    @FindBy(xpath = "//div[@id='apps']/a[1]")
    WebElement findPatientButton;

    public String getHeader() {
        return BrowserUtils.getText(header);
    }
    public void clickLogOut(WebDriver driver) {
        driver.navigate().refresh();
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
