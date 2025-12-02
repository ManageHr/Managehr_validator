package co.com.Managehr.userinterface.Vacaciones;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormularioVacacionesPage {

    public static final Target TXT_MOTIVO = Target
            .the("motivo de vacaciones")
            .located(By.xpath("//*[@id=\"motivo\"]"));

    public static final Target TXT_FECHA_INICIO = Target
            .the("campo fecha inicio de vacaciones")
            .located(By.xpath("//*[@id=\"fechaInicio\"]"));

    public static final Target TXT_FECHA_FIN = Target
            .the("campo fecha fin de vacaciones")
            .located(By.xpath("//*[@id=\"fechaFinal\"]"));

    public static final Target BTN_ENVIAR_SOLICITUD = Target
            .the("botón Enviar Solicitud de vacaciones")
            .located(By.xpath("/html/body/app-root/app-formvacaciones/div/div/div[2]/div/div[1]/form/button"));
}
