package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.userinterface.Usuarios.GestionUsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConfirmarEliminacionTask implements Task {

    public static ConfirmarEliminacionTask enModal() {
        return instrumented(ConfirmarEliminacionTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("=== CONFIRMANDO ELIMINACIÓN ===");

        actor.attemptsTo(
                WaitUntil.the(GestionUsuariosPage.BTN_CONFIRMAR_ELIMINAR, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(GestionUsuariosPage.BTN_CONFIRMAR_ELIMINAR)

        );
    }
}