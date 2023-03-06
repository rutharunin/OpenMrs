package com.test.openMRS.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.PayloadUtils;

public class Test {
    @org.junit.Test
    public void test(){
            RestAssured.baseURI="http://codefish.ninja/openmrs";
            RestAssured.basePath="ws/rest/v1/patient";

            Response response=
                    RestAssured.given()
//                .header("Authorization","Basic QWRtaW46QWRtaW4xMjM=")
//                .queryParam("source","1")
//                .queryParam("username","Admin")
//                .queryParam("password","Admin123")
                            .contentType(ContentType.JSON)
//                            .accept(ContentType.JSON)
                            .body("{\n" +
                                    " \n" +
                                    "    \"identifiers\": [\n" +
                                    "        {\n" +
                                    "          \"identifier\":\"100LL0\", \n" +
                                    "          \"identifierType\":\"05a29f94-c0ed-11e2-94be-8c13b969e334\", \n" +
                                    "          \"location\":\"aff27d58-a15c-49a6-9beb-d30dcfc0c66e\",\n" +
                                    "          \"preferred\":true\n" +
                                    "        } ],\n" +
                                    "    \"person\":\"174ccef9-48d6-4397-a988-c7232b85c22b\"\n" +
                                    " \n" +
                                    "}")
                            .when().post()
                            .then().log().all()
                            .statusCode(201)
                            .extract().response();
    }
}
