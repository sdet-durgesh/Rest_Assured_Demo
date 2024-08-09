import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_GET_AllHeaders {
    @Test
    void getSingleUserDetails()
    {
        //Specify base URI
        RestAssured.baseURI="https://reqres.in";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();

        //Response object
        Response response=httpRequest.request(Method.GET, "/api/users/2");

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        Headers allheaders=response.getHeaders();

        for(Header header:allheaders)
        {
            System.out.println(header.getName() +"    "+ header.getValue());
        }
    }
}
