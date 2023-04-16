package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.action.LoginAction;

public class LoginStep {
    @Steps
    LoginAction loginController;

    @When("I send POST login HTTP request with valid credential as email: {string} and password: {string}")
    public void iSendPOSTLoginHTTPRequestWithValidCredentialAsEmailAndPassword(String email, String password) {
        loginController.getHttpRequest(email,password);
    }

    @And("I will receive Token value on response")
    public void iWillReceiveTokenValueOnResponse() {
        loginController.receiveToken();
    }

    @When("I send POST login HTTP request with invalid credential as email: {string} and password: {string}")
    public void iSendPOSTLoginHTTPRequestWithInvalidCredentialAsEmailAndPassword(String email, String password) {
        loginController.getHttpRequest(email,password);

    }
}
