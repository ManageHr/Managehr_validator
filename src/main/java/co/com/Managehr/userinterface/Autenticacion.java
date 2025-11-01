package co.com.Managehr.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class Autenticacion extends PageObject {
    public static Target INPUT_USUARIO = Target.the("Ingreso del usuario").
            located(By.id("loginEmail"));
    public static Target INPUT_CLAVE = Target.the("Ingreso el password").
            located(By.id("loginPassword"));
    public static Target BTN_INICIOSESION = Target.the("click boton inicio sesion")
            .located(By.cssSelector("button[type='submit']"));

    public static Target MENSAJE_LOGIN = Target.the("mensaje de login")
            .locatedBy("//div[contains(@class, 'alert-danger')]");
    public static Target BTN_VER_OFERTAS = Target.the("boton ver ofertas laborales")
            .located(By.cssSelector("button[routerlink*='register']"));
}
