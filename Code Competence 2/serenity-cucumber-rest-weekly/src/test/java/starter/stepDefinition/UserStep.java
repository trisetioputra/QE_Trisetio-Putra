package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import net.thucydides.core.annotations.Steps;
import nonapi.io.github.classgraph.json.Id;
import starter.action.UserAction;

public class UserStep {
    @Steps
    UserAction userController;
    @When("I send GET Users HTTP request")
    public void iSendGETUsersHTTPRequest() {
        userController.getHttpRequest();
    }

    @And("I receive array type for the retrieved user data")
    public void iReceiveArrayTypeForTheRetrievedUserData() {
        userController.receiveArrayOfObjects();
    }

    @And("I receive the correct attributes for object within array for users")
    public void iReceiveTheCorrectAttributesForObjectWithinArrayForUsers() {
        userController.receiveCorrectAttributes();
    }

    @Then("I will not receive more than {int} user data")
    public void iWillNotReceiveMoreThanUserData(int size) {
        userController.receiveCorrectLength(size);
    }

    @When("I send GET Users By ID HTTP request given valid ID as {string}")
    public void iSendGETUsersByIDHTTPRequestGivenValidIDAs(String id) {
        userController.getByIdHttpRequest(id);
    }

    @And("I receive object type for the retrieved user data")
    public void iReceiveObjectTypeForTheRetrievedUserData() {
        userController.receiveObjectType();
    }

    @And("I receive the correct attributes and ID: {string} for the user object")
    public void iReceiveTheCorrectAttributesAndIDForTheUserObject(String id) {
        userController.receiveId(Integer.parseInt(id));
        userController.receiveCorrectAttributesOnObject();
    }

    @When("I send GET Users By ID HTTP request given invalid ID as {string}")
    public void iSendGETUsersByIDHTTPRequestGivenInvalidIDAs(String id) {
        userController.getByIdHttpRequest(id);
    }

    @And("I receive null value as response on user")
    public void iReceiveNullValueAsResponseOnUser() {
        userController.receiveNullVariant2();
    }

    @When("I send GET Users with sort HTTP request with sort as {string}")
    public void iSendGETUsersWithSortHTTPRequestWithSortAs(String sort) {
        userController.getWithSortHttpRequest(sort);
    }

    @Then("I receive array with Users sorted based on ID with descending order")
    public void iReceiveArrayWithUsersSortedBasedOnIDWithDescendingOrder() {
        userController.receiveUserSortedByIdDescending();
    }

    @Then("I receive array with Users sorted based on ID with ascending order")
    public void iReceiveArrayWithUsersSortedBasedOnIDWithAscendingOrder() {
        userController.receiveUserSortedByIdAscending();
    }

    @When("I send GET Users with limit HTTP request with limit as {string}")
    public void iSendGETUsersWithLimitHTTPRequestWithLimitAs(String limit) {
        userController.getWithLimitHttpRequest(limit);
    }

    @And("I receive user array type for the retrieved data with length matching limit value of {string}")
    public void iReceiveUserArrayTypeForTheRetrievedDataWithLengthMatchingLimitValueOf(String limit) {
        userController.receiveCorrectLength(Integer.parseInt(limit));
    }

    @And("I receive the correct attributes for object within array for user")
    public void iReceiveTheCorrectAttributesForObjectWithinArrayForUser() {
        userController.receiveCorrectAttributes();
    }

    @And("I receive fallback user array size of {string}")
    public void iReceiveFallbackUserArraySizeOf(String fallback) {
        userController.receiveCorrectLength(Integer.parseInt(fallback));
    }

    @When("I send POST user HTTP request with data as: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iSendPOSTUserHTTPRequestWithDataAs(String email, String username, String password, String firstname, String lastname, String phone, String lat, String longitude, String city, String street, String number, String zipcode) {
        userController.postHttpRequest(email, username, password, firstname, lastname, phone, lat, longitude, city, street, number, zipcode);
    }

    @And("I receive user response matching with the given input: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iReceiveUserResponseMatchingWithTheGivenInput(String email, String username, String password, String firstname, String lastname, String phone, String lat, String longitude, String city, String street, String number, String zipcodearg) {
        userController.receiveMatchingResponseAndInput(email, username, password, firstname, lastname, phone, lat, longitude, city, street, number, zipcodearg);
    }

    @And("I will see new user ID created as {string}")
    public void iWillSeeNewUserIDCreatedAs(String id) {
        userController.receiveId(Integer.parseInt(id));
    }

    @When("I send POST user HTTP request with added data as:  {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and id: {string}")
    public void iSendPOSTUserHTTPRequestWithAddedDataAsAndId(String email, String username, String password, String firstname, String lastname, String phone, String lat, String longitude, String city, String street, String number, String zipcode, String id) {
        userController.postHttpRequestMutation(email, username, password, firstname, lastname, phone, lat, longitude, city, street, number, zipcode,id);
    }

    @When("I send PUT user HTTP request with data as: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and ID as {string}")
    public void iSendPUTUserHTTPRequestWithDataAsAndIDAs(String email, String username, String password, String firstname, String lastname, String phone, String lat, String longitude, String city, String street, String number, String zipcode, String id) {
        userController.putHttpRequest(email, username, password, firstname, lastname, phone, lat, longitude, city, street, number, zipcode, id);
    }

    @When("I send PATCH user HTTP request with data as: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and ID as {string}")
    public void iSendPATCHUserHTTPRequestWithDataAsAndIDAs(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12) {
        userController.patchHttpRequest(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    @When("I send DELETE Users By ID HTTP request given valid ID as {string}")
    public void iSendDELETEUsersByIDHTTPRequestGivenValidIDAs(String id) {
        userController.deleteByIdHttpRequest(id);

    }

    @When("I send DELETE Users By ID HTTP request given invalid ID as {string}")
    public void iSendDELETEUsersByIDHTTPRequestGivenInvalidIDAs(String id) {
        userController.deleteByIdHttpRequest(id);
    }
}
