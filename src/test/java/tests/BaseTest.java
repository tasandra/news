package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import utils.Configuration;

public class BaseTest {
    RequestSpecification requestSpecification;

    @BeforeClass(alwaysRun = true)
    public void configure() {

        RestAssured.baseURI = "https://newsapi.org";
        RestAssured.basePath = "/v2";
        requestSpecification = new Configuration().getRequestSpecification();

    }
}
