import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class HistoricalEndpointTests {
    ///historical endpoint requires the “Date” parameter
    // (a user-friendly error should be returned if the parameter is incorrect or missing).
    // As well endpoint is able to receive (optional) currencies parameters(NIS,RUB,EUR,CAD)
    private static Response response;

    @Test
    public void historicalEndpointTest(){
        response=given().get(Consts.URL+Consts.HISTORICAL_ENDPOINT+"2018-01-01"+Consts.HISTORICAL_PART2 +Consts.API_KEY);
        System.out.println(response.asString());
        response.then().statusCode(200);
        response.then().body("success",equalTo(true));
        response.then().body("historical",equalTo(true));
        response.then().body("source",equalTo("USD"));
        response.then().body("date",equalTo("2018-01-01"));
        response.then().body("quotes",notNullValue());
     }
     @Test//authorization,negative, no token
     public void noTokenTest(){
         response=given().get(Consts.URL+Consts.HISTORICAL_ENDPOINT+"2018-01-01"+Consts.HISTORICAL_PART2);
         System.out.println(response.asString());
         response.then().statusCode(401);
         response.then().body("message",containsString("No API key found in request"));

     }
    @Test//authorization,negative,invalid token
    public void invTokenTest(){
        response=given().get(Consts.URL+Consts.HISTORICAL_ENDPOINT+"2018-01-01"+Consts.HISTORICAL_PART2 +"Token");
        System.out.println(response.asString());
        response.then().statusCode(401);
        response.then().body("message",containsString("Invalid auth"));

    }
     @Test//optional currencies' rates,failed, cause NIS option is null
    public void optionalHistoricalRatesTest(){
         response=given().get(Consts.URL+Consts.HISTORICAL_ENDPOINT+"2018-01-01"+Consts.HISTORICAL_PART2 +Consts.OPTIONAL_CURRENCIES);
         System.out.println(response.asString());
         response.then().body("quotes.USDEUR",notNullValue());
         response.then().body("quotes.USDCAD",notNullValue());
         response.then().body("quotes.USDNIS",notNullValue());
         response.then().body("quotes.USDRUB",notNullValue());
     }
    @Test//// (a user-friendly error should be returned if the parameter is missing).
    public void dateMissingTest(){
         response=given().get(Consts.URL+Consts.HISTORICAL_ENDPOINT+""+Consts.HISTORICAL_PART2 +Consts.OPTIONAL_CURRENCIES);
         System.out.println(response.asString());
         response.then().statusCode(200);
         response.then().body("success",equalTo(false));
         response.then().body("error.code",equalTo(301));
         response.then().body("error.info",containsString("not specified a date"));
     }

    @Test//// (a user-friendly error should be returned if the parameter is incorrect).
    public void dateIncorrectTest(){
        response=given().get(Consts.URL+Consts.HISTORICAL_ENDPOINT+"456778"+Consts.HISTORICAL_PART2 +Consts.OPTIONAL_CURRENCIES);
        System.out.println(response.asString());
        response.then().statusCode(200);
        response.then().body("success",equalTo(false));
        response.then().body("error.code",equalTo(302));
        response.then().body("error.info",containsString("invalid date"));
    }
}
