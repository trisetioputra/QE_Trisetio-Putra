package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.mockito.internal.matchers.Null;
import starter.post.Post;

public class PostStep {

    @Steps
    Post postAPI;
    @Given("I set {string} endpoints")
    public void setEndpoint(String endpoint){
        postAPI.setGetEndpoint();
    }

    @When("I send GET HTTP request")
    public void getHttpRequest(){
        postAPI.getHttpRequest();
    }

    @When("I send GET HTTP request based on {string}")
    public void getByIdHttpRequest(String id){
        postAPI.getByIdHttpRequest(id);
    }

    @When("I send DELETE HTTP request based on {string}")
    public void deleteByIdHttpRequest(String id){
        postAPI.deleteByIdHttpRequest(id);
    }


    @When("I send POST HTTP request given valid {int}, {string}, and {string}")
    public void postRequest(int userId, String title, String body){
        postAPI.postHttpRequest(userId,title,body,-1);
    }

    @When("I send POST HTTP request given valid {int}, {int}, {string}, and {string}")
    public void postRequestWithId(int id, int userId, String title, String body){
        postAPI.postHttpRequest(userId,title,body,id);
    }

    @When("I send PUT HTTP request given valid {int}, {int}, {string}, and {string}")
    public void putRequest(int id, int userId, String title, String body){
        postAPI.putHttpRequest(userId,title,body,id);
    }

    @When("I send PUT HTTP request given invalid {int} and valid {int}, {string}, and {string}")
    public void putRequestInvalidId(int id, int userId, String title, String body){
        postAPI.putHttpRequest(userId,title,body,id);
    }

    @Then("I receive valid HTTP response code {string}")
    public void getValidResponse(String code){
        postAPI.receiveValidStatus(code);
    }
    @And("I receive array type for the retrieved data")
    public void receiveValidArray(){
        postAPI.receiveValidDataType();
    }
    @And("I receive valid data type for sample post data")
    public void receiveValidDataGetAll(){
        postAPI.receiveValidDataGetAll();
    }

    @And("I receive data based on matching with {string}")
    public void receiveCorrectId(String id){
        postAPI.receiveCorrectId(id);
    }
    @And("I receive valid data type for post data response")
    public void receiveValidDataGetId(){
        postAPI.receiveValidData();
    }
    @And("I receive empty response body")
    public void receiveEmptyObject(){
        postAPI.receiveEmptyObject();
    }
    @And("I will see id with different values than {int}")
    public void checkIdReceived(int id){
        postAPI.receiveDifferentId(id);
    }
    @When("I receive response based on matching the sent {int}, {string}, and {string}")
    public void checkPostResponse(int userId, String title, String body){
        postAPI.receiveMatchingResponse(userId,title,body);
    }

    @When("I receive response based on matching the sent {int}, {int}, {string}, and {string}")
    public void checkPutResponse(int id, int userId, String title, String body){
        postAPI.receiveMatchingResponsePutRequest(id,userId,title,body);
    }
}
