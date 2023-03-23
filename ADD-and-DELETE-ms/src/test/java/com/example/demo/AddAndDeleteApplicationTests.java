package com.example.demo;

import org.junit.jupiter.api.Test;



import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest


//class AddAndDeleteApplicationTests {
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
class AddAndDeleteApplicationTests {

    @Test
    @Order(1)
    public void testAddBook() {
        String jsonbody="{\"access_number\":\"8\",\"title\":\"test\",\"author\":\"Cardiology\",\"subject\":\"sample\",\"keyword\":\"MBBS\",\"category\":\"sample123\",\"bookurl\":\"bookurl\",\"quantity\":\"10\"}";
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8093/api/Books")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test
    @Order(2)
    public void testgetallbooksbycategory() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8093/api/Books/book/1")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    
    
    @Test
    @Order(3)
    public void testgetallbooks() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8093/api/Books")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test
    @Order(4)
    public void testdeletebooks() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .delete("http://localhost:8093/api/Books/accessno/7")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    @Test
    @Order(5)
    public void testAddmember() {
        String jsonbody="{\"username\":\"user2\",\"email\":\"test@gmail.com\",\"id\":\"6\",\"password\":\"sample\"}";
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8093/api/Books")
                .then()
                .assertThat().statusCode(201)
                .extract().response().asString();
    }
  
    
    
    
    @Test
    @Order(6)
    public void testgetallmembers() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8093/api/Books")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test
    @Order(7)
    public void testdeletemembers() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .delete("http://localhost:8093/api/Books/accessno/4")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    
    

}
