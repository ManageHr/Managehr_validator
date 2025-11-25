package co.com.Managehr.questions.Usuarios;

import co.com.Managehr.userinterface.Usuarios.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class ValidacionesFormularioUsuario implements Question<Object> {

    public enum TipoValidacion {
        BOTON_GUARDAR_HABILITADO,
        ALERTA_EXITO,
        ALERTA_ERROR_DUPLICADO,
        USUARIO_EN_TABLA,
        MENSAJE_ERROR_LOGIN
    }

    private TipoValidacion tipo;
    private String parametro;

    public ValidacionesFormularioUsuario(TipoValidacion tipo) {
        this.tipo = tipo;
    }

    public ValidacionesFormularioUsuario(TipoValidacion tipo, String parametro) {
        this.tipo = tipo;
        this.parametro = parametro;
    }

    public static ValidacionesFormularioUsuario guardar() {
        return new ValidacionesFormularioUsuario(TipoValidacion.BOTON_GUARDAR_HABILITADO);
    }

    public static ValidacionesFormularioUsuario esVisible() {
        return new ValidacionesFormularioUsuario(TipoValidacion.ALERTA_ERROR_DUPLICADO);
    }

    public static ValidacionesFormularioUsuario conDocumento(String documento) {
        return new ValidacionesFormularioUsuario(TipoValidacion.USUARIO_EN_TABLA, documento);
    }

    @Override
    public Object answeredBy(Actor actor) {
        try {
            switch (tipo) {
                case BOTON_GUARDAR_HABILITADO:
                    return validarBotonGuardar(actor);

                case ALERTA_EXITO:
                    return validarAlertaExito(actor);

                case ALERTA_ERROR_DUPLICADO:
                    return validarAlertaErrorDuplicado(actor);

                case USUARIO_EN_TABLA:
                    return validarUsuarioEnTabla(actor);

                case MENSAJE_ERROR_LOGIN:
                    return validarMensajeErrorLogin(actor);

                default:
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Error en validación " + tipo + ": " + e.getMessage());
            return tipo == TipoValidacion.ALERTA_EXITO || tipo == TipoValidacion.MENSAJE_ERROR_LOGIN
                    ? "Error al obtener mensaje" : false;
        }
    }

    private Boolean validarBotonGuardar(Actor actor) {
        boolean habilitado = CrearUsuarioPage.BTN_GUARDAR.resolveFor(actor).isEnabled();
        System.out.println("Botón Guardar habilitado: " + habilitado);
        return habilitado;
    }

    private String validarAlertaExito(Actor actor) {
        try {
            String mensaje = Text.of(CrearUsuarioPage.ALERTA_EXITO).viewedBy(actor).asString();
            if (mensaje != null && !mensaje.trim().isEmpty()) {
                System.out.println("Mensaje de éxito obtenido: " + mensaje);
                return mensaje;
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener mensaje con selector principal: " + e.getMessage());
        }

        try {
            String mensaje = Text.of(CrearUsuarioPage.ALERTA_EXITO_ALTERNATIVA).viewedBy(actor).asString();
            if (mensaje != null && !mensaje.trim().isEmpty()) {
                System.out.println("Mensaje de éxito obtenido (alternativo): " + mensaje);
                return mensaje;
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener mensaje con selector alternativo: " + e.getMessage());
        }

        return "No se pudo obtener el mensaje de éxito";
    }

    private Boolean validarAlertaErrorDuplicado(Actor actor) {
        try {
            System.out.println("=== BUSCANDO ALERTA DE ERROR ===");
            Target mensajeError = Target.the("mensaje de usuario duplicado")
                    .locatedBy("//div[@id='swal2-html-container' and contains(., 'Ya existe un usuario con ese correo o número de documento.')]");
            boolean mensajeVisible = mensajeError.resolveFor(actor).isVisible();
            if (mensajeVisible) {
                System.out.println("ALERTA ENCONTRADA: 'Ya existe un usuario con ese correo o número de documento.'");
                return true;
            } else {
                System.out.println("No se encontro el mensaje esperado");
                return false;
            }

        } catch (Exception e) {
            System.out.println("No se pudo validar la alerta: " + e.getMessage());
            return false;
        }
    }

    private Boolean validarUsuarioEnTabla(Actor actor) {
        System.out.println("Buscando usuario con documento: " + parametro);

        Target filaUsuario = Target.the("fila del usuario")
                .locatedBy("//table//tbody//tr[td[contains(., '" + parametro + "')]]");

        boolean estaVisible = Visibility.of(filaUsuario).viewedBy(actor).resolve();

        if (estaVisible) {
            System.out.println("Usuario encontrado en tabla con documento: " + parametro);
            return true;
        }
        String contenidoTabla = Text.of(CrearUsuarioPage.TABLA_USUARIOS).viewedBy(actor).asString();
        boolean contieneDocumento = contenidoTabla.contains(parametro);

        if (contieneDocumento) {
            System.out.println("Documento encontrado en contenido de tabla: " + parametro);
            return true;
        }

        System.out.println("Usuario NO encontrado en tabla. Documento: " + parametro);
        System.out.println("Contenido de tabla: " + (contenidoTabla.length() > 100 ? contenidoTabla.substring(0, 100) + "..." : contenidoTabla));
        return false;
    }
    private String validarMensajeErrorLogin(Actor actor) {
        try {
            Target mensajeError = Target.the("mensaje error login")
                    .locatedBy("//div[contains(@class,'alert-danger')]");

            if (mensajeError.resolveFor(actor).isVisible()) {
                String mensaje = Text.of(mensajeError).viewedBy(actor).asString();
                System.out.println("Mensaje de error capturado: " + mensaje);
                return mensaje;
            } else {
                System.out.println("No hay mensaje de error visible");
                return "No se encontró mensaje de error";
            }
        } catch (Exception e) {
            System.out.println("No se pudo capturar el mensaje de error: " + e.getMessage());
            return "No se encontró mensaje de error";
        }
    }
}