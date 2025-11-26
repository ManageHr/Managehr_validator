package co.com.Managehr.tasks.Vacantes;

import co.com.Managehr.models.Vacantes.CategoriaVacanteData;
import co.com.Managehr.userinterface.Vacantes.CategoriasVacantesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearCategoriaVacante implements Task {

    private final CategoriaVacanteData data;

    public CrearCategoriaVacante(CategoriaVacanteData data) {
        this.data = data;
    }

    public static CrearCategoriaVacante conDatos(CategoriaVacanteData data) {
        return Tasks.instrumented(CrearCategoriaVacante.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String nombre = data.getNombre();

        actor.attemptsTo(
                // Abrir modal "Agregar Categoría"
                WaitUntil.the(CategoriasVacantesPage.BTN_AGREGAR_CATEGORIA, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CategoriasVacantesPage.BTN_AGREGAR_CATEGORIA),

                // Esperar input del modal y escribir el nombre
                WaitUntil.the(CategoriasVacantesPage.INPUT_NOMBRE_AGREGAR, isVisible())
                        .forNoMoreThan(10).seconds(),
                Clear.field(CategoriasVacantesPage.INPUT_NOMBRE_AGREGAR),
                Enter.theValue(nombre).into(CategoriasVacantesPage.INPUT_NOMBRE_AGREGAR),

                // Guardar
                Click.on(CategoriasVacantesPage.BTN_CONFIRMAR_AGREGAR),

                // SweetAlert "Creada" (OK → luego el front hace window.location.reload())
                WaitUntil.the(CategoriasVacantesPage.BTN_ALERTA_OK, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CategoriasVacantesPage.BTN_ALERTA_OK)
        );
    }
}
