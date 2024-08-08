package ec.com.screenplay.project.tasks;

import ec.com.screenplay.project.ui.CheckOutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateCheckOut implements Task {

    private static final String NON_NUMERIC_REGEX = "[^\\d.]";

    @Override
    @Step("{0} Validar la pantalla del checkout")
    public <T extends Actor> void performAs(T actor) {

        WaitUntil.the(CheckOutPage.PRICE_TOTAL, isVisible()).forNoMoreThan(20).seconds();
        String priceTotal = Text.of(CheckOutPage.PRICE_TOTAL).answeredBy(actor);
        String product1Price = theActorInTheSpotlight().recall("product1Price");
        String product2Price = theActorInTheSpotlight().recall("product2Price");

        // Remove any alphabetical character (But the dot .)
        String cleanProduct1Price = product1Price.replaceAll(NON_NUMERIC_REGEX, "");
        String cleanProduct2Price = product2Price.replaceAll(NON_NUMERIC_REGEX, "");
        String cleanPriceTotal = priceTotal.replaceAll(NON_NUMERIC_REGEX, "");

        // Change from string to int
        double price1 = Double.parseDouble(cleanProduct1Price);
        double price2 = Double.parseDouble(cleanProduct2Price);
        double checkOutPriceTotal = Double.parseDouble(cleanPriceTotal);

        // Sum up the price total
        double totalPrice = price1 + price2;

        actor.remember("totalPrice", totalPrice);
        actor.remember("checkOutPriceTotal", checkOutPriceTotal);

        actor.attemptsTo(
                WaitUntil.the(CheckOutPage.FINISH_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(CheckOutPage.FINISH_BUTTON)
        );
    }

    public static Performable totalValidation() {
        return instrumented(ValidateCheckOut.class);
    }
}
