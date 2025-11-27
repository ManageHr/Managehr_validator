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


        for (int i = 0; i < 5; i++) {
            List<WebElementFacade> filas = CategoriasVacantesPage.FILA_CATEGORIA
                    .of(nombre)
                    .resolveAllFor(actor);

            boolean existeVisible = !filas.isEmpty() &&
                    filas.stream().anyMatch(WebElementFacade::isVisible);

            System.out.println("[DEBUG] filas con nombre '" + nombre + "': " +
                    filas.size() + "  visible=" + existeVisible);


            if (!existeVisible) {
                return true;
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }


        return false;
    }

    public static ValidacionCategoriaEliminada noExisteCategoriaConNombre(String nombre) {
        return new ValidacionCategoriaEliminada(nombre);
    }
}
