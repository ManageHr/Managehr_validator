package co.com.Managehr.stepsdefinitions.HorasExtras;

import co.com.Managehr.models.HorasExtras.HorasExtraUsuario;
import co.com.Managehr.questions.HorasExtra.ValidationHorasExtra;
import co.com.Managehr.tasks.HorasExtras.CrearHoraExtra;
import co.com.Managehr.tasks.HorasExtras.NavegarHorasExtraUsuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class HorasExtraStepDefinitions {

    @Cuando("^registra una solicitud de horas extra$")
    public void registraUnaSolicitudDeHorasExtra(List<HorasExtraUsuario> datos) {
        HorasExtraUsuario dao = datos.get(0);

        theActorInTheSpotlight().attemptsTo(NavegarHorasExtraUsuario.inicio());
        theActorInTheSpotlight().attemptsTo(CrearHoraExtra.con(dao));
    }

    @Entonces("^debe visualizar la confirmación de envío de la solicitud$")
    public void debeVisualizarLaConfirmaciónDeEnvíoDeLaSolicitud() {

    }
    //prueba
    @Entonces("^debe aparecer una alerta de exito y cerrarse$")
    public void debeAparecerUnaAlertaDeExitoYCerrarse() {

    }
    @Cuando("^registra una solicitud de horas extra sin descripcion$")
    public void registraUnaSolicitudDeHorasExtraSinDescripcion(List<HorasExtraUsuario> datos) {
        HorasExtraUsuario dao = datos.get(0);
        theActorInTheSpotlight().attemptsTo(CrearHoraExtra.conDatosIncompletos(dao));
    }
    @Entonces("^debe visualizar el mensaje de error en el formulario de horas extra$")
    public void debeVisualizarElMensajeDeErrorEnElFormularioDeHorasExtra() {
        theActorInTheSpotlight().should(seeThat(ValidationHorasExtra.modalErrorCamposObligatorios()));
    }

    @Entonces("^se debe cerrar la alerta$")
    public void seDebeCerrarLaAlerta() {

    }

}
