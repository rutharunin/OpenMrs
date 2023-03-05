package com.test.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedAdminPage {
    public AdvancedAdminPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@href='/openmrs/admin/person/index.htm']")
    WebElement managePersonsLink;

    public void clickManagePersons(){
        managePersonsLink.click();
    }
}
