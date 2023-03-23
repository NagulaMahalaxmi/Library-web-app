package com.example.demo;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//class SearchBooksApplicationTests {
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
class SearchBooksApplicationTests {

   
    @Test
    @Order(1)
    public void testsearchbooks() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8088/api")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    @Test
    @Order(2)
    public void testgettitle() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8088/api/title/sample")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    @Test
    @Order(3)
    public void testgetauthor() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8088/api/author/Kate Quinn")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test
    @Order(4)
    public void testgetaccessnumber() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8088/api/accessno/1")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test
    @Order(5)
    public void testgetkeyword() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8088/api/keyword/shiva")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test
    @Order(6)
    public void testgetsubject() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8088/api/subject/subject1")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
   
}