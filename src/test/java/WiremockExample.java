import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WiremockExample {

    //sets up our stub
    public void setupStub() {

        stubFor(get(urlEqualTo("/an/endpoint"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withStatus(200)
                        .withBody("This here be a valid endpoint")));
    }
    //sets wiremock service to run on localhost:8090
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8090);

    @Test
    public void testStatusCodePositive() {

        //this test will be using our stub service!
        setupStub();

        given().
                when().
                get("http://localhost:8090/an/endpoint"). //This positive test meets the criteria of our stub so it passes!
                then().
                assertThat().statusCode(200);
    }



    }
