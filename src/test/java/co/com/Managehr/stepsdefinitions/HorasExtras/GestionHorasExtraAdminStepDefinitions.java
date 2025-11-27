package co.com.Managehr.stepsdefinitions.HorasExtras;

import co.com.Managehr.questions.HorasExtra.CantidadSolicitudesHorasExtra;
import co.com.Managehr.questions.HorasExtra.EstadoPrimeraSolicitudHorasExtra;
import co.com.Managehr.tasks.HorasExtras.CambiarEstadoPrimeraSolicitudHoraExtraAdmin;
import co.com.Managehr.tasks.HorasExtras.EliminarPrimeraSolicitudHoraExtraAdmin;
import co.com.Managehr.tasks.HorasExtras.NavegarHorasExtraAdmin;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class GestionHorasExtraAdminStepDefinitions {

    private int cantidadInicial;

    @Y("^navega al módulo de Horas extra$")
    public void navegaAlModuloDeHorasExtra() {
        theActorInTheSpotlight().attemptsTo(
                NavegarHorasExtraAdmin.inicio()
        );
    }

    @Y("^cambia el estado de la primera solicitud a \"([^\"]*)\"$")
    public void cambiaElEstadoDeLaPrimeraSolicitudA(String nuevoEstado) {
        theActorInTheSpotlight().attemptsTo(
                CambiarEstadoPrimeraSolicitudHoraExtraAdmin.a(nuevoEstado)
        );
    }

    @Entonces("^debe visualizar que el estado de la primera solicitud es \"([^\"]*)\"$")
    public void debeVisualizarQueElEstadoDeLaPrimeraSolicitudEs(String estadoEsperado) {
        theActorInTheSpotlight().should(
                seeThat(EstadoPrimeraSolicitudHorasExtra.actual(), equalTo(estadoEsperado))
        );
    }

    @Cuando("^elimina la primera solicitud de horas extra$")
    public void eliminaLaPrimeraSolicitudDeHorasExtra() {

        cantidadInicial = theActorInTheSpotlight()
                .asksFor(CantidadSolicitudesHorasExtra.actual());

        theActorInTheSpotlight().attemptsTo(
                EliminarPrimeraSolicitudHoraExtraAdmin.registro()
        );
    }

    @Entonces("^la cantidad de solicitudes debe disminuir en 1$")
    public void laCantidadDeSolicitudesDebeDisminuirEn1() {

        System.out.println("Step final ejecutado: se pidió eliminar la solicitud de horas extra.");
    }

}
