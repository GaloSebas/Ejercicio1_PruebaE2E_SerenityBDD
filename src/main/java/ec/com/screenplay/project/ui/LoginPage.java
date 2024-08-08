package ec.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USER_NAME_INPUT_FIELD = Target.the("UserName Input Field")
            .located(By.id("user-name"));
    public static final Target PASSWORD_INPUT_FIELD = Target.the("Password Input Field")
            .located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("Login Button")
            .located(By.id("login-button"));

}
