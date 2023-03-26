package starter.finder;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class Homepage {

    public static final Target buttonHome =  Target.the("home icon button").locatedBy("#button_home");

    public static Target getProductIcon(String product){
        return Target.the("product button icon").locatedBy(".product-name").containingText(product);
    }


}
