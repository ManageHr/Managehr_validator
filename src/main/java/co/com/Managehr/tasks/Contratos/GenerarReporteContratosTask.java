package co.com.Managehr.tasks.Contratos;

import co.com.Managehr.userinterface.Contratos.GestionContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GenerarReporteContratosTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(GestionContratosPage.BOTON_REPORTES, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(GestionContratosPage.BOTON_REPORTES, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(GestionContratosPage.BOTON_REPORTES)
        );
    }

    public static GenerarReporteContratosTask ahora() {
        return instrumented(GenerarReporteContratosTask.class);
    }
}