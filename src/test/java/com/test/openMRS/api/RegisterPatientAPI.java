package com.test.openMRS.api;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.PayloadUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class RegisterPatientAPI {
    public Response response;
    private String name;
    private String lastname;
    private String gender;
    private String birthdate;
    private String address1;
    public void postPerson(String name, String lastname, String gender, String dob, String add1, String add2, String city, String state, String country, String zip){
        response=
        RestAssured.given()
                .header("Authorization","Basic QWRtaW46QWRtaW4xMjM=")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(PayloadUtils.postPersonPayload(name,lastname,gender,dob,add1,add2,city,state,country,zip))
                .when().post();
        this.name=name;
        this.lastname=lastname;
        this.gender=gender;
        this.birthdate=dob;
        this.address1=add1;
    }
    public void validateResponseCode(Integer expected){
        Integer actualStatusCode=response.getStatusCode();
        Assert.assertEquals(expected,actualStatusCode);
    }
    public void validateResponseInfo(String postedDate) throws ParseException {
        Map<String,Object>deserializedResponse=response.as(new TypeRef<Map<String,Object>>() {
        });
        Assert.assertEquals(name+" "+lastname,deserializedResponse.get("display").toString());
        Assert.assertEquals(gender,deserializedResponse.get("gender").toString());
        Map<String,Object>responseAddress1=(Map<String,Object>)deserializedResponse.get("preferredAddress");
        Assert.assertEquals(address1,responseAddress1.get("display"));
//        Integer age=(Integer) deserializedResponse.get("age");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        Date posted=simpleDateFormat.parse(postedDate);
//        Date date=new Date();
//        long time_difference = date.getTime() - posted.getTime();
//        long years_difference = (time_difference / (1000l*60*60*24*365));
//        Assert.assertEquals(years_difference,(long)age);

    }
}