package test.automation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import test.automation.pages.HomeScreen;
import test.automation.pages.LoginScreen;
import test.automation.pages.RegistrationScreen;

public class RegistrationSteps {
    @Steps
    RegistrationScreen registrationScreen = new RegistrationScreen();

    @When("I press login button")
    public void iPressLoginButton() {
        registrationScreen.clickLoginButtonOnHomepage();
    }

    @And("I press register hyperlink")
    public void iPressRegisterHyperlink() {
        registrationScreen.clickRegisterHyperlink();
    }

    @And("I enter {string} full name as {string}, password as {string}, and email as: {string}")
    public void iEnterValidFullNameAsFullNamePasswordAsPasswordAndEmailAsEmail(String status, String fullname, String password, String email) {
        if(email.equals("randomized email")){
            boolean useNumbers=true;
            boolean useLetter=true;
            String randomString= RandomStringUtils.random(14,useLetter,useNumbers);
            registrationScreen.fillEmailForm(randomString+"@gmail.com");
            LoginSteps.email=randomString+"@gmail.com";
        }
        else{
            registrationScreen.fillEmailForm(email.equals("empty")?"":email);
        }
        registrationScreen.fillFullNameForm(fullname.equals("empty")?"":fullname);
        registrationScreen.fillPasswordForm(password.equals("empty")?"":password);
    }

    @And("I press register button")
    public void iPressRegisterButton() {
        registrationScreen.clickRegisterButton();
    }

    @Then("I will be directed to home page")
    public void iWillBeDirectedToLoginPage() {
        registrationScreen.isOnHomepage();
    }

    @Then("I will see warning message for {string}")
    public void iWillSeeWarningMessageFor(String errorLocation) {
        boolean result = errorLocation.equals("fullname")? registrationScreen.checkFullNameError()
                : errorLocation.equals("email")? registrationScreen.checkEmailError()
                : registrationScreen.checkPasswordError();
        Assert.assertTrue(result);
    }

    @Then("I will stay on registration page")
    public void iWillStayOnRegistrationPage() {
        registrationScreen.isOnRegistrationPage();
    }
}
