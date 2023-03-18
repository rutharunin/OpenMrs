package com.test.openMRS.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class PersonPage {

    public PersonPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#inputNode")
    WebElement nameBox;
    @FindBy(xpath = "//td[.='Baks']")
    WebElement createdPerson;
    @FindBy(xpath = "//input[@id='addresses[0].address1']")
    WebElement address1;
    @FindBy(xpath = "//input[@id='addresses[0].address2']")
    WebElement address2;
    @FindBy(xpath = "//input[@id='addresses[0].cityVillage']")
    WebElement city;
    @FindBy(xpath = "//input[@id='addresses[0].stateProvince']")
    WebElement state;
    @FindBy(xpath = "//input[@id='addresses[0].country']")
    WebElement country;
    @FindBy(xpath = "//input[@id='addresses[0].postalCode']")
    WebElement zip;
    @FindBy(xpath = "//input[@id='birthdate']")
    WebElement birthDate;
    @FindBy(css = "#deletePersonButton")
    WebElement delete1;
    @FindBy(xpath = "//div/input[@value='Delete Person Forever']")
    WebElement delete2;
    @FindBy(xpath = "//td[.='No matching records found']")
    WebElement noPersonMessage;
    @FindBy(css = "#userLogout")
    WebElement logoutLink;

    public void findPerson(String personName){
        nameBox.sendKeys(personName);
        if (createdPerson.isDisplayed()) {
            createdPerson.click();}else {
            Assert.assertTrue(false);
            System.out.println("no such person created");}
    }
    public void ValidatePersonInfo(String add1, String add2, String city, String state, String country, String zip, String birthdate) throws ParseException {

            String oldDateString = birthdate.replace("-", "/");                //string old date
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");     //give a pattern for java Date
            Date d=simpleDateFormat.parse(oldDateString);                                      //convert old string to java Date (parse)
            simpleDateFormat.applyPattern("dd/MM/yyyy");                                       //give a new pattern
            String newDateString=simpleDateFormat.format(d);                                   //convert Date to string with new format (format)
        Assert.assertEquals(add1,this.address1.getAttribute("value"));
        Assert.assertEquals(add2,this.address2.getAttribute("value"));
        Assert.assertEquals(city,this.city.getAttribute("value"));
        Assert.assertEquals(state,this.state.getAttribute("value"));
        Assert.assertEquals(country,this.country.getAttribute("value"));
        Assert.assertEquals(zip,this.zip.getAttribute("value"));
        Assert.assertEquals(newDateString,this.birthDate.getAttribute("value"));
    }
    public void deletePerson(WebDriver driver){
        delete1.click();
        delete2.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public String validateNoPerson(WebDriver driver) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        noPersonMessage=wait.until(ExpectedConditions.visibilityOf(noPersonMessage));
        return noPersonMessage.getText();
    }
    public void logout(){
        logoutLink.click();
    }
}
