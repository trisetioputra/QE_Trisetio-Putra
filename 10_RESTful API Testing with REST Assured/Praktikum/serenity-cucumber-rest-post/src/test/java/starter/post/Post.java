package starter.post;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matcher;

import javax.annotation.Nullable;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class Post {
    protected static String url= "https://jsonplaceholder.typicode.com/posts";

    public String setGetEndpoint(){
        return url;
    }

    public void receiveValidStatus(String code){
        restAssuredThat(response->response.statusCode(Integer.parseInt(code)));
    }

    public void receiveValidDataType(){
        restAssuredThat(response->response.body("$",isA(List.class)));
    }

    public void receiveEmptyObject(){
        restAssuredThat(response->response.body("this.expectedClass",equalTo(null)));
    }

    public void getHttpRequest(){
        SerenityRest.given()
                .when()
                .get(setGetEndpoint());
    }
    public void getByIdHttpRequest(String id){
        SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"/"+id);
    }

    public void deleteByIdHttpRequest(String id){
        SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"/"+id);
    }

    public void postHttpRequest(@Nullable int userId, @Nullable String title, @Nullable String body, @Nullable int id){
        JsonObject json= new JsonObject();
        if(id!=-1){
            json.set("id",id);
        }
        json.set("userId",userId);
        json.set("title",title);
        json.set("body",body);
        SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(json.toString())
                .when()
                .post(setGetEndpoint());
    }

    public void putHttpRequest(@Nullable int userId, @Nullable String title, @Nullable String body, int id){
        JsonObject json= new JsonObject();
        json.set("userId",userId);
        json.set("title",title);
        json.set("body",body);
        SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(json.toString())
                .when()
                .put(setGetEndpoint()+"/"+id);
    }


    public void receiveValidDataGetAll(){
        restAssuredThat(response->response.body("[0].id",isA(Integer.class)));
        restAssuredThat(response->response.body("[0].userId",isA(Integer.class)));
        restAssuredThat(response->response.body("[0].title",isA(String.class)));
        restAssuredThat(response->response.body("[0].body",isA(String.class)));
    }

    public void receiveValidData(){
        restAssuredThat(response->response.body("id",isA(Integer.class)));
        restAssuredThat(response->response.body("userId",isA(Integer.class)));
        restAssuredThat(response->response.body("title",isA(String.class)));
        restAssuredThat(response->response.body("body",isA(String.class)));
    }

    public void receiveMatchingResponse(int userId, String title, String body){
        restAssuredThat(response->response.body("userId",equalTo(userId)));
        restAssuredThat(response->response.body("title",equalTo(title)));
        restAssuredThat(response->response.body("body",equalTo(body)));
    }

    public void receiveMatchingResponsePutRequest(int id, int userId, String title, String body){
        restAssuredThat(response->response.body("userId",equalTo(userId)));
        restAssuredThat(response->response.body("title",equalTo(title)));
        restAssuredThat(response->response.body("body",equalTo(body)));
        restAssuredThat(response->response.body("id",equalTo(id)));
    }

    public void receiveCorrectId(String id){
        restAssuredThat(response->response.body("id",equalTo(Integer.parseInt(id))));
    }
    public void receiveDifferentId(int id){
        restAssuredThat(response->response.body("id", not(id)));
    }
}
