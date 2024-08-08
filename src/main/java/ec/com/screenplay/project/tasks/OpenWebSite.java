package ec.com.screenplay.project.tasks;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static ec.com.screenplay.project.utils.Constants.WEB_URL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenWebSite implements Task {

    private EnvironmentVariables environmentVariables;

    @Override
    @Step("{0}Abrir el navegador Web")
    public <T extends Actor> void performAs(T actor) {

        String pathWebUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEB_URL);
        actor.attemptsTo(Open.url(pathWebUrl));
    }

    public static Performable browserURL() {

        return instrumented(OpenWebSite.class);
    }
}
