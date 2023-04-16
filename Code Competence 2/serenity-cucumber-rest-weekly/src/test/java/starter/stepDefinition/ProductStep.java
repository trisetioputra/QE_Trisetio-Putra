package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.action.ProductAction;

public class ProductStep {

    @Steps
    ProductAction productController;

    @Given("I set {string} endpoints")
    public void i_set_endpoints(String string) {
        productController.setGetEndpoint();
    }
    @When("I send GET HTTP request")
    public void i_send_get_http_request() {
        productController.getHttpRequest();
    }
    @Then("I receive valid HTTP response code {string}")
    public void i_receive_valid_http_response_code(String code) {
        productController.receiveValidStatus(code);
    }
    @And("I receive array type for the retrieved data")
    public void i_receive_array_type_for_the_retrieved_data() {
        productController.receiveArrayOfObjects();
    }
    @And("I receive the correct attributes for object within array")
    public void i_receive_the_correct_attributes_for_object_within_array() {
        productController.receiveCorrectAttributesOnArray();
    }

    @Then("I will not receive more than {int} data")
    public void i_will_not_receive_more_than_data(Integer length) {
        productController.receiveCorrectLength(length);
    }
    @When("I send GET By ID HTTP request given valid ID as {string}")
    public void i_send_get_by_id_http_request(String id) {
        productController.getByIdHttpRequest(id);
    }

    @When("I send GET By ID HTTP request given invalid ID as {string}")
    public void i_send_get_by_id_http_request_with_invalid(String id) {
        productController.getByIdHttpRequest(id);
    }
    @And("I receive object type for the retrieved data")
    public void i_receive_object_type_for_the_retrieved_data() {
        productController.receiveObject();
    }
    @And("I receive the correct attributes and ID: {string} for the object")
    public void i_receive_the_correct_attributes_for_the_object(String id) {
        productController.receiveCorrectAttributes(id);
    }

    @And("I receive empty array value as response")
    public void i_receive_empty_array_as_response() {
        productController.receiveEmptyArray();
    }
    @And("I receive null value as response")
    public void i_receive_null_value_as_response() {
        productController.receiveNull();
    }
    @When("I send GET with limit HTTP request with limit as {string}")
    public void i_send_get_with_limit_http_request_with_limit_as(String limit) {
        productController.getWithLimitHttpRequest(limit);
    }
    @And("I receive array type for the retrieved data with length matching limit value of {string}")
    public void i_receive_array_type_for_the_retrieved_data_with_length_matching_limit_value_of(String limit) {
        productController.receiveCorrectLength(Integer.parseInt(limit));
        productController.receiveCorrectAttributesOnArray();
    }
    @And("I receive fallback array size of {string}")
    public void i_receive_null_value_as_response(String fallBackSize) {
        productController.receiveCorrectLength(Integer.parseInt(fallBackSize));
    }
    @When("I send GET with sort HTTP request with sort as {string}")
    public void i_send_get_with_sort_http_request_with_sort_as(String sort) {
        productController.getWithSortHttpRequest(sort);

    }
    @And("I receive array with product sorted based on ID with descending order")
    public void i_receive_array_with_product_sorted_based_on_id_with_descending_order() {
        productController.receiveSortedDescendingOrder();
    }
    @And("I receive array with product sorted based on ID with ascending order")
    public void i_receive_array_with_product_sorted_based_on_id_with_ascending_order() {
        productController.receiveSortedAscendingOrder();
    }
    @When("I send GET based on category HTTP request with category as {string}")
    public void i_send_get_based_on_category_http_request_with_category_as(String category) {
        productController.getWithCategoriesHttpRequest(category);
    }
    @Then("I receive array with product with category equals to the provided {string} input")
    public void i_receive_array_with_product_with_category_equals_to_the_provided_input(String category) {
        productController.receiveCorrectCategoriesOnArray(category);
    }
    @When("I send GET product categories HTTP request")
    public void i_send_get_product_categories_http_request() {
        productController.getProductCategoriesHttpRequest();
    }
    @Then("I receive array of strings for all categories exist on all product data")
    public void i_receive_array_of_strings_for_all_categories_exist_on_all_product_data() {
        productController.receiveCategoriesForAllProducts();
    }

    @When("I send POST product HTTP request with data added with id as: {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_send_post_product_http_request_with_data_as_added(String title, String price, String description, String image, String category, String id) {
        productController.postMutationHttpRequest(title,Float.parseFloat(price),description,image,category,id);
    }

    @When("I send POST product HTTP request with data as: {string}, {string}, {string}, {string}, {string}")
    public void i_send_post_product_http_request_with_data_as(String title, String price, String description, String image, String category) {
        productController.postHttpRequest(title,Float.parseFloat(price),description,image,category);
    }
    @Then("I receive response matching with the given input: {string}, {string}, {string}, {string}, {string}")
    public void i_receive_response_matching_with_the_given_input(String title, String price, String description, String image, String category) {
        productController.receiveMatchingInput(title,Float.parseFloat(price),description,image,category);
    }
    @And("I will see new ID created as {string}")
    public void i_will_see_new_id_created_as(String id) {
        productController.receiveId(Integer.parseInt(id));
    }

    @When("I send POST product HTTP request with mismatch attribute type as: {string}, {string}, {string}, {string}, {string}")
    public void iSendPOSTProductHTTPRequestWithMismatchAttributeTypeAs(String title, String price, String description, String image, String category) {
        productController.postMutationHttpRequest(title,price,description,image,category);
    }

    @When("I send POST product HTTP request with missing attribute as: {string}, {string}")
    public void iSendPOSTProductHTTPRequestWithMissingAttributeAs(String title, String price) {
        productController.postMutationHttpRequest(title,Float.parseFloat(price));
    }

    @When("I send POST product HTTP request with empty body")
    public void iSendPOSTProductHTTPRequestWithEmptyBody() {
        productController.postMutationHttpRequest();
    }

    @When("I send PUT product HTTP request with valid ID as {string} and data as: {string}, {string}, {string}, {string}, {string}")
    public void iSendPUTProductHTTPRequestWithValidIDAsAndDataAs(String id,String title, String price, String description, String image, String category) {
        productController.putHttpRequest(title,Float.parseFloat(price), description,image,category,id);
    }

    @When("I send PUT product HTTP request with invalid ID as {string} and data as: {string}, {string}, {string}, {string}, {string}")
    public void iSendPUTProductHTTPRequestWithInvalidIDAsAndDataAs(String id,String title, String price, String description, String image, String category) {
        productController.putHttpRequest(title,Float.parseFloat(price), description,image,category,id);
    }

    @When("I send Patch product HTTP request with valid ID as {string} and data as: {string}, {string}, {string}, {string}, {string}")
    public void iSendPatchProductHTTPRequestWithValidIDAsAndDataAs(String id,String title, String price, String description, String image, String category) {
        productController.patchHttpRequest(title,Float.parseFloat(price), description,image,category,id);
    }

    @When("I send Patch product HTTP request with invalid ID as {string} and data as: {string}, {string}, {string}, {string}, {string}")
    public void iSendPatchProductHTTPRequestWithInvalidIDAsAndDataAs(String id,String title, String price, String description, String image, String category) {
        productController.patchHttpRequest(title,Float.parseFloat(price), description,image,category,id);
    }

    @When("I send DELETE By ID HTTP request given valid ID as {string}")
    public void iSendDELETEByIDHTTPRequestGivenValidIDAs(String id) {
        productController.deleteByIdHttpRequest(id);
    }

    @When("I send DELETE By ID HTTP request given invalid ID as {string}")
    public void iSendDELETEByIDHTTPRequestGivenInvalidIDAs(String id) {
        productController.deleteByIdHttpRequest(id);
    }

    @And("I received null value as response")
    public void iReceivedNullValueAsResponse() {
        productController.receiveNullVariant2();
    }
}
