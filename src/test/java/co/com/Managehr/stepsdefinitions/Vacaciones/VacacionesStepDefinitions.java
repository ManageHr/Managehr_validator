package co.com.Managehr.stepsdefinitions.Vacaciones;


import co.com.Managehr.models.Autentication.CredencialesInicioSesion;
import co.com.Managehr.models.Vacaciones.FormularioVacaciones;
import co.com.Managehr.questions.Vacaciones.MensajeConfirmacionVacaciones;
import co.com.Managehr.tasks.Autentication.Autenticarse;
import co.com.Managehr.tasks.Autentication.CerrarSesion;
import co.com.Managehr.tasks.Vacaciones.DiligenciarFormularioVacaciones;
import co.com.Managehr.tasks.Vacaciones.NavegarAVacaciones;
import co.com.Managehr.userinterface.Vacaciones.MensajeVacacionesPage;
import co.com.Managehr.userinterface.Vacaciones.MenuVacacionesPage;
import co.com.Managehr.userinterface.Vacaciones.VacacionesJefePage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class VacacionesStepDefinitions {

    @Cuando("^navega al módulo de Vacaciones$")
    public void navegaAlModuloDeVacaciones() {
        theActorInTheSpotlight().attemptsTo(
                NavegarAVacaciones.enElMenu()
        );
    }

    @Cuando("^diligencia el formulario de vacaciones$")
    public void diligenciaElFormularioDeVacaciones() {

        FormularioVacaciones datos = new FormularioVacaciones(
                "Solicitud de vacaciones hik",
                "10122025",
                "10142025"
        );

        theActorInTheSpotlight().attemptsTo(
                DiligenciarFormularioVacaciones.conDatos(datos)
        );
    }

    @Entonces("^debería visualizar un mensaje de confirmación de solicitud registrada$")
    public void deberiaVisualizarUnMensajeDeConfirmacionDeSolicitudRegistrada() {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MensajeVacacionesPage.LBL_MENSAJE_CONFIRMACION, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat(
                        MensajeConfirmacionVacaciones.texto(),
                        containsString("Solicitud de vacaciones enviada correctamente")
                )
        );

        theActorInTheSpotlight().attemptsTo(
                Click.on(MensajeVacacionesPage.BTN_OK)
        );
    }

    @Cuando("^cierra la sesión actual$")
    public void cierraLaSesionActual() {
        theActorInTheSpotlight().attemptsTo(
                CerrarSesion.ahora()
        );
    }

    @Cuando("^inicia sesión como jefe de personal$")
    public void iniciaSesionComoJefeDePersonal(List<CredencialesInicioSesion> credenciales) {
        System.out.println(">>> Iniciando sesión como jefe de personal");
        theActorInTheSpotlight().attemptsTo(
                Autenticarse.aute(credenciales)
        );
    }

    @Cuando("^navega al módulo de vacaciones como jefe$")
    public void navegaAlModuloDeVacacionesComoJefe() {
        System.out.println(">>> Navegando al módulo de Vacaciones como jefe");
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(MenuVacacionesPage.BTN_MENU_VACACIONES)
        );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Cuando("^aprueba la solicitud de vacaciones con motivo \"([^\"]*)\"$")
    public void apruebaLaSolicitudDeVacacionesConMotivo(String motivo) {
        System.out.println(">>> Entró al step: aprueba la solicitud de vacaciones con motivo = " + motivo);

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(VacacionesJefePage.BTN_APROBAR_SOLICITUD, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(VacacionesJefePage.BTN_APROBAR_SOLICITUD)
        );
        System.out.println(">>> Click en botón 'Aprobar solicitud' de la lista");

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(VacacionesJefePage.BTN_MODAL_APROBAR, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(VacacionesJefePage.BTN_MODAL_APROBAR)
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(">>> Click en botón 'Aprobar' del modal");

    }
    @Entonces("^el estado de la solicitud debería ser \"([^\"]*)\"$")
    public void elEstadoDeLaSolicitudDeberíaSer(String arg1) {
        System.out.printf("El estado es "+arg1);
    }


}
