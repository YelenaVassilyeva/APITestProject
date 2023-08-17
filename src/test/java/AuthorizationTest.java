import org.junit.jupiter.api.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AuthorizationTest {
    private static Response response;
    //1.1. Critical for all the endpoints below!
    //1.2. Unauthorized users should be restricted to get the response from the external API -
    // 1.3. Expected error: You have not supplied a valid API Access Key.


    @Test//as mentioned in documentation:"Expected error: You have not supplied a valid API Access Key.",failed.
    public void liveInvalidTokenTest(){
        response = given().get(Consts.URL + Consts.LIVE_ENDPOINT+"invalid_Key");
        System.out.println(response.asString());
        response.then().statusCode(401);
        response.then().body("message",containsString("You have not supplied a valid API Access Key."));
    }
    @Test//invalid auth token, as it's in reality,passed
    public void liveEndpInvalidTokenTest(){
        response = given().get(Consts.URL + Consts.LIVE_ENDPOINT+"invalid_Key");
        System.out.println(response.asString());
        response.then().statusCode(401);
        response.then().body("message",containsString("Invalid authentication"));
    }
    @Test//no token applied
    public void liveEndpNoTokenTest(){
        response = given().get(Consts.URL + Consts.LIVE_ENDPOINT);
        System.out.println(response.asString());
        response.then().statusCode(401);
        response.then().body("message",containsString("No API key found in request"));
    }
    @Test//empty token
    public void liveEndpEmptyTokenTest(){
        response = given().get(Consts.URL + Consts.LIVE_ENDPOINT+" ");
        System.out.println(response.asString());
        response.then().statusCode(401);
        response.then().body("message",containsString("Invalid"));
    }

}
