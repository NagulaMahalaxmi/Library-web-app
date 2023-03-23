package com.example.demo;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//class BookIssueReturnRenewalApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}




import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;


@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookIssueReturnRenewalApplicationTests {

    @Test
    @Order(1)
    public void testIssue() {
        String jsonbody="{\"issue_id\":\"1\",\"bookid\":\"1\",\"issue_date\":\"2023-03-23\",\"memberusername\":\"sample\",\"return_date\":\"2023-03-23\",\"returned\":\"0\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8099/books/issue")
                .then()
                .assertThat().statusCode(201)
                .extract().response().asString();
    }
    
    @Test
    @Order(2)
    public void testReturn() {
        String jsonbody= "{\"email\" : \"sample@gmail.com\",\"password\" : \"sample123\"}";
        String token=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8089/books/return")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    @Test
    @Order(3)
    public void testgetallissues() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8099")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    @Test
    @Order(4)
    public void testRenewal() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:5051/api/doctors/get/sample@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    
}