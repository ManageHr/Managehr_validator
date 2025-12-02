package co.com.Managehr.userinterface.Vacaciones;


import net.serenitybdd.screenplay.targets.Target;

public class MensajeVacacionesPage {

    public static final Target LBL_TITULO_EXITO = Target.the("título del mensaje de éxito")
            .locatedBy("//h2[@id='swal2-title' and contains(.,'Éxito')]");

    public static final Target LBL_MENSAJE_CONFIRMACION = Target.the("mensaje de éxito de vacaciones")
            .locatedBy("//div[@id='swal2-html-container']");

    public static final Target BTN_OK = Target.the("botón OK del mensaje de éxito")
            .locatedBy("//button[contains(@class,'swal2-confirm') and contains(.,'OK')]");
}
