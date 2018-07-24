import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestConcatenation {

    @Test
    public void test_ResponseHeaderData_ShouldBeCorrect() {

        given().
                when().
                get("https://pokeapi.co/api/v2/ability/1/").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                header("server",equalTo("cloudflare"));
    }
}
