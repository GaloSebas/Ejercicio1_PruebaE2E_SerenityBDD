package ec.com.screenplay.project.stepdefinition;

import ec.com.screenplay.project.tasks.FulfillPurchaseForm;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static ec.com.screenplay.project.utils.Constants.*;
import static ec.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompletePurchaseForm {
    @When("completo el formulario de compra con {string} {string} {string}")
    public void completeForm(String name, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(FulfillPurchaseForm.fillForm(name, lastName, postalCode));

        waiting(TIME_SHORT);
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(TheWebPage.currentUrl(), Matchers.containsString(CHECKOUT_URL))
        );
    }
}
