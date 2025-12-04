package co.com.Managehr.userinterface.Autentication;

import net.serenitybdd.screenplay.targets.Target;

public class LogoutPage {

    public static final Target BTN_CERRAR_SESION = Target.the("botón Cerrar Sesión")
            .locatedBy("//a[contains(@class,'logout')]");

}
