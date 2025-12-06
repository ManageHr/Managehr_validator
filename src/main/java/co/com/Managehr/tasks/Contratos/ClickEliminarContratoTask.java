package co.com.Managehr.tasks.Contratos;
import co.com.Managehr.userinterface.Contratos.ContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class ClickEliminarContratoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ContratosPage.BOTON_ELIMINAR,isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(ContratosPage.BOTON_ELIMINAR,isClickable()).forNoMoreThan(5).seconds(),
                Click.on(ContratosPage.BOTON_ELIMINAR)
        );
    }
    public static ClickEliminarContratoTask inicioTo(){
        return instrumented(ClickEliminarContratoTask.class);
    }
}
