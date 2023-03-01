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



    public String getHeader() {

        return BrowserUtils.getText(header);
    }

    public void clickLogOut() {
        logOutButton.click();
    }

}
