package tests;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Configuration;
import utils.EndPoint;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class SearchTest extends BaseTest{

    @BeforeClass (alwaysRun = true, dependsOnMethods = "configure")
    public void setURL(){

        // https://newsapi.org/v2/everything?q=trump&apiKey=b2816096a04f4f2f913389449f14653c
        requestSpecification.
                queryParam("q", "Trump").
                queryParam("apiKey", "b2816096a04f4f2f913389449f14653c").log().all();
    }

    @Test(groups = "json")
    public void getResponse(){

        given().spec(requestSpecification).get(EndPoint.GET_EVERYTHING).then().statusCode(200).log().all();
    }

    @Test(groups = {"json", "response"})
    public void getTitle(){

        Response response = new Configuration().getResponse(requestSpecification, EndPoint.GET_EVERYTHING, 200);

        response.then().body(containsString("Trump"));
    }
}
