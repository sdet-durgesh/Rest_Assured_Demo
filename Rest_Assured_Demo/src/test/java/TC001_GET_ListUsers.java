import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_ListUsers {
    //https://youtu.be/yDdBOspPp_c?si=4xl44NkxYt0RPEEt
    @Test(priority = 2)
    void getDetails()
    {
        //Specify base URI
        RestAssured.baseURI="https://reqres.in";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();

        //Response object
        Response response=httpRequest.request(Method.GET, "/api/users?page=2");

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine=response.getStatusLine();
        System.out.println("Status line is:"+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }
    @Test(priority = 1)
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

