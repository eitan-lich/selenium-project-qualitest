package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.JsonUtils;
/*
Todo
1. Use Allure reports
2. Add Java Docs
3. Add logs
4. Refactor tests so each class is a single test
5. Refactor functions in Actions class and page classes (register function should exist in Action and page class should have only type field)
6. Add RestAssured tests
7. Add screenshots to tests
 */

public class ApiTests {

    @BeforeSuite
    public void setUp() {
        RestAssured.baseURI = JsonUtils.readJsonFromFile("apiUrl");
    }

    @Test
    public void testGetAllProductsList() {
        Response response = RestAssured.given()
                .when()
                .get("/productsList")
                .then()
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertFalse(json.getList("products").isEmpty());
    }
}

