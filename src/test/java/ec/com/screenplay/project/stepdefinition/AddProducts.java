package ec.com.screenplay.project.stepdefinition;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import ec.com.screenplay.project.tasks.AddProductsToCart;

public class AddProducts {
    @Then("agrego dos productos al carrito")
    public void addProducts() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddProductsToCart.addProducts());
    }
}
