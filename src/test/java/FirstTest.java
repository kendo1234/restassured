import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class FirstTest {

    @Test
    public void exampleRestTest() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("", "")
                .when()
                .get("url/{id}")
                .then()
                .statusCode(200)
                .body("", equalTo(""));
    }
}
