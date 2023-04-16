package starter.action;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import starter.object.CartObject;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class UserAction {
    protected static String url= "https://fakestoreapi.com/users";

    protected static Response response;
    public String setGetEndpoint(){
        return url;
    }
    public void receiveCode(String code) {
        restAssuredThat(response -> response.statusCode(Integer.parseInt(code)));
    }
    public void receiveArrayOfObjects(){
        restAssuredThat(response->response.body("$",isA(List.class)));
        restAssuredThat(response->response.body("[0]",isA(Object.class)));
    }
    public void receiveObjectType(){
        restAssuredThat(response->response.body("$",isA(Object.class)));
    }
    public void getHttpRequest(){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()).then().extract().response();
    }
    public void getByIdHttpRequest(String id){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"/"+id).then().extract().response();
    }
    public void deleteByIdHttpRequest(String id){
        response= SerenityRest.given()
                .when()
                .delete(setGetEndpoint()+"/"+id).then().extract().response();
    }
    public void getWithSortHttpRequest(String sort){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"?sort="+sort).then().extract().response();
    }
    public void getWithLimitHttpRequest(String limit){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"?limit="+limit).then().extract().response();
    }
    public void postHttpRequest(String email, String username, String password, String firstname, String lastname, String phone, String lat, String longitude, String city, String street, String number, String zipcode){
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("email",email);
        jsonObject.set("username",username);
        jsonObject.set("password",password);
        jsonObject.set("name.firstname",firstname);
        jsonObject.set("name.lastname",lastname);
        jsonObject.set("phone",phone);
        jsonObject.set("address.geolocation.lat",lat);
        jsonObject.set("address.geolocation.long",longitude);
        jsonObject.set("address.street",street);
        jsonObject.set("address.city",city);
        jsonObject.set("address.number",Integer.parseInt(number));
        jsonObject.set("address.zipcode",zipcode);


        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(jsonObject)
                .when()
                .post(setGetEndpoint()).then().extract().response();
    }
    public void putHttpRequest(String email, String username, String password, String firstname, String lastname, String phone, String lat, String longitude, String city, String street, String number, String zipcode, String id){
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("email",email);
        jsonObject.set("username",username);
        jsonObject.set("password",password);
        jsonObject.set("name.firstname",firstname);
        jsonObject.set("name.lastname",lastname);
        jsonObject.set("phone",phone);
        jsonObject.set("address.geolocation.lat",lat);
        jsonObject.set("address.geolocation.long",longitude);
        jsonObject.set("address.street",street);
        jsonObject.set("address.city",city);
        jsonObject.set("address.number",Integer.parseInt(number));
        jsonObject.set("address.zipcode",zipcode);

        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(jsonObject)
                .when()
                .put(setGetEndpoint()+"/"+id).then().extract().response();
    }
    public void patchHttpRequest(String email, String username, String password, String firstname, String lastname, String phone, String lat, String longitude, String city, String street, String number, String zipcode, String id){
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("email",email);
        jsonObject.set("username",username);
        jsonObject.set("password",password);
        jsonObject.set("name.firstname",firstname);
        jsonObject.set("name.lastname",lastname);
        jsonObject.set("phone",phone);
        jsonObject.set("address.geolocation.lat",lat);
        jsonObject.set("address.geolocation.long",longitude);
        jsonObject.set("address.street",street);
        jsonObject.set("address.city",city);
        jsonObject.set("address.number",Integer.parseInt(number));
        jsonObject.set("address.zipcode",zipcode);

        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(jsonObject)
                .when()
                .patch(setGetEndpoint()+"/"+id).then().extract().response();
    }
    public void postHttpRequestMutation(String email, String username, String password, String firstname, String lastname, String phone, String lat, String longitude, String city, String street, String number, String zipcode, String id){
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("id",Integer.parseInt(id));
        jsonObject.set("email",email);
        jsonObject.set("username",username);
        jsonObject.set("password",password);
        jsonObject.set("name.firstname",firstname);
        jsonObject.set("name.lastname",lastname);
        jsonObject.set("phone",phone);
        jsonObject.set("address.geolocation.lat",lat);
        jsonObject.set("address.geolocation.long",longitude);
        jsonObject.set("address.street",street);
        jsonObject.set("address.city",city);
        jsonObject.set("address.number",Integer.parseInt(number));
        jsonObject.set("address.zipcode",zipcode);


        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(jsonObject)
                .when()
                .post(setGetEndpoint()).then().extract().response();
    }
    public void receiveCorrectLength(int length){
        Integer arraySize = response.jsonPath().getList("$").size();
        Assert.assertTrue(arraySize==length);
    }
    public void receiveUserSortedByIdDescending(){
        Integer arraySize = response.jsonPath().getList("$").size();
        Integer previousId=Integer.MAX_VALUE;
        boolean flagIsSorted=true;
        for(int i=0;i<arraySize;i++){
            String index=String.valueOf(i);
            Integer currentId= response.jsonPath().get(String.format("[%s].id",index));
            if(currentId>previousId){
                flagIsSorted=false;
                break;
            }
            previousId = currentId;
        }
        Assert.assertTrue(flagIsSorted);
    }
    public void receiveUserSortedByIdAscending(){
        Integer arraySize = response.jsonPath().getList("$").size();
        Integer previousId=Integer.MIN_VALUE;
        boolean flagIsSorted=true;
        for(int i=0;i<arraySize;i++){
            String index=String.valueOf(i);
            Integer currentId= response.jsonPath().get(String.format("[%s].id",index));
            if(currentId<previousId){
                flagIsSorted=false;
                break;
            }
            previousId = currentId;
        }
        Assert.assertTrue(flagIsSorted);
    }
    public void receiveId(Integer id){
        restAssuredThat(response->response.body("id",equalTo(id)));
    }
    public void receiveNullVariant2(){
        restAssuredThat(response->response.body(equalTo("null")));
    }
    public void receiveCorrectAttributes(){
        restAssuredThat(response->response.body("[0].id",isA(Integer.class)));
        restAssuredThat(response->response.body("[0].email",isA(String.class)));
        restAssuredThat(response->response.body("[0].password",isA(String.class)));
        restAssuredThat(response->response.body("[0].username",isA(String.class)));
        restAssuredThat(response->response.body("[0].name.firstname",isA(String.class)));
        restAssuredThat(response->response.body("[0].name.lastname",isA(String.class)));
        restAssuredThat(response->response.body("[0].phone",isA(String.class)));
        restAssuredThat(response->response.body("[0].address.geolocation.long",isA(String.class)));
        restAssuredThat(response->response.body("[0].address.geolocation.lat",isA(String.class)));
        restAssuredThat(response->response.body("[0].address.city",isA(String.class)));
        restAssuredThat(response->response.body("[0].address.street",isA(String.class)));
        restAssuredThat(response->response.body("[0].address.number",isA(Integer.class)));
        restAssuredThat(response->response.body("[0].address.zipcode",isA(String.class)));
    }
    public void receiveCorrectAttributesOnObject(){
        restAssuredThat(response->response.body("id",isA(Integer.class)));
        restAssuredThat(response->response.body("email",isA(String.class)));
        restAssuredThat(response->response.body("password",isA(String.class)));
        restAssuredThat(response->response.body("username",isA(String.class)));
        restAssuredThat(response->response.body("name.firstname",isA(String.class)));
        restAssuredThat(response->response.body("name.lastname",isA(String.class)));
        restAssuredThat(response->response.body("phone",isA(String.class)));
        restAssuredThat(response->response.body("address.geolocation.long",isA(String.class)));
        restAssuredThat(response->response.body("address.geolocation.lat",isA(String.class)));
        restAssuredThat(response->response.body("address.city",isA(String.class)));
        restAssuredThat(response->response.body("address.street",isA(String.class)));
        restAssuredThat(response->response.body("address.number",isA(Integer.class)));
        restAssuredThat(response->response.body("address.zipcode",isA(String.class)));
    }

    public void receiveMatchingResponseAndInput(String email, String username, String password, String firstname, String lastname, String phone, String lat, String longitude, String city, String street, String number, String zipcode){
        restAssuredThat(response->response.body("email",equalTo(email)));
        restAssuredThat(response->response.body("password",equalTo(password)));
        restAssuredThat(response->response.body("username",equalTo(username)));
        restAssuredThat(response->response.body("name.firstname",equalTo(firstname)));
        restAssuredThat(response->response.body("name.lastname",equalTo(lastname)));
        restAssuredThat(response->response.body("phone",equalTo(phone)));
        restAssuredThat(response->response.body("address.geolocation.long",equalTo(longitude)));
        restAssuredThat(response->response.body("address.geolocation.lat",equalTo(lat)));
        restAssuredThat(response->response.body("address.city",equalTo(city)));
        restAssuredThat(response->response.body("address.street",equalTo(street)));
        restAssuredThat(response->response.body("address.number",equalTo(number)));
        restAssuredThat(response->response.body("address.zipcode",equalTo(zipcode)));
    }
}
