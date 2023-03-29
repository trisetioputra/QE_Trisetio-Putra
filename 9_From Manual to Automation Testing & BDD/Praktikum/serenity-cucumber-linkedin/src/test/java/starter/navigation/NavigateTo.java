package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import starter.finder.Homepage;

public class NavigateTo {
    public static Performable theLinkedInHomePage() {
        return Task.where("User opens the LinkedIn home page",
                Open.browserOn().the(LinkedInHomePage.class));
    }

    public static Performable loginHeaderButton() {
        return Task.where("User press login button on header",
                Click.on(Homepage.loginButtonHeader));
    }

    public static Performable registerButton() {
        return Task.where("User press registration button",
                Click.on(Homepage.registrationButton));
    }

    public static Performable keywordButton(String keyword) {
        return Task.where("User press keyword button",
                Click.on(Homepage.getKeywordButton(keyword)));
    }

    public static Performable topicButton(String keyword) {
        return Task.where("User press keyword button",
                Click.on(Homepage.getTopicButton(keyword)));
    }


    public static Performable postAJobButton() {
        return Task.where("User press post a job button",
                Click.on(Homepage.createJobPostingButton));
    }

    public static Performable fillEmailAndPassword(String email, String password) {
        return Task.where("User enters email and password on form",
                Enter.theValue(email).into(Homepage.emailForm),
                Enter.theValue(password).into(Homepage.passwordForm)
        );
    }
    public static Performable submitEmailAndPassword() {
        return Task.where("User submit email and password",
                Click.on(Homepage.SignInButton)
        );
    }
}
