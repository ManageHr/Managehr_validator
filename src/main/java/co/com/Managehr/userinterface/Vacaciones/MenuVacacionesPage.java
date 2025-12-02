package co.com.Managehr.userinterface.Vacaciones;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuVacacionesPage {

    public static final Target BTN_VACACIONES = Target
            .the("botón del menú Vacaciones")
            .located(By.xpath("/html/body/app-root/app-home/app-menu/div/aside/nav/a[4]"));
}
