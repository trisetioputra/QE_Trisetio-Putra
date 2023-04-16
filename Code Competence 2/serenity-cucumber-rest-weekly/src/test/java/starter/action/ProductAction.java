package starter.action;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import starter.object.ProductObject;
import starter.object.RatingObject;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class ProductAction {
    protected static String url= "https://fakestoreapi.com/products";

    protected static Response response;
    public String setGetEndpoint(){
        return url;
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

    public void postHttpRequest(String title, Float price, String description, String image, String category){
        ProductObject productObject=new ProductObject();
        productObject.setTitle(title);
        productObject.setPrice(price);
        productObject.setDescription(description);
        productObject.setImage(image);
        productObject.setCategory(category);
        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(productObject, ObjectMapperType.GSON)
                .when()
                .post(setGetEndpoint()).then().extract().response();
    }

    public void putHttpRequest(String title, Float price, String description, String image, String category, String id){
        ProductObject productObject=new ProductObject();
        productObject.setTitle(title);
        productObject.setPrice(price);
        productObject.setDescription(description);
        productObject.setImage(image);
        productObject.setCategory(category);
        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(productObject, ObjectMapperType.GSON)
                .when()
                .put(setGetEndpoint()+"/"+id).then().extract().response();
    }

    public void patchHttpRequest(String title, Float price, String description, String image, String category, String id){
        ProductObject productObject=new ProductObject();
        productObject.setTitle(title);
        productObject.setPrice(price);
        productObject.setDescription(description);
        productObject.setImage(image);
        productObject.setCategory(category);
        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(productObject, ObjectMapperType.GSON)
                .when()
                .patch(setGetEndpoint()+"/"+id).then().extract().response();
    }

    public void postMutationHttpRequest(String title, String price, String description, String image, String category){
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("title",Integer.parseInt(title));
        jsonObject.set("price",price);
        jsonObject.set("description",Integer.parseInt(description));
        jsonObject.set("image",image);
        jsonObject.set("category",category);

        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(jsonObject)
                .when()
                .post(setGetEndpoint()).then().extract().response();
    }

    public void postMutationHttpRequest(String title, Float price, String description, String image, String category, String id){
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("title",title);
        jsonObject.set("price",price);
        jsonObject.set("description",description);
        jsonObject.set("image",image);
        jsonObject.set("category",category);
        jsonObject.set("id",id);

        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(jsonObject)
                .when()
                .post(setGetEndpoint()).then().extract().response();
    }

    public void postMutationHttpRequest(String title, Float price){
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("title",title);
        jsonObject.set("price",price);

        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(jsonObject)
                .when()
                .post(setGetEndpoint()).then().extract().response();
    }
    public void postMutationHttpRequest(){
        JsonObject jsonObject = new JsonObject();

        response= SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(jsonObject)
                .when()
                .post(setGetEndpoint()).then().extract().response();
    }

    public void getWithLimitHttpRequest(String limit){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"?limit="+limit).then().extract().response();
    }
    public void getProductCategoriesHttpRequest(){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"/categories").then().extract().response();
    }
    public void getWithCategoriesHttpRequest(String category){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"/category/"+category).then().extract().response();
    }

    public void getWithSortHttpRequest(String sort){
        response= SerenityRest.given()
                .when()
                .get(setGetEndpoint()+"?sort="+sort).then().extract().response();
    }
    public void receiveValidStatus(String code){
        restAssuredThat(response->response.statusCode(Integer.parseInt(code)));
    }

    public void receiveArrayOfObjects(){
        restAssuredThat(response->response.body("$",isA(List.class)));
        restAssuredThat(response->response.body("[0]",isA(Object.class)));
    }

    public void receiveObject(){
        restAssuredThat(response->response.body("$",isA(Object.class)));
    }

    public void receiveNull(){
        restAssuredThat(response->response.body(isEmptyOrNullString()));
    }

    public void receiveNullVariant2(){
        restAssuredThat(response->response.body(equalTo("null")));
    }

    public void receiveEmptyArray(){
        restAssuredThat(response->response.body("$",not(List.class)));
    }

    public void receiveId(Integer id){
        restAssuredThat(response->response.body("id",equalTo(id)));
    }

    public void receiveCorrectAttributesOnArray(){
        List<ProductObject> allProduct = response.jsonPath().getList("$", ProductObject.class);
        for(ProductObject productObject:allProduct){
            assertAttributeProduct(productObject);
        }
    }

    public void receiveCorrectCategoriesOnArray(String expectedCategory){
        List<ProductObject> allProduct = response.jsonPath().getList("$", ProductObject.class);
        for(ProductObject productObject:allProduct){
            assertAttributeProduct(productObject);
            Assert.assertEquals(productObject.getCategory(),expectedCategory);
        }
    }
    public void receiveSortedAscendingOrder(){
        List<ProductObject> allProduct = response.jsonPath().getList("$", ProductObject.class);
        int idBefore=-9999;
        boolean flagStillSorted=true;
        for(ProductObject productObject:allProduct){
            assertAttributeProduct(productObject);
            if(productObject.getId()<idBefore){
                flagStillSorted=false;
                break;
            }
            idBefore=productObject.getId();
        }
        Assert.assertTrue(flagStillSorted);
    }

    public void receiveSortedDescendingOrder(){
        List<ProductObject> allProduct = response.jsonPath().getList("$", ProductObject.class);
        int idBefore=Integer.MAX_VALUE;
        boolean flagStillSorted=true;
        for(ProductObject productObject:allProduct){
            assertAttributeProduct(productObject);
            if(productObject.getId()>idBefore){
                flagStillSorted=false;
                break;
            }
            idBefore=productObject.getId();
        }
        Assert.assertTrue(flagStillSorted);
    }

    public void receiveCategoriesForAllProducts(){
        List<String> allCategories = response.jsonPath().getList("$", String.class);
        getHttpRequest();
        List<ProductObject> allProduct = response.jsonPath().getList("$", ProductObject.class);

        boolean containsAllCategories=true;
        for(ProductObject productObject:allProduct){
            if(!allCategories.contains(productObject.getCategory())){
                containsAllCategories=false;
                break;
            }
        }
        Assert.assertTrue(containsAllCategories);
    }

    public void receiveCorrectAttributes(String id){
        ProductObject productObject = response.jsonPath().getObject("$", ProductObject.class);

        Assert.assertTrue(productObject.getId().equals(Integer.parseInt(id)));
        assertAttributeProduct(productObject);
    }


    public void receiveCorrectLength(int length){
        List<ProductObject> allProduct = response.jsonPath().getList("$", ProductObject.class);
        Assert.assertTrue(allProduct.size() == length);
    }

    public void receiveMatchingInput(String title, Float price, String description, String image, String category){
        ProductObject productObject = response.jsonPath().getObject("$", ProductObject.class);
        assertMatchingResultWithInput(productObject,title,price,description,image,category);
    }

    public void assertAttributeProduct(ProductObject productObject){
        Assert.assertTrue(productObject.getCategory().getClass()==String.class);
        Assert.assertTrue(productObject.getId().getClass()==Integer.class);
        Assert.assertTrue(productObject.getPrice().getClass()==Float.class);
        Assert.assertTrue(productObject.getTitle().getClass()==String.class);
        Assert.assertTrue(productObject.getImage().getClass()==String.class);
        Assert.assertTrue(productObject.getDescription().getClass()==String.class);
        Assert.assertTrue(productObject.getRating().getClass()== RatingObject.class);
    }

    public void assertMatchingResultWithInput(ProductObject productObject, String title, Float price, String description, String image, String category){
        Assert.assertEquals(productObject.getCategory(),category);
        Assert.assertEquals(productObject.getTitle(),title);
        Assert.assertEquals(productObject.getImage(),image);
        Assert.assertEquals(productObject.getDescription(),description);
        Assert.assertEquals(productObject.getPrice(),price);
    }
}
