package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.userinterface.Usuarios.GestionUsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class VerDetallesUsuarioTask implements Task {

    public static VerDetallesUsuarioTask delPrimerRegistro() {
        return instrumented(VerDetallesUsuarioTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("=== VIENDO DETALLES DEL USUARIO ===");

        actor.attemptsTo(
                WaitUntil.the(GestionUsuariosPage.BTN_DETALLES, isVisible()).forNoMoreThan(8).seconds(),
                WaitUntil.the(GestionUsuariosPage.BTN_DETALLES, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(GestionUsuariosPage.BTN_DETALLES),
                WaitUntil.the(GestionUsuariosPage.MODAL_DETALLES, isVisible()).forNoMoreThan(5).seconds()
        );
    }
}