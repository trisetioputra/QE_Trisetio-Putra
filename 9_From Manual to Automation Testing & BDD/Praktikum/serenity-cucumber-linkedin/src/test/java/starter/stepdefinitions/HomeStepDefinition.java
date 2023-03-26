package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.finder.Homepage;
import starter.navigation.NavigateTo;

public class HomeStepDefinition {

    Homepage homepage= new Homepage();
    @When("{actor} try to open linkedIn homepage")
    public void onTheLoginPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theLinkedInHomePage());
    }

    @Then("{actor} will see linkedIn homepage")
    public void should_see_information_about(Actor actor) {
        actor.attemptsTo(
                Ensure.that(homepage.title).hasText("LinkedIn")
        );
    }

    @And("{actor} press login button on header")
    public void pressLoginButtonOnHeader(Actor actor) {
        actor.wasAbleTo(NavigateTo.loginHeaderButton());
    }

    @Then("{actor} will be directed to login page")
    public void userOnLoginPage(Actor actor) {
        actor.attemptsTo(
                Ensure.that(homepage.loginTextOnLoginPage).hasText("Sign in")
        );
    }

    @And("{actor} press register button for new user")
    public void pressRegisterButton(Actor actor) {
        actor.wasAbleTo(NavigateTo.registerButton());
    }

    @Then("{actor} will be directed to registration page")
    public void userWillSeeRegistrationPage(Actor actor) {
        actor.attemptsTo(
                Ensure.that(homepage.registrationTextOnButton).hasText("Agree & Join")
        );
    }
    @And("{actor} press {string} recommendation")
    public void pressKeywordTerm(Actor actor, String keyword) {
        actor.wasAbleTo(NavigateTo.keywordButton(keyword));
    }
    @Then("{actor} will be directed to job search page for the recommended {string}")
    public void userWillSeeSearchPage(Actor actor, String keyword) {
        actor.attemptsTo(
                Ensure.that(homepage.searchTerm).text().contains(keyword)
        );
    }
}
