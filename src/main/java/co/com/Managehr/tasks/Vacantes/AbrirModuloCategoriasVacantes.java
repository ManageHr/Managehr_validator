package co.com.Managehr.tasks.Vacantes;

import co.com.Managehr.userinterface.Vacantes.CategoriasVacantesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AbrirModuloCategoriasVacantes implements Task {

    public static AbrirModuloCategoriasVacantes ir() {
        return Tasks.instrumented(AbrirModuloCategoriasVacantes.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(CategoriasVacantesPage.BTN_VACANTES),

                WaitUntil.the(CategoriasVacantesPage.BTN_CATEGORIA, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CategoriasVacantesPage.BTN_CATEGORIA)
        );
    }
}
