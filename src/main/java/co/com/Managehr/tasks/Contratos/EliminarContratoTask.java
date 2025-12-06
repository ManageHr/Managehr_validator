package co.com.Managehr.tasks.Contratos;

import co.com.Managehr.userinterface.Contratos.ContratosPage;
import co.com.Managehr.userinterface.Contratos.GestionContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarContratoTask implements Task {


    @Override
    @Step("{0} elimina el contrato con documento #documento")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(GestionContratosPage.BOTON_SI_CONFIRMAR,isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(GestionContratosPage.BOTON_SI_CONFIRMAR,isClickable()).forNoMoreThan(5).seconds(),
                Click.on(GestionContratosPage.BOTON_SI_CONFIRMAR)
        );

    }

    public static EliminarContratoTask conDocumento() {
        return new EliminarContratoTask();
    }
}