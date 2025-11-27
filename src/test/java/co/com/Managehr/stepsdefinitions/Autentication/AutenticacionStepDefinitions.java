package co.com.Managehr.stepsdefinitions.Autentication;

import co.com.Managehr.models.Autentication.CredencialesInicioSesion;
import co.com.Managehr.questions.Autentications.MensajeErrorLogin;
import co.com.Managehr.questions.Autentications.ValidacionLogin;
import co.com.Managehr.tasks.Autentication.AbrirPagina;
import co.com.Managehr.tasks.Autentication.Autenticarse;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

public class AutenticacionStepDefinitions {

    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("usuario");
    }

    @Dado("^que el usuario se encuentra en la página de inicio de sesión de Managehr$")
    public void queElUsuarioSeEncuentraEnLaPáginaDeInicioDeSesiónDeManagehr() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.lapagina());
    }

    @Cuando("^ingrese las credenciales correctas \\(correo y clave\\)$")
    public void ingreseLasCredencialesCorrectasCorreoYClave(List<CredencialesInicioSesion> credencialesInicioSesionList) {
        theActorInTheSpotlight().attemptsTo(Autenticarse.aute(credencialesInicioSesionList));
    }

    @Cuando("^ingrese credenciales incorrectas$")
    public void ingreseCredencialesIncorrectas(List<CredencialesInicioSesion> credenciales) {
        theActorInTheSpotlight().attemptsTo(Autenticarse.aute(credenciales));
    }

    @Entonces("^se debe verificar que el usuario haya sido autenticado correctamente y redirigido al directorio de la página Managehr$")
    public void seDebeVerificarQueElUsuarioHayaSidoAutenticadoCorrectamenteYRedirigidoAlDirectorioDeLaPáginaManagehr() {
        String resultado = ValidacionLogin.validacionLogin().answeredBy(theActorInTheSpotlight());
        System.out.println("Resultado validación: " + resultado);

        if (!resultado.contains("SUCCESS")) {
            net.serenitybdd.screenplay.abilities.BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().get("about:blank");
            throw new AssertionError("Validación falló: " + resultado);
        }

    }

    @Entonces("^debe mostrarse un mensaje de error de autenticación$")
    public void debeMostrarseUnMensajeDeErrorDeAutenticacion() {
        theActorInTheSpotlight().should(
                seeThat(MensajeErrorLogin.obtenido(), not(equalTo("No se encontró mensaje de error")))
        );
    }

    @Entonces("^el mensaje de error debe contener \"([^\"]*)\"$")
    public void elMensajeDeErrorDebeContener(String textoEsperado) {
        theActorInTheSpotlight().should(
                seeThat(MensajeErrorLogin.obtenido(), containsString(textoEsperado))
        );
    }
}