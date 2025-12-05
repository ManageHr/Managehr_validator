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
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ContratosPage.MENU_CONTRATOS),
                WaitUntil.the(ContratosPage.MENU_CONTRATOS, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ContratosPage.MENU_CONTRATOS)
        );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static EliminarContratoTask navegar () {
        return new EliminarContratoTask();
    }
}