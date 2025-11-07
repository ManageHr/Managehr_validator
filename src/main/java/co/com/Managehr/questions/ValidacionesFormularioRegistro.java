package co.com.Managehr.questions;

import co.com.Managehr.userinterface.FormularioExterno;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidacionesFormularioRegistro implements Question<Object> {

    public enum TipoValidacion {
        BOTON_REGISTRAR_HABILITADO,
        MENSAJE_EXITO,
        MENSAJE_ERROR_DUPLICADO,
        MENSAJE_VALIDACION_CAMPO,
        FORM_VISIBLE
    }

    private final TipoValidacion tipo;
    private final String parametro; // para el caso de MENSAJE_VALIDACION_CAMPO

    public ValidacionesFormularioRegistro(TipoValidacion tipo) {
        this.tipo = tipo;
        this.parametro = null;
    }

    public ValidacionesFormularioRegistro(TipoValidacion tipo, String parametro) {
        this.tipo = tipo;
        this.parametro = parametro;
    }

    // ==== Constructores estáticos "fluent" ====
    public static ValidacionesFormularioRegistro botonRegistrarHabilitado() {
        return new ValidacionesFormularioRegistro(TipoValidacion.BOTON_REGISTRAR_HABILITADO);
    }

    public static ValidacionesFormularioRegistro mensajeExito() {
        return new ValidacionesFormularioRegistro(TipoValidacion.MENSAJE_EXITO);
    }

    public static ValidacionesFormularioRegistro errorDuplicado() {
        return new ValidacionesFormularioRegistro(TipoValidacion.MENSAJE_ERROR_DUPLICADO);
    }

    /** Ejemplo: ValidacionesFormularioRegistro.errorCampo("correo") */
    public static ValidacionesFormularioRegistro errorCampo(String nombreCampo) {
        return new ValidacionesFormularioRegistro(TipoValidacion.MENSAJE_VALIDACION_CAMPO, nombreCampo);
    }

    public static ValidacionesFormularioRegistro formularioVisible() {
        return new ValidacionesFormularioRegistro(TipoValidacion.FORM_VISIBLE);
    }

    @Override
    public Object answeredBy(Actor actor) {
        try {
            switch (tipo) {
                case BOTON_REGISTRAR_HABILITADO:
                    return validarBotonRegistrar(actor);

                case MENSAJE_EXITO:
                    return capturarMensajeExito(actor);

                case MENSAJE_ERROR_DUPLICADO:
                    return validarErrorDuplicado(actor);

                case MENSAJE_VALIDACION_CAMPO:
                    return capturarErrorPorCampo(actor, parametro);

                case FORM_VISIBLE:
                    return validarFormularioVisible(actor);

                default:
                    return false;
            }
        } catch (Exception e) {
            System.out.println("[ValidacionesRegistro] Error en " + tipo + ": " + e.getMessage());
            // Devuelve valores razonables según el tipo
            if (tipo == TipoValidacion.MENSAJE_EXITO || tipo == TipoValidacion.MENSAJE_VALIDACION_CAMPO) {
                return "No fue posible obtener el mensaje";
            }
            return false;
        }
    }

    // ====== Implementaciones privadas ======

    private Boolean validarBotonRegistrar(Actor actor) {
        boolean habilitado = FormularioExterno.BTN_REGISTRARSE.resolveFor(actor).isEnabled();
        System.out.println("[ValidacionesRegistro] BTN_REGISTRARSE habilitado: " + habilitado);
        return habilitado;
    }

    private String capturarMensajeExito(Actor actor) {
        try {
            if (FormularioExterno.MENSAJE_EXITO_REGISTRO.resolveFor(actor).isVisible()) {
                String msg = Text.of(FormularioExterno.MENSAJE_EXITO_REGISTRO).viewedBy(actor).asString();
                if (msg != null && !msg.trim().isEmpty()) {
                    System.out.println("[ValidacionesRegistro] Éxito (UI): " + msg);
                    return msg;
                }
            }
        } catch (Exception ignored) {}

        try {
            Target toastSuccess = Target.the("toast éxito")
                    .located(By.cssSelector(".toast-success, .alert-success, .swal2-popup .swal2-html-container"));
            if (toastSuccess.resolveFor(actor).isVisible()) {
                String msg = Text.of(toastSuccess).viewedBy(actor).asString();
                System.out.println("[ValidacionesRegistro] Éxito (fallback): " + msg);
                return msg;
            }
        } catch (Exception ignored) {}

        return "No se encontró mensaje de éxito";
    }

    private Boolean validarErrorDuplicado(Actor actor) {
        String xpath = "//div[contains(@id,'swal2-html-container') or contains(@class,'alert-danger') or contains(@class,'invalid-feedback')]" +
                "[contains(., 'ya existe') or contains(., 'en uso') or contains(., 'duplicado')]";
        try {
            Target msgDuplicado = Target.the("mensaje error duplicado").located(By.xpath(xpath));
            boolean visible = msgDuplicado.resolveFor(actor).isVisible();
            System.out.println("[ValidacionesRegistro] Error duplicado visible: " + visible);
            return visible;
        } catch (Exception e) {
            System.out.println("[ValidacionesRegistro] No se pudo validar duplicado: " + e.getMessage());
            return false;
        }
    }

    private String capturarErrorPorCampo(Actor actor, String nombreCampo) {
        Target input = mapearCampoAInput(nombreCampo);
        if (input == null) {
            return "Campo no mapeado: " + nombreCampo;
        }

        try {
            String xpathHermano = ".//following-sibling::*[contains(@class,'invalid-feedback') or contains(@class,'mat-error') or contains(@class,'error')]";
            Target errorDebajo = Target.the("mensaje error debajo del campo")
                    .locatedBy(input.getCssOrXPathSelector() + xpathHermano);

            if (errorDebajo.resolveFor(actor).isVisible()) {
                String msg = Text.of(errorDebajo).viewedBy(actor).asString();
                System.out.println("[ValidacionesRegistro] Error en " + nombreCampo + ": " + msg);
                return msg;
            }
        } catch (Exception ignored) {}

        try {
            String selector = input.getCssOrXPathSelector();
            Target errorPorAria = Target.the("error por aria-describedby")
                    .located(By.xpath("(" + selector + ")/@aria-describedby"));
            if (errorPorAria.resolveFor(actor).isVisible()) {
                String msg = Text.of(errorPorAria).viewedBy(actor).asString();
                return msg == null || msg.isBlank() ? "Error no especificado" : msg;
            }
        } catch (Exception ignored) {}

        return "No se encontró mensaje de validación";
    }

    private Boolean validarFormularioVisible(Actor actor) {
        boolean visible = Visibility.of(FormularioExterno.INPUT_DOCUMENTO).viewedBy(actor).resolve()
                || Visibility.of(FormularioExterno.BTN_REGISTRARSE).viewedBy(actor).resolve();
        System.out.println("[ValidacionesRegistro] Form visible: " + visible);
        return visible;
    }

    private Target mapearCampoAInput(String nombreCampo) {
        if (nombreCampo == null) return null;
        String key = nombreCampo.trim().toLowerCase();

        switch (key) {
            case "documento":
            case "número de documento":
            case "numero de documento":
                return FormularioExterno.INPUT_DOCUMENTO;

            case "nombre":
            case "nombre completo":
                return FormularioExterno.INPUT_NOMBRE;

            case "correo":
            case "email":
            case "correo electrónico":
            case "correo electronico":
                return FormularioExterno.INPUT_CORREO;

            case "confirmar correo":
            case "confirmación de correo":
            case "confirmacion de correo":
                return FormularioExterno.INPUT_CONFIRCORREO;

            case "contraseña":
            case "password":
                return FormularioExterno.INPUT_CONTRASENIA;

            case "confirmar contraseña":
            case "confirmación de contraseña":
            case "confirmar password":
                return FormularioExterno.INPUT_CONFIRCONTRASENIA;

            default:
                return null;
        }
    }
}
