package co.com.Managehr.stepsdefinitions;

import co.com.Managehr.models.HorasExtraUsuario;
import co.com.Managehr.questions.ValidationHorasExtra;
import co.com.Managehr.tasks.CrearHoraExtra;
import co.com.Managehr.userinterface.Autenticacion;
import co.com.Managehr.userinterface.InicioManagehr;
import co.com.Managehr.userinterface.FormHorasExtra;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;

public class HorasExtraStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario ingresa con sus credenciales a ManageHR$")
    public void queElUsuarioIngresaConSusCredencialesAManageHR(List<Map<String, String>> datos) {
        Map<String, String> row = datos.get(0);
        String correo = row.getOrDefault("correo", "").trim();
        String clave  = row.getOrDefault("clave",  "").trim();

        OnStage.theActorCalled("Sharon").wasAbleTo(
                Open.browserOn(new InicioManagehr()),
                WaitUntil.the(Autenticacion.INPUT_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(correo).into(Autenticacion.INPUT_USUARIO),
                Enter.theValue(clave).into(Autenticacion.INPUT_CLAVE),
                Click.on(Autenticacion.BTN_INICIOSESION)
        );
    }

    @Cuando("^registra una solicitud de horas extra$")
    public void registraUnaSolicitudDeHorasExtra(List<Map<String, String>> datos) {
        HorasExtraUsuario he = HorasExtraUsuario.fromMap(datos.get(0));
        theActorInTheSpotlight().attemptsTo(CrearHoraExtra.con(he));
    }

    @Entonces("^debe visualizar la confirmación de envío de la solicitud$")
    public void debeVisualizarLaConfirmacionDeEnvioDeLaSolicitud() {
        theActorInTheSpotlight().should(
                seeThat(ValidationHorasExtra.modalExito(), is(true))
        );
    }

    @Entonces("^debe visualizar el mensaje de error en el formulario de horas extra$")
    public void debeVisualizarElMensajeDeErrorEnElFormularioDeHorasExtra() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(FormHorasExtra.MODAL_ERROR, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(FormHorasExtra.MODAL_ERROR_OK)
        );
    }

}
