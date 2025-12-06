package co.com.Managehr.tasks.Contratos;

import co.com.Managehr.userinterface.Contratos.ContratosPage;
import co.com.Managehr.userinterface.Contratos.GestionContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class CerrarAlertaExitoEliminar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(GestionContratosPage.ALERTA_EXITO_CONTAINER, isVisible())
                        .forNoMoreThan(10).seconds(),
                WaitUntil.the(GestionContratosPage.BOTON_ACEPTAR_EXITO, isClickable())
                        .forNoMoreThan(5).seconds(),
                Click.on(GestionContratosPage.BOTON_ACEPTAR_EXITO),
                Enter.theValue("").into(GestionContratosPage.CAMPO_BUSQUEDA)
        );
    }

    public static CerrarAlertaExitoEliminar inicioTo() {
        return instrumented(CerrarAlertaExitoEliminar.class);
    }
}
