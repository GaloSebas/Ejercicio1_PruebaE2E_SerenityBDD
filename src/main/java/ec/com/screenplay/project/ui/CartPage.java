package ec.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target ITEM_1_NAME = Target.the("Name of the item 1 in the cart")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div"));
    public static final Target ITEM_2_NAME = Target.the("Name of the item 2 in the cart")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div"));
    public static final Target ITEM_1_DESCRIPTION = Target.the("Description of the item 1 in the cart")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[1]"));
    public static final Target ITEM_2_DESCRIPTION = Target.the("Description of the item 2 in the cart")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/div[1]"));
    public static final Target ITEM_1_PRICE = Target.the("Price of the item 1 in the cart")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div"));
    public static final Target ITEM_2_PRICE = Target.the("Price of the item 2 in the cart")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/div[2]/div"));
    public static final Target CHECKOUT_BUTTON = Target.the("CheckOut Button")
            .located(By.id("checkout"));

}
