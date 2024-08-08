package ec.com.screenplay.project.tasks;

import ec.com.screenplay.project.ui.CheckOutFormPage;
import ec.com.screenplay.project.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FulfillPurchaseForm implements Task {

    public final String name;
    public final String lastName;
    public final String postalCode;

    public FulfillPurchaseForm(String name, String lastName, String postalCode) {
        this.name = name;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }
    @Override
    @Step("{0} Completo el formulario de compra")
    public <T extends Actor> void performAs(T actor) {

        // Select Product 1
        actor.attemptsTo(
                WaitUntil.the(CheckOutFormPage.FIRST_NAME_INPUT_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(name).into(CheckOutFormPage.FIRST_NAME_INPUT_FIELD),
                WaitUntil.the(CheckOutFormPage.LAST_NAME_INPUT_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(lastName).into(CheckOutFormPage.LAST_NAME_INPUT_FIELD),
                WaitUntil.the(CheckOutFormPage.POSTAL_CODE_INPUT_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(postalCode).into(CheckOutFormPage.POSTAL_CODE_INPUT_FIELD),
                WaitUntil.the(CheckOutFormPage.CONTINUE_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(CheckOutFormPage.CONTINUE_BUTTON)
        );
    }

    public static Performable fillForm(String name, String lastName, String postalCode) {
        return instrumented(FulfillPurchaseForm.class, name, lastName, postalCode);
    }
}
