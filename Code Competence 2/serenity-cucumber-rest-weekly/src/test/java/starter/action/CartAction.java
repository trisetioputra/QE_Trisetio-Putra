package starter.action;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Assert;
import starter.object.CartObject;
import starter.object.CartObject;
import starter.object.CartProductObjects;
import starter.object.RatingObject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class CartAction {
    protected static String url= "https://fakestoreapi.com/carts";

    protected static Response response;
    public String setGetEndpoint(){
        return url;
    }
    public void receiveCode(String code){
        restAssuredThat(response->response.statusCode(Integer.parseInt(code)));
    }

    public void receiveErrorDateFormat(){
        restAssuredThat(response->response.body("message",equalTo("date format is not correct. it should be in yyyy-mm-dd format")));
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
    public void getByUserHttpRequest(String userId){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"/user/"+userId).then().extract().response();
    }
    public void getWithSortHttpRequest(String sort){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"?sort="+sort).then().extract().response();
    }

    public void getWithDateRangeHttpRequest(String startdate,String enddate){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"?startdate="+startdate+"&enddate="+enddate).then().extract().response();
    }


    public void getWithLimitHttpRequest(String limit){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"?limit="+limit).then().extract().response();
    }
    public void deleteByIdHttpRequest(String id){
        response= SerenityRest.given()
                .when()
                .delete(setGetEndpoint()+"/"+id).then().extract().response();
    }

    public void postHttpRequest(String userId, String date, String productId, String quantity){
        CartObject cartObject=new CartObject();
        cartObject.setUserId(Integer.parseInt(userId));
        cartObject.setDate(date);
        CartProductObjects cartProductObjects=new CartProductObjects();
        cartProductObjects.setQuantity(quantity);
        cartProductObjects.setProductId(productId);
        List<CartProductObjects> cartProductObjectsList = new ArrayList<>();
        cartProductObjectsList.add(cartProductObjects);

        cartObject.setProducts(cartProductObjectsList);
        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(cartObject, ObjectMapperType.GSON)
                .when()
                .post(setGetEndpoint()).then().extract().response();
    }
    public void postHttpRequestMutation(String userId, String date, String productId, String quantity,String id){
        CartObject cartObject=new CartObject();
        cartObject.setId(Integer.parseInt(id));
        cartObject.setUserId(Integer.parseInt(userId));
        cartObject.setDate(date);
        CartProductObjects cartProductObjects=new CartProductObjects();
        cartProductObjects.setQuantity(quantity);
        cartProductObjects.setProductId(productId);
        List<CartProductObjects> cartProductObjectsList = new ArrayList<>();
        cartProductObjectsList.add(cartProductObjects);

        cartObject.setProducts(cartProductObjectsList);
        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(cartObject, ObjectMapperType.GSON)
                .when()
                .post(setGetEndpoint()).then().extract().response();
    }

    public void putHttpRequest(String userId, String date, String productId, String quantity,String id){
        CartObject cartObject=new CartObject();
        cartObject.setUserId(Integer.parseInt(userId));
        cartObject.setDate(date);
        CartProductObjects cartProductObjects=new CartProductObjects();
        cartProductObjects.setQuantity(quantity);
        cartProductObjects.setProductId(productId);
        List<CartProductObjects> cartProductObjectsList = new ArrayList<>();
        cartProductObjectsList.add(cartProductObjects);

        cartObject.setProducts(cartProductObjectsList);
        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(cartObject, ObjectMapperType.GSON)
                .when()
                .put(setGetEndpoint()+"/"+id).then().extract().response();
    }
    public void patchHttpRequest(String userId, String date, String productId, String quantity,String id){
        CartObject cartObject=new CartObject();
        cartObject.setUserId(Integer.parseInt(userId));
        cartObject.setDate(date);
        CartProductObjects cartProductObjects=new CartProductObjects();
        cartProductObjects.setQuantity(quantity);
        cartProductObjects.setProductId(productId);
        List<CartProductObjects> cartProductObjectsList = new ArrayList<>();
        cartProductObjectsList.add(cartProductObjects);

        cartObject.setProducts(cartProductObjectsList);
        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(cartObject, ObjectMapperType.GSON)
                .when()
                .patch(setGetEndpoint()+"/"+id).then().extract().response();
    }
    public void receiveCorrectAttributesOnArray(){
        List<CartObject> allCart = response.jsonPath().getList("$", CartObject.class);
        for(CartObject cartObject:allCart){
            assertAttributeCart(cartObject);
        }
    }
    public void receiveCorrectCartPerUser(String userId){
        List<CartObject> allCart = response.jsonPath().getList("$", CartObject.class);
        for(CartObject cartObject:allCart){
            assertAttributeCart(cartObject);
            Assert.assertTrue(cartObject.getUserId()==Integer.parseInt(userId));
        }
    }

    public void receiveId(Integer id){
        restAssuredThat(response->response.body("id",equalTo(id)));
    }
    public void receiveCorrectValues(String userId, String date, String productId, String quantity){
        CartObject cartObject = response.jsonPath().getObject("$", CartObject.class);
        Assert.assertTrue(cartObject.getUserId()==Integer.parseInt(userId));
        Assert.assertEquals(cartObject.getDate(),date);
        Assert.assertEquals(cartObject.getProducts().get(0).getProductId(),productId);
        Assert.assertEquals(cartObject.getProducts().get(0).getQuantity(),quantity);
    }
    public void receiveWithinDate(String startDate, String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        ZonedDateTime start= LocalDate.parse(startDate,formatter).atStartOfDay(ZoneId.systemDefault());
        ZonedDateTime end= LocalDate.parse(endDate,formatter).atStartOfDay(ZoneId.systemDefault());

        List<CartObject> allCart = response.jsonPath().getList("$", CartObject.class);
        for(CartObject cartObject:allCart){
            ZonedDateTime cartDate=ZonedDateTime.parse(cartObject.getDate());
            Assert.assertTrue(cartDate.isAfter(start));
            Assert.assertTrue(cartDate.isBefore(end));
            assertAttributeCart(cartObject);
        }
    }

    public void receiveArrayOfObjects(){
        restAssuredThat(response->response.body("$",isA(List.class)));
        restAssuredThat(response->response.body("[0]",isA(Object.class)));
    }

    public void receiveObject(){
        restAssuredThat(response->response.body("$",isA(Object.class)));
    }

    public void receiveNullVariant2(){
        restAssuredThat(response->response.body(equalTo("null")));
    }

    public void receiveCorrectLength(int length){
        List<CartObject> allCarts = response.jsonPath().getList("$", CartObject.class);
        Assert.assertTrue(allCarts.size() == length);
    }
    public void receiveCorrectAttributes(String id){
        CartObject cartObject = response.jsonPath().getObject("$", CartObject.class);

        Assert.assertTrue(cartObject.getId().equals(Integer.parseInt(id)));
        assertAttributeCart(cartObject);
    }

    public void assertAttributeCart(CartObject cartObject){
        Assert.assertTrue(cartObject.getUserId().getClass()==Integer.class);
        Assert.assertTrue(cartObject.getId().getClass()==Integer.class);
        Assert.assertTrue(cartObject.getDate().getClass()==String.class);
        Assert.assertTrue(cartObject.getProducts().get(0).getClass()==CartProductObjects.class);
    }

    public void receiveSortedAscendingOrder(){
        List<CartObject> allCart = response.jsonPath().getList("$", CartObject.class);
        int idBefore=-9999;
        boolean flagStillSorted=true;
        for(CartObject cartObject:allCart){
            assertAttributeCart(cartObject);
            if(cartObject.getId()<idBefore){
                flagStillSorted=false;
                break;
            }
            idBefore=cartObject.getId();
        }
        Assert.assertTrue(flagStillSorted);
    }

    public void receiveSortedDescendingOrder(){
        List<CartObject> allCart = response.jsonPath().getList("$", CartObject.class);
        int idBefore=Integer.MAX_VALUE;
        boolean flagStillSorted=true;
        for(CartObject cartObject:allCart){
            assertAttributeCart(cartObject);
            if(cartObject.getId()>idBefore){
                flagStillSorted=false;
                break;
            }
            idBefore=cartObject.getId();
        }
        Assert.assertTrue(flagStillSorted);
    }

}
