package tests;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Configuration;
import utils.EndPoint;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SourceTest extends BaseTest{
    private Response response;

    @BeforeClass(alwaysRun = true, dependsOnMethods = "configure")
    public void setURL(){
        // https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=b2816096a04f4f2f913389449f14653c
        requestSpecification.
                queryParam("sources", "bbc-news").
                queryParam("apiKey", "b2816096a04f4f2f913389449f14653c").log().all();
    }

    @Test(groups = "json")
    public void getResponse(){

        given().spec(requestSpecification).get(EndPoint.TOP_HEADLINES).then().statusCode(200).log().all();
    }

    @Test(groups = {"json", "response"})
    public void getIDs(){

        response = new Configuration().getResponse(requestSpecification, EndPoint.TOP_HEADLINES, 200);

        response.then().body("articles.source.id", everyItem(equalTo("bbc-news")));
    }

    @Test(groups = {"json", "response"})
    public void getAuthor(){

        response = new Configuration().getResponse(requestSpecification, EndPoint.TOP_HEADLINES, 200);

        response.then().body("articles.author", everyItem(equalTo("BBC News")));
    }
}
