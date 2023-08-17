import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LiveRatesTest {
    ///live endpoint is expected to return JSON response with the following information:
    //success Returns true or false depending on whether or not your query succeeds.
    //terms Returns a link to the currency layer Terms & Conditions.
    //privacy Returns a link to the currency layer Privacy Policy.
    //timestamp Returns the exact date and time (UNIX) the exchange rates were collected.
    //source Returns the currency to which all exchange rates are relative. (default: USD)
    //quotes It contains all exchange rate values, consisting of the currency pairs and their respective conversion rates.
    private static Response response;


@Test//failed. terms and privacy fields are missing
        public void liveRatesTest(){
       response = given().get(Consts.URL + Consts.LIVE_ENDPOINT+Consts.API_KEY);
       System.out.println(response.asString());
        response.then().body("success", equalTo(true));
        response.then().body("terms", containsString("Terms & Conditions"));
        response.then().body("privacy", containsString("Privacy policy"));
        response.then().body("timestamp", notNullValue());
        response.then().body("source", equalTo("USD"));
        response.then().body("quotes",equalTo(" \"USDAED\": 3.67298,\n" +
                "        \"USDAFN\": 84.495756,\n" +
                "        \"USDALL\": 96.389656,\n" +
                "        \"USDAMD\": 385.970217,\n" +
                "        \"USDANG\": 1.802559,\n" +
                "        \"USDAOA\": 828.49797,\n" +
                "        \"USDARS\": 349.982984,\n" +
                "        \"USDAUD\": 1.55642,\n" +
                "        \"USDAWG\": 1.8,\n" +
                "        \"USDAZN\": 1.698309,\n" +
                "        \"USDBAM\": 1.791674,\n" +
                "        \"USDBBD\": 2.019235,\n" +
                "        \"USDBDT\": 109.470329,\n" +
                "        \"USDBGN\": 1.797398,\n" +
                "        \"USDBHD\": 0.37693,\n" +
                "        \"USDBIF\": 2835,\n" +
                "        \"USDBMD\": 1,\n" +
                "        \"USDBND\": 1.358092,\n" +
                "        \"USDBOB\": 6.911714,\n" +
                "        \"USDBRL\": 4.988402,\n" +
                "        \"USDBSD\": 1.000046,\n" +
                "        \"USDBTC\": 3.456137e-05,\n" +
                "        \"USDBTN\": 83.223634,\n" +
                "        \"USDBWP\": 13.608527,\n" +
                "        \"USDBYN\": 2.525089,\n" +
                "        \"USDBYR\": 19600,\n" +
                "        \"USDBZD\": 2.016132,\n" +
                "        \"USDCAD\": 1.35299,\n" +
                "        \"USDCDF\": 2491.99991,\n" +
                "        \"USDCHF\": 0.879599,\n" +
                "        \"USDCLF\": 0.031542,\n" +
                "        \"USDCLP\": 870.330199,\n" +
                "        \"USDCNY\": 7.2987,\n" +
                "        \"USDCOP\": 4124.25,\n" +
                "        \"USDCRC\": 535.80671,\n" +
                "        \"USDCUC\": 1,\n" +
                "        \"USDCUP\": 26.5,\n" +
                "        \"USDCVE\": 101.409472,\n" +
                "        \"USDCZK\": 22.14555,\n" +
                "        \"USDDJF\": 177.720264,\n" +
                "        \"USDDKK\": 6.847745,\n" +
                "        \"USDDOP\": 56.610076,\n" +
                "        \"USDDZD\": 135.957976,\n" +
                "        \"USDEGP\": 30.899008,\n" +
                "        \"USDERN\": 15,\n" +
                "        \"USDETB\": 54.930207,\n" +
                "        \"USDEUR\": 0.9189,\n" +
                "        \"USDFJD\": 2.26865,\n" +
                "        \"USDFKP\": 0.78485,\n" +
                "        \"USDGBP\": 0.785465,\n" +
                "        \"USDGEL\": 2.614999,\n" +
                "        \"USDGGP\": 0.78485,\n" +
                "        \"USDGHS\": 11.301075,\n" +
                "        \"USDGIP\": 0.78485,\n" +
                "        \"USDGMD\": 60.550282,\n" +
                "        \"USDGNF\": 8649.999889,\n" +
                "        \"USDGTQ\": 7.85625,\n" +
                "        \"USDGYD\": 209.256842,\n" +
                "        \"USDHKD\": 7.83135,\n" +
                "        \"USDHNL\": 24.605014,\n" +
                "        \"USDHRK\": 6.8828,\n" +
                "        \"USDHTG\": 136.029058,\n" +
                "        \"USDHUF\": 355.401128,\n" +
                "        \"USDIDR\": 15368.55,\n" +
                "        \"USDILS\": 3.75162,\n" +
                "        \"USDIMP\": 0.78485,\n" +
                "        \"USDINR\": 83.23415,\n" +
                "        \"USDIQD\": 1310,\n" +
                "        \"USDIRR\": 42250.000467,\n" +
                "        \"USDISK\": 132.41985,\n" +
                "        \"USDJEP\": 0.78485,\n" +
                "        \"USDJMD\": 155.028605,\n" +
                "        \"USDJOD\": 0.707798,\n" +
                "        \"USDJPY\": 146.245012,\n" +
                "        \"USDKES\": 144.092642,\n" +
                "        \"USDKGS\": 88.270351,\n" +
                "        \"USDKHR\": 4135.99997,\n" +
                "        \"USDKMF\": 451.499134,\n" +
                "        \"USDKPW\": 899.96913,\n" +
                "        \"USDKRW\": 1341.429881,\n" +
                "        \"USDKWD\": 0.30782,\n" +
                "        \"USDKYD\": 0.833551,\n" +
                "        \"USDKZT\": 460.096004,\n" +
                "        \"USDLAK\": 19209.999972,\n" +
                "        \"USDLBP\": 15106.231481,\n" +
                "        \"USDLKR\": 321.068518,\n" +
                "        \"USDLRD\": 186.198491,\n" +
                "        \"USDLSL\": 19.060046,\n" +
                "        \"USDLTL\": 2.95274,\n" +
                "        \"USDLVL\": 0.60489,\n" +
                "        \"USDLYD\": 4.820038,\n" +
                "        \"USDMAD\": 9.900502,\n" +
                "        \"USDMDL\": 17.663413,\n" +
                "        \"USDMGA\": 4460.000009,\n" +
                "        \"USDMKD\": 56.619985,\n" +
                "        \"USDMMK\": 2100.412699,\n" +
                "        \"USDMNT\": 3467.084838,\n" +
                "        \"USDMOP\": 8.066048,\n" +
                "        \"USDMRO\": 356.999828,\n" +
                "        \"USDMUR\": 45.802509,\n" +
                "        \"USDMVR\": 15.39022,\n" +
                "        \"USDMWK\": 1083.50203,\n" +
                "        \"USDMXN\": 17.128801,\n" +
                "        \"USDMYR\": 4.629504,\n" +
                "        \"USDMZN\": 63.250275,\n" +
                "        \"USDNAD\": 19.060076,\n" +
                "        \"USDNGN\": 785.890285,\n" +
                "        \"USDNIO\": 36.549781,\n" +
                "        \"USDNOK\": 10.611897,\n" +
                "        \"USDNPR\": 133.158669,\n" +
                "        \"USDNZD\": 1.684025,\n" +
                "        \"USDOMR\": 0.384993,\n" +
                "        \"USDPAB\": 1.000169,\n" +
                "        \"USDPEN\": 3.709855,\n" +
                "        \"USDPGK\": 3.525003,\n" +
                "        \"USDPHP\": 56.648028,\n" +
                "        \"USDPKR\": 293.649898,\n" +
                "        \"USDPLN\": 4.10736,\n" +
                "        \"USDPYG\": 7257.070881,\n" +
                "        \"USDQAR\": 3.640749,\n" +
                "        \"USDRON\": 4.535898,\n" +
                "        \"USDRSD\": 107.774994,\n" +
                "        \"USDRUB\": 94.498994,\n" +
                "        \"USDRWF\": 1185,\n" +
                "        \"USDSAR\": 3.746343,\n" +
                "        \"USDSBD\": 8.382942,\n" +
                "        \"USDSCR\": 13.526628,\n" +
                "        \"USDSDG\": 600.801924,\n" +
                "        \"USDSEK\": 10.91935,\n" +
                "        \"USDSGD\": 1.359385,\n" +
                "        \"USDSHP\": 1.21675,\n" +
                "        \"USDSLE\": 21.987306,\n" +
                "        \"USDSLL\": 19749.999556,\n" +
                "        \"USDSOS\": 568.556157,\n" +
                "        \"USDSRD\": 38.202023,\n" +
                "        \"USDSTD\": 20697.981008,\n" +
                "        \"USDSSP\": 600.999887,\n" +
                "        \"USDSYP\": 13099.680131,\n" +
                "        \"USDSZL\": 19.05023,\n" +
                "        \"USDTHB\": 35.474012,\n" +
                "        \"USDTJS\": 10.962207,\n" +
                "        \"USDTMT\": 3.51,\n" +
                "        \"USDTND\": 3.092029,\n" +
                "        \"USDTOP\": 2.384803,\n" +
                "        \"USDTRY\": 27.085498,\n" +
                "        \"USDTTD\": 6.777969,\n" +
                "        \"USDTWD\": 31.973504,\n" +
                "        \"USDTZS\": 2494.999905,\n" +
                "        \"USDUAH\": 36.941321,\n" +
                "        \"USDUGX\": 3729.791619,\n" +
                "        \"USDUYU\": 38.525303,\n" +
                "        \"USDUZS\": 12105.000324,\n" +
                "        \"USDVEF\": 3088442.878995,\n" +
                "        \"USDVES\": 31.470441,\n" +
                "        \"USDVND\": 23945,\n" +
                "        \"USDVUV\": 120.704644,\n" +
                "        \"USDWST\": 2.72217,\n" +
                "        \"USDXAF\": 600.910586,\n" +
                "        \"USDXAG\": 0.04456,\n" +
                "        \"USDXAU\": 0.000528,\n" +
                "        \"USDXCD\": 2.70255,\n" +
                "        \"USDXDR\": 0.749905,\n" +
                "        \"USDXOF\": 599.499399,\n" +
                "        \"USDXPF\": 109.690307,\n" +
                "        \"USDYER\": 250.302326,\n" +
                "        \"USDZAR\": 19.178501,\n" +
                "        \"USDZMK\": 9001.209086,\n" +
                "        \"USDZMW\": 19.568991,\n" +
                "        \"USDZWL\": 321.999592"));
}
    @Test//failed. Nis option does not exist
    public void liveOptionalRates(){
        response = given().get(Consts.URL + Consts.LIVE_ENDPOINT + Consts.API_KEY + Consts.OPTIONAL_CURRENCIES);
        System.out.println(response.asString());
        response.then().body("quotes.USDEUR",notNullValue());
        response.then().body("quotes.USDCAD",notNullValue());
        response.then().body("quotes.USDNIS",notNullValue());
        response.then().body("quotes.USDRUB",notNullValue());
    }
    @Test//optional currencies except Nis
    public void liveOptionalRates1(){
        response = given().get(Consts.URL + Consts.LIVE_ENDPOINT + Consts.API_KEY + Consts.OPTIONAL_CURRENCIES1);
        System.out.println(response.asString());
        response.then().body("quotes.USDEUR",notNullValue());
        response.then().body("quotes.USDCAD",notNullValue());
        response.then().body("quotes.USDRUB",notNullValue());
    }
    @Test
    public void liveInvalidCurrencyOption(){
        response = given().get(Consts.URL + Consts.LIVE_ENDPOINT + Consts.API_KEY + Consts.OPTIONAL_INVALID);
        System.out.println(response.asString());
        response.then().statusCode(200);
        response.then().body("success",equalTo(false));
        response.then().body("error.info",containsString("invalid Currency Codes" ));
        response.then().body("error.code",equalTo(202));
    }
}
