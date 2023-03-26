package starter.finder;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class Loginpage {

    public static final Target emailForm =  Target.the("email Form").locatedBy("#email");
    public static final Target passwordForm =  Target.the("passwrod form").locatedBy("#password");

    public static final Target submitForm =  Target.the("submit login button").locatedBy("#submit_login");

    public static final Target errorMessage =  Target.the("submit login button").locatedBy("#alert_description");

    public static Performable enterCredentials(String email, String password) {
        return Task.where("User enters credentials",
                Enter.theValue(email)
                        .into(emailForm),
                Enter.theValue(password)
                        .into(passwordForm)
        );
    }
}
