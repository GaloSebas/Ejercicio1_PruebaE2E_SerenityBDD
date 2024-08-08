package ec.com.screenplay.project.stepdefinition;

import ec.com.screenplay.project.tasks.LoginWhitCredentials;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static ec.com.screenplay.project.utils.Constants.*;
import static ec.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Login {
    @When("ingreso las credenciales e inicio sesión")
    public void login() {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginWhitCredentials.withCredentials());

        waiting(TIME_SHORT);
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(TheWebPage.currentUrl(), Matchers.containsString(INVENTORY_URL))
        );
    }
}


