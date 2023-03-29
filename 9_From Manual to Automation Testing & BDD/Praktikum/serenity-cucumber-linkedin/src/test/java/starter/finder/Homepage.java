package starter.finder;

import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.targets.Target;

public class Homepage {

    public static final Target title =  Target.the("page title").locatedBy(".sr-only");
    public static final Target loginButtonHeader =  Target.the("login button on header").locatedBy(".nav__button-secondary");
    public static final Target loginTextOnLoginPage =  Target.the("Sign in word on login page").locatedBy(".header__content__heading");

    public static final Target registrationButton =  Target.the("register now button").locatedBy(".sign-in-form__join-cta");

    public static final Target registrationTextOnButton =  Target.the("register button").locatedBy("#join-form-submit");

    public static Target getKeywordButton(String keyword){
        return Target.the("keyword button").locatedBy(".btn-md").containingText(keyword);
    }

    public static Target getTopicButton(String keyword){
        return Target.the("keyword button").locatedBy(".btn-md").containingText(keyword);
    }
    public static final Target searchTerm =  Target.the("search term displayed").locatedBy(".results-context-header__query-search");

    public static final Target topicTitle =  Target.the("topic title shown").locatedBy(".core-section-container__main-title");

    public static final Target createJobPostingButton =  Target.the("create job posting").locatedBy(".btn-md").containingText("Post a job");

    public static final Target emailForm =  Target.the("emailForm locator").locatedBy("#session_key");

    public static final Target passwordForm =  Target.the("password locator").locatedBy("#session_password");
    public static final Target SignInButton =  Target.the("Sign in button locator").locatedBy(".sign-in-form__submit-btn--full-width");
    public static final Target errorMessageOnSignIn =  Target.the("error message locator - sign in page").locatedBy("#error-for-username");

}
