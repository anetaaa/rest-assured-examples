package com.testinglaboratory.restassured.foundations.simple.queryparams;

//TODO exercise query parameters

import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Create tests for:
 * /get_all_people_sliced
 * /get_all_people_paged
 * /get_all_people_by
 * endpoints
 */
public class ExerciseQueryParamsPeopleServiceTest {
    @Test
    public void shouldReturnListOfAllPeopleSliced() {
        given().queryParam("from_number", 11)
                .queryParam("up_to_number", 13)
                .when()
                .get("/get_all_people_sliced")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().everything();
    }

    @Test
    public void shouldReturnListOfAllPeoplePaged() {
        Response response = (Response) given().queryParam("page_size", 5)
                //  .queryParam("page_number", 2)
                .when()

                .get("/get_all_people_paged")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().everything().extract();
    }

    @Test
    public void shouldReturnListOfPeopleByName() {
        Response response = given().queryParam("first_name", "Tomasz")
                // .queryParam("last_name", "Rajtar")
                .when()
                .get("/get_people_by")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().everything().extract().response();
        List<Map<String, String>> people = response.getBody().jsonPath().getList(".");
        for (Map<String, String> human : people) {
            assertThat(human.get("first_name")).isEqualTo("Tomasz");
        }
    }

    @Test
    @DisplayName("No such person exists.")
    public void shouldNotReturnListOfPeopleByName() {
        Response response = given().queryParam("first_name", "Aneta")
                // .queryParam("last_name", "Rajtar")
                .when()
                .get("/get_people_by")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().everything().extract().response();

        response.then().statusCode(22);
        response.body().jsonPath().getString("message");

        response.jsonPath().getString("message");
        response.xmlPath();
        response.htmlPath();


        List<Map<String, String>> people = response.getBody().jsonPath().getList(".");
        for (Map<String, String> human : people) {
            assertThat(human.get("first_name")).isEqualTo("Aneta");
        }
    }

    @DisplayName("/get_people_by without params")
    @Test
    public void shouldFailedReturnListOfPeopleByName() {
        given()
                .when()
                .get("/get_people_by")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().everything();
    }
}
