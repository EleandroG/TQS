package com.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class DemoTest {

    @Test
    void todoAvailable() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/todos/4")
                .then().assertThat()
                .statusCode(200);
    }

    @Test
    void titleOfTodoTest() {
        String title = "et porro tempora";

        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/todos/4")
                .then().assertThat()
                .statusCode(200)
                .and().body("title", equalTo(title))
                .and().body("id", equalTo(4));
    }

    @Test
    void whenGetAll() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/todos")
                .then().assertThat()
                .statusCode(200)
                .and().body("id", hasItems(198, 199));
    }

}
