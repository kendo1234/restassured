import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;

//Auth Example
//public class RequestSpecTest {
//    public static RequestSpecBuilder builder;
//    public static RequestSpecification requestSpec;
//    @BeforeClass
//    public static void setupRequestSpecBuilder()
//    {
//        builder = new RequestSpecBuilder();
//        builder.addHeader("Authorization", "abcd-123-xyz");
//        builder.addParameter("loginID", "joebloggs");
//        requestSpec = builder.build();
//    }


public class RequestSpecBuilder {
    //sets re-useable request specification for use within the class tests
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
