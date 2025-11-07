package co.com.Managehr.stepsdefinitions;

import co.com.Managehr.models.DatosFormularioExterno;
import co.com.Managehr.tasks.AbrirPagina;
import co.com.Managehr.tasks.CompletarFormularioExterno;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FormularioExternoStepDefinitions {


    @Dado("^que el usuario se encuentra en el formulario de registro de ManageHR$")
    public void queElUsuarioSeEncuentraEnElFormularioDeRegistroDeManageHR() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.lapagina());
    }


    @Cuando("^ingresa los datos válidos en el formulario$")
    public void ingresaLosDatosVálidosEnElFormulario(List<DatosFormularioExterno> DatosFormularioExternoList) {
        theActorInTheSpotlight().attemptsTo(CompletarFormularioExterno.con(DatosFormularioExternoList));
    }

    @Entonces("^se debe verificar que el usuario haya sido registrado correctamente y redirigido a su perfil$")
    public void seDebeVerificarQueElUsuarioHayaSidoRegistradoCorrectamenteYRedirigidoASuPerfil() {

    }

}
