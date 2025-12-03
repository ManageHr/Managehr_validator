package co.com.Managehr.userinterface.Autentication;

import net.serenitybdd.screenplay.targets.Target;

public class LogoutPage {

    public static final Target BTN_CERRAR_SESION = Target.the("botón Cerrar Sesión")
            // Opción 1: por clase 'logout' (RECOMENDADA)
            .locatedBy("//a[contains(@class,'logout')]");

    // Si quisieras ser todavía más explícito por texto:
    // .locatedBy("//a[contains(@class,'logout') and contains(.,'Cerrar')]");
}
