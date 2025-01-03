package lesson_17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


public class Lesson_17 {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        Response response = RestAssured
                .given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .extract()
                .response();

        Assert.assertEquals(200, response.getStatusCode());

        Assert.assertTrue(response.jsonPath().getString("args.foo1").equals("bar1"));
        Assert.assertTrue(response.jsonPath().getString("args.foo2").equals("bar2"));
    }

    @Test
    public void testPostRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        RestAssured.baseURI = "https://postman-echo.com";
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .extract()
                .response();

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(requestBody, response.jsonPath().getString("data"));
    }

    @Test
    public void testPostFormData() {
        RestAssured.baseURI = "https://postman-echo.com";
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{\"foo1\":\"bar1\", \"foo2\":\"bar2\"}")
                .when()
                .post("/post")
                .then()
                .extract()
                .response();

        Assert.assertEquals(200, response.getStatusCode());

        Assert.assertTrue(response.jsonPath().getString("json.foo1").equals("bar1"));
        Assert.assertTrue(response.jsonPath().getString("json.foo2").equals("bar2"));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        RestAssured.baseURI = "https://postman-echo.com";
        Response response = RestAssured
                .given()
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .extract()
                .response();

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(requestBody, response.jsonPath().getString("data"));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        RestAssured.baseURI = "https://postman-echo.com";
        Response response = RestAssured
                .given()
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .extract()
                .response();

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(requestBody, response.jsonPath().getString("data"));


    }

    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        RestAssured.baseURI = "https://postman-echo.com";
        Response response = RestAssured
                .given()
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .extract()
                .response();

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(requestBody, response.jsonPath().getString("data"));
    }

}
