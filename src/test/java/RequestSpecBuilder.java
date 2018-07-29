import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class RequestSpecBuilder {

    @Before
    public void setBaseUri(){
        RestAssured.baseURI = "http://pokeapi.co/api/v2/";

    }

    @Test
    public void test01() {
        given ()
                .get ("/type/3/")
                .then ()
                .contentType(ContentType.JSON)
                .assertThat ().statusCode (200);
    }
}
