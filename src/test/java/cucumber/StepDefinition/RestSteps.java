package cucumber.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;


public class RestSteps {
    Response response;


    @Given("^the user makes GET request to (.*) endpoint$")
    public void user_makes_get_request_on_ep(String endpoint) throws Throwable{
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath=endpoint;
        try {
            response = given().when().get().then().contentType(ContentType.JSON).extract().response();
        }catch(Exception e) {
            response = given().when().get().then().contentType(ContentType.HTML).extract().response();
        }
    }

    @When("^user will get a (.*) response$")
    public void user_gets_a_response(int status) throws Throwable{
        Assert.assertEquals(response.statusCode(),status);
    }

    @Then("^The response should contain the valid data$")
    public void user_validates_the_data()throws Throwable{
        System.out.println(response.body());
    }
}
