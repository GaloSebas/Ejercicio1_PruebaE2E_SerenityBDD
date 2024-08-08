package ec.com.screenplay.project.ui;

import ec.com.screenplay.project.utils.RandomNumberGenerator;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {

    private static final int[] RANDOM_NUMBERS = RandomNumberGenerator.generateUniqueRandomNumbers();
    private static final int PRODUCT_1_NUMBER = RANDOM_NUMBERS[0];
    private static final int PRODUCT_2_NUMBER = RANDOM_NUMBERS[1];

    // Constructor privado para evitar la instanciación
    private InventoryPage() {
        throw new AssertionError("No se puede instanciar la clase InventoryPage");
    }

    public static final Target PRODUCT_1 = Target.the("Product 1")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[" + PRODUCT_1_NUMBER + "]/div[2]/div[1]/a/div"));

    public static final Target PRODUCT_2 = Target.the("Product 2")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[" + PRODUCT_2_NUMBER + "]/div[2]/div[1]/a/div"));
    public static final Target CART_BUTTON = Target.the("Cart Button")
            .located(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
}


