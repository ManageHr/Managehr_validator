package co.com.Managehr.stepsdefinitions;

import co.com.Managehr.models.DatosContrato;
import co.com.Managehr.questions.ValidacionContrato;
import co.com.Managehr.tasks.CrearContrato;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class ContratosStepDefinitions {

    @Cuando("^registra un nuevo contrato en el módulo de contratos$")
    public void registraUnNuevoContratoEnElModuloDeContratos(List<DatosContrato> datos) {
        DatosContrato contrato = datos.get(0);
        theActorInTheSpotlight().attemptsTo(
                CrearContrato.conDatos(contrato)
        );
    }

    @Entonces("^el contrato con documento \"([^\"]*)\" debe quedar registrado en la tabla de contratos$")
    public void elContratoConDocumentoDebeQuedarRegistradoEnLaTablaDeContratos(String documento) {
        theActorInTheSpotlight().should(
            seeThat(ValidacionContrato.existeContratoConDocumento(documento), equalTo(true))
        );
    }
}
