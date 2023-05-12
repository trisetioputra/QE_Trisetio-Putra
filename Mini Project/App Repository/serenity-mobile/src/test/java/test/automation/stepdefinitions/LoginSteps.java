package test.automation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.jpackage.internal.Log;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import test.automation.pages.LoginScreen;
import test.automation.pages.RegistrationScreen;


public class LoginSteps {
    @Steps
    LoginScreen loginScreen;
    @Steps
    RegistrationScreen registrationScreen;

    public static String email;

    @When("I press login button on homepage")
    public void iPressLoginButton() {
        loginScreen.clickLoginButtonOnHomepage();
    }

    @And("I enter unregistered credentials on form")
    public void iEnterUnregisteredCredentialsOnForm() {
        boolean useNumbers=true;
        boolean useLetter=true;
        String randomString= RandomStringUtils.random(14,useLetter,useNumbers);
        loginScreen.fillEmailForm(randomString+"@gmail.com");
        loginScreen.fillPasswordForm("testing123");
    }

    @And("I press login submit button")
    public void iPressLoginSubmitButton() {
        loginScreen.clickLoginButton();
    }
    @Then("I will see error message for invalid email or password")
    public void iWillSeeErrorMessageForEmailPasswordInvalid() {
        Assert.assertTrue(loginScreen.checkEmailUnregisteredError().contains("Email atau password tidak valid."));
    }

    @And("I enter {string} input: password as {string}, and email as: {string}")
    public void iEnterInputPasswordAsAndEmailAs(String status, String password, String email) {
        boolean useNumbers=true;
        boolean useLetter=true;
        String randomString= RandomStringUtils.random(14,useLetter,useNumbers);
        loginScreen.fillEmailForm(email.equals("empty")?"":email.equals("previous email")?this.email:randomString+"@gmail.com");
        loginScreen.fillPasswordForm(password.equals("empty")?"":password);
    }

    @Then("I will see warning message for {string} on login page")
    public void iWillSeeWarningMessageForOnLoginPage(String errorLocation) {
        boolean result = errorLocation.equals("email")? loginScreen.checkEmailError()
                : loginScreen.checkPasswordError();
        Assert.assertTrue(result);
    }
}
