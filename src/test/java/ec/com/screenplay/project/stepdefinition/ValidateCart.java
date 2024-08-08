package ec.com.screenplay.project.stepdefinition;

import ec.com.screenplay.project.tasks.ValidateCartItems;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import org.hamcrest.Matchers;

import static ec.com.screenplay.project.utils.Constants.TIME_SHORT;
import static ec.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidateCart {
    @And("valido que el carrito contiene los dos productos")
    public void CartValidation() {

        OnStage.theActorInTheSpotlight().attemptsTo(ValidateCartItems.withItemsAdded());

        waiting(TIME_SHORT);
        // Get the products data from the inventory
        String product1Name = theActorInTheSpotlight().recall("product1Name");
        String product1Description = theActorInTheSpotlight().recall("product1Description");
        String product1Price = theActorInTheSpotlight().recall("product1Price");
        String product2Name = theActorInTheSpotlight().recall("product2Name");
        String product2Description = theActorInTheSpotlight().recall("product2Description");
        String product2Price = theActorInTheSpotlight().recall("product2Price");

        // Get the products data from the cart
        String cartProduct1Name = theActorInTheSpotlight().recall("cartProduct1Name");
        String cartProduct1Description = theActorInTheSpotlight().recall("cartProduct1Description");
        String cartProduct1Price = theActorInTheSpotlight().recall("cartProduct1Price");
        String cartProduct2Name = theActorInTheSpotlight().recall("cartProduct2Name");
        String cartProduct2Description = theActorInTheSpotlight().recall("cartProduct2Description");
        String cartProduct2Price = theActorInTheSpotlight().recall("cartProduct2Price");

        // Assertions
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Product 1 Name", actor -> cartProduct1Name, Matchers.equalTo(product1Name)),
                GivenWhenThen.seeThat("Product 1 Description", actor -> cartProduct1Description, Matchers.equalTo(product1Description)),
                GivenWhenThen.seeThat("Product 1 Price", actor -> cartProduct1Price, Matchers.equalTo(product1Price)),
                GivenWhenThen.seeThat("Product 2 Name", actor -> cartProduct2Name, Matchers.equalTo(product2Name)),
                GivenWhenThen.seeThat("Product 2 Description", actor -> cartProduct2Description, Matchers.equalTo(product2Description)),
                GivenWhenThen.seeThat("Product 2 Price", actor -> cartProduct2Price, Matchers.equalTo(product2Price))
        );

    }
}


