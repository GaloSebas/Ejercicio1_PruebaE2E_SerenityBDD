package ec.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckOutPage {
    public static final Target PRICE_TOTAL = Target.the("Price Total")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[6]"));
    public static final Target TAX = Target.the("Tax")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[7]"));
    public static final Target TOTAL = Target.the("Total")
            .located(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]"));
    public static final Target FINISH_BUTTON = Target.the("Finish Button")
            .located(By.id("finish"));
}
