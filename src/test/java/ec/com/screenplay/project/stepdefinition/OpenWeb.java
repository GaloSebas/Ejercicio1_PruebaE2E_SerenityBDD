package ec.com.screenplay.project.stepdefinition;

import ec.com.screenplay.project.tasks.OpenWebSite;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static ec.com.screenplay.project.utils.Constants.TIME_SHORT;
import static ec.com.screenplay.project.utils.Constants.TITLE;
import static ec.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OpenWeb {

    @Before
    public void setTheStage() { OnStage.setTheStage(new OnlineCast()); }

    @Given("que {string} accede al sitio web de prueba Saucedemo")
    public void openWebSite(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(OpenWebSite.browserURL());

        waiting(TIME_SHORT);
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(TheWebPage.title(), Matchers.containsString(TITLE))
        );
    }
}
