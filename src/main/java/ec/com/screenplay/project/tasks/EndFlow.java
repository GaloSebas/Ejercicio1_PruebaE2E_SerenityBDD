package ec.com.screenplay.project.tasks;

import ec.com.screenplay.project.ui.CheckOutCompletePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EndFlow implements Task {

    @Override
    @Step("{0}Abrir el navegador Web")
    public <T extends Actor> void performAs(T actor) {

        WaitUntil.the(CheckOutCompletePage.CONFIRMATION_MESSAGE, isVisible()).forNoMoreThan(20).seconds();
        String confirmationMessage = Text.of(CheckOutCompletePage.CONFIRMATION_MESSAGE).answeredBy(actor);
        actor.remember("confirmationMessage", confirmationMessage);

        actor.attemptsTo(

                WaitUntil.the(CheckOutCompletePage.CONFIRMATION_MESSAGE, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(CheckOutCompletePage.CONFIRMATION_MESSAGE)

        );
    }

    public static Performable purchaseFlowEnds() { return instrumented(EndFlow.class); }
}
