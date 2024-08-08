package ec.com.screenplay.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/TestPurchaseFlow.feature",
        glue = "ec.com.screenplay.project.stepdefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@exitoso"
)
public class RunnerPurchaseFlow {

}
