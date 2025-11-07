package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.models.Usuario;
import co.com.Managehr.userinterface.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LlenarFormularioUsuario implements Task {
    private Usuario usuario;

    public LlenarFormularioUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public static LlenarFormularioUsuario con(Usuario usuario) {
        return instrumented(LlenarFormularioUsuario.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("=== INICIANDO LLENADO DE FORMULARIO ===");

        actor.attemptsTo(
                Enter.theValue(usuario.getPrimerNombre()).into(CrearUsuarioPage.PRIMER_NOMBRE_INPUT),
                Enter.theValue(usuario.getSegundoNombre()).into(CrearUsuarioPage.SEGUNDO_NOMBRE_INPUT),
                Enter.theValue(usuario.getPrimerApellido()).into(CrearUsuarioPage.PRIMER_APELLIDO_INPUT),
                Enter.theValue(usuario.getSegundoApellido()).into(CrearUsuarioPage.SEGUNDO_APELLIDO_INPUT),
                SelectFromOptions.byValue(String.valueOf(usuario.getTipoDocumento())).from(CrearUsuarioPage.TIPO_DOCUMENTO_SELECT),
                Enter.theValue(String.valueOf(usuario.getNumeroDocumento())).into(CrearUsuarioPage.NUMERO_DOCUMENTO_INPUT),
                Enter.theValue(usuario.getFechaNacimiento().toString()).into(CrearUsuarioPage.FECHA_NACIMIENTO_INPUT),
                Enter.theValue(usuario.getEmail()).into(CrearUsuarioPage.EMAIL_INPUT),
                Enter.theValue(usuario.getDireccion()).into(CrearUsuarioPage.DIRECCION_INPUT),
                Enter.theValue(usuario.getTelefono()).into(CrearUsuarioPage.TELEFONO_INPUT),

                SelectFromOptions.byValue(String.valueOf(usuario.getNacionalidad())).from(CrearUsuarioPage.NACIONALIDAD_SELECT),
                SelectFromOptions.byValue(String.valueOf(usuario.getEps())).from(CrearUsuarioPage.EPS_SELECT),
                SelectFromOptions.byValue(String.valueOf(usuario.getFondoPension())).from(CrearUsuarioPage.FONDO_PENSION_SELECT),
                SelectFromOptions.byValue(String.valueOf(usuario.getGenero())).from(CrearUsuarioPage.GENERO_SELECT),
                SelectFromOptions.byValue(String.valueOf(usuario.getEstadoCivil())).from(CrearUsuarioPage.ESTADO_CIVIL_SELECT),
                SelectFromOptions.byValue(String.valueOf(usuario.getRol())).from(CrearUsuarioPage.ROL_SELECT),

                Enter.theValue(usuario.getPassword()).into(CrearUsuarioPage.PASSWORD_INPUT),
                Enter.theValue(usuario.getRepetirPassword()).into(CrearUsuarioPage.REPETIR_PASSWORD_INPUT)

        );
        System.out.println("Datos llenados con exito");
    }
}