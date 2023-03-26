package starter.finder;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class PaymentPage {
    public static final Target detailPembayaran =  Target.the("detail pembayaran text").locatedBy("#checkout_detail");
    public static final Target emailForm =  Target.the("form email").locatedBy("#guest_email");
    public static final Target checkBoxPayment =  Target.the("checkbox payment").locatedByFirstMatching(".MuiListItem-gutters");
    public static final Target paymentButton =  Target.the("pay button").locatedByFirstMatching("#submit_payment");

    public static Performable enterEmail(String email) {
        return Task.where("User enters email",
                Enter.theValue(email)
                        .into(emailForm)
        );
    }

    public static Performable selectPaymentMethod() {
        return Task.where("User enters email",
                Click.on(checkBoxPayment)
        );
    }
}
