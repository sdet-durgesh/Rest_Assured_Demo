import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TC004_POST_RegisterSuccessful {
    @Test
    void postDetails() {
        //Specify base URI
        RestAssured.baseURI = "https://reqres.in";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response payload sending along with post request
        JSONObject requestParams = new JSONObject();

        requestParams.put("name", "morpheus");
        requestParams.put("","QA");
        /*requestParams.put("UserName","John123");
        requestParams.put("Password","Johnxyz123");
        requestParams.put("Email","johnxya@gmail.com");*/

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toString());

        //Response object
        Response response = httpRequest.request(Method.POST, "/api/users");

        //Print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body Is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Response Code Is: " + statusCode);
        //OR
        Assert.assertEquals(statusCode, 201);

    }
}
