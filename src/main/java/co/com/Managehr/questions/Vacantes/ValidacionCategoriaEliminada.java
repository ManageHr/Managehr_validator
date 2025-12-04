package co.com.Managehr.questions.Vacantes;

import co.com.Managehr.userinterface.Vacantes.CategoriasVacantesPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class ValidacionCategoriaEliminada implements Question<Boolean> {

    private final String nombre;

    public ValidacionCategoriaEliminada(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Boolean answeredBy(Actor actor) {


        List<WebElementFacade> filas = CategoriasVacantesPage.FILA_CATEGORIA
                .of(nombre)
                .resolveAllFor(actor);

        System.out.println("[DEBUG] Filas encontradas para '" + nombre + "': " + filas.size());

        return filas.isEmpty();
    }

    public static ValidacionCategoriaEliminada noExisteCategoriaConNombre(String nombre) {
        return new ValidacionCategoriaEliminada(nombre);
    }
}
