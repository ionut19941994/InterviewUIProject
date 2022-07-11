package cucumber.StepDefinition;

import cucumber.models.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @Given("the user sends the GET request to 'read' EP")
    public void getCategories() {
        String endpoint = "http://localhost:8888/api_testing/category/read.php";
        given().when().get(endpoint).then();
    }

    @When("the user receives a 200 status")
    public void assertCategoriesStatus() {
        String endpoint = "http://localhost:8888/api_testing/category/read.php";
        given().when().get(endpoint).then().assertThat().statusCode(200);
    }

    @Then("the user is able to see results")
    public void assertCategories() {
        String endpoint = "http://localhost:8888/api_testing/category/read.php";
        given().
                when().get(endpoint).
                then().assertThat().body("records.size()", equalTo(5));
    }

    public void getProducts() {
        String endpoint = "http://localhost:8888/api_testing/product/read.php";
        given().
                when().
                get(endpoint).
                then().
                log().
                headers().
                assertThat().
                statusCode(200).header("Content-Type", equalTo("application/json; charset=UTF-8")).
                body("records.size()", greaterThan(0)).
                body("records.id", everyItem(notNullValue())).
                body("records.name", everyItem(notNullValue())).
                body("records.description", everyItem(notNullValue())).
                body("records.price", everyItem(notNullValue())).
                body("records.category_id", everyItem(notNullValue())).
                body("records.category_name", everyItem(notNullValue())).
                body("records.id[0]", equalTo("1001"));

    }

    public void getProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
        ValidatableResponse response =
                given().
                        queryParam("id", 2).
                        when().
                        get(endpoint).
                        then().
                        assertThat().
                        statusCode(200).
                        body("id", equalTo("2")).
                        body("name", equalTo("Cross-Back Training Tank")).
                        body("description", equalTo("The most awesome phone of 2013!")).
                        body("price", equalTo("299.00")).
                        body("category_id", equalTo("2")).
                        body("category_name", equalTo("Active Wear - Women"));
        response.log().body();
    }

    public void createProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        String body =
                "{" +
                        "\"name\": \"Water Bottle\"," +
                        "\"description\": \"Blue water bottle. Holds 64 ounces\"," +
                        "\"price\": 12," +
                        "\"category_id\": 3" +
                        "}";
        ValidatableResponse response = given().body(body).when().post(endpoint).then();
        response.log().body();
    }

    public void updateProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/update.php";
        String body =
                "{" +
                        "\"id\": 1000," +
                        "\"name\": \"Water Bottle\"," +
                        "\"description\": \"Blue water bottle. Holds 64 ounces\"," +
                        "\"price\": 15," +
                        "\"category_id\": 3" +
                        "}";
        ValidatableResponse response = given().body(body).when().put(endpoint).then();
        response.log().body();
    }

    public void deleteProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/delete.php";
        String body =
                "{" +
                        "\"id\": 1000" +
                        "}";
        ValidatableResponse response = given().body(body).when().delete(endpoint).then();
        response.log().body();
    }

    public void createSerialezedProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        Product product = new Product(
                "Water Bottle",
                "Blue Sprinkled water bottle",
                12,
                3
        );
        ValidatableResponse response = given().body(product).when().post(endpoint).then();
        response.log().body();
    }

    public void getDeserializedProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
        Product expectedProduct = new Product(
                2,
                "Cross-Back Training Tank",
                "The most awesome phone of 2013!",
                299.00,
                2,
                "Active Wear - Women"
        );
        Product actualProduct = given().
                queryParam("id", "2").
                when().
                get(endpoint).
                as(Product.class);

        assertThat(actualProduct, samePropertyValuesAs(expectedProduct));
    }

    @Given("^the user sends the (.*) request to the EP?$")
    public void productByRequest(String reqType) {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
                given().
                        queryParam("id", 2).
                        when().
                        request(reqType, endpoint).
                        then();
    }
//    Needs rework
    @When("^the user receives (.*) status code?$")
    public void verifyStatus(int statusCode){
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
        given().when().request(Method.GET, endpoint).then().assertThat().statusCode(statusCode);
    }
}
