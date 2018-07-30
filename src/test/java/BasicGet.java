import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class BasicGet {

    //builds config values for use in tests
    @Before
    public void setup() {
        RestAssured.baseURI = "http://pokeapi.co/api/v2";
        //RestAssured.port = 443;
    }

    @Test
    public void exampleRestTest() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", "pokemon/4/") //example of defining a path parameter, sets the param type and endpoint to yield it from
        .when()
                .get("http://pokeapi.co/api/v2/{id}")
        .then()
                .statusCode(200)
                .body("name", equalTo("charmander"));
    }

    @Test
    public void test_Md5CheckSumForTest_ShouldBe098f6bcd4621d373cade4e832627b4f6() {

        String originalText = "test";
        String expectedMd5CheckSum = "098f6bcd4621d373cade4e832627b4f6"; // Example of query parameter

        given().
                param("text",originalText).
                when().
                get("http://md5.jsontest.com"). // /?text=test would be appended to the URL
                then().
                assertThat().
                body("md5",equalTo(expectedMd5CheckSum));
    }
    @Test
    public void whenRequestGet_thenOK(){
        when().request("GET", baseURI)
        .then().statusCode(200);
    }

}
