import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.when;


import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;
import static org.testng.AssertJUnit.assertEquals;

public class MeasureResponseTime {

    //builds config values for use in tests
    @Before
    public void setup() {
        RestAssured.baseURI = "http://pokeapi.co/api/v2";
        RestAssured.port = 443;
    }

    @Test
    public void whenMeasureResponseTime_thenOK() {
        Response response = RestAssured.get("/pokemon/6/");
        long timeInMS = response.time();
        long timeInS = response.timeIn(TimeUnit.SECONDS);

        assertEquals(timeInS, timeInMS / 1000);
    }


    @Test
    public void whenValidateResponseTime_thenSuccess() {
        when()
                .get("/pokemon/6/").then().time(lessThan(5000L)); //simple get
    }

}
