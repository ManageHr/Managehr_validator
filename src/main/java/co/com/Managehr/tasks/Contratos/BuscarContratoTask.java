package co.com.Managehr.tasks.Contratos;

import co.com.Managehr.userinterface.Contratos.GestionContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarContratoTask implements Task {

    private String documento;

    public BuscarContratoTask(String documento) {
        this.documento = documento;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(GestionContratosPage.CAMPO_BUSQUEDA, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(documento).into(GestionContratosPage.CAMPO_BUSQUEDA)
        );

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static BuscarContratoTask conDocumento(String documento) {
        return new BuscarContratoTask(documento);
    }
}