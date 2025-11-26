package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.userinterface.Usuarios.GestionUsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class EliminarUsuarioTask implements Task {

    public static EliminarUsuarioTask delPrimerRegistro() {
        return instrumented(EliminarUsuarioTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("=== ELIMINANDO USUARIO ===");

        actor.attemptsTo(
                WaitUntil.the(GestionUsuariosPage.BTN_ELIMINAR, isVisible()).forNoMoreThan(8).seconds(),
                WaitUntil.the(GestionUsuariosPage.BTN_ELIMINAR, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(GestionUsuariosPage.BTN_ELIMINAR),
                WaitUntil.the(GestionUsuariosPage.MODAL_CONFIRMAR_ELIMINACION, isVisible()).forNoMoreThan(5).seconds()
        );
    }
}