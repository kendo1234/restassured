import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

public class WorkingWithResponsesTest {

    @Before
    public void setBaseUri(){
        RestAssured.baseURI = "http://pokeapi.co/api/v2/";

    }

    @Test
    public void GetWeatherDetails()
    {

        RequestSpecification httpRequest = RestAssured.given();

        // Make a GET request call directly by using RequestSpecification.get() method.
        // Make sure you specify the resource name.

        Response response = httpRequest.get("/pokemon/4");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        // Response.asString method will directly return the content of the body
        // as String.

        System.out.println("Response Body is =>  " + response.asString());
    }

    @Test
    public void IteratingOverHeaders()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/pokemon/4");

        // Get all the headers. Return value is of type Headers.
        // Headers class implements Iterable interface, hence we
        // can apply an advance for loop to go through all Headers
        // as shown in the code below
        Headers allHeaders = response.headers();

        // Iterate over all the Headers
        for(Header header : allHeaders)
        {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }

    @Test
    public void GetWeatherHeaders()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Reader header of a give name. In this line we will get
        // Header named Content-Type
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);

        // Reader header of a give name. In this line we will get
        // Header named Server
        String serverType =  response.header("Server");
        Assert.assertEquals(serverType /* actual value */, "nginx/1.14.0" /* expected value */);

        // Reader header of a give name. In this line we will get
        // Header named Content-Encoding
        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
    }
}
