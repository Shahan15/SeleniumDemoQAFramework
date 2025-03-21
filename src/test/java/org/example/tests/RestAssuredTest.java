package org.example.tests;

import com.fasterxml.jackson.databind.util.JSONPObject;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class RestAssuredTest {

    @Ignore
    @Test
    public void testGetRequest() {
        given()
                .baseUri("https://dummy.restapiexample.com/api/v1")
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(1))
                .body("data[0].employee_name", equalTo("Tiger Nixon"));
    }

    @Test
    public void postman () throws IOException {
//        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://dummy.restapiexample.com/api/v1/employees")
                .asString();
        System.out.println("break");

    }

//    @Test
//    public void testPostRequest() {
//        JSONObject requestParams = new JSONObject();
//        requestParams.put("title", "foo");
//        requestParams.put("body", "bar");
//        requestParams.put("userId", 1);
//
//        given()
//                .baseUri("https://jsonplaceholder.typicode.com")
//
//                .header("Content-Type", "application/json")
//                .body(requestParams.toString())
//                .when()
//                .post("/posts")
//                .then()
//                .statusCode(201)
//                .body("title", equalTo("foo"));
//    }
}