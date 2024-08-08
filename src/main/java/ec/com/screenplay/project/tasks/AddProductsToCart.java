package ec.com.screenplay.project.tasks;

import ec.com.screenplay.project.ui.InventoryPage;
import ec.com.screenplay.project.ui.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductsToCart implements Task {

    @Override
    @Step("{0} Selección de dos productos al carrito y visualización del carrito")
    public <T extends Actor> void performAs(T actor) {

        // Select Product 1
        actor.attemptsTo(
                WaitUntil.the(InventoryPage.PRODUCT_1, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(InventoryPage.PRODUCT_1)
        );

        // Get Product 1 data
        WaitUntil.the(ProductPage.PRODUCT_NAME, isVisible()).forNoMoreThan(20).seconds();
        String product1Name = Text.of(ProductPage.PRODUCT_NAME).answeredBy(actor);
        String product1Description = Text.of(ProductPage.PRODUCT_DESCRIPTION).answeredBy(actor);
        String product1Price = Text.of(ProductPage.PRODUCT_PRICE).answeredBy(actor);

        // Store Product 1 data
        actor.remember("product1Name", product1Name);
        actor.remember("product1Description", product1Description);
        actor.remember("product1Price", product1Price);

        // Add Product 1 to the cart
        actor.attemptsTo(
                Click.on(ProductPage.ADD_TO_CART_BUTTON),
                WaitUntil.the(ProductPage.RETURN_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(ProductPage.RETURN_BUTTON)
        );

        // Select Product 2
        actor.attemptsTo(
                WaitUntil.the(InventoryPage.PRODUCT_2, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(InventoryPage.PRODUCT_2)
        );

        // Get Product 2 data
        WaitUntil.the(ProductPage.PRODUCT_NAME, isVisible()).forNoMoreThan(20).seconds();
        String product2Name = Text.of(ProductPage.PRODUCT_NAME).answeredBy(actor);
        String product2Description = Text.of(ProductPage.PRODUCT_DESCRIPTION).answeredBy(actor);
        String product2Price = Text.of(ProductPage.PRODUCT_PRICE).answeredBy(actor);

        // Store Product 2 data
        actor.remember("product2Name", product2Name);
        actor.remember("product2Description", product2Description);
        actor.remember("product2Price", product2Price);

        // Add Product 2 to the cart
        actor.attemptsTo(
                Click.on(ProductPage.ADD_TO_CART_BUTTON),
                WaitUntil.the(ProductPage.RETURN_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(ProductPage.RETURN_BUTTON)
        );

        // Go to the cart page
        actor.attemptsTo(
                WaitUntil.the(InventoryPage.CART_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(InventoryPage.CART_BUTTON)
        );
    }

    public static Performable addProducts() {
        return instrumented(AddProductsToCart.class);
    }
}
