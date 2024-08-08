package ec.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckOutCompletePage {
    public static final Target CONFIRMATION_MESSAGE = Target.the("Purchase Confirmation Message")
            .located(By.xpath("/html/body/div/div/div/div[2]/h2"));
    public static final Target BACK_HOME_BUTTON = Target.the("Back Home Button")
            .located(By.id("back-to-products"));
}
