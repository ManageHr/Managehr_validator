package co.com.Managehr.tasks.Contratos;

import co.com.Managehr.userinterface.Contratos.ContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class NavegarContratosTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ContratosPage.MENU_CONTRATOS, isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(ContratosPage.MENU_CONTRATOS, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(ContratosPage.MENU_CONTRATOS)
        );

    }

    public static NavegarContratosTask ahora() {
        return new NavegarContratosTask();
    }
}