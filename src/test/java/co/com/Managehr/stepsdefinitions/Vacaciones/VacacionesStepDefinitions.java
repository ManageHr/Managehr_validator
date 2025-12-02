package co.com.Managehr.stepsdefinitions.Vacaciones;


import co.com.Managehr.models.Vacaciones.FormularioVacaciones;
import co.com.Managehr.questions.Vacaciones.MensajeConfirmacionVacaciones;
import co.com.Managehr.tasks.Vacaciones.DiligenciarFormularioVacaciones;
import co.com.Managehr.tasks.Vacaciones.NavegarAVacaciones;
import co.com.Managehr.userinterface.Vacaciones.MensajeVacacionesPage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class VacacionesStepDefinitions {

    @Cuando("^navega al módulo de Vacaciones$")
    public void navegaAlModuloDeVacaciones() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAVacaciones.enElMenu()
        );
    }

    @Cuando("^diligencia el formulario de vacaciones$")
    public void diligenciaElFormularioDeVacaciones() {

        FormularioVacaciones datos = new FormularioVacaciones(
                "Solicitud de vacaciones automatizada",
                "10122025",
                "10142025"
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligenciarFormularioVacaciones.conDatos(datos)
        );
    }

    @Entonces("^debería visualizar un mensaje de confirmación de solicitud registrada$")
    public void deberiaVisualizarUnMensajeDeConfirmacionDeSolicitudRegistrada() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MensajeVacacionesPage.LBL_MENSAJE_CONFIRMACION, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        MensajeConfirmacionVacaciones.texto(),
                        containsString("Solicitud de vacaciones enviada correctamente")
                )
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                net.serenitybdd.screenplay.actions.Click.on(MensajeVacacionesPage.BTN_OK)
        );
    }
}
