package co.com.Managehr.stepsdefinitions.Usuarios;

import co.com.Managehr.models.Usuarios.Usuario;
import co.com.Managehr.questions.Usuarios.*;
import co.com.Managehr.tasks.Usuarios.*;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class EliminarUsuarioStepDefinitions {

    @Cuando("^se encuentra en la vista con el titulo de \"([^\"]*)\" interno$")
    public void seEncuentraEnLaVistaConElTituloDeInterno(String titulo) {
        System.out.println("Navegando a: " + titulo);
    }

    @Y("^se busca por filtro con el numero de documento \"([^\"]*)\"$")
    public void seBuscaPorFiltroConElNumeroDeDocumento(String documento) {
        Usuario us = new Usuario();
        us.setNumeroDocumento(Long.parseLong(documento));

        theActorInTheSpotlight().attemptsTo(
                FiltrarUsuarioInternoTask.con(us)
        );
    }

    @Entonces("^se valide que el usuario esta en la tabla interna$")
    public void seValideQueElUsuarioEstaEnLaTablaInterna() {
        theActorInTheSpotlight().should(
                seeThat("El usuario está en tabla interna",
                        UsuarioFiltradoInternoAdmin.registroVisible(),
                        is(true)
                )
        );
    }

    @Y("^se da click en el boton de detalles$")
    public void seDaClickEnElBotonDeDetalles() {
        theActorInTheSpotlight().attemptsTo(
                VerDetallesUsuarioTask.delPrimerRegistro()
        );
    }

    @Entonces("^se debe visualizar que el rol es \"([^\"]*)\"$")
    public void seDebeVisualizarQueElRolEs(String rolEsperado) {
        theActorInTheSpotlight().should(
                seeThat("El rol es " + rolEsperado,
                        RolEsEmpleado.enDetalles(),
                        is(true)
                )
        );
    }

    @Y("^se cierra el modal de detalles$")
    public void seCierraElModalDeDetalles() {
        theActorInTheSpotlight().attemptsTo(
                CerrarModalDetallesTask.despuesDeVer()
        );
    }

    @Entonces("^se da click en el boton eliminar$")
    public void seDaClickEnElBotonEliminar() {
        theActorInTheSpotlight().attemptsTo(
                EliminarUsuarioTask.delPrimerRegistro()
        );
    }

    @Y("^se confirma la eliminacion en el modal de confirmacion$")
    public void seConfirmaLaEliminacionEnElModalDeConfirmacion() {
        theActorInTheSpotlight().attemptsTo(
                ConfirmarEliminacionTask.enModal(),
                CerrarSweetAlertTask.deExito()
        );
    }

    @Entonces("^se valide que el usuario ya no esta en la tabla$")
    public void seValideQueElUsuarioYaNoEstaEnLaTabla() {
        theActorInTheSpotlight().should(
                seeThat("El usuario fue eliminado",
                        UsuarioEliminado.correctamente(),
                        is(true)
                )
        );
    }
}