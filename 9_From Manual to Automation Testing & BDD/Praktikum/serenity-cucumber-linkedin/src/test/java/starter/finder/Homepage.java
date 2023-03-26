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
    public static final Target searchTerm =  Target.the("search term displayed").locatedBy(".results-context-header__query-search");

}
