package ec.com.screenplay.project.tasks;

import ec.com.screenplay.project.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateCartItems implements Task {

    @Override
    @Step("{0} Ingresa credenciales e inicia sesión")
    public <T extends Actor> void performAs(T actor) {

        //Get info from the items in the cart
        WaitUntil.the(CartPage.ITEM_1_NAME, isVisible()).forNoMoreThan(20).seconds();
        String cartProduct1Name = Text.of(CartPage.ITEM_1_NAME).answeredBy(actor);
        String cartProduct2Name = Text.of(CartPage.ITEM_2_NAME).answeredBy(actor);
        String cartProduct1Description = Text.of(CartPage.ITEM_1_DESCRIPTION).answeredBy(actor);
        String cartProduct2Description = Text.of(CartPage.ITEM_2_DESCRIPTION).answeredBy(actor);
        String cartProduct1Price = Text.of(CartPage.ITEM_1_PRICE).answeredBy(actor);
        String cartProduct2Price = Text.of(CartPage.ITEM_2_PRICE).answeredBy(actor);

        //Store the data from the cart
        actor.remember("cartProduct1Name", cartProduct1Name);
        actor.remember("cartProduct2Name", cartProduct2Name);
        actor.remember("cartProduct1Description", cartProduct1Description);
        actor.remember("cartProduct2Description", cartProduct2Description);
        actor.remember("cartProduct1Price", cartProduct1Price);
        actor.remember("cartProduct2Price", cartProduct2Price);

        actor.attemptsTo(
                WaitUntil.the(CartPage.CHECKOUT_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(CartPage.CHECKOUT_BUTTON)
        );
    }

    public static Performable withItemsAdded() {
        return instrumented(ValidateCartItems.class);
    }
}


