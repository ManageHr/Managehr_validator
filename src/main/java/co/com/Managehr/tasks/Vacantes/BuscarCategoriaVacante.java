package co.com.Managehr.tasks.Vacantes;

import co.com.Managehr.userinterface.Vacantes.CategoriasVacantesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarCategoriaVacante implements Task {

    private final String nombre;

    public BuscarCategoriaVacante(String nombre) {
        this.nombre = nombre;
    }

    public static BuscarCategoriaVacante porNombre(String nombre) {
        return Tasks.instrumented(BuscarCategoriaVacante.class, nombre);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(CategoriasVacantesPage.INPUT_BUSCAR, isVisible())
                        .forNoMoreThan(15).seconds(),


                Click.on(CategoriasVacantesPage.INPUT_BUSCAR),


                Clear.field(CategoriasVacantesPage.INPUT_BUSCAR),
                Enter.theValue(nombre).into(CategoriasVacantesPage.INPUT_BUSCAR),


                WaitUntil.the(CategoriasVacantesPage.FILA_CATEGORIA.of(nombre), isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }
}
