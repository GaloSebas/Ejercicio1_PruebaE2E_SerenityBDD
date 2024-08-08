package ec.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {
    public static final Target PRODUCT_NAME = Target.the("Product Name")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[1]"));
    public static final Target PRODUCT_DESCRIPTION = Target.the("Product Description")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[2]"));
    public static final Target PRODUCT_PRICE = Target.the("Product Price")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[3]"));
    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to Cart Button")
            .located(By.id("add-to-cart"));
    public static final Target RETURN_BUTTON = Target.the("Back to Products Button")
            .located(By.id("back-to-products"));
}
