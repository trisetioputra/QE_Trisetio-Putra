package starter.finder;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {
    public static final Target headerTitle =  Target.the("Page title text").locatedBy(".title-main");
    public static final Target phoneNumberForm =  Target.the("phone number form").locatedBy("#phone_number");
    public static final Target pulsaPackage =  Target.the("pulsa package").locatedBy(".nominal-item").containingText("Rp100.000");

    public static Performable enterPhoneNumber(String phoneNumber) {
        return Task.where("User enters phone number",
                Enter.theValue(phoneNumber)
                        .into(phoneNumberForm)
        );
    }

    public static Performable selectPulsaPackage() {
        return Task.where("User select first pulsa package",
                Click.on(pulsaPackage)
        );
    }
}
