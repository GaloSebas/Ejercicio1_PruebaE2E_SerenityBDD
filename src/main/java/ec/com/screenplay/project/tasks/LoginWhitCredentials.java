package ec.com.screenplay.project.tasks;

import ec.com.screenplay.project.ui.LoginPage;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static ec.com.screenplay.project.utils.Constants.USERNAME;
import static ec.com.screenplay.project.utils.Constants.PASSWORD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginWhitCredentials implements Task {

    private EnvironmentVariables environmentVariables;

    @Override
    @Step("{0} Ingresa credenciales e inicia sesión")
    public <T extends Actor> void performAs(T actor) {
        String username = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(USERNAME);
        String password = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(PASSWORD);

        actor.attemptsTo(
                WaitUntil.the(LoginPage.USER_NAME_INPUT_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(username).into(LoginPage.USER_NAME_INPUT_FIELD),
                WaitUntil.the(LoginPage.PASSWORD_INPUT_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(password).into(LoginPage.PASSWORD_INPUT_FIELD),
                WaitUntil.the(LoginPage.LOGIN_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    public static Performable withCredentials() {
        return instrumented(LoginWhitCredentials.class);
    }
}
