package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.assertEquals;

public class Configuration {

    public RequestSpecification getRequestSpecification() {
        return RestAssured.
                given().
                contentType(ContentType.JSON);
    }

    public Response getResponse(RequestSpecification requestSpecification, String endpoint, int status) {
        Response response = requestSpecification.get(endpoint);
        assertEquals(response.getStatusCode(),status);
        response.then().log().all();
        return response;
    }
}
