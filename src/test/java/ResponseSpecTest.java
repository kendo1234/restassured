import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.builder.ResponseSpecBuilder;
import static io.restassured.RestAssured.when;


public class ResponseSpecTest {

    private static ResponseSpecBuilder builder;
    private static ResponseSpecification responseSpec;

    @BeforeClass
    //Set expected response specification for use in test methods at runtime
    public static void setupResponseSpec() {
        builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        responseSpec = builder.build();
    }

    @Test
    public void testSomeApi()
    {
        when().
                get("http://pokeapi.co/api/v2/").
                then().
                spec(responseSpec);
    }
}
