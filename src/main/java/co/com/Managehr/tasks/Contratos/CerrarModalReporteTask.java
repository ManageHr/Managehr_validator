package co.com.Managehr.tasks.Contratos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CerrarModalReporteTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(/* Target del botón cerrar */)
        );
    }

    public static CerrarModalReporteTask ahora() {
        return instrumented(CerrarModalReporteTask.class);
    }
}