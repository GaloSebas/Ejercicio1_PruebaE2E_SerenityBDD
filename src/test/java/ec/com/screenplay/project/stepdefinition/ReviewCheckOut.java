package ec.com.screenplay.project.stepdefinition;

import ec.com.screenplay.project.tasks.ValidateCheckOut;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static ec.com.screenplay.project.utils.Constants.TIME_SHORT;
import static ec.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReviewCheckOut {
    @Then("verifico el resumen de la compra")
    public void checkOutValidation() {
        OnStage.theActorInTheSpotlight().attemptsTo(ValidateCheckOut.totalValidation());

        waiting(TIME_SHORT);
        // Get the total values
        double currentTotalPrice = theActorInTheSpotlight().recall("totalPrice");
        double checkOutTotalPrice = theActorInTheSpotlight().recall("checkOutPriceTotal");

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Price Total", actor -> currentTotalPrice, Matchers.equalTo(checkOutTotalPrice))
                );
    }
}
