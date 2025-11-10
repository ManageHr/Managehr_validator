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
    public static Target MENSAJE_ERROR = Target.the("Mensaje de error de login")
            .located(By.xpath("/html/body/app-root/app-login/div/div/div[1]/form/div[4]"));

}
