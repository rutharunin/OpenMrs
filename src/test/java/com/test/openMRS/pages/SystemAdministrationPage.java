package com.test.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SystemAdministrationPage {
    public SystemAdministrationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@href='/openmrs/admin/index.htm']")
    WebElement advancedAdministrationLink;

    public void clickAdvancedAdministration(){
        advancedAdministrationLink.click();
    }
}
