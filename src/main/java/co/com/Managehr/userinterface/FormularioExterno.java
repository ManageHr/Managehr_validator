package co.com.Managehr.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class FormularioExterno {

    public static Target BTN_VER_OFERTAS = Target.the("Boton ver ofertas laborales")
            .located(By.xpath("/html/body/app-root/app-login/div/div/div[2]/button"));

    public static Target BTN_POSTULACION = Target.the("Boton de postularme")
            .located(By.xpath("/html/body/app-root/app-register/div[1]/div/div[2]/div[2]/div/div[4]/button"));

    public static Target INPUT_DOCUMENTO = Target.the("Ingreso del numero de documento")
            .located(By.id("numDocumento"));

    public static Target INPUT_NOMBRE = Target.the("Ingreso del nombre")
            .located(By.id("nombre"));

    public static Target INPUT_CORREO = Target.the("Ingreso del correo")
            .located(By.id("email"));

    public static Target INPUT_CONFIRCORREO = Target.the("Ingreso de la confirmacion del correo")
            .located(By.id("confirmEmail"));

    public static Target INPUT_CONTRASENIA = Target.the("Ingreso de la contraseña")
            .located(By.id("password"));

    public static Target INPUT_CONFIRCONTRASENIA = Target.the("Ingreso de la confirmacion de la contraseña")
            .located(By.id("confirmPassword"));

    public static Target BTN_REGISTRARSE = Target.the("Boton para confirmar el registro")
            .located(By.xpath("//*[@id=\"postulacionModal\"]/div/div/div[2]/form/div[7]/button"));

    public static Target MENSAJE_EXITO_REGISTRO = Target.the("Mensaje de éxito en registro")
            .located(By.cssSelector(".toast-success, .alert-success, .swal2-popup .swal2-html-container"));

    public static Target MENSAJE_ERROR_REGISTRO = Target.the("Mensaje de error en registro")
            .located(By.cssSelector(".toast-error, .alert-danger, .invalid-feedback, .mat-error"));

    public static Target SWEETALERT_POPUP = Target.the("SweetAlert popup")
            .located(By.cssSelector(".swal2-container .swal2-popup"));

    public static Target SWEETALERT_TITLE = Target.the("SweetAlert título")
            .located(By.id("swal2-title"));

    public static Target SWEETALERT_TEXT = Target.the("SweetAlert texto")
            .located(By.id("swal2-html-container"));
}
