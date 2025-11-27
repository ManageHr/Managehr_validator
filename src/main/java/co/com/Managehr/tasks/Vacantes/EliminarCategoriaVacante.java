package co.com.Managehr.tasks.Vacantes;

import co.com.Managehr.userinterface.Vacantes.CategoriasVacantesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EliminarCategoriaVacante implements Task {

    private final String nombre;

    public EliminarCategoriaVacante(String nombre) {
        this.nombre = nombre;
    }

    public static EliminarCategoriaVacante porNombre(String nombre) {
        return Tasks.instrumented(EliminarCategoriaVacante.class, nombre);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(CategoriasVacantesPage.BTN_ELIMINAR.of(nombre)),


                WaitUntil.the(CategoriasVacantesPage.BTN_CONFIRMAR_ELIMINAR, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CategoriasVacantesPage.BTN_CONFIRMAR_ELIMINAR),


                WaitUntil.the(CategoriasVacantesPage.BTN_ALERTA_OK, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CategoriasVacantesPage.BTN_ALERTA_OK)
        );
    }
}
