package tests;

import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.JsonUtils;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    /**
     * Sets up the base URI for RestAssured before running any tests.
     * The base URI is fetched from a JSON configuration file.
     */
    @BeforeSuite
    public void setUp() {
        baseURI = JsonUtils.readJsonFromFile("apiUrl");
    }

    /**
     * Test to verify the '/productsList' API endpoint.
     * <p>
     * Steps performed:
     * 1. Sends a GET request to '/productsList'.
     * 2. Asserts the response code is 200.
     * 3. Verifies 'Blue Top' is in the response.
     */
    @Test
    public void testGetAllProductsList() {
        given()
                .when()
                    .get("/productsList") // Replace with your actual endpoint
                .then()
                    .statusCode(200)
                    .body(not(empty()))
                    .body(containsString("\"name\": \"Blue Top\""));
    }

    /**
     * Test to verify the '/verifyLogin' API endpoint.
     * <p>
     * Steps performed:
     * 1. Sends a POST request to '/verifyLogin'.
     * 2. Asserts the response code is 200.
     * 3. Verifies 'User exists!' is in the response.
     */
    @Test
    public void testValidLogin() {
        given()
                .contentType("multipart/form-data")
                .multiPart("email", "testuser@tester.com")
                .multiPart("password", "aa123456")
        .when()
                .post("/verifyLogin")
        .then()
                .statusCode(200)
                .body(containsString("User exists!"));
    }
}

