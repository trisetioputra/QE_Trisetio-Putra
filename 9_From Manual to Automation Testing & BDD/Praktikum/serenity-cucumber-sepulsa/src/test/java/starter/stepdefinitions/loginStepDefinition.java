package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Product;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;
import starter.finder.*;
import starter.navigation.NavigateTo;

public class loginStepDefinition {

    Loginpage loginpage = new Loginpage();

    @Given("{actor} open sepulsa.com login page")
    public void onTheLoginPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSepulsaLoginPage());
    }

    @When("{actor} enter credentials on {string} and {string} fields")
    public void enterValidCredentials(Actor actor, String email, String password) {
        actor.attemptsTo(
                loginpage.enterCredentials(email, password)
        );
    }

    @And("{actor} press submit button")
    public void pressSubmitButton(Actor actor) {
        actor.attemptsTo(
                NavigateTo.pressSignInButton(actor)
        );
    }

    @Then("{actor} will successfully redirect to homepage")
    public void onHomepage(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(Homepage.buttonHome, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds()
        );
//        Assert.assertEquals(Serenity.getDriver().getCurrentUrl(),"https://www.sepulsa.com/");
    }

    @Then("{actor} will see error message")
    public void userWillSeeErrorMessage(Actor actor) {
        actor.wasAbleTo(
                WaitUntil.the(Loginpage.errorMessage, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds(),
                Ensure.that(Loginpage.errorMessage).text().contains("Masih ada yang salah nih")
        );
    }

    @Given("{actor} open sepulsa.com homepage")
    public void onTheHomePage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSepulsaHomePage());
    }

    @When("{actor} press at {string} product icon")
    public void selectProductIcon(Actor actor, String product) {
        actor.attemptsTo(
                NavigateTo.pressProductIcon(product)
        );
    }

    @Then("{actor} will be directed to the correct {string} product page")
    public void directedToProductPage(Actor actor, String product) {
        actor.wasAbleTo(
                Ensure.that(ProductPage.headerTitle).text().contains(product)
        );
    }

    @And("{actor} enter {string} at form field")
    public void entersPhoneNumber(Actor actor, String phoneNumber) {
        actor.attemptsTo(
                ProductPage.enterPhoneNumber(phoneNumber)
        );
    }

    @And("{actor} select the first pulsa package")
    public void selectFirstPulsaPackage(Actor actor) {
        actor.attemptsTo(
                ProductPage.selectPulsaPackage()
        );
    }

    @Then("{actor} will be directed to payment page")
    public void directedToPaymentPage(Actor actor) {
        actor.wasAbleTo(
                WaitUntil.the(PaymentPage.detailPembayaran, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds()
        );
    }

    @Then("{actor} enter valid {string} at form field")
    public void enterEmailAtPayment(Actor actor, String email) {
        actor.wasAbleTo(
                PaymentPage.enterEmail(email)
        );
    }

    @And("{actor} select payment method")
    public void selectPaymentMethod(Actor actor) {
        actor.wasAbleTo(
                PaymentPage.selectPaymentMethod()
        );
    }

    @And("{actor} select Bayar Sekarang button")
    public void selectPaymentButton(Actor actor) {
        actor.wasAbleTo(
                Click.on(PaymentPage.paymentButton)
        );
    }

    @Then("{actor} will be directed to finish transaction page")
    public void directToFinishTransactionPage(Actor actor) {
        actor.wasAbleTo(
                WaitUntil.the(TransactionPage.backToHomeButton, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds()
        );
        //Memastikan sudah pindah halaman dari /checkout
        Assert.assertNotSame("https://www.sepulsa.com/transaction/checkout", Serenity.getDriver().getCurrentUrl());
    }
}