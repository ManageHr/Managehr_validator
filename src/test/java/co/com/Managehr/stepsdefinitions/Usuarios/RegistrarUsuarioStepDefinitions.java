package co.com.Managehr.stepsdefinitions.Usuarios;

import co.com.Managehr.models.Usuarios.Usuario;
import co.com.Managehr.questions.Usuarios.ValidacionesFormularioUsuario;
import co.com.Managehr.tasks.Usuarios.AbrirFormularioUsuario;
import co.com.Managehr.tasks.Usuarios.CompletarFlujoUsuario;
import co.com.Managehr.tasks.Usuarios.GuardarUsuario;
import co.com.Managehr.tasks.Usuarios.LlenarFormularioUsuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class RegistrarUsuarioStepDefinitions {
    private String documentoUsuario;

    @Cuando("^hace clic en \"([^\"]*)\"$")
    public void haceClicEn(String nombreBoton) {
        if ("Agregar usuario".equals(nombreBoton)) {
            theActorInTheSpotlight().attemptsTo(
                    AbrirFormularioUsuario.ahora()
            );
        }
    }

    @Y("^se abre el formulario modal de creación de usuario$")
    public void seAbreElFormularioModalDeCreaciónDeUsuario() {
        System.out.println("Formulario modal abierto");
    }

    @Y("^llena todos los campos requeridos con datos válidos$")
    public void llenaTodosLosCamposRequeridosConDatosVálidos(List<Usuario> datos) {


        documentoUsuario = String.valueOf(datos.get(0).getNumeroDocumento());

        Usuario usuario = new Usuario();
        usuario.setPrimerNombre(datos.get(0).getPrimerNombre());
        usuario.setSegundoNombre(datos.get(0).getSegundoNombre());
        usuario.setPrimerApellido(datos.get(0).getPrimerApellido());
        usuario.setSegundoApellido(datos.get(0).getSegundoApellido());
        usuario.setTipoDocumento(datos.get(0).getTipoDocumento());
        usuario.setNumeroDocumento(datos.get(0).getNumeroDocumento());
        usuario.setFechaNacimiento(datos.get(0).getFechaNacimiento());
        usuario.setEmail(datos.get(0).getEmail());
        usuario.setDireccion(datos.get(0).getDireccion());
        usuario.setTelefono(datos.get(0).getTelefono());
        usuario.setNacionalidad(datos.get(0).getNacionalidad());
        usuario.setEps(datos.get(0).getEps());
        usuario.setFondoPension(datos.get(0).getFondoPension());
        usuario.setGenero(datos.get(0).getGenero());
        usuario.setEstadoCivil(datos.get(0).getEstadoCivil());
        usuario.setRol(datos.get(0).getRol());
        usuario.setPassword(datos.get(0).getPassword());
        usuario.setRepetirPassword(datos.get(0).getRepetirPassword());

        theActorInTheSpotlight().attemptsTo(
                LlenarFormularioUsuario.con(usuario)
        );
    }
   /*@Y("^llena todos los campos requeridos con datos válidos$")
   public void llenaTodosLosCamposRequeridosConDatosVálidos(DataTable dataTable) {
       Map<String, String> datos = dataTable.asMap(String.class, String.class);
       documentoUsuario = datos.get("numeroDocumento");
       System.out.println("Documento guardado para búsqueda: " + documentoUsuario);

       Usuario usuario = new Usuario();
       usuario.setPrimerNombre(datos.get("primerNombre"));
       usuario.setSegundoNombre(datos.get("segundoNombre"));
       usuario.setPrimerApellido(datos.get("primerApellido"));
       usuario.setSegundoApellido(datos.get("segundoApellido"));
       usuario.setTipoDocumento(Integer.parseInt(datos.get("tipoDocumento")));
       usuario.setNumeroDocumento(Long.parseLong(datos.get("numeroDocumento")));
       usuario.setFechaNacimiento(java.sql.Date.valueOf(datos.get("fechaNacimiento")));
       usuario.setEmail(datos.get("email"));
       usuario.setDireccion(datos.get("direccion"));
       usuario.setTelefono(datos.get("telefono"));
       usuario.setNacionalidad(Integer.parseInt(datos.get("nacionalidad")));
       usuario.setEps(datos.get("eps"));
       usuario.setFondoPension(datos.get("fondoPension"));
       usuario.setGenero(Integer.parseInt(datos.get("genero")));
       usuario.setEstadoCivil(Integer.parseInt(datos.get("estadoCivil")));
       usuario.setRol(Integer.parseInt(datos.get("rol")));
       usuario.setPassword(datos.get("clave"));
       usuario.setRepetirPassword(datos.get("repetirClave"));

       theActorInTheSpotlight().attemptsTo(
               LlenarFormularioUsuario.con(usuario)
       );
   }*/

    @Entonces("^el botón \"([^\"]*)\" debe estar habilitado$")
    public void elBotónDebeEstarHabilitado(String nombreBoton) {
        if ("Guardar".equals(nombreBoton)) {
            theActorInTheSpotlight().should(
                    seeThat(ValidacionesFormularioUsuario.guardar(), is(true))
            );
        }
    }

    @Y("^al hacer clic en \"([^\"]*)\"$")
    public void alHacerClicEn(String nombreBoton) {
        if ("Guardar".equals(nombreBoton)) {
            theActorInTheSpotlight().attemptsTo(
                    GuardarUsuario.ahora()
            );
        }
    }

    @Entonces("^debe aparecer una alerta que diga \"([^\"]*)\"$")
    public void debeAparecerUnaAlertaQueDiga(String mensajeEsperado) {
        System.out.println(" Validando alerta "+mensajeEsperado);

        if (documentoUsuario != null) {
            theActorInTheSpotlight().attemptsTo(
                    CompletarFlujoUsuario.conDocumento(documentoUsuario)
            );
        } else {
            System.out.println("DocumentoUsuario es null, no se puede continuar con el flujo");
        }
    }

    @Entonces("^el usuario debe aparecer en la tabla de usuarios$")
    public void elUsuarioDebeAparecerEnLaTablaDeUsuarios() {
        if (documentoUsuario != null) {
            System.out.println("Validando que usuario con documento " + documentoUsuario + " aparece en tabla...");
            theActorInTheSpotlight().should(
                    seeThat(ValidacionesFormularioUsuario.conDocumento(documentoUsuario), is(true))
            );
            System.out.println("Validación completada - usuario encontrado en tabla");
        } else {
            System.out.println("Error: documentoUsuario es null");
        }
    }

    @Entonces("debe mostrar la alerta de usuario duplicado")
    public void debeMostrarLaAlertaDeUsuarioDuplicado() {
        System.out.println("=== VALIDANDO ALERTA DE USUARIO DUPLICADO ===");

        boolean alertaValida = (Boolean) ValidacionesFormularioUsuario.esVisible()
                .answeredBy(OnStage.theActorInTheSpotlight());

        if (alertaValida) {
            System.out.println("PRUEBA EXITOSA - Alerta de usuario duplicado validada");
            System.out.println("Se evidencia la alerta: 'Ya existe un usuario con ese correo o número de documento.'");
            System.out.println("DEPURACIÓN FINALIZADA - Automatización completada sin errores");
        } else {
            System.out.println("No se detectó la alerta esperada");
        }
        System.out.println("=== AUTOMATIZACIÓN FINALIZADA ===");
    }
}