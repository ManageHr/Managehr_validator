package co.com.Managehr.stepsdefinitions;

import co.com.Managehr.models.CredencialesInicioSesion;
import co.com.Managehr.questions.ValidacionLogin;
import co.com.Managehr.tasks.AbrirPagina;
import co.com.Managehr.tasks.Autenticarse;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AutenticacionStepDefinitions {

    @Dado("^que el usuario se encuentra en la página de inicio de sesión de Managehr$")
    public void queElUsuarioSeEncuentraEnLaPáginaDeInicioDeSesiónDeManagehr() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.lapagina());
    }

    @Cuando("^ingrese las credenciales correctas \\(correo y clave\\)$")
    public void ingreseLasCredencialesCorrectasCorreoYClave(List<CredencialesInicioSesion> credencialesInicioSesionList) {
        theActorInTheSpotlight().attemptsTo(Autenticarse.aute(credencialesInicioSesionList));
    }

    @Entonces("^se debe verificar que el usuario haya sido autenticado correctamente y redirigido al directorio de la página Managehr$")
    public void seDebeVerificarQueElUsuarioHayaSidoAutenticadoCorrectamenteYRedirigidoAlDirectorioDeLaPáginaManagehr() {
        theActorInTheSpotlight().should(seeThat(ValidacionLogin.validacionLogin()));
    }
}
