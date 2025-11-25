package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.userinterface.Usuarios.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AbrirFormularioUsuario implements Task {

    public static AbrirFormularioUsuario ahora() {
        return instrumented(AbrirFormularioUsuario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Buscando botón 'Agregar usuario'...");
        actor.attemptsTo(
                WaitUntil.the(CrearUsuarioPage.BTN_AGREGAR_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(CrearUsuarioPage.BTN_AGREGAR_USUARIO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CrearUsuarioPage.BTN_AGREGAR_USUARIO)
        );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        actor.attemptsTo(
                WaitUntil.the(CrearUsuarioPage.FORMULARIO_MODAL, isVisible()).forNoMoreThan(10).seconds()
        );

    }
}