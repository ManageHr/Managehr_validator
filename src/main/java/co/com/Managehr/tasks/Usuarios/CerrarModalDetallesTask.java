package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.userinterface.Usuarios.GestionUsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CerrarModalDetallesTask implements Task {

    public static CerrarModalDetallesTask despuesDeVer() {
        return instrumented(CerrarModalDetallesTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("=== CERRANDO MODAL DETALLES ===");

        actor.attemptsTo(
                Click.on(GestionUsuariosPage.BTN_CERRAR_DETALLES),
                WaitUntil.the(GestionUsuariosPage.MODAL_DETALLES, isNotVisible()).forNoMoreThan(5).seconds()
        );
    }
}