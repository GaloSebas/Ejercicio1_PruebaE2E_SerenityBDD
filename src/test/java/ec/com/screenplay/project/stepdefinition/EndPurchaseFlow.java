package ec.com.screenplay.project.stepdefinition;

import ec.com.screenplay.project.tasks.EndFlow;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static ec.com.screenplay.project.utils.Constants.*;
import static ec.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EndPurchaseFlow {
    @And("finalizo la compra")
    public void endFlow() {
        OnStage.theActorInTheSpotlight().attemptsTo(EndFlow.purchaseFlowEnds());

        String confirmationMessage = theActorInTheSpotlight().recall("confirmationMessage");

        waiting(TIME_SHORT);
        Assert.assertEquals("Validate if the text is equal to the expected", PURCHASE_CONFIRMATION_MESSAGE, confirmationMessage );
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(TheWebPage.currentUrl(), Matchers.containsString(CHECKOUT_COMPLETE_URL))
        );
    }
}
