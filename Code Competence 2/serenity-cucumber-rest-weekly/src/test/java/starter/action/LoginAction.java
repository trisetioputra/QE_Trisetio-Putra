package starter.action;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.object.LoginObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class LoginAction {
    protected static String url= "https://fakestoreapi.com/auth/login";

    protected static Response response;
    public String setGetEndpoint(){
        return url;
    }

    public void getHttpRequest(String email, String password){
        LoginObject loginObject=new LoginObject();
        loginObject.setEmail(email);
        loginObject.setPassword(password);
        SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .header("Content-Length","<calculated when request is sent>")
                .header("Host","<calculated when request is sent>")
                .body(loginObject, ObjectMapperType.GSON)
                .when()
                .post(setGetEndpoint());
    }

    public void receiveToken(){
        restAssuredThat(response->response.body("token",isA(String.class)));
    }
}
