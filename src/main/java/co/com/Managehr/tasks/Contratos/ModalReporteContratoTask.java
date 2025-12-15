package co.com.Managehr.tasks.Contratos;

import co.com.Managehr.userinterface.Contratos.GestionContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ModalReporteContratoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(GestionContratosPage.MODAL_REPORTE, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static ModalReporteContratoTask verificarModal() {
        return instrumented(ModalReporteContratoTask.class);
    }
}