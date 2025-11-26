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

        // Reintentamos unos segundos por si la tabla tarda en refrescar
        for (int i = 0; i < 5; i++) {   // 5 intentos
            List<WebElementFacade> filas = CategoriasVacantesPage.FILA_CATEGORIA
                    .of(nombre)
                    .resolveAllFor(actor);

            boolean existeVisible = !filas.isEmpty() &&
                    filas.stream().anyMatch(WebElementFacade::isVisible);

            System.out.println("[DEBUG] filas con nombre '" + nombre + "': " +
                    filas.size() + "  visible=" + existeVisible);

            // Si ya no hay ninguna visible, consideramos que está eliminada
            if (!existeVisible) {
                return true;
            }

            // Si aún la ve, esperamos 1 segundo y volvemos a mirar
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        // Si después de los reintentos sigue apareciendo visible, NO se eliminó
        return false;
    }

    public static ValidacionCategoriaEliminada noExisteCategoriaConNombre(String nombre) {
        return new ValidacionCategoriaEliminada(nombre);
    }
}
