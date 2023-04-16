package starter.stepDefinition;

import net.thucydides.core.annotations.Steps;
import starter.action.CartAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStep {
    @Steps
    CartAction cartController;

    @When("I send GET Carts HTTP request")
    public void i_send_get_carts_http_request() {
        cartController.getHttpRequest();
    }
    @And("I receive the correct attributes for object within array for carts")
    public void i_receive_the_correct_attributes_for_object_within_array_for_carts() {
        cartController.receiveCorrectAttributesOnArray();
    }

    @And("I receive array type for the retrieved cart data")
    public void iReceiveArrayTypeForTheRetrievedCartData() {
        cartController.receiveArrayOfObjects();
    }

    @Then("I will not receive more than {int} cart data")
    public void iWillNotReceiveMoreThanCartData(int length) {
        cartController.receiveCorrectLength(7);
    }

    @When("I send GET Carts By ID HTTP request given valid ID as {string}")
    public void iSendGETCartsByIDHTTPRequestGivenValidIDAs(String id) {
        cartController.getByIdHttpRequest(id);
    }

    @And("I receive object type for the retrieved cart data")
    public void iReceiveObjectTypeForTheRetrievedCartData() {
        cartController.receiveObject();
    }

    @And("I receive the correct attributes and ID: {string} for the cart object")
    public void iReceiveTheCorrectAttributesAndIDForTheCartObject(String id) {
        cartController.receiveCorrectAttributes(id);
    }

    @When("I send GET Carts By ID HTTP request given invalid ID as {string}")
    public void iSendGETCartsByIDHTTPRequestGivenInvalidIDAs(String id) {
        cartController.getByIdHttpRequest(id);
    }

    @And("I receive null value as response on cart")
    public void iReceiveNullValueAsResponseOnCart() {
        cartController.receiveNullVariant2();
    }

    @When("I send GET Carts with sort HTTP request with sort as {string}")
    public void iSendGETCartsWithSortHTTPRequestWithSortAs(String sort) {
        cartController.getWithSortHttpRequest(sort);
    }

    @Then("I receive array with Carts sorted based on ID with descending order")
    public void iReceiveArrayWithCartsSortedBasedOnIDWithDescendingOrder() {
        cartController.receiveSortedDescendingOrder();
    }

    @Then("I receive array with Carts sorted based on ID with ascending order")
    public void iReceiveArrayWithCartsSortedBasedOnIDWithAscendingOrder() {
        cartController.receiveSortedAscendingOrder();

    }

    @When("I send GET Carts with limit HTTP request with limit as {string}")
    public void iSendGETCartsWithLimitHTTPRequestWithLimitAs(String limit) {
        cartController.getWithLimitHttpRequest(limit);
    }

    @And("I receive cart array type for the retrieved data with length matching limit value of {string}")
    public void iReceiveCartArrayTypeForTheRetrievedDataWithLengthMatchingLimitValueOf(String limit) {
        cartController.receiveCorrectLength(Integer.parseInt(limit));
        cartController.receiveCorrectAttributesOnArray();
    }

    @And("I receive fallback cart array size of {string}")
    public void iReceiveFallbackCartArraySizeOf(String fallBackSize) {
        cartController.receiveCorrectLength(Integer.parseInt(fallBackSize));
    }

    @When("I send GET Carts By Date HTTP request given valid start date as {string} and end date as {string}")
    public void iSendGETCartsByDateHTTPRequestGivenValidStartDateAsAndEndDateAs(String start, String end) {
        cartController.getWithDateRangeHttpRequest(start,end);
    }

    @And("I receive cart array type for the retrieved data with date matching start date as {string} and end date as {string}")
    public void iReceiveCartArrayTypeForTheRetrievedDataWithDateMatchingStartDateAsAndEndDateAs(String start, String end) {
        cartController.receiveWithinDate(start,end);
    }

    @When("I send GET Carts By Date HTTP request given invalid start date as {string} and end date as {string}")
    public void iSendGETCartsByDateHTTPRequestGivenInvalidStartDateAsAndEndDateAs(String start, String end) {
        cartController.getWithDateRangeHttpRequest(start,end);
    }

    @Then("I receive error HTTP response code {string}")
    public void iReceiveErrorHTTPResponseCode(String errorCode) {
        cartController.receiveCode(errorCode);
    }

    @And("I can see error message of wrong date format")
    public void iCanSeeErrorMessageOfWrongDateFormat() {
        cartController.receiveErrorDateFormat();
    }

    @When("I send GET Carts By User HTTP request given valid userId as {string}")
    public void iSendGETCartsByUserHTTPRequestGivenValidUserIdAs(String userId) {
        cartController.getByUserHttpRequest(userId);
    }

    @And("I receive cart array type for the retrieved data with userId matching the input {string}")
    public void iReceiveCartArrayTypeForTheRetrievedDataWithUserIdMatchingTheInput(String userId) {
        cartController.receiveCorrectCartPerUser(userId);
    }

    @When("I send POST cart HTTP request with data as: {string}, {string}, {string}, {string}")
    public void iSendPOSTCartHTTPRequestWithDataAs(String userId, String date, String productId, String quantity) {
        cartController.postHttpRequest(userId, date, productId, quantity);
    }

    @And("I will see new cart ID created as {string}")
    public void iWillSeeNewCartIDCreatedAs(String id) {
        cartController.receiveId(Integer.parseInt(id));
    }

    @When("I send POST cart HTTP request with added data as: {string}, {string}, {string}, {string} and id: {string}")
    public void iSendPOSTCartHTTPRequestWithAddedDataAsAndId(String userId, String date, String productId, String quantity, String id) {
        cartController.postHttpRequestMutation(userId, date, productId, quantity,id);
    }

    @And("I receive cart response matching with the given input: {string}, {string}, {string}, {string}")
    public void iReceiveCartResponseMatchingWithTheGivenInput(String userId, String date, String productId, String quantity) {
        cartController.receiveCorrectValues(userId, date, productId, quantity);
    }

    @When("I send PUT cart HTTP request with data as: {string}, {string}, {string}, {string} and ID as {string}")
    public void iSendPUTCartHTTPRequestWithDataAsAndIDAs(String userId, String date, String productId, String quantity, String id) {
        cartController.putHttpRequest(userId, date, productId, quantity, id);
    }

    @And("I will see cart ID as {string}")
    public void iWillSeeCartIDAs(String id) {
        cartController.receiveId(Integer.parseInt(id));
    }

    @When("I send PUT cart HTTP request with data as: {string}, {string}, {string}, {string} and invalid ID as {string}")
    public void iSendPUTCartHTTPRequestWithDataAsAndInvalidIDAs(String userId, String date, String productId, String quantity, String id) {
        cartController.putHttpRequest(userId, date, productId, quantity, id);
    }

    @When("I send PATCH cart HTTP request with data as: {string}, {string}, {string}, {string} and ID as {string}")
    public void iSendPATCHCartHTTPRequestWithDataAsAndIDAs(String userId, String date, String productId, String quantity, String id) {
        cartController.patchHttpRequest(userId, date, productId, quantity, id);
    }

    @When("I send PATCH cart HTTP request with data as: {string}, {string}, {string}, {string} and invalid ID as {string}")
    public void iSendPATCHCartHTTPRequestWithDataAsAndInvalidIDAs(String userId, String date, String productId, String quantity, String id) {
        cartController.patchHttpRequest(userId, date, productId, quantity, id);
    }

    @When("I send DELETE Carts By ID HTTP request given valid ID as {string}")
    public void iSendDELETECartsByIDHTTPRequestGivenValidIDAs(String id) {
        cartController.deleteByIdHttpRequest(id);
    }

    @When("I send DELETE Carts By ID HTTP request given invalid ID as {string}")
    public void iSendDELETECartsByIDHTTPRequestGivenInvalidIDAs(String id) {
        cartController.deleteByIdHttpRequest(id);
    }
}
