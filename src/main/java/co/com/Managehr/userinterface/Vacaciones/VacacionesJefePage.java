package co.com.Managehr.userinterface.Vacaciones;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VacacionesJefePage {

    public static final Target BTN_APROBAR_SOLICITUD = Target.the("botón Aprobar solicitud en la lista")
            .located(By.xpath("/html/body/app-root/app-vacaciones-jefe/div/div/div[3]/div[1]/table/tbody/tr[1]/td[8]/div/button[1]"));

    public static final Target BTN_MODAL_APROBAR = Target.the("botón Aprobar en el modal de confirmación")
            .located(By.xpath("/html/body/app-root/app-vacaciones-jefe/div[2]/div/div/div[4]/button[2]"));
}
