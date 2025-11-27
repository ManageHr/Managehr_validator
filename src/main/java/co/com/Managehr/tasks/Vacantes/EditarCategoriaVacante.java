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

public class EditarCategoriaVacante implements Task {

    private final CategoriaVacanteData data;

    public EditarCategoriaVacante(CategoriaVacanteData data) {
        this.data = data;
    }

    public static EditarCategoriaVacante conDatos(CategoriaVacanteData data) {
        return Tasks.instrumented(EditarCategoriaVacante.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String nombreActual = (data.getNombreActual() != null && !data.getNombreActual().isEmpty())
                ? data.getNombreActual()
                : data.getNombre();

        String nuevoNombre = (data.getNuevoNombre() != null && !data.getNuevoNombre().isEmpty())
                ? data.getNuevoNombre()
                : data.getNombre();

        actor.attemptsTo(

                Click.on(CategoriasVacantesPage.BTN_EDITAR.of(nombreActual)),

                WaitUntil.the(CategoriasVacantesPage.INPUT_NOMBRE_EDITAR, isVisible())
                        .forNoMoreThan(15).seconds(),
                Clear.field(CategoriasVacantesPage.INPUT_NOMBRE_EDITAR),
                Enter.theValue(nuevoNombre).into(CategoriasVacantesPage.INPUT_NOMBRE_EDITAR),


                Click.on(CategoriasVacantesPage.BTN_GUARDAR_CAMBIOS),


                WaitUntil.the(CategoriasVacantesPage.BTN_ALERTA_OK, isVisible())
                        .forNoMoreThan(15).seconds(),
                Click.on(CategoriasVacantesPage.BTN_ALERTA_OK)
        );
    }
}
