package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.JsonUtils;

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
