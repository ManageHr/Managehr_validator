package co.com.Managehr.tasks.Contratos;

import co.com.Managehr.userinterface.Contratos.GestionContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DescargarPDFContratosTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(GestionContratosPage.BTN_DESCARGAR_PDF, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(GestionContratosPage.BTN_DESCARGAR_PDF, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(GestionContratosPage.BTN_DESCARGAR_PDF)
        );
    }

    public static DescargarPDFContratosTask ahora() {
        return instrumented(DescargarPDFContratosTask.class);
    }
}