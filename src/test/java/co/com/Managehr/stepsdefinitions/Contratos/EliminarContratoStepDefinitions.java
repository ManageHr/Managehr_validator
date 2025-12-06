package co.com.Managehr.stepsdefinitions.Contratos;

import co.com.Managehr.questions.Contratos.ValidarContratoQuestion;
import co.com.Managehr.tasks.Contratos.*;
import co.com.Managehr.userinterface.Contratos.GestionContratosPage;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class EliminarContratoStepDefinitions {
    @Entonces("^debo ser redirigido a la página principal del sistema$")
    public void deboSerRedirigidoALaPáginaPrincipalDelSistema() {

    }

    @Dado("^que estoy en la sección de Gestión de Contratos$")
    public void queEstoyEnLaSecciónDeGestionDeContratos() {
        theActorInTheSpotlight().attemptsTo(
                NavegarContratosTask.ahora()
        );
    }

    @Cuando("^busco al usuario con número de documento \"([^\"]*)\"$")
    public void buscoAlUsuarioConNúmeroDeDocumento(String documento) {
        theActorInTheSpotlight().attemptsTo(
                BuscarContratoTask.conDocumento(documento)
        );
    }
    @Cuando("^verifico que el contrato con documento \"([^\"]*)\" existe en la tabla$")
    public void verificoQueElContratoConDocumentoExisteEnLaTabla(String documento) {
        theActorInTheSpotlight().should(
                seeThat(ValidarContratoQuestion.contratoExiste(documento), is(true))
        );
    }

    @Cuando("^selecciono la opción \"([^\"]*)\" para el contrato encontrado$")
    public void seleccionoLaOpciónParaElContratoEncontrado(String opcion) {
        theActorInTheSpotlight().attemptsTo(
                ClickEliminarContratoTask.inicioTo()
        );
    }

    @Entonces("^se debe mostrar una alerta de confirmación titulada \"([^\"]*)\"$")
    public void seDebeMostrarUnaAlertaDeConfirmaciónTitulada(String tituloEsperado) {
        theActorInTheSpotlight().should(
                seeThat(ValidarContratoQuestion.alertaConfirmacionEsVisible(tituloEsperado), is(true))
        );
    }

    @Cuando("^confirmo la eliminación en la alerta haciendo clic en \"([^\"]*)\"$")
    public void confirmoLaEliminaciónEnLaAlertaHaciendoClicEn(String boton) {
        theActorInTheSpotlight().attemptsTo(
                EliminarContratoTask.conDocumento()
        );
    }

    @Entonces("^debe mostrarse una alerta de éxito con el mensaje \"([^\"]*)\"$")
    public void debeMostrarseUnaAlertaDeÉxitoConElMensaje(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                seeThat(ValidarContratoQuestion.mensajeAlertaExito(),
                        containsString(mensajeEsperado))
        );
    }

    @Entonces("^cierro la alerta de éxito$")
    public void cierroLaAlertaDeÉxito() {
        theActorInTheSpotlight().attemptsTo(
                CerrarAlertaExitoEliminar.inicioTo()
        );
    }


}