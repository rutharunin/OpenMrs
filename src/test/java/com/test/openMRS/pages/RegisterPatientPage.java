package com.test.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class RegisterPatientPage {

    public RegisterPatientPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h2")
    WebElement header;
    @FindBy(xpath = "//input[@name='givenName']")
    WebElement firstnameBox;
    @FindBy(xpath = "//input[@name='familyName']")
    WebElement lastnameBox;
    @FindBy(xpath = "//span[.='Gender']")
    WebElement genderLink;
    @FindBy(xpath = "//option[.='Male']")
    WebElement maleOptionBox;
    @FindBy(xpath = "//span[.='Birthdate']")
    WebElement birthdateLink;
    @FindBy(xpath = "//input[@name='birthdateDay']")
    WebElement birthdateBox;
    @FindBy(xpath = "//select[@name='birthdateMonth']")
    WebElement birthMonthBox;
    @FindBy(xpath = "//input[@name='birthdateYear']")
    WebElement birthyearBox;
    @FindBy(xpath = "//span[.='Address']")
    WebElement addressLink;
    @FindBy(css = "#address1")
    WebElement address1Box;
    @FindBy(css = "#address2")
    WebElement address2Box;
    @FindBy(css = "#cityVillage")
    WebElement cityBox;
    @FindBy(css = "#stateProvince")
    WebElement stateBox;
    @FindBy(css = "#country")
    WebElement countryBox;
    @FindBy(css = "#postalCode")
    WebElement zipBox;
    @FindBy(xpath = "//span[.='Phone Number']")
    WebElement phoneNumberLink;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneBox;
    @FindBy(css = "#confirmation_label")
    WebElement confirm1;
    @FindBy(css = "#submit")
    WebElement confirm2;

    public String validateHeader(){
        return BrowserUtils.getText(header);
    }
    public void fillOutName(String firstName,String lastName){
        firstnameBox.sendKeys(firstName);
        lastnameBox.sendKeys(lastName);
    }
    public void fillOutGenderMale(){
        genderLink.click();
        maleOptionBox.click();
    }
    public void fillOutBirthdate(Integer day,String month,Integer year){
        birthdateLink.click();
        birthdateBox.sendKeys(day.toString());
        BrowserUtils.selectBy(birthMonthBox,month,"text");
        birthyearBox.sendKeys(year.toString());
    }
    public void fillOutAddress(Integer ad1,String ad2,String ad3,String ad4,String ad5,Integer ad6){
        addressLink.click();
        address1Box.sendKeys(ad1.toString());
        address2Box.sendKeys(ad2);
        cityBox.sendKeys(ad3);
        stateBox.sendKeys(ad4);
        countryBox.sendKeys(ad5);
        zipBox.sendKeys(ad6.toString());
    }
    public void fillOutPhone(String phone){
        phoneNumberLink.click();
        phoneBox.sendKeys(phone);
    }
    public void confirm(){
        confirm1.click();
        confirm2.click();
    }
}
