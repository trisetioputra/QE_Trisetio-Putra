package starter.navigation;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import starter.finder.Homepage;
import starter.finder.Loginpage;

import java.time.Duration;

public class NavigateTo {

    public static Performable theSepulsaLoginPage() {
        return Task.where("User open sepulsa login page",
                Open.browserOn().the(sepulsaLoginPage.class));
    }
    public static Performable pressSignInButton(Actor actor) {
        return Task.where("User press sign in button on login page",
                Click.on(Loginpage.submitForm)
        );
    }
    public static Performable theSepulsaHomePage() {
        return Task.where("User open sepulsa home page",
                Open.browserOn().the(sepulsaHomePage.class));
    }
    public static Performable pressProductIcon(String product) {
        return Task.where("User press sign in button on login page",
                Click.on(Homepage.getProductIcon(product))
        );
    }


//
//    public static Performable loginHeaderButton() {
//        return Task.where("User press login button on header",
//                Click.on(Homepage.loginButtonHeader));
//    }
//
//    public static Performable registerButton() {
//        return Task.where("User press registration button",
//                Click.on(Homepage.registrationButton));
//    }
//
//    public static Performable keywordButton(String keyword) {
//        return Task.where("User press keyword button",
//                Click.on(Homepage.getKeywordButton(keyword)));
//    }
}
