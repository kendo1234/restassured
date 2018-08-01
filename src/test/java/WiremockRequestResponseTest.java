import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WiremockRequestResponseTest {


    public void setupStub() {

        stubFor(post(urlEqualTo("/pingpong"))
                .withRequestBody(matching("<input>PING</input>"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withBody("<output>PONG</output>")));
    }

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8090);

   // This service only returns a status code 200 and a response XML message when the request body equals a given value.
    @Test
    public void testPingPongPositive() {

        setupStub();

        given().
                body("<input>PING</input>").
                when().
                post("http://localhost:8090/pingpong").
                then().
                assertThat().
                statusCode(200).
                and().
                assertThat().body("output", org.hamcrest.Matchers.equalTo("PONG"));
    }
}
