package ec.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckOutFormPage {
    public static final Target FIRST_NAME_INPUT_FIELD = Target.the("First Name Input Field")
            .located(By.id("first-name"));
    public static final Target LAST_NAME_INPUT_FIELD = Target.the("Last Name Input Field")
            .located(By.id("last-name"));
    public static final Target POSTAL_CODE_INPUT_FIELD = Target.the("Postal Code Input Field")
            .located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("Continue Button")
            .located(By.id("continue"));
}
