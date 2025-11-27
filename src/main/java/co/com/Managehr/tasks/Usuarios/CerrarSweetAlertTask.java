package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.userinterface.Usuarios.GestionUsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CerrarSweetAlertTask implements Task {

    public static CerrarSweetAlertTask deExito() {
        return instrumented(CerrarSweetAlertTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("=== CERRANDO SWEETALERT DE ÉXITO ===");
        actor.attemptsTo(
                WaitUntil.the(GestionUsuariosPage.SWEETALERT_EXITO, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(GestionUsuariosPage.BTN_CERRAR_SWEETALERT),
                WaitUntil.the(GestionUsuariosPage.SWEETALERT_EXITO, isNotVisible())
                        .forNoMoreThan(5).seconds()
        );
    }
}