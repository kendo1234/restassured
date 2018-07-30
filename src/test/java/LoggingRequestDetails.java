import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.number.OrderingComparison.greaterThan;


public class LoggingRequestDetails {

    //builds config values for use in tests
    @Before
    public void setup() {
        RestAssured.baseURI = "http://pokeapi.co/api/v2";
        //RestAssured.port = 443;
    }

    //logs request details to console
    @Test
    public void whenLogRequest_thenOK() {
        given().log().all() //other log methods in rest assured can return specific parts of the request
                .when().get("/pokemon/6/")
                .then().statusCode(200);
    }

    //logs response body to console
    @Test
    public void whenLogResponse_thenOK() {
        when().get("/pokemon/6/")
                .then().log().body().statusCode(200);
    }
    // Log response if condition occurred
    @Test
    public void whenLogResponseIfErrorOccurred_thenSuccess() {

        when().get("/pokemon/fail/")
                .then().log().ifError();
        when().get("--/pokemon/4/")
                .then().log().ifStatusCodeIsEqualTo(500);
        when().get("/pokemon/5/")
                .then().log().ifStatusCodeMatches(greaterThan(200));
    }
}
