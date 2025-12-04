package co.com.Managehr.stepsdefinitions.Vacantes;

import co.com.Managehr.models.Vacantes.CategoriaVacanteData;
import co.com.Managehr.questions.Vacantes.ValidacionCategoriaEliminada;
import co.com.Managehr.tasks.Vacantes.AbrirModuloCategoriasVacantes;
import co.com.Managehr.tasks.Vacantes.BuscarCategoriaVacante;
import co.com.Managehr.tasks.Vacantes.CrearCategoriaVacante;
import co.com.Managehr.tasks.Vacantes.EditarCategoriaVacante;
import co.com.Managehr.tasks.Vacantes.EliminarCategoriaVacante;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class CategoriasVacantesStepDefinitions {

    @Cuando("^navega al módulo de categorías de vacantes$")
    public void navegaAlModuloDeCategoriasDeVacantes() {
        theActorInTheSpotlight().attemptsTo(
                AbrirModuloCategoriasVacantes.ir()
        );
    }

    @Cuando("^crea una nueva categoría de vacante$")
    public void creaUnaNuevaCategoriaDeVacante(List<CategoriaVacanteData> datos) {
        CategoriaVacanteData data = datos.get(0);
        theActorInTheSpotlight().attemptsTo(
                CrearCategoriaVacante.conDatos(data)
        );
    }

    @Cuando("^consulta la categoría de vacante por nombre \"([^\"]*)\"$")
    public void consultaLaCategoriaDeVacantePorNombre(String nombre) {
        theActorInTheSpotlight().attemptsTo(
                BuscarCategoriaVacante.porNombre(nombre)
        );
    }

    @Cuando("^edita la categoría de vacante$")
    public void editaLaCategoriaDeVacante(List<CategoriaVacanteData> datos) {
        CategoriaVacanteData data = datos.get(0);
        theActorInTheSpotlight().attemptsTo(
                EditarCategoriaVacante.conDatos(data)
        );
    }

    @Cuando("^busca la categoría de vacante por nombre \"([^\"]*)\"$")
    public void buscaLaCategoriaDeVacantePorNombre(String nombre) {
        theActorInTheSpotlight().attemptsTo(
                BuscarCategoriaVacante.porNombre(nombre)
        );
    }

    @Cuando("^elimina la categoría de vacante con nombre \"([^\"]*)\"$")
    public void eliminaLaCategoriaDeVacanteConNombre(String nombre) {
        theActorInTheSpotlight().attemptsTo(
                EliminarCategoriaVacante.porNombre(nombre)
        );
    }


}
